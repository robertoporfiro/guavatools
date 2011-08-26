package test.banking.transfer;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class TestTransferService {

	private InterbankService interbankService;
	private ExternalBank bank9;
	
	@Before public void setup(){
		bank9 = mock(ExternalBank.class);
		interbankService = mock(InterbankService.class);
		when(interbankService.getBank(9)).thenReturn(bank9);
	}

	@Test public void shouldValidateSortCode(){
		TransferService s = new TransferService(interbankService);
		ExternalBank bank = s.retrieveBankBySortCode(9);
		assertNotNull(bank);
		
	}
	
}
