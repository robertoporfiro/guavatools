package com.jarden.courseware.spring.banking.mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jarden.courseware.spring.banking.Stock;
import com.jarden.courseware.spring.banking.StockDAO;

public class StockDAOInMemoryImpl implements StockDAO {

	/**
	 * Just an empty ArrayList to prevent NPEs
	 */
	private Map<String, Stock> stockMap = new HashMap<String, Stock>();

	@Override
	public Collection<Stock> getAllStock() {
		return stockMap.values();
	}

	public void setStock(Collection<Stock> allStock) {
		for(Stock s: allStock){
			stockMap.put(s.getSymbol(), s);
		}
	}

	@Override
	public Stock getStock(String sybmol) {
		return stockMap.get(sybmol);
	}

	@Override
	public void update(Stock stock) {
		stockMap.put(stock.getSymbol(), stock);
	}

}
