package test.banking.store;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedList;

import test.banking.Account;
import test.banking.AccountService;
import test.banking.AccountServiceInMemoryImpl;
import test.banking.ServiceException;


public class AccountServiceFileStoreImpl implements AccountService, Shutdownable{

	File fileStore = new File("AccountStore.ser");
	
	AccountServiceInMemoryImpl  delegate = new AccountServiceInMemoryImpl();
	
	public AccountServiceFileStoreImpl(){
		if( !fileStore.exists()){
			try {
				fileStore.createNewFile();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		try {
			load();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	/**
	 * Loads the accounts from file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("unchecked")
	void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.fileStore));
		Collection<Account> accounts = null;
		try{
			accounts = (Collection<Account>) ois.readObject();
		}catch(EOFException e){
			System.out.println(e);
			// ignore. This is just because the store hasn't been initialised yet
		}
		this.delegate.setAccounts(accounts);
		ois.close();
	}
	
	public void shutdown() throws FileNotFoundException, IOException{
		Collection<Account> accounts = new LinkedList<Account>();
		accounts.addAll(delegate.getAccounts());
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.fileStore));
		oos.writeObject(accounts);
		System.out.println("Wrote out "+accounts.size()+ " accounts to disk");
		oos.close();
	}

	@Override
	public Account openAccount(Account account) throws ServiceException {
		return delegate.openAccount(account);
	}

	@Override
	public Account getAccountByNumber(String number) throws ServiceException {
		return delegate.getAccountByNumber(number);
	}

	@Override
	public Collection<Account> getAccounts() throws ServiceException {
		return delegate.getAccounts();
	}


	@Override
	public void updateAccount(Account account) throws ServiceException {
		delegate.updateAccount(account);		
	}

}
