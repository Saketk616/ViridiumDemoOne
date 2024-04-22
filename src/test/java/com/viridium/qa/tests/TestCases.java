package com.viridium.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.viridium.qa.base.BaseClass;

public class TestCases extends BaseClass{
	public WebDriver driver;
	
	public TestCases() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		driver=BaseClass.driver;
		
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		
		Assert.assertTrue(projectDashboard.getUserProfileIcon().isDisplayed());
	}
	
	@Test (priority=2)
	public void checkProductProfitabilityMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getProductProfitabilityMenu().isDisplayed());
	}
	
	@Test (priority=3)
	public void checkCarbonEmissionMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getCarbonEmissionMenu().isDisplayed());
	}
	
	@Test (priority=4)
	public void checkPFASCHemicalsMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertFalse(projectDashboard.getPFASChemicalsMenu().isDisplayed());
	}
	
	@Test (priority=5)
	public void checkRegulatoryReportsMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getRegulatoryReportsMenu().isDisplayed());
	}

}
