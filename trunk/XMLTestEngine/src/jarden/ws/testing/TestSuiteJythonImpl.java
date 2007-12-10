package jarden.ws.testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.python.util.PythonInterpreter;

public class TestSuiteJythonImpl extends TestSuite {
    
    private String testDefinitionFile;
    Logger log = Logger.getLogger(this.getClass());

    public TestSuiteJythonImpl(String testDefinitionFile) {
        this.testDefinitionFile = testDefinitionFile;
    }

    public String getTestDefinitionFile() {
        return testDefinitionFile;
    }

    public void setTestDefinitionFile(String testDefinitionFile) {
        this.testDefinitionFile = testDefinitionFile;
    }

    @Override
    public Collection<Test> getTests() {
        PythonInterpreter py = new PythonInterpreter();
        InputStream is;
        try {
            is = new FileInputStream(testDefinitionFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Bah! file not found at: "+testDefinitionFile+ e);
        }
       
           
        
        log.debug("found python file at: "+testDefinitionFile);
                
        py.execfile(is);
        Object o = py.get("tests");
        System.out.println(o.getClass());
        log.debug("Object found:"+o);
        return null;
    }

}
