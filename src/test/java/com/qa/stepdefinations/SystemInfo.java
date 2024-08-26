package com.qa.stepdefinations;

import java.io.FileOutputStream;
import java.util.Properties;

import io.cucumber.java.Before;

public class SystemInfo {

	public static String osName;
	public static String osVersion;
	public static String javaVersion;
	public static FileOutputStream fis;
	public static Properties pro;

	@Before
	public void run() throws Throwable {
		printOSDetails();
		setVariablesTo();
	}

	private static void printOSDetails() {
		// Retrieve OS details
		
		
		
		//osName = System.getProperty("os.name");
		osVersion = System.getProperty("os.version");
		javaVersion = System.getProperty("java.version");

		System.out.println("Operating System Details:");
		//System.out.println("OS Name: " + osName);
		System.out.println("OS Version: " + osVersion);
		System.out.println("Java Version: " + javaVersion);
		System.out.println();

	}

	public static void setVariablesTo() throws Throwable {

		pro = new Properties();
		pro.put("OS-Name", "Linux");
		pro.put("OS-Version", osVersion);
		pro.put("Java-Version", javaVersion);

		fis = new FileOutputStream(
				"D:\\Project_2024\\Behaviour_Driven_Development_Project\\allure-results\\environment.properties", true);

		pro.store(fis, "date set to environment file");

	}

}
