package jarden.ws.testing.engine;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import jarden.ws.testing.PersistanceException;
import jarden.ws.testing.Test;
import jarden.ws.testing.TestSuite;
import jarden.ws.testing.config.PropertyManager;
import jarden.ws.testing.results.ResultsSession;
import jarden.ws.testing.results.TestResultsService;
import jarden.ws.testing.results.TestResultsServiceSimpleImpl;
import jarden.ws.testing.store.TestStore;
import jarden.ws.testing.store.TestStoreSerializedImpl;
import jarden.ws.testing.validation.ValidationEngine;
import jarden.ws.testing.validation.Validator;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.xml.sax.SAXException;

public class TestEngine {

    private TestStore testStore;
    private ValidationEngine v = new ValidationEngine();
    TestResultsService testResultsService = new TestResultsServiceSimpleImpl();
    private Logger logger = Logger.getLogger(this.getClass());
    
    public void runTestSuite(String suiteName, String username) throws PersistanceException, XmlException, IOException, SAXException{
        ResultsSession session = testResultsService.beginSession(username);
        logger.info("about to run suite: "+suiteName);
        TestSuite testSuite = testStore.getTestSuite(suiteName);
        for(Test test:testSuite.getTests()){
            runTest(test,session);
        }
        
    }
    
    private void runTest(Test test, ResultsSession session) throws XmlException, IOException, SAXException {
        logger.info("about to run test:"+test.getName());
        
        String path = test.getRequestXMLPath(); // load the XML in from disk
        XmlObject requestXml = XmlObject.Factory.parse(new File(path));
        IPInvoker invoker = new IPInvoker();
        session.notifyRequestSend(test.getName());
        XmlResponseInfo info = invoker.invokeOverHTTP(requestXml,getEndpoint(test));
        session.notifyResponseReceive(test.getName());
        
        XmlObject responseXML =info.getResponsePayload();
        Collection<Validator> validators = test.getValidators();
        
        v.validate(responseXML,session,validators);
        
        
    }

    private String getEndpoint(Test test) {
        String endpoint = test.getEndpoint();
        if(endpoint ==null || endpoint.equals("")){
           return PropertyManager.getProperty("invoker.endpointURL");
        }
        return endpoint;
    }

    public void runTest(String testName){
        
    }
    
    
    
    //------------------------------Singleton stuff
    
    private TestEngine(){
        testStore =TestStoreSerializedImpl.getInstance(); 
        logger.info("initialised");
    }
    private static TestEngine instance = new TestEngine();
    public static TestEngine getEngine(){
        return instance;
    }
}
