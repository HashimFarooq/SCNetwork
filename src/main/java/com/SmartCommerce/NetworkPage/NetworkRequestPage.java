package com.SmartCommerce.NetworkPage;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class NetworkRequestPage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(NetworkRequestPage.class);
	private Date var;

	public NetworkRequestPage(WebDriver driver) {

		this.driver = driver;

	}

	public void logBrowserConsoleLogs(WebDriver driver) {
		all(LogType.PERFORMANCE, driver);
	}

	public void all(String logTypes, WebDriver driver) {
		String var;
		// String authorizationtoken = "";
		// String host = "";
		List<LogEntry> logEntries = driver.manage().logs().get(logTypes).getAll();
		for (LogEntry entry : logEntries) {
			var = new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage();
			log.info("Network Request/Response: " + var);
			System.out.println(var);
		}
		// System.out.println("DeubiAuthorizationToken: " + authorizationtoken);
		// System.out.println("DeubiAuthorizationHost" + host);
		System.out.println("=======================================================");
	}

}
