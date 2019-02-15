package com.Testng_Framework;

import org.testng.annotations.Test;

public class Annotation_Test 
{
	

	@Test(priority=0)
	public void browserLaunch()
	{
		System.out.println("Firefox browser Launch");
	}
	
	@Test(priority=1)
	public void Login()
	{
		System.out.println("Testng Login functionality");
	}
	
	@Test(priority=2)
	public void inbox()
	{
		System.out.println("Testing inbox functionality");
	}
	
	@Test(priority=3)
	public void composeMail()
	{
		System.out.println("Compose Mail functionality");
	}

}
