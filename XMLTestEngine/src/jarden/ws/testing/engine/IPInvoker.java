package jarden.ws.testing.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class IPInvoker {
    Logger log = Logger.getLogger(this.getClass());
    
    public XmlResponseInfo invokeOverHTTP(XmlObject requestXml,String endpoint) throws IOException, SAXException, XmlException{
        log.info("about to send XML Object over HTTP to endpoint: "+endpoint);
        InputStream responseStream = null;
        //dumpXML(requestXml);
        PostMethodWebRequest req = new PostMethodWebRequest(endpoint,requestXml.newInputStream(), "text/xml");
        WebConversation conversation = new WebConversation();
        WebResponse resp = conversation.sendRequest(req);
        int respCode=resp.getResponseCode();
        String responseMessage=resp.getResponseMessage();
        responseStream  = resp.getInputStream();
        XmlObject respObj = XmlObject.Factory.parse(responseStream);
        return new XmlResponseInfo(respObj,respCode,responseMessage);
        
    }
    
    private void dumpXML(XmlObject requestXml) {
        InputStream is = requestXml.newInputStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        try {
            String line = buf.readLine();
            while(line !=null){
                System.out.println(line);
                line = buf.readLine();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public XmlObject invokeOverHTTPS(XmlObject requestXml){
        log.info("[unimplemented] about to send XML Object over HTTPS: "+requestXml);
        return null;
    }
    
    
    

}
