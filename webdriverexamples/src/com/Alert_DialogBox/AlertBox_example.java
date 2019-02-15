package com.Alert_DialogBox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox_example {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://apsrtconline.in";
		
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* 
		 * <input type="button" name="searchBtn" id="searchBtn" class="chkavailabilityBtn" value="Check Availability" 
		 * title="Search" onclick="validateBookingSearch(this.form, '/oprs-web/avail/services.do');">
		 */
		
		 driver.findElement(By.id("searchBtn")).click();
		 
		 Alert alt = driver.switchTo().alert();
		 
		 //To get the text on alert box
		 String Alert_Text = alt.getText();
		 System.out.println("The text on alert box is : " +Alert_Text);
		 
		 alt.accept();

	}

}
