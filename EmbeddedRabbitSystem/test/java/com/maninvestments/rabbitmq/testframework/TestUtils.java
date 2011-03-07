package com.maninvestments.rabbitmq.testframework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * Contains a set of generic utilities for testing Rabbit
 * @author denny
 *
 */
public class TestUtils {
	
	private static Logger log = Logger.getLogger(TestUtils.class.getName());

	/**
	 * Keeps running a method until it either returns the desired result, or until the number of iterations is reached
	 * Pauses for a second between each iteration
	 * @param method
	 * @param iterationsToWait
	 * @param targetObject 
	 * @param Not yet complete text 
	 * @param completed text
	 * @return
	 * @throws BrokerProcessException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static boolean rerunTestMethodUntilTrue(Object targetObject, Method method, boolean expectedResult, int iterationsToWait, String notYetCompleteText, String completeText) throws BrokerProcessException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		int iteration = 0;
		boolean actualResult = (Boolean) method.invoke(targetObject);
		while((actualResult != expectedResult )&& iteration < iterationsToWait){
			log.info(notYetCompleteText+".Will check again in 1 second");
			pause(1000);
			actualResult = (Boolean) method.invoke(targetObject);
			log.info("Broker running state: "+actualResult);
			iteration ++;
		}
		if(actualResult != expectedResult){
			throw new BrokerProcessException("Unable to complete task:["+completeText+"]. After waiting "+iterationsToWait+" seconds");
		}
		return actualResult;
	}

	/**
	 * Forget about those pesky interrupted exceptions-
	 * @param timeToPause
	 */
	public static void pause(long timeToPause) {
		try {
			Thread.sleep(timeToPause);
		} catch (InterruptedException e) {
			//ignore
		}		
	}

	static String getLocalHostName() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hostName = address.getHostName();
		RabbitHelper.log.info("Using hostName: "+hostName);
		return hostName;
	}

}
