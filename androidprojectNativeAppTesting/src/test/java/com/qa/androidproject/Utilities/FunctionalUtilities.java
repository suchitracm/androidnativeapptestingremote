package com.qa.androidproject.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.androidproject.Base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class FunctionalUtilities {
	public static WebDriverWait wait;
	public static ReportUtilities reportUtils = new ReportUtilities();

	// To verify visibility of Webelement
	public static void waitForElementPresent(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for element " + element.toString());
		}
	}

	// To wait for PageTitle
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for element" + title);
		}

	}

	// To get PageTitle
	public String getPageTitle() {
		String pageTitle = TestBase.driver.getTitle();
		waitForPageTitle(pageTitle);
		return pageTitle;
	}

	// To get Page Header
	public static String getPageHeader(WebElement element) {
		waitForElementPresent(element);
		return element.getText();
	}

	// To enter text
	public static void enterText(WebElement ele, String uText, String fieldName) throws IOException {
		waitForElementPresent(ele);
		if (ele.isDisplayed()) {
			System.out.println(fieldName + " is displayed on the screen");
			System.out.println(uText + " is successfully entered into " + fieldName);
			ele.clear();
			ele.sendKeys(uText);
			reportUtils.test.log(LogStatus.INFO, fieldName + " entered successfully");

		} else {
			System.out.println(uText + " is not successfully entered into " + fieldName);
			reportUtils.test.log(LogStatus.FAIL, fieldName + " is not entered successfully"
					+ reportUtils.test.addScreenCapture(ReportUtilities.takeScreenshot()));

		}
	}

	// To click Button
	public static void clickButton(WebElement ele, String fieldName) throws IOException {
		waitForElementPresent(ele);

		if (ele.isDisplayed()) {
			System.out.println(fieldName + " is displayed on the screen");
			System.out.println(fieldName + " is successfully clicked ");
			ele.click();
			ReportUtilities.test.log(LogStatus.INFO, fieldName + " clicked successfully");

		} else {
			System.out.println(fieldName + " is not successfully clicked");
			ReportUtilities.test.log(LogStatus.FAIL, fieldName + " is not clicked successfully"
					+ ReportUtilities.test.addScreenCapture(ReportUtilities.takeScreenshot()));

		}
	}

	// To verify Error Message
	public static void errMessage(WebElement ele1, String erMessage) throws IOException {
		waitForElementPresent(ele1);

		if (ele1.getText().equalsIgnoreCase(erMessage)) {
			System.out.println(erMessage + " error message popped");
			System.out.println("The error message is Verified");
			ReportUtilities.test.log(LogStatus.PASS, erMessage + " Error message displayed successfully");
		} else {
			System.out.println("The error message didn't pop.");
			ReportUtilities.test.log(LogStatus.FAIL, " Error message is not displayed successfully."
					+ ReportUtilities.test.addScreenCapture(ReportUtilities.takeScreenshot()));

		}
	}

	// To verify message
	public static void msgVerify(WebElement ele2, String msgInfo) throws IOException {
		waitForElementPresent(ele2);

		if (ele2.getText().contains(msgInfo)) {
			System.out.println(msgInfo + " is displayed");
			System.out.println("Successfully is Verified");
			ReportUtilities.test.log(LogStatus.PASS, msgInfo + " is verified successfully");

		} else {
			System.out.println("The info is not successfull.");
			ReportUtilities.test.log(LogStatus.FAIL, msgInfo + " is not matched"
					+ ReportUtilities.test.addScreenCapture(ReportUtilities.takeScreenshot()));

		}
	}

	// verify element is displayed
	public boolean verifyDisplayed(WebElement webelement, String elementName) {
		waitForElementPresent(webelement);

		if (webelement.isDisplayed()) {
			ReportUtilities.test.log(LogStatus.PASS, elementName + " is displayed");
			return true;
		} else {
			ReportUtilities.test.log(LogStatus.FAIL, elementName + " is not displayed");
			return false;
		}
	}

	// verify element is present
	public boolean verifyPresent(WebElement webelement, String elementName) {
		waitForElementPresent(webelement);

		if (webelement.isDisplayed() && webelement.isEnabled()) {
			ReportUtilities.test.log(LogStatus.PASS, elementName + " is present");
			return true;
		} else {
			ReportUtilities.test.log(LogStatus.FAIL, elementName + " is not displayed or enabled");
			return false;
		}
	}

	// verify expected text with actual text
	public boolean verifyText(String actualText, String expectedText, String elementName) {
//						System.out.println(actualText +" "+expectedText);
		if (actualText.contains(expectedText)) {
			ReportUtilities.test.log(LogStatus.PASS, elementName + " text is validated");
			return true;
		} else {
			ReportUtilities.test.log(LogStatus.FAIL, elementName + " text is not validated");
			return false;

		}
	}

	// Verifying using locator
//	public WebElement getElement(By userName) {
//		WebElement element = null;
//		try {
//			waitForElementPresent(userName);
//			element = TestBase.driver.findElement(userName);
//			return element;
//		} catch (Exception e) {
//			System.out.println("Some error occured while creating element" + userName.toString());
//		}
//		return element;
//	}
//
//	public String getPageHeader(By locator) {
//		return getElement(locator).getText();
//	}
//
//	public void waitForElementPresent(By locator) {
//		try {
//			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		} catch (Exception e) {
//			System.out.println("Some exception/error occured while waiting for element" + locator.toString());
//		}
//
//	}

}
