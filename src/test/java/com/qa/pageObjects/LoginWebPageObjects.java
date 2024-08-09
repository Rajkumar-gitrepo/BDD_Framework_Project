package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebPageObjects {

	WebDriver driver;

	public LoginWebPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	WebElement dashboardCheck;

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement logoutOption;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;

	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	public String dashboardValidation(String value)
	{
		return value = dashboardCheck.getText();
	}

	public void clickLogoutButton() {
		try {
			logoutOption.click();
			logoutButton.click();
		} catch (Exception e) {

		}
	}
}
