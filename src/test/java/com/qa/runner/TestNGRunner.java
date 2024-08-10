package com.qa.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "./src/test/resources/features",
		dryRun =     false,
		monochrome = true,
		glue       = "com.qa.stepdefinations",
		plugin     = {"pretty","html:target/cucumber-reportshtml1.html",
				      "pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",},
		tags       =  "@Sanity or @Regression"
		
		
		)

public class TestNGRunner extends AbstractTestNGCucumberTests {
   //This class will be empty
}
