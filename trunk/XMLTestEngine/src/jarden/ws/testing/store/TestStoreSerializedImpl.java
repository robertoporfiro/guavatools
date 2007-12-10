package jarden.ws.testing.store;

import jarden.ws.testing.PersistanceException;
import jarden.ws.testing.Test;
import jarden.ws.testing.TestSuite;
import jarden.ws.testing.TestSuiteJavaImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class TestStoreSerializedImpl implements TestStore{
    
    private Map<String,Test> testStore;
    private Map<String,TestSuite> testSuiteStore;
    Logger log = Logger.getLogger(this.getClass());
    
    public void addTest(Test test) throws PersistanceException {
        int id = testStore.size()+1;
        test.setId(new Integer(id).toString());
        testStore.put(test.getId(),test);
        setDirty(true);
    }

    public void addTestSuite(String suiteName) throws PersistanceException {
        if(testSuiteStore.containsKey(suiteName)){
            throw new PersistanceException("A test suite with this name already exists");
        }
       TestSuiteJavaImpl suite = new TestSuiteJavaImpl();
       suite.setName(suiteName);
       testSuiteStore.put(suiteName,suite);
       setDirty(true);
    }

    public Collection<Test> getAllTests() throws PersistanceException {
        return testStore.values();
    }

    public TestSuite getTestSuite(String suiteName) throws PersistanceException {
        return testSuiteStore.get(suiteName);
    }

    /**
     * If the test specified doesn't exist, then it is first added to the test store
     */
    public void addTestToSuite(Test test, String suiteName) throws PersistanceException {
        TestSuite suite = testSuiteStore.get(suiteName);
        if(suite == null){
            throw new PersistanceException("this testsuite does not exists: "+suiteName);
        }
        if(! (suite instanceof TestSuiteJavaImpl)){
            throw new PersistanceException("this method can only be used for java tests");
        }
        if(!testStore.containsKey(test.getId())){
            addTest(test);
        }
        setDirty(true);
        ((TestSuiteJavaImpl) suite).addTest(test);
    }

    public void removeTestFromSuite(Test test, String suiteName) throws PersistanceException {
        throw new PersistanceException("This is still unimplemented");
        
    }

    public Test getTest(String testId) throws PersistanceException {
        return testStore.get(testId);
    }
    
    //----------------------------------- Serialized file stuff
    
    private boolean dirty=false;
    
    private void setDirty(boolean b){
     dirty = b;   
    }
    
    private boolean isDirty(){
     return dirty;   
    }
    
    @SuppressWarnings("unchecked")
    private void loadFromDisk(){
        this.testStore = (Map<String, Test>) GenericSerializeStore.read("testStore");
        this.testSuiteStore= (Map<String, TestSuite>) GenericSerializeStore.read("testSuiteStore");
        log.info("test and testsuite stores loaded from disk");
    }
    
    private void storeToDisk(){
        GenericSerializeStore.store("testStore",testStore);
        GenericSerializeStore.store("testSuiteStore",testSuiteStore);
        log.info("test and testsuite stores persisted to disk");
    }

    
    private TestStoreSerializedImpl(){
        testStore = new HashMap<String,Test>();
        testSuiteStore = new HashMap<String,TestSuite>();
        log.info("initialized store maps [warning, not loading from disk.]");
//        loadFromDisk();
        try {
            loadDummyTests();
        } catch (PersistanceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static TestStoreSerializedImpl instance = new TestStoreSerializedImpl();
    public static TestStoreSerializedImpl getInstance(){
        return instance;
    }
    
    private void loadDummyTests() throws PersistanceException{
        log.info("Loading dummy tests");
        Test t = new Test();
        t.setName("simple test 1");
        t.setRequestXMLPath("files/testxml/test1.xml");
        addTest(t);
        addTestSuite("testSuite1");
        addTestToSuite(t,"testSuite1");   
        
        t = new Test();
        t.setName("simple test 2");
        t.setRequestXMLPath("files/testxml/test2.xml");
        addTest(t);
        addTestToSuite(t,"testSuite1");
    }

}
