package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement signInBtn;
	
	public LoginPage() {
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	//Actions
		public void enterUserName(){
			userName.sendKeys(prop.getProperty("username"));
			
		}
		
		public void enterPassword(){
			passWord.sendKeys(prop.getProperty("password"));
		}
		
		public void clickSignIn(){
			signInBtn.click();
		}
		
		public HomePage loginToApp(){
			enterUserName();
			enterPassword();
			clickSignIn();
			return new HomePage();
		}

		public String getTitle(){
			return driver.getTitle();
		}
		
}
