package PageObjectsC;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import TestData.ExcelUtils;

public class BookingPage {
	
	WebDriver driver = null;
	
	public BookingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@FindBy(name = "tripType")
	List<WebElement> tType;
	
	@FindBy(name = "passCount")
	WebElement nPass;
	
	@FindBy(name = "fromPort")
	WebElement fCity;
	
	@FindBy(name = "fromMonth")
	WebElement fMonth;
	
	@FindBy(name = "fromDay")
	WebElement fDay;
	
	@FindBy(name = "toPort")
	WebElement tCity;
	
	@FindBy(name = "toMonth")
	WebElement tMonth;
	
	@FindBy(name = "toDay")
	WebElement tDay;

	@FindBy(name = "servClass")
	List<WebElement> sClass;
	
	@FindBy(name = "airline")
	WebElement aLine;
	
	@FindBy(name = "findFlights")
	WebElement cButton;
	
	
	public void FillFlightDetails() throws Exception
	{
		if(ExcelUtils.getCellData(2, 1).contains("One"))
			tType.get(1).click();
		else
			tType.get(0).click();
		
		Select pCount = new Select(nPass);
		pCount.selectByValue("2");
		
		Select fromC = new Select(fCity);
		fromC.selectByValue(ExcelUtils.getCellData(2, 2));
		
		//Select By Index
		/*Select fromM = new Select(fMonth);
		fromM.selectByIndex(3);*/
		
		//Select By Value
		/*Select fromM = new Select(fMonth);
		 fromM.selectByValue("March");*/
		
		 //By JavaScriptExecutor
		((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", fMonth, "March");
		
		Select fromD = new Select(fDay);
		fromD.selectByIndex(6);;
		
		Select toC = new Select(tCity);
		toC.selectByValue(ExcelUtils.getCellData(2, 3));
		
		Select toM = new Select(tMonth);
		toM.selectByIndex(4);
		
		Select toD = new Select(tDay);
		toD.selectByIndex(7);
		
		Reporter.log("Flight Details Filled Successfully");
		
	}
	
	public void FillPreference() throws Exception
	{
		switch(ExcelUtils.getCellData(2, 4))
		{
			case "Economy Class":
				sClass.get(0).click();
				break;
				
			case "Business Class":
				sClass.get(1).click();
				break;
				
			case "First Class":
				sClass.get(2).click();
				break;
				
		}
		
		
		Select airL = new Select(aLine);
		airL.selectByIndex(2);
		
		Reporter.log("Preference Filled Successfully");
	}
	
	public void SearchDetails()
	{
		cButton.click();
		
		Reporter.log("Search Started");
	}
	
}
