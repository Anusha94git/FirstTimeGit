package com.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OHRM_Login_Test
{
	@DataProvider(parallel=true)
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="roott";
		data[0][1]="Livetech7.30";
		data[0][2]="firefox";
		
		data[1][0]="roott";
		data[1][1]="Livetech7.30";
		data[1][2]="chrome";
		
		return data;
		
	}
	
	@Test(dataProvider="getData")
	public void Login(String uname,String pwd,String browser) throws MalformedURLException
	{
		System.out.println("The browser is : "+browser); 
		DesiredCapabilities cap=null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			cap =DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.137.1:4444/wd/hub"),cap);
		
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();

		try
		{
			String expected = "Find";
			String actual = driver.getTitle();
			if(actual.contains(expected))
			{
				System.out.println("Login successful - PASS");
			} 
		}
		
		catch(Exception e)
		{
			System.out.println("if fails");
			System.out.println("Login failed - FAIL");
			
		}
		
		//driver.navigate().back();
		driver.quit();
	 }
		
	}
