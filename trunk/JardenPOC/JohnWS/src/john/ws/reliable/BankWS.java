package john.ws.reliable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.*;

import weblogic.jws.BufferQueue;
import weblogic.jws.Policy;
import weblogic.jws.ReliabilityBuffer;
import weblogic.jws.Transactional;

@WebService
@Policy(uri="policy:DefaultReliability.xml", // "ReliablePolicy.xml",
        direction=Policy.Direction.both
        /* , attachToWsdl=true*/)
@BufferQueue(name="jms.johnReliableQ")
public class BankWS {
	private int errorCount = 0;
	private final static SimpleDateFormat dateFormat =
		new SimpleDateFormat("yyyyMMMdd-HH:mm:ss");
	private PrintWriter printWriter;

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
}