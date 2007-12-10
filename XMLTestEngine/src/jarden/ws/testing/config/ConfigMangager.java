package jarden.ws.testing.config;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.xmlbeans.XmlException;

import com.jarden.testengine.Suite;
import com.jarden.testengine.Test;
import com.jarden.testengine.TestConfiguration;
import com.jarden.testengine.TestConfigurationDocument;
import com.jarden.testengine.Tests;

public class ConfigMangager {

    public static void main(String[] args) throws XmlException, IOException {
        TestConfigurationDocument doc = TestConfigurationDocument.Factory.parse(new File("files/Tests.xml"));
        TestConfiguration config = doc.getTestConfiguration();
        //System.out.println(config);
        Tests tests = config.getTests();
       System.out.println("Free standing tests");
        for(Test test: tests.getTestList()){
            System.out.println("## "+test.getName().getStringValue());
        }
        
       List<Suite> suites = tests.getSuiteList();
       
       System.out.println("Suites: ");
       
       for(Suite s: suites){
           System.out.println(s.getName().getStringValue());
           System.out.println("validator:"+s.getValidator());
           for(Test test: s.getTestList()){
               System.out.println("     ## "+test.getName().getStringValue());
           }
           
       }
    }
}
