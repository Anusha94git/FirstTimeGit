package com.Newtours_Using_Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Test_SetUP 
{

	WebDriver driver = null;
	String url = "http://newtours.demoaut.com";
	
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
	}
		
		@AfterTest
		public void teardown()
		{
			//driver.quit();
		}
		
	}
	
	
	
