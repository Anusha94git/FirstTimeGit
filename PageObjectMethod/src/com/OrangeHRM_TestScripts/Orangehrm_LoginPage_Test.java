package com.OrangeHRM_TestScripts;

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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Orangehrm_LoginPage_Test extends BaseTest
{
	@Test
	public void LoginTest() throws IOException, InterruptedException
	{
		OrangeHrmObject_Repository Ohrm = PageFactory.initElements(driver, OrangeHrmObject_Repository.class);
		FileInputStream File = new FileInputStream("F:\\Seleniumworkspace\\PageObjectMethod\\Excel Sheets\\Orangehrm_TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row_count = sheet.getLastRowNum();
		
		for(int i=1;i<=row_count;i++)
		{
			Row r = sheet.getRow(i);
			
			
			Ohrm.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
			
			System.out.println("performed Login operation");
			
			
			
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
						if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid Credentials")||driver.findElement(By.id("spanMessage")).getText().equals("Csrf token validation failed"))
						{
							//File Orange_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
							
							
							//FileUtils.copyFile(Orange_Screenshot, new File("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Screenshots\\loginfailed("+i+").png"));
							
							Thread.sleep(5000);
							System.out.println("***********************");
							System.out.println("failed to login - FAIL");
							r.createCell(2).setCellValue("failed to login - FAIL");
							File Orange_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
							
							
							FileUtils.copyFile(Orange_Screenshot, new File("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Screenshots\\loginfailed("+i+").png"));
							
						
						}
					
					}
					
					
				
			
			
			System.out.println();
			
			FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\PageObjectMethod\\src\\com\\ApplicationTestResultFiles/Orangehrm_Testdata_Result.xlsx");
			workbook.write(file1);
			driver.navigate().back();
			//driver.navigate().refresh();
		}
			
		}
		
	}
