package org.automation.generic_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener extends BaseTest implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("<Test>-- "+context.getName()+" Started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("<Test>-- "+context.getName()+" Finished",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Case-- "+result.getName()+" Failed",true);
		WebDriverUtil.captureScreenshot(driver);
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test Case-- "+result.getName()+" Started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Case-- "+result.getName()+" Success",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Case-- "+result.getName()+" Skipped",true);
	}
}
