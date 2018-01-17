package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import TestData.InitialiseBrowser;

public class WinAutoIt {
  @Test
  public void f() throws Exception {
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  driver.get("http://toolsqa.com/automation-practice-form/");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  WebElement button = driver.findElement(By.id("photo"));
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  button.click();
	  
	  Runtime.getRuntime().exec("D:\\Vinay\\UploadWindow.exe");
	  
	  Thread.sleep(10000);
	  
	  driver.close();
  }
}
