package com.Testng_Framework;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PIM_Element extends Basic_Test_SetUp
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
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" 
				// id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
				
				WebElement PIM = driver.findElement(By.linkText("PIM"));
				Actions act = new Actions(driver);
				act.moveToElement(PIM).build().perform();
				
				// Thread.sleep(1000);
				
				/******************ADD ELEMENT****************/
				
				// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
				
				driver.findElement(By.id("menu_pim_addEmployee")).click();
				
	}

	
	@Test(priority=2)
	public void filldetails()
	{
		/*****************First Name & Last Name************************/
		
		/* <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		
				// <input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
				
				// <input class="formInputText" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
		 */
			
				driver.findElement(By.id("firstName")).sendKeys("Livetech");
				driver.findElement(By.id("lastName")).sendKeys("Testing");
				
				/****************Employee ID***************/
				
				//<input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0045" id="employeeId">
				
				WebElement Employee_id = driver.findElement(By.id("employeeId"));
				//Employee_id.getAttribute("value");
				System.out.println("Emp id is " +Employee_id.getAttribute("value"));
				
				/*************************PHOTOGRAPH****************************/
				
				// <input class="duplexBox" type="file" name="photofile" id="photofile">
				
				/*************************CHECKBOX******************************/

				//<input type="checkbox" name="chkLogin" value="1" id="chkLogin">
				
				driver.findElement(By.id("chkLogin")).click();
				
				
				/**********************USERNAME & PASSWORD*******************/
				
				// <input class="formInputText" maxlength="40" type="text" name="user_name" id="user_name">
				//<input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="user_password" id="user_password">
				// <input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="re_password" id="re_password">
				
				
				driver.findElement(By.id("user_name")).sendKeys("Livetech6");				
				
				driver.findElement(By.id("user_password")).sendKeys("Test_123@Tech");				
				
				driver.findElement(By.id("re_password")).sendKeys("Test_123@Tech");
				
				
		/*************************STATUS******************/
				
				/* <select class="formInputText valid" name="status" id="status">
					<option value="Enabled" selected="selected">Enabled</option>
					<option value="Disabled">Disabled</option>
					</select>
				*/
				
				WebElement Status = driver.findElement(By.id("status"));
				//WebElement Status_tags = Status.findElement(By.tagName("option"));
				
				Select Selection = new Select(Status);
				
				Selection.selectByValue("Disabled");
					
				
				/**************************SAVE***********************/
				
				// <input type="button" class="" id="btnSave" value="Save">
				
				
				
				driver.findElement(By.id("btnSave")).click();
				
	}
	
	@Test(priority=3)
	public void Edit_details()
	{
		/**************Edit Button*******************/
		
		// <input type="button" id="btnSave" value="Edit" class="">
		
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
							
			
			/*****************Employee Id***************/
			//<input value="0022" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable valid" id="personal_txtEmployeeId">
			
			WebElement Emp_Id= driver.findElement(By.id("personal_txtEmployeeId"));
			System.out.println("Emp id is " +Emp_Id.getAttribute("value"));
			
			
			/********************DRIVING LICENCE NUMBER***************/
			// <input value="" type="text" name="personal[txtLicenNo]" maxlength="30" class="editable" id="personal_txtLicenNo">
			
			driver.findElement(By.id("personal_txtLicenNo")).sendKeys("uyy88765788");
			
			
			
			/************************Licence Expiry Date*********************/
			
			// <input id="personal_txtLicExpDate" type="text" name="personal[txtLicExpDate]" class="calendar editable calendar hasDatepicker valid">
			
			driver.findElement(By.id("personal_txtLicExpDate")).sendKeys("2020-08-01");
			
			
			/**********************************Gender****************************/
			
			/* <li class="radio">
	        <label for="personal_optGender">Gender</label>
	        <ul class="radio_list"><li><input name="personal[optGender]" type="radio" 
	        
	        value="1" id="personal_optGender_1" class="editable">&nbsp;<label for="personal_optGender_1">Male</label></li>
			<li><input name="personal[optGender]" type="radio" value="2" id="personal_optGender_2" class="editable">&nbsp;
	        		<label for="personal_optGender_2">Female</label></li></ul>                        </li>
			
			*/
			
			WebElement Gender = driver.findElement(By.xpath("//label[@for='personal_optGender']"));
			
			Gender.findElement(By.xpath("//input [@value='2' and @id='personal_optGender_2']")).click();
			
			/*******************************Marital Status**********************************/
			
			/*<select name="personal[cmbMarital]" class="editable" id="personal_cmbMarital">
			<option value="" selected="selected">-- Select --</option>
			<option value="Single">Single</option>
			<option value="Married">Married</option>
			<option value="Other">Other</option>
			</select>
			*/
			
			WebElement Marital_Status = driver.findElement(By.id("personal_cmbMarital"));
			Select Marital = new Select(Marital_Status);
			Marital.selectByValue("Single");
			
			
			/*********************************Nationality**********************************/
			
			/* <li class="new">
	      
			<label for="personal_cmbNation">Nationality</label>
	        <select name="personal[cmbNation]" class="editable" id="personal_cmbNation">
			<opt	ion value="0">-- Select --</option>
			<opt	ion value="1">Afghan</option>
			<opt*/
			
			WebElement Nationality= driver.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]"));
			
			// <option value="82">Indian</option>
			Nationality.findElement(By.xpath("//option [@value='82']")).click();
			
			
			/***************************************DATE OF BIRTH*******************************/
			
			//<input id="personal_DOB" type="text" name="personal[DOB]" class="editable calendar hasDatepicker">
			
			driver.findElement(By.id("personal_DOB")).sendKeys("1994-01-01");
			
			/******************************************SAVE**********************************/
			
			// <input type="button" id="btnSave" value="Save" class="hover">
			
			driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
			
			
			//driver.findElement(By.xpath("//input[@value = 'save' and @class = 'hover']"));
			
			
			
				}
	
	
}
