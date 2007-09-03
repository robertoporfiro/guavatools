package john.ws.callback;

import javax.jws.*;
import weblogic.jws.CallbackService;
import weblogic.wsee.jws.CallbackInterface;
import weblogic.jws.Callback;
import weblogic.jws.Conversation;
import java.io.Serializable;

@WebService
public class DelayedHelloWS implements Serializable {

	@Callback
	private CallbackSvc callback;
	private static final long serialVersionUID = 1L;

	@WebMethod
	@Oneway
	@Conversation(Conversation.Phase.START)
	public void delayedHello(String name, int delay) {
		String action = "CallbackWS.delayedHello('" + name + "', " + delay + ")";
		System.out.println(action);
		try { Thread.sleep(delay * 1000); }
		catch(InterruptedException ie) { ie.printStackTrace(); }
		callback.helloCallback(action);
		System.out.println("Callback.helloCallback invoked");
	}
	
	@WebMethod
	@Conversation(Conversation.Phase.START)
	public String hello(String name) {
		String greeting = "DelayedHelloWS.hello('" + name + "')";
		System.out.println(greeting);
		if (!Character.isUpperCase(name.charAt(0))) {
			throw new IllegalArgumentException(name + " must start with upper case letter");
		}
		return greeting;
	}

	@CallbackService
	public interface CallbackSvc extends CallbackInterface {
		@WebMethod
		@Conversation(Conversation.Phase.FINISH)
		public void helloCallback(String reply);
	}
}