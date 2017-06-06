package com.unisuper.assignment.Angular.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoMVCpage {

	/**
	 * Page Object Model for Login page of Atlas app
	 */
	
	@FindBy(id="new-todo")
	public WebElement AddToDoTextBox;
	
	@FindBy(xpath="//*[@id='todo-list']/li[1]/div/input")
	public WebElement CircleToComplete;
	
	@FindBy(xpath="//*[@id='todo-list']/li[1]/div/label")
	public WebElement LabelToEdit;
	
	@FindBy(xpath="//*[@id='todo-list']/li[2]/div/label")
	public WebElement LabelToEdit2;
	
	@FindBy(xpath="//*[@id='todo-list']/li[1]/form/input")
	public WebElement ExistingToDoEditTextBox;
	
	@FindBy(id="toggle-all")
	public WebElement ToggleAllCheckBox;

	@FindBy(linkText="Completed")
	public WebElement Completed;
	
	@FindBy(xpath="//*[@id='todo-list']/li[1]/div/button")
	public WebElement deleteTodoBtn;
	
	@FindBy(id="clear-completed")
	public WebElement ClearCompletedBtn;
	
	
	
	
	

}
