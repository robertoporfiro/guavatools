package org.guavatools.jms.aggregator;


public class MessageVO {
	private String correlationId;
	private int noInBatch;
	private int positionInBatch;
	private String messageText;
	public  MessageVO(String correlationId, int noInBatch, int positionInBatch,String messageText) {
		this.correlationId = correlationId;
		this.noInBatch = noInBatch;
		this.positionInBatch = positionInBatch;
		this.messageText = messageText;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public int getNoInBatch() {
		return noInBatch;
	}
	public void setNoInBatch(int noInBatch) {
		this.noInBatch = noInBatch;
	}
	public int getPositionInBatch() {
		return positionInBatch;
	}
	public void setPositionInBatch(int positionInBatch) {
		this.positionInBatch = positionInBatch;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
}

