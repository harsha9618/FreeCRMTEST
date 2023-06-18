package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[contains(text(),'Harsha Reddy')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deal')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Task')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//span[contains(text(),'Cases')]")
	WebElement casesLink;
	
	@FindBy(xpath="//button[contains(text(),'Create')]") 
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean  verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	} 
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		
		action.moveToElement(contactsLink).build().perform();
	}

}
