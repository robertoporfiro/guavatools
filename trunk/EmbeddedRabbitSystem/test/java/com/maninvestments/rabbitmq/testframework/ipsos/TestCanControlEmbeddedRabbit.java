package com.maninvestments.rabbitmq.testframework.ipsos;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.maninvestments.rabbitmq.testframework.BrokerProcessException;
import com.maninvestments.rabbitmq.testframework.RabbitHelper;
import com.maninvestments.rabbitmq.testframework.RabbitInstanceController;
import com.maninvestments.rabbitmq.testframework.RabbitInstanceControllerImpl;

/**
 * Tests that the embedded RabbitMQ broker can be started and stopped via Java
 * @author Denny
 * Silje
 */
public class TestCanControlEmbeddedRabbit {

	private static final long SERVER_START_WAIT_TIME = 6000;
	RabbitInstanceController controller = new RabbitInstanceControllerImpl();


	/**
	 * Tests that Rabbit is unreachable. Then starts it and tests that it is reachable.
	 * Then shuts it down and tests that it'd unreachable again.
	 * @throws IOException 
	 * @throws BrokerProcessException 
	 */
	@Test
	public void shouldBeAbleToStartAndStopRabbitInstance() throws IOException, BrokerProcessException{
		assertServerIsDown("An IO exception was expected at this time. Is the test Rabbit instance already running on port "+RabbitHelper.portNumber+"\nIf so, please shut it down");
		controller.start();
		pause(SERVER_START_WAIT_TIME);
		assertServerIsUp();
		controller.stop();
		assertServerIsDown("Server should have been shut down by now, controller.stop() funtionality does not work");
	}
	

	private void pause(long serverStartWaitTime) {
		try {
			Thread.sleep(serverStartWaitTime);
		} catch (InterruptedException e) {
			// ignore
		}
	}


	/**
	 * Asserts server is up by attempting to get connection to it.
	 * @throws IOException if the server is not down
	 * @throws BrokerProcessException 
	 */
	private void assertServerIsUp() throws BrokerProcessException {
		 controller.isRunning();	
	}


	private void assertServerIsDown(String message) {
		try {
			RabbitHelper.getConnection();
		} catch (IOException e) {
			return; // Good, this is what we expected
		}
		Assert.fail(message);
	}
	
}
