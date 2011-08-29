package test.banking.transfer;

public interface ExternalBank {
	
	public boolean verifyAvailableFunds(double funds) throws ExternalBankException;
	
	public long begin()throws ExternalBankException;
	
	public boolean debit(String payee, double funds)throws ExternalBankException;
	
	public boolean credit(String payee, double funds) throws ExternalBankException;
	
	public void commit(long transactionId)throws ExternalBankException;
	
	public void rollback(long transactionId)throws ExternalBankException;

}
