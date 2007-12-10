/*
 * XML Type:  Tests
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Tests
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML Tests(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class TestsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Tests
{
    
    public TestsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TEST$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "test");
    private static final javax.xml.namespace.QName SUITE$2 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "suite");
    private static final javax.xml.namespace.QName ROOTDIR$4 = 
        new javax.xml.namespace.QName("", "rootDir");
    
    
    /**
     * Gets a List of "test" elements
     */
    public java.util.List<com.jarden.testengine.Test> getTestList()
    {
        final class TestList extends java.util.AbstractList<com.jarden.testengine.Test>
        {
            public com.jarden.testengine.Test get(int i)
                { return TestsImpl.this.getTestArray(i); }
            
            public com.jarden.testengine.Test set(int i, com.jarden.testengine.Test o)
            {
                com.jarden.testengine.Test old = TestsImpl.this.getTestArray(i);
                TestsImpl.this.setTestArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Test o)
                { TestsImpl.this.insertNewTest(i).set(o); }
            
            public com.jarden.testengine.Test remove(int i)
            {
                com.jarden.testengine.Test old = TestsImpl.this.getTestArray(i);
                TestsImpl.this.removeTest(i);
                return old;
            }
            
            public int size()
                { return TestsImpl.this.sizeOfTestArray(); }
            
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
     * Gets a List of "suite" elements
     */
    public java.util.List<com.jarden.testengine.Suite> getSuiteList()
    {
        final class SuiteList extends java.util.AbstractList<com.jarden.testengine.Suite>
        {
            public com.jarden.testengine.Suite get(int i)
                { return TestsImpl.this.getSuiteArray(i); }
            
            public com.jarden.testengine.Suite set(int i, com.jarden.testengine.Suite o)
            {
                com.jarden.testengine.Suite old = TestsImpl.this.getSuiteArray(i);
                TestsImpl.this.setSuiteArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Suite o)
                { TestsImpl.this.insertNewSuite(i).set(o); }
            
            public com.jarden.testengine.Suite remove(int i)
            {
                com.jarden.testengine.Suite old = TestsImpl.this.getSuiteArray(i);
                TestsImpl.this.removeSuite(i);
                return old;
            }
            
            public int size()
                { return TestsImpl.this.sizeOfSuiteArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new SuiteList();
        }
    }
    
    /**
     * Gets array of all "suite" elements
     */
    public com.jarden.testengine.Suite[] getSuiteArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(SUITE$2, targetList);
            com.jarden.testengine.Suite[] result = new com.jarden.testengine.Suite[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "suite" element
     */
    public com.jarden.testengine.Suite getSuiteArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Suite target = null;
            target = (com.jarden.testengine.Suite)get_store().find_element_user(SUITE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "suite" element
     */
    public int sizeOfSuiteArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(SUITE$2);
        }
    }
    
    /**
     * Sets array of all "suite" element
     */
    public void setSuiteArray(com.jarden.testengine.Suite[] suiteArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(suiteArray, SUITE$2);
        }
    }
    
    /**
     * Sets ith "suite" element
     */
    public void setSuiteArray(int i, com.jarden.testengine.Suite suite)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Suite target = null;
            target = (com.jarden.testengine.Suite)get_store().find_element_user(SUITE$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(suite);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "suite" element
     */
    public com.jarden.testengine.Suite insertNewSuite(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Suite target = null;
            target = (com.jarden.testengine.Suite)get_store().insert_element_user(SUITE$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "suite" element
     */
    public com.jarden.testengine.Suite addNewSuite()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Suite target = null;
            target = (com.jarden.testengine.Suite)get_store().add_element_user(SUITE$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "suite" element
     */
    public void removeSuite(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(SUITE$2, i);
        }
    }
    
    /**
     * Gets the "rootDir" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType getRootDir()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(ROOTDIR$4);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "rootDir" attribute
     */
    public void setRootDir(org.apache.xmlbeans.XmlAnySimpleType rootDir)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(ROOTDIR$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(ROOTDIR$4);
            }
            target.set(rootDir);
        }
    }
    
    /**
     * Appends and returns a new empty "rootDir" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType addNewRootDir()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(ROOTDIR$4);
            return target;
        }
    }
}
