package com.OHRM_TestScripts;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.OHRM_Library.LoginKeywords;

public class LoginTest 
{
	@Test
	public void Login() throws IOException
	{
		LoginKeywords Keys = new LoginKeywords();
		
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\Keyboard_Driven_Framework\\src\\com\\ExcelTestDataFiles\\TestCase_Excel_File.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row r =null;
		int row_count = sheet.getLastRowNum();
		for(int i=1;i<=row_count;i++)
		{
			r=sheet.getRow(i);
			String runmode = r.getCell(4).getStringCellValue();
			if(runmode.equals("y"))
			{
				String Keyword = r.getCell(3).getStringCellValue();
				
				if(Keyword.equalsIgnoreCase("launchbrowser"))
				{
					Keys.launchbrowser();
					System.out.println("launch");
				}
				if(Keyword.equalsIgnoreCase("navigate"))
				{
					Keys.navigate();
					System.out.println("navigate");
				}
				if(Keyword.equalsIgnoreCase("enterusername"))
				{
					Keys.enterusername();
					System.out.println("username");
				}
				if(Keyword.equalsIgnoreCase("enterpassword"))
				{
					Keys.enterpassword();
					System.out.println("Password");
	
				}
				if(Keyword.equalsIgnoreCase("clicklogin"))
				{
					Keys.clicklogin();
					System.out.println("click");
	
				}
	
			}
		}
	}
}
		

