package test.banking.aspects;

import test.banking.Account;

public class AccountStoreImpl implements AccountStore{

	@Override
	public void storeAccount(Account a) {
		// do nothing. Let's hope the logging aspect picks this up
		System.out.println("Here:"+a);
	}

}
