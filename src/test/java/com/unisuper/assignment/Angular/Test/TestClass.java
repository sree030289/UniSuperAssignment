package com.unisuper.assignment.Angular.Test;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.unisuper.assignment.Angular.Page.ToDoMVCpage;
import com.unisuper.assignment.Angular.Utils.GenericUtils;
import com.unisuper.assignment.Angular.WebDriverManager;

public class TestClass {
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	public ToDoMVCpage POM;
	public GenericUtils utils;
	
	// can be modified as per request .. providing the browser as chrome for now
	public String browserName="chrome";


	
	// Before method runs before each test method to start the browser and intitiate the dependency classes
	@BeforeMethod
	public void BeforeMethod()
	{
		 driver = WebDriverManager.getDriver(browserName);
		 wait= new WebDriverWait(driver,5000);
		 action = new Actions(driver);
		 POM = PageFactory.initElements(driver,ToDoMVCpage.class);
		 utils= new GenericUtils(driver);	 
		 driver.navigate().to("http://todomvc.com/examples/angularjs/#/");
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
	}
	
	
	@Test(description="This test is to verify that you can add a To-do item")
	public void AddTodo()
	{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);		
		utils.clickElement(POM.CircleToComplete);
		
		//validate the task is added 

		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit), "Strings are not matching");
		
		utils.TakeScreenShot(driver, "Success AddTodo test");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in ADDTODO test");
			utils.TakeScreenShot(driver, "Exception in AddTodo test");
		}
		
	}
	@Test(description="This test is to verify that you can edit the content of an existing To-do item")
	public void EditExistingTodo()
	{	
		try{	
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		
		action.doubleClick(POM.LabelToEdit).build().perform();
		utils.enterText(POM.ExistingToDoEditTextBox, "modified To do test 1");
		POM.ExistingToDoEditTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("modified To do test 1", utils.getText(POM.LabelToEdit));
		utils.TakeScreenShot(driver, "Success existing To-do item");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in existing To-do item");
			utils.TakeScreenShot(driver, "Exception in existing To-do item");
		}
		
	}
	
	@Test( description="This test is to verify that you can complete a To-do by clicking inside the circle UI to the left of the To-do")
	public void CompleteTodo()
	{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		utils.clickElement(POM.CircleToComplete);
		utils.TakeScreenShot(driver, "Success Complete one To-do item");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in Complete one To-do item");
			utils.TakeScreenShot(driver, "Exception Complete one To-do item");
		}
		
	}
	
	@Test( description="This test is to verify that you can re-activate a completed To-do by clicking inside the circle UI")
	public void ReactivateCompleteTodo()
	{	
	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		utils.clickElement(POM.CircleToComplete);
		utils.clickElement(POM.CircleToComplete);
		utils.TakeScreenShot(driver, "Success re-activate a completed");
		
	}
	catch(Exception e)
	{
		System.out.println("Exception occured in re-activate a completed");
		utils.TakeScreenShot(driver, "Exception re-activate a completed");
	}
	}
	
	@Test( description="This test is to verify that you can  add a second To-do")
	public void Add2Todo()
	{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 2");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 2", utils.getText(POM.LabelToEdit2));
		utils.TakeScreenShot(driver, "Success add a second To-do");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in add a second To-do");
			utils.TakeScreenShot(driver, "Exception add a second To-do");
		}
		
		
	}
	
	@Test( description="This test is to verify that you can complete all active To-dos by clicking the down arrow at the top-left of the UI")
		public void CompleteALLTodo()
		{	
			
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 2");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 2", utils.getText(POM.LabelToEdit2));
		
		utils.clickElement(POM.ToggleAllCheckBox);	
		
		utils.TakeScreenShot(driver, "Success complete all");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in complete all to do");
			utils.TakeScreenShot(driver, "Exception complete all To-do");
		}
			
		}
	
	@Test( description="This test is to verify that you can filter the visible To-dos by Completed state")
	public void CompleteTodoFilter()
	{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 2");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 2", utils.getText(POM.LabelToEdit2));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 3");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
			
		utils.clickElement(POM.ToggleAllCheckBox);	
		
		utils.clickElement(POM.Completed);
		
		utils.TakeScreenShot(driver, "Success completeFilter");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in completeFilter test");
			utils.TakeScreenShot(driver, "Exception complete Filter");
		}
			
		
		
	}
	
	@Test( description="This test is to verify that you can clear a single To-do item from the list completely by clicking the Close icon.")
	public void DeleteTodo()
	{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 2");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 2", utils.getText(POM.LabelToEdit2));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 3");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
			
	
		action.moveToElement(POM.LabelToEdit).build().perform();
		
		utils.clickElement(POM.deleteTodoBtn);	
	
		utils.TakeScreenShot(driver, "Success clear a single to do");
	}
	catch(Exception e)
	{
		System.out.println("Exception occured in clear a single to do test");
		utils.TakeScreenShot(driver, "Exception clear a single to do");
	}	
	}
	
	
	@Test( description="This test is to verify that you can clear all completed To-do items from the list completely")
		public void DeleteAllTodo()
		{	
		try{
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 1");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 1", utils.getText(POM.LabelToEdit));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 2");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		Assert.assertEquals("To do test 2", utils.getText(POM.LabelToEdit2));
		
		utils.clickElement(POM.AddToDoTextBox);		
		utils.enterText(POM.AddToDoTextBox, "To do test 3");
		POM.AddToDoTextBox.sendKeys(Keys.ENTER);
		
		utils.clickElement(POM.ToggleAllCheckBox);	
		
		utils.clickElement(POM.ClearCompletedBtn);

		utils.TakeScreenShot(driver, "Success clear all completed to do");
		
		}
	catch(Exception e)
	{
		System.out.println("Exception occured in clear a single to do test");
		utils.TakeScreenShot(driver, "Exception clear all completed to do");
	}	
		}
		
	
	@AfterMethod
	public void AfterMethod()
	{
		// close the browser before running each test to make sure we are running fresh every time
		//or else i can put refresh of browser instead of closing and opening the browser
		
		//driver.navigate().refresh();
		
		driver.close();
		
		
	}
	
	
	
	

}
