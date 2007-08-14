package john.ws;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 12:21:24 BST 2007]
 */

public interface HelloWSPortType extends java.rmi.Remote {

  /**
   * Web Method: logMessage ...
   */
  java.lang.String logMessage(java.lang.String message)
      throws java.rmi.RemoteException;
  /**
   * Web Method: samlHello ...
   */
  java.lang.String samlHello(java.lang.String name)
      throws java.rmi.RemoteException;
  /**
   * Web Method: hello ...
   */
  java.lang.String hello(java.lang.String name)
      throws java.rmi.RemoteException;
  /**
   * Web Method: longHello ...
   */
  java.lang.String longHello(java.lang.String name,int delay)
      throws java.rmi.RemoteException;
}
