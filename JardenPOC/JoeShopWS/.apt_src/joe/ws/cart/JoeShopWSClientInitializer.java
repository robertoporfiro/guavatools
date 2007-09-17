
package joe.ws.cart;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class JoeShopWSClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _productWSServiceControlField;
    static final Field _bankWSServiceControlField;
    static
    {
        try
        {
            _productWSServiceControlField = joe.ws.cart.JoeShopWS.class.getDeclaredField("productWSServiceControl");
            _productWSServiceControlField.setAccessible(true);
            _bankWSServiceControlField = joe.ws.cart.JoeShopWS.class.getDeclaredField("bankWSServiceControl");
            _bankWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    joe.ws.cart.JoeShopWS client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = "productWSServiceControl";
            joe.ws.cart.ProductWSServiceControlBean _productWSServiceControl = (cbc == null ? null : (joe.ws.cart.ProductWSServiceControlBean)cbc.getBean(__bc_id));
            if (_productWSServiceControl == null)
            _productWSServiceControl = (joe.ws.cart.ProductWSServiceControlBean) Controls.instantiate(joe.ws.cart.ProductWSServiceControlBean.class, getAnnotationMap(cbc, _productWSServiceControlField), cbc, __bc_id );
            
            
            _productWSServiceControlField.set(client, _productWSServiceControl);
            __bc_id = "bankWSServiceControl";
            joe.ws.cart.BankWSServiceControlBean _bankWSServiceControl = (cbc == null ? null : (joe.ws.cart.BankWSServiceControlBean)cbc.getBean(__bc_id));
            if (_bankWSServiceControl == null)
            _bankWSServiceControl = (joe.ws.cart.BankWSServiceControlBean) Controls.instantiate(joe.ws.cart.BankWSServiceControlBean.class, getAnnotationMap(cbc, _bankWSServiceControlField), cbc, __bc_id );
            
            
            _bankWSServiceControlField.set(client, _bankWSServiceControl);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, joe.ws.cart.JoeShopWS client)
    {
        
        initializeFields( cbc, client );
    }
}
