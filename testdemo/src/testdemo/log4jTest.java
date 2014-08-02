package testdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jTest {

	
	private static Logger logger = LogManager.getLogger(log4jTest.class);  
	
	public static void main(String[] args) {
		
		logger.entry();
		
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");
		
		try {
	    int a = 8/0;
    } catch (Exception e) {
	    // TODO Auto-generated catch block
    	logger.catching(e);
    }
		
		logger.exit();
		
		
	}

}
