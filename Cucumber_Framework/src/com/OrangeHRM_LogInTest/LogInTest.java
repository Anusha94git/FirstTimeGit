
package com.OrangeHRM_LogInTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInTest 
{
	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	String username ="roott";
	String password = "Livetech7.3";
	

	@Given("^Open Firefox Browser and navigate to OrangeHRM application$")
	public void Open_Firefox_Browser_and_navigate_to_OrangeHRM_application() throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Seleniumworkspace\\Cucumber_Framework\\driverFiles\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    	}

	@When("^User enters valid userName and Password and click on SignIn button$")
	public void User_enters_valid_userName_and_Password_and_click_on_SignIn_button() throws Throwable
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
	   	}
	

	@Then("^User should be able to successfully login to the application and close$")
	public void User_should_be_able_to_successfully_login_to_the_application_and_close() throws Throwable 
	{
		try
		{
			String expected = "Welcome Admin";
			String Actual = driver.findElement(By.id("welcome")).getText();
			if(Actual.contains(expected))
			{
				System.out.println("successfully loged in - PASS");
			} 
		}
		//<span id="spanMessage">Invalid credentials</span>
		catch(Exception e)
		{
			System.out.println("if fails");
			if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials"))
				{
				
				File Snapshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Snapshot, new File ("F:\\Seleniumworkspace\\Cucumber_Framework\\Screenshots\\img.png"));
				System.out.println("Login Failed - FAIL");
			}
		}
		driver.quit();
	}


}
