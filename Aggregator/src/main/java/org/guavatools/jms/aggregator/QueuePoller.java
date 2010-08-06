package org.guavatools.jms.aggregator;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.log4j.Logger;


public class QueuePoller {

	private Logger log = Logger.getLogger(this.getClass().getName());
	ErrorHandler errorHandler;
	private long pollFrequency = 10000;
	private JMSUtils jmsUtils;
	private QueueBrowser browser;
	private BatchProcessOrchestrator batchProcessOrchestrator;

	private Map<String, BatchMetaData> metaDataMap;
	private int noOfPartialBatchesAvailable=0;


	
	public int getNoOfPartialBatchesAvailable() {
		return noOfPartialBatchesAvailable;
	}






	public void init() throws NamingException, JMSException{
		Queue queue = jmsUtils.getInboundQueue();
		QueueSession session = jmsUtils.getQueueSession(queue);
		browser = session.createBrowser(queue);
		log.info("init called");
		QueuePollRunnable runnable = new QueuePollRunnable();
		Thread t = new Thread(runnable);
		t.setName("QueuePollerThread");
		t.start();
	}
	
	
	
	public class QueuePollRunnable implements Runnable{

		private boolean showtime = true;
		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			log.debug("starting queuepollrunnable");
			while(showtime){
				try {
					noOfPartialBatchesAvailable=0;
					Enumeration<Object> messageEnum = browser.getEnumeration();
					Collection<BatchMetaData> messages = extractBatchMetaData(messageEnum);
					for(BatchMetaData metaData: messages){
						if(metaData.isFullBatchAvailable()){
							log.debug("found complete batch to process");
							handleFullBatch(metaData);
						}else{
							log.debug("found incomplete batch");
							noOfPartialBatchesAvailable ++;
						}
					}
					
				} catch (JMSException e) {
					errorHandler.handleError(e);
				}
				pause();
			}
			
		}
		
		
		
		
		
		private void handleFullBatch(BatchMetaData metaData) {
			batchProcessOrchestrator.getBatchProcessor(metaData.getCorrelationId());
		}





		private Collection<BatchMetaData> extractBatchMetaData(Enumeration<Object> messageEnum) throws JMSException {
			metaDataMap = new HashMap<String, BatchMetaData>();	// throw records away on every poll
			while(messageEnum.hasMoreElements()){
				TextMessage message = (TextMessage) messageEnum.nextElement();
				String correlationId = message.getJMSCorrelationID();
				int batchSize = message.getIntProperty(Constants.BATCH_SIZE_HEADER_NAME);
				int positionInBatch=message.getIntProperty(Constants.POSITION_IN_BATCH_HEADER_NAME);
				BatchMetaData metaData = metaDataMap.get(correlationId);
				if(metaData == null){
					metaData = new BatchMetaData(correlationId);
					metaData.setBatchSize(batchSize);
					metaDataMap.put(correlationId, metaData);
				}
				metaData.addAvailableChunkId(positionInBatch);
			}
			
			return metaDataMap.values();
		}





		private void pause() {
			try {
				Thread.sleep(pollFrequency);
			} catch (InterruptedException e) {
				//ignore
			}
		}





		public void stopWhatYourDoing(){
			showtime = false;
			log.debug("stopping run thread....");
		}
		
	}
	
	
	
	
	public void setJmsUtils(JMSUtils jmsUtils) {
		this.jmsUtils = jmsUtils;
	}






	public void setPollFrequency(long pollFrequency) {
		this.pollFrequency = pollFrequency;
	}






	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}






	public void setBatchProcessOrchestrator(
			BatchProcessOrchestrator batchProcessOrchestrator) {
		this.batchProcessOrchestrator = batchProcessOrchestrator;
	}


}

