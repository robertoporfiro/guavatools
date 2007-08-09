package com.zurich.ep.protection.alsb.test.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ALSBTestConfiguration {
    private static Properties props = new Properties();
    private static ResponseErrorHandler responseErrorHandler;
    
    private static Logger log = Logger.getLogger(ALSBTestConfiguration.class.getName());
    static{
        try {
            InputStream is = new FileInputStream("ALSBTest.properties");
            props.load(is);
            String errorDir = props.getProperty("responseErrorHandler.errorDir");
            String persistErrorXML=props.getProperty("responseErrorHandler.persistErrorResponseXML");
            responseErrorHandler= new ResponseErrorHandler(errorDir,persistErrorXML);
        } catch (IOException e) {
         log.severe(e.toString());
        }
        
    }
    
    
    public static String get(String name){
        return props.getProperty(name);
    }
   
    public static ResponseErrorHandler getResponseErrorHandler(){
      return responseErrorHandler;   
    }
}
