package test.misc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("localhost",9876);
		OutputStream os = sock.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write("Hello");
		osw.close();
	}
}
