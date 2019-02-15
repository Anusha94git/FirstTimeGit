package com.Newtours_Using_Testng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class User_Registration_Multliple_testdata extends Base_Test_SetUP
{

	@Test(priority=0)
	public void register() throws IOException 
	{
		// <a href="mercuryregister.php?osCsid=803c79f6c9bebfdaa2cb7018c835af11">REGISTER</a>
		
		driver.findElement(By.linkText("REGISTER")).click(); //identifying the REGISTER and performing click on it
		
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Registration_testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet Sheet = workbook.getSheet("Sheet1");
		
		int row_count = Sheet.getLastRowNum();
		
		/*
		 * <input maxlength="60" name="firstName" size="20">    --------First Name
		 * <input maxlength="60" name="lastName" size="20">     --------Last Name
		 * <input maxlength="20" name="phone" size="15">        --------Phone Number
		 * <input name="userName" id="userName" size="35" maxlength="64">   -----------EMAIL
		 * <input maxlength="60" name="address1" size="40">     -----------Adress
		 * <input maxlength="60" name="city" size="15">    --------- City
		 * <input maxlength="40" name="state">     ---------State
		 * <input maxlength="20" name="postalCode" size="15">   -----Postal Code
		 * <select name="country" size="1"> 
                <option value="92">INDIA </option>  -------Country               

		 * <input name="email" id="email" size="20" maxlength="60">  ----------username
		 * <input maxlength="60" name="password" size="20" type="password">   -----------password
		 * <input maxlength="60" name="confirmPassword" size="20" type="password">  ----------confirm password
		 * <input type="image" name="register" src="/images/forms/submit.gif" width="60" height="23" border="0"> ----- Submit
		 * 
		 */
		
		for(int i=1; i<=row_count;i++)
		{
			Row r = Sheet.getRow(i);
			driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());    
			driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
			
			//Typecasting of phone number
			
			double d= r.getCell(2).getNumericCellValue();
			long x= (long)d;
			String phonenumber = Long.toString(x);		
			
			driver.findElement(By.name("phone")).sendKeys(phonenumber);
			

			driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());

			driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());

			driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
			driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
			

			
			double 	S = r.getCell(7).getNumericCellValue();
			long y =(long)S;
			String Postalcode = Long.toString(y);
			
			
			driver.findElement(By.name("state")).sendKeys(Postalcode);
			
			driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
			driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
			driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
			driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
			driver.findElement(By.name("register")).click();
			
				///html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b
			
			String expected_result = r.getCell(9).getStringCellValue();
			System.out.println("The expected result is : "+expected_result);
			
			String actual_result = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			
			if(actual_result.contains(expected_result))
			{
				System.out.println("user registered successfully - PASS");
				r.createCell(12).setCellValue("user registered successfully - PASS");
			}
			else
			{
				System.out.println("user registration failed - FAIL");
				r.createCell(12).setCellValue("user registration failed - FAIL");
			}
			
			FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Registration_testdata_Result.xlsx");
			workbook.write(file1);
			
			driver.navigate().back();
			driver.navigate().refresh();
		}
		
	}
}
