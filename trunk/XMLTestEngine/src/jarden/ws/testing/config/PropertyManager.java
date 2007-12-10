package jarden.ws.testing.config;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyManager {
    private static String propsFileLocation="TestEngine.properties";
    private static Logger log = Logger.getLogger(PropertyManager.class);
    private static Properties props = new Properties();
    static{
        try {
            InputStream is  = Thread.currentThread().getContextClassLoader().getResourceAsStream(propsFileLocation);
            props.load(is);
            log.info("loaded properties from: "+propsFileLocation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getProperty(String property){
        return props.getProperty(property);
    }

}
