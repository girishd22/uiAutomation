package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='signin_info']")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='login1']")
	WebElement username;

	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='login']/div[2]/div[2]/div[4]/div")
	WebElement authenticationFail;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String uname, String passwd)
	{
		signIn.click();
		log.info("Clicked on signIn link:" + signIn.toString());
		username.sendKeys(uname);
		log.info("Provided the uname:" + username.toString());
		password.sendKeys(passwd);
		log.info("Provided the Password:" + password.toString());
		submitButton.click();
		log.info("Clicked the Go button:" + submitButton.toString());
		
	}
	
	public String getInvalidAuthenticationText()
	{
		return authenticationFail.getText();
	}
	
}
