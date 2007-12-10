/*
 * XML Type:  Validator
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Validator
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine.impl;
/**
 * An XML Validator(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public class ValidatorImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Validator
{
    
    public ValidatorImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECK$0 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "check");
    private static final javax.xml.namespace.QName INHERIT$2 = 
        new javax.xml.namespace.QName("http://www.jarden.com/testengine", "inherit");
    private static final javax.xml.namespace.QName NAME$4 = 
        new javax.xml.namespace.QName("", "name");
    
    
    /**
     * Gets the "check" element
     */
    public com.jarden.testengine.Validator.Check getCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Check target = null;
            target = (com.jarden.testengine.Validator.Check)get_store().find_element_user(CHECK$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "check" element
     */
    public boolean isSetCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CHECK$0) != 0;
        }
    }
    
    /**
     * Sets the "check" element
     */
    public void setCheck(com.jarden.testengine.Validator.Check check)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Check target = null;
            target = (com.jarden.testengine.Validator.Check)get_store().find_element_user(CHECK$0, 0);
            if (target == null)
            {
                target = (com.jarden.testengine.Validator.Check)get_store().add_element_user(CHECK$0);
            }
            target.set(check);
        }
    }
    
    /**
     * Appends and returns a new empty "check" element
     */
    public com.jarden.testengine.Validator.Check addNewCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Check target = null;
            target = (com.jarden.testengine.Validator.Check)get_store().add_element_user(CHECK$0);
            return target;
        }
    }
    
    /**
     * Unsets the "check" element
     */
    public void unsetCheck()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CHECK$0, 0);
        }
    }
    
    /**
     * Gets a List of "inherit" elements
     */
    public java.util.List<com.jarden.testengine.Validator.Inherit> getInheritList()
    {
        final class InheritList extends java.util.AbstractList<com.jarden.testengine.Validator.Inherit>
        {
            public com.jarden.testengine.Validator.Inherit get(int i)
                { return ValidatorImpl.this.getInheritArray(i); }
            
            public com.jarden.testengine.Validator.Inherit set(int i, com.jarden.testengine.Validator.Inherit o)
            {
                com.jarden.testengine.Validator.Inherit old = ValidatorImpl.this.getInheritArray(i);
                ValidatorImpl.this.setInheritArray(i, o);
                return old;
            }
            
            public void add(int i, com.jarden.testengine.Validator.Inherit o)
                { ValidatorImpl.this.insertNewInherit(i).set(o); }
            
            public com.jarden.testengine.Validator.Inherit remove(int i)
            {
                com.jarden.testengine.Validator.Inherit old = ValidatorImpl.this.getInheritArray(i);
                ValidatorImpl.this.removeInherit(i);
                return old;
            }
            
            public int size()
                { return ValidatorImpl.this.sizeOfInheritArray(); }
            
        }
        
        synchronized (monitor())
        {
            check_orphaned();
            return new InheritList();
        }
    }
    
    /**
     * Gets array of all "inherit" elements
     */
    public com.jarden.testengine.Validator.Inherit[] getInheritArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(INHERIT$2, targetList);
            com.jarden.testengine.Validator.Inherit[] result = new com.jarden.testengine.Validator.Inherit[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "inherit" element
     */
    public com.jarden.testengine.Validator.Inherit getInheritArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Inherit target = null;
            target = (com.jarden.testengine.Validator.Inherit)get_store().find_element_user(INHERIT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "inherit" element
     */
    public int sizeOfInheritArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INHERIT$2);
        }
    }
    
    /**
     * Sets array of all "inherit" element
     */
    public void setInheritArray(com.jarden.testengine.Validator.Inherit[] inheritArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(inheritArray, INHERIT$2);
        }
    }
    
    /**
     * Sets ith "inherit" element
     */
    public void setInheritArray(int i, com.jarden.testengine.Validator.Inherit inherit)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Inherit target = null;
            target = (com.jarden.testengine.Validator.Inherit)get_store().find_element_user(INHERIT$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(inherit);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "inherit" element
     */
    public com.jarden.testengine.Validator.Inherit insertNewInherit(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Inherit target = null;
            target = (com.jarden.testengine.Validator.Inherit)get_store().insert_element_user(INHERIT$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "inherit" element
     */
    public com.jarden.testengine.Validator.Inherit addNewInherit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jarden.testengine.Validator.Inherit target = null;
            target = (com.jarden.testengine.Validator.Inherit)get_store().add_element_user(INHERIT$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "inherit" element
     */
    public void removeInherit(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INHERIT$2, i);
        }
    }
    
    /**
     * Gets the "name" attribute
     */
    public java.lang.String getName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "name" attribute
     */
    public org.apache.xmlbeans.XmlID xgetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlID target = null;
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(NAME$4);
            return target;
        }
    }
    
    /**
     * True if has "name" attribute
     */
    public boolean isSetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(NAME$4) != null;
        }
    }
    
    /**
     * Sets the "name" attribute
     */
    public void setName(java.lang.String name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$4);
            }
            target.setStringValue(name);
        }
    }
    
    /**
     * Sets (as xml) the "name" attribute
     */
    public void xsetName(org.apache.xmlbeans.XmlID name)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlID target = null;
            target = (org.apache.xmlbeans.XmlID)get_store().find_attribute_user(NAME$4);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlID)get_store().add_attribute_user(NAME$4);
            }
            target.set(name);
        }
    }
    
    /**
     * Unsets the "name" attribute
     */
    public void unsetName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(NAME$4);
        }
    }
    /**
     * An XML check(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public static class CheckImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Validator.Check
    {
        
        public CheckImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CHECKTYPE$0 = 
            new javax.xml.namespace.QName("", "checkType");
        
        
        /**
         * Gets the "checkType" attribute
         */
        public com.jarden.testengine.CheckType.Enum getCheckType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHECKTYPE$0);
                if (target == null)
                {
                    return null;
                }
                return (com.jarden.testengine.CheckType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "checkType" attribute
         */
        public com.jarden.testengine.CheckType xgetCheckType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jarden.testengine.CheckType target = null;
                target = (com.jarden.testengine.CheckType)get_store().find_attribute_user(CHECKTYPE$0);
                return target;
            }
        }
        
        /**
         * True if has "checkType" attribute
         */
        public boolean isSetCheckType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(CHECKTYPE$0) != null;
            }
        }
        
        /**
         * Sets the "checkType" attribute
         */
        public void setCheckType(com.jarden.testengine.CheckType.Enum checkType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CHECKTYPE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CHECKTYPE$0);
                }
                target.setEnumValue(checkType);
            }
        }
        
        /**
         * Sets (as xml) the "checkType" attribute
         */
        public void xsetCheckType(com.jarden.testengine.CheckType checkType)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jarden.testengine.CheckType target = null;
                target = (com.jarden.testengine.CheckType)get_store().find_attribute_user(CHECKTYPE$0);
                if (target == null)
                {
                    target = (com.jarden.testengine.CheckType)get_store().add_attribute_user(CHECKTYPE$0);
                }
                target.set(checkType);
            }
        }
        
        /**
         * Unsets the "checkType" attribute
         */
        public void unsetCheckType()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(CHECKTYPE$0);
            }
        }
    }
    /**
     * An XML inherit(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public static class InheritImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jarden.testengine.Validator.Inherit
    {
        
        public InheritImpl(org.apache.xmlbeans.SchemaType sType)
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
