package com.sw.utilities;


import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelReader(String excelPath, int n) {
		try {
			FileInputStream fis= new FileInputStream(excelPath);
			wb= new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(n);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getData(int sheetNumber, int row, int coulmn) {
		try {
			if (wb != null) {
				sheet=wb.getSheetAt(sheetNumber);
	        } else {
	            System.out.println("Workbook is not initialized.");
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String data=sheet.getRow(row).getCell(coulmn).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		int row = 0;
		if (wb != null) {
		   row=wb.getSheetAt(sheetIndex).getLastRowNum();
			row=row+1;
        } else {
            System.out.println("Workbook is not initialized.");
        }
		
		return row;
	}

}
