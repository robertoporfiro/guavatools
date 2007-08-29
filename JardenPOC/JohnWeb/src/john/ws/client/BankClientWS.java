package john.ws.client;

import javax.jws.*;

import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.controls.api.events.EventHandler;

@WebService
public class BankClientWS {

	@Control
	private BankReliableWSServiceControl bankReliableWSServiceControl;
	@Control
	private DelayedHelloWSServiceControl delayedHelloWSServiceControl;

	@WebMethod
	public void transfer(String fromAccount, String password, String toAccount, double amount) {
		String action = "BankClientWS.transfer('" + fromAccount + "', <password>, '" + toAccount +
			"', " + amount + ")";
		System.out.println(action);
		bankReliableWSServiceControl.transfer(fromAccount, password, toAccount, amount);
		System.out.println("transfer completed");
	}
	@WebMethod
	public void delayedHello(String name, int delay) {
		delayedHelloWSServiceControl.delayedHello(name, delay);
	}
	@WebMethod
	public String hello(String name) {
		return delayedHelloWSServiceControl.hello(name);
	}
	@EventHandler(field = "delayedHelloWSServiceControl",
			eventSet = DelayedHelloWSServiceControl.Callback.class,
			eventName = "helloCallback")
	protected void delayedHelloWSServiceControl_Callback_helloCallback(String reply_arg) {
		System.out.println("BankClientWS.helloCallback('" + reply_arg + "')");
	}
	@EventHandler(field = "delayedHelloWSServiceControl",
			eventSet = DelayedHelloWSServiceControl.Callback.class,
			eventName = "onAsyncFailure")
	protected void delayedHelloWSServiceControl_Callback_onAsyncFailure(String p0, Object[] p1) {
		System.out.println("BankClientWS.callbackWS_onAsyncFailure('" +
				p0 + "', " + p1 + ")");
	}
	@EventHandler(field = "bankReliableWSServiceControl",
			eventSet = BankReliableWSServiceControl.Callback.class,
			eventName = "onAsyncFailure")
	protected void bankReliableWSServiceControl_Callback_onAsyncFailure(String p0, Object[] p1) {
		System.out.println("BankClientWS.bankWS_onAsyncFailure('" +
				p0 + "', " + p1 + ")");
	}
}