package john.ws.client;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/CallbackWS"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/ws/client/HelloCallback.wsdl", service = "CallbackWSService")
@ControlExtension
public interface CallbackWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    @ServiceControl.HttpSoapProtocol
    @ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
    @EventSet(unicast=true)
    public interface Callback extends ServiceControl.Callback
    {
        @ServiceControl.ExternalCallbackEvent
        public void helloCallback(java.lang.String reply_arg);
    }


    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.START)
    public void delayedHello(java.lang.String name_arg,int delay_arg);
}