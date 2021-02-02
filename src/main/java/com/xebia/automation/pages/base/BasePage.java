package com.xebia.automation.pages.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BasePage {
	public static WebDriver driver;
	public static final Logger logger = LogManager.getLogger(BasePage.class);

	public BasePage() {
		// Page factory can initialize the Global variables initially and can load it at
		// run time
		PageFactory.initElements(driver, this);
		logger.info("Initialized web elements");
	}


}
