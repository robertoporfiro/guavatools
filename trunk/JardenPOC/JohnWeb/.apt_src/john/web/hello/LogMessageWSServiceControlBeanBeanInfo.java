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
public class LogMessageWSServiceControlBeanBeanInfo
extends com.bea.control.ServiceControlBeanBeanInfo
{
    static final Method _logMessageMethod;
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
            _logMessageMethod = john.web.hello.LogMessageWSServiceControl.class.getMethod("logMessage", new Class [] {java.lang.String.class});
            _methodParamMap.put(_logMessageMethod, new String [] { "message_arg" });
            _Callback_onAsyncFailureEvent = john.web.hello.LogMessageWSServiceControl.Callback.class.getMethod("onAsyncFailure", new Class [] {java.lang.String.class, java.lang.Object[].class});
            _methodParamMap.put(_Callback_onAsyncFailureEvent, new String [] { "arg0", "arg1" });
        }
        catch (NoSuchMethodException __bc_nsme)
        {
            throw new ExceptionInInitializerError(__bc_nsme);
        }
    }
    
    /**
    * Default null-arg constructor used to create a new BeanInfo instance
    */
    public LogMessageWSServiceControlBeanBeanInfo()
    {
        super(john.web.hello.LogMessageWSServiceControlBean.class);
    }
    
    /**
    * Protected constructor used if this BeanInfo class is extended.
    */
    protected LogMessageWSServiceControlBeanBeanInfo(Class beanClass)
    {
        super(beanClass);
    }
    
    // java.beans.BeanInfo.getBeanDescriptor
    public BeanDescriptor getBeanDescriptor()
    {
        BeanDescriptor bd = new BeanDescriptor(john.web.hello.LogMessageWSServiceControlBean.class);
        bd.setName( "LogMessageWSServiceControlBean" );
        bd.setDisplayName( "LogMessageWSServiceControlBean" );
        
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
        // Declare MethodDescriptor for logMessage(message_arg)
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
        // Add method descriptors from parent BeanInfo
        //
        super.initMethodDescriptors(methodDescriptors, index);
    }
    
    public MethodDescriptor [] getMethodDescriptors()
    {
        MethodDescriptor [] __bc_methodDescriptors = new MethodDescriptor[35];
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
        
        pd = new PropertyDescriptor( "controlImplementation" , john.web.hello.LogMessageWSServiceControlBean.class, "getControlImplementation", "setControlImplementation");
        propDescriptors[index++] = pd;
        
        
        //
        // Add property descriptors from parent BeanInfo
        //
        super.initPropertyDescriptors(propDescriptors, index);
    }
    
    // java.beans.BeanInfo.getPropertyDescriptors
    public PropertyDescriptor [] getPropertyDescriptors()
    {
        PropertyDescriptor [] __bc_propDescriptors = new PropertyDescriptor[20];
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
    
    //
    // Adds the EventDescriptors for Callback to the EventDescriptor array, starting
    // at index
    //
    protected void initCallbackEvents(MethodDescriptor [] eventDescriptors, int index)
    {
        String [] __bc_paramNames;
        ParameterDescriptor [] __bc_paramDescriptors;
        MethodDescriptor md;
        
        //
        // Build a method descriptor for each event method in the event set
        //
        
        //
        // Declare MethodDescriptor for onAsyncFailure(arg0, arg1)
        //
        __bc_paramNames = _methodParamMap.get(_Callback_onAsyncFailureEvent);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int k = 0; k < __bc_paramNames.length; k++)
        {
            __bc_paramDescriptors[k] = new ParameterDescriptor();
            __bc_paramDescriptors[k].setName(__bc_paramNames[k]);
            __bc_paramDescriptors[k].setDisplayName(__bc_paramNames[k]);
        }
        md = new MethodDescriptor(_Callback_onAsyncFailureEvent, __bc_paramDescriptors);
        eventDescriptors[index++] = md;
        
    }
    
    
    protected void initEventSetDescriptors(EventSetDescriptor [] eventSetDescriptors, int index)
    throws java.beans.IntrospectionException
    {
        MethodDescriptor [] __bc_eventDescriptors;
        EventSetDescriptor __bc_esd;
        Method __bc_addListener, __bc_removeListener, __bc_getListeners;
        Class __bc_eventIntf;
        
        __bc_eventIntf = john.web.hello.LogMessageWSServiceControl.Callback.class;
        
        //
        // Find the add/remove listener methods
        //
        try
        {
            __bc_addListener =
            john.web.hello.LogMessageWSServiceControlBean.class.getDeclaredMethod("addCallbackListener",
            new Class [] { __bc_eventIntf });
            __bc_removeListener =
            john.web.hello.LogMessageWSServiceControlBean.class.getDeclaredMethod("removeCallbackListener",
            new Class [] { __bc_eventIntf });
            __bc_getListeners =
            john.web.hello.LogMessageWSServiceControlBean.class.getDeclaredMethod("getCallbackListeners",
            new Class [] {});
        }
        catch (NoSuchMethodException __bc_nsme)
        {
            // This is moderately lame, but there is no checked exception declared for this
            // method.  This could only happen as a result of a mismatch between bean class
            // and introspector codegen.
            throw new ControlException("Unable to locate listener method", __bc_nsme);
        }
        
        //
        // Build the MethodDescriptor array contain all event set events
        //
        __bc_eventDescriptors = new MethodDescriptor[1];
        initCallbackEvents(__bc_eventDescriptors, 0);
        
        try
        {
            __bc_esd = new ControlEventSetDescriptor(localizeString("callback"),
            __bc_eventIntf, __bc_eventDescriptors, __bc_addListener, __bc_removeListener, __bc_getListeners);
            __bc_esd.setUnicast(true);
        }
        catch (IntrospectionException __bc_ie)
        {
            throw new ControlException("Unable to create EventDescriptor", __bc_ie);
        }
        eventSetDescriptors[index++] = __bc_esd;
        
        
        //
        // Add event set descriptors from parent BeanInfo
        //
        super.initEventSetDescriptors(eventSetDescriptors, index);
    }
    
    // java.beans.BeanInfo.getEventSetDescriptors
    public EventSetDescriptor [] getEventSetDescriptors()
    {
        EventSetDescriptor [] __bc_eventSetDescriptors = new EventSetDescriptor[1];
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
