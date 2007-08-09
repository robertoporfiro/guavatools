package com.zurich.ep.protection.alsb.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;



public class ResponseObjectValidator {
    
    private static Logger log = Logger.getLogger(ResponseObjectValidator.class.getName());
    /**
     * 
     * @param xml the XMLObejct to validate
     * @param tests A collection of XMLObjectTest objects
     * @return a collection of error messages as Strings, or an empty collection
     */
    public static Collection<String> validateResponse(XmlResponseInfo info,Collection<XMLObjectTest> tests, String testName){
        int noOfTestsRun=0;
        Collection<String> errors = new ArrayList<String>();
        if(tests==null || tests.isEmpty()){
            log.info("No validators provided for "+testName+". Will just test that a 200 status was returned");
            if(info.getResponseCode() != 200){
                // I know what you're thinking (muchos string concat), but the performance of the GC collector during my JUnit tests is surely not a big concern. Don't you agree ? :-)
                errors.add("The invocation of "+testName+ " return with a status of "+info.getResponseCode()+" and a response message of "+info.getResponseMessage());
            }
            
        }
        XmlObject xml = info.getResponsePayload();
        
        
        for(XMLObjectTest test : tests){
            noOfTestsRun++;
            try{
                String failMessage = handleTest(xml,test);
                if(failMessage != null){
                    errors.add(failMessage);
//                    errors.add("Test "+test.getTestName()+"failed: "+failMessage);
                }
                
            }
            catch(Exception e){
                errors.add("Test "+test.getTestName()+"failed: \n"+e.toString());
            }
        }
        return errors;
    }

    private static String handleTest(XmlObject xml, XMLObjectTest test) {
        
        if(test.getTestType().equals(XMLObjectTest.EXISTS)){
            boolean nodeExists = assertNodeExists(test.getXpath(),xml);
            if(!nodeExists){
                return test.getTestName()+" failed with the error: "+"The node at "+test.getXpath()+" doesn't exist";
            }
        }
        if(test.getTestType().equals(XMLObjectTest.EQUALS)){
            String result = assertNodeEqualsValue(test.getXpath(),xml,test.getValue());
            if(result !=null){
                return test.getTestName()+" failed with the error: "+"The node at "+test.getXpath()+" equals "+result+" instead of: "+test.getValue();
            }else{
                return null;
            }
        }
        if(test.getTestType().equals(XMLObjectTest.NOT_EXISTS)){
             
            if(! assertNodeDoesntExist(test.getXpath(),xml)){
                return test.getTestName()+"failed with the error: The node at "+test.getXpath()+" exists. This is unexpected";
            }else{
                return null;
            }
        }
        if(test.getTestType().equals(XMLObjectTest.CONTAINS)){
            String result = assertNodeContainsValue(test.getXpath(),xml,test.getValue());
            if(result !=null){
                return test.getTestName()+" failed with the error: "+"The node at "+test.getXpath()+" has this value: '"+result+"' and does not contain : "+test.getValue();
            }else{
                return null;
            }
        }
        
        return null;
    }
    
    private static String assertNodeContainsValue(String xpath, XmlObject xml, String value) {
        XmlObject[] nodes = xml.selectPath(xpath);
        if(nodes.length <1){
            return null;
        }
        boolean contains=false;
        for(XmlObject node: nodes){
            String xmlValue = ((SimpleValue)node).getStringValue();
            if(xmlValue.contains(value)){
                contains=true;
            }
        }
        
        if(contains){
            return null;
        }
        StringBuffer buf = new StringBuffer();
        for(XmlObject node: nodes){
            buf.append(node.toString());
            buf.append(" ");
        }
        return buf.toString();
    }

    private static boolean assertNodeExists(String nodePath, XmlObject obj){
        
        XmlObject[] node=null;
        try {
            node = obj.selectPath(nodePath);
        } catch (Throwable e) {
            log.info(e.toString());
        }
        if(node.length <1){
            return false;
        }
        return true;
    }
    
    private static boolean assertNodeDoesntExist(String nodePath, XmlObject obj){
        XmlObject[] node = obj.selectPath(nodePath);
        if(node.length >0){
            return false;
        }
        return true;
    }
    
    /**
     * This method returns null if everything is OK, or the actual String in case of failure.
     * This is to allow us to to return the actual value in case of error
     * @param nodePath
     * @param obj
     * @param regex
     * @return
     */
    private static String assertNodeEqualsValue(String nodePath, XmlObject obj,String regex){
        XmlObject[] node = obj.selectPath(nodePath);
        if(node.length <1){
            return null;
        }
        
        String xmlValue = ((SimpleValue)node[0]).getStringValue();
        if(xmlValue.matches(regex)){
            return null;
        }
        return xmlValue;
    }
    
    
    /**
     * for test purpose only
     * @param args
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("testXML/TEX/onlineQuote1.xml");
            XmlObject obj = XmlObject.Factory.parse(fis);
            XmlObject sel[] = obj.selectPath("/message/m_control/initiator_id");
            System.out.println(((SimpleValue)sel[0]).getStringValue());
            System.out.println(sel[0].equals("Exchange, The"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
