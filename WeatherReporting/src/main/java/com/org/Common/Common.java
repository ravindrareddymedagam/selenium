package com.org.Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.org.Tools.DriverManager;
import com.org.Tools.DriverManagerFactory;
import com.org.Tools.DriverTypes;

public class Common {

	DriverManager drivermanager;
	public static WebDriver driver;
	public int DEFAULT_EXPLICIT_WAIT_TIMEOUT = 90;
	private int number;

	public Common(WebDriver a_driver) {
		this.driver = a_driver;
	}

	public void launchBrowser(String url) throws Exception {
		drivermanager = DriverManagerFactory.getManager(DriverTypes.CHROME);
		driver = drivermanager.getDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void clickOnElementUsingJS(String elementName, By locator) throws Exception {
		System.out.println("click started");
		try {

			waitForVisibilityOfElementLocated(locator);
			WebElement element = getElement(locator);
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				System.out.println("click completed");
			}

		} catch (Exception e) {

			Assert.assertEquals("FAIL - Element is not displayed", true);
		}

	}

	public void checkPageReadyState() {
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}

			if (((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
					.equals("complete")) {
				break;
			}
		}
	}

	public void waitForVisibilityOfElementLocated(By locator) {
		waitForElementToBeClickable(locator, DEFAULT_EXPLICIT_WAIT_TIMEOUT);
	}

	public void waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = webDriverWait(timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebDriverWait webDriverWait(long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait;
	}

	public WebElement getElement(By locator) {
		checkPageReadyState();
		return driver.findElement(locator);
	}

	public void clickOnElement(String elementName, By locator) throws Exception {

		try {

			waitForVisibilityOfElementLocated(locator);
			getElement(locator).click();

		} catch (Exception e) {

		}

	}

	public void moveMapDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("map_canvas")).sendKeys(Keys.DOWN);
	}

	private void executeJS(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript(script, element);
	}

	public String getElementText(By locator) throws Exception {
		boolean status = true;
		String returnText = "RandDom";
		try {
			returnText = getElement(locator).getText().trim();

		} catch (Exception e) {

		}

		return returnText;

	}

	public void moveToASpecfiedElemntOnThePage(String elementName, By locator) throws Exception {
		boolean status = true;
		try {

			WebElement element = getElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(element, 100, 100).release().perform();

		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

	}

	public int getHumidityFromWeb() {
		return this.number;
	}

	public void setHumidityFromWeb(int num) {
		this.number = num;
	}
	
	public void setMagnitude(int num) {
		this.number = num;
	}

	public String readProp(String a_key) throws Exception {
		try {
			String w_value = "";
			Properties w_prop = new Properties();
			InputStream w_input = null;
			w_input = new FileInputStream(System.getProperty("user.dir") + "\\Resources\\system.properties");
			w_prop.load(w_input);
			w_value = w_prop.getProperty(a_key);
			return w_value;

		} catch (Exception e) {
			throw e;
		}
	}
	
	public int getMagnitude() {
		return this.number;
	}


}
