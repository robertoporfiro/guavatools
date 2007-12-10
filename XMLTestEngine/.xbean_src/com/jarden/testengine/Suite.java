/*
 * XML Type:  Suite
 * Namespace: http://www.jarden.com/testengine
 * Java type: com.jarden.testengine.Suite
 *
 * Automatically generated - do not modify.
 */
package com.jarden.testengine;


/**
 * An XML Suite(@http://www.jarden.com/testengine).
 *
 * This is a complex type.
 */
public interface Suite extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Suite.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.PostDeployTestEngineTypeSystem").resolveHandle("suite0126type");
    
    /**
     * Gets a List of "test" elements
     */
    java.util.List<com.jarden.testengine.Test> getTestList();
    
    /**
     * Gets array of all "test" elements
     * @deprecated
     */
    com.jarden.testengine.Test[] getTestArray();
    
    /**
     * Gets ith "test" element
     */
    com.jarden.testengine.Test getTestArray(int i);
    
    /**
     * Returns number of "test" element
     */
    int sizeOfTestArray();
    
    /**
     * Sets array of all "test" element
     */
    void setTestArray(com.jarden.testengine.Test[] testArray);
    
    /**
     * Sets ith "test" element
     */
    void setTestArray(int i, com.jarden.testengine.Test test);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "test" element
     */
    com.jarden.testengine.Test insertNewTest(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "test" element
     */
    com.jarden.testengine.Test addNewTest();
    
    /**
     * Removes the ith "test" element
     */
    void removeTest(int i);
    
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
    java.lang.String getValidator();
    
    /**
     * Gets (as xml) the "validator" attribute
     */
    org.apache.xmlbeans.XmlIDREF xgetValidator();
    
    /**
     * True if has "validator" attribute
     */
    boolean isSetValidator();
    
    /**
     * Sets the "validator" attribute
     */
    void setValidator(java.lang.String validator);
    
    /**
     * Sets (as xml) the "validator" attribute
     */
    void xsetValidator(org.apache.xmlbeans.XmlIDREF validator);
    
    /**
     * Unsets the "validator" attribute
     */
    void unsetValidator();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jarden.testengine.Suite newInstance() {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jarden.testengine.Suite newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jarden.testengine.Suite parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jarden.testengine.Suite parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jarden.testengine.Suite parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jarden.testengine.Suite parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jarden.testengine.Suite parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jarden.testengine.Suite parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jarden.testengine.Suite parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jarden.testengine.Suite parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jarden.testengine.Suite parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jarden.testengine.Suite parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jarden.testengine.Suite parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jarden.testengine.Suite parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jarden.testengine.Suite parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jarden.testengine.Suite parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Suite parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static com.jarden.testengine.Suite parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jarden.testengine.Suite) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
