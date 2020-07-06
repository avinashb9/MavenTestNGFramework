package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	  public void beforeMethod() {
		initializer();
		loginPage = new LoginPage();
	  }
	
  @Test
  public void verifyLogin() {
	  String sTitle = loginPage.getTitle();
	  Assert.assertEquals(sTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
  }
  

  @AfterMethod
  public void afterMethod() {
	  tearDown();
  }

}
