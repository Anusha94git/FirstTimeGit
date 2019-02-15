package com.getAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute_example {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://newtours.demoaut.com";
		
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// <a href="mercuryregister.php?osCsid=701a59fe370cdabe8c30b3a0b6591f1f">REGISTER</a>
		
		WebElement Register_element = driver.findElement(By.linkText("REGISTER"));
		String expected_result = Register_element.getAttribute("href");
		Register_element.click();
		System.out.println("expected result is : " +expected_result);
		
		String Actual_Result = driver.getCurrentUrl();
		if(Actual_Result.equals(expected_result))
		{
			System.out.println("Register page is opened successfully - PASS");
		}
		else
		{
			System.out.println("Register Page doesnot opened - FAIL");
		}
		
		
	}

}
