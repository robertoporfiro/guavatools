package john.web.alsb;

import javax.servlet.http.HttpSession;

import john.sbconfig.ALSBUtils;
import john.sbconfig.EsbQueryResult;

import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.Forward;

/*
 * TODO - search feature, like ALSB console.
 * TODO - provide model answer.
 * typical query received, that should be answered by service catalog:
services
	real: http://10.82.223.20/zfsa/registrant.asmx
	stub: http://10.88.67.70:7301/ZigWebStubWebServices/ZigWebRegistrationService

proxies
	http://syst:8201/ZigWebRegistrationStubProxy route directly to stub service
	http://syst:8201/ZigWebRegistrationStubToRealProxy transform & route to real service
	http://syst:8201/ZigWebRegistrationDynamicProxy
		if header.hint = 'stub'
			route directly to stub service
		else
			transform & route to real service
 */
@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "sbutils.jsp") })
public class AlsbController extends PageFlowController {
	private static final long serialVersionUID = 175310369L;
	private String controllerStatus = "";

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", action = "begin") })
	public Forward home() {
		controllerStatus = "";
		Forward forward = new Forward("success");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "sbutils.jsp", actionOutputs = { @Jpf.ActionOutput(name = "esbQueryResult", type = john.sbconfig.EsbQueryResult[].class) }) })
	public Forward getSBEndpoints(SBConfigFormBean form) {
		controllerStatus = "";
		Forward forward = new Forward("success");
		EsbQueryResult[] esbQueryResult;
		try {
			esbQueryResult = ALSBUtils.getESBConfig(form.alsbName, form.action);
		} catch (Exception e) {
			controllerStatus = e.toString();
			esbQueryResult = new EsbQueryResult[0];
			e.printStackTrace();
		}
		forward.addActionOutput("esbQueryResult", esbQueryResult);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "sbutils.jsp", actionOutputs = { @Jpf.ActionOutput(name = "esbQueryResult", type = john.sbconfig.EsbQueryResult[].class) }) })
	public Forward getInvalidSBEndpoints(SBConfigFormBean form) {
		controllerStatus = "";
		Forward forward = new Forward("success");
		EsbQueryResult[] esbQueryResult;
		try {
			esbQueryResult = ALSBUtils.getInvalidESBConfig(form.alsbName, form.action);
		} catch (Exception e) {
			controllerStatus = e.toString();
			esbQueryResult = new EsbQueryResult[0];
			e.printStackTrace();
		}
		forward.addActionOutput("esbQueryResult", esbQueryResult);
		return forward;
	}
	public String getControllerStatus() {
		return controllerStatus;
	}
	public String[] getAlsbNames() {
		return ALSBUtils.getAlsbNames();
	}
	public String[] getResourceTypes() {
		return ALSBUtils.getResourceTypes();
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
	public static class SBConfigFormBean implements java.io.Serializable {
		private static final long serialVersionUID = 1L;
		private String alsbName;
		private String action;

		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public String getAlsbName() {
			return alsbName;
		}
		public void setAlsbName(String alsbName) {
			this.alsbName = alsbName;
		}
	}
}