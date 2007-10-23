package john.ws.jms;

import javax.jws.*;

import weblogic.jws.WLJmsTransport;

@WebService(targetNamespace="http://john/ws")
@WLJmsTransport(queue="jms.johnHelloQ", serviceUri = "HelloJmsWS")
public class HelloJmsWS {

	@WebMethod
	public String hello(String name) {
		String greeting = "HelloJmsWS.hello('" + name + "')";
		System.out.println(greeting);
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new IllegalArgumentException(name + " must start with upper case letter");
		}
		return greeting;
	}
}