package com.SmartCommerce.NetworkPage;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.utilities.ExcelModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class SCLinksPage {


	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(SCLinksPage.class);
	private WebDriverWait wait;
	
	
	public By makeandmanage = By.xpath("//span[normalize-space()='Make & Manage']");
	public By clienttype = By.xpath("//select[@name='clientTypesSelector']");
	
	
	public SCLinksPage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}
	
	public String readHashFromExcel() throws IOException {
		// Specify the path of file
		File src = new File(
				"C:/Users/hashimfarooq/eclipse-workspace/NetworkRequest/src/test/resources/excel/HashList.xlsx");
		// load file
		FileInputStream fi = new FileInputStream(src);
		// Load workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		// Load Sheet
		XSSFSheet sheet = workbook.getSheet("C2CHash");

		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		//System.out.println(sheet.getRow(0).getCell(0));

		Cell CellValue = sheet.getRow(1).getCell(0);
		
		String value = CellValue.toString();
		
		return value;
		
	}


	
	public Boolean clickC2CLinks(String val) {
		
		String Hash = val;
		
		String testURL = "https://stage.click2cart.com/" + Hash;
		
		driver.get(testURL);

		if (driver.getPageSource().contains("Cart")) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
