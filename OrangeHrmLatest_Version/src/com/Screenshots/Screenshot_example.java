package com.Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot_example
{

	@Test
	public void setup() throws IOException
	{
	WebDriver driver = null;
	String url = "https://my.monsterindia.com/";
	
	System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	
	File Screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(Screenshots, new  File("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Screenshots\\monster.jpg"));
	
	
	//driver.close();
	}
	
}

