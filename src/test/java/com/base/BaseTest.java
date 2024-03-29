package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.util.BaseUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class BaseTest {
	public WebDriver driver=null;
	public Properties prop;
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter reporter;
	public ExtentTest test;




	public  void initializeBrowser() throws Throwable {
		WebDriverManager.chromedriver().clearCache();
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		// logger.info("ChromeBrowser opens successfully ....");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		prop=new Properties();


		File file=new File("config.properties");
		FileInputStream file1=new FileInputStream(file);
		prop.load(file1);
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}


	@BeforeSuite
	public void starttestCase() throws InterruptedException {

		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		reporter = new ExtentSparkReporter(path);
	}

	

	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			BaseUtils.takeScreenshot(driver, result.getName());
		}
	}
	







	@AfterSuite
	public void endtestCase() {
		extent.attachReporter(reporter);
		extent.flush();
	}

	


}
