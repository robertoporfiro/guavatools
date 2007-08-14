package john.web.wsclient;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import john.client.HelloWS;
import john.client.HelloWSService;
import john.client.HelloWSService_Impl;

import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class WsclientController extends PageFlowController {
	private static final long serialVersionUID = 742613011L;
	// private String endpoint = "http://localhost:7091/HelloProxy"; 
	private String endpoint = "http://localhost:7041/JohnWS/HelloWS";
	private HelloWS port;
	
	public String getEndpoint() {
		return endpoint;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp",
			actionOutputs = { @Jpf.ActionOutput(name = "helloResult", type = java.lang.String.class) }) })
	public Forward hello(HelloFormBean form) {
		Forward forward = new Forward("success");
		String name = form.getName();
		
		if (name.trim().length() == 0) {
			SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMMdd-HH:mm:ss");
			name = "John-" + dateFormat2.format(new Date());
		}
		String helloResult;
		try {
			helloResult = port.hello(name);
		} catch (RemoteException e) {
			helloResult = "exception calling port.hello: " + e;
			e.printStackTrace();
		}

		forward.addActionOutput("helloResult", helloResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward setEndpoint(EndpointFormBean form) {
		Forward forward = new Forward("success");
		endpoint = form.getEndpoint();
		onCreate();
		return forward;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
		try {
			HelloWSService service = new HelloWSService_Impl(endpoint + "?WSDL");
			port = service.getHelloWSSoapPort();
		} catch (ServiceException e) {
			e.printStackTrace();
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
		private static final long serialVersionUID = 1L;
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	@Jpf.FormBean
	public static class EndpointFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1L;
		private String endpoint;
		public String getEndpoint() {
			return endpoint;
		}
		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}
	}
}