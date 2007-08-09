package com.zurich.ep.protection.alsb.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

import weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean;

import com.bea.wli.config.Ref;
import com.bea.wli.config.env.EnvValueQuery;
import com.bea.wli.sb.management.configuration.ALSBConfigurationMBean;
import com.bea.wli.sb.management.configuration.SessionManagementMBean;
import com.bea.wli.sb.management.query.BusinessServiceQuery;
import com.bea.wli.sb.util.EnvValueTypes;


public class ALSBConfigAutomator {
    private String sessionName;
    private String hostName;
    private int port;
    private String userName;
    private byte[] password;
    SessionManagementMBean sm;

    public static void main(String[] args) throws Exception{
        
        ALSBConfigAutomator automator = new ALSBConfigAutomator("peet01","localhost",7021,"weblogic","weblogic".getBytes());
        ALSBConfigurationMBean alsbSession=null;
        alsbSession = automator.getALSBConfigurationMBean();
        
        BusinessServiceQuery query = new BusinessServiceQuery();
        //query.setPath("protectionPlus/dmc/quote/Business Services");
        query.setLocalName("ProtectionPlusQuoteOrchestrationService");
        Set<Ref> refs = alsbSession.getRefs(query);
        System.out.println("Resources that satisfy the search criteria are:");
        for (Ref ref : refs) {
            System.out.println(ref);
            
        }
        
       automator.discardSession();
        
        
    }

    public ALSBConfigurationMBean getALSBConfigurationMBean() throws Exception{
        
        // get the jmx connector
        JMXConnector conn = initConnection();
        // get mbean connection 
        MBeanServerConnection mbconn = conn.getMBeanServerConnection();
        
        sm = (SessionManagementMBean)MBeanServerInvocationHandler.
        newProxyInstance(mbconn, new ObjectName("com.bea:Name=SessionManagement,Type=com.bea.wli.sb.management.configuration.SessionManagementMBean"),SessionManagementMBean.class,false);
        sm.createSession(this.sessionName);
        
        
        if(! sm.sessionExists(this.sessionName)){
            sm.createSession(this.sessionName);    
        }
        
        ALSBConfigurationMBean alsbSession = (ALSBConfigurationMBean) MBeanServerInvocationHandler.
        newProxyInstance(mbconn, new ObjectName("com.bea:Name=ALSBConfiguration,Type=com.bea.wli.sb.management.configuration.ALSBConfigurationMBean"),ALSBConfigurationMBean.class,false);
        return alsbSession;
        
    }
    
    public void discardSession() throws Exception{
        if(this.sessionName ==null || ! sm.sessionExists(this.sessionName)){
            return; //ignore
        }
        sm.discardSession(this.sessionName);
    }
    
    public void activateSession(String description) throws Exception {
        if(this.sessionName ==null || ! sm.sessionExists(this.sessionName)){
            return; //ignore
        }
        sm.activateSession(this.sessionName,description);
    }

    
    private JMXConnector initConnection() throws IOException, MalformedURLException {
        JMXServiceURL serviceURL = new JMXServiceURL("t3", this.hostName, this.port, "/jndi/" + DomainRuntimeServiceMBean.MBEANSERVER_JNDI_NAME);
        Hashtable<String, String> h = new Hashtable<String, String>();
        h.put(Context.SECURITY_PRINCIPAL, this.userName);
        h.put(Context.SECURITY_CREDENTIALS, new String(this.password));
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
        return JMXConnectorFactory.connect(serviceURL, h);
    }

    public ALSBConfigAutomator(String sessionName, String hostName, int port, String userName, byte[] password) {
        this.sessionName = sessionName;
        this.hostName = hostName;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    @Override
    protected void finalize() throws Throwable {
        discardSession();
    }
    
    
    private EnvValueQuery getBusinessServices(String path, String name){
        BusinessServiceQuery query = new BusinessServiceQuery();
        query.setPath(path);
        query.setLocalName(name);
        
        EnvValueQuery evquery =  new EnvValueQuery(
                        null,        // search across all resource types
                        Collections.singleton(EnvValueTypes.SERVICE_URI), // search only the URIs
                        null,        // search across all projects and folders.
                        true,        // only search across resources that are
                                     // actually modified/imported in this session
                        "localhost", // the string we want to replace
                        false        // not a complete match of URI. any URI
                                     // that has "localhost" as substring will match
                        );
        
        return evquery;
    }
}
