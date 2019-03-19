package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.automation.pages.Base;


public class CalculatorTests extends Base {

	@Test
	public void test1() {
		
		try {

			driver.get("https://www.mortgagecalculator.org/");
			String browserTitle = driver.getTitle();
			System.out.println("webside title is :'" + browserTitle + "'");
			assertEquals(browserTitle, "Mortgage Calculator");
			
            myLibrary.enterTextField(By.id("homeval"), "250000");
			
			myLibrary.enterTextField(By.cssSelector("#downpayment"), "40000");
			
			myLibrary.enterTextField(By.name("param[interest_rate]"), "5.2");
			
			myLibrary.enterTextField(By.cssSelector("#loanterm"), "30");
			
			myLibrary.selectDropDown("2021",By.id("start_year"));
			
			myLibrary.selectDropDown(By.name("param[start_month]"), "Jul");
			
			myLibrary.selectDropDown(By.name("param[refiorbuy]"), 1);
					
			myLibrary.clickButton(By.className("styled-button"));
		
			
			
			WebElement value = driver.findElement(By.cssSelector("#calc > form > section > section.content-area > div > div > div.calculation-container > div > div > div.cal-content > div.cal-right-box > div:nth-child(4) > div:nth-child(1) > div.left-cell > h3"));
			String monthlyPayments = value.getAttribute("value");
			System.out.println("monthly payment is:" + monthlyPayments);
			assertEquals(monthlyPayments, "$1,583.04");
		
			
			
        
		} catch (Exception e) {
			e.printStackTrace();} 

		

	}
}
		
		
		
		
		
	
