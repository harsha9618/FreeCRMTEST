package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//label[text()='Company']")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//button[text()='Save']")
	@CacheLookup
	WebElement saveBtn;
	
	
	//Initialization
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='" +name+"']")).click();
	}
	
	public void createNewContact(String firsName, String ltName, String comp) {
		// Select select= new Select(driver.findElement(By.xpath("")));
		// select.selectByVisibleText(title); String title,
		 firstName.sendKeys(firsName);
		 lastName.sendKeys(ltName);
		 company.sendKeys(comp);
		 saveBtn.click();
		 
	}




}
