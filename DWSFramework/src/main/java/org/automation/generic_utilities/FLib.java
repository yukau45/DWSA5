package org.automation.generic_utilities;

import static org.automation.generic_utilities.IAutoConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author my
 * This class is used to fetch the data
 */
public class FLib {
/**
 * This method is used to fetch the data from properties file
 * @param key
 * @return value
 */
     public static String readDataFromProperties(String key) {
    	File f = new File(PROPERTIES_PATH);
    	FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	Properties prop = new Properties();
    	try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return prop.getProperty(key);
     }
     
 /**
  * This method is used to fetch the data from cell given in Excel sheet
  * @param sheetName
  * @param rowIndex
  * @param cellIndex
  * @return data present in cell
  */
     public static String readDataFromExcel(String sheetName, int rowIndex, int cellIndex) {
    	File file = new File(EXCEL_PATH);
 		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
 		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).toString();
    	return data;
     }
}
