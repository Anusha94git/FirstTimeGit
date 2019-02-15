package com.OHRM;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Log4j
{
	//creating object for logger class
		public static Logger logger=Logger.getLogger("OHRM_Log4j");
				
		WebDriver driver = null;
		String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		String username = "roott";
		String password = "Livetech7.30";
		
		@BeforeTest
		public void browserLaunch()
		{
			//Configuring logger properties file
			PropertyConfigurator.configure("log4j.properties");
			System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\driverFiles\\chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.get(url);
			logger.info("browser successfully opened");
				
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
		
		logger.info("Expected result is : "+expected_result);
		logger.info("Actual result is : " +actual_result);
		
		if(actual_result.equals(expected_result))
		{
			logger.info("logged successfully - PASS");
		}
		else
		{
				logger.info("failed to login - FAIL");
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
			logger.info("Logout successfully - PASS");
		}
		else
		{
			logger.info("Failed to logout - FAIL");
		}
		
	}
	
	@AfterTest
	public void browserClose()
	{
		driver.close();
	}

}
