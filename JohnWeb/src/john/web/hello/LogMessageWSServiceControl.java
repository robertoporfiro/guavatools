package john.web.hello;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

// @ServiceControl.Location(urls = {"http://localhost:7021/JohnWS/LogMessageWS"})
@ServiceControl.Location(urls = {"http://localhost:7091/JohnEjbProxy"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/hello/LogMessageWS.wsdl", service = "LogMessageWSService")
@ControlExtension
public interface LogMessageWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public void logMessage(java.lang.String message_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}