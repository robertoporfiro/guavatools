package john.web.jms;

import javax.servlet.http.HttpSession;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class JmsController extends PageFlowController {
	private static final long serialVersionUID = -1280655305L;
	@Control
	private LogMessageJmsWSServiceControl logMessageJmsWSServiceControl;
	@Control
	private HelloJmsWSServiceControl helloJmsWSServiceControl;

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward logMessage(LogMessageFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String message_arg = form.getMessage_arg();
		logMessageJmsWSServiceControl.logMessage(message_arg);
		return forward;
	}
	public String getEndpoint() {
		return logMessageJmsWSServiceControl.getEndpointAddress();
	}
	public String getHelloEndpoint() {
		return helloJmsWSServiceControl.getEndpointAddress();
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setEndpointAddress(SetEndpointAddressFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String p0 = form.getP0();
		logMessageJmsWSServiceControl.setEndpointAddress(p0);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "helloJms.jsp") })
	public Forward goToHelloJms() {
		Forward forward = new Forward("success");
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward home() {
		Forward forward = new Forward("success");
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "helloJms.jsp", actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward hello(HelloFormBean form) {
		Forward forward = new Forward("success");
		java.lang.String name_arg = form.getName_arg();
		java.lang.String helloResult = helloJmsWSServiceControl.hello(name_arg);
		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}
	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "helloJms.jsp") })
	public Forward setEndpointAddress1(SetEndpointAddress1FormBean form) {
		Forward forward = new Forward("success");
		java.lang.String p0 = form.getP0();
		helloJmsWSServiceControl.setEndpointAddress(p0);
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
	public static class LogMessageFormBean implements java.io.Serializable {
		private static final long serialVersionUID = -841520311L;
	
		private java.lang.String message_arg;
	
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
	public static class SetEndpointAddressFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1184548068L;
	
		private java.lang.String p0;
	
		public SetEndpointAddressFormBean() {
		}
	
		public java.lang.String getP0() {
			return p0;
		}
	
		public void setP0(java.lang.String p0) {
			this.p0 = p0;
		}
	}

	@Jpf.FormBean
	public static class HelloFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1495379386L;
	
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
	public static class SetEndpointAddress1FormBean implements java.io.Serializable {
		private static final long serialVersionUID = -991913277L;
	
		private java.lang.String p0;
	
		public SetEndpointAddress1FormBean() {
		}
	
		public java.lang.String getP0() {
			return p0;
		}
	
		public void setP0(java.lang.String p0) {
			this.p0 = p0;
		}
	}
}