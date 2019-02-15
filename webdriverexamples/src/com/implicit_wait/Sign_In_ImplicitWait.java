package com.implicit_wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Sign_In_ImplicitWait {

	public static void main(String[] args) throws InterruptedException 
	
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		//Thread.sleep(10000);
		
		// Sleeper.sleepTightInSeconds();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.partialLinkText("Sign")).click();
		
		
	}

}
