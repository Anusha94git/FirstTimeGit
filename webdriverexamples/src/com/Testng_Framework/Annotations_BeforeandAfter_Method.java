package com.Testng_Framework;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_BeforeandAfter_Method 
{
	@BeforeMethod
	public void applicationLaunch()
	{
		System.out.println("Firefox browser Launch and navigate to Gmail application");
	}
	
	@Test(priority=1)
	public void inbox()
	{
		System.out.println("Testng inbox Functionality");
	}
	
	
	@Test(priority=2)
	public void ComposeMail()
	{
		System.out.println("Testng compose Mail Functionality");
	}
	
	
	@AfterMethod
	public void applicationclose()
	{
		System.out.println("Firefox browser close");
	}
	


}
