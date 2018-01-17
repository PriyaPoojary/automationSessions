package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import TestData.InitialiseBrowser;

public class Frame {
  @Test
  public void f() throws Exception{
	  WebDriver driver = InitialiseBrowser.OpenBrowser();
	  driver.get("http://way2automation.com/way2auto_jquery/frames-windows/frameset.html");
	  
	  driver.switchTo().frame(1);
	  
	  
	  driver.findElement(By.xpath("html/body/h2"));
  }
}
