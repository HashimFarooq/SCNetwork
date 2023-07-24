package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;

public class ExcelUtils {

	public WebDriver driver;

	public ExcelUtils(WebDriver driver) {
		this.driver = driver;
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

		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		//System.out.println(sheet.getRow(0).getCell(0));

		Cell CellValue = sheet.getRow(0).getCell(0);
		
		String value = CellValue.toString();
		
		return value;
		/*
		 * List<ExcelModel> modelList = new ArrayList<ExcelModel>(); int rowCount =
		 * sheet.getLastRowNum() - sheet.getFirstRowNum();
		 * 
		 * for (int i = 1; i < rowCount + 1; i++) { ExcelModel excelModel = new
		 * ExcelModel(); Row row = sheet.getRow(i); excelModel.hash =
		 * row.getCell(0).toString();
		 * 
		 * excelModel.lname = row.getCell(1).toString(); excelModel.email =
		 * row.getCell(2).toString(); excelModel.passWord = row.getCell(3).toString();
		 * row.getCell(4).setCellType(Cell.CELL_TYPE_STRING); excelModel.mobile =
		 * row.getCell(4).toString(); row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
		 * excelModel.month = row.getCell(5).toString();
		 * row.getCell(6).setCellType(Cell.CELL_TYPE_STRING); excelModel.day =
		 * row.getCell(6).toString(); row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
		 * excelModel.year = row.getCell(7).toString();
		 * 
		 * modelList.add(excelModel); } return modelList;
		 */
	}

	public List<ExcelModel> readProviderFromExcel() throws IOException {
		// Specify the path of file
		File src = new File(
				"C:/Users/hashimfarooq/eclipse-workspace/NetworkRequest/src/test/resources/excel/HashList.xlsx");
		// load file
		FileInputStream fi = new FileInputStream(src);
		// Load workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		// Load Sheet
		XSSFSheet sheet = workbook.getSheet("C2CHash");
		List<ExcelModel> modelList = new ArrayList<ExcelModel>();
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {
			ExcelModel excelModel = new ExcelModel();
			Row row = sheet.getRow(i);
			excelModel.hash = row.getCell(0).toString();
			/*
			 * excelModel.lname = row.getCell(1).toString(); excelModel.email =
			 * row.getCell(2).toString(); excelModel.passWord = row.getCell(3).toString();
			 * row.getCell(4).setCellType(Cell.CELL_TYPE_STRING); excelModel.mobile =
			 * row.getCell(4).toString(); row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
			 * excelModel.zipcode = row.getCell(5).toString();
			 */
			modelList.add(excelModel);
		}
		return modelList;
	}
}
