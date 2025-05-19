package com.kiranacedamy.practicepage.configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



	public class ScreenshotUtils {

		public static String takeScreenshot(WebDriver driver, String screenshotName) {
		    String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		    String destDir = System.getProperty("user.dir") + "/screenshots";
		    File dir = new File(destDir);
		    if (!dir.exists()) {
		        dir.mkdir();  // create folder if not exists
		    }

		    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String destPath = destDir + "/" + screenshotName + "_" + timeStamp + ".png";

		    try {
		        FileUtils.copyFile(srcFile, new File(destPath));
		        System.out.println("Screenshot saved at: " + destPath); // 👈 Debug print
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    return destPath;
		}
	}


