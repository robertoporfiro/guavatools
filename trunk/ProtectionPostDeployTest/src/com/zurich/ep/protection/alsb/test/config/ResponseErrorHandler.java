package com.zurich.ep.protection.alsb.test.config;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.apache.log4j.Logger;

import org.apache.xmlbeans.XmlObject;



public class ResponseErrorHandler {
    Logger log = Logger.getLogger(this.getClass().getName());
    private File errorDir;
    private boolean persistErrorXML=true;
    private int counter=0;
    
    public ResponseErrorHandler(String errorDir, String persistErrorXML) {
        this.errorDir = new File(errorDir);
        if(this.errorDir == null){
            throw new RuntimeException("ResponseErrorHandler has not been correctly configured. The error dir provided ,which seems to be in error, was null");
        }
        
        if(!this.errorDir.exists()){
            this.errorDir.mkdirs();
        }
        
        if("yes".equals(persistErrorXML)){
            this.persistErrorXML = true;
            log.info("turned on error XML persistence");
            //delete old messages
            deleteOldMessages(new File(errorDir));
            log.info("deleted old messages");
        }else{
            this.persistErrorXML=false;
        }
    }



    public void handleErrors(XmlObject obj, String testName,String testDescription, Collection<String> errorMessages) throws IOException{
        if(errorMessages == null || (errorMessages.isEmpty())){    // i.e. there are no error messages
            return;        
        }
        
        log.error(testName+" failed with message: "+ testDescription+ " \n The faults raised with the response are detailed below\n-----------\n");
        for(String message : errorMessages){
            log.error("\n    *       "+message);
        }
    
        if(persistErrorXML){
            //log.info("about to store errors");
            if(errorDir != null){
                counter++;
                File file = new File(this.errorDir+"/"+counter+testName+".xml");
                obj.save(file);
              //  log.info("errors stored");
            }
            else{
                log.info("not currently handling errors");
            }
        }
    }



    private void deleteOldMessages(File errorDir) {
        for(File f: errorDir.listFiles()){
            f.delete();
        }
    }
}
