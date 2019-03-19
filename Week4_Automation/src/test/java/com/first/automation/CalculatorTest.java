package com.first.automation;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

	public WebDriver driver;

	@BeforeTest
	public void beforeEachTest() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/browser_drivers/chromedriver.exe");
		// start a browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterEachTestEnd() {
		try {
			Thread.sleep(5 * 1000);
			driver.close();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Testing_Mortgage_Calculate() {
		try {

			driver.get("http://www.mortgagecalculator.org/");
			String browserTitle = driver.getTitle();
			System.out.println("webside title is :'" + browserTitle + "'");
			assertEquals(browserTitle, "Mortgage Calculator");

			WebElement homeValue = driver.findElement(By.id("homeval"));
			homeValue.clear();
			homeValue.sendKeys("250000");
			Thread.sleep(2*1000);
			
			WebElement downYayment = driver.findElement(By.cssSelector("#downpayment"));
			downYayment.clear();
			downYayment.sendKeys("40000");
			Thread.sleep(2*1000);
			
			WebElement interestRate = driver.findElement(By.name("param[interest_rate]"));
			interestRate.clear();
			interestRate.sendKeys("5.2");
			Thread.sleep(2*1000);
			
			WebElement loanTerm = driver.findElement(By.cssSelector("#loanterm")) ;
			loanTerm.clear();
			loanTerm.sendKeys("30");
			Thread.sleep(2*1000);
			
			WebElement startDay = driver.findElement(By.name("param[start_month]"));
			Select startDayDropdown = new Select(startDay);
			startDayDropdown.selectByVisibleText("Jul");
			Thread.sleep(2*1000);
			
			WebElement startYear = driver.findElement(By.id("start_year"));
			startYear.clear();
			startYear.sendKeys("2019");
			Thread.sleep(2*1000);
			
			WebElement loanType = driver.findElement(By.name("param[refiorbuy]"));
			Select loanTypeDropdown = new Select(loanType);
			loanTypeDropdown.selectByValue("1");		
			
			WebElement calculateBtm = driver.findElement(By.className("styled-button"));
			calculateBtm.click();
			Thread.sleep(5*1000);
			
			WebElement value = driver.findElement(By.cssSelector("#calc > form > section > section.content-area > div > div > div.calculation-container > div > div > div.cal-content > div.cal-right-box > div:nth-child(4) > div:nth-child(1) > div.left-cell > h3"));
			String monthlyPayments = value.getAttribute("h3");
			System.out.println("monthly payment is:" + monthlyPayments);
			assertEquals(monthlyPayments, "$1,583.04");
		
			
			
        
		} catch (Exception e) {
			e.printStackTrace();} 

		

	}
}
