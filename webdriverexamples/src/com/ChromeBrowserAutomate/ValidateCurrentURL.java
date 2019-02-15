package com.ChromeBrowserAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateCurrentURL {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver= null;
		String URL = "http://facebook.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(URL);
		
		String expected_result = "facebook.com";
		System.out.println("Expected Result is : "+expected_result);
		
		String actual_result = driver.getCurrentUrl();
		System.out.println("Actual Result is :" +actual_result);
		
		if(actual_result.equals(expected_result))
		{
			System.out.println("matched - PASS");
		}
		else if (actual_result.contains(expected_result))
		{
			System.out.println("contains expected result - PASS");
		}
		else
		{
			System.out.println("mismatches - FAIL");
		}
			
		

	}

}
