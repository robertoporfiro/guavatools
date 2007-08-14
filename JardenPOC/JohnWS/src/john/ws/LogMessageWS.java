package john.ws;

import java.util.Date;

import javax.jws.*;

import weblogic.jws.Policy;
import weblogic.jws.Transactional;
import org.apache.beehive.controls.api.bean.Control;
import john.db.LogMessageDB;

@WebService
public class LogMessageWS {

	@Control
	private LogMessageDB logMessageDB;

	@WebMethod
	@Transactional(value=true)
	@Oneway()
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
	@Transactional(value = true)
	@Policy(uri="AuthSAML.xml")
	@Oneway()
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