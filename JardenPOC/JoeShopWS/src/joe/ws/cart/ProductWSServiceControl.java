package joe.ws.cart;
import com.bea.control.ServiceControl;

import org.apache.beehive.controls.api.events.EventSet;
import org.apache.beehive.controls.api.bean.ControlExtension;

// @ServiceControl.Location(urls = {"http://localhost:7041/JohnWS/ProductWS"})
@ServiceControl.Location(urls = {"http://localhost:7091/ProductAllShops"})
@ServiceControl.HttpSoapProtocol
@ServiceControl.SOAPBinding(style = ServiceControl.SOAPBinding.Style.DOCUMENT, use = ServiceControl.SOAPBinding.Use.LITERAL, parameterStyle = ServiceControl.SOAPBinding.ParameterStyle.WRAPPED)
@ServiceControl.WSDL(resourcePath = "joe/ws/cart/Product.wsdl", service = "ProductWSService")
@ControlExtension
public interface ProductWSServiceControl extends ServiceControl
{
    static final long serialVersionUID = 1L;

    public john.db.ProductVO[] getAllProducts();

    public john.db.ProductVO[] getMatchingProducts(john.db.ProductVO vo_arg);

    public john.db.ProductVO getProduct(java.lang.String supplier_arg,java.lang.String code_arg);

   /** This event set interface provides support for the onAsyncFailure event.
    */
   @EventSet(unicast=true)
   public interface Callback extends ServiceControl.Callback {};
}