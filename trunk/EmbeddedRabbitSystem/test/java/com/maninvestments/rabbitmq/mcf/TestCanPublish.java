package com.maninvestments.rabbitmq.mcf;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.maninvestments.rabbitmq.testframework.AbstractSingleNodeRabbitMQTest;
import com.maninvestments.rabbitmq.testframework.RabbitHelper;
import com.rabbitmq.client.Connection;

/**
 * Tests publishing functionality
 * @author denny
 *
 */
public class TestCanPublish extends AbstractSingleNodeRabbitMQTest{

	
	@Test
	public void testCanConnectToRabbitInstance() throws IOException{
		Connection connection = RabbitHelper.getConnection();
		assertNotNull(connection);
		connection.close();
	}
	
	
}
