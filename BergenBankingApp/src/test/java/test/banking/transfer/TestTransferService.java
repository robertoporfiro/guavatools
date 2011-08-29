package test.banking.transfer;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestTransferService {

	@Test public void shouldDebitRemoteAccount(){
		InterbankService interbankService = mock(InterbankService.class);
		TransferService service = new TransferService(interbankService);
	}
	
}
