package com.OHRM_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginKeywords 
{
	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\Keyboard_Driven_Framework\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void navigate()
	{
		driver.get(url);
		
	}
	
	public void enterusername()
	{
		driver.findElement(By.id("txtUsername")).sendKeys("roott");
	}
	
	public void enterpassword()
	{
		driver.findElement(By.id("txtPassword")).sendKeys("Livetech7.30");
	}
	
	public void clicklogin()
	{
		driver.findElement(By.id("btnLogin")).click();
		
	}
}
