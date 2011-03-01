package test.banking;

import java.util.Collection;

/**
 * Holds a collection of bank accounts
 * @author denny
 *
 */
public class Bank {

	private static Bank instance = new Bank();
	private AccountService accountService = AccountServiceFactory.getAccountService();
	
	
	
	private Bank(){
	}
	
	public void openNewAccount(CheckingAccount account) {
		accountService.openAccount(account);
	}

	public static Bank getBank() {
		return instance ;
	}
	
	public Account getAccount(String accountNumber) {
		return accountService.getAccountByNumber(accountNumber);
	}
	public Collection<Account> getAllAccounts() {
		return accountService.getAccounts();
	}

	
	
}
