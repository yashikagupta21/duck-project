package com.xebia.automation.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class XebiaListener extends TestListenerAdapter {
	public static final Logger logger = LogManager.getLogger(XebiaListener.class);

	// On start
	@Override
	public void onTestStart(ITestResult tr) {
		ITestNGMethod testNGMethod = tr.getMethod();
		Method method = testNGMethod.getConstructorOrMethod().getMethod();
		logger.info("Test execution started for " + method.getName());

	}

	// On success
	@Override
	public void onTestSuccess(ITestResult tr) {
		ITestNGMethod testNGMethod = tr.getMethod();
		Method method = testNGMethod.getConstructorOrMethod().getMethod();
		logger.info("TestCase " + method.getName() + " Passed");

		TakesScreenshot scrShot = ((TakesScreenshot) XebiaBaseTest.driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("screenshots/" + method.getName() + "-successful.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

// On failure
	@Override
	public void onTestFailure(ITestResult tr) {
		ITestNGMethod testNGMethod = tr.getMethod();
		Method method = testNGMethod.getConstructorOrMethod().getMethod();
		logger.info("TestCase " + method.getName() + " Failed");

		TakesScreenshot scrShot = ((TakesScreenshot) XebiaBaseTest.driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("screenshots/" + method.getName() + "-failed.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//On skipped
	@Override
	public void onTestSkipped(ITestResult tr) {
		ITestNGMethod testNGMethod = tr.getMethod();
		Method method = testNGMethod.getConstructorOrMethod().getMethod();
		logger.info("TestCase " + method.getName() + " Skipped");

		TakesScreenshot scrShot = ((TakesScreenshot) XebiaBaseTest.driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("screenshots/" + method.getName() + "-skipped.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}