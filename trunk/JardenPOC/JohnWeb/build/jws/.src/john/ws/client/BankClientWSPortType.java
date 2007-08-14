package john.ws.client;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 14:49:40 BST 2007]
 */

public interface BankClientWSPortType extends java.rmi.Remote {

  /**
   * Web Method: debit ...
   */
  void debit(java.lang.String account,double amount)
      throws java.rmi.RemoteException;
  /**
   * Web Method: delayedHello ...
   */
  void delayedHello(java.lang.String name,int delay)
      throws java.rmi.RemoteException;
}
