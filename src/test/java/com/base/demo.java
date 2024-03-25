//package com.base;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//
//public class demo {
//	public class TestLogger {
//
//		public static WebDriver driver;
//		//public static Logger log;
//		
//		public static void main(String[] args) {
//
//			//log= LogManager.
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.get("https://www.myntra.com/");
//			log.info("Logged into Myntra");
//			try {
//				boolean text= driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
//			}
//			catch(Exception e) {
//				System.out.print(e.getMessage());
//				log.error("Exception occured", new Exception("Element Not Found"));
//			}
//			finally {
//				driver.quit();
//				log.info("Quitting the driver");
//			}
//		}	
//	}
//
//
//}
