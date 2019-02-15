package com.LinksCount;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class APSRTC_HeaderBlock_TestingLinks {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://apsrtconline.in/oprs-web/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(url);
	WebElement HeaderBlock = driver.findElement(By.className("menu-wrap"));
	List<WebElement> HeaderBlock_Links = HeaderBlock.findElements(By.tagName("a"));

	int HeaderBlock_Links_Count = HeaderBlock_Links.size();
	System.out.println("The links in Header Block : " +HeaderBlock_Links_Count);
	
	for(int k=0;k<HeaderBlock_Links_Count;k++)
	{
		String HeaderBlock_Links_Text = HeaderBlock_Links.get(k).getText();
		System.out.println("index : " +k +" Link Name is " +HeaderBlock_Links_Text);
		
		HeaderBlock_Links.get(k).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println();
		
		driver.navigate().back();
		 HeaderBlock = driver.findElement(By.className("menu-wrap"));
		HeaderBlock_Links = HeaderBlock.findElements(By.tagName("a"));
		
		
	}


	}

}
