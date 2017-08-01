package com.NAMTG1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LaunchBrowser {

	WebDriver driver;
	Logger log;
	
	@BeforeClass
	public void invokeBrowser() throws InterruptedException
	{
		log = Logger.getLogger(LaunchBrowser.class);
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		log.info("Browser is Launching");
	}
	
	@Test(priority=1)
	public void CallloginPage() throws InterruptedException
	{
		LoginPage LoginP = new LoginPage(driver);
		LoginP.Loginpatient("TomBrady_123", "TomBrady@123");
		log.info("Entering UserName and PassWord for Patient Login");
	}
	
	@Test(priority=2)
	public void CallSearchSymptoms() throws InterruptedException
	{
		SearchSymptoms SearchStms = new SearchSymptoms(driver);
		SearchStms.verifySearchSymptomsPageOptions();
		log.info("Verifying Search Symtoms Page");
	}
	
	@Test(priority=3)
	public void CallSendMessages() throws InterruptedException
	{
		SendMessages SendMsg = new SendMessages(driver);
		SendMsg.EnterMessages("Emergency","Need to talk Imm");
		log.info("Entering message in Message Tab");
	}
	@Test(priority=4)
	public void CallAlertAccept () throws InterruptedException
	{
		AlertAccept AlertApt = new AlertAccept(driver);
		AlertApt.switchAlertMessage();
		log.info("Displaying Message Sucessfull");
		
	}
}