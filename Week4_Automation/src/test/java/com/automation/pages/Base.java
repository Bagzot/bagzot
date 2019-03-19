package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.automation.library.GlobalSeleniumLibrary;

public class Base {

	public static WebDriver driver;
	public static GlobalSeleniumLibrary myLibrary;

	@BeforeClass
	public void beforeAllTestStart() {
		myLibrary = new GlobalSeleniumLibrary(driver);
		myLibrary.setDemo(true);
	}

	@AfterClass
	public void afterAllTestCompleted() {

	}

	@BeforeMethod
	public void beforeEachTestStart() {
		driver = myLibrary.startChromeBrowser();
	}

	@AfterMethod
	public void afterEachTestEnd() {
		try {
			Thread.sleep(10 * 1000);

			driver.close(); // close the browser
			driver.quit(); // kills/deletes the driver object

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
