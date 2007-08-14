package john.ws.cart;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private String clientName;
	private String creditCardNumber;
	private ArrayList cartList;
	
	public Cart() {
		
	}
	public Cart(String clientName) {
		cartList = new ArrayList();
		this.clientName = clientName;
	}
	public void addItem(String itemName) {
		cartList.add(itemName);
	}
	public String[] getCartArray() {
		return (String[])cartList.toArray(new String[0]);
	}
	public void setCartArray(String[] itemNames) {
		cartList.clear();
		for (String itemName: itemNames) {
			cartList.add(itemName);
		}
	}
	public ArrayList getCartList() {
		return cartList;
	}
	public String getClientName() {
		return clientName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}
