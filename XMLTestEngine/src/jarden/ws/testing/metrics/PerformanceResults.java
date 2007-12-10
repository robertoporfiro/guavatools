package jarden.ws.testing.metrics;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceResults {
    
    Collection<TestMetric> metrics = new ArrayList<TestMetric>();
    
    public void addTestMetric(String testName,long invocationTimeInMillis){
        TestMetric metric = new TestMetric(testName,invocationTimeInMillis);
        metrics.add(metric);        
    }

    public Collection<TestMetric> getMetrics() {
        return metrics;
    }
    
    public long getAverageInvocationTimeInMillis(){
        return getTotalInvocationTimeInMillis() / getNumberOfTests();
    }
    
    public long getTotalInvocationTimeInMillis(){
        long totalInvTime=0;
        for(TestMetric m : metrics){
            totalInvTime +=m.getInvocationTimeInMillis();
        }
        return totalInvTime;
    }
    
    public int getNumberOfTests(){
        return metrics.size();
    }
}
