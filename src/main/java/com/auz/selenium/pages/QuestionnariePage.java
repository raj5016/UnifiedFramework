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

public class QuestionnariePage extends ProjectSpecificMethods{
	public QuestionnariePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================QuestionnariePage Objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Questionnaire')]")
	private WebElement eleQuestionnaireMenu;	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Questionnaire')]//following::main/div/div/div/div/div/div/button[1]")
	private WebElement eleAddNewQuestionnaire;
	
	@FindBy(how=How.ID,using="Questionnaire_name")
	private WebElement eleToenterQuestionnaireName;
	
	@FindBy(how=How.XPATH,using="//div[@id='formFieldDetails_type']//div//span//i//*[local-name()='svg']")
	private WebElement eleToSelectAddQuestion;
	
	@FindBy(how=How.ID,using="formFieldDetails_label")
	private WebElement eleEnterQuestion;
	
	@FindBy(how=How.XPATH,using="//*[@id='formFieldDetailsForm 1']/div/div/div/button[2]")
	private WebElement eleToClickOnAddQuestion;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Questionnaire')]//following::main/div/div/div/div/div/div/button[2]")
	private WebElement eleToClickOnAddAndUpdateButtonQuestionnaire;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Do you want to delete this questionnaire ?')]//following::div[1]//div//button[1]")
	private WebElement eleToClickOnConfirmDeleteQuestionnaire;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Do you want to delete this questionnaire ?')]//following::div[1]//div//button[1]")
	private WebElement eleToMouseOverInAddedQuestionname;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Are you sure you want to delete this Question?')]//following::button[2]")
	private WebElement eleToClickOnConfirmDeleteQuestionType;
	
	@FindBy(how=How.XPATH,using="//html//body//div//div//div//div//div//div//section//main//div//div//div//div//div//div//div//div//button")
	private WebElement eleToClickOnAddAfterConfirmDeleteOfQuestionType;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'name is required!')]")
	private WebElement eleToValidateErrorTextOfNameField;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Question is required!')]")
	private WebElement eleToValidateErrorTextOfQuestionField;
	
	@FindBy(how=How.XPATH,using="//form[@id='formFieldDetailsForm 1']//div//div//div//div//div//div//div//div//div//div//span//button")
	private WebElement eleToclickOnAddAnswer;
	
	@FindBy(how=How.ID,using="formFieldDetails_options[1]")
	private WebElement eleToenterOptionalAnswer1;
	
	@FindBy(how=How.ID,using="formFieldDetails_options[2]")
	private WebElement eleToenterOptionalAnswer2;

	/*	=====================================Questionnare methods starts===================================================================*/
	public void clickOnQuestionnaireMenu() {
		click(eleQuestionnaireMenu,"QuestionnaireMenu");
	}
	
	public void clickOnAddNewQuestionnaire() throws InterruptedException {
		click(eleAddNewQuestionnaire,"Add New Questionnaire");
	}
	
	public void enterQuestionnaireName(String questionareName) {
		clearAndTypeWithTagName(eleToenterQuestionnaireName, questionareName, "QuestionnaireName");
	}
	
	public void selectAddQuestionType(String questionType) {
		click(eleToSelectAddQuestion,"Select Tag for AddQuestionType");
		driver.findElement(By.xpath("//li[contains(text(),'"+questionType+"')]")).click();
		reportStep("Question type select tag selected successfully", "pass");
	}
	
	public void enterAddQuestion(String question) {
		clearAndTypeWithTagName(eleEnterQuestion, question, "Add question");
	}
	
	public void clickOnAddQuestion() {
		click(eleToClickOnAddQuestion,"Add Question");
		waitForElementLoad(2000);
	}
	
	public void clickOnAddAndUpdateButtonQuestionnaire() {
		click(eleToClickOnAddAndUpdateButtonQuestionnaire, "AddQuestionnaire");
	}
	
	public void clickOnEditQuestionnaire(String questionnarename) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+questionnarename+"')]//following::ul[1]//li[1]//button[1]")).click();
		reportStep("Clicked on questionnare edit button", "pass");
	}
	
	public void clickOnDeleteQuestionnaire(String questionnarename) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+questionnarename+"')]//following::ul[1]//li[2]//button[1]")).click();
		reportStep("Clicked on questionnare delete button", "pass");
	}
	
	public void clickOnConfirmDeleteQuestionnaire() {
		click(eleToClickOnConfirmDeleteQuestionnaire, "DeleteQuestionnaire");
	}
	
	public String validateAddedQuestionareeName(String addedName) {
		return driver.findElement(By.xpath("//h4[contains(text(),'"+addedName+"')]")).getText();
	}
	public void clickOnEditAddQuestionType(String questionName) {
		WebElement addedQuestionName=driver.findElement(By.xpath("//div[contains(text(),'"+questionName+"')]"));
		Actions action=new Actions(driver);
		action.moveToElement(addedQuestionName).build().perform();
		driver.findElement(By.xpath("//div[contains(text(),'"+questionName+"')]//following::*[local-name()='svg'][1]")).click();
		reportStep("Clicked on edit Question type", "pass");
	}
	public void clickOnDeleteAddQuestionType(String questionName) {
		WebElement addedQuestionName=driver.findElement(By.xpath("//div[contains(text(),'"+questionName+"')]"));
		Actions action=new Actions(driver);
		action.moveToElement(addedQuestionName).build().perform();
		driver.findElement(By.xpath("//div[contains(text(),'"+questionName+"')]//following::*[local-name()='svg'][2]")).click();
		reportStep("Clicked on edit Question type", "pass");
	}
	
	public void clickOnConfirmDeleteQuestionType() {
		click(eleToClickOnConfirmDeleteQuestionType, "DeleteQuestion Type");
	}
	
	public void clickOnAddAfterConfirmDeleteOfQuestionType() {
		click(eleToClickOnAddAfterConfirmDeleteOfQuestionType, "AddQuestion");
	}
	
	public String validateErrorTextOfQuestionField() {
		return  getElementText(eleToValidateErrorTextOfQuestionField);
	}
	public String validateQuestionnareDeleteText(String validationText) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+validationText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
		}
	public String validateQuestionnareRequiredText(String validationText) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+validationText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
	
	public void clickOnAddAnswer() {
		click(eleToclickOnAddAnswer, "Add Answer");
	}
	
	public void enterOptionalAnswer1() {
		clearAndType(eleToenterOptionalAnswer1, "OptionalAnswer1");
	}
	
	public void enterOptionalAnswer2() {
		clearAndType(eleToenterOptionalAnswer2, "OptionalAnswer2");
	}
	
	public String validateOptionalFieldErrorText(String optionalFieldErrorText) {
		WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'"+optionalFieldErrorText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
	public String validatetwoOptionalMandatoryErrorText(String optionalmandatoryerrortext) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+optionalmandatoryerrortext+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
}
