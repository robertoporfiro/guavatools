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
	public void logMessage(String message) {
		String request = "LogMessageWS.logMessage('" + message + "')";
		System.out.println(request);
		logMessageDB.logMessage(message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}
	
	@WebMethod
	@Transactional(value=true)
	public JohnLogVO getMessage(int ident) {
		String request = "LogMessageWS.getMessage('" + ident + "')";
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
	public int deleteMessage(int ident) {
		String request = "LogMessageWS.deleteMessage('" + ident + "')";
		System.out.println(request);
		return logMessageDB.deleteMessage(ident);
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
	public void secureLogMessage(String message) {
		String method = "LogMessageWS.secureLogMessage('" + message + "')";
		System.out.println(method);
		logMessageDB.logMessage(message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}

}