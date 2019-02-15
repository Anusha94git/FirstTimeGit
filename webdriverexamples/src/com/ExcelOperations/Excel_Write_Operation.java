package com.ExcelOperations;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write_Operation {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Sample_ExcelSheet1.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet Sheet = workBook.getSheet("Sheet1");
		
		Row r= Sheet.createRow(0);
		Cell c = r.createCell(1);
		Cell c1 = r.createCell(2);
		c.setCellValue("Srinivas");
		c1.setCellValue("Hello");
		
		
		// Saving the file
		FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Sample_ExcelSheet1.xlsx");
		workBook.write(file1);

	}

}

