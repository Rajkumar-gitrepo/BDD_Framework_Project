package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features",
		dryRun =     false,
		monochrome = true,
		glue       = "com.qa.stepdefinations",
		plugin     = {"pretty","html:target/cucumber-reportshtml1.html",
				      "pretty","junit:target/cucumber-reportsxml1.xml",
				      "pretty","json:target/cucumber-reportsjson1.json"},
		tags       =  "@Sanity or @Regression"
		
		
		)

public class TestNGRunner extends AbstractTestNGCucumberTests {
   //This class will be empty
}
