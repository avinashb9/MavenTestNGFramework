package listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testBase.TestBase;

public class CustomListener implements ITestListener{
	
	Logger log = Logger.getLogger(CustomListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("**********Test - "+result.getName()+" has started*********");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("**********Test - "+result.getName()+" has SUCCESS*********");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.error("**********Test - "+result.getName()+" has FAILED*********");
		TestBase.captureScreenshot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("**********Context - "+context.getName()+" has started*********");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("**********Context - "+context.getName()+" has FINISHED*********");
	}
}
