package com.SmartCommerce.NetworkTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.ExcelModel;
import com.utilities.ExcelUtils;
import com.SmartCommerce.NetworkPage.SCLinksPage;

import com.utilities.ExtentReporting;



public class SCLinksTest extends BaseTest{
	
	private WebDriver driver;
	private SCLinksPage LP;
	private WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(SCLinksTest.class);
	private static ExtentTest logger;
	public static String winHandleBefore;
	private ExcelUtils readExcel;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("*************************Test Starting***************************");
		log.info("Driver is initialized...");
		LP = new SCLinksPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
	}
	
	
	@Test(priority = 1, description = "Verify Click2Cart Links", groups = { "SC_Smoke" })
	public void C2C_Verify_URLS() throws IOException {

		String hashValue = LP.readHashFromExcel();
		Assert.assertTrue(LP.clickC2CLinks(hashValue));
	}
  
  
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		log.info("Closing Driver...");
		log.info("*************************Test Ending*****************************");
		driver.close();
	}
}
