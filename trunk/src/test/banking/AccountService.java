package test.banking;

import java.util.Collection;

/**
 * Abstracts the CRUD operations for the Account service
 * @author denny
 *
 */
public interface AccountService {
	public Account openAccount(Account account) throws ServiceException;
	public Account getAccountByNumber(String number) throws ServiceException;
	public Collection<Account> getAccounts() throws ServiceException;
	public void updateAccount(Account account) throws ServiceException;
}
