package Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjectsC.BookingPage;
import PageObjectsC.HomePage;
import TestData.Constants;
import TestData.InitialiseBrowser;

public class BrowserTest {
	
@Test
  public void HomePageTest() throws Exception{
	  
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  HomePage hPage = PageFactory.initElements(driver, HomePage.class);
	  
	  driver.get(Constants.url);
	  hPage.SiteLogin();
	 
	  Assert.assertTrue(driver.getCurrentUrl().contains("mercuryreservation"));
	  
	  driver.close();
	  
	  Reporter.log("Home Page Test Passed");
  }
  
  @Test 
  public void BookingPageTest() throws Exception{
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  HomePage hPage = PageFactory.initElements(driver, HomePage.class);
	  BookingPage bPage = PageFactory.initElements(driver, BookingPage.class);
	  
	  driver.get(Constants.url);
	  hPage.SiteLogin();
	  
	  bPage.FillFlightDetails();
	  bPage.FillPreference();
	  
	  bPage.SearchDetails();
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("mercuryreservation2"));
	  
	  driver.close();
	  
	  Reporter.log("Booking Page Test Passed");
  }
}
