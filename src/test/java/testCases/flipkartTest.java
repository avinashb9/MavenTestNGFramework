package testCases;

import org.testng.annotations.Test;

import pageObjects.FlipkartPage;
import testBase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class flipkartTest extends TestBase {

	
	FlipkartPage flipkartPage;
	
	Logger log = Logger.getLogger(flipkartTest.class);
	
	public flipkartTest() {
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
		initializer();
		flipkartPage = new FlipkartPage(driver);
	}

	@Test
	public void verifyAjax() throws InterruptedException {
		log.info("Login Popuup displayed");
		flipkartPage.closeLogin();
		log.info("Clicked on Login popup close Button");
		flipkartPage.clickBanner();
		log.info("Selected a Banner in the Home Page");
		Thread.sleep(5000);
		flipkartPage.clickItem();
		log.info("selected an Item in the Home Page");
		Assert.assertTrue(false);
		
	}

	@AfterMethod
	public void afterMethod() {
		tearDown();
	}

}
