package com.test.automation.uiAutomation.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	HomePage page;
	
	@BeforeClass
	public void setUp()
	{
		init();
				
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("============Starting verifyLoginWithInvalidCredentials test============");
		HomePage page = new HomePage(driver);
		page.loginToApplication("test", "password123");
		Assert.assertEquals(page.getInvalidAuthenticationText(), "Wrong username and password combination.");
		log.info("============Finished verifyLoginWithInvalidCredentials test============");
	}
	
	@AfterClass	
	public void endTest()
	{
		driver.close();
	}

}
