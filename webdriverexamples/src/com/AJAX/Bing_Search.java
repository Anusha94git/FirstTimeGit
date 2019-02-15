package com.AJAX;

//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bing_Search {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver=null;
		String url ="http://bing.com";
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*	<input class="b_searchbox" id="sb_form_q" name="q" title="Enter your search term" type="search" value="" maxlength="1000"
		 *  autocapitalize="off" autocorrect="off"  autocomplete="off" spellcheck="false" aria-controls="sw_as" style="" aria-autocomplete="both" aria-owns="sw_as">
		
		
		*/
		
		driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");
		//xpath pf bing list  //*[@id="sa_ul"]
		
		String Search_List_data = driver.findElement(By.xpath("//*[@id=\"sa_ul\"]")).getText();
		System.out.println("the elements related to your search are  "+Search_List_data);
		
			String expected = "Livetech";
			String actual = Search_List_data;
			if(actual.contains(expected))
			{
				System.out.println("Element is found");
			}
			
			else
			{
			System.out.println("Element not found");
		}
driver.quit();		
	}


}