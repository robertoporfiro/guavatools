package com.maninvestments.rabbitmq.testframework;


import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Super class for all MCF tests that require access to a running Rabbit instance
 * @author denny
 *
 */
public class AbstractSingleNodeRabbitMQTest {

	private static final int RABBIT_START_WAIT_DELAY = 6;	// Default wait delay in seconds
	static Logger log = Logger.getLogger(AbstractSingleNodeRabbitMQTest.class.getName());
	static RabbitInstanceController instanceController = new RabbitInstanceControllerImpl();
	
	@BeforeClass
	public static void setUp() throws Exception {
		ensureRabbitIsRunning();
	}

	/**
	 * Checks that RabbitMQ is running, and if it isn't, starts it.
	 * @throws BrokerProcessException 
	 */
	private static void ensureRabbitIsRunning() throws BrokerProcessException {
		if(! instanceController.isRunning()){
			log.info("Starting rabbit. Will wait for a total of " + RABBIT_START_WAIT_DELAY+ "seconds");
			instanceController.start();
			instanceController.waitForStartingBroker(RABBIT_START_WAIT_DELAY);
		}
	}

	@AfterClass
	public static void tearDown() throws Exception {
		instanceController.stop();
		log.info("Invoked RabbitMQ stop procedure");
	}

}
