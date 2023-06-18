package com.crm.qa.testcases;

import org.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class ContactsPageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="Contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
	    contactsPage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact label is missing");
	}
	
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContacts("Shilpa P");
	}
	
	@Test(priority=3)
	public void selectultipleContactsTest() {
		//contactsPage.selectContacts("Shilpa P");
		contactsPage.selectContacts("Pallavi J");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName,lastName,company);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
