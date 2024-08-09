package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsWebPageObjects {

	WebDriver driver;

	public ContactUsWebPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='My Info']")
	WebElement myinfoOption;

	@FindBy(xpath = "//a[normalize-space()='Contact Details']")
	WebElement contactUsOption; 

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addressOne;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement state;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement postalCode;

	@FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
	WebElement country;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[8]")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	public void clickOnMyInfo() {
		myinfoOption.click();
	}

	public void clickOnContactUsOption() {
		contactUsOption.click();
	}
	
	public void isContactUsOptionDisplayed() {
		contactUsOption.isDisplayed();
	}

	public void addAddressOne() {
		addressOne.sendKeys("New raipuara");
	}

	public void addState() {
		state.sendKeys("Telangana");
	}

	public void addPincode() {
		postalCode.sendKeys("400001");
	}

	public void selectCountry() {
		Select s = new Select(country);
		s.selectByVisibleText("Japan");
	}

	public void addMobileNumber() {
		mobileNumber.sendKeys("9876543210");
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}
}
