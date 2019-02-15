package com.MouseHover_Operations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Jquery_DragandDrop_Operation {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = null;
		String URL = "http://jqueryui.com/droppable";
		
		System.setProperty("webdriver.chrome.driver", "F:\\Seleniumworkspace\\webdriverexamples\\driverFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* <iframe src="/resources/demos/droppable/default.html" class="demo-frame"></iframe>*/
		
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		/* <div id="draggable" class="ui-widget-content ui-draggable ui-draggable-handle" style="position: relative;">
		<p>Drag me to my target</p>
		</div>
		*/
	
		WebElement Drag_Element = driver.findElement(By.id("draggable"));
		
		// <div id="droppable" class="ui-widget-header ui-droppable"> 	<p>Drop here</p>
//		</div>
		
		
		WebElement DropHere_Element = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(Drag_Element, DropHere_Element).build().perform();
		
		
		
	}

}
