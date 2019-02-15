package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SignIn_Click {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		/* <a class="gb_Ue gb_Ba gb_Tb" id="gb_70" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/" 
		 * target="_top">Sign in</a>
		 */
		
		WebElement signin = driver.findElement(By.linkText("Sign in"));
		signin.click();
		System.out.println("Sign in page is opened");
		System.out.println("The title of Sign In page is : " +driver.getTitle());
		System.out.println("The Url of Current Page is : "+driver.getCurrentUrl());
	}

}
