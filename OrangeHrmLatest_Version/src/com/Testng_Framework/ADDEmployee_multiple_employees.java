package com.Testng_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ADDEmployee_multiple_employees extends Basic_Test_SetUp
{

	String username = "roott";
	String password = "Livetech7.30";

	@Test(priority = 0)
	public void login()
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		String expected_result ="Welcome Admin";
		
		String actual_result = driver.findElement(By.id("welcome")).getText();
		
		System.out.println("Expected result is : "+expected_result);
		System.out.println("Actual result is : " +actual_result);
		
		if(actual_result.equals(expected_result))
		{
			System.out.println("logged successfully - PASS");
		}
		else
		{
			System.out.println("failed to login - FAIL");
		}
		
		
	}
	
	@Test(priority=1)
	public void addemployee()
	{
				
				WebElement PIM = driver.findElement(By.linkText("PIM"));
				Actions act = new Actions(driver);
				act.moveToElement(PIM).build().perform();
				
				
				
				/******************ADD ELEMENT****************/
				
				
				driver.findElement(By.id("menu_pim_addEmployee")).click();
				
	}

	
	@Test(priority=2)
	public void filldetails() throws IOException
	{
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Excel_sheets\\AddEmployee_Firstdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row_count = sheet.getLastRowNum();
		for(int i=1;i<=row_count;i++)
		{
			
			Row r = sheet.getRow(i);
		/*****************First Name & Last Name************************/
		
			
				WebElement Firstname =driver.findElement(By.id("firstName"));
				Firstname.sendKeys(r.getCell(0).getStringCellValue());
				WebElement LastName= driver.findElement(By.id("lastName"));
				LastName.sendKeys(r.getCell(1).getStringCellValue());
				
					/****************Employee ID***************/
				
				//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0045" id="employeeId">
				
				WebElement Employee_id = driver.findElement(By.id("employeeId"));
				String Employee_Details_Id = Employee_id.getAttribute("value");
				System.out.println("Emp id is " +Employee_Details_Id);
				
				
				
				
				/*************************PHOTOGRAPH****************************/
				
				// <input class="duplexBox" type="file" name="photofile" id="photofile">
				
				/*************************CHECKBOX******************************/

				//<input type="checkbox" name="chkLogin" value="1" id="chkLogin">
				
				driver.findElement(By.id("chkLogin")).click();
				
				
				/**********************USERNAME & PASSWORD*******************/
				
				// <input class="formInputText" maxlength="40" type="text" name="user_name" id="user_name">
				//<input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="user_password" id="user_password">
				// <input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="re_password" id="re_password">
				
				
				driver.findElement(By.id("user_name")).sendKeys(r.getCell(2).getStringCellValue());				
				
				driver.findElement(By.id("user_password")).sendKeys(r.getCell(3).getStringCellValue());				
				
				driver.findElement(By.id("re_password")).sendKeys(r.getCell(4).getStringCellValue());
				
				
		/*************************STATUS******************/
				
				
				
				driver.findElement(By.id("status")).sendKeys(r.getCell(5).getStringCellValue());
					
				
				/**************************SAVE***********************/
				
						
				
				driver.findElement(By.id("btnSave")).click();
				
		/**************Edit Button*******************/
		
		// <input type="button" id="btnSave" value="Edit" class="">
		
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
							
			/*****************Employee Id***************/
			
			
			//<input value="0022" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable valid" id="personal_txtEmployeeId">
			
			WebElement Emp_Id= driver.findElement(By.id("personal_txtEmployeeId"));
			String Employee_Personal_ID= Emp_Id.getAttribute("value");
			System.out.println("Emp id is " +Employee_Personal_ID);
		
			
			
			/********************DRIVING LICENCE NUMBER***************/
			// <input value="" type="text" name="personal[txtLicenNo]" maxlength="30" class="editable" id="personal_txtLicenNo">
			
			driver.findElement(By.id("personal_txtLicenNo")).sendKeys(r.getCell(6).getStringCellValue());
			
			
			
			/************************Licence Expiry Date*********************/
			
			// <input id="personal_txtLicExpDate" type="text" name="personal[txtLicExpDate]" class="calendar editable calendar hasDatepicker valid">
			
			/*double d = r.getCell(7).getNumericCellValue();
			long x = (long)d;
			String License = Long.toString(x);
			*/
			
			Date date = new Date();
			DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			String License1 = formatter.format(date);
			
							
			
		WebElement License	= driver.findElement(By.id("personal_txtLicExpDate"));
		License.clear();
			License.sendKeys(License1);
			
			
			/**********************************Gender****************************/
			
			
			
			driver.findElement(By.xpath("//input [@value='2' and @id='personal_optGender_2']")).sendKeys(r.getCell(8).getStringCellValue());
			
			
			/*******************************Marital Status**********************************/
			
			
			driver.findElement(By.id("personal_cmbMarital")).sendKeys(r.getCell(9).getStringCellValue());
			
			
			/*********************************Nationality**********************************/
			
			
			driver.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]")).sendKeys(r.getCell(10).getStringCellValue());
			
			
			/***************************************DATE OF BIRTH*******************************/
			
			//<input id="personal_DOB" type="text" name="personal[DOB]" class="editable calendar hasDatepicker">
			
			/*double d1 = r.getCell(11).getNumericCellValue();
			long y = (long)d1;
			String dob = Long.toString(y);
			
			*/
			String DateofBirth = formatter.format(date);
		
			
			
			WebElement DOB = driver.findElement(By.id("personal_DOB"));
			DOB.clear();
			DOB.sendKeys(DateofBirth);
			
			/******************************************SAVE**********************************/
			
			// <input type="button" id="btnSave" value="Save" class="hover">
			
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
			
			
			//driver.findElement(By.xpath("//input[@value = 'save' and @class = 'hover']"));
			
			
			if(Employee_Details_Id.equals(Employee_Personal_ID))
			{
				System.out.println("Employee ID matched - PASS");
			}
			else
			{
				System.out.println("Employee ID doesn't matched - FAIL ");
			}
			
			
				
		
		driver.navigate().back();
		driver.navigate().refresh();
	}


}
}
