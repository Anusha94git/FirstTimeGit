package com.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Print_whole_WebTable
{

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
		
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]  - 1st row 1st column
		// /html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[7] - last row last column
		
		String Part1 = "/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr[";
		String Part2 = "]/td[";
		String Part3 = "]";
		
		System.out.println("1st approach");
		for(int i=1; i<=36; i++)
		{
			for(int j=1; j<=8; j++)
			{
				
				String data = driver.findElement(By.xpath(Part1+i+Part2+j+Part3)).getText();
				System.out.print(data + "    ");
			}
			System.out.println();
		}
		
		System.out.println("********************************************");
		
		System.out.println("2nd approach");
			
		for(int i=1; i<=36; i++)
		{
			for(int j=1; j<=8; j++)
			{
		
		System.out.print(driver.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody/tr["+i+"]/td["+j+"]")).getText());
			System.out.print("            ");
			}
			System.out.println();
		}
		

	}
			

}
