package test.banking;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the savings functionality
 * @author denny
 *
 */
public class TestSavingsAccount {
	
	private static final double INTEREST_RATE = 5.0;

	@Test
	public void testApplyInterest(){
		SavingsAccount account = new SavingsAccount("sdfsf");
		account.setInterestRate(INTEREST_RATE);
		account.credit(1000.0);
		assertEquals(1000.0, account.getBalance(),0.001);
		account.applyInterest();
		assertEquals(1000.0*(INTEREST_RATE/365), account.getBalance(),0.001);
	}
	@Test(expected = InterestException.class)
	public void testInterestException(){
		SavingsAccount account = new SavingsAccount("dsfs");
		account.setInterestRate(-1);
	}
}
