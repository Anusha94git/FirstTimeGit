package com.Testng_Framework;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class Login_Functionality_Using_TestData extends Basic_Test_SetUp
{
	@Test
	public void Login() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Excel_sheets\\Orangehrm_TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int Row_size = sheet.getLastRowNum();
		System.out.println("Row size is " +Row_size);
		
		for(int i=1;i<=Row_size;i++)
		{	
			System.out.println("***********"+i+"th iteration" +"**************** ");
			Row r = sheet.getRow(i);
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
	
		driver.findElement(By.id("btnLogin")).click();
		
		/******************Validation*****************/
	
	 
	//<span id="spanMessage">Invalid credentials</span>
	//<span id="spanMessage">Csrf token validation failed</span>
	try
	{	
		 String expected_result ="Welcome Admin";
			
			String actual_result = driver.findElement(By.id("welcome")).getText();
		
			System.out.println("Expected result is : "+expected_result);
		System.out.println("Actual result is : " +actual_result);
		
		if(actual_result.equals(expected_result))
		{
			System.out.println("if success");
			System.out.println("logged successfully - PASS");
			r.createCell(2).setCellValue("logged successfully - PASS");		
									
		}
	}
		catch(Exception e)
		{
			if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials")||driver.findElement(By.id("spanMessage")).getText().equals("Csrf token validation failed"))
			{
				File Orange_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
				
				
				FileUtils.copyFile(Orange_Screenshot, new File("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Screenshots\\loginfailed("+i+").png"));
				
				Thread.sleep(5000);
				System.out.println("***********************");
				System.out.println("failed to login - FAIL");
				r.createCell(2).setCellValue("failed to login - FAIL");
				
			
			}
		
		}
		
		
			
		FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Excel_sheets\\Orangehrm_TestData_Result.xlsx");
		workbook.write(file1);
		
		driver.navigate().back();
		}
	
	}
}
