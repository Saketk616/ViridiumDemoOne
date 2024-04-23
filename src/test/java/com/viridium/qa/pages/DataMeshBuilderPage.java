package com.viridium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.viridium.qa.base.BaseClass;

public class DataMeshBuilderPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@title='VIR03 CLIP 2N']")
	private WebElement All_products_VIR03_row;
	
	@FindBy(xpath="//div[text()='VIR03 CLIP 2N']")
	private WebElement product_heirarchy_VIR03_title;
	

	public DataMeshBuilderPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_VIR_03_Table_Row() {
		BaseClass.wait.until(ExpectedConditions.visibilityOf(All_products_VIR03_row));
		All_products_VIR03_row.click();
	}
	
	public String get_VIR_03_Title() {
		BaseClass.wait.until(ExpectedConditions.visibilityOf(product_heirarchy_VIR03_title));
		return product_heirarchy_VIR03_title.getText();
	}
	
	public WebElement get_Color_VIR_03_Title() {
		BaseClass.wait.until(ExpectedConditions.visibilityOf(product_heirarchy_VIR03_title));
		return product_heirarchy_VIR03_title;
	}
	
	

}
