package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	Logger log = Logger.getLogger(TestBase.class);
	public TestBase(){
		prop = new Properties();
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public void initializer(){
		
		if(prop.getProperty("browser").equals("chrome")){
			String sChromeDriverPath = System.getProperty("user.dir")+"//BrowserDrivers//chromedriver_win32_V84//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", sChromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}else if(prop.getProperty("browser").equals("FF")){
			
		}
		driver.get(prop.getProperty("url"));
		log.info("Navigated Application URL.");
		
	}
	
	public void tearDown(){
		driver.quit();
	}
	
	public static void captureScreenshot(String Method){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String filePath = System.getProperty("user.dir")+"//screenshots//screenshot_"+Method+"_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(file, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
