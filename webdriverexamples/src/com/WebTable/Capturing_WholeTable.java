package com.WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capturing_WholeTable {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "https://timeanddate.com/worldclock/";
		
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]
		
		WebElement table = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]"));
	List<WebElement> rows	= table.findElements(By.tagName("tr"));
	
	for(int i=0;i<rows.size();i++)
	{
		List<WebElement>cols = rows.get(i).findElements(By.tagName("td"));
		for(int k=0;k<cols.size();k++)
		{
			String data = cols.get(k).getText();
			System.out.print(data + " ");
		}
		System.out.println();
	}

	}

}
