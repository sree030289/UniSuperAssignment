package com.unisuper.assignment.Angular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverManager {
	
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	
	//returns the WebDriver with requested browser
	public static WebDriver getDriver(String browserName) {
    	
      WebDriver driver;
      driver = createInstance(browserName);
      setWebDriver(driver);
      return webDriver.get();
      
      
    }
 
	//sets the webDriver
    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    
   public static void quitDriver() {
  	  if (webDriver.get() != null) {
  	      webDriver.get().quit();
  	  }
      }    
    
    //Creating the instance of webDriver with requested browser name and returning the driver instance 
    static WebDriver createInstance(String browserName) {
		WebDriver driver = null;
        
		if (browserName.toLowerCase().contains("firefox"))
		{
			System.setProperty("webdriver.ie.driver", "Resources\\geckodriver.exe");
           driver = new FirefoxDriver();
           return driver;
        }
		
		else if (browserName.toLowerCase().contains("internet"))
		{
            
			System.setProperty("webdriver.ie.driver", "Resources\\internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			return driver;
		}
		
		else if (browserName.toLowerCase().contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		}
		
		else if (browserName.toLowerCase().contains("phantom"))
		{
			System.setProperty("phantomjs.binary.path", "Resources\\phantomjs.exe");		
            driver = new PhantomJSDriver();
            return driver;
        }

		else
		{
			System.out.println("Please provide proper browser name");
		}
        return driver;
	}
	

}
