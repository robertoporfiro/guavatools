package test.banking;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AccountServiceFactory {

	private static AccountService instance;

	public static AccountService getAccountService() {
		if(instance != null){
			return instance;
		}
		Properties props = new Properties();
		InputStream is = AccountServiceFactory.class.getResourceAsStream("/banking-app.properties");
		try {
			props.load(is);
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}
		try {
			@SuppressWarnings("unchecked")
			Class<? extends AccountService> serviceImplClass = (Class<? extends AccountService>) Class.forName(props.getProperty("test.banking.AccountService.Implementation.Classname"));
			AccountService serviceImpl = (AccountService) serviceImplClass.newInstance();
			instance=serviceImpl;
			return serviceImpl;
			
			
		
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
