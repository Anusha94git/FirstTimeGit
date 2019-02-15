package com.NewtoursTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{

	WebDriver driver = null;
	String url = "http://newtours.demoaut.com";
	
	@BeforeTest
	public void SetUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Seleniumworkspace\\PageObjectMethod\\driverFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void browserclose()
	{
		driver.close();
	}
	


}


