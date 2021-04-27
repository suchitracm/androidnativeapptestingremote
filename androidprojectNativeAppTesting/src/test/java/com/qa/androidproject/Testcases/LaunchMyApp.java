package com.qa.androidproject.Testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.androidproject.Base.TestBase;
import com.qa.androidproject.Utilities.FunctionalUtilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LaunchMyApp extends TestBase {

	public LaunchMyApp() throws IOException {
		super();
	}


	@Test(enabled=false)
	public void TC1_AddingTwoNumbers() throws Exception {

//		logger.info("***********************Amazon Search Test case started**********************");
//		logger.info("searchText is "+searchText);
		driver.findElement(By.id("calc_keypad_btn_07")).click();
		driver.findElement(By.id("calc_keypad_btn_add")).click();
		driver.findElement(By.id("calc_keypad_btn_05")).click();
		driver.findElement(By.id("calc_keypad_btn_equal")).click();
		System.out.println(driver.findElement(By.id("calc_edt_formula")).getText());
		String result = driver.findElement(By.id("calc_edt_formula")).getText();
		Assert.assertEquals(result,"12");
		
//		logger.info("***********************Amazon Search Test case Completed successfully**********************");
		System.out.println("Test Case1 Completed");

	}
	
	
	
	@Test(enabled=false)
	public void TC2_PeopleActivity() throws Exception {

//		logger.info("***********************People Activity Test case started**********************");
//		logger.info("searchText is "+searchText);
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Baskar']")).click();
//		logger.info("***********************People Activity Test case Completed successfully**********************");
		System.out.println("Test Case2 Completed");

	}
	
	
	@Test(enabled=false)
	public void TC3_PeopleActivityVerticalScrolldown() throws Exception {

		//Accessibility id is a type of unique locator
		//driver.findElement(MobileBy.AccessibilityId("Balakrishnan")).click();
		
		//For scrolling down to a particular text in a list 
		
		String listName = "com.samsung.android.app.contacts:id/contact_list";
		String contactName = "Hong";
		
		//If the text is inside the list
		MobileElement scroll = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+
		listName+"\")).scrollIntoView(new UiSelector().textContains(\""+contactName+"\"))");
		scroll.click();
		
//		//If the text is not in the list, its outside we can scroll till the text
//		MobileElement scroll1 = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+
//		listName+"\")).scrollIntoView(new UiSelector().text(\""+contactName+"\"))");
//		scroll1.click();
		
		System.out.println("Test Case3 Completed");

	}
	

	@Test
	public void TC4_PeopleActivityswipe() throws Exception {

		//swiping from left to right x values will change and y will remain the same
		// swiping from top to bottom x values will remain same and y values will change
		TouchAction swp = new TouchAction(driver);
		swp.press(PointOption.point(11,252)).waitAction().moveTo(PointOption.point(1119, 252)).release().perform();
		
		System.out.println("Successfully swiped");
		
		swp.press(PointOption.point(1119,252)).waitAction().moveTo(PointOption.point(11,252)).release().perform();
		
		//swp.press(PointOption.point(11,252)).waitAction().moveTo(PointOption.point(1299,252)).release().perform();
		
		System.out.println("Test Case4 Completed");

	}

	
}
