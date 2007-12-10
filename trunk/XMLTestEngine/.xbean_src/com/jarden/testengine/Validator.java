/*
 * XML Type:  Validator
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Validator
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine;


/**
 * An XML Validator(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public interface Validator extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Validator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("validatorb38ctype");
    
    /**
     * Gets the "check" element
     */
    com.jarden.testengine.Validator.Check getCheck();
    
    /**
     * True if has "check" element
     */
    boolean isSetCheck();
    
    /**
     * Sets the "check" element
     */
    void setCheck(com.jarden.testengine.Validator.Check check);
    
    /**
     * Appends and returns a new empty "check" element
     */
    com.jarden.testengine.Validator.Check addNewCheck();
    
    /**
     * Unsets the "check" element
     */
    void unsetCheck();
    
    /**
     * Gets a List of "inherit" elements
     */
    java.util.List<com.jarden.testengine.Validator.Inherit> getInheritList();
    
    /**
     * Gets array of all "inherit" elements
     * @deprecated
     */
    com.jarden.testengine.Validator.Inherit[] getInheritArray();
    
    /**
     * Gets ith "inherit" element
     */
    com.jarden.testengine.Validator.Inherit getInheritArray(int i);
    
    /**
     * Returns number of "inherit" element
     */
    int sizeOfInheritArray();
    
    /**
     * Sets array of all "inherit" element
     */
    void setInheritArray(com.jarden.testengine.Validator.Inherit[] inheritArray);
    
    /**
     * Sets ith "inherit" element
     */
    void setInheritArray(int i, com.jarden.testengine.Validator.Inherit inherit);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "inherit" element
     */
    com.jarden.testengine.Validator.Inherit insertNewInherit(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "inherit" element
     */
    com.jarden.testengine.Validator.Inherit addNewInherit();
    
    /**
     * Removes the ith "inherit" element
     */
    void removeInherit(int i);
    
    /**
     * Gets the "name" attribute
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" attribute
     */
    org.apache.xmlbeans.XmlID xgetName();
    
    /**
     * True if has "name" attribute
     */
    boolean isSetName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" attribute
     */
    void xsetName(org.apache.xmlbeans.XmlID name);
    
    /**
     * Unsets the "name" attribute
     */
    void unsetName();
    
    /**
     * An XML check(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public interface Check extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Check.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("check4498elemtype");
        
        /**
         * Gets the "checkType" attribute
         */
        com.jarden.testengine.CheckType.Enum getCheckType();
        
        /**
         * Gets (as xml) the "checkType" attribute
         */
        com.jarden.testengine.CheckType xgetCheckType();
        
        /**
         * True if has "checkType" attribute
         */
        boolean isSetCheckType();
        
        /**
         * Sets the "checkType" attribute
         */
        void setCheckType(com.jarden.testengine.CheckType.Enum checkType);
        
        /**
         * Sets (as xml) the "checkType" attribute
         */
        void xsetCheckType(com.jarden.testengine.CheckType checkType);
        
        /**
         * Unsets the "checkType" attribute
         */
        void unsetCheckType();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.jarden.testengine.Validator.Check newInstance() {
              return (com.jarden.testengine.Validator.Check) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.jarden.testengine.Validator.Check newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.jarden.testengine.Validator.Check) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * An XML inherit(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public interface Inherit extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Inherit.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("inherita185elemtype");
        
        /**
         * Gets the "ref" attribute
         */
        java.lang.String getRef();
        
        /**
         * Gets (as xml) the "ref" attribute
         */
        org.apache.xmlbeans.XmlIDREF xgetRef();
        
        /**
         * True if has "ref" attribute
         */
        boolean isSetRef();
        
        /**
         * Sets the "ref" attribute
         */
        void setRef(java.lang.String ref);
        
        /**
         * Sets (as xml) the "ref" attribute
         */
        void xsetRef(org.apache.xmlbeans.XmlIDREF ref);
        
        /**
         * Unsets the "ref" attribute
         */
        void unsetRef();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.jarden.testengine.Validator.Inherit newInstance() {
              return (com.jarden.testengine.Validator.Inherit) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.jarden.testengine.Validator.Inherit newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.jarden.testengine.Validator.Inherit) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jarden.testengine.Validator newInstance() {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jarden.testengine.Validator newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jarden.testengine.Validator parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jarden.testengine.Validator parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jarden.testengine.Validator parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jarden.testengine.Validator parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jarden.testengine.Validator parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jarden.testengine.Validator parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jarden.testengine.Validator parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jarden.testengine.Validator parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jarden.testengine.Validator parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jarden.testengine.Validator parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jarden.testengine.Validator parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jarden.testengine.Validator parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jarden.testengine.Validator parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jarden.testengine.Validator parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Validator parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Validator parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
