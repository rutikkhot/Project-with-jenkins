package com.kiranacedamy.practicepage.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.kiranacedamy.practicepage.configuration.ExtentManager;
import com.kiranacedamy.practicepage.configuration.ScreenshotUtils;

public class BaseTest {

	public static WebDriver driver;
		public static ExtentReports extent;


		@BeforeMethod
		public void beforeCheck() {
			driver = new ChromeDriver();
			driver.get("https://practicetestautomation.com/practice-test-login/");
			driver.manage().window().maximize();
		}

		@AfterMethod
		public void afterCheck() throws InterruptedException {

			if (driver != null) {
				Thread.sleep(5000);
				driver.quit();
			}
		}
		
		@AfterMethod
		public void afterCheck(ITestResult result) throws InterruptedException {
		    if (result.getStatus() == ITestResult.FAILURE) {
		        String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
		        ExtentManager.getTest().fail("Test Failed. Screenshot below:").addScreenCaptureFromPath(screenshotPath);
		    }
		    Thread.sleep(2000);
		    if (driver != null) {
		        driver.quit();
		    }
		}


		@BeforeSuite
		public void startReport() {
			extent = ExtentManager.getExtentReports();
			System.out.println("beforesuite" );
		}

		@AfterSuite
		public void endReport() {
			extent.flush();
			System.out.println("aftresuite");
		}

	}

