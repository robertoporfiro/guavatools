
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
public class JohnSessionEjbCtrlBean
extends org.apache.beehive.controls.system.ejb.SessionEJBControlBean
implements john.web.hello.JohnSessionEjbCtrl
{
    static final Method _logMessageMethod;
    static final Method _getEJBHomeMethod;
    static final Method _getHomeHandleMethod;
    static final Method _createMethod;
    static final Method _getHandleMethod;
    static final Method _getEJBMetaDataMethod;
    static final Method _isIdenticalMethod;
    static final Method _remove1Method;
    static final Method _remove0Method;
    static final Method _remove2Method;
    static final Method _getPrimaryKeyMethod;
    
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
            _logMessageMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("logMessage", new Class [] {java.lang.String.class});
            _methodParamMap.put(_logMessageMethod, new String [] { "arg0" });
            _getEJBHomeMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("getEJBHome", new Class [] {});
            _methodParamMap.put(_getEJBHomeMethod, new String [] {  });
            _getHomeHandleMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("getHomeHandle", new Class [] {});
            _methodParamMap.put(_getHomeHandleMethod, new String [] {  });
            _createMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("create", new Class [] {});
            _methodParamMap.put(_createMethod, new String [] {  });
            _getHandleMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("getHandle", new Class [] {});
            _methodParamMap.put(_getHandleMethod, new String [] {  });
            _getEJBMetaDataMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("getEJBMetaData", new Class [] {});
            _methodParamMap.put(_getEJBMetaDataMethod, new String [] {  });
            _isIdenticalMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("isIdentical", new Class [] {javax.ejb.EJBObject.class});
            _methodParamMap.put(_isIdenticalMethod, new String [] { "arg0" });
            _remove1Method = john.web.hello.JohnSessionEjbCtrl.class.getMethod("remove", new Class [] {java.lang.Object.class});
            _methodParamMap.put(_remove1Method, new String [] { "arg0" });
            _remove0Method = john.web.hello.JohnSessionEjbCtrl.class.getMethod("remove", new Class [] {javax.ejb.Handle.class});
            _methodParamMap.put(_remove0Method, new String [] { "arg0" });
            _remove2Method = john.web.hello.JohnSessionEjbCtrl.class.getMethod("remove", new Class [] {});
            _methodParamMap.put(_remove2Method, new String [] {  });
            _getPrimaryKeyMethod = john.web.hello.JohnSessionEjbCtrl.class.getMethod("getPrimaryKey", new Class [] {});
            _methodParamMap.put(_getPrimaryKeyMethod, new String [] {  });
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
    public JohnSessionEjbCtrlBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, john.web.hello.JohnSessionEjbCtrl.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public JohnSessionEjbCtrlBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected JohnSessionEjbCtrlBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
    {
        super(context, id, props, controlClass);
        
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
    * Implements john.web.hello.JohnSessionEjbCtrl.logMessage
    */
    public  void logMessage(java.lang.String arg0) throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] { arg0 };
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_logMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.getEJBHome
    */
    public  javax.ejb.EJBHome getEJBHome() throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        javax.ejb.EJBHome __bc_retval = null;
        
        try
        {
            preInvoke(_getEJBHomeMethod, __bc_argArray);
            
            __bc_retval =
            (javax.ejb.EJBHome)
            __bc_target.invoke(_getEJBHomeMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getEJBHomeMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.getHomeHandle
    */
    public  javax.ejb.HomeHandle getHomeHandle() throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        javax.ejb.HomeHandle __bc_retval = null;
        
        try
        {
            preInvoke(_getHomeHandleMethod, __bc_argArray);
            
            __bc_retval =
            (javax.ejb.HomeHandle)
            __bc_target.invoke(_getHomeHandleMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getHomeHandleMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.create
    */
    public  john.ejb.JohnSessionEJBRemote create() throws javax.ejb.CreateException, java.rmi.RemoteException, javax.ejb.CreateException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        john.ejb.JohnSessionEJBRemote __bc_retval = null;
        
        try
        {
            preInvoke(_createMethod, __bc_argArray);
            
            __bc_retval =
            (john.ejb.JohnSessionEJBRemote)
            __bc_target.invoke(_createMethod, __bc_argArray)
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
            else if (__bc_t instanceof javax.ejb.CreateException) throw (javax.ejb.CreateException)__bc_t;
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            else if (__bc_t instanceof javax.ejb.CreateException) throw (javax.ejb.CreateException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_createMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.getHandle
    */
    public  javax.ejb.Handle getHandle() throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        javax.ejb.Handle __bc_retval = null;
        
        try
        {
            preInvoke(_getHandleMethod, __bc_argArray);
            
            __bc_retval =
            (javax.ejb.Handle)
            __bc_target.invoke(_getHandleMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getHandleMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.getEJBMetaData
    */
    public  javax.ejb.EJBMetaData getEJBMetaData() throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        javax.ejb.EJBMetaData __bc_retval = null;
        
        try
        {
            preInvoke(_getEJBMetaDataMethod, __bc_argArray);
            
            __bc_retval =
            (javax.ejb.EJBMetaData)
            __bc_target.invoke(_getEJBMetaDataMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getEJBMetaDataMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.isIdentical
    */
    public  boolean isIdentical(javax.ejb.EJBObject arg0) throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] { arg0 };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        boolean __bc_retval = false;
        
        try
        {
            preInvoke(_isIdenticalMethod, __bc_argArray);
            
            __bc_retval =
            (Boolean)
            __bc_target.invoke(_isIdenticalMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_isIdenticalMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.remove
    */
    public  void remove(java.lang.Object arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException
    {
        Object [] __bc_argArray = new Object[] { arg0 };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_remove1Method, __bc_argArray);
            
            __bc_target.invoke(_remove1Method, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            else if (__bc_t instanceof javax.ejb.RemoveException) throw (javax.ejb.RemoveException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_remove1Method, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.remove
    */
    public  void remove(javax.ejb.Handle arg0) throws java.rmi.RemoteException, javax.ejb.RemoveException
    {
        Object [] __bc_argArray = new Object[] { arg0 };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_remove0Method, __bc_argArray);
            
            __bc_target.invoke(_remove0Method, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            else if (__bc_t instanceof javax.ejb.RemoveException) throw (javax.ejb.RemoveException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_remove0Method, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.remove
    */
    public  void remove() throws java.rmi.RemoteException, javax.ejb.RemoveException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_remove2Method, __bc_argArray);
            
            __bc_target.invoke(_remove2Method, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            else if (__bc_t instanceof javax.ejb.RemoveException) throw (javax.ejb.RemoveException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = null;
            postInvoke(_remove2Method, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements john.web.hello.JohnSessionEjbCtrl.getPrimaryKey
    */
    public  java.lang.Object getPrimaryKey() throws java.rmi.RemoteException
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        java.lang.Object __bc_retval = null;
        
        try
        {
            preInvoke(_getPrimaryKeyMethod, __bc_argArray);
            
            __bc_retval =
            (java.lang.Object)
            __bc_target.invoke(_getPrimaryKeyMethod, __bc_argArray)
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
            else if (__bc_t instanceof java.rmi.RemoteException) throw (java.rmi.RemoteException)__bc_t;
            
            throw new UndeclaredThrowableException(__bc_t);
        }
        finally
        {
            Object __bc_rv = __bc_retval;
            postInvoke(_getPrimaryKeyMethod, __bc_argArray, __bc_rv, __bc_thrown);
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
    * The _annotCache maintains a lookup cache from AnnotatedElements to an associated
    * PropertyMap.  This enables these maps to be shared across multiple beans.
    */
    static private HashMap __bc_annotCache = new HashMap();
    
    protected Map getPropertyMapCache() { return __bc_annotCache; }
    
    private static final long serialVersionUID = 1L;
}
