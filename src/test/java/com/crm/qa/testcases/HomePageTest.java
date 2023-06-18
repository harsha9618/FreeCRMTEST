package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utilities.TestUtil;

public class HomePageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	Logger log;
	
	public HomePageTest() {
		super();
	}
	//test cases should be separated- independent with each other
	//before each test cases -- launch the browser and login
	//test -- execute test case
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
	    contactsPage = new ContactsPage();
		loginPage = new LoginPage(); 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log= Logger.getLogger(getClass());
		
	}
	@Test
	public void verifyHomePageTtitleTest() {
		log.info("Assert the title");
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page title not found");
		log.info("**** Successfully Verify the Home page title ****");
		
	}
	
	@Test
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
		log.info("**** Successfully Verify the user name test ****");
	}
	public void verifyContactsLink() {
		contactsPage = homePage.clickOnContactsLink();
		log.info("**** Successfully Verify the contacts link ****");
		
	}
	 
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
