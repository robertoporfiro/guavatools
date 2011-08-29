package test.banking.transfer;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestTransferService {
	
	private static final int UNKNOWN_BANK = 9999;
	private InterbankService interbankService;
	private TransferService transferService;

	@Before public void init(){
		interbankService = mock(InterbankService.class);
		transferService = new TransferService(interbankService);
		ExternalBank bank = mock(ExternalBank.class);
		when(interbankService.getBank(1)).thenReturn(bank);
		
		when(interbankService.getBank(UNKNOWN_BANK)).thenThrow(ExternalBankException.class);
	}
	
	@Test public void shouldGetExternalBank() throws ExternalBankException{
		int sortcode = 1;
		transferService.getExternalBank(sortcode);
		verify(interbankService, times(1)).getBank(sortcode);
	}
	
	@Test(expected=ExternalBankException.class) 
	public void shouldErrorOnUnknownBank() throws ExternalBankException{
		transferService.getExternalBank(UNKNOWN_BANK);
	}

}
