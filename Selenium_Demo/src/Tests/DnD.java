package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjectsC.DropPage;
import TestData.Constants;
import TestData.InitialiseBrowser;

public class DnD {
  @Test
  public void f() throws Exception {
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  DropPage dPage = PageFactory.initElements(driver, DropPage.class);
	  
	  driver.get(Constants.url2);
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	  dPage.DragandDropElement();
	  
	  driver.close();
  }
}
