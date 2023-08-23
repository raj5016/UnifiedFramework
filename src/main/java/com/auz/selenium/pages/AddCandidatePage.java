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


public class AddCandidatePage extends ProjectSpecificMethods{

	public AddCandidatePage(RemoteWebDriver driver,ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}		

	@FindBy(id="candidateDetailsForm_firstName")
	public WebElement eleFirstNameOfCandidate;
	
	public By byEleCandidateSource=By.id("candidateDetailsForm_source");
	
	@FindBy(id="candidateDetailsForm_mobileNo")
	public WebElement eleMobileNumberOfCandidate;
	
	@FindBy(id="candidateDetailsForm_currentLocation")
	public WebElement eleCurrentLocationOfCandidate;
	
	@FindBy(xpath="//input[@placeholder='LinkedIn URL']")
	public WebElement eleLinkedinUrl;
	
	@FindBy(id="candidateDetailsForm_email")
	public WebElement eleCandidateEmail;
	
	@FindBy(id="candidateDetailsForm_currentCompany")
	public WebElement eleCandidateCurrentCompany;
	
	@FindBy(id="candidateDetailsForm_currentDesignation")
	public WebElement eleCandidateDesgination;
	
	@FindBy(xpath="//span[contains(text(),'Mandatory Fields')]//following::button[1]")
	public WebElement eleAddCandidate;
	
	@FindBy(xpath="//body//button//div[1]")
	public WebElement eleAddJobToCandidate;
	
	@FindBy(xpath="//body//div//div//div//div//div//div//div//div//button[2]")
	public WebElement eleAddJobSelectedToCandidate;
	
	@FindBy(xpath="//body//div[@id='candidateDetailsForm_uploadFiles']//div//div//div//div[1]")
	public WebElement eleAddResumeToCandidate;
	
	@FindBy(xpath="//div[contains(text(),'First Name is required!')]")
	public WebElement eleValidateFirstNameError;
	
	@FindBy(xpath="//div[contains(text(),'Source is required!')]")
	public WebElement eleValidateSourceError;
	
	@FindBy(xpath="//span[contains(text(),'Move to Stage:')]")
	public WebElement elemouseOverToMoveToStage;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Added')]//following::button[1]")
	public WebElement eleToClickOnSendEmailUnderCandidateProfile;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'This action hasn')]//following::button[1]")
	public WebElement eleToClickOnMoveWithoutAction;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'This action hasn')]//following::button[2]")
	public WebElement eleToClickOnProceedStage;
	
	public void enterCandidateLinkedinUrl(String strLinkedinUrl) {
		clearAndTypeWithTagName(eleLinkedinUrl, strLinkedinUrl, "linkedInUrl");
		}
	
	public void enterCandidateName(String strfirstname) {
		clearAndTypeWithTagName(eleFirstNameOfCandidate, strfirstname, "FirstName");
		}
	
	public void selectCandidateSource(String strSource) {
		driver.findElement(byEleCandidateSource).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+strSource+"')]")).click();
		reportStep("The JobDepartment :" + strSource + " selected Successfully", "pass");
	}
	
	public void enterCandidateMobileNumber(String strmobileNumbers) {
		clearAndTypeWithTagName(eleMobileNumberOfCandidate,strmobileNumbers,"MobileNumber");
	}
	
	public void enterCandidateEmail(String strEmail) {
		clearAndTypeWithTagName(eleCandidateEmail,strEmail,"Email");
	}
	
	public void enterCandidateCurrentCompany(String strCompany) {
		clearAndTypeWithTagName(eleCandidateCurrentCompany,strCompany,"CurrentCompany");
	}
	
	public void enterCandidateCurrentDesgination(String strDesgination) {
		clearAndTypeWithTagName(eleCandidateDesgination,strDesgination,"CurrentDesgination");
	}
	
	public void clickAddCandidateButton() throws InterruptedException {
		click(eleAddCandidate,"AddcandidateButton");
		waitForElementLoad(7000);
	}
	
	public void clickAddJobToCandidate() throws InterruptedException {
		click(eleAddJobToCandidate,"AddJob");
		driver.findElement(By.xpath("//h3[contains(text(),'Add Candidate')]//following::li[1]//div[1]//div[1]//label[1]//span[1]//input[1]")).click();
		click(eleAddJobSelectedToCandidate,"AddSelectedJobToCandidate");
	}
		
	public void clickAddCandidateResume(String fileName) {
		click(eleAddResumeToCandidate,"AddResume");
		waitForElementLoad(3000);
		uploadFile(fileName);
		waitForElementLoad(4000);
	}
	
	public String validateFirstNameErrorText() {
		String firstnameerror= getElementText(eleValidateFirstNameError);
		 return firstnameerror;
	}

	public String validateSourceErrorText() {
		String firstnameerror= getElementText(eleValidateSourceError);
		 return firstnameerror;
	}

	public void selectStages(String stageaction) {
		clickBySingleAction(elemouseOverToMoveToStage, "StageAction");
		driver.findElement(By.xpath("//li[contains(text(),'"+stageaction+"')]")).click();
		waitForElementLoad(2000);
	}
	
	public String validateCurrentStages(String stageaction) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//span[contains(text(),'"+stageaction+"')]")).getText();
	}
	
	public String validatePromptSatgeActionText(String promptactiontext) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+promptactiontext+"')]")).getText();
	}
	
	public void moveToSendEmailUnderCandidateProfile() {
		Actions action = new Actions(driver);
		action.moveToElement(eleToClickOnSendEmailUnderCandidateProfile).click().build().perform();
	}
	
	public void clickonMoveWithoutAction() {
		click(eleToClickOnMoveWithoutAction, "MoveWithoutAction");
		waitForElementLoad(2000);
	}
	public void clickonProceedStageAction() {
		click(eleToClickOnProceedStage, "Proceed");
		waitForElementLoad(2000);
	}
}










