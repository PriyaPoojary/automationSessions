package PageObjectsC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropPage {
	
	WebDriver driver = null;
	
	public DropPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@FindBy(id = "ui-id-5")
	WebElement sCart;
	
	@FindBy(xpath=".//*[@id='ui-id-7']/ul/li[3]")
	WebElement fromE;
	
	@FindBy(xpath = ".//*[@id='ui-id-10']/a")
	WebElement ele;
	
	@FindBy(xpath = ".//*[@id='cart']/div/ol")
	WebElement toE;
	
	public void DragandDropElement()
	{
		sCart.click();
		//ele.click();
		
		((JavascriptExecutor)driver).executeScript("scrollBy(0,250);");
		
		Actions builder = new Actions(driver);
		
		Action dragAndDrop = builder.clickAndHold(fromE).moveToElement(toE).release(toE).build();
		
		
		dragAndDrop.perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='cart']/div/ol/li")));
		Assert.assertNotNull(ele1);
	}

}
