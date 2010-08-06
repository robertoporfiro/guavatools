package org.guavatools.jms.aggregator.processor;
import org.apache.log4j.Logger;
import org.guavatools.jms.aggregator.BatchProcessor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * Creates instances of BatchProcessor for a particular correlationId
 * Uses Spring prototypes and then sets the correlationId
 * @author peet.denny
 *
 */
public class BatchProcessorFactory implements ApplicationContextAware{
	
	private Logger log = Logger.getLogger(BatchProcessorFactory.class);
	

	private ApplicationContext applicationContext;

	
	public BatchProcessor getBatchProcessor(String correlationId) {
		log.debug("creating processor for correlationId "+correlationId);
		BatchProcessor processor = applicationContext.getBean(BatchProcessor.class);
		processor.setCorrelationId(correlationId);
		return processor;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.applicationContext = applicationContext;
		log.info("setting app context");
	}
	
	
	

}

