package com.kiranacedamy.practicepage.configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			String reportPath = System.getProperty("user.dir") + "/PracticePage Extent Report.html";
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Project", "TestNG Selenium sample Project");
			extent.setSystemInfo("Tester", "Rutik");
		}
		return extent;
	}

	public static ExtentTest createTest(String testName) {
		test = getExtentReports().createTest(testName);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}
}