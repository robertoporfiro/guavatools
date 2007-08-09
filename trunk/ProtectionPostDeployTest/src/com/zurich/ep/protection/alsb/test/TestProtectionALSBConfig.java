package com.zurich.ep.protection.alsb.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

public class TestProtectionALSBConfig extends TestCase {

    private String endpointURL = "http://localhost:7021/quote/OrigoProtectionTransformXMLPS";         // localhost
//      private String endpointURL = "http://10.239.252.45:7211/quote/OrigoProtectionTransformXMLPS";     // auto
//      private String endpointURL = "http://10.239.252.48:9111/quote/OrigoProtectionTransformXMLPS";     // EA_UAT
    
    
    private String testXMLDir_ROOT="testXML/";
    private String testXMLDir_TEX = testXMLDir_ROOT+"TEX";
    private String testXMLDir_WEBLINE = testXMLDir_ROOT+"webline";
    
    private List<ALSBProtectionPlusTest> tests = new ArrayList<ALSBProtectionPlusTest>();
    
    public TestProtectionALSBConfig(){
        tests.add(new ALSBProtectionPlusTest(testXMLDir_ROOT+"TEX/onlineQuote1.xml"));
    }

    public void testTEX() throws Exception {
            ALSBInvoker invoker = new ALSBInvoker(endpointURL, testXMLDir_TEX);
            assertTestsWereSucessful(invoker.runALSBTestSuiteFromDir());
    }
    
    public void testWebline() throws Exception {
        ALSBInvoker invoker = new ALSBInvoker(endpointURL, testXMLDir_WEBLINE);
        assertTestsWereSucessful(invoker.runALSBTestSuiteFromDir());
    }
    
    private void assertTestsWereSucessful(Collection<String> errors){
        if(errors.size()>0){
            System.out.println(errors);
            fail("Errors found in invocation results");
        }
    }
}
