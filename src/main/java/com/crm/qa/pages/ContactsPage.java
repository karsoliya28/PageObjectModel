/* 
 * @author Vandana Karsoliya
 */
package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name=\"title\"]")
	WebElement TitleDrpDwn;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' ]")
	WebElement savebtn;
	

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	public void selectContacts(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent:://td[@class='datalistrow']//preceding-sibling::td[@name='contact_id']")).click();
	}

	public boolean verifyContactsLabel() {
		boolean flag= contactsLabel.isDisplayed();
		return flag;
	}
	
	public void createNewContact(String title, String fname, String lname, String comp )
	{
		Select select=new Select(TitleDrpDwn);
		select.selectByVisibleText(title);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(comp);
		savebtn.click();
		
		
	}
}
