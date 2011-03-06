package com.maninvestments.rabbitmq.testframework.ipsos;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.maninvestments.rabbitmq.testframework.AbstractSingleNodeRabbitMQTest;
import com.maninvestments.rabbitmq.testframework.BrokerProcessException;
import com.maninvestments.rabbitmq.testframework.RabbitInstanceController;
import com.maninvestments.rabbitmq.testframework.RabbitInstanceControllerImpl;

/**
 * Tests that extending the abstract test class causes server to be started and stopped correctly
 * @author denny
 *
 */
public class TestAbstractTestClassWorks extends AbstractSingleNodeRabbitMQTest{
		
	static RabbitInstanceController instanceController = new RabbitInstanceControllerImpl();

	@Test
	public void testServerIsRunning() throws BrokerProcessException{
		assertTrue(instanceController.isRunning());
	}
	
//	@AfterClass	// TODO Put this into a suite and run this test at the end. This @AfterClass is run *before* the super class
//	public static void testServerIsShutDownAfterTests() throws Exception{
//		
//		boolean isShutDown = TestUtils.rerunTestMethodUntilTrue(	
//								instanceController, 
//								RabbitInstanceController.class.getMethod("isRunning"), 
//								false, 
//								8,
//								"Server not yet shut down",
//								"Server shut down");
//		assertTrue(isShutDown);
//	}

	
}
