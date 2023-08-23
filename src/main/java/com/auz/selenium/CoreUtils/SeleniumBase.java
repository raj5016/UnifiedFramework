package com.auz.selenium.CoreUtils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.auz.SupportedUtils.Constants;
import com.auz.SupportedUtils.Reporter;
import com.auz.SupportedUtils.lib;

public class SeleniumBase extends Reporter implements Browser, Element {

	public RemoteWebDriver driver;
	public WebDriverWait wait;
	//String environment = lib.readEnvironmentData();
	String environment="STAGING";
	public RemoteWebDriver startApp(String browser, boolean bRemote) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// For running in Distributed Grid mode
			if (bRemote) {
				System.out.println("Running in grid mode");
				driver = new RemoteWebDriver(
						new URL("http://" + Constants.HUBURL + ":" + Constants.HUBPORT + "/wd/hub"), dc);
			}
			// For running in local machine
			else {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				} else if (browser.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
			}
			driver.manage().window().maximize();
			if (environment.equalsIgnoreCase("STAGING")) {
				driver.navigate().to(Constants.STAGING_APPURL);
			} else {
				driver.navigate().to(Constants.TESTING_APPURL);
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return driver;

	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + idValue, "FAIL");
		}
	}

	int i = 1;

	@Override
	public void click(WebElement ele) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element " + text + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			text = ele.getText();
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			reportStep("The Element with text: " + text + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + ele + " could not be clicked", "fail");
			throw new RuntimeException();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	@Override
	public void append(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	@Override
	public void clear(WebElement ele) {
		try {
			ele.clear();
			reportStep("The field is cleared Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The field is not Interactable", "fail");
			throw new RuntimeException();
		}
	}

	@Override
	public void clearAndType(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :" + data + " entered Successfully", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	@Override
	public void clearAndTypeWithTagName(WebElement ele, String data, String tagName) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The Data :" + data + " entered Successfully in " + tagName + " field", "pass");
		} catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable", "fail");
			throw new RuntimeException();
		}

	}

	@Override
	public String getElementText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public String getBackgroundColor(WebElement ele) {
		String cssValue = ele.getCssValue("color");
		return cssValue;
	}

	@Override
	public String getTypedText(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		new Select(ele).selectByVisibleText(value);
		reportStep("The value selected successfully", "pass");
	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		new Select(ele).selectByIndex(index);
		reportStep("The value selected successfully", "pass");
	}

	@Override
	public void selectDropDownUsingValue(WebElement ele, String value) {
		new Select(ele).selectByValue(value);
		reportStep("The value selected successfully", "pass");
	}

	@Override
	public boolean verifyExactText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().equals(expectedText)) {
				reportStep("The expected text contains the actual " + expectedText, "pass");
				return true;
			} else {
				reportStep("The expected text doesn't contain the actual " + expectedText, "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	@Override
	public boolean verifyPartialText(WebElement ele, String expectedText) {
		try {
			if (ele.getText().contains(expectedText)) {
				reportStep("The expected text contains the actual " + expectedText, "pass");
				return true;
			} else {
				reportStep("The expected text doesn't contain the actual " + expectedText, "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		}

		return false;
	}

	@Override
	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).equals(value)) {
				reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "pass");
				return true;
			} else {
				reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
						"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}
		return false;
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if (ele.getAttribute(attribute).contains(value)) {
				reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "pass");
			} else {
				reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
						"fail");
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Attribute Text");
		}

	}

	@Override
	public boolean verifyDisplayed(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				reportStep("The element " + ele + " is visible", "pass");
				return true;
			} else {
				reportStep("The element " + ele + " is not visible", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;

	}

	@Override
	public boolean verifyDisappeared(WebElement ele) {
		return false;

	}

	@Override
	public boolean verifyEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				reportStep("The element " + ele + " is Enabled", "pass");
				return true;
			} else {
				reportStep("The element " + ele + " is not Enabled", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return false;
	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				reportStep("The element " + ele + " is selected", "pass");
				// return true;
			} else {
				reportStep("The element " + ele + " is not selected", "fail");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		// return false;

	}

	/*
	 * @Override public RemoteWebDriver startApp(String url) { return
	 * startApp("chrome", url); }
	 */

	@Override
	public WebElement locateElement(String locatorType, String value) {
		try {
			switch (locatorType.toLowerCase()) {
			case "id":
				return driver.findElementById(value);
			case "name":
				return driver.findElementByName(value);
			case "class":
				return driver.findElementByClassName(value);
			case "link":
				return driver.findElementByLinkText(value);
			case "xpath":
				return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
			throw new RuntimeException();
		} catch (Exception e) {
			reportStep("The Element with locator:" + locatorType + " Not Found with value: " + value, "fail");
		}
		return null;
	}

	@Override
	public WebElement locateElement(String value) {
		WebElement findElementById = driver.findElementById(value);
		return findElementById;
	}

	@Override
	public List<WebElement> locateElements(String type, String value) {
		try {
			switch (type.toLowerCase()) {
			case "id":
				return driver.findElementsById(value);
			case "name":
				return driver.findElementsByName(value);
			case "class":
				return driver.findElementsByClassName(value);
			case "link":
				return driver.findElementsByLinkText(value);
			case "xpath":
				return driver.findElementsByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The Element with locator:" + type + " Not Found with value: " + value);
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public void switchToAlert() {
		driver.switchTo().alert();
	}

	@Override
	public void acceptAlert() {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert " + text + " is accepted.", "pass");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.", "fail");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	@Override
	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			System.out.println("The alert " + text + " is accepted.");
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}

	}

	@Override
	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("There is no alert present.");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : " + e.getMessage());
		}
		return text;
	}

	@Override
	public void typeAlert(String data) {
		driver.switchTo().alert().sendKeys(data);

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			String exWindow = allhandles.get(index);
			driver.switchTo().window(exWindow);
			System.out.println("The Window With index: " + index + " switched successfully");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With index: " + index + " not found");
		}
	}

	@Override
	public void switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			System.out.println("The Window With Title: " + title + "is switched ");
		} catch (NoSuchWindowException e) {
			System.err.println("The Window With Title: " + title + " not found");
		} finally {
			takeSnap();
		}
	}

	@Override
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	@Override
	public void switchToFrame(WebElement ele) {
		driver.switchTo().frame(ele);

	}

	@Override
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);

	}

	@Override
	public void defaultContent() {
		driver.switchTo().defaultContent();

	}

	@Override
	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: " + url + " matched successfully");
			return true;
		} else {
			System.out.println("The url: " + url + " not matched");
		}
		return false;
	}

	@Override
	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			reportRequest("Page title: " + title + " matched successfully", "pass");
			return true;
		} else {
			reportRequest("Page url: " + title + " not matched", "fail");
		}
		return false;
	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	@Override
	public void close() {
		driver.close();

	}

	@Override
	public void quit() {
		driver.quit();

	}

	public void clickByAction(WebElement mouseEle, WebElement actionEle, String field) throws InterruptedException {
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(mouseEle));
			Actions builder = new Actions(driver);
			builder.moveToElement(mouseEle).build().perform();
			waitForElementLoad(2000);
			builder.moveToElement(actionEle).click().build().perform();
			waitForElementLoad(2000);
			reportStep("The Element " + field + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + field + " Not clicked", "fail");
			throw new RuntimeException();
		}
	}
	
	public void clickBySingleAction(WebElement mouseEle,String field) {
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(mouseEle));
			Actions builder = new Actions(driver);
			builder.moveToElement(mouseEle).click().build().perform();
			reportStep("The Element " + field + " clicked", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + field + " Not clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void click(WebElement ele, String Field) {
		String text = "";
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			text = ele.getText();
			ele.click();
			reportStep("The Element " + text + " clicked in " + Field + "", "pass", false);
		} catch (StaleElementReferenceException e) {
			reportStep("The Element " + text + " could not be clicked", "fail");
			throw new RuntimeException();
		}
	}

	public void scrollBottom(WebDriver driver) {
			waitForElementLoad(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3500)");
	}

	public boolean waitforcomponent(WebDriver driver, WebElement eleofFirstCandidate, long lngWaitTime) {
		WebElement weElement = null;
		for (int i = 0; i <= lngWaitTime && weElement == null; i++) {
			try {
				Thread.sleep(1000);
				weElement = driver.findElement((By) eleofFirstCandidate);
			} catch (Exception e) {
				weElement = null;
			}
		}
		if (weElement == null)
			return false;
		else
			return true;
	}

	public static void updateTestRailResultAsPass(String testCaseId) {
		String payload = "{\"status_id\":\"1\"}";
		String requestUrl = "https://auzmorhr.testrail.io/index.php?/api/v2/add_result/" + testCaseId;
		sendPostRequest(requestUrl, payload);
	}

	public static void updateTestRailResultAsFail(String testCaseId) {
		String payload = "{\"status_id\":\"5\"}";
		String requestUrl = "https://auzmorhr.testrail.io/index.php?/api/v2/add_result/" + testCaseId;
		sendPostRequest(requestUrl, payload);
	}

	public static String sendPostRequest(String requestUrl, String payload) {
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			connection.setRequestProperty("Authorization",
					"Basic Z292aW5kYXJhakBhbWVyaWNhbi10ZWNobm9sb2d5Lm5ldDp3ZWxjb21lMTIz");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonString = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();
			connection.disconnect();
			return jsonString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
	public static String separateDigitsAndAlphabets(String str) 
    { 
        StringBuffer alpha = new StringBuffer(),  
        num = new StringBuffer(), special = new StringBuffer(); 
          
        for (int i=0; i<str.length(); i++) 
        { 
            if (Character.isDigit(str.charAt(i))) 
                num.append(str.charAt(i)); 
            else if(Character.isAlphabetic(str.charAt(i))) 
                alpha.append(str.charAt(i)); 
            else
                special.append(str.charAt(i)); 
        } 
       return num.toString();
    } 
	
	public void waitForElementLoad(int time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadFile(String filename) {
		try {
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "\\src\\test\\resources\\uploadfiles\\"+filename+".docx";
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e) {
			reportStep("Exception thrown while uploading file", "fail");
		}
	}
	
	public void uploadCSVFile(String filename) {
		try {
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "\\src\\test\\resources\\uploadfiles\\"+filename+".csv";
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}catch(Exception e) {
			reportStep("Exception thrown while uploading file", "fail");
		}
	}
	public void dragAndDropElement(WebElement source, WebElement target) {
		try {
		new Actions(driver).moveToElement(source)
        .pause(Duration.ofSeconds(1))
        .clickAndHold(source)
        .pause(Duration.ofSeconds(1))
        .moveByOffset(2, 0)
        .moveToElement(target)
        .moveByOffset(2,0)
        .pause(Duration.ofSeconds(1))
        .release().build().perform();
		reportStep("The Element from source is Moved to target Field", "pass");
		}catch(Exception e) {
			reportStep("The Element " + source + " could not be Moved to target", "fail");
		}
	}
	public void refreshBrowser() {
		driver.navigate().refresh();
	}
}
