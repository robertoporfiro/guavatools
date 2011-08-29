package test.banking;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;


public class TestBank {

	
	@Test
	public void testBank(){
		Bank bank = Bank.getBank();
		Account a = bank.getAccount(AccountServiceInMemoryImpl.testCheckingAccountNumbers[0]);
		assertNotNull(a);
		Collection<Account> accounts = bank.getAllAccounts();
		assertNotNull(accounts);
		for(Account account: accounts){
			assertNotNull(account.getAccountNumber());
		}
	}
}
