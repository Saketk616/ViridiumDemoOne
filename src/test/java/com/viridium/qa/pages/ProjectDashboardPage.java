package com.viridium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.viridium.qa.base.BaseClass;

public class ProjectDashboardPage {

	WebDriver driver;

	@FindBy(className="profile-img")
	private WebElement userProfileIcon;

	public ProjectDashboardPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserProfileIcon() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
		return userProfileIcon;
	}



}
