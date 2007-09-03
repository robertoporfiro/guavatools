package john.ws.jms;

import java.util.Date;

import javax.jws.*;

import john.db.LogMessageDB;

import weblogic.jws.Policy;
import weblogic.jws.Transactional;
import weblogic.jws.WLJmsTransport;
import org.apache.beehive.controls.api.bean.Control;

/**
 * Version of LogMessageJmsWS that uses queue jms.johnDBQ, which is persisted
 * using a JDBC datastore.
 * @author John Denny
 *
 */
@WebService(targetNamespace="http://john/ws")
@WLJmsTransport(queue="jms.johnDBQ", serviceUri = "LogMessageJmsPersistWS",
		connectionFactory = "javax.jms.QueueConnectionFactory")
public class LogMessageJmsPersistWS {

	@Control
	private LogMessageDB logMessageDB;

	@WebMethod
	@Transactional(value = true)
	@Oneway()
	public void logMessage(String message) {
		String method = "LogMessageJmsPersistWS.logMessage('" + message + "'); queue=jms.johnDBQ";
		System.out.println(method);
		logMessageDB.logMessage(message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}
	@WebMethod
	@Transactional(value = true)
	@Policy(uri="policy:Auth.xml")
	@Oneway()
	public void secureLogMessage(String message) {
		String method = "LogMessageJmsWS.secureLogMessage('" + message + "')";
		System.out.println(method);
		logMessageDB.logMessage(message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
	}
}