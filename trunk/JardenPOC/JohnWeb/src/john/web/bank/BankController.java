package john.web.bank;

import javax.servlet.http.HttpSession;

import john.db.JohnLogVO;
import john.ws.bank.BankException;

import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class BankController extends PageFlowController {
	private static final long serialVersionUID = -272088653L;
	private String statusMessage;
	private String userName;
	private String password;
	@Control
	private BankWSServiceControl bankWSServiceControl;
	
	public String getStatusMessage() {
		return statusMessage;
	}
	public String getUserName() {
		return userName;
	}
	public JohnLogVO[] getTransactionLog() throws BankException {
		JohnLogVO[] transactions = bankWSServiceControl.getTransactionLog(userName, password);
		// if (transactions == null) transactions = new JohnLogVO[0];
		return transactions;
	}
	public double getBalance() throws BankException {
		return bankWSServiceControl.getBalance(userName, password);
	}

	@Jpf.Action(forwards = { 
		@Jpf.Forward(name = "success", path = "bank.jsp"),
		@Jpf.Forward(name = "fail", path = "index.jsp")
	})
	public Forward login(LoginFormBean form) {
		Forward forward = new Forward("success");
		userName = form.getFromName_arg();
		password = form.getPassword_arg();
		statusMessage = "";
		try {
			bankWSServiceControl.getBalance(userName, password);
			return forward;
		} catch (BankException e) {
			statusMessage = e.toString();
			return new Forward("fail");
		}
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward logout() {
		userName = null;
		password = null;
		statusMessage = "";
		Forward forward = new Forward("success");
		return forward;
	}
	@Jpf.Action(forwards = {
			@Jpf.Forward(name = "success", path = "bank.jsp") })
	public Forward transfer(TransferFormBean form) {
		statusMessage = "";
		Forward forward = new Forward("success");
		java.lang.String fromName_arg = userName;
		java.lang.String password_arg = password;
		java.lang.String toName_arg = form.getToName_arg();
		double amount_arg = form.getAmount_arg();
		try {
			bankWSServiceControl.transfer(fromName_arg, password_arg, toName_arg, amount_arg);
		} catch (BankException e) {
			statusMessage = e.toString();
		}
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "bank.jsp")})
	public Forward changePassword(ChangePasswordFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String newPassword = form.getNewPassword_arg();
		int changePasswordResult;
		try {
			changePasswordResult = bankWSServiceControl.changePassword(
					userName, password, newPassword);
			if (changePasswordResult == 0) {
				statusMessage = "password change failed";
			}
			else {
				statusMessage = "password successfully changed";
				password = newPassword;
			}
		} catch (BankException e) {
			statusMessage = "password change exception: " + e;
		}
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
	public static class LoginFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -1060654109L;
	
		private java.lang.String fromName_arg;
	
		private java.lang.String password_arg;
	
		public java.lang.String getFromName_arg() {
			return fromName_arg;
		}
	
		public void setFromName_arg(java.lang.String fromName_arg) {
			this.fromName_arg = fromName_arg;
		}
	
		public java.lang.String getPassword_arg() {
			return password_arg;
		}
	
		public void setPassword_arg(java.lang.String password_arg) {
			this.password_arg = password_arg;
		}
	}

	@Jpf.FormBean
	public static class TransferFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 841754443L;
	
		private java.lang.String fromName_arg;
	
		private double amount_arg;
	
		private java.lang.String toName_arg;
	
		private java.lang.String password_arg;
	
		public TransferFormBean() {
		}
	
		public java.lang.String getFromName_arg() {
			return fromName_arg;
		}
	
		public void setFromName_arg(java.lang.String fromName_arg) {
			this.fromName_arg = fromName_arg;
		}
	
		public double getAmount_arg() {
			return amount_arg;
		}
	
		public void setAmount_arg(double amount_arg) {
			this.amount_arg = amount_arg;
		}
	
		public java.lang.String getToName_arg() {
			return toName_arg;
		}
	
		public void setToName_arg(java.lang.String toName_arg) {
			this.toName_arg = toName_arg;
		}
	
		public java.lang.String getPassword_arg() {
			return password_arg;
		}
	
		public void setPassword_arg(java.lang.String password_arg) {
			this.password_arg = password_arg;
		}
	}

	@Jpf.FormBean
	public static class ChangePasswordFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -868110743L;
	
		private java.lang.String newPassword_arg;
	
		private java.lang.String userName_arg;
	
		private java.lang.String oldPassword_arg;
	
		public ChangePasswordFormBean() {
		}
	
		public java.lang.String getNewPassword_arg() {
			return newPassword_arg;
		}
	
		public void setNewPassword_arg(java.lang.String newPassword_arg) {
			this.newPassword_arg = newPassword_arg;
		}
	
		public java.lang.String getUserName_arg() {
			return userName_arg;
		}
	
		public void setUserName_arg(java.lang.String userName_arg) {
			this.userName_arg = userName_arg;
		}
	
		public java.lang.String getOldPassword_arg() {
			return oldPassword_arg;
		}
	
		public void setOldPassword_arg(java.lang.String oldPassword_arg) {
			this.oldPassword_arg = oldPassword_arg;
		}
	}

}