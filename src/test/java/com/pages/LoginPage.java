package com.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.testng.listener.commons.ExtentTestCommons;
import com.base.BaseTest;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LoginPage extends BaseTest {
	public WebDriver driver;
	
	private static Logger log=LogManager.getLogger(LoginPage.class);
	

	@FindBy(xpath="//img[@class=\"fb_logo _8ilh img\"]") private WebElement facebookLogo;
	@FindBy(xpath = "//form[@class=\"_9vtf\"]") private WebElement loginForm;
	@FindBy(xpath="//input[@id=\"email\"]")  private WebElement emailTextField;
	@FindBy(xpath="//input[@id=\"pass\"]") private WebElement passwordTextField;
	@FindBy(xpath="//button[@name=\"login\"]") private WebElement loginButton;
	@FindBy(xpath="//a[text()=\"Create new account\"]") private WebElement create_New_Account_Button;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void verifyLogo() {
		Assert.assertTrue(facebookLogo.isDisplayed());
		
		log.info("logo of login page verified");
		
	}
	
	public void verifyPageTitle(WebDriver driver) {
		
	Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	log.info("Title of login page verified");
	System.out.println(driver.getCurrentUrl());
	}
	
	public void verifyLoginForm() {
		Assert.assertTrue(loginForm.isDisplayed());
	log.info("loginform of login page verified");
}
	public void verifyLoginFeature(String userEmail, String UserPassword) {
		
		emailTextField.sendKeys(userEmail);
		passwordTextField.sendKeys(UserPassword);
		loginButton.click();
		log.info("user Sccessfully redirected to homepage/ dashboard");
		
	}
	public void clickcreate_New_Account_Button() throws Throwable {
		Thread.sleep(3000);
		create_New_Account_Button.click();
		Thread.sleep(3000);
		log.info("clicked on create account button");
		log.info("navigated to Registration page ");
	}
	
	

}