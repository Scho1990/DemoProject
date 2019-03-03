package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestionsSearch {
	
	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/sql/sql_and_or.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		//*[@id="main"]/div[6]/table/tbody/tr[1]/th[1]
		//*[@id='main']/div[6]/table/tbody/tr[1]/th[7]
	   List<WebElement> colElements = driver.findElements(By.xpath("//*[@id='main']/div[6]/table/tbody/tr[1]/th"));
	   int colCounts=colElements.size();
	   System.out.println("No of Columns present in web table :::::   "+colCounts);
	   String colBeforeXpath="//*[@id='main']/div[6]/table/tbody/tr[1]/th[";
	   String colAfterXpath="]";
	   for(int i=1;i<=colCounts;i++) {
		  WebElement actualXpath = driver.findElement(By.xpath(colBeforeXpath+i+colAfterXpath));
		  System.out.println("Name of the columns in web table :::  "+actualXpath.getText());
		  if(actualXpath.getText().equals("CustomerID")&&actualXpath.getText().equals("CustomerName")&&actualXpath.getText().equals("ContactName")
				  &&actualXpath.getText().equals("Address")&&actualXpath.getText().equals("City")&&actualXpath.getText().equals("PostalCode")&&actualXpath.getText().equals("Country")) {
			  
			  System.out.println("Test Case Pass");
			  break;
		  }
	   }
		driver.quit();
	}

}
