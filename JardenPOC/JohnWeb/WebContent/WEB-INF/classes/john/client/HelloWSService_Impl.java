package john.client;

/**
 * Generated class, do not edit.
 *
 * This service class was generated by weblogic
 * webservice stub gen on Tue Aug 14 16:21:21 BST 2007 */

public class HelloWSService_Impl     extends weblogic.wsee.jaxrpc.ServiceImpl
     implements john.client.HelloWSService {

  public HelloWSService_Impl() throws javax.xml.rpc.ServiceException {
    this("john/client/HelloWSService_saved_wsdl.wsdl", null);
  }
  
  public HelloWSService_Impl(String wsdlurl) throws javax.xml.rpc.ServiceException {
    this(wsdlurl, null);
  }
  
  public HelloWSService_Impl(String wsdlurl, weblogic.wsee.connection.transport.TransportInfo transportInfo) throws javax.xml.rpc.ServiceException {
    super(wsdlurl,
          new javax.xml.namespace.QName("http://john/ws", "HelloWSService"),
          "john/client/HelloWSService_internaldd.xml", transportInfo);
  }
  
  //***********************************
  // Port Name: HelloWSSoapPort 
  // Port Type: HelloWS 
  //***********************************

  john.client.HelloWS mvar_HelloWSSoapPort;

  /**
   * returns HelloWSSoapPort port in this service 
   */
  public john.client.HelloWS getHelloWSSoapPort() 
    throws javax.xml.rpc.ServiceException
  {

    if (mvar_HelloWSSoapPort == null) {
      mvar_HelloWSSoapPort =
        new john.client.HelloWS_Stub(_getPort("HelloWSSoapPort"), this);
    }

    if (transportInfo != null && 
        transportInfo instanceof weblogic.wsee.connection.transport.http.HttpTransportInfo) {
      ((javax.xml.rpc.Stub)mvar_HelloWSSoapPort)._setProperty(
        "weblogic.wsee.connection.transportinfo", 
        (weblogic.wsee.connection.transport.http.HttpTransportInfo)transportInfo);
    }
    
    return mvar_HelloWSSoapPort;
  }

  /**
   * @deprecated  Use getHelloWSSoapPort(byte[] username, byte[] password)
   */
  public john.client.HelloWS getHelloWSSoapPort(String username, String password) 
    throws javax.xml.rpc.ServiceException
  {
    if (username != null & password != null) {
      weblogic.wsee.connection.transport.http.HttpTransportInfo httpInfo = 
        new weblogic.wsee.connection.transport.http.HttpTransportInfo();
      httpInfo.setUsername(username.getBytes());
      httpInfo.setPassword(password.getBytes());
      transportInfo = httpInfo;
    }
    return getHelloWSSoapPort();
  }

  public john.client.HelloWS getHelloWSSoapPort(byte[] username, byte[] password) 
    throws javax.xml.rpc.ServiceException
  {
    if (username != null & password != null) {
      weblogic.wsee.connection.transport.http.HttpTransportInfo httpInfo = 
        new weblogic.wsee.connection.transport.http.HttpTransportInfo();
      httpInfo.setUsername(username);
      httpInfo.setPassword(password);
      transportInfo = httpInfo;
    }
    return getHelloWSSoapPort();
  }
  
  
}