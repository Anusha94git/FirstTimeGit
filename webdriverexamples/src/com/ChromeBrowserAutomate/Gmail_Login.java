package com.ChromeBrowserAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Login {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url = "http://google.com";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
	
		
		driver = new ChromeDriver();
		driver.get(url);
		
		// <a class="gb_Ue gb_Ba gb_Tb" id="gb_70" href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;
		//continue=https://www.google.com/" target="_top">Sign in</a>
	

		driver.findElement(By.linkText("Sign in")).click();
		System.out.println("sign in page is opened");
		
		// <input id="Email" type="email" value="" spellcheck="false" name="Email" placeholder="Email or phone" autofocus="">
		
		 driver.findElement(By.id("Email")).sendKeys("anusha.spring94");
		
		/* <input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0"
		 *  aria-label="Email or phone" name="identifier" autocapitalize="none" id="identifierId" dir="ltr" 
		 *  data-initial-dir="ltr" data-initial-value="">
		 */
		
		//driver.findElement(By.id("identifierId")).sendKeys("anusha.spring94");
		
		
		
		// <input id="next" name="signIn" class="rc-button rc-button-submit" type="submit" value="Next">
		
		driver.findElement(By.id("next")).click();
		
		// <span class="RveJvd snByac">Next</span>
		
	//	driver.findElement(By.xpath("RveJvd snByac")).click();
		
		// <input id="Passwd" name="Passwd" type="password" placeholder="Password" class="">
		
		driver.findElement(By.id("Passwd")).sendKeys("Killers@356");
		
		// <input id="signIn" name="signIn" class="rc-button rc-button-submit" type="submit" value="Sign in">
		
		driver.findElement(By.id("signIn")).click();
		
		String Expected_Title = "Inbox";
		
		String Actual_Title = driver.getTitle();
		
		if(Actual_Title.contains(Expected_Title))
		{
		
			System.out.println("gmail successfully logged in");
		}
		else
		{
			System.out.println("give the correct details to login");
		}
				
		// <span class="gb_cb gbii"></span>
		
		driver.findElement(By.className("gb_cb gbii")).click();
		
		/* <a class="gb_Aa gb_xg gb_Eg gb_ef gb_Tb" id="gb_71" 
		 * href="https://accounts.google.com/Logout?hl=en&amp;continue=https://mail.google.com/mail&amp;
		 * service=mail&amp;timeStmp=1548158913&amp;secTok=.AG5fkS8y0oi1XhdEfKER5_TkWm-YEHluYg" target="_top">Sign out</a>
		 */
		
		driver.findElement(By.linkText("Sign out")).click();
		
		System.out.println("Successfully loggod out");
		
		driver.close();
		
	}

}
