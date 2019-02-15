package com.NewToursLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeMercuryTours 
{
	
	
	/*********************Menu Bar******************/
	
	 // <a href="mercurysignon.php">SIGN-ON</a>
	// <a href="mercuryregister.php">REGISTER</a>
	// <a href="mercuryunderconst.php">SUPPORT</a>
	// <a href="mercuryunderconst.php">CONTACT</a>
	
	
	@FindBy(linkText = "SIGN-ON")
	WebElement Signon;
	
	public void signon()
	{
		Signon.click();
	}
	
	
	@FindBy(linkText = "REGISTER")
	WebElement Register;
	
	public void register()
	{
		Register.click();
	}
	
	@FindBy(linkText = "SUPPORT")
	WebElement Support;
	
	public void support()
	{
		Support.click();
	}
	
	
	@FindBy(linkText = "CONTACT")
	WebElement Contact;
	
	public void contact()
	{
		Contact.click();
	}
	
	
	
	/**********************Loign*******************/
	
	
	// <input type="text" name="userName" size="10">
	// <input type="password" name="password" size="10">
	// <input type="image" name="login" value="Login" src="/images/btn_signin.gif" width="58" height="17" alt="Sign-In" border="0">
	
	
	@FindBy(name ="userName")
	WebElement Username;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(name = "login")
	WebElement Login;
	
	
	public void login(String Uname, String Pwd)
	{
		Username.clear();
		Username.sendKeys(Uname);
		
		Password.clear();
		Password.sendKeys(Pwd);
		
		Login.click();
	}
	
	
	/******************Side Links***************/
	
	//<a href="mercurywelcome.php">Home</a>
	//<a href="mercuryreservation.php">Flights</a>
	//<a href="mercuryunderconst.php">Hotels<a href="mercuryreservation.php">Flights</a></a>
	//<a href="mercuryunderconst.php">Car Rentals</a>
	//<a href="mercurycruise.php">Cruises</a>
	//<a href="mercuryunderconst.php">Destinations</a>
	//<a href="mercuryunderconst.php">Vacations</a>
	
	
	@FindBy(linkText = "Home")
	WebElement Home;
	
	public void home()
	{
		Home.click();
	}
	
	
	
	@FindBy(linkText = "Flights")
	WebElement Flights;
	
	public void flights()
	{
		Flights.click();
	}
	
	
	@FindBy(linkText = "Hotels")
	WebElement Hotels;
	
	public void hotels()
	{
		Hotels.click();
	}
	
	
	@FindBy(linkText = "Car Rentals")
	WebElement Car_Rentals;
	
	public void CarRentals()
	{
		Car_Rentals.click();
	}
	
	@FindBy(linkText = "Cruises")
	WebElement Cruises;
	
	public void cruises()
	{
		Cruises.click();
	}
	
	
	@FindBy(linkText = "Destinations")
	WebElement Destinations;
	
	public void destinations()
	{
		Destinations.click();
	}
	
	
	@FindBy(linkText = "Vacations")
	WebElement Vacations;
	
	public void vacations()
	{
		Vacations.click();
	}
	
	/**************Destinations*************/
	//<a href="mercuryunderconst.php">your destination</a>
	
	@FindBy(linkText = "your destination")
	WebElement your_destination;
	
	public void yourdestination()
	{
		your_destination.click();
	}
	
	/*******************Vacations****************/
	
	//<a href="mercuryunderconst.php">featured vacation destinations</a>
	
	@FindBy(linkText = "featured vacation destinations")
	WebElement featured_vacation;
	
	public void featuredvacation()
	{
		featured_vacation.click();
	}
	
	
	/****************Register*********************/
	//<a href="mercuryregister.php">Register here</a>
	
	@FindBy(linkText = "Register here")
	WebElement Register_here;
	
	public void Registerhere()
	{
		Register_here.click();
	}
	
	
	
	
	/***************About us*****************/
	/*	// <a href="http://businesstravel.about.com/mbody.htm?PM=78_101_T&amp;cob=home">Business Travel @ About.com</a>
	
	@FindBy(linkText = "Business Travel @ About.com")
	WebElement Business_Travel;
	
	public void BusinessTravel()
	{
		Business_Travel.click();
	}
*/


}
