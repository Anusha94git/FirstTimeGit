package com.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class Login_Using_Xpath {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url ="http://localhost/orangehrm";
		String username = "admin";
		String password = "admin";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\orangehrmexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		// <input name="txtUserName" type="text" class="loginText" tabindex="1">
		
		driver.findElement(By.xpath("//input[@class = 'loginText' and @name = 'txtUserName']")).sendKeys(username);
		
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		
		driver.findElement(By.xpath("//input[@class='loginText' and @name = 'txtPassword']")).sendKeys(password);
		
		// <input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		
		driver.findElement(By.xpath("//input[@value = 'Login' and @name = 'Submit']")).click();
		
		// <ul id="option-menu">
	    
		
		String welcome_admin = driver.findElement(By.id("option-menu")).getText();
		String expected_result = "Welcome admin";
		if(welcome_admin.contains(expected_result))
		{
			System.out.println("successfully logged in - PASS");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
		}
		else
		{
			System.out.println("failed to loggedin - FAIL");
		}
		
		
			
		
		
		// <a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		
				driver.findElement(By.linkText("Logout")).click();
				driver.quit();



	}

}
