package test.banking;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceInMemoryImpl implements AccountService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String checkingAccNumberStub = "C-";
	String savingsAccNumberStub = "S-";
	private Map<String,Account> accountStore = new HashMap<String, Account>();
	private int sequence=100;

	public final static String[] testCheckingAccountNumbers = {
		"C-6757",
		"C-6758",
		"C-6759",
	};
	
	public final static String[] testSavingsAccountNumbers = {
		"S-6757",
		"S-6758",
		"S-6759",
	};

	
	public AccountServiceInMemoryImpl() {
		for(String accNo: testCheckingAccountNumbers){
			Account a = new CheckingAccount(accNo);
			accountStore.put(a.getAccountNumber(),a);
		}
		for(String accNo: testSavingsAccountNumbers){
			Account a = new SavingsAccount(accNo);
			accountStore.put(a.getAccountNumber(),a);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(){

			@Override
			public void run() {
				System.out.println("Shutting down banking app");
			}
			
		});
	}
	
	@Override
	public Account openAccount(Account account) throws ServiceException {
		String accountNumber = getNextAccountNumber(account);
		account.setAccountNumber(accountNumber);
		return account;
	}

	private synchronized String getNextAccountNumber(Account account) {
		if(account instanceof SavingsAccount){
			return savingsAccNumberStub + sequence ++;
		}
		return checkingAccNumberStub + sequence ++;
	}

	@Override
	public Account getAccountByNumber(String number) throws ServiceException {
		return this.accountStore.get(number);
	}

	@Override
	public Collection<Account> getAccounts() throws ServiceException {
		return this.accountStore.values();
	}

	@Override
	public void updateAccount(Account account) throws ServiceException {
		
	}

	public void setAccounts(Collection<Account> accounts) {
		System.out.println("Loading "+accounts.size()+ "accounts from disk");
		for(Account acc: accounts){
			this.accountStore.put(acc.getAccountNumber(), acc);
		}
	}

}
