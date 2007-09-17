package john.web.shop;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

// @ServiceControl.Location(urls = {"http://localhost:7041/JoeShopWS/ShopWS"})
@ServiceControl.Location(urls = {"http://localhost:7091/ShoppingCartToJoe"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "john/web/shop/ShoppingCart.wsdl", service = "ShopService")
@ControlExtension
public interface ShopServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.CONTINUE)
    public void addItem(java.lang.String supplier_arg,java.lang.String code_arg,int qty_arg);

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.FINISH)
    public java.lang.String cancelOrder();

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.FINISH)
    public jarden.shop.Invoice confirmOrder() throws john.ws.bank.BankException;

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.CONTINUE)
    public jarden.shop.ProductVO[] getAllProducts();

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.CONTINUE)
    public jarden.shop.Invoice getCart();

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.CONTINUE)
    public java.lang.String getClient();

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.START)
    public void newCart(java.lang.String client_arg);

    @ServiceControl.Conversation(phase = ServiceControl.Conversation.Phase.CONTINUE)
    public boolean setAccount(java.lang.String accountName_arg,java.lang.String accountPassword_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}