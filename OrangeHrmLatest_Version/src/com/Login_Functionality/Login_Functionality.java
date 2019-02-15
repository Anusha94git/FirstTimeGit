package com.Login_Functionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_Functionality {

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
		
		
		
		

	}

}
