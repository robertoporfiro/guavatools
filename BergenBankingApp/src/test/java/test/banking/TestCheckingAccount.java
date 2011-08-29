package test.banking;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the functionality of the account class
 * @author denny
 *
 */
public class TestCheckingAccount {

	@Test
	public void testDebitAndCreditMethods(){
		Account a = new CheckingAccount("098089");
		double balance = a.getBalance();
		assertTrue(balance == 0.0);
		a.credit(200);
		assertEquals(200.00,a.getBalance(),0.00001);
		a.debit(100.0);
		assertEquals(100.00,a.getBalance(),0.00001);	}
	
	
}
