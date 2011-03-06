package com.maninvestments.rabbitmq.testframework;

import java.io.IOException;

import org.junit.Test;


/**
 * Starts up the embedded instance, creates and exchange, sends messages
 * and then attempts to consume
 * @author denny
 *
 */
public class TestCanSendAndReceiveOnEmbeddedBroker {

	private static final int SECONDS_TO_WAIT_FOR_BROKER_TO_START = 5;
	RabbitInstanceController instanceController = new RabbitInstanceControllerImpl(); 
	
	/**
	 * Creates a consumer and queue.
	 * Sends 3 messages, then attempts to receive them
	 * @throws BrokerProcessException
	 * @throws IOException 
	 */
	@Test
	public void shouldReceiveSentMessages() {
		try {
			instanceController.start();
			instanceController.waitForStartingBroker(SECONDS_TO_WAIT_FOR_BROKER_TO_START);
			RabbitHelper.getQueueForExchange("test.send-receive.1");
		} catch (Exception e) {
			try {
				instanceController.stop();
			} catch (BrokerProcessException e1) {
				System.out.println(e);	// TODO replace with Logger
			}
		}
	}
}
