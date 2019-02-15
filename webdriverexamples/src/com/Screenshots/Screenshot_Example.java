package com.Screenshots;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;


public class Screenshot_Example {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://gmail.com";
		
		System.setProperty("webdriver.gecko.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		
		File Bing_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		
	
		
		FileUtils.copyFile(Bing_Screenshot, new File("F:\\Seleniumworkspace\\webdriverexamples\\Screenshots\\gmail.jpg"));
		
		
				//FileUtils.copyFile(Bing_Screenshot, new File("./Screenshots/bing.png"));
				
	}

}
