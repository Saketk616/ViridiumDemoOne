package com.viridium.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.viridium.qa.base.BaseClass;

public class TestCases extends BaseClass{
	public WebDriver driver;
	
	public TestCases() {
		super();
	}
	
	@Test(priority=1)
	public void login() {
		
		Assert.assertTrue(projectDashboard.getUserProfileIcon().isDisplayed());
	}
	
	@Test (priority=2)
	public void checkProductProfitabilityMenuVisible() {
		Assert.assertTrue(projectDashboard.getProductProfitabilityMenu().isDisplayed());
	}
	
	@Test (priority=3)
	public void checkCarbonEmissionMenuVisible() {
		Assert.assertTrue(projectDashboard.getCarbonEmissionMenu().isDisplayed());
	}
	
	@Test (priority=4)
	public void checkPFASCHemicalsMenuVisible() {
		Assert.assertTrue(projectDashboard.getPFASChemicalsMenu().isDisplayed());
	}
	
	@Test (priority=5)
	public void checkRegulatoryReportsMenuVisible() {
		Assert.assertTrue(projectDashboard.getRegulatoryReportsMenu().isDisplayed());
	}

}
