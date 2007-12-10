package jarden.ws.testing.metrics;

public class TestMetric {
    private String testName;
    private long invocationTimeInMillis;
    public TestMetric(String testName, long invocationTimeInMillis) {
        this.testName = testName;
        this.invocationTimeInMillis = invocationTimeInMillis;
    }
    public long getInvocationTimeInMillis() {
        return invocationTimeInMillis;
    }
   
    public String getTestName() {
        return testName;
    }
    
}
