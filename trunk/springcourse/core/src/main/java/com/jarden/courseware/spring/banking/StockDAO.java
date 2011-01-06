package com.jarden.courseware.spring.banking;

import java.util.Collection;

/**
 * Defines the methods to CRUD Stock
 * @author Peet Denny
 *
 */
public interface StockDAO {

	/**
	 * @return all of the Stock in a market
	 */
	Collection<Stock> getAllStock();

	/**
	 * Gets an individual stock by its symbol
	 * @param string
	 * @return
	 */
	Stock getStock(String string);

	/**
	 * Updates the stock in the store
	 * @param stock
	 */
	public void update(Stock stock);

}
