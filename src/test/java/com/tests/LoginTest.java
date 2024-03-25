package com.tests;



import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseTest;
import com.pages.LoginPage;
import com.pages.RegistrationPage;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	RegistrationPage registrationPage;
	
	
	@BeforeClass
	public void precondition() throws Throwable {
		  initializeBrowser();
		loginPage=new LoginPage(driver);
	    registrationPage=new RegistrationPage(driver);
	  
	}
	
	
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		loginPage.verifyPageTitle(driver);
	}
	@Test(priority = 2)
	public void verifylogo(){
		loginPage.verifyLogo();
	}
	
	@Test(priority = 3)
	public void verifyloginForm() {
		loginPage.verifyLoginForm();
	}
	
	@Test(priority = 4)
	public void clickonCreateAccountbotton() throws Throwable{
		loginPage.clickcreate_New_Account_Button();
	}
	
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
