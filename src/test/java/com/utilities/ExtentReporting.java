package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.DisplayOrder;

public class ExtentReporting {
	private static ExtentReports reporter;
	public ExtentTest logger;
	public WebDriver driver;

	public ExtentReporting(WebDriver driver) {
		this.driver = driver;
	}

	public static ExtentReports getReport() {
		if (reporter == null) {
			reporter = new ExtentReports("E://Ortho//Automation Testing//ExtentReport//Report.html", true,
					DisplayOrder.NEWEST_FIRST);
		}
		return reporter;
	}

	public void closeReport() {
		if (reporter != null) {
			reporter.flush();
		}
	}

	public void captureScreenShot(String screenShotName) {

		try {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,
					new File("E://Ortho//Automation Testing//ExtentReport//ScreenShot//" + screenShotName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
