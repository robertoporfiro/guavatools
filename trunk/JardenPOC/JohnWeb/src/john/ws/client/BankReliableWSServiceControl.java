package john.ws.client;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/BankReliableWS"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/ws/client/BankReliableWS.wsdl", service = "BankReliableWSService")
@ControlExtension
public interface BankReliableWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public void transfer(java.lang.String fromName_arg,java.lang.String password_arg,java.lang.String toName_arg,double amount_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}