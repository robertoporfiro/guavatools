
package joe.ws.shop;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class JoeProductWSClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _productDBField;
    static
    {
        try
        {
            _productDBField = joe.ws.shop.JoeProductWS.class.getDeclaredField("productDB");
            _productDBField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    joe.ws.shop.JoeProductWS client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = "productDB";
            joe.ws.shop.ProductDBBean _productDB = (cbc == null ? null : (joe.ws.shop.ProductDBBean)cbc.getBean(__bc_id));
            if (_productDB == null)
            _productDB = (joe.ws.shop.ProductDBBean) Controls.instantiate(joe.ws.shop.ProductDBBean.class, getAnnotationMap(cbc, _productDBField), cbc, __bc_id );
            
            
            _productDBField.set(client, _productDB);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, joe.ws.shop.JoeProductWS client)
    {
        
        initializeFields( cbc, client );
    }
}
