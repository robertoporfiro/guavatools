package com.zurich.ep.protection.alsb.test;

public class XMLObjectTest {
    /*
     * Jython doesn't support enums, so we have to use this tweedy syntax of yore
     */
    public final static String EXISTS="EXISTS";
    public final static String NOT_EXISTS="NOT EXISTS";
    public final static String EMPTY="EMPTY";
    public final static String EQUALS="EQUALS";
    public final static String IS_NULL="IS_NULL";
    public final static String NOT_NULL="NOT_NULL";
    public final static String CONTAINS="CONTAINS";
    
    
    String testType = EXISTS;
    String xpath;
    String value;
    String testName="NO NAME GIVEN";
    
    public XMLObjectTest(String name,String testType, String xpath) {
        this.testType = testType;
        this.xpath = xpath;
        this.testName = name;
    }
    
    public XMLObjectTest(String name,String testType, String xpath, String value) {
        if(! testType.equals(EQUALS) && !testType.equals(CONTAINS)){
            throw new RuntimeException("This constructor can only be used when comparing a value using the EQUALS or CONTAINS type");
        }
        this.testType = testType;
        this.xpath = xpath;
        this.value = value;
        this.testName = name;
    }
    public String getTestType() {
        return testType;
    }
    public void setTestType(String testType) {
        this.testType = testType;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getXpath() {
        return xpath;
    }
    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
   

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

}
