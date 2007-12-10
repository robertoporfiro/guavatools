package jarden.ws.testing;

import jarden.ws.testing.engine.TestEngine;
import jarden.ws.testing.results.TestResultsService;
import jarden.ws.testing.results.TestResultsServiceSimpleImpl;
import jarden.ws.testing.store.TestStore;
import jarden.ws.testing.store.TestStoreSerializedImpl;

public class TestEngineApplication {
    private TestEngine engine;
    private TestStore testStore;
    private TestResultsService testResultsService;
    
    public TestEngineApplication(){
        engine = TestEngine.getEngine();
        testStore = TestStoreSerializedImpl.getInstance();
        TestResultsService service = new TestResultsServiceSimpleImpl();
    }
    
    public TestEngine getEngine() {
        return engine;
    }
    public TestResultsService getTestResultsService() {
        return testResultsService;
    }
    public TestStore getTestStore() {
        return testStore;
    }

}
