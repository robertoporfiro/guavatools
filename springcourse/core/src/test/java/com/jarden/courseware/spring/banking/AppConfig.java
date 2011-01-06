package com.jarden.courseware.spring.banking;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jarden.courseware.spring.banking.mock.StockDAOInMemoryImpl;

@Configuration
public class AppConfig {

	/**
	 * Creates a stockDAO impl and initialises it.
	 * @return
	 */
	public @Bean StockDAO stockDAO(){
		StockDAOInMemoryImpl impl =new StockDAOInMemoryImpl();
		Collection<Stock> allStock = generateTestStock();
		impl.setStock(allStock);
		return impl ;
	}

	/**
	 * 
	 * @return
	 */
	private Collection<Stock> generateTestStock() {
		Collection<Stock> allStock = new ArrayList<Stock>();
		allStock.add(new Stock("LLY",500));
		allStock.add(new Stock("PFE",300));
		allStock.add(new Stock("GSK",300));
		allStock.add(new Stock("MRK",600));
		return allStock;
	}
}
