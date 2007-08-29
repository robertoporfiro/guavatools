
package john.web.jms;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class JmsControllerClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _logMessageJmsWSServiceControlField;
    static final Field _helloJmsWSServiceControlField;
    static
    {
        try
        {
            _logMessageJmsWSServiceControlField = john.web.jms.JmsController.class.getDeclaredField("logMessageJmsWSServiceControl");
            _logMessageJmsWSServiceControlField.setAccessible(true);
            _helloJmsWSServiceControlField = john.web.jms.JmsController.class.getDeclaredField("helloJmsWSServiceControl");
            _helloJmsWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    john.web.jms.JmsController client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = client.getClass() + "@" + client.hashCode() + ".john.web.jms.LogMessageJmsWSServiceControl.logMessageJmsWSServiceControl";
            john.web.jms.LogMessageJmsWSServiceControlBean _logMessageJmsWSServiceControl = (cbc == null ? null : (john.web.jms.LogMessageJmsWSServiceControlBean)cbc.getBean(__bc_id));
            if (_logMessageJmsWSServiceControl == null)
            _logMessageJmsWSServiceControl = (john.web.jms.LogMessageJmsWSServiceControlBean) Controls.instantiate(john.web.jms.LogMessageJmsWSServiceControlBean.class, getAnnotationMap(cbc, _logMessageJmsWSServiceControlField), cbc, __bc_id );
            
            
            _logMessageJmsWSServiceControlField.set(client, _logMessageJmsWSServiceControl);
            __bc_id = client.getClass() + "@" + client.hashCode() + ".john.web.jms.HelloJmsWSServiceControl.helloJmsWSServiceControl";
            john.web.jms.HelloJmsWSServiceControlBean _helloJmsWSServiceControl = (cbc == null ? null : (john.web.jms.HelloJmsWSServiceControlBean)cbc.getBean(__bc_id));
            if (_helloJmsWSServiceControl == null)
            _helloJmsWSServiceControl = (john.web.jms.HelloJmsWSServiceControlBean) Controls.instantiate(john.web.jms.HelloJmsWSServiceControlBean.class, getAnnotationMap(cbc, _helloJmsWSServiceControlField), cbc, __bc_id );
            
            
            _helloJmsWSServiceControlField.set(client, _helloJmsWSServiceControl);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, john.web.jms.JmsController client)
    {
        
        initializeFields( cbc, client );
    }
}
