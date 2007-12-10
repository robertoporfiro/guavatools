package jarden.ws.testing.results;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class TestResultsServiceSimpleImpl implements TestResultsService {
    Random random = new Random(new Date().getTime());   // to create the session IDs
    private static long sessionCounter = 0;
    HashMap<String,ResultsSession> sessionStore = new HashMap<String,ResultsSession>();
    
    public ResultsSession beginSession(String username) {
        // get next session:
        String salt = Integer.toHexString(random.nextInt());
        salt = salt.substring(0,(salt.length()>5?6:salt.length()));
        StringBuffer buf = new StringBuffer(username);
        buf.append("-");
        buf.append(++sessionCounter);
        buf.append("-");
        buf.append(salt);
        
        String sessionId = buf.toString();
        ResultsSession session = new ResultsSession(sessionId,username,this);
        sessionStore.put(sessionId,session);
        
        return session;
    }

    public ResultsSession getCurrentSession(String sessionId) {
        ResultsSession session = this.sessionStore.get(sessionId);
        return session;
    }

    public void endSession(String sessionId) {
        ResultsSession session = getCurrentSession(sessionId);
        if(session != null){
            session.endSession();
        }
    }

    public Collection<ResultsSession> getAllSessions() {
        return this.sessionStore.values();
    }

    public Collection<ResultsSession> getLastNSessions(int noOfSessions) {
        throw new RuntimeException("This method is not yet implemented");
    }

    public Collection<ResultsSession> getSessionsForUser(String username) {
        Collection<ResultsSession> thisUsersStuff = new ArrayList<ResultsSession>();
        for(ResultsSession s : this.sessionStore.values()){
            if(s.getUsername().equals(username)){
                thisUsersStuff.add(s);
            }
        }
        return thisUsersStuff;
    }

    public void purgeSessions() {
        // need to purge only  non-active sessions
        for(String sessionId : this.sessionStore.keySet()){
            ResultsSession session = sessionStore.get(sessionId);
            SessionState state =session.getSessionState();
            if(state != SessionState.New && state != SessionState.Started ){
                sessionStore.remove(sessionId);
            }
        }
    }

    public void purgeOldSessions(Date olderThanDate) {
        throw new RuntimeException("This method is not yet implemented");

    }

}
