package com.zurich.ep.protection.alsb.test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;

import junit.framework.TestCase;
import org.apache.xmlbeans.XmlObject;

import com.zurich.ep.protection.alsb.test.config.ALSBTestConfiguration;
import com.zurich.ep.protection.alsb.test.config.ResponseErrorHandler;

public class ALSBTestCase extends TestCase {
    private String xmlFile;

    private String testName;

    private String testDescription = "no desription provided";

    private Collection<XMLObjectTest> validatorTests;
    
    /**
     * writes the performance results out to a file
     */
    private PerfTestResultsAggregator aggregator;
    
    /**
     * the index number of this test within the suite
     */
    private int testNumber;

    Logger log = Logger.getLogger(this.getClass().getName());

    private File responseXMLDir = new File("C:/temp/ALSBTestOK");

    public void testQuoteScenario() throws Exception {
        
        NewALSBInvoker invoker = NewALSBInvoker.getALSBInvoker();
        Date startTime = new Date();

        XmlResponseInfo info = null;
        try {
            info = invoker.invokeALSB(xmlFile);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }
        Date endTime = new Date();
        assertNotNull(info);
        XmlObject responseObject = info.getResponsePayload();
        
        responseObject.save(new File(responseXMLDir,testNumber+".xml"));
        
        Collection<String> errorMessages = ResponseObjectValidator.validateResponse(info, validatorTests, testName);
        ResponseErrorHandler responseErrorHandler = ALSBTestConfiguration.getResponseErrorHandler();
        responseErrorHandler.handleErrors(responseObject, testName, testDescription, errorMessages);
        
        long millis = (endTime.getTime() - startTime.getTime());
        
        if(aggregator != null){
            try {
                aggregator.addResult(millis);
            } catch (IOException e) {
                log.error("aggregator not initialised properly, will not log performance results: "+e);
            }
        }
        log.info(testNumber+") " + this.getName()+"         ("+millis+" millis)");
        assertTrue(errorMessages.isEmpty());
    }

    @Override
    protected void runTest() throws Throwable {
        testQuoteScenario();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public ALSBTestCase(String testName, String xmlFile, String testDescription, Collection<XMLObjectTest> validatorTests,int testNumber) {
        super(testName);
        this.testName = testName;
        this.xmlFile = xmlFile;
        this.testDescription = testDescription;
        this.validatorTests = validatorTests;
        this.testNumber = testNumber;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public Collection<XMLObjectTest> getValidatorTests() {
        return validatorTests;
    }

    public void setValidatorTests(Collection<XMLObjectTest> validatorTests) {
        this.validatorTests = validatorTests;
    }

    public void addValidatorTest(XMLObjectTest validatorTest) {
        this.validatorTests.add(validatorTest);
    }

    public String getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    public String toString() {
        return this.getTestName() + " " + this.getTestDescription() + " " + this.getXmlFile() + " " + this.validatorTests.size();
    }

    public int getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(int testNumber) {
        this.testNumber = testNumber;
    }

    public PerfTestResultsAggregator getAggregator() {
        return aggregator;
    }

    public void setAggregator(PerfTestResultsAggregator aggregator) {
        this.aggregator = aggregator;
    }
}
