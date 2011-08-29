package test.banking.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class TestClient {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1",80);
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Hello at "+new Date());
		sock.close();
	}
}
