package john.ws.cart;

import java.io.Serializable;
import java.util.HashMap;

import javax.jws.*;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.w3c.dom.Element;

import weblogic.jws.Context;
import weblogic.jws.Conversation;
import weblogic.jws.Conversational;
import weblogic.wsee.jws.JwsContext;
/**
 * Non-conversational version of ShopWS. The client name is passed to each method.
 * 
 */
@WebService
public class Shop2WS implements Serializable
{
	private static final long serialVersionUID = 1L;
	private HashMap invoiceMap = new HashMap(); // would be HashMap<Invoice, String>
			// if generics worked with WebLogic web services

	public void newCart(String client) {
		Invoice invoice = new Invoice();
		invoice.setClient(client);
		invoiceMap.put(client, invoice);
	}
	public void addItem(String client, CartItem item) {
		Invoice invoice = getInvoice(client);
		invoice.addItem(item);
	}
	public CartItem[] getCart(String client) {
		Invoice invoice = getInvoice(client);
		return invoice.getItems();
	}
	public Invoice placeOrder(String client, String creditCardNumber) {
		Invoice invoice = getInvoice(client);
		invoice.setCreditCardNumber(creditCardNumber);
		invoice.calculateTotalPrice();
		invoice.setCreditCardNumber(creditCardNumber);
		invoiceMap.remove(client);
		return invoice;
	}
	private Invoice getInvoice(String client) {
		Invoice invoice = (Invoice)invoiceMap.get(client);
		if (invoice == null) {
			System.out.println("invoiceMap.size()=" + invoiceMap.size());
			for (Object o: invoiceMap.keySet()) {
				System.out.println("clientName=" + o);
			}
			throw new IllegalStateException("no shopping cart active for client " + client);
		}
		return invoice;
	}
}