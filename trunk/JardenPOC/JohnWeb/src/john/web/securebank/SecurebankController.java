package john.web.securebank;

import javax.servlet.http.HttpSession;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class SecurebankController extends PageFlowController {
	private static final long serialVersionUID = -601203117L;
	@Control
	private SecureBankWSServiceControl secureBankWSServiceControl;

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp", actionOutputs = { @Jpf.ActionOutput(name = "getBalanceResult", type = java.lang.Double.class) }) })
	public Forward getBalance(GetBalanceFormBean form)
			throws john.ws.bank.BankException {
		Forward forward = new Forward("success");
		java.lang.String userName_arg = form.getUserName_arg();
		java.lang.String password_arg = form.getPassword_arg();
		double getBalanceResult = secureBankWSServiceControl.getBalance(
				userName_arg, password_arg);
		forward.addActionOutput("getBalanceResult", getBalanceResult);
		return forward;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
	}

	/**
	 * Callback that is invoked when this controller instance is destroyed.
	 */
	@Override
	protected void onDestroy(HttpSession session) {
	}

	@Jpf.FormBean
	public static class GetBalanceFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -155919409L;
	
		private java.lang.String userName_arg;
	
		private java.lang.String password_arg;
	
		public GetBalanceFormBean() {
		}
	
		public java.lang.String getUserName_arg() {
			return userName_arg;
		}
	
		public void setUserName_arg(java.lang.String userName_arg) {
			this.userName_arg = userName_arg;
		}
	
		public java.lang.String getPassword_arg() {
			return password_arg;
		}
	
		public void setPassword_arg(java.lang.String password_arg) {
			this.password_arg = password_arg;
		}
	}
}