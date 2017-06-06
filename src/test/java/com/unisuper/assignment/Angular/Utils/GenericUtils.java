package com.unisuper.assignment.Angular.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GenericUtils {
	
	WebDriver driver;
	String strDate;
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        strDate = sdf.format(cal.getTime());
		
	}
	public void enterText(WebElement element, String value)
	{
		try{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(value);
			
		}
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("No such element is found on the page: "+element);
		}
		
	}
	
	public String getText(WebElement element)
	{
		String value="";
		try{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		if(element.isDisplayed())
		{
			value=element.getText();
		
			
		}
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("No such element is found on the page: "+element);
		}
		return value;
		
	}
	
	public void clickElement(WebElement element)
	{
		try{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		if(element.isDisplayed())
		{
			element.click();
		}
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("No such element is found on the page , so not able to click: "+element);
		}
		
	}
	
	 public void TakeScreenShot(WebDriver driver,String Scenario)
     {
            
            
            File screenshot = new File("Screenshots//"+strDate+"//"+Scenario+".jpg");
            File tmpScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                   FileUtils.copyFile(tmpScreenshot, screenshot);
            } catch (IOException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
            }
            Reporter.log("the screenshot printed at:- " + screenshot.getAbsolutePath());
     }
	
	
	
	

}
