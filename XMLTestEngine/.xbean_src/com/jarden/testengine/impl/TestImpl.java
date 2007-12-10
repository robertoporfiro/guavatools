/*
 * XML Type:  Test
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Test
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML Test(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class TestImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Test
{
    
    public TestImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DESCRIPTION$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "description");
    private static final javax.xml.namespace.QName VALIDATOR$2 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "validator");
    private static final javax.xml.namespace.QName NAME$4 = 
        new javax.xml.namespace.QName("", "name");
    private static final javax.xml.namespace.QName VALIDATOR2$6 = 
        new javax.xml.namespace.QName("", "validator");
    private static final javax.xml.namespace.QName INPUTFILE$8 = 
        new javax.xml.namespace.QName("", "inputFile");
    
    
    /**
     * Gets the "description" element
     */
    public java.lang.String getDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "description" element
     */
    public org.apache.xmlbeans.XmlString xgetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "description" element
     */
    public boolean isSetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DESCRIPTION$0) != 0;
        }
    }
    
    /**
     * Sets the "description" element
     */
    public void setDescription(java.lang.String description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DESCRIPTION$0);
            }
            target.setStringValue(description);
        }
    }
    
    /**
     * Sets (as xml) the "description" element
     */
    public void xsetDescription(org.apache.xmlbeans.XmlString description)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DESCRIPTION$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DESCRIPTION$0);
            }
            target.set(description);
        }
    }
    
    /**
     * Unsets the "description" element
     */
    public void unsetDescription()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DESCRIPTION$0, 0);
        }
    }
    
    /**
     * Gets a List of "validator" elements
     */
    public java.util.List<com.jarden.testengine.Test.Validator> getValidatorList()
    {
        final class ValidatorList extends java.util.AbstractList<com.jarden.testengine.Test.Validator>
        {
            public com.jarden.testengine.Test.Validator get(int i)
                { return TestImpl.this.getValidatorArray(i); }
            
            public com.jarden.testengine.Test.Validator set(int i, com.jarden.testengine.Test.Validator o)
            {
                com.jarden.testengine.Test.Validator old = TestImpl.this.getValidatorArray(i);
                TestImpl.this.setValidatorArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Test.Validator o)
                { TestImpl.this.insertNewValidator(i).set(o); }
            
            public com.jarden.testengine.Test.Validator remove(int i)
            {
                com.jarden.testengine.Test.Validator old = TestImpl.this.getValidatorArray(i);
                TestImpl.this.removeValidator(i);
                return old;
            }
            
            public int size()
                { return TestImpl.this.sizeOfValidatorArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new ValidatorList();
        }
    }
    
    /**
     * Gets array of all "validator" elements
     */
    public com.jarden.testengine.Test.Validator[] getValidatorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VALIDATOR$2, targetList);
            com.jarden.testengine.Test.Validator[] result = new com.jarden.testengine.Test.Validator[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "validator" element
     */
    public com.jarden.testengine.Test.Validator getValidatorArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test.Validator target = null;
            target = (com.jarden.testengine.Test.Validator)get_store().find_element_user(VALIDATOR$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "validator" element
     */
    public int sizeOfValidatorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(VALIDATOR$2);
        }
    }
    
    /**
     * Sets array of all "validator" element
     */
    public void setValidatorArray(com.jarden.testengine.Test.Validator[] validatorArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(validatorArray, VALIDATOR$2);
        }
    }
    
    /**
     * Sets ith "validator" element
     */
    public void setValidatorArray(int i, com.jarden.testengine.Test.Validator validator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test.Validator target = null;
            target = (com.jarden.testengine.Test.Validator)get_store().find_element_user(VALIDATOR$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(validator);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "validator" element
     */
    public com.jarden.testengine.Test.Validator insertNewValidator(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test.Validator target = null;
            target = (com.jarden.testengine.Test.Validator)get_store().insert_element_user(VALIDATOR$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "validator" element
     */
    public com.jarden.testengine.Test.Validator addNewValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Test.Validator target = null;
            target = (com.jarden.testengine.Test.Validator)get_store().add_element_user(VALIDATOR$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "validator" element
     */
    public void removeValidator(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(VALIDATOR$2, i);
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
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(NAME$4);
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
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(NAME$4);
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
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(NAME$4);
            return target;
        }
    }
    
    /**
     * Gets the "validator" attribute
     */
    public java.lang.String getValidator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATOR2$6);
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
    public org.apache.xmlbeans.XmlIDREF xgetValidator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(VALIDATOR2$6);
            return target;
        }
    }
    
    /**
     * True if has "validator" attribute
     */
    public boolean isSetValidator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(VALIDATOR2$6) != null;
        }
    }
    
    /**
     * Sets the "validator" attribute
     */
    public void setValidator2(java.lang.String validator2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATOR2$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALIDATOR2$6);
            }
            target.setStringValue(validator2);
        }
    }
    
    /**
     * Sets (as xml) the "validator" attribute
     */
    public void xsetValidator2(org.apache.xmlbeans.XmlIDREF validator2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlIDREF target = null;
            target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(VALIDATOR2$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlIDREF)get_store().add_attribute_user(VALIDATOR2$6);
            }
            target.set(validator2);
        }
    }
    
    /**
     * Unsets the "validator" attribute
     */
    public void unsetValidator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(VALIDATOR2$6);
        }
    }
    
    /**
     * Gets the "inputFile" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType getInputFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(INPUTFILE$8);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "inputFile" attribute
     */
    public void setInputFile(org.apache.xmlbeans.XmlAnySimpleType inputFile)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().find_attribute_user(INPUTFILE$8);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(INPUTFILE$8);
            }
            target.set(inputFile);
        }
    }
    
    /**
     * Appends and returns a new empty "inputFile" attribute
     */
    public org.apache.xmlbeans.XmlAnySimpleType addNewInputFile()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlAnySimpleType target = null;
            target = (org.apache.xmlbeans.XmlAnySimpleType)get_store().add_attribute_user(INPUTFILE$8);
            return target;
        }
    }
    /**
     * An XML validator(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public static class ValidatorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Test.Validator
    {
        
        public ValidatorImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName REF$0 = 
            new javax.xml.namespace.QName("", "ref");
        
        
        /**
         * Gets the "ref" attribute
         */
        public java.lang.String getRef()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REF$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "ref" attribute
         */
        public org.apache.xmlbeans.XmlIDREF xgetRef()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlIDREF target = null;
                target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(REF$0);
                return target;
            }
        }
        
        /**
         * True if has "ref" attribute
         */
        public boolean isSetRef()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(REF$0) != null;
            }
        }
        
        /**
         * Sets the "ref" attribute
         */
        public void setRef(java.lang.String ref)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REF$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REF$0);
                }
                target.setStringValue(ref);
            }
        }
        
        /**
         * Sets (as xml) the "ref" attribute
         */
        public void xsetRef(org.apache.xmlbeans.XmlIDREF ref)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlIDREF target = null;
                target = (org.apache.xmlbeans.XmlIDREF)get_store().find_attribute_user(REF$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlIDREF)get_store().add_attribute_user(REF$0);
                }
                target.set(ref);
            }
        }
        
        /**
         * Unsets the "ref" attribute
         */
        public void unsetRef()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(REF$0);
            }
        }
    }
}
