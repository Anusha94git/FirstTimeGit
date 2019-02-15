package com.LinksCount;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_HomePage_LinksCount {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://newtours.demoaut.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		int linksize = Links.size();
		
		System.out.println("links in Home page are : " +linksize);
		
		

	}

}
