package com.qa.androidproject.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.androidproject.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportUtilities {
	
	

	public static ExtentReports report;
	public static ExtentTest test;
	public static String fpath;
	public static String path;

	/*Method Name: initializeReports
	  Method Description : Allows to take reports
	  Date Created:
	 */	
public static void initializeReports()
{
	
		 fpath = new SimpleDateFormat("'Currentdate_'MMddYYYY'.html'").format(new Date());
		 path = "D:\\TekArch1\\VinodSeleniumAssignments\\amazonandriodproject\\src\\test\\reports\\amazonreports\\AmazonReport" +fpath;
		report = new ExtentReports(path);	
		test = report.startTest("Amazon Search Test Cases Started");
		report.addSystemInfo("HostName","localhost");
		report.addSystemInfo("Environment","QA");
		report.addSystemInfo("User","Suchitra");
		
		
		
	}

	
	
/*Method Name: takeScreenshot
  Method Description : Allows to take screenshot
  Date Created:
 */
public static String takeScreenshot() throws IOException
{
TakesScreenshot screenShot = ((TakesScreenshot)TestBase.driver);
File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
String imgpath = "D:\\TekArch1\\VinodSeleniumAssignments\\amazonandriodproject\\src\\test\\reports\\amazonreports\\Screenshots\\Image"+new SimpleDateFormat("'CurrentDate_'MMddYYYY'.png'").format(new Date());
File desfile = new File(imgpath);
FileUtils.copyFile(srcFile,desfile);
return imgpath;
}



}
