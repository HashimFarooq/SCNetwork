package com.SmartCommerce.NetworkTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class BaseTest {

	private WebDriver driver;
	protected static Properties prop;
	protected static Properties propExcel;
	private static final Logger log = LogManager.getLogger(BaseTest.class);
	LoggerContext context = (LoggerContext) LogManager.getContext(false);
	File file = new File("src/test/resources/properties/log4j2.xml");

	public WebDriver initializeDriver() throws IOException {
		prop = loadConfig();
		propExcel = loadExcel();
		context.setConfigLocation(file.toURI());
		String browserName = prop.getProperty("browser");
		String browserURL = prop.getProperty("urlnew");
		//String fileUpload = prop.getProperty("IMAGE_FILE_UPLOAD_PATH");
		ChromeOptions options = new ChromeOptions();

		log.debug("Running on browser: " + browserName);

		if (browserName.equals("chrome")) {

			// Creating Chrome options
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-application-cache");
			options.addArguments("--disable-xss-auditor");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--test-type");
			options.addArguments("start-maximized");
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			
			// add Network logging
			LoggingPreferences logPrefs = new LoggingPreferences();
		    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		    logPrefs.enable(LogType.PROFILER, Level.ALL);
		    logPrefs.enable(LogType.CLIENT, Level.ALL);
		    logPrefs.enable(LogType.BROWSER, Level.ALL);
		    options.setCapability("goog:loggingPrefs", logPrefs);
		    
		    Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
		    perfLogPrefs.put("enableNetwork", true);
		    perfLogPrefs.put("traceCategories", "devtools.network");
		    
		    options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe");
			
			driver = new ChromeDriver(options);
			//driver.get(browserURL);
			

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/IEDriverServer");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(browserName + " is not a valid browser");
		}
		return driver;
	}

	public Properties loadConfig() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		prop.load(fis);
		return prop;
	}
	
	
	public Properties loadExcel() throws IOException {
		Properties propExcel = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/excel/HashList.xlsx");
		propExcel.load(fis);
		return prop;
	}
}
