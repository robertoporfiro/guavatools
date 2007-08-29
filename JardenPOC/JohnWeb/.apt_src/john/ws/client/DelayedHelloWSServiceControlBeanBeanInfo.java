package john.ws.client;

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
public class DelayedHelloWSServiceControlBeanBeanInfo
extends com.bea.control.ServiceControlBeanBeanInfo
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
    
    /**
    * Default null-arg constructor used to create a new BeanInfo instance
    */
    public DelayedHelloWSServiceControlBeanBeanInfo()
    {
        super(john.ws.client.DelayedHelloWSServiceControlBean.class);
    }
    
    /**
    * Protected constructor used if this BeanInfo class is extended.
    */
    protected DelayedHelloWSServiceControlBeanBeanInfo(Class beanClass)
    {
        super(beanClass);
    }
    
    // java.beans.BeanInfo.getBeanDescriptor
    public BeanDescriptor getBeanDescriptor()
    {
        BeanDescriptor bd = new BeanDescriptor(john.ws.client.DelayedHelloWSServiceControlBean.class);
        bd.setName( "DelayedHelloWSServiceControlBean" );
        bd.setDisplayName( "DelayedHelloWSServiceControlBean" );
        
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
        // Declare MethodDescriptor for hello(name_arg)
        //
        __bc_paramNames = _methodParamMap.get(_helloMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_helloMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for delayedHello(name_arg, delay_arg)
        //
        __bc_paramNames = _methodParamMap.get(_delayedHelloMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_delayedHelloMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        
        //
        // Add method descriptors from parent BeanInfo
        //
        super.initMethodDescriptors(methodDescriptors, index);
    }
    
    public MethodDescriptor [] getMethodDescriptors()
    {
        MethodDescriptor [] __bc_methodDescriptors = new MethodDescriptor[36];
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
        
        pd = new PropertyDescriptor( "controlImplementation" , john.ws.client.DelayedHelloWSServiceControlBean.class, "getControlImplementation", "setControlImplementation");
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
        
        //
        // Declare MethodDescriptor for helloCallback(reply_arg)
        //
        __bc_paramNames = _methodParamMap.get(_Callback_helloCallbackEvent);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int k = 0; k < __bc_paramNames.length; k++)
        {
            __bc_paramDescriptors[k] = new ParameterDescriptor();
            __bc_paramDescriptors[k].setName(__bc_paramNames[k]);
            __bc_paramDescriptors[k].setDisplayName(__bc_paramNames[k]);
        }
        md = new MethodDescriptor(_Callback_helloCallbackEvent, __bc_paramDescriptors);
        eventDescriptors[index++] = md;
        
    }
    
    
    protected void initEventSetDescriptors(EventSetDescriptor [] eventSetDescriptors, int index)
    throws java.beans.IntrospectionException
    {
        MethodDescriptor [] __bc_eventDescriptors;
        EventSetDescriptor __bc_esd;
        Method __bc_addListener, __bc_removeListener, __bc_getListeners;
        Class __bc_eventIntf;
        
        __bc_eventIntf = john.ws.client.DelayedHelloWSServiceControl.Callback.class;
        
        //
        // Find the add/remove listener methods
        //
        try
        {
            __bc_addListener =
            john.ws.client.DelayedHelloWSServiceControlBean.class.getDeclaredMethod("addCallbackListener",
            new Class [] { __bc_eventIntf });
            __bc_removeListener =
            john.ws.client.DelayedHelloWSServiceControlBean.class.getDeclaredMethod("removeCallbackListener",
            new Class [] { __bc_eventIntf });
            __bc_getListeners =
            john.ws.client.DelayedHelloWSServiceControlBean.class.getDeclaredMethod("getCallbackListeners",
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
        __bc_eventDescriptors = new MethodDescriptor[2];
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
