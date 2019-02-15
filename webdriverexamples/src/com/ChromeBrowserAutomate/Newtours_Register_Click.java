package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtours_Register_Click {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String Url = "http://newtours.demoaut.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Url);
		
		// <a href="mercuryregister.php?osCsid=8914b0c3ab00fc41c4df3f3bcfa40738">REGISTER</a>
		
		WebElement register = driver.findElement(By.linkText("REGISTER"));
		register.click();
		
		System.out.println("The title of current web page is : "+driver.getTitle());
		
		driver.close();
	}

}
