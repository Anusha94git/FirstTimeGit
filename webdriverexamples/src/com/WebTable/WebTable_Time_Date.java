package com.WebTable;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Time_Date {

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
		
		///html/body/div[1]/div[6]/section[1]/div/section/div[1]  - table absolute xpath
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1] - 1st row 1st column xpath
		
		//To print 1st row 1st column 1st element name
		
		String FirstColumn_FirstRow_Name = driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]")).getText();
		
		System.out.println(FirstColumn_FirstRow_Name);
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1] - last row 1st column xpath
		
		
		
		// 1 approach
		for(int i=1;i<=36;i++)
		{
			String Data= driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td[1]")).getText();
			System.out.println(Data);
		}

		
		//2nd approach
		
		String Part1 = "/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String Part2 = "]/td[1]";
		
		for(int i=1;i<=36;i++)
		{
			String data = driver.findElement(By.xpath(Part1+i+Part2)).getText();
			System.out.println("2nd approach is " +data);
		}
		
		
		
	}

}
