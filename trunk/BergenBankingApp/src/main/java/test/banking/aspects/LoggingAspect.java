package test.banking.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingAspect {
	Log log = LogFactory.getLog(this.getClass());
	
	public void log(){
		log.info("<Aspect> About to write to AccountStore");
	}

}
