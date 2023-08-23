package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class CustomFieldsPage extends ProjectSpecificMethods{
	public CustomFieldsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Team member page objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Custom Fields')]")
	private WebElement eleCustomFieldsMenu;	
	
	@FindBy(how=How.XPATH,using="(//div[contains(text(),'Field Name')]//following::div/div[1]/button[1])[1]")
	private WebElement eleAddCustomFields;
	
	@FindBy(how=How.ID,using="CustomFields_label")
	private WebElement eleCustomFieldName;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Short Answer')]//following::label[1]//span[1]//input[1]")
	private WebElement eleShortAnswerYes;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Short Answer')]//following::label[2]//span[1]//input[1]")
	private WebElement eleShortAnswerNo;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Add Custom Fields')]//following::button[1]")
	private WebElement eleAddCustomeFieldsAfterEnteringValue;

	@FindBy(how=How.XPATH,using="//div[contains(text(),'Do you want to delete this Custom Field ?')]//following::button[1]")
	private WebElement eleConfirmDeleteCustomeFields;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search Custom Fields']")
	private WebElement eleSearchCustomeFields;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Please check!')]")
	private WebElement eleValidatePleaseChecktext;
	
	/*	=====================================Team Members methods starts===================================================================*/
	public void clickOnCustomFieldMenu() {
		click(eleCustomFieldsMenu,"Custom Menu");
	}
	
	public void clickOnAddNewCustomFields() {
		click(eleAddCustomFields,"AddCustom");
	}
	
	public void enterCustomFieldName(String fieldName) {
		clearAndTypeWithTagName(eleCustomFieldName, fieldName, "CustomeName field");
	}
	
	public void clickOnShortAnsweryes() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(eleShortAnswerYes).click().build().perform();
		reportStep("The Short Answer yes clicked Successfully", "pass", false);
	}
	
	public void clickOnShortAnswerNo() {
		Actions action=new Actions(driver);
		action.moveToElement(eleShortAnswerNo).click().build().perform();
		reportStep("The Short Answer No clicked Successfully", "pass", false);
	}
	
	public void clickOnAddCustomeFieldAfterEnteringValue() {
		click(eleAddCustomeFieldsAfterEnteringValue, "Add Button");
	}
	
	public void enterSearchCustomFields(String fieldName) {
		clearAndTypeWithTagName(eleSearchCustomeFields, fieldName, "CustomeName field");
	}
	
	public void clickOnDeleteCustomeField(String customFieldsName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'"+customFieldsName+"')]//following::button[1]"))));
		driver.findElement(By.xpath("//div[contains(text(),'"+customFieldsName+"')]//following::button[1]")).click();	
	}
	
	public void clickOnConfirmDeleteCustomeField() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(text(),'Do you want to delete this Custom Field ?')]//following::button[1]"))));
		click(eleConfirmDeleteCustomeFields, "Confirm Delete");
	}
	
	public String validateAddedCustomFields(String customFieldsName) {
		String addedPerson=driver.findElement(By.xpath("//div[contains(text(),'"+customFieldsName+"')]")).getText();
		 return addedPerson;
	}
	
	public String validateCustomFieldtext(String validationtext) {
		WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'"+validationtext+"')]"));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		return getElementText(ele);
	}
	
}
