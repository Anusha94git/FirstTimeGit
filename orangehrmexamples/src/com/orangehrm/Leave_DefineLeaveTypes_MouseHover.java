package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Leave_DefineLeaveTypes_MouseHover {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url ="http://localhost/orangehrm";
		String username = "admin";
		String password = "admin";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\orangehrmexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		// <input name="txtUserName" type="text" class="loginText" tabindex="1">
		
		driver.findElement(By.name("txtUserName")).sendKeys(username);
		
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		
		// <input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		
		driver.findElement(By.name("Submit")).click();
		
		// <ul id="option-menu">
	    
		
		String welcome_admin = driver.findElement(By.id("option-menu")).getText();
		String expected_result = "Welcome admin";
		if(welcome_admin.contains(expected_result))
		{
			System.out.println("successfully logged in - PASS");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
		}
		else
		{
			System.out.println("failed to loggedin - FAIL");
		}
		
		
		/*<a href="./index.php?menu_no_top=leave" class="l1_link">
					<span class="drop">Leave</span>
				</a>	*/
		
		WebElement Leave= driver.findElement(By.linkText("Leave"));
		Actions act = new Actions(driver);
		act.moveToElement(Leave).build().perform();
		
		/*<a href="lib/controllers/CentralController.php?leavecode=Leave&amp;action=Leave_Type_Summary" target="rightMenu" class="l2_link leavetypes" onclick="menuclicked(this);">
		<span>Define Leave Types</span>
	</a>
	*/
	driver.findElement(By.linkText("Define Leave Types")).click();
	 	
		
		
		// <a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		
				driver.findElement(By.linkText("Logout")).click();
				driver.quit();



	}

}
