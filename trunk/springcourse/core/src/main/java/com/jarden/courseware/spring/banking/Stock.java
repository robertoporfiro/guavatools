package com.jarden.courseware.spring.banking;

/**
 * Holds the symbol and current price of the stock
 * @author Peet Denny
 *
 */
public class Stock {

	
	
	private String symbol;
	private double price;

	public Stock(String symbol, double price) {
		this.symbol = symbol;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
