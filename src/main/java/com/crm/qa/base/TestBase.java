/* 
 * @author Vandana Karsoliya
 */

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtils;
import com.crm.qa.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener; 
	
	public TestBase(){
		prop=new Properties();
		   FileInputStream Input;
		try {
			Input = new FileInputStream("G:\\Vandana\\eclipse\\workspace\\FreeCRMTestAutomation\\src\\main\\java\\com\\CRM\\qa\\configuration\\config.properties");
			prop.load(Input);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch (IOException e) 
		{
						e.printStackTrace();
		}
	}
		  
	public static void initialization()	{
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.logfile", "TestLog.txt");
			System.setProperty("webdriver.chrome.driver","G:\\Vandana\\eclipse\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();

		} 
		else if(browserName.equals("Firefox"))
		 {
		  System.setProperty("webdriver.gecko.driver","G:\\Vandana\\eclipse\\New folder\\GECKO\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		 }
		e_driver=new EventFiringWebDriver(driver);
		
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	public static void closeModalPopUp(WebDriver driver)
	{
		driver.switchTo().frame("intercom-borderless-frame");//intercom-borderless-frame
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.className("intercom-chat-card-author"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')//span]")).click();
		//driver.switchTo().parentFrame();
		
	}
}
