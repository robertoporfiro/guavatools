package test.banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import test.banking.store.Shutdownable;

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
	
	public void openNewAccount(Account account) {
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

	public void exit() throws FileNotFoundException, IOException {
		if(accountService instanceof Shutdownable){
			((Shutdownable)accountService).shutdown();
		}
	}

	
	
}
