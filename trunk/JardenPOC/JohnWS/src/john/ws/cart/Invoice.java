package john.ws.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList itemList = new ArrayList();
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
		return (CartItem[])itemList.toArray(new CartItem[0]);
	}
	public void setItems(CartItem[] items) {
		itemList.addAll(Arrays.asList(items));
	}
	public void addItem(CartItem item) {
		itemList.add(item);
	}
	public void calculateTotalPrice() {
		totalPrice = 0;
		for (int i = 0; i < itemList.size(); ++i) {
			CartItem item = (CartItem)itemList.get(i); 
			totalPrice += item.getPrice() * item.getQuantity();
		}
	}

}
