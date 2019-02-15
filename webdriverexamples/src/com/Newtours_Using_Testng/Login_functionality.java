package com.Newtours_Using_Testng;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login_functionality extends Base_Test_SetUP
{

	@Test
	public void Login_Functionality() throws IOException, InterruptedException
	{
		// <input type="text" name="userName" size="10">
		//<input type="password" name="password" size="10">
		//<input type="image" name="login" value="Login" src="/images/btn_signin.gif" width="58" height="17" alt="Sign-In" border="0">
		
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\webdriverexamples\\ExcelSheets\\Newtours_Login_Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int Row_size = sheet.getLastRowNum();
		
		for(int i=1;i<=Row_size;i++)
		{
		
			System.out.println("****************"+i+"th iteration"+"***************");
			
				Row r = sheet.getRow(i);
				
		
				System.out.println("Newtours page opened");
			
				driver.findElement(By.name("userName")).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.name("password")).sendKeys(r.getCell(1).getStringCellValue());
				driver.findElement(By.name("login")).click();
		
		
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
