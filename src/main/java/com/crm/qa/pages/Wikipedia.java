package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class Wikipedia extends TestBase{
	//Page Factory-Object Repo
	
		@FindBy(id="searchInput")
		WebElement txt_SearchBox;
		
		@FindBy(id="searchLanguage")
		static WebElement dd_language;
		
		@FindBy(id="Tournament_history")
		WebElement text_Tournament_History;
		
		@FindBy(xpath="//font[contains(text(),'Sign Up')]")
		WebElement signUp;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		//Initializing my web elements using Page Factory
		
		public Wikipedia() {
			PageFactory.initElements(driver,this); //this keyword will initialize all the current webelements in the LoginPage class with the driver
		}
		
		public static void selectLanguage(String value) {
			TestUtil.dropDownSelection(dd_language,value);
		}
		
		public void setSearchData(String inputText) {
			txt_SearchBox.clear();
			txt_SearchBox.sendKeys(inputText);
		}
		
		//*[@id="typeahead-suggestions"]/div/a[6]/div[1]/h3/em
		//*[@id="typeahead-suggestions"]/div/a[5]/div[1]/h3/em
		//*[@id="typeahead-suggestions"]/div/a[3]/div[1]/h3/text()
		//*[@id="typeahead-suggestions"]/div/a[2]/descendant :: h3[contains(text(),'Cricket World Cup awards')]
		
		public void selectSearchSuggestions(String inputText) {
			List<WebElement> list = driver.findElements(By.xpath("//*[@id='typeahead-suggestions']/div/a"));
			try {
				for(int i=0;i<=list.size()-1;i++) {
					System.out.println(list.get(i).getText());
					if(list.get(i).getText().contains(inputText)) {
						list.get(i).click();
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void scrollUntilTextPresent() {
		   TestUtil.scrollIntoView(text_Tournament_History);
		}
		
		public void fetchColumnsFromTournamentHistoryTable() {
			List<WebElement> list = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/table[4]/thead/tr[1]/th"));
			System.out.println("Total Columns :::: "+list.size());
			String colsBeforeXpath="//*[@id='mw-content-text']/div/table[4]/thead/tr[1]/th[";
			String colsAfterXpath="]";
			try {
				for(int i=1;i<=list.size()-1;i++) {
					WebElement colsActualXpath=driver.findElement(By.xpath(colsBeforeXpath+i+colsAfterXpath));
					System.out.println("Total No of Columns ::::::   "   +colsActualXpath.getText());    
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void fetchDataFromFirstColumnInTournamentHistoryTable() {
			List<WebElement> list = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/table[4]/tbody/tr"));
			String rowBeforeXpath="//*[@id='mw-content-text']/div/table[4]/tbody/tr[";
			String rowAfterXpath="]/td[1]";
			System.out.println("No of Rows in a table::::::"+list.size());
			try {
				for(int i=1;i<=list.size();i++) {
					WebElement colsActualXpath=driver.findElement(By.xpath(rowBeforeXpath+i+rowAfterXpath));
					System.out.println("Data From First Column ::::::   "   +colsActualXpath.getText());    
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void fetchDataFromSecondColumnInTournamentHistoryTable() {
			List<WebElement> list = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/table[4]/tbody/tr"));
			String rowBeforeXpath="//*[@id='mw-content-text']/div/table[4]/tbody/tr[";
			String rowAfterXpath="]/td[2]";
			System.out.println("No of Rows in a table::::::"+list.size());
			try {
				for(int i=1;i<=list.size();i++) {
					WebElement colsActualXpath=driver.findElement(By.xpath(rowBeforeXpath+i+rowAfterXpath));
					System.out.println("Data From Second Column ::::::   "   +colsActualXpath.getText());    
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void fetchDataFromThirdColumnInTournamentHistoryTable() {
			List<WebElement> listCols = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/table[4]/tbody/tr[1]/td"));
			System.out.println("Total Columns :::: "+(listCols.size()-3));
			List<WebElement> listRow = driver.findElements(By.xpath("//*[@id='mw-content-text']/div/table[4]/tbody/tr"));
			String rowBeforeXpath="//*[@id='mw-content-text']/div/table[4]/tbody/tr[";
			String rowAfterXpath="]/td[";
			String third_part="]";
			System.out.println("No of Rows in a table::::::"+listRow.size());
			fetchColumnsFromTournamentHistoryTable();
			try {
				for(int i=1;i<=listRow.size();i++) {
					for(int j=1;j<=listCols.size()-3;j++) {
					//WebElement colsActualXpath=driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[4]/tbody/tr["+i+"]/td["+j+"]"));
					String Table_Data=driver.findElement(By.xpath(rowBeforeXpath+i+rowAfterXpath+j+third_part)).getText();
					System.out.print(Table_Data +"                 ");  
				}
					System.out.println("                          ");
					System.out.println("                           ");
				}
			}
			 catch (Exception e) {
				e.printStackTrace();
			}
		}

}
