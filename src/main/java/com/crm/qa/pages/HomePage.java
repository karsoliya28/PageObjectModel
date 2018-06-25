/* 
 * @author Vandana Karsoliya
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtils;

public class HomePage extends TestBase {

	TestUtils testutil;

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {
		return driver.getTitle();
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

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnNewConctactLink() {

		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		return new ContactsPage();
	}
}
