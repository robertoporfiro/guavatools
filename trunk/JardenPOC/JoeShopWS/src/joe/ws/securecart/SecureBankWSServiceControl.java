package joe.ws.securecart;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

@ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/SecureBankWS"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "joe/ws/securecart/SecureBank.wsdl", service = "SecureBankWSService")
@ControlExtension
public interface SecureBankWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public int changePassword(java.lang.String userName_arg,java.lang.String password_arg,java.lang.String newPassword_arg) throws john.ws.bank.BankException;

    public double getBalance(java.lang.String userName_arg,java.lang.String password_arg) throws john.ws.bank.BankException;

    public john.db.JohnLogVO[] getTransactionLog(java.lang.String userName_arg,java.lang.String password_arg) throws john.ws.bank.BankException;

    public double transfer(java.lang.String fromName_arg,java.lang.String password_arg,java.lang.String toName_arg,double amount_arg) throws john.ws.bank.BankException;

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}