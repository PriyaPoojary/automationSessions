package TestData;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitialiseBrowser {
	
	public static WebDriver OpenBrowser() throws Exception
	{
		String bName = GetBrowserName();
		WebDriver driver = null;
		switch(bName)
		{
			case "Firefox":
				driver = new FirefoxDriver();
				break;
				
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "IE":
				System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
		}
		return driver;
	}
	
	public static String GetBrowserName() throws Exception
	{
		try{
			
		Properties prop = new Properties();
		
		String rootPath = "D:\\Vinay\\Selenium_Workspace\\Selenium_Demo\\";
		String configPath = rootPath + "Config.properties";
		
		prop.load(new FileInputStream(configPath));
		
		String bName = prop.getProperty("browser");
		
		return bName;
		} catch(Exception E)
		{
			return null;
		}
	}

}
