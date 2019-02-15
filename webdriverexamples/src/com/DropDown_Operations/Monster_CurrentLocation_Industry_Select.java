package com.DropDown_Operations;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Monster_CurrentLocation_Industry_Select {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String url = "https://my.monsterindia.com/";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		
		/* <div id="ind" class="dropdown_small_wrapper open_multi_select  industry req" tabindex="9" monstab="undefined" style="width:550px;">            
		 *      	<div class="left" id="ind_value">Industry</div>             
		<div class="right clip_image"></div><div class="clear_both"></div>               </div>
		*/
		
		// <input type="text" style="width:485px;font-size:11px;" value="" id="ind_typeahead" class="input_style" autocomplete="off">
		
		WebElement Industry = driver.findElement(By.id("ind_value"));
		Industry.click();
		
		// <input type="text" style="width:485px;font-size:11px;" value="" id="ind_typeahead" class="input_style" autocomplete="off">
		
		// <div class="left" style="width:87% !important;" title="Any" id="other_ind_65_val">Any</div>
		/* <div class="select_item select_action jq2 traverseKeyboard" data-selid="other_ind_4"
		 *  data-parent="cluster_ind_4" data-check="unchecked" data-ttype="other" data-mainid="ind" data-val1="4"
		 *   style="background-image: none; background-position: 0px 0px; background-size: initial; background-repeat: repeat; 
		 *   background-attachment: scroll; background-origin: initial; background-clip: initial;"><input type="checkbox" value="4" 
		 *   name="industry" style="display:none;"><div class=" check" id="other_ind_4_check" style="float:left;"></div>
		 *   <div class="left" style="width:87% !important;" 
		 * title="Automotive/ Ancillaries" id="other_ind_4_val">Automotive/ Ancillaries</div><div class="clear_left"></div> </div>
		 * */
		 
		
		
		 List<WebElement>Industry_Data = driver.findElements(By.tagName("title"));
		 
		 for(int i=0;i<Industry_Data.size();i++)
		 {
			 System.out.println(Industry_Data.size());
			 System.out.println(Industry_Data.get(i).getText());
		 }
		 
		//driver.close();
		

	}

}
