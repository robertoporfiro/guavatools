package jarden.ws.testing.results;

import java.util.Collection;
import java.util.Date;

public interface TestResultsService {
    public ResultsSession beginSession(String username);
    public ResultsSession getCurrentSession(String sessionId);
    public void endSession(String sessionId);
    public Collection<ResultsSession> getAllSessions();
    public Collection<ResultsSession> getLastNSessions(int noOfSessions);
    public Collection<ResultsSession> getSessionsForUser(String username);
    public void purgeSessions();
    public void purgeOldSessions(Date olderThanDate);
    
}
