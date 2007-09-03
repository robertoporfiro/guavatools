package john.web.servicecatalog;

import javax.servlet.http.HttpSession;

/*!
import john.ws.servicecatalog.PackageBean;
import john.ws.servicecatalog.ServiceBean;
*/
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.controls.api.bean.Control;

import com.zurich.ep.catalog.PackageBean;
import com.zurich.ep.catalog.ServiceBean;

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
@Jpf.Controller(simpleActions = { @Jpf.SimpleAction(name = "begin", path = "index.jsp") })
public class ServiceCatalogController extends PageFlowController {
	private static final long serialVersionUID = 175310369L;
	private String currentServiceName;
	private String currentPackageName;
	private String controllerStatus = "";

	@Control
	private CatalogServiceControl serviceCatalogWSServiceControl;

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "service.jsp") })
	public Forward selectService() {
		controllerStatus = "";
		Forward forward = new Forward("success");
		currentServiceName = getRequest().getParameter("serviceName");
		System.out.println("currentServiceName=" + currentServiceName);
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", action = "begin") })
	public Forward home() {
		controllerStatus = "";
		Forward forward = new Forward("success");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward selectPackage() {
		controllerStatus = "";
		Forward forward = new Forward("success");
		currentPackageName = getRequest().getParameter("packageName");
		return forward;
	}

	@Jpf.Action(forwards = { @Jpf.Forward(name = "success", path = "index.jsp") })
	public Forward refreshServiceCatalog() {
		controllerStatus = "";
		Forward forward = new Forward("success");
		serviceCatalogWSServiceControl.reloadCatalog();
		return forward;
	}

	public String getControllerStatus() {
		return controllerStatus;
	}

	/**
	 * Callback that is invoked when this controller instance is created.
	 */
	@Override
	protected void onCreate() {
		currentPackageName = serviceCatalogWSServiceControl.reloadCatalog();
	}
	/**
	 * Callback that is invoked when this controller instance is destroyed.
	 */
	@Override
	protected void onDestroy(HttpSession session) {
	}
	public ServiceBean getCurrentService() {
		if (currentServiceName == null) {
			return null;
		}
		return serviceCatalogWSServiceControl.getService(currentServiceName);
	}
	public PackageBean[] getCurrentPackageHierarchy() {
		return serviceCatalogWSServiceControl.getPackageHierarchy(currentPackageName);
	}
	public PackageBean[] getCurrentMemberPackages() {
		return serviceCatalogWSServiceControl.getMemberPackages(currentPackageName);
	}
	public ServiceBean[] getCurrentMemberServices() {
		return serviceCatalogWSServiceControl.getMemberServices(currentPackageName);
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