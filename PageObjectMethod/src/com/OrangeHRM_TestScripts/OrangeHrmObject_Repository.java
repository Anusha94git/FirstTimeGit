package com.OrangeHRM_TestScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHrmObject_Repository
{

		@FindBy(id = "txtUsername")
		WebElement Username;
		
		@FindBy(id = "txtPassword")
		WebElement Password;
		
		@FindBy(id= "btnLogin")
		WebElement Login;
		
		public void login(String Uname, String Pwd)
		{
			Username.clear();
			
			Username.sendKeys(Uname);
			
			Password.clear();
			Password.sendKeys(Pwd);
			Login.click();
		}
		
}
