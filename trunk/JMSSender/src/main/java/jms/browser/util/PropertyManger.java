package jms.browser.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertyManger {
	private static final String FILE_NAME = "browser.properties";
	private static Properties properties;
	private static Logger log = Logger.getLogger(PropertyManger.class.getClass().getName());

	static{
		properties = new Properties();
		try {
			properties.load(getFileAsStream());
			log.info(properties.entrySet().size()+" properties loaded");
		} catch (IOException e) {
			throw new RuntimeException("Properties file not found on classpath with name : "+FILE_NAME);
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	private static InputStream getFileAsStream() {
		return PropertyManger.class.getClassLoader().getResourceAsStream(FILE_NAME);
	}
	
	
}

