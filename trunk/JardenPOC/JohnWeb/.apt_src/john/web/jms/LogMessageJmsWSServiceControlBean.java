
package john.web.jms;

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
public class LogMessageJmsWSServiceControlBean
extends com.bea.control.ServiceControlBean
implements john.web.jms.LogMessageJmsWSServiceControl
{
    static final Method _logMessageMethod;
    static final Method _secureLogMessageMethod;
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
            _logMessageMethod = john.web.jms.LogMessageJmsWSServiceControl.class.getMethod("logMessage", new Class [] {java.lang.String.class});
            _methodParamMap.put(_logMessageMethod, new String [] { "message_arg" });
            _secureLogMessageMethod = john.web.jms.LogMessageJmsWSServiceControl.class.getMethod("secureLogMessage", new Class [] {java.lang.String.class});
            _methodParamMap.put(_secureLogMessageMethod, new String [] { "message_arg" });
            _Callback_onAsyncFailureEvent = john.web.jms.LogMessageJmsWSServiceControl.Callback.class.getMethod("onAsyncFailure", new Class [] {java.lang.String.class, java.lang.Object[].class});
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
    public LogMessageJmsWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, john.web.jms.LogMessageJmsWSServiceControl.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public LogMessageJmsWSServiceControlBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected LogMessageJmsWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
    {
        super(context, id, props, controlClass);
        
        //
        // Register event notifier instances for any EventSets
        //
        setEventNotifier(john.web.jms.LogMessageJmsWSServiceControl.Callback.class, new CallbackNotifier());
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
    * Implements john.web.jms.LogMessageJmsWSServiceControl.logMessage
    */
    public  void logMessage(java.lang.String message_arg) 
    {
        Object [] __bc_argArray = new Object[] { message_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_logMessageMethod, __bc_argArray);
            
            __bc_target.invoke(_logMessageMethod, __bc_argArray)
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
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_logMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements john.web.jms.LogMessageJmsWSServiceControl.secureLogMessage
    */
    public  void secureLogMessage(java.lang.String message_arg) 
    {
        Object [] __bc_argArray = new Object[] { message_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_secureLogMessageMethod, __bc_argArray);
            
            __bc_target.invoke(_secureLogMessageMethod, __bc_argArray)
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
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_secureLogMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
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
    implements john.web.jms.LogMessageJmsWSServiceControl.Callback, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            Throwable __bc_thrown = null;
            
            CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.jms.LogMessageJmsWSServiceControl.Callback.class);
            
            john.web.jms.LogMessageJmsWSServiceControl.Callback __bc_listener = (john.web.jms.LogMessageJmsWSServiceControl.Callback)__bc_notifier.getListener();
            
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
    public synchronized void addCallbackListener(john.web.jms.LogMessageJmsWSServiceControl.Callback listener)
    throws java.util.TooManyListenersException
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.jms.LogMessageJmsWSServiceControl.Callback.class);
        __bc_notifier.addListener(listener);
    }
    
    /**
    * Unregisters an existing listener for Callback events on the bean.
    */
    public synchronized void removeCallbackListener(john.web.jms.LogMessageJmsWSServiceControl.Callback listener)
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.jms.LogMessageJmsWSServiceControl.Callback.class);
        __bc_notifier.removeListener(listener);
    }
    
    /**
    * Returns the  array of registered listeners for Callback events on the bean, or
    * an empty array if no listener has been registered
    */
    public synchronized john.web.jms.LogMessageJmsWSServiceControl.Callback [] getCallbackListeners()
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.jms.LogMessageJmsWSServiceControl.Callback.class);
        john.web.jms.LogMessageJmsWSServiceControl.Callback [] __bc_listeners = new john.web.jms.LogMessageJmsWSServiceControl.Callback[__bc_notifier.getListenerCount()];
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
