package john.ws.complex;

import java.io.Serializable;

import javax.jws.*;

import weblogic.jws.Conversation;
import weblogic.jws.Conversational;

@WebService
@Conversational()
public class ConverseWS implements Serializable
{
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