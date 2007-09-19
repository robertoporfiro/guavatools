package john.web.hello;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/HelloWS"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/hello/HelloWS.wsdl", service = "HelloWSService")
@ControlExtension
public interface HelloWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public java.lang.String authHello(java.lang.String name_arg);

    public java.lang.String hello(java.lang.String name_arg);

    public java.lang.String logMessage(java.lang.String message_arg);

    public java.lang.String longHello(java.lang.String name_arg,int delay_arg);

    public java.lang.String samlHello(java.lang.String name_arg);

    public java.lang.String secretHello(java.lang.String name_arg);

    public java.lang.String signHello(java.lang.String name_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}