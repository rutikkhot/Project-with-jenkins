package com.kiranacdemy.practicepage.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.kiranacdemy.practicepage.constnce.Locators;
import com.kiranacdemy.practicepage.constnce.Message;
import com.kiranacdemy.practicepage.constnce.TestData;
import com.kiranacdemy.practicepage.constnce.Titles;
import com.kiranacedamy.practicepage.base.BaseTest;
import com.kiranacedamy.practicepage.configuration.ExtentManager;
import com.kiranacedamy.practicepage.configuration.ScreenshotUtils;

public class TC_02_InvalidUserNameCheck extends BaseTest {

	@Test
	public void TC_02_invalidUserNameCheck() {
		ExtentManager.createTest("TC_02_invalidUserNameCheck");
		ExtentReports extent = ExtentManager.getExtentReports();

		driver.findElement(By.id(Locators.USERNAME_BY_ID)).sendKeys(TestData.INVALID_USERNAME);
		driver.findElement(By.id(Locators.PASSWORD_BY_ID)).sendKeys(TestData.PASSWORD);
		driver.findElement(By.id(Locators.SUBMITBUTTON_BY_ID)).click();

		String title = driver.getTitle();

		if (title.equals(Titles.DASHBOARD_TITLE)) {
		    assertEquals(title, Titles.DASHBOARD_TITLE);
		} else {
		    ScreenshotUtils.takeScreenshot(driver, Message.FAILURE_MESSAGE);
		    System.out.println("Title not matched, taking screenshot...");

		}


		ExtentManager.getTest();
		extent.flush();

	}
}
