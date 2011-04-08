package test.banking.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class BankingClient {
	
	private static int port;
	private static String host;
	private OutputStream os;

	public static void main(String[] args) throws IOException {
		if(args.length<1){
			host="localhost";
			port=80;
		}
		BankingClient client = new BankingClient();
		client.run();
	}

	private void run() throws IOException {
		Socket sock = new Socket(host,port);
		os = sock.getOutputStream();
		startReaderThread();
		startWriterThread();
		
	}

	private void startReaderThread() {
		
	}
	
	private void startWriterThread() {
		// TODO Auto-generated method stub
		
	}

}
