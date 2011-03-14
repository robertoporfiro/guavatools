package test.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	
	public static void main(String[] args) throws IOException {
		TestServer server = new TestServer();
		server.start();
		
	}

	private void start() throws IOException {
		ServerSocket socket = new ServerSocket(9876);
		System.out.println("Blocking to accept incoming connections");
		Socket sock = socket.accept();
		InputStream is = sock.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String line = reader.readLine();
		while(true){
			try{
				if(line != null){
					System.out.println(line);
				}
				Thread.sleep(1000);
				line = reader.readLine();
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
}
