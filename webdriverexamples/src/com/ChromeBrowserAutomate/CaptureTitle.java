package com.ChromeBrowserAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureTitle {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		
		String Url = "http://gmail.com";
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get(Url);
		
		String title = driver.getTitle();
		System.out.println("The title of web page is : " +title);
		
		driver.close();

	}

}
