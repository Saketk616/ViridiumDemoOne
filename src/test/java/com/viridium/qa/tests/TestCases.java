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
	
	@Test
	public void login() {
		
		Assert.assertTrue(projectDashboard.getUserProfileIcon().isDisplayed());
	}

}
