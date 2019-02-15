package com.GetPageSource;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find_Particular_Element {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://javatpoint.com";
		
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String Page_Source = driver.getPageSource();
		String expected_result = "HTML";
		
		if(Page_Source.contains(expected_result))
		{
			System.out.println("element found - PASS ");
		}
		else
		{
			System.out.println("element not found - FAIL");
		}
		
	}

}
