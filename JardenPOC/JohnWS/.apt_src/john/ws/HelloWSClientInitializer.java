
package john.ws;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class HelloWSClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _logMessageDBField;
    static
    {
        try
        {
            _logMessageDBField = john.ws.HelloWS.class.getDeclaredField("logMessageDB");
            _logMessageDBField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    john.ws.HelloWS client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = "logMessageDB";
            john.db.LogMessageDBBean _logMessageDB = (cbc == null ? null : (john.db.LogMessageDBBean)cbc.getBean(__bc_id));
            if (_logMessageDB == null)
            _logMessageDB = (john.db.LogMessageDBBean) Controls.instantiate(john.db.LogMessageDBBean.class, getAnnotationMap(cbc, _logMessageDBField), cbc, __bc_id );
            
            
            _logMessageDBField.set(client, _logMessageDB);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, john.ws.HelloWS client)
    {
        
        initializeFields( cbc, client );
    }
}
