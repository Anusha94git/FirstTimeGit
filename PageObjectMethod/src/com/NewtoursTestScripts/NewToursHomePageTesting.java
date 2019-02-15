package com.NewtoursTestScripts;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.NewToursLibrary.WelcomeMercuryTours;

public class NewToursHomePageTesting extends BaseTest
{
	@Test
	public void homepageTesting() throws IOException, InterruptedException
	{
		//Creating object for Object Repository class
		WelcomeMercuryTours wmt = PageFactory.initElements(driver, WelcomeMercuryTours.class);   
		
		wmt.signon();
		System.out.println("Performed click on Sign on Element");
		
		driver.navigate().back();
		
		wmt.register();
		System.out.println("Performed click on Register Element");
		
		driver.navigate().back();
		
		wmt.support();
		System.out.println("Performed click on Support Element");
		
		driver.navigate().back();
		
		
		wmt.contact();
		System.out.println("Performed Click on Contact");
		
		driver.navigate().back();
		
		
		FileInputStream File = new FileInputStream("F:\\Seleniumworkspace\\PageObjectMethod\\Excel Sheets\\Newtours_Login_Testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int row_count = sheet.getLastRowNum();
		
		for(int i=1;i<=row_count;i++)
		{
			Row r = sheet.getRow(i);
			
			wmt.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
			
			System.out.println("performed Login operation");
			
			String Expected ="Find";
			String Actual = driver.getTitle();
			
			if(Actual.contains(Expected))
			{
				System.out.println("Login Successful - PASS");
				r.createCell(2).setCellValue("Login Successful - PASS");
				
			}
			else
			{
				System.out.println("Login Failed - FAIL");
				r.createCell(2).setCellValue("Login Failed - FAIL");
				
			}
			
			System.out.println();
			
			FileOutputStream file1 = new FileOutputStream("F:\\Seleniumworkspace\\PageObjectMethod\\src\\com\\ApplicationTestResultFiles/Newtours_Login_Testdata_Result.xlsx");
			workbook.write(file1);
			driver.navigate().back();
			
		}
		
			wmt.home();
			System.out.println("Performed Click on Home");
			
			
			wmt.flights();
			System.out.println("Performed Click on Flights ");
			
			driver.navigate().back();
			
			wmt.hotels();
			System.out.println("Performed Click on Hotels");
			
			driver.navigate().back();
			
			
			wmt.CarRentals();
			System.out.println("Performed Click on CarRentals");
			
			driver.navigate().back();
			
			wmt.cruises();
			System.out.println("Performed Click on Cruises");
			
			driver.navigate().back();
			
			wmt.destinations();
			System.out.println("Performed Click on Destinations");
			
			driver.navigate().back();
			
			
			wmt.vacations();
			System.out.println("Performed Click on Vacations");
			
			driver.navigate().back();
			
			wmt.yourdestination();
			System.out.println("Performed Click on Your Destinations");
			
			driver.navigate().back();
			
			
			wmt.featuredvacation();
			System.out.println("Performed Click on FeaturedVacation");
			
			driver.navigate().back();
			
			
			wmt.Registerhere();
			System.out.println("Performed Click on Registerhere");
			driver.navigate().back();
			
			/*wmt.BusinessTravel();
			System.out.println("Performed Click on Business Travel");
			// Thread.sleep(1000);
			driver.navigate().back();
			*/
			
			
		}
		
		
		
		
	}
	
	


