package com.SmartCommerce.NetworkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.testng.annotations.Test;

import com.SmartCommerce.NetworkPage.CDPPage;

import java.util.Optional;

public class CDPTest {

	private CDPPage CDP;
	private WebDriver driver;
	private ChromeDriver cdriver;

	@Test
	public void CaptureNetworkRequest() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe");

		cdriver = new ChromeDriver();

		CDP = new CDPPage(cdriver);
		CDP.CaptureRequest();
		CDP.CaptureResponse();
	}
}
