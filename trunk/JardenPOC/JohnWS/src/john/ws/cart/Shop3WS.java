package john.ws.cart;

import java.io.Serializable;
import java.util.Iterator;

import javax.jws.*;
import javax.xml.rpc.handler.MessageContext;

import john.db.ProductVO;


import weblogic.jws.Context;
import weblogic.wsee.jws.JwsContext;
import org.apache.beehive.controls.api.bean.Control;
/**
 * Non-conversational version of ShopWS. The client name is passed to each method.
 * There is a slight problem: it doesn't work! Each time an operation is invoked,
 * we get a different instance of Show3WS, and a different instance of JwsContext,
 * which surprises us! Hence we never get back to the shopping cart created in a
 * previous operation.
 */
@WebService
public class Shop3WS implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String myShopAccountName = "john";
	@Control
	private ProductWSServiceControl productWSServiceControl;
	@Control
	private BankWSServiceControl bankWSServiceControl;
	@Context
	private JwsContext jwsContext;

	public void newCart(String client) {
		Invoice invoice = new Invoice();
		invoice.setClient(client);
		jwsContext.getMessageContext().setProperty(client, invoice);
		invoice = getInvoice(client); // this line for testing only
		System.out.println("jwsContext=" + jwsContext + "; invoice client=" + invoice.getClient());
	}
	public ProductVO[] getAllProducts() {
		return productWSServiceControl.getAllProducts();
	}
	public void addItem(String client, String supplier, String code, int qty) {
		Invoice invoice = getInvoice(client);
		System.out.println("jwsContext=" + jwsContext + "; invoice client=" + invoice.getClient());
		ProductVO product = productWSServiceControl.getProduct(supplier, code);
		double price = product.getPrice() * qty;
		CartItem item = new CartItem(supplier, code, product.getName(), qty, price);
		invoice.addItem(item);
	}
	public Invoice placeOrder(String client, String accountName, String accountPassword) {
		Invoice invoice = getInvoice(client);
		invoice.setAccountName(accountName);
		bankWSServiceControl.transfer(accountName, accountPassword, myShopAccountName,
				invoice.getTotalPrice());
		jwsContext.getMessageContext().removeProperty(client);
		return invoice;
	}
	public Invoice getInvoice(String client) {
		MessageContext messageContext = jwsContext.getMessageContext();
		Invoice invoice = (Invoice)messageContext.getProperty(client);
		if (invoice == null) {
			System.out.println("this=" + this + "; messageContext=" + messageContext);
			System.out.println("property names in messageContext:");
			Iterator iterator = messageContext.getPropertyNames();
			while (iterator.hasNext()) {
				System.out.println("  " + iterator.next());
			}
			throw new IllegalStateException("no shopping cart active for client " + client);
		}
		return invoice;
	}
}