package Tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestData.InitialiseBrowser;

public class WHandlers {
  @Test
  public void f() throws Exception{
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  
	  driver.get("http://toolsqa.com/");
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  WebElement link1 = driver.findElement(By.xpath(".//*[@id='primary-menu']/li[8]/a/span[1]/span/span"));
	  
	  Actions builder = new Actions(driver);
	  
	  builder.moveToElement(link1).build().perform();
	  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  String win1 = driver.getWindowHandle();
	  System.out.println(win1);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  WebElement link2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='primary-menu']/li[8]/ul/li[1]/a/span[1]/span/span")));
	  link2.click();
	  Set<String> handles = driver.getWindowHandles();
	  String win2 = null;
	  
	  for(String handle : handles)
	  {
		  if(handle!= win1)
		  {
			  win2 = handle;
		  }
	  }
	  
	  driver.switchTo().window(win2);
	  System.out.println(win2);
	  driver.findElement(By.xpath(".//*[@id='main-nav']/form/fieldset/input[1]")).sendKeys("iPhone");
	  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  
	  driver.switchTo().window(win1);
	  String win3 = driver.getWindowHandle();
	  System.out.println(win3);
	  
	  builder.moveToElement(link1).build().perform();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='primary-menu']/li[8]/ul/li[3]/a/span[1]/span/span"))).click();
	 
	  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("automation"));
	  driver.quit();
  }
}
