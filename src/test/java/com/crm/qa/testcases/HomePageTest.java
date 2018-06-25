/* 
 * @author Vandana Karsoliya
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtils testutil;
	ContactsPage contactsPage;
	

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtils();
		contactsPage = new ContactsPage();

	}

	@Test(priority = 1)

	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage Title not match expected");
		System.out.println(homePageTitle);
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void createNewContactTest() {
		testutil.switchToFrame();
		contactsPage = homepage.clickOnNewConctactLink();
		System.out.println(driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}