
package john.ws.client;

import java.lang.reflect.Field;
import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.api.bean.Controls;
import org.apache.beehive.controls.api.versioning.VersionRequired;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.runtime.bean.EventAdaptor;
import org.apache.beehive.controls.runtime.bean.AdaptorPersistenceDelegate;

@SuppressWarnings("all")
public class BankClientWSClientInitializer
extends org.apache.beehive.controls.runtime.bean.ClientInitializer
{
    static final Field _bankReliableWSServiceControlField;
    static final Field _delayedHelloWSServiceControlField;
    static
    {
        try
        {
            _bankReliableWSServiceControlField = john.ws.client.BankClientWS.class.getDeclaredField("bankReliableWSServiceControl");
            _bankReliableWSServiceControlField.setAccessible(true);
            _delayedHelloWSServiceControlField = john.ws.client.BankClientWS.class.getDeclaredField("delayedHelloWSServiceControl");
            _delayedHelloWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    public static class BankReliableWSServiceControlCallbackEventAdaptor 
    implements john.ws.client.BankReliableWSServiceControl.Callback, 
    EventAdaptor, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        john.ws.client.BankClientWS __bc_client;
        
        public BankReliableWSServiceControlCallbackEventAdaptor(john.ws.client.BankClientWS client) { __bc_client = client; }
        
        public Object getClient() { return __bc_client; }
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            __bc_client.bankReliableWSServiceControl_Callback_onAsyncFailure(arg0, arg1);
        }
    }
    
    public static class DelayedHelloWSServiceControlCallbackEventAdaptor 
    implements john.ws.client.DelayedHelloWSServiceControl.Callback, 
    EventAdaptor, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        john.ws.client.BankClientWS __bc_client;
        
        public DelayedHelloWSServiceControlCallbackEventAdaptor(john.ws.client.BankClientWS client) { __bc_client = client; }
        
        public Object getClient() { return __bc_client; }
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            __bc_client.delayedHelloWSServiceControl_Callback_onAsyncFailure(arg0, arg1);
        }
        public void helloCallback(java.lang.String reply_arg) 
        {
            __bc_client.delayedHelloWSServiceControl_Callback_helloCallback(reply_arg);
        }
    }
    
    
    private static void initializeFields(ControlBeanContext cbc,
    john.ws.client.BankClientWS client)
    {
        try
        {
            String __bc_id;
            //
            // Initialize any nested controls used by the client
            //
            __bc_id = "bankReliableWSServiceControl";
            john.ws.client.BankReliableWSServiceControlBean _bankReliableWSServiceControl = (cbc == null ? null : (john.ws.client.BankReliableWSServiceControlBean)cbc.getBean(__bc_id));
            if (_bankReliableWSServiceControl == null)
            _bankReliableWSServiceControl = (john.ws.client.BankReliableWSServiceControlBean) Controls.instantiate(john.ws.client.BankReliableWSServiceControlBean.class, getAnnotationMap(cbc, _bankReliableWSServiceControlField), cbc, __bc_id );
            _bankReliableWSServiceControl.addCallbackListener(new BankReliableWSServiceControlCallbackEventAdaptor(client));
            
            
            _bankReliableWSServiceControlField.set(client, _bankReliableWSServiceControl);
            __bc_id = "delayedHelloWSServiceControl";
            john.ws.client.DelayedHelloWSServiceControlBean _delayedHelloWSServiceControl = (cbc == null ? null : (john.ws.client.DelayedHelloWSServiceControlBean)cbc.getBean(__bc_id));
            if (_delayedHelloWSServiceControl == null)
            _delayedHelloWSServiceControl = (john.ws.client.DelayedHelloWSServiceControlBean) Controls.instantiate(john.ws.client.DelayedHelloWSServiceControlBean.class, getAnnotationMap(cbc, _delayedHelloWSServiceControlField), cbc, __bc_id );
            _delayedHelloWSServiceControl.addCallbackListener(new DelayedHelloWSServiceControlCallbackEventAdaptor(client));
            
            
            _delayedHelloWSServiceControlField.set(client, _delayedHelloWSServiceControl);
        }
        catch (RuntimeException __bc_re) { throw __bc_re; }
        catch (Exception __bc_e)
        {
            __bc_e.printStackTrace();
            throw new ControlException("Initializer failure", __bc_e);
        }
    }
    
    public static void initialize(ControlBeanContext cbc, john.ws.client.BankClientWS client)
    {
        
        initializeFields( cbc, client );
    }
}
