package john.ws.jms;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 12:21:25 BST 2007]
 */

public interface LogMessageJmsPersistWSPortType extends java.rmi.Remote {

  /**
   * Web Method: secureLogMessage ...
   */
  void secureLogMessage(java.lang.String message)
      throws java.rmi.RemoteException;
  /**
   * Web Method: logMessage ...
   */
  void logMessage(java.lang.String message)
      throws java.rmi.RemoteException;
}
