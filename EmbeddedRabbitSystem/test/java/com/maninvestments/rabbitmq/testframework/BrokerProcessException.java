package com.maninvestments.rabbitmq.testframework;

/**
 * Wrapper class around all broker-specific exceptions
 * @author denny
 *
 */
public class BrokerProcessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BrokerProcessException() {
		super();
	}

	public BrokerProcessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BrokerProcessException(String arg0) {
		super(arg0);
	}

	public BrokerProcessException(Throwable arg0) {
		super(arg0);
	}

}
