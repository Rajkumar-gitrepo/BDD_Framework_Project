package com.qa.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.pageObjects.ContactUsWebPageObjects;
import com.qa.pageObjects.LoginWebPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefinations {

	public WebDriver driver;
	public LoginWebPageObjects lp;
	public ContactUsWebPageObjects cpo;

	@Given("User opens browser")
	public void user_opens_browser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		lp = new LoginWebPageObjects(driver);
	}

	@When("User launches URL {string}")
	public void user_launches_url(String url) {
        driver.get(url);
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String mail, String passwd) {
          lp.enterEmail(mail);
          lp.enterPassword(passwd);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
          lp.clickLoginButton();
	}

	@Then("Page Home page Title should be {string}")
	public void page_home_page_title_should_be(String pageTitle) {
          Assert.assertEquals(driver.getTitle(), pageTitle);
	}
	
	@Then("User checks for dashboard validation as {string}")
	public void user_checks_for_dashboard_validation_as(String string) {
	    Assert.assertEquals(lp.dashboardValidation(string), string);
	}


	@Then("User clicks on Logout")
	public void user_clicks_on_logout() {
	    lp.clickLogoutButton();
	}

	//==========================================================================
	//Contact us Information functionality
	
	@Then("User clicks on MyInfo option")
	public void user_clicks_on_my_info_option() {
		cpo = new ContactUsWebPageObjects(driver);
		cpo.clickOnMyInfo();
	}

	@Then("User clicks on Contact details option")
	public void user_clicks_on_contact_details_option() {
		cpo.clickOnContactUsOption();
	}

	@Then("User can view contact details")
	public void user_can_view_contact_details() {
		cpo.isContactUsOptionDisplayed();
	}

	@Then("User enters Street1 details")
	public void user_enters_street1_details() {
		cpo.addAddressOne();
	}

	@Then("User enters State details")
	public void user_enters_state_details() {
		cpo.addState();
	}

	@Then("User enters Zipcode Deatis")
	public void user_enters_zipcode_deatis() {
		cpo.addPincode();
	}

	@Then("User selects country from dropdown")
	public void user_selects_country_from_dropdown() {
		//cpo.selectCountry();
	}

	@Then("User enters mobile number")
	public void user_enters_mobile_number() {
		cpo.addMobileNumber();
	}

	@Then("User clicks on save button")
	public void user_clicks_on_save_button() {
		cpo.clickOnSaveButton();
	}


}
