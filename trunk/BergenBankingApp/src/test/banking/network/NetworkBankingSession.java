package test.banking.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import test.banking.BankingSession;

public class NetworkBankingSession extends BankingSession {

	private final BufferedReader reader;
	private final PrintWriter writer;

	public NetworkBankingSession(BufferedReader reader, PrintWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	@Override
	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "Server Error: "+e;
		}
	}

	@Override
	public void print(String string) {
		writer.println(string);
	}

	@Override
	public void dispose() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.close();
	}

}
