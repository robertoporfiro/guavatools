package jarden.ws.testing.results;

import java.util.Date;

import jarden.ws.testing.metrics.PerformanceResults;

public class ResultsSession {
    private String sessionId;
    private String username;
    private PerformanceResults performanceResults;
    private TestResultsService testResultsService;
    private SessionState sessionState= SessionState.New;
    
    private Date startTime;
    private Date endTime;
    
    
    public void notifyRequestSend(String testName){
        
    }
    
    public void notifyResponseReceive(String testName){
        
    }
    
    
    public SessionState getSessionState() {
        return sessionState;
    }



    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }



    public ResultsSession(String sessionId, String username, TestResultsService service) {
        this.sessionId = sessionId;
        this.username = username;
        this.testResultsService=service;
        startTime = new Date();
    }



    public void addTestMetric(String testName, long invocationTimeInMillis) {
        performanceResults.addTestMetric(testName, invocationTimeInMillis);
    }


    public void endSession(){
        testResultsService.endSession(this.sessionId);
        endTime=new Date();
    }
    
    

    public String getSessionId() {
        return sessionId;
    }



    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public PerformanceResults getPerformanceResults() {
        return performanceResults;
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.sessionState=SessionState.Orphaned;
        this.endSession();
    }
    
    

}
