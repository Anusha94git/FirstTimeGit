package com.Newtours_Using_Testng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Newtours_Login_Using_Properties_File extends Base_Test_SetUP
{

	@Test
	public void Login_Functionality() throws IOException, InterruptedException
	{
		
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Newtours_Login_Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int Row_size = sheet.getLastRowNum();
		
		for(int i=1;i<=Row_size;i++)
		{
		
			System.out.println("****************"+i+"th iteration"+"***************");
			
				Row r = sheet.getRow(i);
				
				FileInputStream file2 = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\src\\com\\Newtours_Using_Testng\\Newtours.properties");
				Properties pr = new Properties();
				pr.load(file2);
		
				System.out.println("Newtours page opened");
			
				driver.findElement(By.name(pr.getProperty("uname"))).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.name(pr.getProperty("pwd"))).sendKeys(r.getCell(1).getStringCellValue());
				driver.findElement(By.name(pr.getProperty("signin"))).click();
		
		
				/*<td class="mouseOut" width="73" height="33" align="center" 
			onmouseout="changeStyle(this, 'mouseOut')" onmouseover="changeStyle(this, 'mouseOver')">
			<a href="mercurysignoff.php">SIGN-OFF</a></td>*/
		
			/*WebElement Sign_Off= driver.findElement(By.linkText("SIGN-OFF"));
			if(Sign_Off.isDisplayed())
				{
					System.out.println("Login successful - PASS");
					r.createCell(2).setCellValue("Login successful - PASS");
					//Sign_Off.click();
				}
				else 
				{
					System.out.println("Login failed - FAIL");
					r.createCell(2).setCellValue("Login failed - FAIL");
				}
		*/
				
				String expected = "Find";
				String actual = driver.getTitle();
				if(actual.contains(expected))
				{
					System.out.println("Login successful - PASS");
					r.createCell(2).setCellValue("Login successful - PASS");
				}
				else 
				{
					System.out.println("Login failed - FAIL");
					r.createCell(2).setCellValue("Login failed - FAIL");
				}
					
				
				
									
				Thread.sleep(5000);
				FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Newtours_Login_Testdata_Result.xlsx");
				workbook.write(file1);
		
				driver.navigate().back();
		}
		
		
	}

}
