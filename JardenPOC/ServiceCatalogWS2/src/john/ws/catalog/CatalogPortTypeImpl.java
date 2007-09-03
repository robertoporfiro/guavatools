package john.ws.catalog;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.jws.WebService;

import com.zurich.ep.catalog.CatalogPortType;
import com.zurich.ep.catalog.NameValue;
import com.zurich.ep.catalog.NameValues;
import com.zurich.ep.catalog.PackageBean;
import com.zurich.ep.catalog.PackageBeans;
import com.zurich.ep.catalog.ServiceBean;
import com.zurich.ep.catalog.ServiceBeans;

import weblogic.jws.*;

/**
 * ServiceCatalogWSImpl class implements web service endpoint interface ServiceCatalogWS.
 */

@WebService(
	serviceName="CatalogService",
	targetNamespace="http://www.zurich.com/ep/catalog",
	endpointInterface="com.zurich.ep.catalog.CatalogPortType")
	@WLHttpTransport(/*contextPath="ServiceCatalogWS2",*/serviceUri="ServiceCatalogWSImpl",portName="ServiceCatalogWSSoapPort")
public class CatalogPortTypeImpl implements CatalogPortType {
	private static final String rootPackageName = "com.zurich.ep";
	private static final String rootDirectory = "C:/myeclipse/JohnOld/ModelServices/src/";
	private static final String wikiUrl = "http://10.239.252.46:8080/wiki/Wiki.jsp?page=ServiceWiki_";
	// private static final String svnModelRoot = "http://10.160.2.94:80/ModelServices/";
	private static final String localProxyEndpoint   = "http://10.160.2.94:7091/";
	//private static final String stabProxyEndpoint    = "http://10.88.7.183:7201/";
	//private static final String stabNATProxyEndpoint = "http://10.239.252.45:7201/";
	private static final String autoProxyEndpoint    = "http://10.88.7.183:8201/";
	private static final String autoNATProxyEndpoint = "http://10.239.252.45:8201/";
	private static final String svnBuildArtifactsRoot = "http://10.239.252.46:8081/svn/ep/build/artifacts/";

	private HashMap<String, ServiceBean> serviceMap;
	private HashMap<String, PackageBean> packageMap;
	private HashMap<String, PackageBeans> memberPackageMap; // subpackages in package
	private HashMap<String, ServiceBeans> memberServiceMap; // services in package
	private PackageBean rootPackage;
	private Properties proxyNameProperties;
	private Properties svnWsdlNameProperties;

	// these 2 objects are used during reload of catalog:
	private HashMap<String, ArrayList<PackageBean>> tempMemberPackageMap; // subpackages in package
	private HashMap<String, ArrayList<ServiceBean>> tempMemberServiceMap; // services in package

	public String reloadCatalog() {
		serviceMap = new HashMap<String, ServiceBean>();
		packageMap = new HashMap<String, PackageBean>();
		memberPackageMap = new HashMap<String, PackageBeans>();
		memberServiceMap = new HashMap<String, ServiceBeans>();
		tempMemberPackageMap = new HashMap<String, ArrayList<PackageBean>>(); 
		tempMemberServiceMap = new HashMap<String, ArrayList<ServiceBean>>(); 
		rootPackage = new PackageBean();
		rootPackage.setName(rootPackageName);
		rootPackage.setLastBit(rootPackageName);
		proxyNameProperties = new Properties();
		svnWsdlNameProperties = new Properties();
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream is;
		try {
			is = classLoader.getResourceAsStream("proxyName.properties");
			proxyNameProperties.load(is);
			is.close();
			is = classLoader.getResourceAsStream("svnWsdlName.properties");
			svnWsdlNameProperties.load(is);
			is.close();
		} catch (IOException e) {
			throw new RuntimeException("exception thrown loading property files", e);
		}
		processPackage(rootPackage);
		// now convert tempMemberMaps to real ones
		for (String packageName: tempMemberPackageMap.keySet()) {
			ArrayList<PackageBean> memberPackages = tempMemberPackageMap.get(packageName);
			PackageBean[] packageBeanArray = memberPackages.toArray(new PackageBean[0]);
			PackageBeans packageBeans = new PackageBeans();
			packageBeans.setPackageBean(packageBeanArray);
			memberPackageMap.put(packageName, packageBeans);
		}
		for (String packageName: tempMemberServiceMap.keySet()) {
			ArrayList<ServiceBean> memberServices = tempMemberServiceMap.get(packageName);
			ServiceBean[] serviceBeanArray = memberServices.toArray(new ServiceBean[0]);
			ServiceBeans serviceBeans = new ServiceBeans();
			serviceBeans.setServiceBean(serviceBeanArray);
			memberServiceMap.put(packageName, serviceBeans);
		}
		return rootPackageName;
	}

	public PackageBeans getPackageHierarchy(String packageName) {
		packageName = getPackageName(packageName);
		ArrayList<PackageBean> packageHierarchy = new ArrayList<PackageBean>();
		PackageBean packageBean = packageMap.get(packageName);
		while (packageBean != null) {
			packageHierarchy.add(0, packageBean);
			int lastDotIndex = packageName.lastIndexOf('.');
			packageName = packageName.substring(0, lastDotIndex);
			packageBean = packageMap.get(packageName);
		}
		PackageBean[] packageBeanArray = packageHierarchy.toArray(new PackageBean[0]); 
		PackageBeans packageBeans = new PackageBeans();
		packageBeans.setPackageBean(packageBeanArray);
		return packageBeans;
	}

	public PackageBeans getMemberPackages(String packageName) {
		return memberPackageMap.get(packageName);
	}

	
	public ServiceBean getService(String serviceName) {
		return serviceMap.get(serviceName);
	}

	public ServiceBeans getMemberServices(String packageName) {
		return memberServiceMap.get(packageName);
	}

	private void processPackage(PackageBean packageBean) {
		String packageName = packageBean.getName();
		packageMap.put(packageName, packageBean);
		tempMemberPackageMap.put(packageName, new ArrayList<PackageBean>());
		tempMemberServiceMap.put(packageName, new ArrayList<ServiceBean>());
		String packagePath = packageToPath(packageName);
		File file = new File(rootDirectory + packagePath);
		if (!file.canRead()) {
			throw new IllegalStateException(rootDirectory + packagePath + " cannot be read");
		}
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				PackageBean memberPackage = new PackageBean();
				String fileName = fileList[i].getName();
				memberPackage.setName(packageName + "." + fileName);
				int lastDotIndex = fileName.lastIndexOf('.');
				memberPackage.setLastBit(fileName.substring(lastDotIndex + 1));
				tempMemberPackageMap.get(packageName).add(memberPackage);
				processPackage(memberPackage);
			}
			else if (fileList[i].isFile()) {
				String fileName = fileList[i].getName(); 
				if (fileName.endsWith(".java")) {
					int nameLength = fileName.length() - 5;
					String className = fileName.substring(0, nameLength);
					if (className.endsWith("Model")) {
						className = className.substring(0, (className.length() - 5));
					}
					ServiceBean serviceBean = createServiceBean(className, packageName);
					serviceBean.setPackageName(packageName);
					serviceMap.put(serviceBean.getServiceName(), serviceBean);
					tempMemberServiceMap.get(packageName).add(serviceBean);
				}
			}
			else {
				throw new IllegalStateException(fileList[i] + " is neither directory nor file");
			}
		}
	}
	private ServiceBean createServiceBean(String className, String packageName) {
		String serviceName = getServiceName(className);
		String stream = getStream(packageName);
		String svnWsdlName = getSvnWsdlName(serviceName, stream);
		String proxyName = getProxyName(serviceName);
		ArrayList<NameValue> endpointList = new ArrayList<NameValue>();
		NameValue endpoint;
		
		endpoint = new NameValue();
		endpoint.setName("properties EndpointName");
		endpoint.setValue(stream + ".ws." + serviceName + ".EndpointAddress");
		endpoint.setHyperlink(false);
		endpointList.add(endpoint);

		endpoint = new NameValue();
		endpoint.setName("WSDL (on svn)");
		endpoint.setValue(svnBuildArtifactsRoot + svnWsdlName + ".wsdl");
		endpoint.setHyperlink(true);
		endpointList.add(endpoint);

		endpoint = new NameValue();
		endpoint.setName("local ProxyEndpoint");
		endpoint.setValue(localProxyEndpoint + proxyName);
		endpoint.setHyperlink(false);
		endpointList.add(endpoint);

		endpoint = new NameValue();
		endpoint.setName("auto ProxyEndpoint");
		endpoint.setValue(autoProxyEndpoint + proxyName);
		endpoint.setHyperlink(false);
		endpointList.add(endpoint);

		endpoint = new NameValue();
		endpoint.setName("auto NATProxyEndpoint");
		endpoint.setValue(autoNATProxyEndpoint + proxyName);
		endpoint.setHyperlink(false);
		endpointList.add(endpoint);

		endpoint = new NameValue();
		endpoint.setName("JspWiki page");
		endpoint.setValue(wikiUrl + serviceName);
		endpoint.setHyperlink(true);
		endpointList.add(endpoint);

		/*
		endpoint = new NameValue();
		endpoint.setName("Model WSDL");
		endpoint.setValue(svnModelRoot + className + "?wsdl");
		endpoint.setHyperlink(false);
		endpointList.add(endpoint);
		*/
		
		ServiceBean serviceBean = new ServiceBean();
		serviceBean.setServiceName(serviceName);
		serviceBean.setStream(stream);
		serviceBean.setPackageName(packageName);
		NameValues nameValues = new NameValues();
		nameValues.setNameValue(endpointList.toArray(new NameValue[0]));
		serviceBean.setEndpoints(nameValues);
		return serviceBean;
	}

	// get last part of packageName, i.e. part after last '.'
	private static String getStream(String packageName) {
		if (!packageName.startsWith(rootPackageName)) {
			throw new IllegalStateException("package name " + packageName +
					" does not start with " + rootPackageName);
		}
		String stream = packageName.substring(rootPackageName.length() + 1);
		int firstDot = stream.indexOf('.');
		if (firstDot >= 0) {
			stream = stream.substring(0, firstDot);
		}
		return stream;
	}

	private String getProxyName(String serviceName) {
		String proxyName = proxyNameProperties.getProperty(serviceName);
		if (proxyName != null) return proxyName;
		return serviceName;
	}

	private String getServiceName(String className) {
		String suffix = "Model";
		String serviceName = className;
		if (!serviceName.endsWith(suffix)) return serviceName;
		return serviceName.substring(0, (serviceName.length() - suffix.length())); 
	}

	private String getSvnWsdlName(String serviceName, String stream) {
		String svnWsdlName = svnWsdlNameProperties.getProperty(serviceName);
		if (svnWsdlName != null) return svnWsdlName;
		svnWsdlName = serviceName;
		if (stream.equals("apply")) {
			svnWsdlName += "Service";
		}
		return svnWsdlName;
	}
	private static String getPackageName(String packageName) {
		if (packageName != null && packageName.trim().length() > 0) return packageName;
		return rootPackageName;
	}
	
	private static String packageToPath(String packageName) {
		StringBuffer buffer = new StringBuffer(packageName);
		for (int i = 0; i < packageName.length(); i++) {
			if (buffer.charAt(i) == '.') buffer.setCharAt(i, '/');
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		CatalogPortTypeImpl catalog = new CatalogPortTypeImpl();
		catalog.reloadCatalog();
		String packageName = rootPackageName + ".apply";
		PackageBean[] memberPackages = catalog.getMemberPackages(packageName).getPackageBean();
		for (PackageBean packageBean: memberPackages) {
			System.out.println(packageBean.getName() + ", " + packageBean.getLastBit());
		}
		ServiceBean[] memberServices = catalog.getMemberServices(packageName).getServiceBean();
		for (ServiceBean serviceBean: memberServices) {
			System.out.println(serviceBean.getServiceName() + ", " + serviceBean.getPackageName() +
					", " + serviceBean.getStream());
			for (NameValue endpoint: serviceBean.getEndpoints().getNameValue()) {
				System.out.println("  " + endpoint.getName() + ", " + endpoint.getValue() +
						", " + endpoint.getHyperlink());
			}
		}
		
	}
}  