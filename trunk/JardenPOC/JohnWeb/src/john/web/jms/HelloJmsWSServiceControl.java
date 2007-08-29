package john.web.jms;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"jms://10.160.2.94:7041/JohnWS/HelloJmsWS?URI=jms.johnHelloQ&FACTORY=javax.jms.QueueConnectionFactory"})
@ServiceControl.JmsSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/jms/HelloJms.wsdl", service = "HelloJmsWSService")
@ControlExtension
public interface HelloJmsWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public java.lang.String hello(java.lang.String name_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}