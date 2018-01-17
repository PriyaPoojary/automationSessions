package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestData.InitialiseBrowser;

public class AlertTest {
  @Test
  public void f() throws Exception {
	  WebDriver driver  = InitialiseBrowser.OpenBrowser();
	  
	  driver.get("http://demo.guru99.com/test/delete_customer.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  
	  
	  driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("12345");
	  driver.findElement(By.name("submit")).click();
	 
	  
	  Alert alertMess = driver.switchTo().alert();
	  String messageA  = alertMess.getText();
	  String messageE = "Do you really want to delete this Customer?";
	  
	  Assert.assertEquals(messageA, messageE, "the text are not same");
	  
	  alertMess.accept();
	  
	 
	  driver.close();
	  
  }
}
