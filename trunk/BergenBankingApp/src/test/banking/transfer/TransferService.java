package test.banking.transfer;

public class TransferService {

	private final InterbankService interbankService;

	public TransferService(InterbankService interbankService) {
		this.interbankService = interbankService;
	}

	public ExternalBank retrieveBankBySortCode(int sortCode) {
		return interbankService.getBank(sortCode);
	}

}
