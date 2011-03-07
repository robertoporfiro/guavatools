package com.maninvestments.rabbitmq.testframework;

/**
 * Defines the interface for components that control RabbitMQ processes for testing purposes.
 * <br>
 * Startup, shutdown etc
 * @author denny
 *
 */
public interface RabbitInstanceController {

	public Process start() throws BrokerProcessException;
	public int stop() throws BrokerProcessException;
	public boolean isRunning() throws BrokerProcessException;
	/**
	 * Waits for the broker instance to start by attempting to get a connection
	 * every seconds until secondsToWait is reached
	 * @param millis
	 * @throws BrokerProcessException
	 */
	public void waitForStartingBroker(int secondsToWait) throws BrokerProcessException;
	
}
