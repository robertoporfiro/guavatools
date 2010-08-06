package org.guavatools.jms.aggregator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.guavatools.jms.aggregator.BatchProcessOrchestrator;
import org.guavatools.jms.aggregator.BatchProcessor;
import org.guavatools.jms.aggregator.Constants;
import org.guavatools.jms.aggregator.JMSUtils;
import org.guavatools.jms.aggregator.QueuePoller;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestAggregation {
	private static final Random RANDOM = new Random(new Date().getTime());

	public enum BatchType {
		Beginning,
		End,
		Full

	}

	private static final int NO_OF_MESSAGES_IN_BATCH = 10;
	private Logger log = Logger.getLogger(this.getClass().getName());
	private Queue queue;
	private static Random random = RANDOM;
	private ApplicationContext applicationContext = getApplicationContext();
	private JMSUtils jmsUtils = applicationContext.getBean(JMSUtils.class);

	final int noOfBatches = 3;
	private QueueSender sender;
	private QueueSession qSession;
	/**
	 * Send ten messages to a queue <1/> <2/> <3/> etc.
	 * Send them in a random order , but labelled with JMS headers.
	 * This test will prove the the Aggregator waits until all of the messages have arrived before processing them
	 * Also proves that it writes them to an output stream in the correct order
	 * @throws JMSException   
	 * @throws NamingException 
	 */
	@Test
	public void testReceiveMessagesInOrder() throws NamingException, JMSException{
		Collection<String> correlationIds = new ArrayList<String>();
		for(int i=0;i<noOfBatches;i++){
			String correlationId = nextCorrelationId();
			correlationIds.add(correlationId);
			Collection<MessageVO> messages = getMessageBatch(correlationId);
			sendMessages(messages);
		}
		
		
		// the queue should now contain noOfBatches complete batches
		
		for(String correlationId: correlationIds){
			BatchProcessOrchestrator batchProcessOrchestrator = applicationContext.getBean(BatchProcessOrchestrator.class);
			BatchProcessor batchProcessor = batchProcessOrchestrator.getBatchProcessor(correlationId);
			assertNotNull(batchProcessor);
			pause(1000,"Waiting for messages to be consumed");
			assertEquals("Expected the processor to have processed "+NO_OF_MESSAGES_IN_BATCH+" messages", NO_OF_MESSAGES_IN_BATCH, batchProcessor.getNoOfMessagesProcessed() );
		}
	}
	
	
	/**
	 * Populates the queue with n partial batches and then fires up a browser to see if it detects that there are n batches.
	 * Checks that it doesn't start processing until the full batch is available.
	 * 
	 * @throws NamingException
	 * @throws JMSException
	 */
	@Test
	public void testQueueBrowser() throws NamingException, JMSException{
		QueuePoller poller = applicationContext.getBean(QueuePoller.class);
		Collection<Collection<MessageVO>> endBatches = new ArrayList<Collection<MessageVO>>();
		
		for(int i=0;i<noOfBatches;i++){
			String correlationId = nextCorrelationId();
			Collection<MessageVO> messages = getMessageBatch(correlationId);
			Collection<MessageVO> startBatch = new ArrayList<MessageVO>();
			ArrayList<MessageVO> endBatch = new ArrayList<MessageVO>();
			endBatches.add(endBatch);
			splitBatchIntoStartAndEnd(messages, startBatch, endBatch);
			assertEquals("End batch should only contain one",endBatch.size(),1);
			assertEquals("Start batch should contain "+(NO_OF_MESSAGES_IN_BATCH-1 )+" messages",NO_OF_MESSAGES_IN_BATCH-1,startBatch.size());	
			
			sendMessages(startBatch);
		}
		
		pause(1000,"Waiting for messages to be consumed");
		assertEquals(3, poller.getNoOfPartialBatchesAvailable());
		
		for(Collection<MessageVO> endBatch: endBatches){		
			sendMessages(endBatch);
		}
		
		pause(5000,"Waiting for messages to be consumed");
		assertEquals(0, poller.getNoOfPartialBatchesAvailable());
		
	}
	


	private void splitBatchIntoStartAndEnd(Collection<MessageVO> messages,Collection<MessageVO> startBatch, Collection<MessageVO> endBatch) {
		int idx=0;
		int indexOfLastMessage=(messages.size()-1);
		for(MessageVO vo: messages){
			if(idx == indexOfLastMessage){
				endBatch.add(vo);
			}else{
				startBatch.add(vo);
			}
			idx++;
		}
	}



	private Collection<MessageVO> getMessageBatch(String correlationId) {
		List<MessageVO> batch = new ArrayList<MessageVO>();
		for(int index=1;index<=NO_OF_MESSAGES_IN_BATCH;index++){
			String messageText = "<item id='"+index+"' />";
			MessageVO vo = new MessageVO(correlationId,NO_OF_MESSAGES_IN_BATCH,index,messageText);
			batch.add(vo);
		}
		Collections.shuffle(batch,RANDOM);
		return batch;
	}


	


	private ApplicationContext getApplicationContext() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-services.xml");
		return ctx;
	}


	private void pause(long timeToWait, String message) {
		log.info(message);
		try {
			Thread.sleep(timeToWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}


	/**
	 * Sends a batch of messages to the queue.
	 * If batchType = BatchType.Full all n messages are sent
	 * If batchType = BatchType.Beginning, n-1 message sent
	 * If batchType = BatchType.End, just the last message is sent
	 * @param batchType
	 * @param correlationId
	 * @return
	 * @throws NamingException
	 * @throws JMSException
	 */
	public void sendMessages(Collection<MessageVO> messageVOs) throws NamingException, JMSException{
		
		for(MessageVO vo: messageVOs){
			TextMessage message = qSession.createTextMessage();
			message.setText(vo.getMessageText());
			message.setIntProperty(Constants.POSITION_IN_BATCH_HEADER_NAME, vo.getPositionInBatch());
			message.setIntProperty(Constants.BATCH_SIZE_HEADER_NAME,vo.getNoInBatch());
			message.setJMSCorrelationID(vo.getCorrelationId());
			log.debug("sending message to queue: "+message);
			sender.send(message);
		}
		log.info("Sent "+NO_OF_MESSAGES_IN_BATCH+" messages to queue");
	}
	
	public static String nextCorrelationId() {
		return Long.toHexString(random.nextLong());
	}

	@Before
	public void init() throws NamingException, JMSException{
		queue = jmsUtils.getInboundQueue();
		log.info("retrived queue: "+queue.getQueueName());		
		qSession = jmsUtils.getQueueSession(queue);
		sender = qSession.createSender(queue);
	}
	
}

