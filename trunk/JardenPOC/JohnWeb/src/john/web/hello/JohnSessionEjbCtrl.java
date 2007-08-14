package john.web.hello;

import org.apache.beehive.controls.system.ejb.SessionEJBControl;
import org.apache.beehive.controls.system.ejb.EJBControl.EJBHome;
import org.apache.beehive.controls.system.ejb.EJBControl.JNDIContextEnv;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ControlExtension
@EJBHome(jndiName = "ejb.JohnSessionEJBRemoteHome")
@JNDIContextEnv(
        contextFactory="weblogic.jndi.WLInitialContextFactory",
        providerURL="t3://localhost:7021",
        principal="weblogic",
        credentials="weblogic")
public interface JohnSessionEjbCtrl extends john.ejb.JohnSessionEJBRemoteHome, // home interface
		john.ejb.JohnSessionEJBRemote, // business interface
		SessionEJBControl // control interface
{
	static final long serialVersionUID = 1L;
}
