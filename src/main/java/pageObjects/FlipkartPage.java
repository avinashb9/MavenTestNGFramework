package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class FlipkartPage {

	org.apache.log4j.Logger log = Logger.getLogger(FlipkartPage.class);
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/a/div[1]/div/img")
	WebElement banner;
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	WebElement closeBtn;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div/div[2]/div[2]/div/div[1]/div/a[2]")
	WebElement item;
	
	public FlipkartPage(WebDriver driver){
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this);
	}
	
	public void closeLogin(){
		closeBtn.click();
		log.info("Close Button clicked");
	}
	
	public void clickBanner(){
		banner.click();
		log.warn("BAnner clicked");
	}
	
	public void clickItem(){
		item.click();
		log.fatal("Item clicked");
	}
}
