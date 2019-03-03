package com.crm.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BrokenLinks;


public class BrokenLinksTest extends TestBase {
	
	BrokenLinks brokenLinks;
    public BrokenLinksTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		brokenLinks=new BrokenLinks();
	}
	@Test
	public void validateBrokenLinkTest() throws MalformedURLException, IOException {
		brokenLinks.verifyBrokenLinks();
	}
	
	
	
	@AfterMethod            
	public void tearDown() {
		driver.quit();
	}

}
