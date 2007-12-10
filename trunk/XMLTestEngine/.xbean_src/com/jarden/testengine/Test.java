/*
 * XML Type:  Test
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Test
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine;


/**
 * An XML Test(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public interface Test extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Test.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("test521atype");
    
    /**
     * Gets the "description" element
     */
    java.lang.String getDescription();
    
    /**
     * Gets (as xml) the "description" element
     */
    org.apache.xmlbeans.XmlString xgetDescription();
    
    /**
     * True if has "description" element
     */
    boolean isSetDescription();
    
    /**
     * Sets the "description" element
     */
    void setDescription(java.lang.String description);
    
    /**
     * Sets (as xml) the "description" element
     */
    void xsetDescription(org.apache.xmlbeans.XmlString description);
    
    /**
     * Unsets the "description" element
     */
    void unsetDescription();
    
    /**
     * Gets a List of "validator" elements
     */
    java.util.List<com.jarden.testengine.Test.Validator> getValidatorList();
    
    /**
     * Gets array of all "validator" elements
     * @deprecated
     */
    com.jarden.testengine.Test.Validator[] getValidatorArray();
    
    /**
     * Gets ith "validator" element
     */
    com.jarden.testengine.Test.Validator getValidatorArray(int i);
    
    /**
     * Returns number of "validator" element
     */
    int sizeOfValidatorArray();
    
    /**
     * Sets array of all "validator" element
     */
    void setValidatorArray(com.jarden.testengine.Test.Validator[] validatorArray);
    
    /**
     * Sets ith "validator" element
     */
    void setValidatorArray(int i, com.jarden.testengine.Test.Validator validator);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "validator" element
     */
    com.jarden.testengine.Test.Validator insertNewValidator(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "validator" element
     */
    com.jarden.testengine.Test.Validator addNewValidator();
    
    /**
     * Removes the ith "validator" element
     */
    void removeValidator(int i);
    
    /**
     * Gets the "name" attribute
     */
    org.apache.xmlbeans.XmlAnySimpleType getName();
    
    /**
     * Sets the "name" attribute
     */
    void setName(org.apache.xmlbeans.XmlAnySimpleType name);
    
    /**
     * Appends and returns a new empty "name" attribute
     */
    org.apache.xmlbeans.XmlAnySimpleType addNewName();
    
    /**
     * Gets the "validator" attribute
     */
    java.lang.String getValidator2();
    
    /**
     * Gets (as xml) the "validator" attribute
     */
    org.apache.xmlbeans.XmlIDREF xgetValidator2();
    
    /**
     * True if has "validator" attribute
     */
    boolean isSetValidator2();
    
    /**
     * Sets the "validator" attribute
     */
    void setValidator2(java.lang.String validator2);
    
    /**
     * Sets (as xml) the "validator" attribute
     */
    void xsetValidator2(org.apache.xmlbeans.XmlIDREF validator2);
    
    /**
     * Unsets the "validator" attribute
     */
    void unsetValidator2();
    
    /**
     * Gets the "inputFile" attribute
     */
    org.apache.xmlbeans.XmlAnySimpleType getInputFile();
    
    /**
     * Sets the "inputFile" attribute
     */
    void setInputFile(org.apache.xmlbeans.XmlAnySimpleType inputFile);
    
    /**
     * Appends and returns a new empty "inputFile" attribute
     */
    org.apache.xmlbeans.XmlAnySimpleType addNewInputFile();
    
    /**
     * An XML validator(@http://www.jarden.com/testengine).
     *
     * This is a complex type.
     */
    public interface Validator extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Validator.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("validator69d8elemtype");
        
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
            public static com.jarden.testengine.Test.Validator newInstance() {
              return (com.jarden.testengine.Test.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.jarden.testengine.Test.Validator newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.jarden.testengine.Test.Validator) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jarden.testengine.Test newInstance() {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jarden.testengine.Test newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jarden.testengine.Test parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jarden.testengine.Test parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jarden.testengine.Test parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jarden.testengine.Test parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jarden.testengine.Test parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jarden.testengine.Test parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jarden.testengine.Test parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jarden.testengine.Test parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jarden.testengine.Test parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jarden.testengine.Test parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jarden.testengine.Test parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jarden.testengine.Test parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jarden.testengine.Test parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jarden.testengine.Test parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Test parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Test parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Test) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
