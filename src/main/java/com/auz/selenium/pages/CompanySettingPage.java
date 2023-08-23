package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class CompanySettingPage extends ProjectSpecificMethods{
	public  String strtestdatafilename="UiTestData";
	public CompanySettingPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	@FindBy(how=How.ID,using="Basics_companyWebsite")
	private WebElement eleCompanyWebsite;	
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/form/div/button[1]")
	private WebElement eleUpdate;	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Departments')]")
	private WebElement eleDepartment;	
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/div/div/button[1]")
	private WebElement eleAddDepartment;
	
	@FindBy(how=How.ID,using="Department_departmentName")
	private WebElement eleEnterDepartmentName;
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/form/div/div[2]/button[1]")
	private WebElement eleAddButton;
	
	/*	=====================================Location page objects starts===================================================================*/

	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Locations')]")
	private WebElement eleLocationMenu;	
	
	@FindBy(how=How.XPATH,using="//div[@id='hireApp']//following::div/div/div/div/div/div[2]/button[1]")
	private WebElement eleAddLocation;	
	
	@FindBy(how=How.ID,using="Location_zipcode")
	private WebElement eleZipCode;	
	
	@FindBy(how=How.XPATH,using="//body//section//button[2]")
	private WebElement eleAddCountryStateCityLocationButton;	
	
	@FindBy(xpath="//div[contains(text(),'Please select a country!')]")
	public WebElement eleSelectCountryError;
	
	@FindBy(xpath="//div[contains(text(),'Please select a state!')]")
	public WebElement eleSelectStateError;
	
	@FindBy(xpath="//div[contains(text(),'Please select a city!')]")
	public WebElement eleSelectCityError;
	
	@FindBy(xpath="//div[contains(text(),'Zipcode is required!')]")
	public WebElement eleSelectZipcodeError;
	
	@FindBy(xpath="//h4[contains(text(),'Fayzabad, Badakhshan, Afghanistan')]")
	public WebElement eleValidateAddedLocation;
	
	/*	=====================================Tags page objects starts===================================================================*/
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Tags')]")
	private WebElement eleTagsMenu;	
	
	@FindBy(how=How.XPATH,using="(//span[contains(text(),'Tags')]//following::div/div/div/div/div[1]/button[1])[2]")
	private WebElement eleAddTags;
	
	@FindBy(how=How.ID,using="Tags_tagName")
	private WebElement eleToEnterTagName;
	
	@FindBy(how=How.XPATH,using="//input[@id='Tags_tagName']//following::div[1]/button[1]")
	private WebElement eleToClickAddAfterTagsValueEntered;
	
	@FindBy(xpath="//h4[contains(text(),'meetExpectations')]")
	public WebElement eleValidateAddedTag;
	
	/*	=====================================Department menu methods starts===================================================================*/

	public void enterCompanyWeSite(String strCompnayWebsite) {
		clearAndTypeWithTagName(eleCompanyWebsite, strCompnayWebsite, "CompanyWebsite");
	}
	
	public void clickOnBasicUpdateButton() {
		click(eleUpdate, "Update");
	}
	
	public void clickOnDepartment() throws InterruptedException {
		waitForElementLoad(2000);
		Actions actions =new Actions(driver);
		WebElement subMenu = driver.findElement(By.xpath("//div[contains(text(),'Departments')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
	}   
	
	public void clickOnAddDepartment() {
		click(eleAddDepartment, "AddDepartment");
	}
	
	public void enterDepartmentName(String strDepartmentName) {
		clearAndTypeWithTagName(eleEnterDepartmentName, strDepartmentName, "DepartmentName");
	}
	public void clickOnAddButton() {
		click(eleAddButton, "AddButton");
	}
	
	public void clickOnEditButton(String departmentName) throws InterruptedException {
		Actions actions =new Actions(driver);
		WebElement subMenu = driver.findElement(By.xpath("//h4[contains(text(),'"+departmentName+"')]//following::ul[1]//li[1]//button[1]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		waitForElementLoad(2000);
		reportStep("The Element " + departmentName + " clicked", "pass", false);
	}
	public void clickUpdateDepartmentButton() {
		driver.findElement(By.xpath("//input[@id='Department_departmentName']//following::div/button[1]")).click();
		reportStep("The Update button clicked successfullt", "pass", false);
	}
	
	
	public void clickOnDeleteButton(String departmentName) {
		WebElement ele=driver.findElement(By.xpath("//h4[contains(text(),'"+departmentName+"')]//following::ul[1]//li[2]//button[1]"));
		clickBySingleAction(ele, "Delete");
		reportStep("The Element " + departmentName + " clicked on Edit Button", "pass", false);
	}
	
	public void clickOnConfirmDeleteButton(String departmentName) throws InterruptedException {
		driver.findElement(By.xpath("//h4[contains(text(),'"+departmentName+"')]//following::div[1]//div[3]//div/button[1]")).click();
		Thread.sleep(5000);
		reportStep("The Element " + departmentName + " clicked on Delete Button", "pass", false);
	}
	
	public String validateDepartmentAdded(String departmentName) {
		String strdepartmentName=driver.findElement(By.xpath("//h4[contains(text(),'"+departmentName+"')]")).getText();
		return strdepartmentName;
		
	}
	
/*	=====================================Location menu methods starts===================================================================*/
	public void clickOnLocationMenu() {
		click(eleLocationMenu,"LocationMenu");
	}
	
	public void clickOnAddLocation() {
		click(eleAddLocation,"AddLocation");
	}
	
	public void enterZipcode(String zipcode) {
		clearAndTypeWithTagName(eleZipCode, zipcode, "Zipcode");
		
	}
	public void selectCountry(String strCountry) {
		driver.findElement(By.xpath("//div[contains(text(),'Select Country')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strCountry + "')]")).click();
		reportStep("The country :" + strCountry + " selected Successfully", "pass");
	}
	
	public void selectState(String strState) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strState + "')]")).click();
		reportStep("The state :" + strState + " selected Successfully", "pass");
	}
	
	public void selectCity(String strCity) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strCity + "')]")).click();
		reportStep("The state :" + strCity + " selected Successfully", "pass");
	}
	
	public void clickOnAddLocationAfterFeedingCountry() throws InterruptedException {
		click(eleAddCountryStateCityLocationButton, "Add");
		waitForElementLoad(2000);
	}
	
	public void clickOnEditLocationButton(String locationName) throws InterruptedException {
		waitForElementLoad(2000);
		Actions actions =new Actions(driver);
		WebElement subMenu = driver.findElement(By.xpath("//h4[contains(text(),'"+locationName+"')]//following::ul[1]//li[1]//button[1]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		waitForElementLoad(2000);
		reportStep("The Element " + locationName + " clicked", "pass", false);
	}
	
	public void clickOnDeleteLocationButton(String locationname) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//h4[contains(text(),'"+locationname+"')]//following::ul[1]//li[2]//button[1]")).click();
		reportStep("The Element " + locationname + " clicked on Edit Button", "pass", false);
	}
	
	public void clickOnLocationConfirmDeleteButton(String locationName) throws InterruptedException {
		driver.findElement(By.xpath("//h4[contains(text(),'"+locationName+"')]//following::div//div//div//div//button[1]")).click();
		waitForElementLoad(4000);
		reportStep("The Element " + locationName + " clicked on Delete Button", "pass", false);
	}
	
	public String validateCountryErrorText() {
		String countryerror= getElementText(eleSelectCountryError);
		 return countryerror;
	}

	public String validateStateErrorText() {
		String stateerror= getElementText(eleSelectStateError);
		 return stateerror;
	}
	
	public String validateCityErrorText() {
		String cityerror= getElementText(eleSelectCityError);
		 return cityerror;
	}
	
	public String validateZipcodeErrorText() {
		String zipcodeerror= getElementText(eleSelectZipcodeError);
		 return zipcodeerror;
	}
	
	public String validateAddedLocation() {
		String addedLocation= getElementText(eleValidateAddedLocation);
		 return addedLocation;
	}
	
	/*	=====================================Tags menu methods starts===================================================================*/
	public void clickOnTagsMenu() {
		click(eleTagsMenu,"TagsMenu");
	}
	
	public void clickOnAddTags() {
		click(eleAddTags,"AddTag");
	}
	
	public void enterTagsName(String tagName) {
		clearAndTypeWithTagName(eleToEnterTagName, tagName, "TagValueAdding Button");
	}
	
	public void clickAddAfterTagsValueEntered() {
		click(eleToClickAddAfterTagsValueEntered,"AddTag Button");
	}
	
	public void clickOnDeleteTagsButton(String tagName) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//h4[contains(text(),'"+tagName+"')]//following::ul[1]//li[1]//button[1]")).click();
		reportStep("The Element " + tagName + " clicked on Delete Button", "pass", false);
	}
	
	public void clickOnTagConfirmDeleteButton(String tagName) throws InterruptedException {
		driver.findElement(By.xpath("//h4[contains(text(),'"+tagName+"')]//following::div[1]//div[3]/div[1]/button[1]")).click();
		waitForElementLoad(4000);
		reportStep("The Element " + tagName + " clicked on Delete Button", "pass", false);
	}
	public String validateAddedTag() {
		String addedTag= getElementText(eleValidateAddedTag);
		 return addedTag;
	}
}
