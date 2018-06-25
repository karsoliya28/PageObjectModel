/* 
 * @author Vandana Karsoliya
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

public class ContactPageTest extends TestBase {

	TestUtils testUtil;
	LoginPage login;
	HomePage home;
	ContactsPage contact;
	String SheetName = "Contacts";

	public ContactPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtils();
		contact = new ContactsPage();
		login = new LoginPage();
		// home = login.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		home = login.login("vandanak", "test@123");
		testUtil.switchToFrame();
		contact = home.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void contactsPageLabelTest() {
		Assert.assertTrue(contact.verifyContactsLabel(), "Label is missing");
	}

	
	  @Test (priority = 3)
	  public void selectContactTest() { // Thread.sleep(5000);
	  contact.selectContacts("Tom Peter"); System.out.println("Done");
	  
	 }
	 

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtils.getTestData(SheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstname, String lastname, String company) {
		home.clickOnNewConctactLink();
		contact.createNewContact(title, firstname, lastname, company);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
