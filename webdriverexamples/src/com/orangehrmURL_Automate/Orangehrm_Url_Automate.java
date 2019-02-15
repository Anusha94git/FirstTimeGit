package com.orangehrmURL_Automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orangehrm_Url_Automate {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url ="http://localhost/orangehrm";
		String Username = "admin";
		String Password = "admin";

		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		// <input name="txtUserName" type="text" class="loginText" tabindex="1">
		
		driver.findElement(By.name("txtUserName")).sendKeys(Username);
		
		// <input name="txtPassword" type="password" class="loginText" tabindex="2">
		
		driver.findElement(By.name("txtPassword")).sendKeys(Password);
		
		// input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		
		driver.findElement(By.name("Submit")).click();
	
		// <input type="reset" name="clear" value="Clear" class="button" tabindex="4">
		
		/*<ul id="option-menu">
     <li>Welcome admin</li>
	 <li><a href="./lib/controllers/CentralController.php?mtcode=CPW&amp;capturemode=updatemode&amp;id=USR001" target="rightMenu">Change Password</a></li>
	 <li><a href="./index.php?ACT=logout" target="rightMenu">Logout</a></li>
	
		</ul>
		 */
		
		String Expected_result = "Welcome admin";
		
		
		WebElement welcome_admin= driver.findElement(By.id("option-menu"));
			String Actual_result = welcome_admin.getText();
		// System.out.println("......" + Actual_result);
		
		
		if(Actual_result.contains(Expected_result))
		{	
				
		System.out.println("successfully login");
		
		}
		else
		{
			System.out.println("failed to login");
		}
		
		
		// <a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		
		driver.findElement(By.linkText("Logout")).click();
		
		System.out.println("logout ");
		
		driver.close();
			}

}
