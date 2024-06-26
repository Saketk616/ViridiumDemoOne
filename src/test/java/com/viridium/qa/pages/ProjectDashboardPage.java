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
	
	@FindBy(className="logo-image")
	private WebElement viridium_logo;
	
	@FindBy(xpath="//div[text()='Product profitability']")
	private WebElement productProfitabilityMenu;
	
	@FindBy(xpath="//div[text()='Carbon emission']")
	private WebElement carbonEmissionMenu;
	
	@FindBy(xpath="//div[text()='PFAS chemicals']")
	private WebElement PFASChemicalsMenu;
	
	@FindBy(xpath="//div[text()='Regulatory reports']")
	private WebElement regulatoryReportsMenu;
	
	@FindBy(xpath="//img[@alt='Data mesh builder']")
	private WebElement dataMeshBuilderIconPFAS;

	public ProjectDashboardPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getUserProfileIcon() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(userProfileIcon));
		return userProfileIcon;
	}
	
	public void clickViridiumLogo() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(viridium_logo));
		viridium_logo.click();
	}
	
	public WebElement getProductProfitabilityMenu() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(productProfitabilityMenu));
		return productProfitabilityMenu;
	}
	
	public WebElement getCarbonEmissionMenu() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(carbonEmissionMenu));
		return carbonEmissionMenu;
	}
	
	public WebElement getPFASChemicalsMenu() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(PFASChemicalsMenu));
		return PFASChemicalsMenu;
	}
	
	public WebElement getRegulatoryReportsMenu() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(regulatoryReportsMenu));
		return regulatoryReportsMenu;
	}
	
	public void clickPFASChemicalsMenu() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(PFASChemicalsMenu));
		PFASChemicalsMenu.click();
	}
	
	public void clickPFASDataMeshBuilderIcon() {	
		BaseClass.wait.until(ExpectedConditions.visibilityOf(dataMeshBuilderIconPFAS));
		dataMeshBuilderIconPFAS.click();
	}



}
