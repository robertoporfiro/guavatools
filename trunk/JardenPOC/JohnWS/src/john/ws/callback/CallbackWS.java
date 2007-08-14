package john.ws.callback;

import javax.jws.*;
import weblogic.jws.CallbackService;
import weblogic.wsee.jws.CallbackInterface;
import weblogic.jws.Callback;
import weblogic.jws.Conversation;
import java.io.Serializable;

@WebService
public class CallbackWS implements Serializable {

	@Callback
	private CallbackSvc callback;
	private static final long serialVersionUID = 1L;

	@WebMethod
	@Oneway
	@Conversation(value=Conversation.Phase.START)
	public void delayedHello(String name, int delay) {
		String action = "CallbackWS.delayedHello('" + name + "', " + delay + ")";
		System.out.println(action);
		try { Thread.sleep(delay * 1000); }
		catch(InterruptedException ie) { ie.printStackTrace(); }
		callback.helloCallback(action);
		System.out.println("Callback.helloCallback invoked");
	}

	@CallbackService
	public interface CallbackSvc extends CallbackInterface {
		@WebMethod
		@Conversation(value=Conversation.Phase.FINISH)
		public void helloCallback(String reply);
	}
}