package john.ws.cart;

/**
 * Generated interface, please do not edit.
 * Date: [Tue Aug 14 12:21:25 BST 2007]
 */

public interface ShopWSPortType extends java.rmi.Remote {

  /**
   * Web Method: newCart ...
   */
  void newCart(java.lang.String client)
      throws java.rmi.RemoteException;
  /**
   * Web Method: placeOrder ...
   */
  john.ws.cart.Invoice placeOrder(java.lang.String creditCardNumber)
      throws java.rmi.RemoteException;
  /**
   * Web Method: addItem ...
   */
  void addItem(john.ws.cart.CartItem item)
      throws java.rmi.RemoteException;
  /**
   * Web Method: getCart ...
   */
  john.ws.cart.CartItem[] getCart()
      throws java.rmi.RemoteException;
  /**
   * Web Method: getClient ...
   */
  java.lang.String getClient()
      throws java.rmi.RemoteException;
}
