package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class TemplatePage extends ProjectSpecificMethods{
	public TemplatePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Email Template Page Objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Templates')]")
	private WebElement eleTemplateMenu;	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Email Templates')]//following::div/button[1]")
	private WebElement eleAddNewTemplate;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Template Name']")
	private WebElement eleTemplateName;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Template Name']//following::p[1]")
	private WebElement eleEmailSubjectName;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Template Name']//following::p[2]")
	private WebElement eleEmailBody;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::button[1]")
	private WebElement eleCandidateFirstName;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::button[2]")
	private WebElement eleCandidateJobName;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::span//i//*[local-name()='svg']")
	private WebElement elePlaceHolderMouseOver;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::div/div/div/ul/li[1]/button[1]")
	private WebElement eleCandidateLastName;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::div/div/div/ul/li[2]/button[1]")
	private WebElement eleCandidateCompanyName;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Placeholders:')]//following::div[1]//button[2]")
	private WebElement eleEmailTemplateSave;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Search Templates']")
	private WebElement eleSearchTemplate;
	
	/*	=====================================Email templates methods starts===================================================================*/
	public void clickOnTemplateMenu() throws InterruptedException {
		click(eleTemplateMenu,"Template Menu");
		waitForElementLoad(2000);
	}
	
	public void clickOnAddNewTemplate() throws InterruptedException {
		waitForElementLoad(2000);
		click(eleAddNewTemplate,"Add New Template");
	}
	
	public void enterTemplateName(String templateName) {
		clearAndTypeWithTagName(eleTemplateName, templateName, "TemplateName field");
	}
	
	public void enterEmailSubject(String emailSubjectName) {
		clearAndTypeWithTagName(eleEmailSubjectName, emailSubjectName, "EmailSubject field");
	}
	
	public void enterEmailBody(String emailBody) {
		clearAndTypeWithTagName(eleEmailBody, emailBody, "EmailBody field");
	}
	
	public void clickOnCandidateNamePlaceHolder() {
		click(eleCandidateFirstName,"CANDIDATE_FIRST_NAME");
	}
	
	public void clickOnJobNamePlaceHolder() {
		click(eleCandidateJobName,"JOB_NAME");
	}
	
	public void clickOnCandidateLastNamePlaceHolder() throws InterruptedException {
		clickByAction(elePlaceHolderMouseOver, eleCandidateLastName, "CANDIDATE_LAST_NAME");
	}
	
	public void clickOnCandidateCompanyNamePlaceHolder() throws InterruptedException {
		clickByAction(elePlaceHolderMouseOver, eleCandidateCompanyName, "CANDIDATE_COMPNAY_NAME");
	}
	
	public void clickOnEmailTemplateSave() throws InterruptedException {
		click(eleEmailTemplateSave,"Save");
		waitForElementLoad(2000);
	}
	
	public String validateAddedEmailTemplate(String emailTemplateName) {
		String templateName=driver.findElement(By.xpath("//h4[contains(text(),'"+emailTemplateName+"')]")).getText();
		 return templateName;
	}
	
	public void clickOnEmailTemplateEdit(String emailTemplateName) throws InterruptedException {
		driver.findElement(By.xpath("//h4[contains(text(),'"+emailTemplateName+"')]//following::button[1]")).click();
		reportStep("The Email edit clicked Successfully", "pass", false);
		waitForElementLoad(2000);
	}
	
	public void clickOnDeleteEmailTemplate(String emailTemplateName) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//h4[contains(text(),'"+emailTemplateName+"')]//following::button[2]")).click();
		reportStep("Clicked On email Template deleted button", "pass", false);
	}
	
	public void clickOnConfirmDeleteEmailTemplate() throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Do you want to delete this template ?')]//following::div[1]//button[1]")).click();
		reportStep("Added Email Template deleted successfully", "pass", false);
	}
	public void SerachTemplateByName(String templateName) {
		clearAndTypeWithTagName(eleSearchTemplate, templateName, "Search field");
	}
	
	/*	=====================================Job Template Page Objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//div[contains(text(),'Job Templates')]")
	private WebElement eleJobTemplateMenu;
	
	@FindBy(how=How.XPATH,using="//section[1]/main[1]/div/div/div/div[2]/div/div/div/div/button[1]")
	private WebElement eleAddNewJobTemplate;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Template Name']")
	private WebElement eleJobTemplateName;
	
	@FindBy(how=How.XPATH,using="//label[contains(text(),'Job Description *')]//following::p")
	private WebElement eleJobDescription;
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/div/div/div/div/div/span/div/div/button[1]")
	private WebElement eleJobName;
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/div/div/div/button[2]")
	private WebElement eleSaveButton;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Job Templates')]//following::div//div//div[2]//div[1]//div[1]//span[1]//input[1]")
	private WebElement eleSearchJobTemplate;
	
	public void clickOnJobTemplateMenu() throws InterruptedException {
		click(eleJobTemplateMenu,"JobTemplate Menu");
		waitForElementLoad(2000);
	}
	
	public void clickOnAddNewJobTemplate() throws InterruptedException {
		click(eleAddNewJobTemplate,"AddNewJobTemplate");
		waitForElementLoad(1000);
	}
	public void enterJobTemplateName(String templateName) {
		clearAndTypeWithTagName(eleJobTemplateName, templateName, "TemplateName field");
	}
	
	public void enterJobDescriptionName(String jobdescription) {
		clearAndTypeWithTagName(eleJobDescription, jobdescription, "Job Description field");
	}
	
	public void ClickOnJobName() {
		click(eleJobName,"Jobname");
	}
	
	public void ClickOnJobSaveButton() throws InterruptedException {
		click(eleSaveButton,"Save");
		waitForElementLoad(2000);
	}

	public String validateAddedJobTemplate(String jobTemplateName) {
		String templateName=driver.findElement(By.xpath("//h4[contains(text(),'"+jobTemplateName+"')]")).getText();
		 return templateName;
	}
	public void clickOnJobTemplateEdit(String jobTemplateName) throws InterruptedException {
		waitForElementLoad(1000);
		driver.findElement(By.xpath("//h4[contains(text(),'"+jobTemplateName+"')]//following::button[1]")).click();
		reportStep("The JobTemplate edit clicked Successfully", "pass", false);
		waitForElementLoad(1000);
	}
	
	public void clickOnJobTemplateDelete(String jobTemplateName) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//h4[contains(text(),'"+jobTemplateName+"')]//following::button[2]")).click();
		reportStep("The JobTemplate delete clicked Successfully", "pass", false);
	}
	
	public void clickOnConfirmDeleteJobTemplate() throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Do you want to delete this template ?')]//following::div[1]//button[1]")).click();
		reportStep("Added Email Template deleted successfully", "pass", false);
	}
	public void SerachJobTemplateByName(String templateName) {
		clearAndTypeWithTagName(eleSearchJobTemplate, templateName, "Search field");
	}
	public String validateEmailAndJobTemplateErrorText(String emailTemplateErrorText) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),\""+emailTemplateErrorText+"\")]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
	public String validateEmailTemplateDeleteText(String emailDeleteText) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+emailDeleteText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
		 
	}
}
