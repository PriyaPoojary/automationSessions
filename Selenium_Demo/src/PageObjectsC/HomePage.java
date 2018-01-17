package PageObjectsC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import TestData.ExcelUtils;

public class HomePage {
	
	WebDriver driver = null;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@FindBy(name = "userName")
	WebElement uName;
	
	@FindBy(name = "password")
	WebElement pWord;
	
	@FindBy(name = "login")
	WebElement sIn;
	
	public void SiteLogin() throws Exception
	{
				
		uName.sendKeys(ExcelUtils.getCellData(1, 1));	
		pWord.sendKeys(ExcelUtils.getCellData(1, 2));
		
		sIn.getAttribute("value");
				
		sIn.click();
		
		Reporter.log("Site Login Successfull");
	}

}
