
package joe.ws.cart;

import java.beans.*;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

import org.apache.beehive.controls.api.bean.*;
import org.apache.beehive.controls.api.context.ControlBeanContext;
import org.apache.beehive.controls.api.properties.PropertyKey;
import org.apache.beehive.controls.api.properties.PropertyMap;
import org.apache.beehive.controls.api.versioning.*;

@SuppressWarnings("all")
public class BankWSServiceControlBean
extends com.bea.control.ServiceControlBean
implements joe.ws.cart.BankWSServiceControl
{
    static final Method _transferMethod;
    static final Method _changePasswordMethod;
    static final Method _getTransactionLogMethod;
    static final Method _getBalanceMethod;
    static final Method _Callback_onAsyncFailureEvent;
    
    //
    // This HashMap will map from a Method to the array of names for parameters of the
    // method.  This is necessary because parameter name data isn't carried along in the
    // class file, but if available can enable ease of use by referencing parameters by
    // the declared name (vs. by index).
    //
    // This map should be read-only after its initialization in the static block, hence
    // using a plain HashMap is thread-safe.
    //
    static HashMap<Method, String []> _methodParamMap = new HashMap<Method, String []>();
    
    static
    {
        try
        {
            _transferMethod = joe.ws.cart.BankWSServiceControl.class.getMethod("transfer", new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class, double.class});
            _methodParamMap.put(_transferMethod, new String [] { "fromName_arg", "password_arg", "toName_arg", "amount_arg" });
            _changePasswordMethod = joe.ws.cart.BankWSServiceControl.class.getMethod("changePassword", new Class [] {java.lang.String.class, java.lang.String.class, java.lang.String.class});
            _methodParamMap.put(_changePasswordMethod, new String [] { "userName_arg", "oldPassword_arg", "newPassword_arg" });
            _getTransactionLogMethod = joe.ws.cart.BankWSServiceControl.class.getMethod("getTransactionLog", new Class [] {java.lang.String.class, java.lang.String.class});
            _methodParamMap.put(_getTransactionLogMethod, new String [] { "userName_arg", "password_arg" });
            _getBalanceMethod = joe.ws.cart.BankWSServiceControl.class.getMethod("getBalance", new Class [] {java.lang.String.class, java.lang.String.class});
            _methodParamMap.put(_getBalanceMethod, new String [] { "userName_arg", "password_arg" });
            _Callback_onAsyncFailureEvent = joe.ws.cart.BankWSServiceControl.Callback.class.getMethod("onAsyncFailure", new Class [] {java.lang.String.class, java.lang.Object[].class});
            _methodParamMap.put(_Callback_onAsyncFailureEvent, new String [] { "arg0", "arg1" });
        }
        catch (NoSuchMethodException __bc_nsme)
        {
            throw new ExceptionInInitializerError(__bc_nsme);
        }
    }
    
    
    
    static
    {
        
    }
    
    
    
    /**
    * This is the public constructor for the class.  A client-defined control ID may
    * be provided.  This ID must be unique within the nesting ControlBeanContext.
    * @param context The containing ControlBeanContext
    * @param id The control identifier (or null to autogenerate a unique value)
    * @param props The initialization Properties for the new instance (or null for defaults)
    */
    public BankWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, joe.ws.cart.BankWSServiceControl.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public BankWSServiceControlBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected BankWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
    {
        super(context, id, props, controlClass);
        
        //
        // Register event notifier instances for any EventSets
        //
        setEventNotifier(joe.ws.cart.BankWSServiceControl.Callback.class, new CallbackNotifier());
    }
    
    
    /**
    * Returns an array of parameter names for the request method, or null if no parameter
    * data is available.
    */
    protected String [] getParameterNames(Method m)
    {
        // Check the local map for operations on this bean type
        if (_methodParamMap.containsKey(m))
        {
            return _methodParamMap.get(m);
        }
        
        // Delegate up if not found locally
        return super.getParameterNames(m);
    }
    
    /**
    * Implements joe.ws.cart.BankWSServiceControl.transfer
    */
    public  double transfer(java.lang.String fromName_arg, java.lang.String password_arg, java.lang.String toName_arg, double amount_arg) throws john.ws.bank.BankException
    {
        Object [] __bc_argArray = new Object[] { fromName_arg, password_arg, toName_arg, amount_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        double __bc_retval = 0.0d;
        
        try
        {
            preInvoke(_transferMethod, __bc_argArray);
            
            __bc_retval =
            (Double)
            __bc_target.invoke(_transferMethod, __bc_argArray)
            ;
        }
        catch (Throwable __bc_t)
        {
            //
            // All exceptions are caught here, so postInvoke processing has visibility into
            // the exception status.  Errors, RuntimExceptions, or declared checked exceptions will
            // be rethrown.
            //
            __bc_thrown = __bc_t;
            
            if (__bc_t instanceof Error) throw (Error)__bc_t;
            else if (__bc_t instanceof RuntimeException) throw (RuntimeException)__bc_t;
            else if (__bc_t instanceof john.ws.bank.BankException) throw (john.ws.bank.BankException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_transferMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.cart.BankWSServiceControl.changePassword
    */
    public  int changePassword(java.lang.String userName_arg, java.lang.String oldPassword_arg, java.lang.String newPassword_arg) throws john.ws.bank.BankException
    {
        Object [] __bc_argArray = new Object[] { userName_arg, oldPassword_arg, newPassword_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        int __bc_retval = 0;
        
        try
        {
            preInvoke(_changePasswordMethod, __bc_argArray);
            
            __bc_retval =
            (Integer)
            __bc_target.invoke(_changePasswordMethod, __bc_argArray)
            ;
        }
        catch (Throwable __bc_t)
        {
            //
            // All exceptions are caught here, so postInvoke processing has visibility into
            // the exception status.  Errors, RuntimExceptions, or declared checked exceptions will
            // be rethrown.
            //
            __bc_thrown = __bc_t;
            
            if (__bc_t instanceof Error) throw (Error)__bc_t;
            else if (__bc_t instanceof RuntimeException) throw (RuntimeException)__bc_t;
            else if (__bc_t instanceof john.ws.bank.BankException) throw (john.ws.bank.BankException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_changePasswordMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.cart.BankWSServiceControl.getTransactionLog
    */
    public  john.db.JohnLogVO[] getTransactionLog(java.lang.String userName_arg, java.lang.String password_arg) throws john.ws.bank.BankException
    {
        Object [] __bc_argArray = new Object[] { userName_arg, password_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        john.db.JohnLogVO[] __bc_retval = null;
        
        try
        {
            preInvoke(_getTransactionLogMethod, __bc_argArray);
            
            __bc_retval =
            (john.db.JohnLogVO[])
            __bc_target.invoke(_getTransactionLogMethod, __bc_argArray)
            ;
        }
        catch (Throwable __bc_t)
        {
            //
            // All exceptions are caught here, so postInvoke processing has visibility into
            // the exception status.  Errors, RuntimExceptions, or declared checked exceptions will
            // be rethrown.
            //
            __bc_thrown = __bc_t;
            
            if (__bc_t instanceof Error) throw (Error)__bc_t;
            else if (__bc_t instanceof RuntimeException) throw (RuntimeException)__bc_t;
            else if (__bc_t instanceof john.ws.bank.BankException) throw (john.ws.bank.BankException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getTransactionLogMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.cart.BankWSServiceControl.getBalance
    */
    public  double getBalance(java.lang.String userName_arg, java.lang.String password_arg) throws john.ws.bank.BankException
    {
        Object [] __bc_argArray = new Object[] { userName_arg, password_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        double __bc_retval = 0.0d;
        
        try
        {
            preInvoke(_getBalanceMethod, __bc_argArray);
            
            __bc_retval =
            (Double)
            __bc_target.invoke(_getBalanceMethod, __bc_argArray)
            ;
        }
        catch (Throwable __bc_t)
        {
            //
            // All exceptions are caught here, so postInvoke processing has visibility into
            // the exception status.  Errors, RuntimExceptions, or declared checked exceptions will
            // be rethrown.
            //
            __bc_thrown = __bc_t;
            
            if (__bc_t instanceof Error) throw (Error)__bc_t;
            else if (__bc_t instanceof RuntimeException) throw (RuntimeException)__bc_t;
            else if (__bc_t instanceof john.ws.bank.BankException) throw (john.ws.bank.BankException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getBalanceMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    
    /**
    * A PropertyKey that can be used to access the controlImplementation property of the
    * BaseProperties PropertySet
    */
    public static final PropertyKey ControlImplementationKey = new PropertyKey(org.apache.beehive.controls.api.properties.BaseProperties.class, "controlImplementation");
    
    public synchronized void setControlImplementation(java.lang.String value)
    {
        
        setControlProperty(ControlImplementationKey, value);
    }
    
    public java.lang.String getControlImplementation()
    {
        return (java.lang.String)getControlProperty(ControlImplementationKey);
    }
    
    
    
    
    /**
    * This inner class implements a simple proxy to deliver Callback events
    * back to a register listener.
    */
    protected class CallbackNotifier
    extends org.apache.beehive.controls.runtime.bean.UnicastEventNotifier
    implements joe.ws.cart.BankWSServiceControl.Callback, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            Throwable __bc_thrown = null;
            
            CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(joe.ws.cart.BankWSServiceControl.Callback.class);
            
            joe.ws.cart.BankWSServiceControl.Callback __bc_listener = (joe.ws.cart.BankWSServiceControl.Callback)__bc_notifier.getListener();
            
            //
            // If an event listener has been registered, then deliver the event
            //
            if (__bc_listener != null)
            {
                Object [] __bc_argArray = new Object[] {arg0, arg1};
                try
                {
                    __bc_listener.onAsyncFailure(arg0, arg1);
                }
                catch (Throwable __bc_t)
                {
                    //
                    // All exceptions are caught here, so postEvent processing has visibility into
                    // the exception status.  Errors, RuntimExceptions, or declared checked exceptions will
                    // be rethrown.
                    //
                    __bc_thrown = __bc_t;
                    
                    if (__bc_t instanceof Error) throw (Error)__bc_t;
                    else if (__bc_t instanceof RuntimeException) throw (RuntimeException)__bc_t;
                    
                    throw new UndeclaredThrowableException(__bc_t);
                }
            }
        }
        
    }
    
    /**
    * Registers a new listener for Callback events on the bean.
    */
    public synchronized void addCallbackListener(joe.ws.cart.BankWSServiceControl.Callback listener)
    throws java.util.TooManyListenersException
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(joe.ws.cart.BankWSServiceControl.Callback.class);
        __bc_notifier.addListener(listener);
    }
    
    /**
    * Unregisters an existing listener for Callback events on the bean.
    */
    public synchronized void removeCallbackListener(joe.ws.cart.BankWSServiceControl.Callback listener)
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(joe.ws.cart.BankWSServiceControl.Callback.class);
        __bc_notifier.removeListener(listener);
    }
    
    /**
    * Returns the  array of registered listeners for Callback events on the bean, or
    * an empty array if no listener has been registered
    */
    public synchronized joe.ws.cart.BankWSServiceControl.Callback [] getCallbackListeners()
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(joe.ws.cart.BankWSServiceControl.Callback.class);
        joe.ws.cart.BankWSServiceControl.Callback [] __bc_listeners = new joe.ws.cart.BankWSServiceControl.Callback[__bc_notifier.getListenerCount()];
        __bc_notifier.getListeners(__bc_listeners);
        return __bc_listeners;
    }
    
    /**
    * The _annotCache maintains a lookup cache from AnnotatedElements to an associated
    * PropertyMap.  This enables these maps to be shared across multiple beans.
    */
    static private HashMap __bc_annotCache = new HashMap();
    
    protected Map getPropertyMapCache() { return __bc_annotCache; }
    
    private static final long serialVersionUID = 1L;
}
