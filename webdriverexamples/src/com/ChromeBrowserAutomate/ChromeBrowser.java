package com.ChromeBrowserAutomate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		WebDriver driver=null;
		
		String URL ="http://gmail.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		
					
		driver = new ChromeDriver();
		
		driver.get(URL);
		
		System.out.println("Url is : "+URL);
		
	//	driver.quit();
		
		
	}

}
