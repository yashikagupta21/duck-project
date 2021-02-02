package com.xebia.automation.pages.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.xebia.automation.pages.base.BasePage;
import com.xebia.automation.pages.srp.SRPPage;

public class HomePage extends BasePage {
	public static final Logger logger = LogManager.getLogger(HomePage.class);

	@FindBy(xpath = "//img[contains(@src,'googlelogo')]")
	WebElement logo;
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchbox;

	public boolean islogoPresent() {
		logger.info("verifying availability of logo ");
		boolean isPresent = logo.isDisplayed();
		return isPresent;
	}
	
	public boolean issearchboxPresent() {
		logger.info("verifying availability of search box ");
		boolean isPresent = searchbox.isDisplayed();
		return isPresent;
	}

	public SRPPage performSearch(String searchtxt) {
		logger.info("Searching for keyword");
		searchbox.sendKeys(searchtxt);
		searchbox.submit();
		SRPPage srpPage = new SRPPage();
		return srpPage;

	}

	
}
