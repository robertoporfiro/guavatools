
package john.web.hello;

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
public class HelloWSServiceControlBean
extends com.bea.control.ServiceControlBean
implements john.web.hello.HelloWSServiceControl
{
    static final Method _logMessageMethod;
    static final Method _helloMethod;
    static final Method _longHelloMethod;
    static final Method _samlHelloMethod;
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
            _logMessageMethod = john.web.hello.HelloWSServiceControl.class.getMethod("logMessage", new Class [] {java.lang.String.class});
            _methodParamMap.put(_logMessageMethod, new String [] { "message_arg" });
            _helloMethod = john.web.hello.HelloWSServiceControl.class.getMethod("hello", new Class [] {java.lang.String.class});
            _methodParamMap.put(_helloMethod, new String [] { "name_arg" });
            _longHelloMethod = john.web.hello.HelloWSServiceControl.class.getMethod("longHello", new Class [] {java.lang.String.class, int.class});
            _methodParamMap.put(_longHelloMethod, new String [] { "name_arg", "delay_arg" });
            _samlHelloMethod = john.web.hello.HelloWSServiceControl.class.getMethod("samlHello", new Class [] {java.lang.String.class});
            _methodParamMap.put(_samlHelloMethod, new String [] { "name_arg" });
            _Callback_onAsyncFailureEvent = john.web.hello.HelloWSServiceControl.Callback.class.getMethod("onAsyncFailure", new Class [] {java.lang.String.class, java.lang.Object[].class});
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
    public HelloWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, john.web.hello.HelloWSServiceControl.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public HelloWSServiceControlBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected HelloWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
    {
        super(context, id, props, controlClass);
        
        //
        // Register event notifier instances for any EventSets
        //
        setEventNotifier(john.web.hello.HelloWSServiceControl.Callback.class, new CallbackNotifier());
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
    * Implements john.web.hello.HelloWSServiceControl.logMessage
    */
    public  java.lang.String logMessage(java.lang.String message_arg) 
    {
        Object [] __bc_argArray = new Object[] { message_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        java.lang.String __bc_retval = null;
        
        try
        {
            preInvoke(_logMessageMethod, __bc_argArray);
            
            __bc_retval =
            (java.lang.String)
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
            Object __bc_rv = __bc_retval;
            postInvoke(_logMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.HelloWSServiceControl.hello
    */
    public  java.lang.String hello(java.lang.String name_arg) 
    {
        Object [] __bc_argArray = new Object[] { name_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        java.lang.String __bc_retval = null;
        
        try
        {
            preInvoke(_helloMethod, __bc_argArray);
            
            __bc_retval =
            (java.lang.String)
            __bc_target.invoke(_helloMethod, __bc_argArray)
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
            Object __bc_rv = __bc_retval;
            postInvoke(_helloMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.HelloWSServiceControl.longHello
    */
    public  java.lang.String longHello(java.lang.String name_arg, int delay_arg) 
    {
        Object [] __bc_argArray = new Object[] { name_arg, delay_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        java.lang.String __bc_retval = null;
        
        try
        {
            preInvoke(_longHelloMethod, __bc_argArray);
            
            __bc_retval =
            (java.lang.String)
            __bc_target.invoke(_longHelloMethod, __bc_argArray)
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
            Object __bc_rv = __bc_retval;
            postInvoke(_longHelloMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.HelloWSServiceControl.samlHello
    */
    public  java.lang.String samlHello(java.lang.String name_arg) 
    {
        Object [] __bc_argArray = new Object[] { name_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        java.lang.String __bc_retval = null;
        
        try
        {
            preInvoke(_samlHelloMethod, __bc_argArray);
            
            __bc_retval =
            (java.lang.String)
            __bc_target.invoke(_samlHelloMethod, __bc_argArray)
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
            Object __bc_rv = __bc_retval;
            postInvoke(_samlHelloMethod, __bc_argArray, __bc_rv, __bc_thrown);
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
    implements john.web.hello.HelloWSServiceControl.Callback, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            Throwable __bc_thrown = null;
            
            CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.hello.HelloWSServiceControl.Callback.class);
            
            john.web.hello.HelloWSServiceControl.Callback __bc_listener = (john.web.hello.HelloWSServiceControl.Callback)__bc_notifier.getListener();
            
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
    public synchronized void addCallbackListener(john.web.hello.HelloWSServiceControl.Callback listener)
    throws java.util.TooManyListenersException
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.hello.HelloWSServiceControl.Callback.class);
        __bc_notifier.addListener(listener);
    }
    
    /**
    * Unregisters an existing listener for Callback events on the bean.
    */
    public synchronized void removeCallbackListener(john.web.hello.HelloWSServiceControl.Callback listener)
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.hello.HelloWSServiceControl.Callback.class);
        __bc_notifier.removeListener(listener);
    }
    
    /**
    * Returns the  array of registered listeners for Callback events on the bean, or
    * an empty array if no listener has been registered
    */
    public synchronized john.web.hello.HelloWSServiceControl.Callback [] getCallbackListeners()
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.web.hello.HelloWSServiceControl.Callback.class);
        john.web.hello.HelloWSServiceControl.Callback [] __bc_listeners = new john.web.hello.HelloWSServiceControl.Callback[__bc_notifier.getListenerCount()];
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
