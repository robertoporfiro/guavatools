
package john.web.hello;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class HelloControllerClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _helloWSServiceControlField;
    static final Field _logMessageWSServiceControlField;
    static
    {
        try
        {
            _helloWSServiceControlField = john.web.hello.HelloController.class.getDeclaredField("helloWSServiceControl");
            _helloWSServiceControlField.setAccessible(true);
            _logMessageWSServiceControlField = john.web.hello.HelloController.class.getDeclaredField("logMessageWSServiceControl");
            _logMessageWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    john.web.hello.HelloController client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = client.getClass() + "@" + client.hashCode() + ".john.web.hello.HelloWSServiceControl.helloWSServiceControl";
            john.web.hello.HelloWSServiceControlBean _helloWSServiceControl = (cbc == null ? null : (john.web.hello.HelloWSServiceControlBean)cbc.getBean(__bc_id));
            if (_helloWSServiceControl == null)
            _helloWSServiceControl = (john.web.hello.HelloWSServiceControlBean) Controls.instantiate(john.web.hello.HelloWSServiceControlBean.class, getAnnotationMap(cbc, _helloWSServiceControlField), cbc, __bc_id );
            
            
            _helloWSServiceControlField.set(client, _helloWSServiceControl);
            __bc_id = client.getClass() + "@" + client.hashCode() + ".john.web.hello.LogMessageWSServiceControl.logMessageWSServiceControl";
            john.web.hello.LogMessageWSServiceControlBean _logMessageWSServiceControl = (cbc == null ? null : (john.web.hello.LogMessageWSServiceControlBean)cbc.getBean(__bc_id));
            if (_logMessageWSServiceControl == null)
            _logMessageWSServiceControl = (john.web.hello.LogMessageWSServiceControlBean) Controls.instantiate(john.web.hello.LogMessageWSServiceControlBean.class, getAnnotationMap(cbc, _logMessageWSServiceControlField), cbc, __bc_id );
            
            
            _logMessageWSServiceControlField.set(client, _logMessageWSServiceControl);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, john.web.hello.HelloController client)
    {
        
        initializeFields( cbc, client );
    }
}
