package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/Feature_Login.feature",
		dryRun =     false,
		monochrome = true,
		glue       = "com.qa.stepdefinations",
		plugin     = {"pretty","html:target/cucumber-reports1.html"}
		
		
		
		
		
		        )






public class JUnitRunner {

}
