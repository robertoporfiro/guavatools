/*
 * An XML document type.
 * Localname: testConfiguration
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.TestConfigurationDocument
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * A document containing one testConfiguration(@http://www.jarden.com/testengine) element.
 *
 * This is a complex type.
 */
public class TestConfigurationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.TestConfigurationDocument
{
    
    public TestConfigurationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TESTCONFIGURATION$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "testConfiguration");
    
    
    /**
     * Gets the "testConfiguration" element
     */
    public com.jarden.testengine.TestConfiguration getTestConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.TestConfiguration target = null;
            target = (com.jarden.testengine.TestConfiguration)get_store().find_element_user(TESTCONFIGURATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "testConfiguration" element
     */
    public void setTestConfiguration(com.jarden.testengine.TestConfiguration testConfiguration)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.TestConfiguration target = null;
            target = (com.jarden.testengine.TestConfiguration)get_store().find_element_user(TESTCONFIGURATION$0, 0);
            if (target == null)
            {
                target = (com.jarden.testengine.TestConfiguration)get_store().add_element_user(TESTCONFIGURATION$0);
            }
            target.set(testConfiguration);
        }
    }
    
    /**
     * Appends and returns a new empty "testConfiguration" element
     */
    public com.jarden.testengine.TestConfiguration addNewTestConfiguration()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.TestConfiguration target = null;
            target = (com.jarden.testengine.TestConfiguration)get_store().add_element_user(TESTCONFIGURATION$0);
            return target;
        }
    }
}
