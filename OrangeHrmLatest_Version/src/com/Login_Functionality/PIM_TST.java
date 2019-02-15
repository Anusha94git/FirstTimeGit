package com.Login_Functionality;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PIM_TST {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String username = "roott";
		String password = "Livetech7.30";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// <input name="txtUsername" id="txtUsername" type="text"> - username
		
		// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password"> - password
		
		//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN"> - LOGIN
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		
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
		
		
		/********* PIM ELEMENT ***********/
		
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" 
		// id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
		
		WebElement PIM = driver.findElement(By.linkText("PIM"));
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		
		//Thread.sleep(1000);
		
		/******************ADD ELEMENT****************/
		
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		
		/******************Filling ADD EMPLOYEE DETAILS*************/
		
		// <input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		
		// <input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
		
		// <input class="formInputText" maxlength="10" type="text" name="employeeId" value="0001" id="employeeId">
		
		driver.findElement(By.id("firstName")).sendKeys("Livetech");
		driver.findElement(By.id("lastName")).sendKeys("Testing");
		
		//String Employee_id = driver.findElement(By.id("employeeId")).getText();
		//System.out.println("Employee id is " +Employee_id);
		
		/*************************PHOTOGRAPH****************************/
		
		// <input class="duplexBox" type="file" name="photofile" id="photofile">
		
		/*************************CHECKBOX******************************/

		//<input type="checkbox" name="chkLogin" value="1" id="chkLogin">
		
		driver.findElement(By.id("chkLogin")).click();
		
		
		/**********************USERNAME & PASSWORD*******************/
		
		// <input class="formInputText" maxlength="40" type="text" name="user_name" id="user_name">
		
		driver.findElement(By.id("user_name")).sendKeys("Livetech14");
		
		//<input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="user_password" id="user_password">
		
		driver.findElement(By.id("user_password")).sendKeys("Test_123@Tech");
		
		// <input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="re_password" id="re_password">
		
		driver.findElement(By.id("re_password")).sendKeys("Test_123@Tech");
		//Thread.sleep(1000);
		
		/* <select class="formInputText valid" name="status" id="status">
			<option value="Enabled" selected="selected">Enabled</option>
			<option value="Disabled">Disabled</option>
			</select>
		*/
		
		WebElement Status = driver.findElement(By.id("status"));
		//WebElement Status_tags = Status.findElement(By.tagName("option"));
		
		Select Selection = new Select(Status);
		
		Selection.selectByValue("Disabled");
			
		
		
		
		// <input type="button" class="" id="btnSave" value="Save">
		
		
		
		driver.findElement(By.id("btnSave")).click();
		
		/**********************EDIT BUTTON********************/
						
		
		// <input type="button" id="btnSave" value="Edit" class="">
		
		
		driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();
		
		/*******************Gender*******************/
		
		/* <li class="radio">
        <label for="personal_optGender">Gender</label>
        <ul class="radio_list"><li><input name="personal[optGender]" type="radio" 
        
        value="1" id="personal_optGender_1" class="editable">&nbsp;<label for="personal_optGender_1">Male</label></li>
		<li><input name="personal[optGender]" type="radio" value="2" id="personal_optGender_2" class="editable">&nbsp;
        		<label for="personal_optGender_2">Female</label></li></ul>                        </li>
		
		*/
		
			
		
		WebElement Gender = driver.findElement(By.xpath("//label[@for='personal_optGender']"));
		List<WebElement>Radiobuttons = Gender.findElements(By.className("editable"));
		System.out.println("The size of radiobuttons : "+Radiobuttons.size());
		
		Gender.findElement(By.xpath("//input [@value='2' and @id='personal_optGender_2']")).click();
		
		/***************Nationality**********************/
		
		/* <li class="new">
      
		<label for="personal_cmbNation">Nationality</label>
        <select name="personal[cmbNation]" class="editable" id="personal_cmbNation">
		<opt	ion value="0">-- Select --</option>
		<opt	ion value="1">Afghan</option>
		<opt*/
		
		
		//<select name="personal[cmbNation]" class="editable" id="personal_cmbNation" disabled="disabled">
		
		
		
		//WebElement Nationality = driver.findElement(By.xpath("//label [@for='personal_cmbNation']" ));
		
		//WebElement Nationality_1= Nationality.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]"));
		
		WebElement Nationality_1= driver.findElement(By.xpath("//select [@name='personal[cmbNation]' and @id='personal_cmbNation' ]"));
		
		
		Nationality_1.click();
		
		// <option value="82">Indian</option>
		Nationality_1.findElement(By.xpath("//option [@value='82']")).click();
		
		
		
		
		
		/***************SAVE BUTON************/
		// <input type="button" id="btnSave" value="Save" class="">
		
		//
		//*[@id="btnSave"]
		
		driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
		
			
		
			
	/*	
		//Logout functionality
		
		// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		
		driver.findElement(By.id("welcome")).click();
		
		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout
		//<a href="#" id="welcome" class="panelTrigger activated-welcome">Welcome Admin</a></a>
		
		driver.findElement(By.linkText("Logout")).click();
		
		String Logout_url = driver.getCurrentUrl();
		
		if(Logout_url.equals(url))
		{
			System.out.println("Logout successfully - PASS");
		}
		else
		{
			System.out.println("Failed to logout - FAIL");
		}
		
		
		
	*/


	}

}
