package com.qa.androidproject.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import com.qa.androidproject.Utilities.AndroidUtils;
import com.qa.androidproject.Utilities.ReportUtilities;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	
	public static AndroidDriver<WebElement> driver;
	public AndroidUtils androidUtils = new AndroidUtils();
	public static Properties configProperty = new Properties();
	public static Properties credentialProperty = new Properties();
	public static String url;
	public static Logger logger;
	public static String searchText; 
	
	public TestBase() throws IOException
	{
		FileInputStream ip = new FileInputStream("D:\\TekArch1\\VinodSeleniumAssignments\\amazonandroidproject\\src\\test\\java\\com\\qa\\androidproject\\Config\\config.properties");
		configProperty.load(ip);
		url = configProperty.getProperty("Url");
		FileInputStream ip1 = new FileInputStream("D:\\TekArch1\\VinodSeleniumAssignments\\amazonandroidproject\\src\\test\\java\\com\\qa\\androidproject\\Config\\credentials.properties");
		credentialProperty.load(ip1);
		searchText = credentialProperty.getProperty("SearchText");
	}
	
	@BeforeMethod
	public void TriggeringBeforeSuiteDependency() throws Exception
	{
//		logger.getLogger("Andriod Amazon Test case");
//		PropertyConfigurator.configure("D:\\TekArch1\\VinodSeleniumAssignments\\amazonandroidproject\\src\\test\\java\\com\\qa\\androidproject\\Config\\Log4j.properties");
//		logger.setLevel(Level.DEBUG);
		ReportUtilities.initializeReports();
		androidUtils.launchNativePeopleContactsApp();
	}
	
}
