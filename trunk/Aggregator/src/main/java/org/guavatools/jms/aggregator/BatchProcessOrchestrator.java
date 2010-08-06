package org.guavatools.jms.aggregator;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guavatools.jms.aggregator.processor.BatchProcessorFactory;



public class BatchProcessOrchestrator {
	private Logger log = Logger.getLogger(this.getClass().getName());
	private Map<String, BatchProcessor> processorStore = new HashMap<String, BatchProcessor>();
	BatchProcessorFactory batchProcessorFactory;

	

	public BatchProcessor getBatchProcessor(String correlationId) {
		BatchProcessor processor = processorStore.get(correlationId);
		if(processor==null){
			log.info("Creating new batch processor for correlationId: "+correlationId);
			processorStore.put(correlationId, processor);
			processor = batchProcessorFactory.getBatchProcessor(correlationId);
			initialiseProcessor(processor);
		}
		return processor;
	}
	
	
	
	
	private void initialiseProcessor(BatchProcessor processor) {
		Thread t = new Thread(processor);
		t.setName("Batch processor thread: <JMSCorrId="+processor.getCorrelationId()+">");
		t.start();
		log.info("started new Thread for BatchProcessor: "+t.getName());		
	}













	public void setBatchProcessorFactory(BatchProcessorFactory batchProcessorFactory) {
		this.batchProcessorFactory = batchProcessorFactory;
	}















}

