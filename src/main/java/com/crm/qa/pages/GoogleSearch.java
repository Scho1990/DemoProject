package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Java");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println("List of Suggestions:::  "+list.size());
		try {
			for(int i=1;i<=list.size();i++) {
				Thread.sleep(1000);
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("javat")) {
				list.get(i).click();
				break;
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
		

	}

}
