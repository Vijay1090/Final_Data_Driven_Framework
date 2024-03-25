package com.tests;

import java.io.IOException;
import java.lang.reflect.Method;

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
import com.util.BaseUtils;

import io.cucumber.java.After;

public class RegistrationTest extends BaseTest {
	LoginPage loginPage;
	RegistrationPage registrationPage;
	
	@BeforeClass
	public void preconditions() throws Throwable {
		initializeBrowser();
		loginPage=new LoginPage(driver);
	    registrationPage=new RegistrationPage(driver);
		
	    loginPage.clickcreate_New_Account_Button();
	}
	
	@Test
	public void verifyRegistrationform() {
		registrationPage.verifyRegistrationForm();
		
	}
	
	@Test
	public void verifyRegFormElement()  {
		registrationPage.verifyAllRegistrationFormelement();
	}
	
	@Test
	public void verifyRegFormFunction() throws IOException, Throwable  {	
		registrationPage.fillAllData(BaseUtils.getTestData(1, 0),BaseUtils.getTestData(1, 1),BaseUtils.getTestData(1, 2),BaseUtils.getTestData(1, 3),BaseUtils.getTestData(1, 4));
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	

}
