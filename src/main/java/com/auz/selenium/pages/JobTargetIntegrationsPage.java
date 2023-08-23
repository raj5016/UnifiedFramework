package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.aventstack.extentreports.ExtentTest;

public class JobTargetIntegrationsPage extends ProjectSpecificMethods {

	public JobTargetIntegrationsPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//iframe[@title='JobTarget']")
	public WebElement eleToSwitchFrame;

	@FindBy(how = How.XPATH, using = "//div[@id='cart-container']//following::a/i")
	public WebElement eleTocartContainer;

	@FindBy(how = How.XPATH, using = "(//a[text()='Next Step'])[1]")
	public WebElement eleTocartContainerNeXtStep;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Status *']//following::div[1]/select")
	public WebElement eleToselectJobStatus;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Country *']//following::div/select")
	public WebElement eleToselectCountry;
	
	@FindBy(how = How.XPATH, using = "//label[text()='State *']//following::div/select")
	public WebElement eleToselectState;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Application Method *']//following::div/select")
	public WebElement eleToselectApplicationMethod;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='City']")
	public WebElement eleToenterCity;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Next Step - Review Order']")
	public WebElement eleToClickOnNextStepReviewOrder;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billingName']")
	public WebElement eleToEnterBillingName;
	
	@FindBy(how = How.ID, using = "ccNum")
	public WebElement eleToEnterCcNumber;
	
	@FindBy(how = How.ID, using = "exp_month")
	public WebElement eleToSelectExpiryMonth;
	
	@FindBy(how = How.ID, using = "exp_year")
	public WebElement eleToSelectExpiryYear;
	
	@FindBy(how = How.XPATH, using = "//input[@name='ccv2']")
	public WebElement eleToEnterCvv;
	
	@FindBy(how = How.ID, using = "country")
	public WebElement eleToSelectBillingCountry;
	
	@FindBy(how = How.ID, using = "address")
	public WebElement eleToEnterBillingAddress;
	
	@FindBy(how = How.ID, using = "city")
	public WebElement eleToEnterBillingCity;
	
	@FindBy(how = How.ID, using = "state")
	public WebElement eleToBillingState;
	
	@FindBy(how = How.ID, using = "zipcode")
	public WebElement eleToEnterBillingZipCode;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Confirm Payment']")
	public WebElement eleToClickOnConfirmPayment;
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Apply URL']")
	public WebElement eleToEnterLinkedinAppUrl;
	
	public void scrollBottom(WebDriver driver) {
		waitForElementLoad(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3500)");
}
	
	public void switchtoFrameInJobTargetIntegrationPage() {
		switchToFrame(0);
		waitForElementLoad(8000);
	}
	
	public void clickOnAddCartOnSite(String siteName) {
		WebElement ele=driver.findElement(By.xpath("(//img[@alt='"+siteName+"']//following::a[1])[1]"));
		waitForElementLoad(5000);
		click(ele, siteName+" Add cart");
	}
	
	public void clickOnCartContainer() {
		waitForElementLoad(3000);
		click(eleTocartContainer, "Cart");
	}
	
	public void clickOnNextStepInCartContainer() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleTocartContainerNeXtStep));
		click(eleTocartContainerNeXtStep, "NextStep");
	}
	
	public void selectJobStatus(String jobStatus) {
		selectDropDownUsingText(eleToselectJobStatus, jobStatus);
	}
	
	public void enterCity(String city) {
		clearAndType(eleToenterCity, city);
	}
	
	public void selectCountry(String country) {
		selectDropDownUsingText(eleToselectCountry, country);
	}
	
	public void selectState(String state) {
		selectDropDownUsingText(eleToselectState, state);
	}
	
	public void selectApplicationMethod(String applicationmethod) {
		selectDropDownUsingText(eleToselectApplicationMethod, applicationmethod);
	}
	

	public void switchtoWindow(int index) {
		switchToWindow(index);
		waitForElementLoad(6000);
	}
	
	public void clickOnNextStepReviewOrder() {
		//click(eleToClickOnNextStepReviewOrder, "NextStep-ReviewOrder");
		clickBySingleAction(eleToClickOnNextStepReviewOrder, "NextStep-ReviewOrder");
		waitForElementLoad(6000);
	}
	
	public void selectMultiIndustries() {
		WebElement select1 = driver.findElement(By.xpath("//option[@value='343499']"));
        WebElement select2 = driver.findElement(By.xpath("//option[@value='343500']"));
        WebElement select3 = driver.findElement(By.xpath("//option[@value='343501']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(select1).click(select2).click(select3).build().perform();
	}
	

	public void selectMultiCategories() {
		WebElement select1 = driver.findElement(By.xpath("//option[@value='60370']"));
        WebElement select2 = driver.findElement(By.xpath("//option[@value='60372']"));
        WebElement select3 = driver.findElement(By.xpath("//option[@value='60373']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(select1).click(select2).click(select3).build().perform();
	}
	
	public void selectMultiOccupations() {
		WebElement select1 = driver.findElement(By.xpath("//option[@value='646519']"));
        WebElement select2 = driver.findElement(By.xpath("//option[@value='646520']"));
        WebElement select3 = driver.findElement(By.xpath("//option[@value='646521']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(select1).click(select2).click(select3).build().perform();
	}
	
	public void enterBillingname(String name) {
		/*
		 * wait = new WebDriverWait(driver, 30);
		 * wait.until(ExpectedConditions.visibilityOf(eleToEnterBillingName));
		 * clearAndTypeWithTagName(eleToEnterBillingName, name,"BillingName");
		 */
		driver.findElement(By.xpath("//input[@name='billingName']")).sendKeys(name);
	}
	
	public void enterCCNumber(String ccnumber) {
		clearAndTypeWithTagName(eleToEnterCcNumber, ccnumber,"CCNUMBER");
	}
	public void selectExpiryMonth(int expirymonth) {
		selectDropDownUsingIndex(eleToSelectExpiryMonth, expirymonth);
		waitForElementLoad(1000);
	}
	public void selectExpiryYear(int expiryYear) {
		selectDropDownUsingIndex(eleToSelectExpiryYear, expiryYear);
	}
	public void enterCVV(String ccv) {
		clearAndType(eleToEnterCvv, ccv);
	}

	public void selectBillingCountry(String billingcountry) {
		selectDropDownUsingText(eleToSelectBillingCountry, billingcountry);
	}
	
	public void enterBillingAddress(String billingaddress) {
		clearAndType(eleToEnterBillingAddress, billingaddress);
	}
	public void enterBillingCity(String billingCity) {
		clearAndType(eleToEnterBillingCity, billingCity);
	}
	
	public void enterBillingState(String billingstate) {
		clearAndType(eleToBillingState, billingstate);
	}
	
	public void enterBillingZipCode(String zipcode) {
		clearAndType(eleToEnterBillingZipCode, zipcode);
	}
	
	public void selectBillingState(int billingstate) {
		selectDropDownUsingIndex(eleToBillingState, billingstate);
	}
	
	public void clickonconfirmPayment() {
		click(eleToClickOnConfirmPayment, "confirm payment");
		waitForElementLoad(4000);
		enterBillingname(RandomGenerator.randomName());
		click(eleToClickOnConfirmPayment, "confirm payment");
		waitForElementLoad(5000);
		close();
	}
	public void clickonconfirmPaymentOnLinkedIn() {
		click(eleToClickOnConfirmPayment, "confirm payment");
		waitForElementLoad(4000);
	}
	
	public void switchtoWindowAndCloseBrowser(int index) {
		switchToWindow(index);
		waitForElementLoad(1000);
		close();
	}
	
	public void enterAppUrl(String url) {
		clearAndTypeWithTagName(eleToEnterLinkedinAppUrl, url, "AppUrl");
	}
	
	
}
