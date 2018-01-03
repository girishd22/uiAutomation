package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String browser = "chrome";
	String url = "http://www.rediff.com/";
	
	public void init()
	{
		select(browser);
		get(url);
		//String log4jconfpath="log4j.properties";
		//PropertyConfigurator.configure(log4jconfpath);
		PropertyConfigurator.configure("log4j.properties");	
		
	}
	
	public void select(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			log.info("Launching:" + browser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}

	public void get(String url)
	{
		log.info("Navigating to URL:" + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
