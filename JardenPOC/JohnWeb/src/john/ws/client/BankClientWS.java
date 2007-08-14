package john.ws.client;

import javax.jws.*;

import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.controls.api.events.EventHandler;

@WebService
public class BankClientWS {

	@Control
	private BankWSServiceControl bankWSServiceControl;
	@Control
	private CallbackWSServiceControl callbackWSServiceControl;

	@WebMethod
	public void debit(String account, double amount) {
		String action = "BankClientWS.hello('" + account + "', " + amount + ")";
		System.out.println(action);
		bankWSServiceControl.debit(account, amount);
		System.out.println("debit completed");
	}
	@WebMethod
	public void delayedHello(String name, int delay) {
		callbackWSServiceControl.delayedHello(name, delay);
	}
	@EventHandler(field = "callbackWSServiceControl",
			eventSet = CallbackWSServiceControl.Callback.class,
			eventName = "helloCallback")
	protected void callbackWSServiceControl_Callback_helloCallback(String reply_arg) {
		System.out.println("BankClientWS.helloCallback('" + reply_arg + "')");
	}
	@EventHandler(field = "callbackWSServiceControl",
			eventSet = CallbackWSServiceControl.Callback.class,
			eventName = "onAsyncFailure")
	protected void callbackWSServiceControl_Callback_onAsyncFailure(String p0, Object[] p1) {
		System.out.println("BankClientWS.callbackWS_onAsyncFailure('" +
				p0 + "', " + p1 + ")");
	}
	@EventHandler(field = "bankWSServiceControl",
			eventSet = BankWSServiceControl.Callback.class,
			eventName = "onAsyncFailure")
	protected void bankWSServiceControl_Callback_onAsyncFailure(String p0, Object[] p1) {
		System.out.println("BankClientWS.bankWS_onAsyncFailure('" +
				p0 + "', " + p1 + ")");
	}
}