package com.radiobuttons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radiobuttons_example {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://echoecho.com/htmlforms10.htm";
		
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		/*
		 * /html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td
		 */
		
		WebElement radiobuttons_block = driver.findElement(By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td"));
		
		//<input type="radio" name="group1" value="Milk">
		// <input type="radio" name="group1" value="Cheese">
		// <input type="radio" name="group1" value="Butter" checked="">
		
		List<WebElement> radiobuttons = radiobuttons_block.findElements(By.name("group1"));
				
		System.out.println("total radiobuttons are "+radiobuttons.size());
		
		/* <td class="table5"><!-- perl mysql php web host -->


		<br><br><input type="radio" name="group1" value="Milk"> Milk<br>
		<input type="radio" name="group1" value="Butter" checked=""> Butter<br>
		<input type="radio" name="group1" value="Cheese"> Cheese<hr>
		<input type="radio" name="group2" value="Water"> Water<br>
		<input type="radio" name="group2" value="Beer"> Beer<br>
		<input type="radio" name="group2" value="Wine" checked=""> Wine<div align="center"></div><br>
		</td>
		*/

		
		for(int i=0; i<radiobuttons.size();i++)
		{
			radiobuttons.get(i).click();
			
			for(int k = 0;k<radiobuttons.size();k++)
			{
								System.out.println(radiobuttons.get(k).getAttribute("value")+" " +radiobuttons.get(k).getAttribute("checked"));
			}
			System.out.println("************************");
		}
		
		
		
	}

}
