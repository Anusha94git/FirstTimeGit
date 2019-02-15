package com.Testng_Framework;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PIM_Add_Employee_MultiData extends Basic_Test_SetUp
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
		
			
				driver.findElement(By.id("firstName")).sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.id("lastName")).sendKeys(r.getCell(1).getStringCellValue());
				
				/****************Employee ID***************/
				
				//String Employee_id = driver.findElement(By.id("employeeId")).getText();
				//System.out.println("Employee id is " +Employee_id);
				
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
				
				
				/*WebElement Status = driver.findElement(By.id("status"));
				//WebElement Status_tags = Status.findElement(By.tagName("option"));
				
				Select Selection = new Select(Status);
				
				Selection.selectByValue("Disabled");
				*/
				
				driver.findElement(By.id("status")).sendKeys(r.getCell(5).getStringCellValue());
					
				
				/**************************SAVE***********************/
				
				// <input type="button" class="" id="btnSave" value="Save">
		}
				
				
				
				driver.findElement(By.id("btnSave")).click();
				
	}
	
	@Test(priority=3)
	public void Edit_details() throws IOException
	{
		
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Excel_sheets\\AddEmployee_Firstdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row_count = sheet.getLastRowNum();
		
		/**************Edit Button*******************/
		
		// <input type="button" id="btnSave" value="Edit" class="">
		
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
							
			
			for(int i=1;i<=row_count;i++)
			{
				
				Row r = sheet.getRow(i);
			
			
			/********************DRIVING LICENCE NUMBER***************/
			// <input value="" type="text" name="personal[txtLicenNo]" maxlength="30" class="editable" id="personal_txtLicenNo">
			
			driver.findElement(By.id("personal_txtLicenNo")).sendKeys(r.getCell(6).getStringCellValue());
			
			
			
			/************************Licence Expiry Date*********************/
			
			// <input id="personal_txtLicExpDate" type="text" name="personal[txtLicExpDate]" class="calendar editable calendar hasDatepicker valid">
			
			double d = r.getCell(7).getNumericCellValue();
			long x = (long)d;
			String License = Long.toString(x);
			
			
			
			
			driver.findElement(By.id("personal_txtLicExpDate")).sendKeys(License);
			
			
			/**********************************Gender****************************/
			
			/* <li class="radio">
	        <label for="personal_optGender">Gender</label>
	        <ul class="radio_list"><li><input name="personal[optGender]" type="radio" 
	        
	        value="1" id="personal_optGender_1" class="editable">&nbsp;<label for="personal_optGender_1">Male</label></li>
			<li><input name="personal[optGender]" type="radio" value="2" id="personal_optGender_2" class="editable">&nbsp;
	        		<label for="personal_optGender_2">Female</label></li></ul>                        </li>
			
			*/
			
			/*WebElement Gender = driver.findElement(By.xpath("//label[@for='personal_optGender']"));
			
			Gender.findElement(By.xpath("//input [@value='2' and @id='personal_optGender_2']")).click();
			*/
			
			driver.findElement(By.xpath("//input [@value='2' and @id='personal_optGender_2']")).sendKeys(r.getCell(8).getStringCellValue());
			
			
			/*******************************Marital Status**********************************/
			
			/*<select name="personal[cmbMarital]" class="editable" id="personal_cmbMarital">
			<option value="" selected="selected">-- Select --</option>
			<option value="Single">Single</option>
			<option value="Married">Married</option>
			<option value="Other">Other</option>
			</select>
			*/
			
			/*WebElement Marital_Status = driver.findElement(By.id("personal_cmbMarital"));
			Select Marital = new Select(Marital_Status);
			Marital.selectByValue("Single");
			*/
			driver.findElement(By.id("personal_cmbMarital")).sendKeys(r.getCell(9).getStringCellValue());
			
			
			/*********************************Nationality**********************************/
			
			/* <li class="new">
	      
			<label for="personal_cmbNation">Nationality</label>
	        <select name="personal[cmbNation]" class="editable" id="personal_cmbNation">
			<opt	ion value="0">-- Select --</option>
			<opt	ion value="1">Afghan</option>
			<opt*/
			
			/*WebElement Nationality= driver.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]"));
			
			// <option value="82">Indian</option>
			Nationality.findElement(By.xpath("//option [@value='82']")).click();
			
			*/
			
			driver.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]")).sendKeys(r.getCell(10).getStringCellValue());
			
			
			/***************************************DATE OF BIRTH*******************************/
			
			//<input id="personal_DOB" type="text" name="personal[DOB]" class="editable calendar hasDatepicker">
			
			double d1 = r.getCell(11).getNumericCellValue();
			long y = (long)d1;
			String dob = Long.toString(y);
			
			
			driver.findElement(By.id("personal_DOB")).sendKeys(dob);
			
			/******************************************SAVE**********************************/
			
			// <input type="button" id="btnSave" value="Save" class="hover">
			
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
			
			
			//driver.findElement(By.xpath("//input[@value = 'save' and @class = 'hover']"));
			
				}

}
}

