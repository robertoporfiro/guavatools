package com.zurich.ep.protection.alsb.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;
import com.zurich.ep.protection.alsb.test.config.ALSBTestConfiguration;

public class NewALSBInvoker{

    private String endpointURL;
    private NewALSBInvoker(){
        endpointURL = ALSBTestConfiguration.get("alsb.url");
    }
 
    
    public XmlResponseInfo invokeALSB(String pathToPayloadFile) throws XmlException, IOException, SAXException{
        FileInputStream fis = new FileInputStream(pathToPayloadFile);
        InputStream responseStream = null;
        PostMethodWebRequest req = new PostMethodWebRequest(endpointURL,fis, "text/xml");
        WebConversation conversation = new WebConversation();
        WebResponse resp = conversation.sendRequest(req);
        int respCode=resp.getResponseCode();
        String responseMessage=resp.getResponseMessage();
        responseStream  = resp.getInputStream();
        XmlObject respObj = XmlObject.Factory.parse(responseStream);
        return new XmlResponseInfo(respObj,respCode,responseMessage);
    }
    
    
    
    //------------------------Singleton stuff
    
    
    private static NewALSBInvoker instance = new NewALSBInvoker();
    public static NewALSBInvoker getALSBInvoker(){
        return instance; 
    }
    
}
