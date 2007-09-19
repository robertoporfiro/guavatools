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
	
	public String hello(String name) {
		String user = jwsContext.getCallerPrincipal().getName();
		String greeting = "HelloWS.hello('" + name + "'); user=" + user;
		System.out.println(greeting);
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new IllegalArgumentException(name + " must start with upper case letter");
		}
		return greeting;
	}
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
	@Policy(uri = "./AuthSAML.xml", direction = Policy.Direction.inbound, attachToWsdl = true)
	public String samlHello(String name) {
		String user = jwsContext.getCallerPrincipal().getName();
		String greeting = "HelloWS.samlHello('" + name + "'); user=" + user;
		System.out.println(greeting);
		return greeting;
	}
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
	// @Policy(uri="policy:Encrypt.xml", direction = Policy.Direction.inbound)
	@Policy(uri="./EncryptName.xml", direction = Policy.Direction.inbound)
	public String secretHello(String name) {
		String action = "HelloWS.secretHello('" + name + "')";
		System.out.println(action);
		return action;
	}
	@Policy(uri="policy:Auth.xml", direction = Policy.Direction.inbound)
	public String authHello(String name) {
		String action = "HelloWS.authHello('" + name + "')";
		System.out.println(action);
		return action;
	}
	@Policy(uri="policy:Sign.xml", direction = Policy.Direction.inbound)
	public String signHello(String name) {
		String action = "HelloWS.signHello('" + name + "')";
		System.out.println(action);
		return action;
	}
}