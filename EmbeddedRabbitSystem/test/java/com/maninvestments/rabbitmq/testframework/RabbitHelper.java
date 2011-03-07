package com.maninvestments.rabbitmq.testframework;

import java.io.IOException;
import java.util.logging.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Helps out with getting connections etc
 * @author denny
 *
 */
public class RabbitHelper {

	static Logger log = Logger.getLogger(RabbitHelper.class.getName());
	public static String userName = "guest";
	public static String password = "guest";
	public static String hostName = TestUtils.getLocalHostName();
	public static int portNumber = 5672;
	public static String nodeName="testframework-rabbit";


	
	/**
	 * Gets a connection to RabbitMQ
	 * @param userName 
	 * @param password 
	 * @param hostName 
	 * @param portNumber 
	 * @return 
	 * @throws IOException 
	 */
	public static Connection getConnection() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(userName);
		factory.setPassword(password);
		factory.setHost(hostName);
		factory.setPort(portNumber);
		factory.setVirtualHost("/");
		Connection conn = factory.newConnection();
		return conn;
	}



	public static boolean isRunning() {
		Connection c = null;
		try {
			c = getConnection();
		} catch (IOException e) {
			return false;
		}finally{
			try {
				if(c != null){
					c.close();
				}
			} catch (IOException e) {
				//ignore
			}
		}
		return true;
	}



	public static void getQueueForExchange(String exchangeName) throws IOException {
		Connection con = getConnection();
		Channel channel = con.createChannel();
		channel.exchangeDeclare(exchangeName, null);
	}

}
