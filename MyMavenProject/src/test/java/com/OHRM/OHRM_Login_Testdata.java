package com.OHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRM_Login_Testdata 
{
	//creating object for logger class
	public static Logger logger=Logger.getLogger("OHRM_Log4j");
			
	WebDriver driver = null;
	String url = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	//String username = "roott";
	//String password = "Livetech7.30";
	
	@BeforeTest
	public void browserLaunch()
	{
		//Configuring logger properties file
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver","F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\driverFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get(url);
		logger.info("browser successfully opened");
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void Login() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("F:\\Seleniumworkspace\\MyMavenProject\\Excel_sheets\\Orangehrm_TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int Row_size = sheet.getLastRowNum();
		logger.info("Row size is " +Row_size);
		
		for(int i=1;i<=Row_size;i++)
		{	
			logger.info("***********"+i+"th iteration" +"**************** ");
			Row r = sheet.getRow(i);
		
		
		driver.findElement(By.id("txtUsername")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.id("txtPassword")).sendKeys(r.getCell(1).getStringCellValue());
	
		driver.findElement(By.id("btnLogin")).click();
		
		
	 
	//<span id="spanMessage">Invalid credentials</span>
	//<span id="spanMessage">Csrf token validation failed</span>
	try
	{	
		 String expected_result ="Welcome Admin";
			
			String actual_result = driver.findElement(By.id("welcome")).getText();
		
			logger.info("Expected result is : "+expected_result);
		logger.info("Actual result is : " +actual_result);
		
		if(actual_result.equals(expected_result))
		{
			logger.info("if success");
			logger.info("logged successfully - PASS");
			r.createCell(2).setCellValue("logged successfully - PASS");		
									
		}
	}
		catch(Exception e)
		{
			if(driver.findElement(By.id("spanMessage")).getText().equals("Invalid credentials")||driver.findElement(By.id("spanMessage")).getText().equals("Csrf token validation failed"))
			{
				File Orange_Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
				
				
				FileUtils.copyFile(Orange_Screenshot, new File("F:\\Seleniumworkspace\\OrangeHrmLatest_Version\\Screenshots\\loginfailed("+i+").png"));
				
				Thread.sleep(5000);
				logger.info("***********************");
				logger.info("failed to login - FAIL");
				r.createCell(2).setCellValue("failed to login - FAIL");
				
			
			}
		
		}
		
	
			
		FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\MyMavenProject\\Excel_sheets\\Orangehrm_TestData_Result.xlsx");
		workbook.write(file1);
		
		driver.navigate().back();
		}
	}
	
	
	
	@AfterTest
	public void browserClose()
	{
		driver.close();
	}

}