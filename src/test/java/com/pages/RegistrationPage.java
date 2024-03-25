package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.BaseTest;

import io.cucumber.java.eo.Se;

public class RegistrationPage extends BaseTest {
	
	private static Logger log=LogManager.getLogger(RegistrationPage.class);
	
	@FindBy(xpath = "//form[@id=\"reg\"]") private WebElement regForm;
	@FindBy(xpath="//input[@name=\"firstname\"]") private WebElement firstName;
	@FindBy(xpath="//input[@name=\"lastname\"]") private WebElement lastName;
	@FindBy(xpath = "//input[@name=\"reg_email__\"]") private WebElement regemailTextfield;
	@FindBy(xpath = "//input[@name=\"reg_email_confirmation__\"]") private WebElement confirm_Reg_EmailTextField;
	@FindBy(xpath="//input[@id=\"password_step_input\"]") private WebElement passwordTextField;
	@FindBy(xpath="//select[@id=\"day\"]") private WebElement dayDropdown;
	@FindBy(xpath = "//select[@id=\"month\"]") private WebElement monthDropdown;
	@FindBy(xpath="//select[@id=\"y\"]") private WebElement yearDropdown;
	@FindBy(xpath="//div[@class=\"mtm _5wa2 _5dbb\"]/descendant::*/label[text()='Male']") private WebElement genderRedioButton;
	@FindBy(xpath="//div[@class=\"_1lch\"]/descendant::button") private WebElement signUPButton;
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void verifyRegistrationForm() {
		Assert.assertTrue(regForm.isDisplayed());
		log.info("Registration form is displayed");
		
	}
	public void verifyAllRegistrationFormelement() {
		Assert.assertTrue(firstName.isEnabled());
		Assert.assertTrue(lastName.isEnabled());
		Assert.assertTrue(regemailTextfield.isEnabled());
		Assert.assertTrue(passwordTextField.isEnabled());
		Assert.assertTrue(dayDropdown.isEnabled());
		Assert.assertTrue(monthDropdown.isEnabled());
		Assert.assertTrue(yearDropdown.isEnabled());
		Assert.assertTrue(genderRedioButton.isEnabled());
		Assert.assertTrue(signUPButton.isEnabled());
		log.info("Regitsration form consist all reqired fields");
		
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
		log.info("entered first name");
			
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
		log.info("entered last name");
	}
	public void enterregEmail(String email) {
		regemailTextfield.sendKeys(email);
		log.info("entered emailid name");
	}
	
	public void enterconEmail(String conemail) {
		confirm_Reg_EmailTextField.sendKeys(conemail);
		log.info("entered con emailid name");
	}
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
		log.info("entered password name");
	}
	
	public void fillAllData(String fname,String lName, String regemail, String conRegEmail, String password) {
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		regemailTextfield.sendKeys(regemail);
		confirm_Reg_EmailTextField.sendKeys(conRegEmail);
		passwordTextField.sendKeys(password);
		log.info("All details Filled  successfully");
		}
	public void selectDateOfBirth(String day, String month, String year) {
		Select s=new Select(dayDropdown);
		s.selectByValue(day);
		Select s1=new Select(monthDropdown);
		s1.selectByValue(month);
		Select s2=new Select(yearDropdown);
		s2.selectByValue(year);
		log.info("Date of birth selectd successfully");
		
	}
	public void selectGender() {
		genderRedioButton.click();
		log.info("gender as male selected Successfully");
		
	}
	
	

}
