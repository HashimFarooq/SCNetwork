package com.SmartCommerce.NetworkTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.SmartCommerce.NetworkPage.NetworkRequestPage;

public class NetworkRequestTest extends BaseTest {

	private WebDriver driver;
	private NetworkRequestPage NRP;
	private static final Logger log = LogManager.getLogger(NetworkRequestTest.class);

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {

		driver = initializeDriver();
		log.info("*************************Test Starting***************************");
		log.info("Driver is initialized...");
		NRP = new NetworkRequestPage(driver);

	}

	@Test(priority = 1, description = "Verify all the Network Requests", groups = { "SC_Smoke" })
	public void VERIFY_NETWORK_REQUESTS() {

		NRP.logBrowserConsoleLogs(driver);
		log.info("End of Network Requets.........");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {

		log.info("Closing Driver...");
		log.info("*************************Test Ending*****************************");
		driver.close();
	}
}
