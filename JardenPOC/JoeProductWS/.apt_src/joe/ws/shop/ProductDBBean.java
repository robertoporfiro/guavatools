
package joe.ws.shop;

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
public class ProductDBBean
extends org.apache.beehive.controls.system.jdbc.JdbcControlBean
implements joe.ws.shop.ProductDB
{
    static final Method _getProductMethod;
    static final Method _deleteProductMethod;
    static final Method _getAllProductsMethod;
    static final Method _createProductMethod;
    static final Method _getProductsByNameMethod;
    static final Method _deleteAllProductsMethod;
    
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
            _getProductMethod = joe.ws.shop.ProductDB.class.getMethod("getProduct", new Class [] {java.lang.String.class});
            _methodParamMap.put(_getProductMethod, new String [] { "code" });
            _deleteProductMethod = joe.ws.shop.ProductDB.class.getMethod("deleteProduct", new Class [] {java.lang.String.class});
            _methodParamMap.put(_deleteProductMethod, new String [] { "code" });
            _getAllProductsMethod = joe.ws.shop.ProductDB.class.getMethod("getAllProducts", new Class [] {});
            _methodParamMap.put(_getAllProductsMethod, new String [] {  });
            _createProductMethod = joe.ws.shop.ProductDB.class.getMethod("createProduct", new Class [] {joe.ws.shop.ProductVO.class});
            _methodParamMap.put(_createProductMethod, new String [] { "vo" });
            _getProductsByNameMethod = joe.ws.shop.ProductDB.class.getMethod("getProductsByName", new Class [] {java.lang.String.class});
            _methodParamMap.put(_getProductsByNameMethod, new String [] { "name" });
            _deleteAllProductsMethod = joe.ws.shop.ProductDB.class.getMethod("deleteAllProducts", new Class [] {});
            _methodParamMap.put(_deleteAllProductsMethod, new String [] {  });
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
    public ProductDBBean(ControlBeanContext context, String id, PropertyMap props)
    {
        this(context, id, props, joe.ws.shop.ProductDB.class);
    }
    
    /**
    * This is the public null-arg constructor for this ControlBean.  If a control id
    * is not provided, a unique value will be auto-generated.
    */
    public ProductDBBean()
    {
        this(null, null, null);
    }
    
    /**
    * This is the protected version that is used by any ControlBean subclass
    */
    protected ProductDBBean(ControlBeanContext context, String id, PropertyMap props, Class controlClass)
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
    * Implements joe.ws.shop.ProductDB.getProduct
    */
    public  joe.ws.shop.ProductVO getProduct(java.lang.String code) 
    {
        Object [] __bc_argArray = new Object[] { code };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        joe.ws.shop.ProductVO __bc_retval = null;
        
        try
        {
            preInvoke(_getProductMethod, __bc_argArray);
            
            __bc_retval =
            (joe.ws.shop.ProductVO)
            __bc_target.invoke(_getProductMethod, __bc_argArray)
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
            postInvoke(_getProductMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.shop.ProductDB.deleteProduct
    */
    public  int deleteProduct(java.lang.String code) 
    {
        Object [] __bc_argArray = new Object[] { code };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        int __bc_retval = 0;
        
        try
        {
            preInvoke(_deleteProductMethod, __bc_argArray);
            
            __bc_retval =
            (Integer)
            __bc_target.invoke(_deleteProductMethod, __bc_argArray)
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
            postInvoke(_deleteProductMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.shop.ProductDB.getAllProducts
    */
    public  joe.ws.shop.ProductVO[] getAllProducts() 
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        joe.ws.shop.ProductVO[] __bc_retval = null;
        
        try
        {
            preInvoke(_getAllProductsMethod, __bc_argArray);
            
            __bc_retval =
            (joe.ws.shop.ProductVO[])
            __bc_target.invoke(_getAllProductsMethod, __bc_argArray)
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
            postInvoke(_getAllProductsMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.shop.ProductDB.createProduct
    */
    public  void createProduct(joe.ws.shop.ProductVO vo) 
    {
        Object [] __bc_argArray = new Object[] { vo };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        
        try
        {
            preInvoke(_createProductMethod, __bc_argArray);
            
            __bc_target.invoke(_createProductMethod, __bc_argArray)
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
            postInvoke(_createProductMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
    }
    
    /**
    * Implements joe.ws.shop.ProductDB.getProductsByName
    */
    public  joe.ws.shop.ProductVO[] getProductsByName(java.lang.String name) 
    {
        Object [] __bc_argArray = new Object[] { name };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        joe.ws.shop.ProductVO[] __bc_retval = null;
        
        try
        {
            preInvoke(_getProductsByNameMethod, __bc_argArray);
            
            __bc_retval =
            (joe.ws.shop.ProductVO[])
            __bc_target.invoke(_getProductsByNameMethod, __bc_argArray)
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
            postInvoke(_getProductsByNameMethod, __bc_argArray, __bc_rv, __bc_thrown);
        }
        return __bc_retval;
    }
    
    /**
    * Implements joe.ws.shop.ProductDB.deleteAllProducts
    */
    public  int deleteAllProducts() 
    {
        Object [] __bc_argArray = new Object[] {  };
        Throwable __bc_thrown = null;
        Extensible __bc_target = (Extensible)ensureControl();
        int __bc_retval = 0;
        
        try
        {
            preInvoke(_deleteAllProductsMethod, __bc_argArray);
            
            __bc_retval =
            (Integer)
            __bc_target.invoke(_deleteAllProductsMethod, __bc_argArray)
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
            postInvoke(_deleteAllProductsMethod, __bc_argArray, __bc_rv, __bc_thrown);
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
