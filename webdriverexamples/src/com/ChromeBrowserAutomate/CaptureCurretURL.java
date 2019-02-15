package com.ChromeBrowserAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureCurretURL {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		
		String URL = "http://facebook.com";
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get(URL);
		
		String Current_URL = driver.getCurrentUrl();
		System.out.println("The Current URL is : " +Current_URL);
		
				
				
		

	}

}
