package jarden.ws.testing.engine;

import jarden.ws.testing.PersistanceException;
import jarden.ws.testing.Test;
import jarden.ws.testing.TestEngineApplication;
import jarden.ws.testing.TestSuite;
import jarden.ws.testing.TestSuiteJythonImpl;
import jarden.ws.testing.store.TestStore;

import java.util.Collection;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class TestTestEngine extends TestCase {
    TestEngineApplication app;
    private TestStore testStore;
    private Logger log = Logger.getLogger(this.getClass());
     
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        log.info("setup called");
        app = new TestEngineApplication();
        testStore = app.getTestStore();
    }

    
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        log.info("tearDown called");
        testStore = null;
        app = null;
    }



    public void testTestStore() throws PersistanceException{
        TestSuite suite = testStore.getTestSuite("testSuite1");
        Collection tests = suite.getTests();
        assertTrue(tests.size() >0);
    }


    public void testRunTestSuite() {
        TestEngine engine = app.getEngine();
        try {
            engine.runTestSuite("testSuite1","Peet");
        } catch (Exception e) {
            e.printStackTrace();
           fail("Exception thrown: "+e);
        }
    }
    
    public void testTestSuiteJythonImpl(){
        TestSuiteJythonImpl suite = new TestSuiteJythonImpl("files/jython/testdefs/testdefinitions.py");
        Collection<Test> c = suite.getTests();
        assertNotNull(c);
        assertFalse(c.isEmpty());
    }
 
}
