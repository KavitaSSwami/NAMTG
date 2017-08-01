package com.scheduleappointment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchBrowserpatient {
WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	}
	
	@Test(priority=1)
	public void CallloginPage() throws InterruptedException
	{
		LoginPatientPage LoginP = new LoginPatientPage(driver);
		LoginP.Loginpatient("TomBrady_123", "TomBrady@123");
	}
	@Test(priority=2)
	public void Navigation() throws InterruptedException
	{
		NavitageToScheduleAppointment NTScheduleAppointment = new NavitageToScheduleAppointment(driver);
		NTScheduleAppointment.ScheduleAppointment();
		NTScheduleAppointment.CreateNewAppointment();
	}
	@Test(priority=3)
	public void CallSelectDate() throws InterruptedException
	{
		SelectDate SelectD = new SelectDate(driver);
		SelectD.SelectData();
}
}