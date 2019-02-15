package com.ExcelOperations;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Print_MultipleData {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Sample_ExcelSheet1.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet Sheet = workBook.getSheet("Sheet2");
		
		//To print single v@lue
		
		Row r = Sheet.getRow(1);
		Cell c = r.getCell(1);
		
		if(c!=null)
		{
				
			String data = c.getStringCellValue();
	
			System.out.println(data);
		}
		else
		{
			System.out.println("There is no value");
		}
		
		//TO print multiple v@lues
		
		int Row_Count= Sheet.getLastRowNum();
		System.out.println("Number of Rows : " +Row_Count);
		for(int i=0;i<=Row_Count;i++)
		{
			Row r1 = Sheet.getRow(i);
			int Cell_Count = r1.getLastCellNum();
			
			System.out.println("Number of Cells : "+Cell_Count);
			
			
			
			for(int k=0;k<Cell_Count; k++)
			{
				String Multiple_data = r1.getCell(k).getStringCellValue();
				
				System.out.print(" " +Multiple_data +" ");
			}
			System.out.println();
		}
		
		
		

	}

}
