package jarden.ws.testing.store;

import jarden.ws.testing.PersistanceException;
import jarden.ws.testing.Test;
import jarden.ws.testing.TestSuite;

import java.util.Collection;

public interface TestStore {
    
    public void addTest(Test test) throws PersistanceException;
    public void addTestSuite(String suiteName) throws PersistanceException;
    public Collection<Test> getAllTests() throws PersistanceException;
    public TestSuite getTestSuite(String suiteName) throws PersistanceException;
    public void addTestToSuite(Test test, String suiteName) throws PersistanceException;;
    public void removeTestFromSuite(Test test, String suiteName) throws PersistanceException;;    
    public Test getTest(String testId) throws PersistanceException;;

}
