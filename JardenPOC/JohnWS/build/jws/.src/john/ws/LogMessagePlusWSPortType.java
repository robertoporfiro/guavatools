package john.ws;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 12:21:25 BST 2007]
 */

public interface LogMessagePlusWSPortType extends java.rmi.Remote {

  /**
   * Web Method: deleteMessage ...
   */
  int deleteMessage(int ident)
      throws java.rmi.RemoteException;
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
  /**
   * Web Method: getMessage ...
   */
  john.db.JohnLogVO getMessage(int ident)
      throws java.rmi.RemoteException;
  /**
   * Web Method: deleteAllMessages ...
   */
  int deleteAllMessages()
      throws java.rmi.RemoteException;
  /**
   * Web Method: getAllMessages ...
   */
  john.db.JohnLogVO[] getAllMessages()
      throws java.rmi.RemoteException;
}
