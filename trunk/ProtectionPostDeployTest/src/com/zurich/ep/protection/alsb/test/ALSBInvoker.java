package com.zurich.ep.protection.alsb.test;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;

public class ALSBInvoker{


    private static final String M_CONTENT_NODE = ".//m_content";
    private String endpointURL;
    private String testXMLDir;
    
    public ALSBInvoker(String endpointURL, String testXMLDir){
        this.endpointURL = endpointURL;
        this.testXMLDir = testXMLDir;
        
    }

    public Collection<String> runALSBTestSuiteFromDir() throws Exception {
        Collection<File> files = getInputFiles(testXMLDir);
        System.out.println("About to run "+ files.size()+" tests");
        Collection<String> errorCol = new ArrayList<String>();
        File errorXMLDir = createResultsDir();
        int fileCount=0;
        for (File file : files) {
            System.out.println("about to run test with file: "+file);
            InputStream response = invokeServiceWithFile(file);
            XmlObject obj = XmlObject.Factory.parse(response);
            
            try{
                assertNodeExists(M_CONTENT_NODE,obj);
            }
            catch (NodeDoesNotExistException e) {
                errorCol.add(file.getName()+" : "+e.toString()+"\n"+obj+"\n");
                storeErrorXML(errorXMLDir,obj,++fileCount);
                System.out.println("Saved error file to:"+errorXMLDir);
                
            }
        }
        if(errorCol.size()>0){
            System.out.println("Error XML is available from:"+errorXMLDir.toString());
        }
        return errorCol;

    }
    
    private void storeErrorXML(File errorXMLDir, XmlObject obj, int i) throws IOException {
        File errorFile = new File(errorXMLDir,i+".txt");
        FileOutputStream fos = new FileOutputStream(errorFile);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
        out.write(obj.toString());
        out.close();
    }

    private File createResultsDir() throws IOException {
        Calendar cal = Calendar.getInstance();
        String tempdir = System.getProperty("java.io.tmpdir");
        tempdir = tempdir + System.getProperty("file.separator");
        String simpletime = ""+cal.get(Calendar.MONTH)+cal.get(Calendar.DATE)+cal.get(Calendar.HOUR)+cal.get(Calendar.MINUTE);
        Random random = new Random(cal.getTimeInMillis());
        String fileName="ALSBErrors-"+simpletime+random.nextInt();
        System.out.println("trying to create file with name:"+fileName);
        File dir = new File(tempdir+fileName);
        dir.mkdir();
        return dir;
    }

    private boolean assertNodeExists(String nodePath, XmlObject obj){
        XmlObject[] node = obj.selectPath(nodePath);
        if(node.length <1){
            throw new NodeDoesNotExistException("Node does not exist: "+nodePath);
        }
        return true;
    }
    
    public XmlObject invokeALSB(XmlObject payload, String endpoint) throws XmlException, IOException, SAXException{
        InputStream responseStream = null;
        PostMethodWebRequest req = new PostMethodWebRequest(endpointURL, new ByteArrayInputStream(payload.toString().getBytes()), "text/xml");
        WebConversation conversation = new WebConversation();
        WebResponse resp = conversation.sendRequest(req);
        responseStream  = resp.getInputStream();
        XmlObject respObj = XmlObject.Factory.parse(responseStream);
        return respObj;
    }
    
    public InputStream invokeServiceWithFile(File xmlFile) throws Exception {
        FileInputStream fis = null;
        InputStream responseStream = null;
        try {
            fis = new FileInputStream(xmlFile);
            PostMethodWebRequest req = new PostMethodWebRequest(endpointURL, fis, "text/xml");
            WebConversation conversation = new WebConversation();
            
            WebResponse resp = conversation.sendRequest(req);
            responseStream = resp.getInputStream();

        }

        finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        
        return responseStream;
    }

    /**
     * reads all of the XML files under the specified docRoot
     * 
     * @return a Collection of File objects representing the XML input files
     */
    private Collection<File> getInputFiles(String docRoot) {
        File dir = new File(docRoot);
        if (testXMLDir == null || !dir.isDirectory() || !dir.canRead()) {
            throw new RuntimeException("unable to read from this directory: " + testXMLDir);
        }
        Collection<File> xmlFiles = new ArrayList<File>();
        xmlFiles = listFileNames(dir,xmlFiles);
        return xmlFiles;
    }

    private Collection<File> listFileNames(File file, Collection<File> xmlFiles) {

        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    listFileNames(f, xmlFiles);
                } else if (f.getName().endsWith(".xml")) {
                    xmlFiles.add(f);
                }
            }
            return xmlFiles;
        } else {
            xmlFiles.add(file);

        }
        return xmlFiles;
    }

}
