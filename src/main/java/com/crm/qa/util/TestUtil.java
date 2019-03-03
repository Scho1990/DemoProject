package com.crm.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static  void dropDownSelection(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}
	
	public static  void scrollIntoView(WebElement element) {
		// Create instance of Javascript executor
		JavascriptExecutor je = (JavascriptExecutor)driver;
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
	}
	
	public void actionsmethod(WebDriver element) {
		Actions action =new Actions(element);
	}

}
