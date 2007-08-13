
package john.db;

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
public class LogMessageDBBean
extends org.apache.beehive.controls.system.jdbc.JdbcControlBean
implements john.db.LogMessageDB
{
    static final Method _deleteMessageMethod;
    static final Method _deleteAllMessagesMethod;
    static final Method _logMessageMethod;
    static final Method _getAllMessagesMethod;
    static final Method _getMessageMethod;
    
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
            _deleteMessageMethod = john.db.LogMessageDB.class.getMethod("deleteMessage", new Class [] {int.class});
            _methodParamMap.put(_deleteMessageMethod, new String [] { "ident" });
            _deleteAllMessagesMethod = john.db.LogMessageDB.class.getMethod("deleteAllMessages", new Class [] {});
            _methodParamMap.put(_deleteAllMessagesMethod, new String [] {  });
            _logMessageMethod = john.db.LogMessageDB.class.getMethod("logMessage", new Class [] {java.lang.String.class, java.util.Date.class});
            _methodParamMap.put(_logMessageMethod, new String [] { "message", "time" });
            _getAllMessagesMethod = john.db.LogMessageDB.class.getMethod("getAllMessages", new Class [] {});
            _methodParamMap.put(_getAllMessagesMethod, new String [] {  });
            _getMessageMethod = john.db.LogMessageDB.class.getMethod("getMessage", new Class [] {int.class});
            _methodParamMap.put(_getMessageMethod, new String [] { "ident" });
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
    public LogMessageDBBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, john.db.LogMessageDB.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public LogMessageDBBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected LogMessageDBBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
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
    * Implements john.db.LogMessageDB.deleteMessage
    */
    public  int deleteMessage(int ident) 
    {
        Object [] __bc_argArray = new Object[] { ident };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        int __bc_retval = 0;
        
        try
        {
            preInvoke(_deleteMessageMethod, __bc_argArray);
            
            __bc_retval =
            (Integer)
            __bc_target.invoke(_deleteMessageMethod, __bc_argArray)
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
            postInvoke(_deleteMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.db.LogMessageDB.deleteAllMessages
    */
    public  int deleteAllMessages() 
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        int __bc_retval = 0;
        
        try
        {
            preInvoke(_deleteAllMessagesMethod, __bc_argArray);
            
            __bc_retval =
            (Integer)
            __bc_target.invoke(_deleteAllMessagesMethod, __bc_argArray)
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
            postInvoke(_deleteAllMessagesMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.db.LogMessageDB.logMessage
    */
    public  void logMessage(java.lang.String message, java.util.Date time) 
    {
        Object [] __bc_argArray = new Object[] { message, time };
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
    * Implements john.db.LogMessageDB.getAllMessages
    */
    public  john.db.JohnLogVO[] getAllMessages() 
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        john.db.JohnLogVO[] __bc_retval = null;
        
        try
        {
            preInvoke(_getAllMessagesMethod, __bc_argArray);
            
            __bc_retval =
            (john.db.JohnLogVO[])
            __bc_target.invoke(_getAllMessagesMethod, __bc_argArray)
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
            postInvoke(_getAllMessagesMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements john.db.LogMessageDB.getMessage
    */
    public  john.db.JohnLogVO getMessage(int ident) 
    {
        Object [] __bc_argArray = new Object[] { ident };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        john.db.JohnLogVO __bc_retval = null;
        
        try
        {
            preInvoke(_getMessageMethod, __bc_argArray);
            
            __bc_retval =
            (john.db.JohnLogVO)
            __bc_target.invoke(_getMessageMethod, __bc_argArray)
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
            postInvoke(_getMessageMethod, __bc_argArray, __bc_rv, __bc_thrown);
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
