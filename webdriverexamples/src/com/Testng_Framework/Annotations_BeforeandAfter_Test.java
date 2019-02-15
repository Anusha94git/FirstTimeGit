package com.Testng_Framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_BeforeandAfter_Test 
{

	@BeforeTest
	public void applicationLaunch()
	{
		System.out.println("Firefox browser Launch and navigate to Gmail application");
	}
	
	@Test(priority=0)
	public void Login()
	{
		System.out.println("Testng Login Functionality");
	}
	

	@Test(priority=1)
	public void inbox()
	{
		System.out.println("Testng Login Functionality");
	}
	
	
	@Test(enabled=false)
	public void ComposeMail()
	{
		System.out.println("Testng compose Mail Functionality");
	}
	
	
	@AfterTest
	public void applicationclose()
	{
		System.out.println("Firefox browser close");
	}
	
	
}
