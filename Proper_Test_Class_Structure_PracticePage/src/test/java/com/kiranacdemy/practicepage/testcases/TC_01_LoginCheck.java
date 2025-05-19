package com.kiranacdemy.practicepage.testcases;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.kiranacdemy.practicepage.constnce.Locators;
import com.kiranacdemy.practicepage.constnce.TestData;
import com.kiranacdemy.practicepage.constnce.Titles;
import com.kiranacedamy.practicepage.base.BaseTest;
import com.kiranacedamy.practicepage.configuration.ExtentManager;
public class TC_01_LoginCheck extends BaseTest {

	@Test
	public void TC_01_loginCheck() {
		ExtentManager.createTest("TC_01_LoginCheck");
		ExtentReports extent = ExtentManager.getExtentReports();
		
		driver.findElement(By.id(Locators.USERNAME_BY_ID)).sendKeys(TestData.USERNAME);
		driver.findElement(By.id(Locators.PASSWORD_BY_ID)).sendKeys(TestData.PASSWORD);
		driver.findElement(By.id(Locators.SUBMITBUTTON_BY_ID)).click();
		
		String title = driver.getTitle();
		
		assertEquals(title, Titles.DASHBOARD_TITLE);
		
		ExtentManager.getTest();
		extent.flush();
	}
	
}

