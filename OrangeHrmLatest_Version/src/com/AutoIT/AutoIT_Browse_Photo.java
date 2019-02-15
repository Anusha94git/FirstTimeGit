package com.AutoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoIT_Browse_Photo
{

	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	String username = "roott";
	String password = "Livetech7.30";

	
	@BeforeTest
	public void Setup()
	{
		String browser = "Chrome";
		if(browser.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
		
	

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
	public void filldetails() throws IOException, InterruptedException
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
				
				driver.findElement(By.id("photofile")).click();
				java.lang.Runtime.getRuntime().exec("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\AutoIT Scripts\\Orangehrm_Browse.exe");
				//java.lang.Runtime.getRuntime().exec("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\AutoIT Scripts\\OrangeHrm_With_Path.exe");
				
				Thread.sleep(1000);
				
				/*************************CHECKBOX******************************/

				//<input type="checkbox" name="chkLogin" value="1" id="chkLogin">
				
				driver.findElement(By.id("chkLogin")).click();
				
				
				/**********************USERNAME & PASSWORD*******************/
				
				// <input class="formInputText" maxlength="40" type="text" name="user_name" id="user_name">
				//<input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="user_password" id="user_password">
				// <input class="formInputText passwordRequired" maxlength="64" autocomplete="off" type="password" name="re_password" id="re_password">
				
				
				driver.findElement(By.id("user_name")).sendKeys("Livetech7");				
				
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
	
	@AfterTest
	public void teardown()
	{
		//driver.quit();
	}

}
