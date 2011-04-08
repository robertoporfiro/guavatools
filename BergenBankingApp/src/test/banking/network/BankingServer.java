package test.banking.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BankingServer {

	public static void main(String[] args) throws IOException {
		BankingServer bankingServer = new BankingServer();
		bankingServer.start();
	}

	private boolean showtime = true;

	private void start() throws IOException {
		int portNumber = 80;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		while(showtime ){
			Socket socket = serverSocket.accept();
			beginCustomerSession(socket);
		}
	}

	private void beginCustomerSession(Socket socket) {
	}
}
