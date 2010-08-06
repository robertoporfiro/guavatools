package org.guavatools.jms.aggregator;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.guavatools.jms.aggregator.writer.MessageWriter;



/**
 * Abstracts out common behavior of the BatchProcessor classes.
 * @author peet.denny
 *
 */
public class BatchProcessor implements Runnable{ 
	
	
	public enum State {
		Waiting,
		Working,
		Completed,
		Error
	}

	protected JMSUtils jmsUtils;
	private State state = State.Waiting;
	private Logger log = Logger.getLogger(this.getClass().getName());
	private ErrorHandler errorHandler;

	private volatile int noOfMessagesProcessed = 0;
	private String correlationId;
	private MessageWriter messageWriter;
	
	
	
	@Override
	public void run(){
		log.debug("running processor for correlationId "+correlationId);
		this.state = State.Working;
		try {
			Queue inboundQueue = jmsUtils.getInboundQueue();
			QueueSession session = jmsUtils.getQueueSession(inboundQueue);
			
			String messageSelector = "JMSCorrelationID='"+correlationId+"'";
			MessageConsumer consumer = session.createConsumer(inboundQueue,messageSelector);
			int messageIndex=1;
			TextMessage mess = (TextMessage) consumer.receiveNoWait();
			if(mess != null){
				messageWriter.start(correlationId);
			}
			else{
				throw new RuntimeException("There should be at least one message on this queue. Found none using message selector: "+messageSelector);
			}
			while(mess != null){
				processMessage(mess,messageIndex++);
				incrementNoOfMessagesProcess();
				mess = (TextMessage) consumer.receiveNoWait();
			}
			messageWriter.end();
		} catch (Exception e) {
			messageWriter.onError(e);
			errorHandler.handleError(e);
			this.state = State.Error;
		}
		this.state = State.Completed;
	}
	
	
	private void incrementNoOfMessagesProcess() {
		noOfMessagesProcessed++;		
	}

	public int getNoOfMessagesProcessed() {
		return noOfMessagesProcessed;
	}

	private void processMessage(TextMessage mess, int index) throws JMSException {
		messageWriter.write(mess.getText(),index);
	}


	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	public State getState(){
		return state;
	}


	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}






	public void setJmsUtils(JMSUtils jmsUtils) {
		this.jmsUtils = jmsUtils;
	}


	public void setMessageWriter(MessageWriter messageWriter) {
		this.messageWriter = messageWriter;
	}

}

