package com.LinksCount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_HomePage_TestingLinks {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://newtours.demoaut.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		
		String Title = driver.getTitle();
		System.out.println(Title);
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		int Links_Count = Links.size();
		System.out.println("The number of links are " +Links_Count);
		
		for(int k=0;k<Links_Count;k++)
		{
			String Links_Text = Links.get(k).getText();
			
			System.out.println("index " +k +" link Name is " +Links_Text);
			
			Links.get(k).click();
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
		Links = driver.findElements(By.tagName("a"));
			
			
		}
		
		driver.quit();
	}

}
