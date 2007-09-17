package joe.ws.cart;

/**
 * Generated interface, please do not edit.
 * Date: [Wed Sep 12 13:19:08 BST 2007]
 */

public interface JoeShopWSPortType extends java.rmi.Remote {

  /**
   * Web Method: confirmOrder ...
   */
  joe.ws.cart.Invoice confirmOrder()
      throws java.rmi.RemoteException, john.ws.bank.BankException;
  /**
   * Web Method: getAllProducts ...
   */
  john.db.ProductVO[] getAllProducts()
      throws java.rmi.RemoteException;
  /**
   * Web Method: newCart ...
   */
  void newCart(java.lang.String client)
      throws java.rmi.RemoteException;
  /**
   * Web Method: addItem ...
   */
  void addItem(java.lang.String supplier,java.lang.String code,int qty)
      throws java.rmi.RemoteException;
  /**
   * Web Method: setAccount ...
   */
  boolean setAccount(java.lang.String accountName,java.lang.String accountPassword)
      throws java.rmi.RemoteException;
  /**
   * Web Method: cancelOrder ...
   */
  java.lang.String cancelOrder()
      throws java.rmi.RemoteException;
  /**
   * Web Method: getCart ...
   */
  joe.ws.cart.Invoice getCart()
      throws java.rmi.RemoteException;
  /**
   * Web Method: getClient ...
   */
  java.lang.String getClient()
      throws java.rmi.RemoteException;
}
