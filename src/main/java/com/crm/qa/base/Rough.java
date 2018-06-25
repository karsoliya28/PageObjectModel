
/* 
 * @author Vandana Karsoliya
 */


package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.util.TestUtils;

public class Rough {
	
	
	

	public static void main(String[] args) throws InterruptedException 
	{
		/*System.setProperty("webdriver.chrome.driver","G:\\Vandana\\eclipse\\New folder\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();*/
		 
		 System.setProperty("webdriver.gecko.driver","G:\\Vandana\\eclipse\\New folder\\GECKO\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.freecrm.com/");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
			Thread.sleep(10000);
			closeModalPopUp(driver);
			
					driver.findElement(By.xpath("//input[@value='Login']")).click();
				driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.switchTo().frame("mainpanel");
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//driver.quit();
			
			
			
	

	}

	public static void closeModalPopUp(WebDriver driver)
	{
		driver.switchTo().frame("intercom-borderless-frame");//intercom-borderless-frame
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.className("intercom-chat-card-author"))).build().perform();
		//driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')//span]")).click();
		driver.switchTo().parentFrame();
		
	}
}
