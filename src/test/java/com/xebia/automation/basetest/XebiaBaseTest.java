package com.xebia.automation.basetest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.xebia.automation.pages.base.BasePage;
import com.xebia.automation.utils.PropertyReader;



@Listeners(XebiaListener.class)
public class XebiaBaseTest {
	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(XebiaBaseTest.class);

	@BeforeSuite
	public void init() throws IOException {
		// get browsername from properties file
		String browser = PropertyReader.getMyProperty("browser");
		logger.info("browser name is " + browser);
		if (browser.equals("firefox")) {
			logger.info("Launching FireFox browser");
			System.setProperty("webdriver.gecko.driver", "/Users/yashikagupta/Desktop/geckodriver");
			driver = new FirefoxDriver();
		} else {
			logger.info("Launching Chrome browser");
			System.setProperty("webdriver.chrome.driver", "/Users/yashikagupta/Desktop/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BasePage.driver = driver;
		String url = PropertyReader.getMyProperty("url");
		driver.get(url);

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
