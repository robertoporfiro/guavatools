package test.banking.transfer;

public interface InterbankService {

	public ExternalBank getBank(int sortCode);
	public boolean verifySortCode(int sortCode);
	

}
