package john.ws.bank;

public class BankException extends Exception {
	private static final long serialVersionUID = 1L;

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

	public BankException(String message, Throwable cause) {
		super(message, cause);
	}

	public BankException(Throwable cause) {
		super(cause);
	}
	

}
