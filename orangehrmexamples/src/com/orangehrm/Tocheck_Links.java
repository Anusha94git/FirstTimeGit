package com.orangehrm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tocheck_Links {
	
	public static void main(String[] args)
	{
		WebDriver driver = null;
		String url ="http://localhost/orangehrm";
		String username = "admin";
		String password = "admin";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\orangehrmexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		// <input name="txtUserName" type="text" class="loginText" tabindex="1">
		
		driver.findElement(By.name("txtUserName")).sendKeys(username);
		
		//<input name="txtPassword" type="password" class="loginText" tabindex="2">
		
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		
		// <input type="Submit" name="Submit" value="Login" class="button" tabindex="3">
		
		driver.findElement(By.name("Submit")).click();
		
		// <ul id="option-menu">
	    
		
		String welcome_admin = driver.findElement(By.id("option-menu")).getText();
		String expected_result = "Welcome admin";
		if(welcome_admin.contains(expected_result))
		{
			System.out.println("successfully logged in - PASS");
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			
		}
		else
		{
			System.out.println("failed to loggedin - FAIL");
		}
		
		
	List<WebElement> links = driver.findElements(By.tagName("a"));
	int links_count = links.size();
	System.out.println("number of links in orange hrm page are " +links_count);
	
	for(int k=0;k<links_count;k++)
	{
		if(links.get(k).isDisplayed())
		{
		String Link_Text = links.get(k).getText();
		System.out.println("index " +k +" " +"Link Name is : " +Link_Text);
		if(k==1)
		{
			continue;
		}
		
		links.get(k).click();
		
		driver.navigate().back();
		links = driver.findElements(By.tagName("a"));
		
	
		}
		
	}	
		
		// <a href="./index.php?ACT=logout" target="rightMenu">Logout</a>
		
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();

	}

}
