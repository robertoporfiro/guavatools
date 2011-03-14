package test.banking.store;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Shutdownable {

	public void shutdown() throws FileNotFoundException, IOException;
	

}
