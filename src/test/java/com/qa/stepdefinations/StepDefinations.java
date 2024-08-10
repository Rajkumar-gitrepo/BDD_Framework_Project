package com.qa.stepdefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.qa.pageObjects.ContactUsWebPageObjects;
import com.qa.pageObjects.LoginWebPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import java.io.*;


public class StepDefinations extends BaseClass {


	@Given("User opens browser")
	public void user_opens_browser() throws Throwable {
         setup(); //Opens Browser
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


	//hooks usage-->Taking Screenshot for failed test cases.
	@After
	public void tearDown(Scenario sc)
    {
		if(sc.isFailed() == true)
		{
			try {
				Thread.sleep(4000);
				getScreenshot();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
	@After
	public void getScreenshotForFailureTestScenario(Scenario scenario)
	{
		if(scenario.isFailed())
			{
			   try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			   byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			   Allure.addAttachment("Failed-Screenshot",new ByteArrayInputStream(screenshot));
			}
		driver.quit();
	}
	

}
