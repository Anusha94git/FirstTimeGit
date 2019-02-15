package com.DropDown_Operations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Register_Country {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://newtours.demoaut.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
		
		//<a href="mercuryregister.php?osCsid=e1e6bcfb6e950418f4f3b181afdff4f2">REGISTER</a>
		driver.findElement(By.linkText("REGISTER")).click();
		
		// <select name="country" size="1">
		
	WebElement Country	= driver.findElement(By.name("country"));
	
	List<WebElement>Countries = Country.findElements(By.tagName("option"));
	
	int Countries_count = Countries.size();
	System.out.println("The total number of values in drop down are " +Countries_count);
	
	for(int k=0;k<Countries_count;k++)
	{
		System.out.println(Countries.get(k).getText());
		
		Countries.get(k).click();
		if(Countries.get(k).isSelected())
		{
			System.out.println("element is active");
		}
		else
		{
			System.out.println("element is inactive");
		}
	}

		

	}

}
