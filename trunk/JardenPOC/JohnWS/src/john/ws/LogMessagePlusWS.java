package john.ws;

import java.util.Date;

import javax.jws.*;

import weblogic.jws.Policy;
import weblogic.jws.Transactional;
import org.apache.beehive.controls.api.bean.Control;

import john.db.JohnLogVO;
import john.db.LogMessageDB;

@WebService
public class LogMessagePlusWS {

	@Control
	private LogMessageDB logMessageDB;

	@WebMethod
	@Transactional(value=true)
	/**
	 * Write message to a database table, then throw a system exception if the first
	 * letter of message is not upper case.
	 */
	public void logMessage(String owner, String message) {
		String request = "LogMessageWS.logMessage('" + message + "')";
		System.out.println(request);
		logMessageDB.logMessage(owner, message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}
	
	@WebMethod
	@Transactional(value=true)
	public JohnLogVO getMessage(int ident) {
		String request = "LogMessageWS.getMessage(" + ident + ")";
		System.out.println(request);
		return logMessageDB.getMessage(ident);
	}
	
	@WebMethod
	@Transactional(value=true)
	public JohnLogVO[] getAllMessages() {
		String request = "LogMessageWS.getAllMessages()";
		System.out.println(request);
		return logMessageDB.getAllMessages();
	}
	
	@WebMethod
	@Transactional(value=true)
	public JohnLogVO[] getMessagesByOwner(String owner) {
		String request = "LogMessageWS.getMessagesByOwner('" + owner + "')";
		System.out.println(request);
		return logMessageDB.getMessagesByOwner(owner);
	}
	
	@WebMethod
	@Transactional(value=true)
	public int deleteMessage(int ident) {
		String request = "LogMessageWS.deleteMessage(" + ident + ")";
		System.out.println(request);
		return logMessageDB.deleteMessage(ident);
	}
	
	@WebMethod
	@Transactional(value=true)
	public int deleteMessagesByOwner(String owner) {
		String request = "LogMessageWS.deleteMessagesByOwner('" + owner + "')";
		System.out.println(request);
		return logMessageDB.deleteMessagesByOwner(owner);
	}
	
	@WebMethod
	@Transactional(value=true)
	public int deleteAllMessages() {
		String request = "LogMessageWS.deleteAllMessages()";
		System.out.println(request);
		return logMessageDB.deleteAllMessages();
	}
	
	@WebMethod
	@Transactional(value = true)
	@Policy(uri="AuthSAML.xml")
	/**
	 * Same as logMessage, but requires client authentication.
	 */
	public void secureLogMessage(String owner, String message) {
		String method = "LogMessageWS.secureLogMessage('" + owner + "', '" + message + "')";
		System.out.println(method);
		logMessageDB.logMessage(owner, message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}

}