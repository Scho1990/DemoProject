package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Wikipedia;

public class WikipediaTest extends TestBase {
       Wikipedia wikipedia;
       public WikipediaTest() {
   		super();
   	}
   	
   	@BeforeMethod
   	public void setUp() {
   		initialization();
   		wikipedia=new Wikipedia();
   	}
   	@Test
	public void dropdownTest() {
   		Wikipedia.selectLanguage("en");
   		wikipedia.setSearchData("Cricket");
   		wikipedia.selectSearchSuggestions("Cricket World Cup");
   		wikipedia.scrollUntilTextPresent();
   		//wikipedia.fetchColumnsFromTournamentHistoryTable();
//  		wikipedia.fetchDataFromFirstColumnInTournamentHistoryTable();
//   		wikipedia.fetchDataFromSecondColumnInTournamentHistoryTable();
   		wikipedia.fetchDataFromThirdColumnInTournamentHistoryTable();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	}
