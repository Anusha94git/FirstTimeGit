package com.MouseHover_Operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_HelloSignIn_MouseHover {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		WebDriver driver = null;
		String url = "http://amazon.in";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		/* <a href="https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&amp;
		 * openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.assoc_handle=inflex&amp;
		 * openid.mode=checkid_setup&amp;openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;
		 * openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&amp;&amp;openid.pape.max_auth_age=0" 
		 * class="nav-a nav-a-2" data-nav-ref="nav_ya_signin" data-nav-role="signin" data-ux-jq-mouseenter="true" 
		 * id="nav-link-yourAccount" tabindex="25">
		  <span class="nav-line-1">Hello, Sign in</span>
		  <span class="nav-line-2">Your Orders<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
		  </span>
		  <span class="nav-line-3">Sign in</span>
		  <span class="nav-line-4">Your Orders</span>
		</a>
		*/
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//<span class="nav-line-2">Your Orders<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
		  /*<a href="https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&amp;
		   * openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.assoc_handle=inflex&amp;
		   * openid.mode=checkid_setup&amp;openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;
		   * openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&amp;&amp;openid.pape.max_auth_age=0" class="nav-a nav-a-2" 
		   * data-nav-ref="nav_ya_signin" data-nav-role="signin" data-ux-jq-mouseenter="true" id="nav-link-yourAccount" tabindex="25">
  <span class="nav-line-1">Hello, Sign in</span>
  <span class="nav-line-2">Your Orders<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
  </span>
  <span class="nav-line-3">Sign in</span>
  <span class="nav-line-4">Your Orders</span>
</a>
		   * 
		   */
		
		WebElement Hello_SignIn= driver.findElement(By.id("nav-link-yourAccount"));
		Actions act = new Actions(driver);
		act.moveToElement(Hello_SignIn).build().perform();
		
		/*<a href="https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&amp;openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.assoc_handle=inflex&amp;openid.mode=checkid_setup&amp;openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&amp;&amp;openid.pape.max_auth_age=0" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin" data-nav-role="signin" data-ux-jq-mouseenter="true" id="nav-link-yourAccount" tabindex="25">
		  <span class="nav-line-1">Hello, Sign in</span>
		  <span class="nav-line-2">Your Orders<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
		  </span>
		  <span class="nav-line-3">Sign in</span>
		  <span class="nav-line-4">Your Orders</span>
		</a>
		*/
		
		//<span class="nav-text">Your Wish List</span>
		
		driver.findElement(By.linkText("Your Wish List")).click();
		
		
		
		
		driver.quit();
				
		
	}

}
