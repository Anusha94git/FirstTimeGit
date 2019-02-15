package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_SigninClick {

	public static void main(String[] args) 
	
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
	
		
		driver = new ChromeDriver();
		driver.get(url);
		

		/* <a class="gb_Ue gb_Ba gb_Tb" id="gb_70" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
		  continue=https://www.google.com/" target="_top">Sign in</a>
		 */
		
		
		//driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.partialLinkText("Sign")).click();
		driver.close();

	}
}
