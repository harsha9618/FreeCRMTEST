package com.crm.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxml4j.exceptions.InvalidFormatException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICITY_WAIT=20;
	
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\HARSHA\\Desktop\\FreeCrmTestData.xlsx";
			//"E:\\NaveenAutomationLab\\FreeCRMTEST\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
			
	static Workbook book;
	static Sheet sheet;
	
	//E:\\NaveenAutomationLab\\FreeCRMTEST\\src\\main\\java\\com\\crm\\qa\\testdata
	
	public void switchToFrame() {
		driver.switchTo().frame(0);
		
	}
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
		FileInputStream file= null;
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
 
}
}