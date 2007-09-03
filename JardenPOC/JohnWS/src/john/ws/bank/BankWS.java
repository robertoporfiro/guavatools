package john.ws.bank;

import java.util.Date;

import javax.jws.*;

import weblogic.jws.Transactional;
import org.apache.beehive.controls.api.bean.Control;
import john.db.BankDB;
import john.db.JardenAccountVO;
import john.db.JohnLogVO;
import john.db.LogMessageDB;

@WebService
public class BankWS {
	@Control
	private BankDB bankDB;
	@Control
	private LogMessageDB logMessageDB;
	
	@Transactional(value = true)
	public double transfer(String fromName, String password, String toName,
			double amount) throws BankException {
		String action = "BankWS.transfer('" + fromName + "', <password>, '" + toName +
			"', " + amount + ")";
		System.out.println(action);
		if (amount <= 0) {
			throw new BankException("invalid amount: " + amount);
		}
		JardenAccountVO account = getAccount(fromName, password);
		if (account.getBalance() < amount) {
			throw new BankException("insufficient funds in account "
					+ fromName);
		}
		JardenAccountVO account2 = bankDB.getAccount(toName);
		if (account2 == null) {
			throw new BankException("unknown account " + toName);
		}
		double newBal = account.getBalance() - amount;
		bankDB.setBalance(fromName, newBal);
		bankDB.setBalance(toName, account2.getBalance() + amount);
		Date now = new Date();
		String message = amount + " transferred from " + fromName + 
			" to " + toName;
		logMessageDB.logMessage(fromName, message, now);
		logMessageDB.logMessage(toName, message, now);
		return newBal;
	}
	public double getBalance(String userName, String password) throws BankException {
		JardenAccountVO account = getAccount(userName, password);
		return account.getBalance();
	}
	public int changePassword(String userName, String oldPassword, String newPassword)
	throws BankException {
		getAccount(userName, oldPassword); // i.e. check userName & password are valid
		return bankDB.changePassword(userName, newPassword);
	}
	public JohnLogVO[] getTransactionLog(String userName, String password) throws BankException {
		getAccount(userName, password);
		return logMessageDB.getMessagesByOwner(userName);
	}
	private JardenAccountVO getAccount(String userName, String password) throws BankException {
		JardenAccountVO account = bankDB.getAccount(userName);
		if (account == null) {
			throw new BankException("unknown account " + userName);
		}
		if (!account.getPassword().equals(password)) {
			throw new BankException("invalid password on account "
					+ userName);
		}
		return account;
	}
}