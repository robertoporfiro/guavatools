package john.web.jms;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"jms://10.160.2.94:7041/JohnWS/LogMessageJmsWS?URI=jms.johnQ&FACTORY=javax.jms.QueueConnectionFactory"})
@ServiceControl.JmsSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/jms/LogMessageJms.wsdl", service = "LogMessageJmsWSService")
@ControlExtension
public interface LogMessageJmsWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public void logMessage(java.lang.String message_arg);

    public void secureLogMessage(java.lang.String message_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}