
package john.ws.client;

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
public class DelayedHelloWSServiceControlBean
extends com.bea.control.ServiceControlBean
implements john.ws.client.DelayedHelloWSServiceControl
{
    static final Method _helloMethod;
    static final Method _delayedHelloMethod;
    static final Method _Callback_onAsyncFailureEvent;
    static final Method _Callback_helloCallbackEvent;
    
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
            _helloMethod = john.ws.client.DelayedHelloWSServiceControl.class.getMethod("hello", new Class [] {java.lang.String.class});
            _methodParamMap.put(_helloMethod, new String [] { "name_arg" });
            _delayedHelloMethod = john.ws.client.DelayedHelloWSServiceControl.class.getMethod("delayedHello", new Class [] {java.lang.String.class, int.class});
            _methodParamMap.put(_delayedHelloMethod, new String [] { "name_arg", "delay_arg" });
            _Callback_onAsyncFailureEvent = john.ws.client.DelayedHelloWSServiceControl.Callback.class.getMethod("onAsyncFailure", new Class [] {java.lang.String.class, java.lang.Object[].class});
            _methodParamMap.put(_Callback_onAsyncFailureEvent, new String [] { "arg0", "arg1" });
            _Callback_helloCallbackEvent = john.ws.client.DelayedHelloWSServiceControl.Callback.class.getMethod("helloCallback", new Class [] {java.lang.String.class});
            _methodParamMap.put(_Callback_helloCallbackEvent, new String [] { "reply_arg" });
        }
        catch (NoSuchMethodException __bc_nsme)
        {
            throw new ExceptionInInitializerError(__bc_nsme);
        }
    }
    
    
    private static String[] _Callback_helloCallbackEventInterceptors = {"com.bea.control.interceptors.SecurityInterceptor"};
    
    static
    {
        _Callback_helloCallbackEventInterceptors = org.apache.beehive.controls.runtime.bean.InterceptorUtils.prioritizeInterceptors(_Callback_helloCallbackEventInterceptors);
        
    }
    
    
    
    /**
    * This is the public constructor for the class.  A client-defined control ID may
    * be provided.  This ID must be unique within the nesting ControlBeanContext.
    * @param context The containing ControlBeanContext
    * @param id The control identifier (or null to autogenerate a unique value)
    * @param props The initialization Properties for the new instance (or null for defaults)
    */
    public DelayedHelloWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, john.ws.client.DelayedHelloWSServiceControl.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public DelayedHelloWSServiceControlBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected DelayedHelloWSServiceControlBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
    {
        super(context, id, props, controlClass);
        
        //
        // Register event notifier instances for any EventSets
        //
        setEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class, new CallbackNotifier());
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
    * Implements john.ws.client.DelayedHelloWSServiceControl.hello
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
    * Implements john.ws.client.DelayedHelloWSServiceControl.delayedHello
    */
    public  void delayedHello(java.lang.String name_arg, int delay_arg) 
    {
        Object [] __bc_argArray = new Object[] { name_arg, delay_arg };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_delayedHelloMethod, __bc_argArray);
            
            __bc_target.invoke(_delayedHelloMethod, __bc_argArray)
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
            postInvoke(_delayedHelloMethod, __bc_argArray, __bc_rv, __bc_thrown);
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
    implements john.ws.client.DelayedHelloWSServiceControl.Callback, java.io.Serializable
    {
        private static final long serialVersionUID = 1L;
        
        public void onAsyncFailure(java.lang.String arg0, java.lang.Object[] arg1) 
        {
            Throwable __bc_thrown = null;
            
            CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class);
            
            john.ws.client.DelayedHelloWSServiceControl.Callback __bc_listener = (john.ws.client.DelayedHelloWSServiceControl.Callback)__bc_notifier.getListener();
            
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
        
        public void helloCallback(java.lang.String reply_arg) 
        {
            Throwable __bc_thrown = null;
            
            CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class);
            
            john.ws.client.DelayedHelloWSServiceControl.Callback __bc_listener = (john.ws.client.DelayedHelloWSServiceControl.Callback)__bc_notifier.getListener();
            
            //
            // If an event listener has been registered, then deliver the event
            //
            if (__bc_listener != null)
            {
                Object [] __bc_argArray = new Object[] {reply_arg};
                String __bc_pivotedInterceptor = null;
                try
                {
                    preEvent(_Callback_helloCallbackEvent, __bc_argArray, _Callback_helloCallbackEventInterceptors);
                    __bc_listener.helloCallback(reply_arg);
                }
                catch (org.apache.beehive.controls.spi.svc.InterceptorPivotException __bc_ipe)
                {
                    __bc_pivotedInterceptor = __bc_ipe.getInterceptorName();
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
                finally
                {
                    Object __bc_rv = null;
                    postEvent(_Callback_helloCallbackEvent, __bc_argArray, __bc_rv, __bc_thrown, _Callback_helloCallbackEventInterceptors, __bc_pivotedInterceptor);
                }
            }
        }
        
        private void preEvent(Method method, Object[] argArray, String[] interceptors)
        throws org.apache.beehive.controls.spi.svc.InterceptorPivotException
        {
            for ( String __bc_n : interceptors )
            {
                org.apache.beehive.controls.spi.svc.Interceptor __bc_i = ensureInterceptor( __bc_n );
                try
                {
                    __bc_i.preEvent( DelayedHelloWSServiceControlBean.this, john.ws.client.DelayedHelloWSServiceControl.Callback.class , method, argArray );
                }
                catch (org.apache.beehive.controls.spi.svc.InterceptorPivotException __bc_ipe)
                {
                    __bc_ipe.setInterceptorName(__bc_n);
                    throw __bc_ipe;
                }
            }
        }
        private void postEvent(Method method, Object[] argArray, Object retval, Throwable t, String[] interceptors, String pivotedInterceptor)
        {
            for (int __bc_cnt = interceptors.length - 1; __bc_cnt >= 0; __bc_cnt--)
            {
                String __bc_n = interceptors[__bc_cnt];
                if (pivotedInterceptor == null || __bc_n.equals(pivotedInterceptor))
                {
                    pivotedInterceptor = null;
                    org.apache.beehive.controls.spi.svc.Interceptor __bc_i = ensureInterceptor( __bc_n );
                    __bc_i.postEvent( DelayedHelloWSServiceControlBean.this, john.ws.client.DelayedHelloWSServiceControl.Callback.class , method, argArray, retval, t );
                }
            }
        }
    }
    
    /**
    * Registers a new listener for Callback events on the bean.
    */
    public synchronized void addCallbackListener(john.ws.client.DelayedHelloWSServiceControl.Callback listener)
    throws java.util.TooManyListenersException
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class);
        __bc_notifier.addListener(listener);
    }
    
    /**
    * Unregisters an existing listener for Callback events on the bean.
    */
    public synchronized void removeCallbackListener(john.ws.client.DelayedHelloWSServiceControl.Callback listener)
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class);
        __bc_notifier.removeListener(listener);
    }
    
    /**
    * Returns the  array of registered listeners for Callback events on the bean, or
    * an empty array if no listener has been registered
    */
    public synchronized john.ws.client.DelayedHelloWSServiceControl.Callback [] getCallbackListeners()
    {
        CallbackNotifier __bc_notifier = (CallbackNotifier)getEventNotifier(john.ws.client.DelayedHelloWSServiceControl.Callback.class);
        john.ws.client.DelayedHelloWSServiceControl.Callback [] __bc_listeners = new john.ws.client.DelayedHelloWSServiceControl.Callback[__bc_notifier.getListenerCount()];
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
