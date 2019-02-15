package com.AutoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoIT_To_Download 
{

	WebDriver driver = null;
	String url = "https://www.seleniumhq.org/download/";
	String username = "roott";
	String password = "Livetech7.30";

	
	@BeforeTest
	public void Setup()
	{
		String browser = "Chrome";
		if(browser.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
		
	@Test(priority = 0)
	public void downloadlink() throws IOException
	{
		//<a href="https://bit.ly/2TlkRyu">3.141.59</a>
		// //*[@id="mainContent"]/p[3]/a
		
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/p[3]/a")).click();
		java.lang.Runtime.getRuntime().exec("");
	}
}
