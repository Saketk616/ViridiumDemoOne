package com.viridium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//input[@type='checkbox']/parent::label")
	private WebElement checkbox1;
	
	@FindBy(xpath="//span[text()=' User Details']")
	private WebElement userDetailsText;

	@FindBy(id="username")
	private WebElement inputEmailField;
	
	@FindBy(id="password")
	private WebElement inputPasswordField;
	
	@FindBy(id="kc-login")
	private WebElement signInButton;
	
	@FindBy(id="idBtn_Back")
	private WebElement noButton;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void login(String emailId, String password) {
		
		checkbox1.click();
		inputEmailField.sendKeys(emailId);
		inputPasswordField.sendKeys(password);
		signInButton.click();
	}
}
