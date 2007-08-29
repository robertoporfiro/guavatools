
package john.web.bank;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class BankControllerClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _bankWSServiceControlField;
    static
    {
        try
        {
            _bankWSServiceControlField = john.web.bank.BankController.class.getDeclaredField("bankWSServiceControl");
            _bankWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    john.web.bank.BankController client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = client.getClass() + "@" + client.hashCode() + ".john.web.bank.BankWSServiceControl.bankWSServiceControl";
            john.web.bank.BankWSServiceControlBean _bankWSServiceControl = (cbc == null ? null : (john.web.bank.BankWSServiceControlBean)cbc.getBean(__bc_id));
            if (_bankWSServiceControl == null)
            _bankWSServiceControl = (john.web.bank.BankWSServiceControlBean) Controls.instantiate(john.web.bank.BankWSServiceControlBean.class, getAnnotationMap(cbc, _bankWSServiceControlField), cbc, __bc_id );
            
            
            _bankWSServiceControlField.set(client, _bankWSServiceControl);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, john.web.bank.BankController client)
    {
        
        initializeFields( cbc, client );
    }
}
