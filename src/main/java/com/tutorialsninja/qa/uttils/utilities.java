package com.tutorialsninja.qa.uttils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {

	public static final int IMPLICIT_WAIT_time = 10;
	public static final int pageload_timeout = 10;

	public static String generateEmailWithTimestamps() {
		Date d = new Date();
		String timstamp = d.toString().replace(" ", "_").replace(":", "_");
		return "madhu" + timstamp + "@gmail.com";

	}

	public static Object[][] getTestDataFromExcel(String sheetName) {

		File f = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjatestdata.xlsx");
		XSSFWorkbook wb= null;
		try {
			FileInputStream fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}
	
	public static String captureScreenshort(WebDriver driver,String testname)
	{
		File screenshortfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String actualpath= System.getProperty("user.dir")+"\\screenshorts\\"+testname+".png";
		try {
			FileHandler.copy(screenshortfile, new File(actualpath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return actualpath;
	}

}
