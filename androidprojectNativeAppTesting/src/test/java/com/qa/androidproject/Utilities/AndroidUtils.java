package com.qa.androidproject.Utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.androidproject.Base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidUtils {

	public void launchApp() throws Exception {

		System.out.println("Test case started");
//		TestBase.logger.info("***********************Test case started**********************");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R52N70RFSSP");
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(CapabilityType.VERSION, "10");
		TestBase.driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		TestBase.driver.get(TestBase.url);
//		TestBase.logger.info(TestBase.url);
//		TestBase.logger.info("***********************Amazon WebPage Launched**********************");
		ReportUtilities.test.log(LogStatus.PASS, "App Launched Successfully");
		System.out.println("App Launched");

	}

	public void launchNativeApp() throws Exception {
		System.out.println("Test case Launch Native Calculator App started");
//		TestBase.logger.info("***********************Test case Launch Native App started**********************");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R52N70RFSSP");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		TestBase.driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		ReportUtilities.test.log(LogStatus.PASS, "Calculator App Launched Successfully");
		System.out.println("Calculator App Launched");

	}

public void launchNativePeopleContactsApp() throws Exception {
	System.out.println("Test case Launch Native Calculator App started");
//	TestBase.logger.info("***********************Test case Launch Native App started**********************");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R52N70RFSSP");
//	cap.setCapability("appPackage", "com.samsung.android.app.contacts");
//	cap.setCapability("appActivity", "com.samsung.android.contacts.contactslist.PeopleActivity");
	TestBase.driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	ReportUtilities.test.log(LogStatus.PASS, "People Contact App Launched Successfully");
	System.out.println("People Contact App Launched");

}




}
