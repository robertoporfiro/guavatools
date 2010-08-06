package jms.browser;

import java.io.Serializable;


/**
 * holds the meta data about a destination
 * @author peet.denny
 *
 */
public class DestinationInfo implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	public enum DestinationType {
		Queue,
		Topic
	}
	private String serverUrl;
	private String destinationName;
	private String confacName;
	private DestinationType destinationType;
	
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getConfacName() {
		return confacName;
	}
	public void setConfacName(String confacName) {
		this.confacName = confacName;
	}
	public DestinationType getDestinationType() {
		return destinationType;
	}
	public void setDestinationType(DestinationType destinationType) {
		this.destinationType = destinationType;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(! (obj instanceof DestinationInfo)){
			return false;
		}
		DestinationInfo info = (DestinationInfo) obj;
		return  info.getConfacName().equals(confacName) &&
				info.getDestinationName().equals(destinationName) &&
				info.getDestinationType().equals(destinationType) &&
				info.getServerUrl().equals(serverUrl);
	}
	@Override
	public int hashCode() {
		return	confacName.hashCode() &
				destinationName.hashCode() &
				destinationType.hashCode() &
				serverUrl.hashCode();
	}

}

