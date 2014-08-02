package testdemo;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j2Test {

	
	private static Logger logger = LogManager.getLogger(log4j2Test.class);  
	
	public static void main(String[] args) {
		
		logger.entry();
		//trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
		
		logger.trace("trace");
		
		logger.debug("debug");
		
		logger.log(Level.TRACE, "我是自定义的");   
		//这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
		
		logger.info("info");
		//info级别的信息
		
		logger.warn("warn");
		
		logger.error("error");
		 //error级别的信息，参数就是你输出的信息
		
		logger.fatal("fatal");
		
		try {
	    int a = 8/0;
    } catch (Exception e) {
    	logger.catching(e);
    }
		
		logger.exit();
		//和entry()对应的结束方法，和logger.trace("exit");一个意思
		
	}

}
