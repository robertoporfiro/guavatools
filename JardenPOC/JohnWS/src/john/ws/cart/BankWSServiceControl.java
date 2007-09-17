package john.ws.cart;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/BankWS"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/ws/cart/Bank.wsdl", service = "BankWSService")
@ControlExtension
public interface BankWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public int changePassword(java.lang.String userName_arg,java.lang.String oldPassword_arg,java.lang.String newPassword_arg);

    public double getBalance(java.lang.String userName_arg,java.lang.String password_arg);

    public john.db.JohnLogVO[] getTransactionLog(java.lang.String userName_arg,java.lang.String password_arg);

    public double transfer(java.lang.String fromName_arg,java.lang.String password_arg,java.lang.String toName_arg,double amount_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}