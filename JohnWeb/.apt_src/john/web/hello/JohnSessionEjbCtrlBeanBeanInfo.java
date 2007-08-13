package john.web.hello;

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
public class JohnSessionEjbCtrlBeanBeanInfo
extends org.apache.beehive.controls.system.ejb.SessionEJBControlBeanBeanInfo
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
    
    /**
    * Default null-arg constructor used to create a new BeanInfo instance
    */
    public JohnSessionEjbCtrlBeanBeanInfo()
    {
        super(john.web.hello.JohnSessionEjbCtrlBean.class);
    }
    
    /**
    * Protected constructor used if this BeanInfo class is extended.
    */
    protected JohnSessionEjbCtrlBeanBeanInfo(Class beanClass)
    {
        super(beanClass);
    }
    
    // java.beans.BeanInfo.getBeanDescriptor
    public BeanDescriptor getBeanDescriptor()
    {
        BeanDescriptor bd = new BeanDescriptor(john.web.hello.JohnSessionEjbCtrlBean.class);
        bd.setName( "JohnSessionEjbCtrlBean" );
        bd.setDisplayName( "JohnSessionEjbCtrlBean" );
        
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
        // Declare MethodDescriptor for logMessage(arg0)
        //
        __bc_paramNames = _methodParamMap.get(_logMessageMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_logMessageMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getEJBHome()
        //
        __bc_paramNames = _methodParamMap.get(_getEJBHomeMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getEJBHomeMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getHomeHandle()
        //
        __bc_paramNames = _methodParamMap.get(_getHomeHandleMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getHomeHandleMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for create()
        //
        __bc_paramNames = _methodParamMap.get(_createMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_createMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getHandle()
        //
        __bc_paramNames = _methodParamMap.get(_getHandleMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getHandleMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getEJBMetaData()
        //
        __bc_paramNames = _methodParamMap.get(_getEJBMetaDataMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getEJBMetaDataMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for isIdentical(arg0)
        //
        __bc_paramNames = _methodParamMap.get(_isIdenticalMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_isIdenticalMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for remove(arg0)
        //
        __bc_paramNames = _methodParamMap.get(_remove1Method);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_remove1Method, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for remove(arg0)
        //
        __bc_paramNames = _methodParamMap.get(_remove0Method);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_remove0Method, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for remove()
        //
        __bc_paramNames = _methodParamMap.get(_remove2Method);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_remove2Method, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getPrimaryKey()
        //
        __bc_paramNames = _methodParamMap.get(_getPrimaryKeyMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getPrimaryKeyMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        
        //
        // Add method descriptors from parent BeanInfo
        //
        super.initMethodDescriptors(methodDescriptors, index);
    }
    
    public MethodDescriptor [] getMethodDescriptors()
    {
        MethodDescriptor [] __bc_methodDescriptors = new MethodDescriptor[15];
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
        
        pd = new PropertyDescriptor( "controlImplementation" , john.web.hello.JohnSessionEjbCtrlBean.class, "getControlImplementation", "setControlImplementation");
        propDescriptors[index++] = pd;
        
        //
        // add property descriptors for any getter/setters defined in control interface
        //
        pd = new PropertyDescriptor( "primaryKey" , john.web.hello.JohnSessionEjbCtrlBean.class, "getPrimaryKey", null);
        propDescriptors[index++] = pd;
        pd = new PropertyDescriptor( "handle" , john.web.hello.JohnSessionEjbCtrlBean.class, "getHandle", null);
        propDescriptors[index++] = pd;
        pd = new PropertyDescriptor( "homeHandle" , john.web.hello.JohnSessionEjbCtrlBean.class, "getHomeHandle", null);
        propDescriptors[index++] = pd;
        pd = new PropertyDescriptor( "eJBMetaData" , john.web.hello.JohnSessionEjbCtrlBean.class, "getEJBMetaData", null);
        propDescriptors[index++] = pd;
        pd = new PropertyDescriptor( "eJBHome" , john.web.hello.JohnSessionEjbCtrlBean.class, "getEJBHome", null);
        propDescriptors[index++] = pd;
        
        //
        // Add property descriptors from parent BeanInfo
        //
        super.initPropertyDescriptors(propDescriptors, index);
    }
    
    // java.beans.BeanInfo.getPropertyDescriptors
    public PropertyDescriptor [] getPropertyDescriptors()
    {
        PropertyDescriptor [] __bc_propDescriptors = new PropertyDescriptor[17];
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
