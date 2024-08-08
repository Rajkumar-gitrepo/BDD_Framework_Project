package com.qa.stepdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.pageObjects.LoginWebPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginWebPage {

	public WebDriver driver;
	public LoginWebPageObjects lp;

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

	

}
