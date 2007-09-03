package john.ws.bank;

public class BankException extends Exception {

	public BankException() {
		super();
	}

	public BankException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	

}
