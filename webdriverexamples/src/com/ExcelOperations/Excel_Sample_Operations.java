package com.ExcelOperations;

import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// import jxl.Workbook;

public class Excel_Sample_Operations 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Sample_ExcelSheet1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet Sheet = workbook.getSheet("Sheet1");
		Row r = Sheet.getRow(0);
		Cell c= r.getCell(0);
		
		String data= c.getStringCellValue();
		System.out.println(data);
		
		
		

	}

}
