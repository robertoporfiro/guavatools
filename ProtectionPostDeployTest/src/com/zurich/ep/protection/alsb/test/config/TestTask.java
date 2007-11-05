package com.zurich.ep.protection.alsb.test.config;

/**
 * Defines either a test, or a set of tests to run.
 * @author GBEVVH8
 *
 */
public class TestTask {
    
    /**
     * maps onto a directory full of tests
     */
    private String testName;
    /**
     * which env should we point this to ?
     */
    private String endPointURL;
    
    /**
     * If it is possible to modify the endpoint of the business endpoint, <br>
     * then we can use WLST to log into ALSB and modify it.
     */
    private String backendEnv;
    
    
    
    
    
    public String getBackendEnv() {
        return backendEnv;
    }
    public void setBackendEnv(String backendEnv) {
        this.backendEnv = backendEnv;
    }
    public String getEndPointURL() {
        return endPointURL;
    }
    public void setEndPointURL(String endPointURL) {
        this.endPointURL = endPointURL;
    }
    public String getTestName() {
        return testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }

}
