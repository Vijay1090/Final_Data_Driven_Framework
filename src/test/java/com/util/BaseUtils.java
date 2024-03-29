package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseUtils {
	
	WebDriver driver;
	
	public static String getTestData(int rowIndex, int cellIndex) throws Throwable, IOException {
		
		FileInputStream file=new  FileInputStream("C:\\DataDriven_Framework\\git\\Final_Data_Driven_Framework\\src\\main\\java\\com\\testData\\FaceBookDataSanjay.xlsx");
		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return data;
	}
   
	
	public static void takeScreenshot(WebDriver driver,String screenShotName) {

	   File  srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./TestStepsScreenshots/"+screenShotName+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void verifyTitleOfThePage(WebDriver driver,String exptitleOfThepge) {
		String actualTitleoftThepge = driver.getTitle();
		try {
			Assert.assertEquals(actualTitleoftThepge, exptitleOfThepge);
			System.out.println("Title of the page varified: Test case passed...");
		} catch (Exception e) {
			System.out.println("Title of the page is not matched: Test case failed......");
		}
	}

	public static void waitForTime(int time ) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

//	public static void clickOnElement(WebDriver driver,String path) {
//		driver.findElement(By.xpath(path)).click();
//	}
//
//	public static void sendData(WebDriver driver,String path,String data) {
//		driver.findElement(By.xpath(path)).sendKeys(data);
//	}
//
//	public static void verifyPageDisplayed(WebDriver driver,String path) {
//		WebElement actualPage = driver.findElement(By.xpath(path));
//		try {
//			if(actualPage.isDisplayed()) {
//				System.out.println("Expected Page displayed: Test case pass... ");
//			}
//		} catch (Exception e) {
//			System.out.println("Expected Page not displayed: Test case fail... ");
//		}
//	}



}

	
	


