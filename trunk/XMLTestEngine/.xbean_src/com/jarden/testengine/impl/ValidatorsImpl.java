/*
 * XML Type:  Validators
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Validators
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML Validators(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class ValidatorsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Validators
{
    
    public ValidatorsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VALIDATOR$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "validator");
    
    
    /**
     * Gets a List of "validator" elements
     */
    public java.util.List<com.jarden.testengine.Validator> getValidatorList()
    {
        final class ValidatorList extends java.util.AbstractList<com.jarden.testengine.Validator>
        {
            public com.jarden.testengine.Validator get(int i)
                { return ValidatorsImpl.this.getValidatorArray(i); }
            
            public com.jarden.testengine.Validator set(int i, com.jarden.testengine.Validator o)
            {
                com.jarden.testengine.Validator old = ValidatorsImpl.this.getValidatorArray(i);
                ValidatorsImpl.this.setValidatorArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Validator o)
                { ValidatorsImpl.this.insertNewValidator(i).set(o); }
            
            public com.jarden.testengine.Validator remove(int i)
            {
                com.jarden.testengine.Validator old = ValidatorsImpl.this.getValidatorArray(i);
                ValidatorsImpl.this.removeValidator(i);
                return old;
            }
            
            public int size()
                { return ValidatorsImpl.this.sizeOfValidatorArray(); }
            
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
    public com.jarden.testengine.Validator[] getValidatorArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(VALIDATOR$0, targetList);
            com.jarden.testengine.Validator[] result = new com.jarden.testengine.Validator[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "validator" element
     */
    public com.jarden.testengine.Validator getValidatorArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator target = null;
            target = (com.jarden.testengine.Validator)get_store().find_element_user(VALIDATOR$0, i);
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
            return get_store().count_elements(VALIDATOR$0);
        }
    }
    
    /**
     * Sets array of all "validator" element
     */
    public void setValidatorArray(com.jarden.testengine.Validator[] validatorArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(validatorArray, VALIDATOR$0);
        }
    }
    
    /**
     * Sets ith "validator" element
     */
    public void setValidatorArray(int i, com.jarden.testengine.Validator validator)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator target = null;
            target = (com.jarden.testengine.Validator)get_store().find_element_user(VALIDATOR$0, i);
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
    public com.jarden.testengine.Validator insertNewValidator(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator target = null;
            target = (com.jarden.testengine.Validator)get_store().insert_element_user(VALIDATOR$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "validator" element
     */
    public com.jarden.testengine.Validator addNewValidator()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator target = null;
            target = (com.jarden.testengine.Validator)get_store().add_element_user(VALIDATOR$0);
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
            get_store().remove_element(VALIDATOR$0, i);
        }
    }
}
