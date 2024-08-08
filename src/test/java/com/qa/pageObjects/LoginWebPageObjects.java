package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebPageObjects {

	WebDriver rdriver;
	
	public LoginWebPageObjects(WebDriver ldriver)
	{
		rdriver = ldriver;
		PageFactory.initElements(ldriver,this );
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	public void enterEmail(String emailId)
	{
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
	
}
