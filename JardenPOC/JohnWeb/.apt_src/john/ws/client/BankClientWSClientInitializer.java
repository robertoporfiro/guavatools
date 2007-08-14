
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
    static final Field _bankWSServiceControlField;
    static final Field _callbackWSServiceControlField;
    static
    {
        try
        {
            _bankWSServiceControlField = john.ws.client.BankClientWS.class.getDeclaredField("bankWSServiceControl");
            _bankWSServiceControlField.setAccessible(true);
            _callbackWSServiceControlField = john.ws.client.BankClientWS.class.getDeclaredField("callbackWSServiceControl");
            _callbackWSServiceControlField.setAccessible(true);
        }
        catch (NoSuchFieldException __bc_nsfe)
        {
            throw new ExceptionInInitializerError(__bc_nsfe);
        }
    }
    
    public static class BankWSServiceControlCallbackEventAdaptor 
    implements john.ws.client.BankWSServiceControl.Callback, 
    EventAdaptor, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        john.ws.client.BankClientWS __bc_client;
        
        public BankWSServiceControlCallbackEventAdaptor(john.ws.client.BankClientWS client) { __bc_client = client; }
        
        public Object getClient() { return __bc_client; }
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            __bc_client.bankWSServiceControl_Callback_onAsyncFailure(arg0, arg1);
        }
    }
    
    public static class CallbackWSServiceControlCallbackEventAdaptor 
    implements john.ws.client.CallbackWSServiceControl.Callback, 
    EventAdaptor, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        john.ws.client.BankClientWS __bc_client;
        
        public CallbackWSServiceControlCallbackEventAdaptor(john.ws.client.BankClientWS client) { __bc_client = client; }
        
        public Object getClient() { return __bc_client; }
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            __bc_client.callbackWSServiceControl_Callback_onAsyncFailure(arg0, arg1);
        }
        public void helloCallback(java.lang.String reply_arg) 
        {
            __bc_client.callbackWSServiceControl_Callback_helloCallback(reply_arg);
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
            __bc_id = "bankWSServiceControl";
            john.ws.client.BankWSServiceControlBean _bankWSServiceControl = (cbc == null ? null : (john.ws.client.BankWSServiceControlBean)cbc.getBean(__bc_id));
            if (_bankWSServiceControl == null)
            _bankWSServiceControl = (john.ws.client.BankWSServiceControlBean) Controls.instantiate(john.ws.client.BankWSServiceControlBean.class, getAnnotationMap(cbc, _bankWSServiceControlField), cbc, __bc_id );
            _bankWSServiceControl.addCallbackListener(new BankWSServiceControlCallbackEventAdaptor(client));
            
            
            _bankWSServiceControlField.set(client, _bankWSServiceControl);
            __bc_id = "callbackWSServiceControl";
            john.ws.client.CallbackWSServiceControlBean _callbackWSServiceControl = (cbc == null ? null : (john.ws.client.CallbackWSServiceControlBean)cbc.getBean(__bc_id));
            if (_callbackWSServiceControl == null)
            _callbackWSServiceControl = (john.ws.client.CallbackWSServiceControlBean) Controls.instantiate(john.ws.client.CallbackWSServiceControlBean.class, getAnnotationMap(cbc, _callbackWSServiceControlField), cbc, __bc_id );
            _callbackWSServiceControl.addCallbackListener(new CallbackWSServiceControlCallbackEventAdaptor(client));
            
            
            _callbackWSServiceControlField.set(client, _callbackWSServiceControl);
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
