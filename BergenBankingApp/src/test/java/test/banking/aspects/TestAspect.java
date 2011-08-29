package test.banking.aspects;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.banking.SavingsAccount;

public class TestAspect {

	private ApplicationContext context;

	@Before public void init(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
	@Test public void shouldInvokeLogger(){
		AccountStore store = context.getBean("accountStore", AccountStore.class);
		store.storeAccount(new SavingsAccount("12345"));
	}
}
