package com.ChromeBrowserAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTitle {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		String url="http://gmail.com";
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		String expected_title = "facebook";
		System.out.println("expected title is : "+expected_title);
		
		String actual_title = driver.getTitle();
		System.out.println("Actual title is : "+actual_title);
		
		
		if(actual_title.equals(expected_title))
		{
			System.out.println("title mached - PASS");
		}
		else
		{
			System.out.println("title mismatched - FAIL");
		}
		
		
		

	}

}
