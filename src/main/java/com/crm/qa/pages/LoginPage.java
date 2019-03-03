package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
 //Page Factory-Object Repo
	
	@FindBy(name="username")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_login;
	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//*[@id='hd1TopNav']/a[2]")
	WebElement menu;
	
	//Initializing my web elements using Page Factory
	
	public LoginPage() {
		PageFactory.initElements(driver,this); //this keyword will initialize all the current webelements in the LoginPage class with the driver
	}
	
	//Actions: On the current login page
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) {
		txt_username.clear();
		txt_username.sendKeys(uname);
		txt_password.clear();
		txt_password.sendKeys(pwd);
		btn_login.click();
		return new HomePage();
	}
	
	public void clickOnMenu() {
	     menu.click();
	     driver.findElement(By.xpath("//*[@id='sn-wrapper']/main/div[2]/div[1]/ul/li[1]/a")).click();
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     WebElement ele = driver.findElement(By.xpath("//*[@id='sort-by-wrapper']/select"));
	     Select select =new Select(ele);
	     select.selectByVisibleText("Price High - Low");
	    List<WebElement> pricelist = driver.findElements(By.xpath("//*[starts-with(@id,'product-tile')]/a/div[2]/div[1]/div/div[1]"));
	    List<String> originalList = new ArrayList();
	    List<String> tempList = new ArrayList();
	    for(int i=1;i<=pricelist.size();i++) {
	    	System.out.println(pricelist.get(i).getText());
	    	originalList.add(pricelist.get(i).getText());
	    	tempList.add(pricelist.get(i).getText());
	    }
	    
	    Collections.sort(originalList);
	}
}
