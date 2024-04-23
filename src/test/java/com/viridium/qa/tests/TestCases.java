package com.viridium.qa.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	
	@AfterMethod
	public void goToDashboard() {
		projectDashboard.clickViridiumLogo();
	}
	
	@Test(priority=1,enabled=false)
	public void login() throws InterruptedException {
		Thread.sleep(2000);
		
		Assert.assertTrue(projectDashboard.getUserProfileIcon().isDisplayed());
	}
	
	@Test (priority=2,enabled=false)
	public void checkProductProfitabilityMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getProductProfitabilityMenu().isDisplayed());
	}
	
	@Test (priority=3,enabled=false)
	public void checkCarbonEmissionMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getCarbonEmissionMenu().isDisplayed());
	}
	
	@Test (priority=4,enabled=false)
	public void checkPFASCHemicalsMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertFalse(projectDashboard.getPFASChemicalsMenu().isDisplayed());
	}
	
	@Test (priority=5,enabled=false)
	public void checkRegulatoryReportsMenuVisible() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(projectDashboard.getRegulatoryReportsMenu().isDisplayed());
	}

	
	@Test (priority=6,enabled=true)
	public void checkTitleVIR03VisibleAfterClick() throws InterruptedException {
		Thread.sleep(2000);
		projectDashboard.clickPFASChemicalsMenu();
		projectDashboard.clickPFASDataMeshBuilderIcon();
		dataMeshBuilderPage.click_VIR_03_Table_Row();
		String title=dataMeshBuilderPage.get_VIR_03_Title();
		System.out.println("title is : "+title);
		Assert.assertEquals(title, "VIR03 CLIP 2N");
	}
	
	@Test (priority=7,enabled=true)
	public void checkTitleVIR03Color() throws InterruptedException {
		Thread.sleep(2000);
		projectDashboard.clickPFASChemicalsMenu();
		projectDashboard.clickPFASDataMeshBuilderIcon();
		dataMeshBuilderPage.click_VIR_03_Table_Row();
		WebElement title=dataMeshBuilderPage.get_Color_VIR_03_Title();
		String color = (String)((JavascriptExecutor) driver).executeScript("var element = arguments[0];" +
                "var style = window.getComputedStyle(element);" +
                "return style.getPropertyValue('color');", title);
		System.out.println("Color is: "+color);
		Assert.assertEquals(color, "rgb(77, 160, 103)");
	}
	
		

}
