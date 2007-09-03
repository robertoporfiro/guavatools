package john.ws;

import java.util.Date;

import javax.jws.*;

import john.db.LogMessageDB;

import weblogic.jws.Context;
import weblogic.jws.Policy;
import weblogic.wsee.jws.JwsContext;
import weblogic.jws.Transactional;
import org.apache.beehive.controls.api.bean.Control;

@WebService
public class HelloWS {
	@Context
	JwsContext jwsContext;
	@Control
	private LogMessageDB logMessageDB;
	
	@WebMethod
	public String hello(String name) {
		String user = jwsContext.getCallerPrincipal().getName();
		String greeting = "HelloWS.hello('" + name + "'); user=" + user;
		System.out.println(greeting);
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new IllegalArgumentException(name + " must start with upper case letter");
		}
		return greeting;
	}
	@WebMethod
	public String longHello(String name, int delay) {
		String greeting = "HelloWS.longHello('" + name + "', " + delay + ")";
		System.out.println(greeting);
		try {
			Thread.sleep(delay * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("HelloWS.longHello delay completed");
		return greeting;
	}
	@WebMethod
	@Policy(uri = "./AuthSAML.xml", direction = Policy.Direction.inbound, attachToWsdl = true)
	public String samlHello(String name) {
		String user = jwsContext.getCallerPrincipal().getName();
		String greeting = "HelloWS.samlHello('" + name + "'); user=" + user;
		System.out.println(greeting);
		return greeting;
	}
	@WebMethod
	@Transactional(value=true)
	public String logMessage(String message) {
		String request = "HelloWS.logMessage('" + message + "')";
		System.out.println(request);
		logMessageDB.logMessage(message, new Date());
		if (!Character.isUpperCase(message.charAt(0))) {
			throw new IllegalArgumentException(message + " must start with upper case letter");
		}
		return request;
	}
}