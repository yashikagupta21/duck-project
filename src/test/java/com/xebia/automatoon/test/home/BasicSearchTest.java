package com.xebia.automatoon.test.home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.xebia.automation.basetest.XebiaBaseTest;
import com.xebia.automation.pages.home.HomePage;
import com.xebia.automation.pages.srp.SRPPage;

public class BasicSearchTest extends XebiaBaseTest {
	public static final Logger logger = LogManager.getLogger(BasicSearchTest.class);
	HomePage homePage;
	SRPPage srpPage;
	
	@Test
	public void launchTest() {
		homePage = new HomePage();
		logger.info("Asserting logo");
		Assert.assertTrue(homePage.islogoPresent(), "Logo not dispalyed, possibly wrong URL");

	}
	
	@Test(dependsOnMethods = "launchTest")
	public void searchTest() {
		boolean chksearchbox = homePage.issearchboxPresent();
		Assert.assertTrue(chksearchbox, "Search box not available");
		srpPage=homePage.performSearch("ducks");
		String pageTitle = driver.getTitle();
		Boolean isTitleMatch= pageTitle.contains("ducks");
		Assert.assertTrue(isTitleMatch, "Title Mismatch for SRP page");	
	}

}
