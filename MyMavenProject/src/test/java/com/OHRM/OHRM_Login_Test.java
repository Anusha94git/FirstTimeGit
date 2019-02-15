package com.OHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Login_Test 
{
	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	String username = "roott";
	String password = "Livetech7.30";
	
	@BeforeTest
	public void browserLaunch()
	{

		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Login()
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test(priority=2)
	public void Login_Validation()
	{
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
	
	@Test(priority=3)
	public void Logout_functionality()
	{
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
	
	@AfterTest
	public void browserClose()
	{
		driver.close();
	}
	
	
}


