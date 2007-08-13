package john.db;

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
public class LogMessageDBBeanBeanInfo
extends org.apache.beehive.controls.system.jdbc.JdbcControlBeanBeanInfo
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
    
    /**
    * Default null-arg constructor used to create a new BeanInfo instance
    */
    public LogMessageDBBeanBeanInfo()
    {
        super(john.db.LogMessageDBBean.class);
    }
    
    /**
    * Protected constructor used if this BeanInfo class is extended.
    */
    protected LogMessageDBBeanBeanInfo(Class beanClass)
    {
        super(beanClass);
    }
    
    // java.beans.BeanInfo.getBeanDescriptor
    public BeanDescriptor getBeanDescriptor()
    {
        BeanDescriptor bd = new BeanDescriptor(john.db.LogMessageDBBean.class);
        bd.setName( "LogMessageDBBean" );
        bd.setDisplayName( "LogMessageDBBean" );
        
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
        // Declare MethodDescriptor for deleteMessage(ident)
        //
        __bc_paramNames = _methodParamMap.get(_deleteMessageMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_deleteMessageMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for deleteAllMessages()
        //
        __bc_paramNames = _methodParamMap.get(_deleteAllMessagesMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_deleteAllMessagesMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for logMessage(message, time)
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
        // Declare MethodDescriptor for getAllMessages()
        //
        __bc_paramNames = _methodParamMap.get(_getAllMessagesMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getAllMessagesMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        //
        // Declare MethodDescriptor for getMessage(ident)
        //
        __bc_paramNames = _methodParamMap.get(_getMessageMethod);
        __bc_paramDescriptors = new ParameterDescriptor[__bc_paramNames.length];
        for (int j = 0; j < __bc_paramNames.length; j++)
        {
            __bc_paramDescriptors[j] = new ParameterDescriptor();
            __bc_paramDescriptors[j].setName(__bc_paramNames[j]);
            __bc_paramDescriptors[j].setDisplayName(__bc_paramNames[j]);
        }
        md = new MethodDescriptor(_getMessageMethod, __bc_paramDescriptors);
        methodDescriptors[index++] = md;
        
        
        //
        // Add method descriptors from parent BeanInfo
        //
        super.initMethodDescriptors(methodDescriptors, index);
    }
    
    public MethodDescriptor [] getMethodDescriptors()
    {
        MethodDescriptor [] __bc_methodDescriptors = new MethodDescriptor[8];
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
        
        pd = new PropertyDescriptor( "controlImplementation" , john.db.LogMessageDBBean.class, "getControlImplementation", "setControlImplementation");
        propDescriptors[index++] = pd;
        
        //
        // add property descriptors for any getter/setters defined in control interface
        //
        pd = new PropertyDescriptor( "allMessages" , john.db.LogMessageDBBean.class, "getAllMessages", null);
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
