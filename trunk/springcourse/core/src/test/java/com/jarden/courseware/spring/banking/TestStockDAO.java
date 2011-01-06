package com.jarden.courseware.spring.banking;

import static org.junit.Assert.*;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jarden.courseware.spring.banking.audit.Auditor;

/**
 * Tests the StockDAO
 * @author Peet Denny
 *
 */
public class TestStockDAO {
	Logger log = Logger.getLogger(this.getClass());
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
//	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	StockDAO dao = ctx.getBean("stockDAO", StockDAO.class);
	
	@Test
	public void testGetAll(){
		Collection<Stock> allStock = dao.getAllStock();
		assertFalse("Stock should not be empty",allStock.isEmpty());
		for(Stock stock: allStock){
			log.info(stock.getSymbol()+": £"+stock.getPrice());
		}
	}
	
	@Test
	public void testUpdate(){
		String symbol = "PFE";
		Stock stock = dao.getStock(symbol);
		assertNotNull(stock);
		double startValue = stock.getPrice();
		int increment = 101;
		stock.setPrice(startValue+increment);
		dao.update(stock);
		stock = dao.getStock(symbol);
		assertEquals((startValue+increment), stock.getPrice(),0.01);
	}
	
	@Test
	public void testAspect(){
		int updateInvocations = Auditor.getUpdateInvocations();
		testUpdate();
		assertSame((updateInvocations+1),Auditor.getUpdateInvocations());		
	}

}
