package john.ws.cart;

import java.io.Serializable;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
	private CartItem[] items;
	private String client;
	private String creditCardNumber;
	private double totalPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public CartItem[] getItems() {
		return items;
	}
	public void setItems(CartItem[] items) {
		this.items = items;
	}

}
