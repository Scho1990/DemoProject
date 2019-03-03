package com.crm.qa.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class BrokenLinks extends TestBase {
	
	public BrokenLinks() {
		PageFactory.initElements(driver,this); //this keyword will initialize all the current webelements in the LoginPage class with the driver
	}

	public void verifyBrokenLinks() throws MalformedURLException, IOException{
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images-----> "+linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		for(int i=0;i<linksList.size();i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href")!=null && !(linksList.get(i).getAttribute("href").contains("tel"))) {
				activeLinks.add(linksList.get(i));
			}
		}
		
		System.out.println("size of active links and images-----> "+activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++) {
			
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			
			String response=connection.getResponseMessage();
			
			connection.disconnect();
			
			System.out.println(activeLinks.get(j).getAttribute("href")+"-------> "+response);
			
		}
		}
	}