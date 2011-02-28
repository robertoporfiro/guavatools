package test.banking;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AccountServiceFactory {

	public static AccountService getAccountService() {
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
			return serviceImpl;
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AccountServiceInMemoryImpl();
	}

	
}
