package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;


import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm"
							+ "\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\chromedriver.exe");
			if (prop.getProperty("headless").equalsIgnoreCase("yes")) {
				// headless mode:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			} else {
				if (prop.getProperty("disableImage").equalsIgnoreCase("yes")) {
					ChromeOptions options = new ChromeOptions();
					disableImageChrome(options);
					driver = new ChromeDriver(options);
				} else {
					driver = new ChromeDriver();
				}
			}
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\geckodriver.exe");
			if (prop.getProperty("headless").equalsIgnoreCase("yes")) {
				// headless mode:
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
			} else {
				if (prop.getProperty("disableImage").equalsIgnoreCase("yes")) {
					FirefoxOptions options = new FirefoxOptions();
					disableImageFirefox(options);
					driver = new FirefoxDriver(options);
				} else {
					driver = new FirefoxDriver();
				}
			}
		} 
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if (browserName.equals("phantomjs")) {
			System.setProperty("webdriver.edge.driver",
					"\\Users\\santo\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\phantomjs.exe");
			driver = new PhantomJSDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("appUrl"));

	}

	private static void disableImageChrome(ChromeOptions options) {
		HashMap<String, Object> images = new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);
		options.setExperimentalOption("prefs", prefs);
	}

	private static void disableImageFirefox(FirefoxOptions options) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options.setProfile(profile);
		options.setCapability(FirefoxDriver.PROFILE, profile);
	}

}
