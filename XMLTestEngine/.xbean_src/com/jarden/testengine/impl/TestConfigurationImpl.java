/*
 * XML Type:  TestConfiguration
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.TestConfiguration
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML TestConfiguration(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class TestConfigurationImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.TestConfiguration
{
    
    public TestConfigurationImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TESTS$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "tests");
    private static final javax.xml.namespace.QName VALIDATORS$2 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "validators");
    
    
    /**
     * Gets the "tests" element
     */
    public com.jarden.testengine.Tests getTests()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Tests target = null;
            target = (com.jarden.testengine.Tests)get_store().find_element_user(TESTS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "tests" element
     */
    public void setTests(com.jarden.testengine.Tests tests)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Tests target = null;
            target = (com.jarden.testengine.Tests)get_store().find_element_user(TESTS$0, 0);
            if (target == null)
            {
                target = (com.jarden.testengine.Tests)get_store().add_element_user(TESTS$0);
            }
            target.set(tests);
        }
    }
    
    /**
     * Appends and returns a new empty "tests" element
     */
    public com.jarden.testengine.Tests addNewTests()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Tests target = null;
            target = (com.jarden.testengine.Tests)get_store().add_element_user(TESTS$0);
            return target;
        }
    }
    
    /**
     * Gets the "validators" element
     */
    public com.jarden.testengine.Validators getValidators()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validators target = null;
            target = (com.jarden.testengine.Validators)get_store().find_element_user(VALIDATORS$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "validators" element
     */
    public void setValidators(com.jarden.testengine.Validators validators)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validators target = null;
            target = (com.jarden.testengine.Validators)get_store().find_element_user(VALIDATORS$2, 0);
            if (target == null)
            {
                target = (com.jarden.testengine.Validators)get_store().add_element_user(VALIDATORS$2);
            }
            target.set(validators);
        }
    }
    
    /**
     * Appends and returns a new empty "validators" element
     */
    public com.jarden.testengine.Validators addNewValidators()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validators target = null;
            target = (com.jarden.testengine.Validators)get_store().add_element_user(VALIDATORS$2);
            return target;
        }
    }
}
