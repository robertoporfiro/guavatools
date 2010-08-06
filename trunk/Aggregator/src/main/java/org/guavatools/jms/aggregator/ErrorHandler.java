package org.guavatools.jms.aggregator;
import org.apache.log4j.Logger;

/**
 * Abstracts out the error handling process
 * @author peet.denny
 *
 */
public class ErrorHandler {
	private Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * This basic implementation should be extended to do something more meaningful
	 * @param e
	 */
	public void handleError(Exception e) {
		log.error(e);
	}

}

