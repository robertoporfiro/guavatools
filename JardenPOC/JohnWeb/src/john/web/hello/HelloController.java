package john.web.hello;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class HelloController extends PageFlowController {
	private static final long serialVersionUID = 105559867L;
	@Control
	private HelloWSServiceControl helloWSServiceControl;
	@Control
	private LogMessageWSServiceControl logMessageWSServiceControl;
	private static final String[] endpointNames = {
		"HelloWS", "HelloWS via TCP Monitor", "HelloProxy", "HelloProxyUsingMIProxy", "HelloProxyWithReports"
	};
	private static final String[] endpoints = {
		"http://localhost:7041/JohnWS/HelloWS",
		"http://localhost:8041/JohnWS/HelloWS",
		"http://localhost:7091/HelloProxy",
		"http://localhost:7091/HelloProxyUsingMIProxy",
		"http://localhost:7091/HelloProxyWithReports"
	};
	private Properties endpointProps;
	
	public String[] getEndpointNames() {
		return endpointNames;
	}
	public String getUsername() {
        String userName;
		Principal principal = this.getUserPrincipal();
        if (principal == null) {
            userName = "callerPrincipal is null";
        }
        else {
        	String inRole = this.isUserInRole("jardenRole")?"":"not ";
            userName = principal.getName() + "; user is " + inRole + "in role jarden";
        }
		return userName;
	}
	public String getHelloEndpointAddress() {
		return helloWSServiceControl.getEndpointAddress();
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward hello(HelloFormBean form) {
		Forward forward = new Forward("success");
		String name_arg = form.getName_arg();
		String helloResult = helloWSServiceControl.hello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward samlHello(HelloFormBean form) {
		Forward forward = new Forward("success");
		String name_arg = form.getName_arg();
		String helloResult = helloWSServiceControl.samlHello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward secretHello(HelloFormBean form) {
		Forward forward = new Forward("success");
		String name_arg = form.getName_arg();
		String helloResult = helloWSServiceControl.secretHello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward authHello(john.web.hello.HelloController.HelloFormBean form) {
		Forward forward = new Forward("success");
		String name_arg = form.getName_arg();
		String helloResult = helloWSServiceControl.authHello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward signHello(john.web.hello.HelloController.HelloFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String name_arg = form.getName_arg();
		java.lang.String helloResult = helloWSServiceControl.signHello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward login() {
		Forward forward = new Forward("success");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward logMessage(LogMessageFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String message_arg = form.getMessage_arg();
		boolean rollback = form.isRollback();
		try {
			Context context = new InitialContext();
			UserTransaction userTransaction =
				(UserTransaction)context.lookup("javax.transaction.UserTransaction");
			userTransaction.begin();
			logMessageWSServiceControl.logMessage(message_arg);
			if (rollback) {
				userTransaction.rollback();
				System.out.println("message logged, but transaction rolled back");
			}
			else {
				userTransaction.commit();
				System.out.println("message logged within a committed transaction");
			}
		} catch (Exception e) {
			System.out.println(e);
			Throwable t = e.getCause();
			if (t == null) {
				e.printStackTrace();
			}
			else {
				System.out.println("caused by: ");
				t.printStackTrace();
			}
		}
		return forward;
	
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setEndpoint(HelloController.SetEndpointFormBean form) {
		Forward forward = new Forward("success");
		String endpoint = endpointProps.getProperty(form.getEndpointName());
		helloWSServiceControl.setEndpointAddress(endpoint);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setEndpointAddress2(SetEndpointAddress2FormBean form) {
		Forward forward = new Forward("success");
		java.lang.String p0 = form.getP0();
		helloWSServiceControl.setEndpointAddress(p0);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setMessage() {
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMMdd-HH:mm:ss");
		String name = "John-" + dateFormat2.format(new Date());
		HelloFormBean form = new HelloFormBean();
		form.setName_arg(name);
		Forward forward = new Forward("success", form);
		return forward;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
		this.endpointProps = new Properties();
		for (int i = 0; i < endpointNames.length; ++i) {
			endpointProps.put(endpointNames[i], endpoints[i]);
		}
	}

	/**
	 * Callback that is invoked when this controller instance is destroyed.
	 */
	@Override
	protected void onDestroy(HttpSession session) {
	}

	@Jpf.FormBean
	public static class HelloFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -1035060405L;
	
		private java.lang.String name_arg;

		public HelloFormBean() {
		}
	
		public java.lang.String getName_arg() {
			return name_arg;
		}
	
		public void setName_arg(java.lang.String name_arg) {
			this.name_arg = name_arg;
		}
	}

	@Jpf.FormBean
	public static class LogMessageFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -752715788L;
	
		private java.lang.String message_arg;
		private boolean rollback;
	
		public boolean isRollback() {
			return rollback;
		}

		public void setRollback(boolean rollback) {
			this.rollback = rollback;
		}

		public LogMessageFormBean() {
		}
	
		public java.lang.String getMessage_arg() {
			return message_arg;
		}
	
		public void setMessage_arg(java.lang.String message_arg) {
			this.message_arg = message_arg;
		}
	}

	@Jpf.FormBean
	public static class SetEndpointFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -6381583516434024926L;
		private String endpointName;

		public String getEndpointName() {
			return endpointName;
		}

		public void setEndpointName(String endpointName) {
			this.endpointName = endpointName;
		}
	}

	@Jpf.FormBean
	public static class SetEndpointAddress2FormBean implements java.io.Serializable {
		private static final long serialVersionUID = -1136932217L;
	
		private java.lang.String p0;
	
		public SetEndpointAddress2FormBean() {
		}
	
		public java.lang.String getP0() {
			return p0;
		}
	
		public void setP0(java.lang.String p0) {
			this.p0 = p0;
		}
	}

}