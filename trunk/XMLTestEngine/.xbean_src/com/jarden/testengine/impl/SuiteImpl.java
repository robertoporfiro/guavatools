/*
 * XML Type:  Suite
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Suite
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML Suite(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class SuiteImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Suite
{
    
    public SuiteImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TEST$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "test");
    private static final javax.xml.namespace.QName NAME$2 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName VALIDATOR$4 = 
        new javax.xml.namespace.QName("", "validator");
    
    
    /**
     * Gets a List of "test" elements
     */
    public java.util.List<com.jarden.testengine.Test> getTestList()
    {
        final class TestList extends java.util.AbstractList<com.jarden.testengine.Test>
        {
            public com.jarden.testengine.Test get(int i)
                { return SuiteImpl.this.getTestArray(i); }
            
            public com.jarden.testengine.Test set(int i, com.jarden.testengine.Test o)
            {
                com.jarden.testengine.Test old = SuiteImpl.this.getTestArray(i);
                SuiteImpl.this.setTestArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Test o)
                { SuiteImpl.this.insertNewTest(i).set(o); }
            
            public com.jarden.testengine.Test remove(int i)
            {
                com.jarden.testengine.Test old = SuiteImpl.this.getTestArray(i);
                SuiteImpl.this.removeTest(i);
                return old;
            }
            
            public int size()
                { return SuiteImpl.this.sizeOfTestArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new TestList();
        }
    }
    
    /**
     * Gets array of all "test" elements
     */
    public com.jarden.testengine.Test[] getTestArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(TEST$0, targetList);
            com.jarden.testengine.Test[] result = new com.jarden.testengine.Test[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "test" element
     */
    public com.jarden.testengine.Test getTestArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test target = null;
            target = (com.jarden.testengine.Test)get_store().find_element_user(TEST$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "test" element
     */
    public int sizeOfTestArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TEST$0);
        }
    }
    
    /**
     * Sets array of all "test" element
     */
    public void setTestArray(com.jarden.testengine.Test[] testArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(testArray, TEST$0);
        }
    }
    
    /**
     * Sets ith "test" element
     */
    public void setTestArray(int i, com.jarden.testengine.Test test)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test target = null;
            target = (com.jarden.testengine.Test)get_store().find_element_user(TEST$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(test);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "test" element
     */
    public com.jarden.testengine.Test insertNewTest(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test target = null;
            target = (com.jarden.testengine.Test)get_store().insert_element_user(TEST$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "test" element
     */
    public com.jarden.testengine.Test addNewTest()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test target = null;
            target = (com.jarden.testengine.Test)get_store().add_element_user(TEST$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "test" element
     */
    public void removeTest(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TEST$0, i);
        }
    }
    
    /**
     * Gets the "name" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "name" attribute
     */
    public void setName(org.apache.xmlbeans.XmlAnySimpleType name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(NAME$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(NAME$2);
            }
            target.set(name);
        }
    }
    
    /**
     * Appends and returns a new empty "name" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType addNewName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(NAME$2);
            return target;
        }
    }
    
    /**
     * Gets the "validator" attribute
     */
    public java.lang.String getValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATOR$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "validator" attribute
     */
    public org.apache.xmlbeans.XmlIDREF xgetValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(VALIDATOR$4);
            return target;
        }
    }
    
    /**
     * True if has "validator" attribute
     */
    public boolean isSetValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(VALIDATOR$4) != null;
        }
    }
    
    /**
     * Sets the "validator" attribute
     */
    public void setValidator(java.lang.String validator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATOR$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALIDATOR$4);
            }
            target.setStringValue(validator);
        }
    }
    
    /**
     * Sets (as xml) the "validator" attribute
     */
    public void xsetValidator(org.apache.xmlbeans.XmlIDREF validator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(VALIDATOR$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlIDREF)get_store().add_attribute_user(VALIDATOR$4);
            }
            target.set(validator);
        }
    }
    
    /**
     * Unsets the "validator" attribute
     */
    public void unsetValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(VALIDATOR$4);
        }
    }
}
