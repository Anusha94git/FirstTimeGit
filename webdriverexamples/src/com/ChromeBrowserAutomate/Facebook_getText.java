package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_getText {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://facebook.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		// <div class="_5iyx">Facebook helps you connect and share with the people in your life.</div>
		
		WebElement facebook_text = driver.findElement(By.className("_5iyx"));
		String Actual_text = facebook_text.getText();
		
		System.out.println("Facebook home page text is " +Actual_text);
		driver.close();

	}

}
