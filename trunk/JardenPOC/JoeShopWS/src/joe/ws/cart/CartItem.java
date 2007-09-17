package joe.ws.cart;

import java.io.Serializable;

public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	private String supplier;
	private String code;
	private String name;
	private int quantity;
	private double price;
	
	public CartItem() {
	}
	public CartItem(String supplier, String code, String name, int quantity, double price) {
		this.code = code;
		this.supplier = supplier;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
