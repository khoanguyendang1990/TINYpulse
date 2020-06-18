package commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseFunctions {

	WebDriver driver;
	WebElement element;
	WebDriverWait waitExplicit;
	long longTimeout = 30;
	JavascriptExecutor jsExecutor;

	public ReuseFunctions(WebDriver driver) {
		this.driver = driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);
		jsExecutor = (JavascriptExecutor) driver;
	}

	public void openUrl(String urlValue) {
		driver.get(urlValue);
	}
	public WebElement find(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	public void waitForElementVisible(WebElement element) {
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementVisible(String locator,String... params) {
		locator = castRestParameter(locator, params);
		WebElement element = find(locator);
		waitForElementVisible(element);
	}
	public void waitForElementClickable(WebElement element) {
		waitExplicit.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickToElement(WebElement element) {
		element.click();
	}

	public void clickToElement(String locator, String... params) {
			locator = castRestParameter(locator, params);
			element = find(locator);
			element.click();
	}
			
	public void sendKeyToElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplay(WebElement element) {
		return element.isDisplayed();
	}
	
	public void clickToElementByJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	
	public String castRestParameter(String locator, String... params) {
		locator = String.format(locator, (Object[]) params);
		return locator;
	}
	
	public String getTextFromTableGrid(String locator,String row, String column) {
		locator = castRestParameter(locator, row, column);
		WebElement element = find(locator);
		waitForElementVisible(element);
		return getTextElement(element);
	}
	
	public String getAttributeValue(String locator, String attributeName) {
		element = find(locator);
		return element.getAttribute(attributeName);
	}
	
	public String getAttributeValue(String locator, String attributeName, String... params) {
		locator = castRestParameter(locator, params);
		element = find(locator);
		return element.getAttribute(attributeName);
	}
	
	public String getAttributeFromTableGrid(String locator,String row, String column, String attributeName) {
		locator = castRestParameter(locator, row, column);
		return getAttributeValue(locator,attributeName);
	}
	
	public void takeScreenshot(String testcaseName) {

		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + testcaseName + "_" + formater.format(calendar.getTime()) + ".png"));
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}

	}
}
