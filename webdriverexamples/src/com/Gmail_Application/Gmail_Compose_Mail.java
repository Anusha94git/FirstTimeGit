package com.Gmail_Application;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Compose_Mail {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		String url ="http://google.com";
		String username = "anusha.spring94";
		String password = "Killers@356";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\orangehrmexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* <a class="gb_Ue gb_Ba gb_Tb" id="gb_70" href="https://accounts.google.com/ServiceLogin?hl=en&amp;
		 * passive=true&amp;continue=https://www.google.com/%3Fgws_rd%3Dssl" target="_top">Sign in</a>*/
		
		driver.findElement(By.linkText("Sign in")).click();
		
		// <input id="Email" type="email" value="" spellcheck="false" name="Email" placeholder="Email or phone" autofocus="">
		
		driver.findElement(By.id("Email")).sendKeys(username);
		
		// <input id="next" name="signIn" class="rc-button rc-button-submit" type="submit" value="Next">
		
		driver.findElement(By.id("next")).click();
		
		// <input id="Passwd" name="Passwd" type="password" placeholder="Password" class="">
		
		driver.findElement(By.id("Passwd")).sendKeys(password);
		
		// <input id="signIn" name="signIn" class="rc-button rc-button-submit" type="submit" value="Sign in">
		
		driver.findElement(By.id("signIn")).click();
		
		// <a class="gb_P" data-pid="23" href="https://mail.google.com/mail/?tab=wm">Gmail</a>
		
		driver.findElement(By.linkText("Gmail")).click();
		
		
		/* <a class="gb_b gb_hb gb_R" aria-label="Google Account: Anusha spring  
(anusha.spring94@gmail.com)" href="https://accounts.google.com/SignOutOptions?hl=en&amp;continue=https://mail.google.com/mail&amp
;service=mail" role="button" tabindex="0" aria-expanded="true"><span class="gb_cb gbii"></span></a>
*/
		
		driver.findElement(By.xpath("//a [@class = 'gb_b gb_hb gb_R']")).click();
		

	}

}
