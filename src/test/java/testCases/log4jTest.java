package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.FlipkartPage;

public class log4jTest {
	
	Logger log = Logger.getLogger(log4jTest.class);
	
  @Test
  public void f() {
	  log.info("INFO");
	  log.debug("DEBUG");
	  log.warn("WARN");
	  log.error("ERROR");
	  log.fatal("FATAL");
  }
}
