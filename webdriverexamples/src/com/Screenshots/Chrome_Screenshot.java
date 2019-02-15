package com.Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Screenshot {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		WebDriver driver = null;
		String url = "https://my.monsterindia.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		File Screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshots, new  File("F:\\Seleniumworkspace\\webdriverexamples\\Screenshots\\monster.jpg"));
		
		
		driver.close();
		
	}

}
