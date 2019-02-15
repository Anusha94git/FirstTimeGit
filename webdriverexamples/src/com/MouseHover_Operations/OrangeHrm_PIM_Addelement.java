package com.MouseHover_Operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHrm_PIM_Addelement {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://localhost/orangehrm";
		String Username = "admin";
		String Password = "admin";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
		//<input name="txtUserName" type="text" class="loginText" tabindex="1">
		
		driver.findElement(By.name("txtUserName")).sendKeys(Username);
		
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		
		driver.findElement(By.name("txtPassword")).sendKeys(Password);
		
		//<input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		
		driver.findElement(By.name("Submit")).click();
		
		// id = "option-menu-bar"
		
		WebElement Welcome = driver.findElement(By.id("option-menu"));
		String Actual_Result = Welcome.getText();
		System.out.println(Actual_Result);
		
		String expected_Result = "Welcome admin";
		
		
		
		if(Actual_Result.contains(expected_Result))
		{
			 System.out.println("Successfully logged - PASS");
			 
		}
		else
		{
			System.out.println("Failed to login - FAIL");
		}
			
		
		/* <a href="./index.php?menu_no_top=hr" class="l1_link">
		<span class="drop current">PIM</span>
	</a>
		*/
		
		WebElement PIM = driver.findElement(By.linkText("PIM"));
		
		Actions act = new Actions(driver);
		act.moveToElement(PIM).build().perform();
		
		/* <a href="./lib/controllers/CentralController.php?reqcode=EMP&amp;capturemode=addmode" target="rightMenu" 
		 * class="l2_link empadd" onclick="menuclicked(this);">
								<span>Add Employee</span>
							</a>
							*/
		
		driver.findElement(By.linkText("Add Employee")).click();
		
		// <a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
