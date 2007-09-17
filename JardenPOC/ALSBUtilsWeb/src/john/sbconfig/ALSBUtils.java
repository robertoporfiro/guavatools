package john.sbconfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

import weblogic.management.jmx.MBeanServerInvocationHandler;
import weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean;

import com.bea.wli.config.Ref;
import com.bea.wli.config.env.EnvValueQuery;
import com.bea.wli.config.env.QualifiedEnvValue;
import com.bea.wli.sb.management.configuration.ALSBConfigurationMBean;
import com.bea.wli.sb.util.EnvValueTypes;
import com.bea.wli.sb.util.Refs;

public class ALSBUtils {
	private static final WLSConnection[] wlsConnections = {
		new WLSConnection("auto", "10.88.7.183", "10.239.252.45", 7201, "johndenny", null),
		new WLSConnection("john", "10.160.2.94",                  7091, "weblogic", null),
		new WLSConnection("stab", "10.88.7.183", "10.239.252.45", 7201, "weblogic", "servicebus"),
		new WLSConnection("syst", "10.88.67.70", "10.239.252.48", 7201, "weblogic", null),
		new WLSConnection("uat",  "10.88.67.70", "10.239.252.48", 9101, "weblogic", null)
	};
	private static final String[] resourceTypes = {
		Refs.BUSINESS_SERVICE_TYPE,
		Refs.PROXY_SERVICE_TYPE
	};
	private static HashMap<String, WLSConnection> wlsConnectionMap;
	private static String[] alsbNames;
	
	static {
		wlsConnectionMap = new HashMap<String, WLSConnection>();
		alsbNames = new String[wlsConnections.length];
		for (int i = 0; i < wlsConnections.length; i++) {
			WLSConnection con = wlsConnections[i];
			wlsConnectionMap.put(con.getName(), con);
			alsbNames[i] = con.getName();
		}
	}
	
	public static String[] getAlsbNames() {
		return alsbNames;
	}
	public static String[] getResourceTypes() {
		return resourceTypes;
	}
	public static void main(String[] args) throws Exception {
		getService("john", null);
		EsbQueryResult[] results = getESBConfig("john", null);
		for (EsbQueryResult result: results) {
			System.out.println(result.getName() + "\t" + result.getValue());
		}
		// getHierarchy("john", null);
	}
	private static JMXConnector initConnection(String name) throws Exception {
		if (name == null || name.trim().length() == 0) name = "john";
		WLSConnection wlsConn = wlsConnectionMap.get(name);
		System.out.println("Connecting to ALSB at t3://" + wlsConn.getNatHost() + ":" + wlsConn.getPort());
		JMXServiceURL serviceURL = new JMXServiceURL("t3", wlsConn.getNatHost(), wlsConn.getPort(),
				"/jndi/" + DomainRuntimeServiceMBean.MBEANSERVER_JNDI_NAME);
		Hashtable<String, String> h = new Hashtable<String, String>();
		String username = wlsConn.getUsername();
		String password = wlsConn.getPassword();
		h.put(Context.SECURITY_PRINCIPAL, username);
		if (password == null) password = username;
		h.put(Context.SECURITY_CREDENTIALS, password);
		h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
				"weblogic.management.remote");
		return JMXConnectorFactory.connect(serviceURL, h);
	}
	private static ALSBConfigurationMBean getALSBConfigurationMBean(String name) throws Exception {
		JMXConnector conn = initConnection(name);
		MBeanServerConnection mbconn = conn.getMBeanServerConnection();
		// get domain service mbean. This is the topmost mbean
		DomainRuntimeServiceMBean domainService =
			(DomainRuntimeServiceMBean) MBeanServerInvocationHandler.newProxyInstance(
					mbconn, new ObjectName(DomainRuntimeServiceMBean.OBJECT_NAME));
		return (ALSBConfigurationMBean) domainService.findService(
					ALSBConfigurationMBean.NAME,
					ALSBConfigurationMBean.TYPE, null);
	}
	/**
	 * Get configuration details from ALSB running at specified location.
	 * @param username if null, uses default
	 * @param password if null, uses default
	 * @param type for now, ignored, and finds endpoints
	 * @throws Exception 
	 */
	public static EsbQueryResult[] getESBConfig(String name, String resourceType) throws Exception {
		ALSBConfigurationMBean alsbCore = getALSBConfigurationMBean(name);
		Set<String> resourceSet = null;
		if (resourceType != null) resourceSet = Collections.singleton(resourceType);
	
		EnvValueQuery evquery = new EnvValueQuery(
				resourceSet, // null means all resource types
				Collections.singleton(EnvValueTypes.SERVICE_URI), // envValueTypes (i.e. search URIs)
				null, // refsToSearch
				false, // includeOnlyModifiedResources
				null, // searchString
				false // isCompleteMatch
			);
		Collection<QualifiedEnvValue> results = alsbCore.findEnvValues(evquery);
		EsbQueryResult[] esbQueryResults = new EsbQueryResult[results.size()];
		Iterator<QualifiedEnvValue> qevIt = results.iterator();
		for (int i = 0; qevIt.hasNext(); i++) {
			QualifiedEnvValue qev = qevIt.next();
			esbQueryResults[i] = new EsbQueryResult();
			esbQueryResults[i].setName(qev.getOwner().getFullName());
			esbQueryResults[i].setValue(qev.getValue().toString());
		}
		return esbQueryResults;
	}
	public static EsbQueryResult[] getInvalidESBConfig(String name, String resourceType) throws Exception {
		// System.out.println("getInvalidESBConfig('" + name + "', '" + resourceType + "')");
		String targetHost = wlsConnectionMap.get(name).getHost();
		EsbQueryResult[] esbQueryResults = getESBConfig(name, resourceType);
		ArrayList<EsbQueryResult> resultList = new ArrayList<EsbQueryResult>();
		for (EsbQueryResult result: esbQueryResults) {
			String endpoint = result.getValue();
			if (endpoint.startsWith("ejb:")) continue;
			try {
				URL url = new URL(result.getValue());
				String host = url.getHost();
				// System.out.println("host=" + host + "; targetHost=" + targetHost);
				if (!host.equals(targetHost)) {
					resultList.add(result);
				}
			} catch (MalformedURLException e) {
				resultList.add(result);
				System.out.println(result.getName() + ", " + result.getValue() + ", " + e.toString());
			}
		}
		return resultList.toArray(new EsbQueryResult[0]);
		
	}
	public static void getService(String alsbName, String type) throws Exception {
		ALSBConfigurationMBean alsbCore = getALSBConfigurationMBean(alsbName);
		Ref serviceRef = new Ref("ProxyService", new String[] {
				"Apply", "proxyServices", "PostCodeLookupProxy"});
		EnvValueQuery evquery = new EnvValueQuery(
				null, // resourceTypes, // null means all resource types
				Collections.singleton(EnvValueTypes.SERVICE_URI), // envValueTypes (i.e. search URIs)
				Collections.singleton(serviceRef), // refsToSearch
				false, // includeOnlyModifiedResources
				null, // searchString
				false // isCompleteMatch
			);
		Collection<QualifiedEnvValue> results = alsbCore.findEnvValues(evquery);
		for (QualifiedEnvValue qev: results) {
			 System.out.println(qev.getOwner().getFullName() + ", " + qev.getValue());
		}
	}
	public static EsbQueryResult[] getHierarchy(String alsbName, String type) throws Exception {
		ALSBConfigurationMBean alsbCore = getALSBConfigurationMBean(alsbName);
		Set<Ref> refs = alsbCore.getRefs(Ref.DOMAIN);
		HashMap<String, ArrayList<String>> projects = new HashMap<String, ArrayList<String>>(); 
		for (Ref ref: refs) {
			if (ref.getTypeId().equals("Project")) {
				String projectName = ref.getFullName();
				if (projects.get(projectName) == null) { // project resource may appear before project
					projects.put(projectName, new ArrayList<String>());
				}
			}
			else if (ref.getTypeId().equals("Folder")) {
				String projectName = ref.getProjectName();
				ArrayList<String> folders = projects.get(projectName);
				if (folders == null) {
					folders = new ArrayList<String>();
					projects.put(projectName, folders);
				}
				folders.add(ref.getFullName());
			}
			else {
				System.out.println(ref.getFullName() + ", " + ref.getTypeId());
				for (String name: ref.getNames()) {
					System.out.println("  name=" + name);
				}
			}
		}
		/*
		Iterator iterator = projects.keySet().iterator();
		while (iterator.hasNext()) {
			String projectName = (String)iterator.next();
			System.out.println("Project: " + projectName);
			ArrayList<String> folders = projects.get(projectName);
			for (String folder: folders) {
				System.out.println("   " + folder);
			}
		}
		*/
		/*
		Set<Ref> refs = null;
		if (type.equals(PROXY) || type.equals(SERVICE)) {
			ServiceQuery serviceQuery;
			if (type.equals(PROXY)) {
				serviceQuery = new ProxyServiceQuery();
			}
			else {
				serviceQuery = new BusinessServiceQuery();
			}
			refs = alsbCore.getRefs(serviceQuery);
		}
		EnvValueQuery evquery = new EnvValueQuery(null, // search across all resource types
				Collections.singleton(EnvValueTypes.SERVICE_URI), // envValueTypes (i.e. search URIs)
				refs, // refsToSearch
				false, // includeOnlyModifiedResources
				null, // searchString
				false // isCompleteMatch
			);
		Collection<QualifiedEnvValue> results = alsbCore.findEnvValues(evquery);
		EsbQueryResult[] esbQueryResults = new EsbQueryResult[results.size()];
		Iterator<QualifiedEnvValue> qevIt = results.iterator();
		for (int i = 0; qevIt.hasNext(); i++) {
			QualifiedEnvValue qev = qevIt.next();
			esbQueryResults[i] = new EsbQueryResult();
			esbQueryResults[i].setName(qev.getOwner().getFullName());
			esbQueryResults[i].setValue(qev.getValue().toString());
		}
		return esbQueryResults;
		*/
		return null;
	}

}
