package john.ws.reliable;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 12:21:25 BST 2007]
 */

public interface BankWSPortType extends java.rmi.Remote {

  /**
   * Web Method: debit ...
   */
  void debit(java.lang.String account,double amount)
      throws java.rmi.RemoteException;
}
