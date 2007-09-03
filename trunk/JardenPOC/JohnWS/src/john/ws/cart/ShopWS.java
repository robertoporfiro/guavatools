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

@WebService
@Conversational()
public class ShopWS implements Serializable
{
	@Context
	private JwsContext jwsContext;
	
	private static final long serialVersionUID = 1L;
	private HashMap cart;
	private String client;

	@Conversation (Conversation.Phase.START)
	public void newCart(String client) {
		this.client = client;
		cart = new HashMap();
		// printHeaders();
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public void addItem(CartItem item) {
		CartItem existingItem = (CartItem)cart.get(item.getCode());
		if (existingItem == null) {
			cart.put(item.getCode(), item);
		}
		else {
			existingItem.setQuantity(item.getQuantity() + existingItem.getQuantity());
			existingItem.setPrice(item.getPrice() + existingItem.getPrice());
		}
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public String getClient() {
		return client;
	}
	@Conversation (Conversation.Phase.CONTINUE)
	public CartItem[] getCart() {
		return (CartItem[])cart.values().toArray(new CartItem[0]);
	}
	@Conversation (Conversation.Phase.FINISH)
	public Invoice placeOrder(String creditCardNumber) {
		Invoice invoice = new Invoice();
		invoice.setClient(client);
		CartItem[] items = getCart();
		double totalPrice = 0;
		for (CartItem item: items) {
			totalPrice += item.getPrice() * item.getQuantity();
		}
		invoice.setItems(getCart());
		invoice.setTotalPrice(totalPrice);
		invoice.setCreditCardNumber(creditCardNumber);
		return invoice;
	}
	/*
	private void printHeaders() {
		Element[] inputHeaders = jwsContext.getInputHeaders();
		for (Element element: inputHeaders) {
			try {
				XmlObject obj = XmlObject.Factory.parse(element.getDocumentElement());
				System.out.println(obj);
			} catch (XmlException e) {
				e.printStackTrace();
			}
			
		}
	}
	*/
	
}