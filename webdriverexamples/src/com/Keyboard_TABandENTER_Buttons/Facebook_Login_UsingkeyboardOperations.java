package com.Keyboard_TABandENTER_Buttons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Facebook_Login_UsingkeyboardOperations {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://facebook.com";
		String Username = "Anusha";
		String Password = "hello";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// <input type="email" class="inputtext" name="email" id="email" data-testid="royal_email">
		
				driver.findElement(By.id("email")).sendKeys(Username);
				
				
				Actions act = new Actions(driver);
				act.sendKeys(Keys.TAB).perform();
				
				act.sendKeys(Password).perform();
				
				act.sendKeys(Keys.ENTER).perform();
				
				
				
					
					

	}

}
