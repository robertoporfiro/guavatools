package john.ws.cart;

import java.io.Serializable;
import java.util.HashMap;

import javax.jws.*;

import weblogic.jws.Conversation;
import weblogic.jws.Conversational;

@WebService
@Conversational()
public class ShopWS implements Serializable
{
	private static final long serialVersionUID = 1L;
	private HashMap cart;
	private String client;

	@Conversation (Conversation.Phase.START)
	public void newCart(String client) {
		this.client = client;
		cart = new HashMap();
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
	private static final long serialVersionUID = 1L;
	private Cart cart;
	
	@Conversation(Conversation.Phase.START)
	public void startCart(String clientName) {
		cart = new Cart(clientName);
	}
	@Conversation(Conversation.Phase.CONTINUE)
	public void addItem(String itemName) {
		cart.addItem(itemName);
	}
	@Conversation(Conversation.Phase.CONTINUE)
	public Cart getCart() {
		return cart;
	}
	@Conversation(Conversation.Phase.FINISH)
	public Cart buyCart(String creditCard) {
		cart.setCreditCardNumber(creditCard);
		return cart;
	}
	*/
	/*
	private ArrayList primeList;
	
	@Conversation(Conversation.Phase.START)
	public void startPrimes(int from, int count) {
		return;
	}
	private void nextPrime() {
		if (primeList == null) {
			primeList = new ArrayList();
			primeList.add(1);
		}
	}
	private void nextPrime(int from) {
		int highest = (Integer)primeList.get(primeList.size() - 1);
		
	}
	*/
}