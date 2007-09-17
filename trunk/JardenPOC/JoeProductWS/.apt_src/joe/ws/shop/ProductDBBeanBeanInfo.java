package joe.ws.shop;

import java.beans.BeanDescriptor;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.beehive.controls.api.ControlException;
import org.apache.beehive.controls.runtime.bean.BeanPersistenceDelegate;
import org.apache.beehive.controls.runtime.packaging.ControlEventSetDescriptor;

@SuppressWarnings("all")
public class ProductDBBeanBeanInfo
extends org.apache.beehive.controls.system.jdbc.JdbcControlBeanBeanInfo
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
    
    /**
    * Default null-arg constructor used to create a new BeanInfo instance
    */
    public ProductDBBeanBeanInfo()
    {
        super(joe.ws.shop.ProductDBBean.class);
    }
    
    /**
    * Protected constructor used if this BeanInfo class is extended.
    */
    protected ProductDBBeanBeanInfo(Class beanClass)
    {
        super(beanClass);
    }
    
    // java.beans.BeanInfo.getBeanDescriptor
    public BeanDescriptor getBeanDescriptor()
    {
        BeanDescriptor bd = new BeanDescriptor(joe.ws.shop.ProductDBBean.class);
        bd.setName( "ProductDBBean" );
        bd.setDisplayName( "ProductDBBean" );
        
        //
        // The org.apache.beehive.controls.runtime.bean.BeanPersistenceDelegate class
        // implements the XMLDecode delegation model for all Control JavaBean types. It
        // provides optimized XML persistance based upon the Control runtime architecture.
        // The 'persistenceDelegate' attribute of a BeanDescriptor is used by XMLEncoder to
        // locate a delegate for a particular JavaBean type.
        //
        bd.setValue("persistenceDelegate", new BeanPersistenceDelegate());
        
        return bd;
    }
    
    /**
    * Stores MethodDescriptor descriptors for this bean and its superclasses into
    * an array, starting at the specified index
    */
    protected void initMethodDescriptors(MethodDescriptor [] methodDescriptors, int index)
    throws java.beans.IntrospectionException
    {
        String [] __bc_paramNames;
        ParameterDescriptor [] __bc_paramDescriptors;
        MethodDescriptor md;
        
        //
        // Declare MethodDescriptor for getProduct(code)
        //
        __bc_paramNames = _methodParamMap.get(_getProductMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getProductMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for deleteProduct(code)
        //
        __bc_paramNames = _methodParamMap.get(_deleteProductMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_deleteProductMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getAllProducts()
        //
        __bc_paramNames = _methodParamMap.get(_getAllProductsMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getAllProductsMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for createProduct(vo)
        //
        __bc_paramNames = _methodParamMap.get(_createProductMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_createProductMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getProductsByName(name)
        //
        __bc_paramNames = _methodParamMap.get(_getProductsByNameMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getProductsByNameMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for deleteAllProducts()
        //
        __bc_paramNames = _methodParamMap.get(_deleteAllProductsMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_deleteAllProductsMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        
        //
        // Add method descriptors from parent BeanInfo
        //
        super.initMethodDescriptors(methodDescriptors, index);
    }
    
    public MethodDescriptor [] getMethodDescriptors()
    {
        MethodDescriptor [] __bc_methodDescriptors = new MethodDescriptor[9];
        try
        {
            initMethodDescriptors(__bc_methodDescriptors, 0);
        }
        catch (java.beans.IntrospectionException __bc_ie)
        {
            throw new ControlException("Unable to create MethodDescriptor", __bc_ie);
        }
        return __bc_methodDescriptors;
    }
    
    /**
    * Stores PropertyDescriptor descriptors for this bean and its superclasses into
    * an array, starting at the specified index
    */
    protected void initPropertyDescriptors(PropertyDescriptor [] propDescriptors, int index)
    throws java.beans.IntrospectionException
    {
        PropertyDescriptor pd;
        
        pd = new PropertyDescriptor( "controlImplementation" , joe.ws.shop.ProductDBBean.class, "getControlImplementation", "setControlImplementation");
        propDescriptors[index++] = pd;
        
        //
        // add property descriptors for any getter/setters defined in control interface
        //
        pd = new PropertyDescriptor( "allProducts" , joe.ws.shop.ProductDBBean.class, "getAllProducts", null);
        propDescriptors[index++] = pd;
        
        //
        // Add property descriptors from parent BeanInfo
        //
        super.initPropertyDescriptors(propDescriptors, index);
    }
    
    // java.beans.BeanInfo.getPropertyDescriptors
    public PropertyDescriptor [] getPropertyDescriptors()
    {
        PropertyDescriptor [] __bc_propDescriptors = new PropertyDescriptor[31];
        try
        {
            initPropertyDescriptors(__bc_propDescriptors, 0);
        }
        catch (java.beans.IntrospectionException __bc_ie)
        {
            throw new ControlException("Unable to create PropertyDescriptor", __bc_ie);
        }
        return __bc_propDescriptors;
    }
    
    
    protected void initEventSetDescriptors(EventSetDescriptor [] eventSetDescriptors, int index)
    throws java.beans.IntrospectionException
    {
        
        
        //
        // Add event set descriptors from parent BeanInfo
        //
        super.initEventSetDescriptors(eventSetDescriptors, index);
    }
    
    // java.beans.BeanInfo.getEventSetDescriptors
    public EventSetDescriptor [] getEventSetDescriptors()
    {
        EventSetDescriptor [] __bc_eventSetDescriptors = new EventSetDescriptor[0];
        try
        {
            initEventSetDescriptors(__bc_eventSetDescriptors, 0);
        }
        catch (java.beans.IntrospectionException __bc_ie)
        {
            throw new ControlException("Unable to create EventSetDescriptor", __bc_ie);
        }
        return __bc_eventSetDescriptors;
    }
}
