package john.ws.reliable;

import java.util.Date;

import javax.jws.*;

import weblogic.jws.BufferQueue;
import weblogic.jws.Policy;
import weblogic.jws.ReliabilityBuffer;
import weblogic.jws.Transactional;
import org.apache.beehive.controls.api.bean.Control;
import john.db.BankDB;
import john.db.JardenAccountVO;
import john.db.LogMessageDB;

@WebService
@Policy(uri="policy:DefaultReliability.xml", // "ReliablePolicy.xml",
        direction=Policy.Direction.both
        // , attachToWsdl=true
)
@BufferQueue(name="jms.johnReliableQ")
public class BankReliableWS {
	// private final static SimpleDateFormat dateFormat =
	//	new SimpleDateFormat("yyyyMMMdd-HH:mm:ss");
	private int errorCount;

	@Control
	private BankDB bankDB;
	@Control
	private LogMessageDB logMessageDB;
	
	@Oneway()
	@ReliabilityBuffer(retryCount = 5, retryDelay = "3 seconds")
	@Transactional(value = true)
	public void transfer(String fromName, String password, String toName,
			double amount) { 
		String action = "BankWS.transfer('" + fromName + "', <password>, '" + toName +
			"', " + amount + ")";
		System.out.println(action);
		if (amount <= 0) {
			System.out.println("amount " + amount + " is negative");
			++errorCount;
			if (errorCount < 3) {
				System.out.println("about to throw exception; errorCount=" + errorCount);
				throw new IllegalArgumentException("invalid amount: " + amount);
			}
			errorCount = 0;
			return; // amount;
		}
		JardenAccountVO account = bankDB.getAccount(fromName);
		if (account == null) {
			throw new IllegalArgumentException("unknown account " + fromName);
		}
		if (!account.getPassword().equals(password)) {
			throw new IllegalArgumentException("invalid password on account "
					+ fromName);
		}
		if (account.getBalance() < amount) {
			throw new IllegalArgumentException("insufficient funds in account "
					+ fromName);
		}
		JardenAccountVO account2 = bankDB.getAccount(toName);
		if (account2 == null) {
			throw new IllegalArgumentException("unknown account " + toName);
		}
		double newBal = account.getBalance() - amount;
		bankDB.setBalance(fromName, newBal);
		bankDB.setBalance(toName, account2.getBalance() + amount);
		Date now = new Date();
		String message = amount + " transferred from " + fromName + 
			" to " + toName;
		logMessageDB.logMessage(fromName, message, now);
		logMessageDB.logMessage(toName, message, now);
		return ; //newBal;
	}
	/*
	@Oneway()
	@ReliabilityBuffer(retryCount = 5, retryDelay = "3 seconds")
	@Transactional(value = true)
	public void debit(String account, double amount) {
		String date = dateFormat.format(new Date());
		String entry = date + "\tDebit " + amount + " from account " + account;
		System.out.println(entry);
		if (amount < 0) {
			System.out.println("amount " + amount + " is negative");
			++errorCount;
			if (errorCount < 3) {
				System.out.println("about to throw exception");
				throw new IllegalStateException("errorCount=" + errorCount);
			}
			errorCount = 0;
		}
		logEntry(entry);
	}

	private void logEntry(String entry) {
		try {
			if (printWriter == null) {
				File file = new File("c:/john/Bank.log");
				FileWriter fileWriter = new FileWriter(file, true); // append
				printWriter = new PrintWriter(fileWriter);
			}
			printWriter.println(entry);
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
}