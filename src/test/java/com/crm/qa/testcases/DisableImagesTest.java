package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class DisableImagesTest extends TestBase {
	
	LoginPage loginPageObj;
	
	public DisableImagesTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPageObj=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException {
		System.out.println(loginPageObj.validateLoginPageTitle());
		//loginPageObj.clickOnMenu();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
