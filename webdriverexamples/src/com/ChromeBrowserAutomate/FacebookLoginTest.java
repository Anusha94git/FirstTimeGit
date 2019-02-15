package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		WebDriver driver = null;
		
		String URL = "http://facebook.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(URL);
		
		
		// <input type="email" class="inputtext" name="email" id="email" data-testid="royal_email">
		
		driver.findElement(By.id("email")).sendKeys("anusha");
		
		// <input type="password" class="inputtext" name="pass" id="pass" data-testid="royal_pass">
		
		driver.findElement(By.id("pass")).sendKeys("hello");
		
		//<input value="Log In" aria-label="Log In" data-testid="royal_login_button" type="submit" id="u_0_2">
		
		driver.findElement(By.id("u_0_2")).click();
		
		
		
		
	}

}
