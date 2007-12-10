package jarden.ws.testing;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The tests are both defined and stored as Java
 * @author GBEVVH8
 *
 */
public class TestSuiteJavaImpl extends TestSuite{
    private String name;    
    private Collection<Test> tests= new ArrayList<Test>();
    
    /**
     * 
     * @return just the tests from this suite <br> to get the tests from contained suites, call getTestSuites()
     *
     */
    public Collection<Test> getTests() {
        return tests;
    }
    
    
    public void addTest(Test test){
        this.tests.add(test);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
