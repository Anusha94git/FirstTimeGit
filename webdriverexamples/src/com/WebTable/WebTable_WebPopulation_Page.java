package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_WebPopulation_Page {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "http://www.worldometers.info/world-population/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		
		driver.manage().window().maximize();
		
			
		
		
	// 1st row ********* /html/body/div[3]/div[4]/div/div/div[9]/table/thead/tr[1]/th[1]
		
		//1st row 1st column ************* /html/body/div[3]/div[4]/div/div/div[9]/table/thead/tr[2]/td[1]
		
		//2nd row 1st column ***************/html/body/div[3]/div[4]/div/div/div[9]/table/tbody/tr[1]/td[1]
		
		// last row 1st column ************ /html/body/div[3]/div[4]/div/div/div[9]/table/tbody/tr[16]/td[1]
		
		
		WebElement Table = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div"));
		
		
		
		//giving 1st row
		
			String FIRST_ROW = Table.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div[9]/table/thead/tr[1]/th[1]")).getText();
			System.out.println(FIRST_ROW);
			System.out.println("*******************************");
			
			//giving multiple rows of 1st column
		
			String Pt1 = "/html/body/div[3]/div[4]/div/div/div[9]/table/thead/tr[2]/td[1]";
			String Pt2 = "/html/body/div[3]/div[4]/div/div/div[9]/table/thead/tr[2]/td[1]";
			String Pt3 = "/html/body/div[3]/div[4]/div/div/div[9]/table/tbody/tr[";
			String Pt4 = "]/td[1]";
			
			
			List<WebElement> rows = Table.findElements(By.tagName("tr"));
			int rows_count = rows.size();
			
			System.out.println("Number of rows are " +rows_count);
			
			System.out.println(driver.findElement(By.xpath(Pt1)).getText());
			System.out.println(driver.findElement(By.xpath(Pt2)).getText());
			
			
			for(int i=1;i<16;i++)
			{
				String data = driver.findElement(By.xpath(Pt3 + i + Pt4)).getText();
						System.out.println(i+"th row element is" +data);
			}
			
			System.out.println("************************************");
			
			// to print entire table
			// Last row - last column  ------------ /html/body/div[3]/div[4]/div/div/div[9]/table/tbody/tr[16]/td[9]
			
			
			for(int i=0; i<16;i++)
			{
				List<WebElement>cols= rows.get(i).findElements(By.tagName("td"));
				int Cols_Count = cols.size();
				
				System.out.println("number of columns  " +cols);
				
				for(int j=0;j<Cols_Count;j++)
				{
					String entire_data= cols.get(j).getText();
					System.out.print(i +"th row of " + j +"th column is " +entire_data);
				}
				System.out.println();
			}
			
			
			
			

	}

}
