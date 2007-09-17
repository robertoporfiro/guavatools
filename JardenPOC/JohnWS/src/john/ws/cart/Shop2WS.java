package john.ws.cart;

import java.io.Serializable;
import java.util.HashMap;

import javax.jws.*;

import john.db.ProductVO;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Element;

import weblogic.jws.Context;
import weblogic.jws.Conversation;
import weblogic.jws.Conversational;
import weblogic.wsee.jws.JwsContext;
import org.apache.beehive.controls.api.bean.Control;
/**
 * Non-conversational version of ShopWS. The client name is passed to each method.
 * 
 */
@WebService
public class Shop2WS implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String myShopAccountName = "john";
	private HashMap invoiceMap = new HashMap(); // would be HashMap<Invoice, String>
			// if generics worked with WebLogic web services
	@Control
	private ProductWSServiceControl productWSServiceControl;
	@Control
	private BankWSServiceControl bankWSServiceControl;

	public void newCart(String client) {
		Invoice invoice = new Invoice();
		invoice.setClient(client);
		invoiceMap.put(client, invoice);
		System.out.println("this=" + this + "; invoiceMap=" + invoiceMap);
	}
	public ProductVO[] getAllProducts() {
		return productWSServiceControl.getAllProducts();
	}
	public void addItem(String client, String supplier, String code, int qty) {
		Invoice invoice = getInvoice(client);
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
		invoiceMap.remove(client);
		return invoice;
	}
	public Invoice getInvoice(String client) {
		Invoice invoice = (Invoice)invoiceMap.get(client);
		if (invoice == null) {
			System.out.println("this=" + this + "; invoiceMap=" + invoiceMap);
			System.out.println("invoiceMap.size()=" + invoiceMap.size());
			for (Object o: invoiceMap.keySet()) {
				System.out.println("clientName=" + o);
			}
			throw new IllegalStateException("no shopping cart active for client " + client);
		}
		return invoice;
	}
}