package org.guavatools.jms.aggregator;

import java.util.HashSet;
import java.util.Set;


public class BatchMetaData {
	
	private String correlationId;
	private int batchSize;
	private Set<Integer> chunkIds = new HashSet<Integer>();
	
	
	
	
	
	public BatchMetaData(String correlationId) {
		this.correlationId = correlationId;
	}

	public boolean isFullBatchAvailable(){
		return chunkIds.size() >=batchSize;
	}
	
	public void addAvailableChunkId(int chunkId){
		this.chunkIds.add(chunkId);
	}
	
	
	
	
	
	
	
	
	
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public int getAvailableForConsumption() {
		return this.chunkIds.size();
	}
	

	
	
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof BatchMetaData)){
			return false;
		}
		BatchMetaData other = (BatchMetaData) obj;
		return other.getCorrelationId().equals(this.correlationId);
	}
	@Override
	public int hashCode() {
		return correlationId.hashCode();
	}
	
}

