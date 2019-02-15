package com.xpath_Locator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Login_UsingXpath {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String URL = "http://facebook.com";
		String username = "anusha";
		String password = "hello";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// <input type="email" class="inputtext" name="email" id="email" data-testid="royal_email">
		
		// driver.findElement(By.id("email")).sendKeys(username);
		
		driver.findElement(By.xpath("//input [@data-testid='royal_email']")).sendKeys(username);
		
		// <input type="password" class="inputtext" name="pass" id="pass" data-testid="royal_pass">
		
		//driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.findElement(By.xpath("//input [@data-testid = 'royal_pass']")).sendKeys(password);
		
		// <input value="Log In" aria-label="Log In" data-testid="royal_login_button" type="submit" id="u_0_2">
		 
		//driver.findElement(By.id("u_0_2")).click();
		
		driver.findElement(By.xpath("//input [@data-testid = 'royal_login_button']")).click();
	}

}
