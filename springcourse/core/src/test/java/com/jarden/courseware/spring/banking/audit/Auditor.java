package com.jarden.courseware.spring.banking.audit;


/**
 * Provides basic Auditing functions
 * @author Peet Denny
 *
 */
public class Auditor {

	private static int updateInvocationCounter=0;

	public static int getUpdateInvocations() {
		return updateInvocationCounter;
	}

	public static void incrementUpdateCount() {
		updateInvocationCounter++;
	}

}
