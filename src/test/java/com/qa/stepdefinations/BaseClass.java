package com.qa.stepdefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.pageObjects.ContactUsWebPageObjects;
import com.qa.pageObjects.LoginWebPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public LoginWebPageObjects lp;
	public ContactUsWebPageObjects cpo;
	public SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
	public Date date = new Date();
	public String actualDate = sdf.format(date);
	public Properties pro;
	public FileInputStream fis;
	
	
	public void setup() throws Throwable
	{
		pro=new Properties();
		fis = new FileInputStream("Config.properties");
		pro.load(fis);
		if(pro.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else if(pro.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else if(pro.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}
	
	
	public String getScreenshot() throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+actualDate+"-FailedScreenshot.png"; 
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
