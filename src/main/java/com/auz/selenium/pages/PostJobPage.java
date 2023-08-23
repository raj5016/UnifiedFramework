package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class PostJobPage extends ProjectSpecificMethods {

	public PostJobPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gettingStartedForm_title")
	public WebElement eleJobTitle;

	public By byEleDepartment = By.id("gettingStartedForm_departmentId");

	public By byEleJobLocation = By.id("gettingStartedForm_locationId");

	@FindBy(id = "gettingStartedForm_noOfVacancies")
	public WebElement eleJobNoOfOpening;

	public By byEleJobEmploymentTypes = By.id("gettingStartedForm_employmentTypes");

	public By byEleJobTeamMember = By.id("gettingStartedForm_recruiters");

	public By byEleJobTags = By.id("gettingStartedForm_tags");
	
	public By byEleScreeingquestype = By.id("formFieldDetails_type");

	public By byEleJobContinue = By.xpath("//span[contains(text(),'Continue')]");

	@FindBy(xpath = "//div[@data-placeholder='Describe the job details here!']")
	public WebElement eleJobDescription;

	@FindBy(id = "jobDescriptionForm_minExperience")
	public WebElement eleJobWorkExperience;

	public By byeleJobEducation = By.id("jobDescriptionForm_educationQualificationType");

	@FindBy(id = "jobDescriptionForm_minBudget")
	public WebElement eleJobMinAnnualSalary;

	@FindBy(id = "jobDescriptionForm_maxBudget")
	public WebElement eleJobMaxAnnualSalary;

	@FindBy(xpath = "//html//body//div//div//div//div//div//div//div//div//div//div//form//div//button")
	public WebElement eleJobContinueOnGettingStarted;

	@FindBy(xpath = "//div//div//div//div//div//div//div//div//div[2]//form[1]//div[3]//button[1]")
	public WebElement eleContinueOnJobDescription;

	@FindBy(xpath = "//span[contains(text(),'Screening Questions')]//following::button[1]")
	public WebElement eleClickOnAddScreeningQuestions;

	@FindBy(xpath = "//div[contains(text(),'Add Question')]//following::button[5]")
	public WebElement eleClickOnTextAddScreenQuestion;

	@FindBy(id = "formFieldDetails_label")
	public WebElement eleenterAddScreeningQuestion;

	@FindBy(xpath = "//span[contains(text(),'+ Add Screening Question')]//following::div[1]/div[1]/button[1]")
	public WebElement eleToclickOnContinueOnApplication;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/button[1]")
	public WebElement eleClickOnAddStageOfInterviewProcess;

	@FindBy(id = "interviewStage_title")
	public WebElement eleStageTitle;

	@FindBy(xpath = "//div[contains(text(),'Interviewer')]")
	public WebElement eleStageInterviewer;

	@FindBy(xpath = "//li[contains(text(),'automation')]")
	public WebElement eleSelectStageInterviewer;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/div/div/div/button[1]")
	public WebElement eleUpdateStage;

	@FindBy(xpath = "//div[contains(text(),'Hired')]//following::button[1]")
	public WebElement eleToClickOnSaveAndExitInInterviewProcess;

	@FindBy(xpath = "//div//div[4]//div[1]//label[1]//span[1]//input[1]")
	public WebElement eleJobExternalPublish;

	@FindBy(xpath = "//div[contains(text(),'Candidates will be able to apply via advertised jo')]//following::div[1]/button[1]")
	public WebElement eleToclickOnContinueInPublishjob;

	@FindBy(xpath = "//div[contains(@class,'ant-tabs-tab')][contains(text(),'Interview Process')]")
	public WebElement eleclickonInterviewProcessLink;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/div/div/div/div/i/*[local-name()='svg']")
	public WebElement eleclickOnEditIcon;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/form/div/button[1]")
	public WebElement eleclickOnSendEmail;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/p")
	public WebElement eleenterEmailSubject;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/div/p")
	public WebElement eleenterEmailBody;

	@FindBy(xpath = "//span[contains(text(),'Insert Questionnaire')]")
	public WebElement eleemailQuestionnaire;

	@FindBy(xpath = "//body[1]/div/div/div/ul/li")
	public WebElement eleClickonemailQuestionnaireLink;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div/div/div/div/div/form/div/div/div/div/div[2]/div/div/div")
	public WebElement eleSelectTemplate;

	@FindBy(xpath = "//div/span[contains(text(),'Placeholders')]/following::button[1]")
	public WebElement eleclickOnFirstPlaceholder;

	@FindBy(xpath = "//div/span[contains(text(),'Placeholders')]/following::button[2]")
	public WebElement eleclickOnSecondPlaceholder;

	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/div/button[2]")
	public WebElement eleOfclickOnSaveandExit;

	@FindBy(xpath = "//div[contains(text(),'Are you sure you want to delete this Question?')]//following::div[1]/div/button[2]")
	public WebElement eleToConfirmDeleteTheAddedScreeingQuestions;
	
	@FindBy(xpath = "//span[contains(text(),'Advertise job')]//following::div[1]/button[1]")
	public WebElement eleToClickOnContinueInAdvertiseJob;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div[4]/form[1]/div[3]/button[1]")
	public WebElement eleToClickOnContinueInAdvertiseJobAfterJobTargetadded;
	
	@FindBy(xpath = "//div[contains(text(),'Edit Question')]//following::button[5]")
	public WebElement eleToClickOnEditQuestionsUpdateButton;
	
	@FindBy(xpath = "//span/div/div/div/button")
	public WebElement eleToclickOnCareerPageSwitch;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/div/div/div/div/form/div/button")
	public WebElement eleOfclickOnPublishButton;
	
	@FindBy(xpath ="//section/main/div/div/div/div/button[1]")
	private WebElement eleOfclickOnApplyForThisJob;
	
	@FindBy(xpath = "//div[3]/div[2]/div[1]/span[1]/input[1]")
	public WebElement eleToenterFirstNameInCareerPage;
	
	@FindBy(xpath = "//div/div/div/span/div/button[1]")
	public WebElement eleOfclickOnSubmitApplicationButton;

	@FindBy(xpath = "//h4[contains(text(),'No Job Boards are enabled. Contact your admin or g')]")
	public WebElement eleToValidateDisabledjobTargetInIntegratios;
	
	@FindBy(xpath = "//div[contains(text(),'Candidates will be able to apply via advertised jo')]")
	public WebElement eleToValidateEnabledjobTargetInIntegratios;
	
	@FindBy(how=How.ID,using="formFieldDetails_label")
	private WebElement eleEnterQuestionScreening;
	
	@FindBy(how=How.XPATH,using="//form[@id='formFieldDetailsForm 7']//div//div//div//div//div//div//div//div//div//div//span//button")
	private WebElement eleToclickOnAddAnswerInScreeningchoice;
	
	@FindBy(how=How.ID,using="formFieldDetails_options[1]")
	private WebElement eleToenterscreeningOptionalAnswer1;
	
	@FindBy(how=How.ID,using="formFieldDetails_options[2]")
	private WebElement eleToenterscreeningOptionalAnswer2;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Add Question')]//following::button[6]")
	private WebElement eleToclickOnAddcompleteScreeningchoiceSet;
	
	@FindBy(how=How.XPATH,using="//form/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/button[3]")
	public WebElement eleToclickDisabledresponse;
	
	@FindBy(how=How.XPATH,using="//form/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/button[1]")
	public WebElement eleToclickRequriedresponse;
	
	@FindBy(how=How.XPATH,using="//img[@alt='jobTarget']//following::div/div/div/button[1]")
	public WebElement eleToclickAdvertiseJob;
	
	@FindBy(how=How.XPATH,using="//div//div//div//div//div//div//div//div//div//div//div//div[3]//button[1]")
	public WebElement eleToclickrefreshAdvertiseJob;
	
	
	/*
	 * ========================End of page object
	 * repo=========================================================================
	 */

	public void enterJobTitle(String strJobTitle) {
		clearAndTypeWithTagName(eleJobTitle, strJobTitle, "JobTitle");
	}

	public void selectJobDepartment(String strDepartment) {
		driver.findElement(byEleDepartment).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strDepartment + "')]")).click();
		reportStep("The JobDepartment :" + strDepartment + " selected Successfully", "pass");
	}

	public void selectJobLocation(String strLocation) {
		driver.findElement(byEleJobLocation).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strLocation + "')]")).click();
		reportStep("The JobLocation :" + strLocation + " selected Successfully", "pass");
	}

	public void enterNoOfOpening(String strNofOpeing) {
		clearAndTypeWithTagName(eleJobNoOfOpening, strNofOpeing, "NoOfJobOpeing");
	}

	public void selectJobEmploymentTypes(String strEmploymentTypes) throws InterruptedException {
		driver.findElement(byEleJobEmploymentTypes).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strEmploymentTypes + "')]")).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strEmploymentTypes + "')]")).sendKeys(Keys.TAB);
		waitForElementLoad(2000);
		driver.findElement(byEleJobTeamMember).click();
		reportStep("The JobEmploymentTypes :" + strEmploymentTypes + " selected Successfully", "pass");
	}

	public void selectJobTeamMember(String strTeamMember) {
		driver.findElement(By.xpath("//li[contains(text(),'" + strTeamMember + "')]")).click();
		reportStep("The JobTeamMember :" + strTeamMember + " selected Successfully", "pass");
	}

	public void selectJobTags(String strTags) {
		driver.findElement(byEleJobTags).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strTags + "')]")).click();
		reportStep("The JobTags :" + strTags + " selected Successfully", "pass");
	}

	public void clickContinueOnGetStarted() {
		click(eleJobContinueOnGettingStarted, "GettingStartedContinue");
	}

	public void clickContinueOnJobDescription() {
		waitForElementLoad(1000);
		click(eleContinueOnJobDescription, "JobDescriptionContinue");
	}
	
	public void clickContinueOnAdvertiseJob() {
		waitForElementLoad(3000);
		click(eleToClickOnContinueInAdvertiseJob, "Advertise Continue");
	}
	
	public void clickOnContinueInAdvertiseJobAfterJobTargetadded() {
		waitForElementLoad(3000);
		click(eleToClickOnContinueInAdvertiseJobAfterJobTargetadded, "Advertise Continue");
	}

	public void clickContinueOnApplication() {
		waitForElementLoad(1000);
		clickBySingleAction(eleToclickOnContinueOnApplication, "Application");
		waitForElementLoad(2000);
	}

	public void clickContinueOnInterviewProcess() {
		waitForElementLoad(1000);
		click(eleToClickOnSaveAndExitInInterviewProcess, "Interviewprocess");
		waitForElementLoad(3000);
	}

	public void enterJobDescription(String strJobDescription) {
		clearAndTypeWithTagName(eleJobDescription, strJobDescription, "JobDescription");
	}

	public void enterJobWorkExperience(String strJobWorkExperience) {
		clearAndTypeWithTagName(eleJobWorkExperience, strJobWorkExperience, "WorkExperience");
	}

	public void selectJobEducation(String strJobEducation) {
		driver.findElement(byeleJobEducation).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strJobEducation + "')]")).click();
		reportStep("The JobEducation :" + strJobEducation + " selected Successfully", "pass");
	}

	public void enterJobAnnualMinSalary(String strJobMinAnnualSalary) {
		clearAndTypeWithTagName(eleJobMinAnnualSalary, strJobMinAnnualSalary, "MinSalary");
	}

	public void enterJobAnnualMaxSalary(String strJobMaxAnnualSalary) {
		clearAndTypeWithTagName(eleJobMaxAnnualSalary, strJobMaxAnnualSalary, "MaxSalary");
	}

	public void clickAddScreeningQuestions() {
		click(eleClickOnAddScreeningQuestions, "AddScreening");
	}

	public void enterScreeningQuestions(String screeningQuestions) {
		clearAndTypeWithTagName(eleenterAddScreeningQuestion, screeningQuestions, "TextFieldOfScreeningQuestion");
	}

	public void clickOnAddButtonOfScreeningQuestion() {
		click(eleClickOnTextAddScreenQuestion, "Add");
	}

	public void clickOnAddStageButton() {
		click(eleClickOnAddStageOfInterviewProcess, "AddStage");
	}

	public void enterStageTitle(String strStageTitle) {
		clearAndTypeWithTagName(eleStageTitle, strStageTitle, "StageTitle");
	}

	public void selectStageInterviewer() throws InterruptedException {
		clickByAction(eleStageInterviewer, eleSelectStageInterviewer, "Interviewer");
	}

	public void clickUpdateStage() {
		click(eleUpdateStage, "UpdateStage");
	}

	public void clickExternalJobCheckBox() {
		Actions action = new Actions(driver);
		action.moveToElement(eleJobExternalPublish).click().build().perform();
	}

	public void clickonContinueInPublishJob() {
		click(eleToclickOnContinueInPublishjob, "continue PublishJob");
	}

	public void publishJobToCareerSite() {
		clickExternalJobCheckBox();
		clickonContinueInPublishJob();
	}

	public void addScreening(String strQuestion) {
		clickAddScreeningQuestions();
		enterScreeningQuestions(strQuestion);
		clickOnAddButtonOfScreeningQuestion();
	}

	public void clickonInterviewProcessLink() throws InterruptedException {
		clickByAction(eleclickonInterviewProcessLink, eleclickonInterviewProcessLink, "Interview Process");
		waitForElementLoad(2000);
	}

	public void clickOnEditIcon() {
		click(eleclickOnEditIcon, "Edit Icon");
		waitForElementLoad(1000);
	}

	public void clickOnSendemail() {
		waitForElementLoad(1000);
		click(eleclickOnSendEmail, "Send Email");
	}

	public void enterEmailSubject(String emailSubject) {
		clearAndTypeWithTagName(eleenterEmailSubject, emailSubject, "TextFieldOfEmailSubject");
	}

	public void enterEmailBody(String emailBody) {
		clearAndTypeWithTagName(eleenterEmailBody, emailBody, "TextFieldOfEmailBody");
	}

	public void clickonInsertQuestionnaire() throws InterruptedException {
		clickByAction(eleemailQuestionnaire, eleClickonemailQuestionnaireLink, "Insert Questionnaire");
		waitForElementLoad(2000);
	}

	public void selectEmailTemplate(String strEmailTemplate) {
		click(eleSelectTemplate, "Select Template");
		driver.findElement(By.xpath("//li[contains(text(),'" + strEmailTemplate + "')]")).click();
		reportStep("The Template :" + strEmailTemplate + " selected Successfully", "pass");
	}

	public void clickOnPlaceholders() {
		click(eleenterEmailBody, "Email Body");
		waitForElementLoad(1000);
		click(eleclickOnFirstPlaceholder, "Placeholders");
		waitForElementLoad(1000);
		click(eleclickOnSecondPlaceholder, "Placeholders");
	}

	public void clickOnSaveandExit() {
		click(eleOfclickOnSaveandExit);
		waitForElementLoad(4000);
	}

	public void addStaging(String strStageTitle) {
		try {
			clickOnAddStageButton();
			enterStageTitle(strStageTitle);
			// selectStageInterviewer();
			clickUpdateStage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String validateJobTitleRequiredErrorText(String jobtitleerrortext) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'" + jobtitleerrortext + "')]")).getText();
	}

	public String validateQuestionsRequiredErrorText(String questionserrortext) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'" + questionserrortext + "')]")).getText();
	}

	public void clickOneditTheScreeningQuestions(String screeningquestion) {
		WebElement mouseover = driver.findElement(By.xpath("//div[contains(text(),'" + screeningquestion + "')]"));
		WebElement editbutton = driver.findElement(
				By.xpath("//div[contains(text(),'" + screeningquestion + "')]//following::*[local-name()='svg'][1]"));
		try {
			clickByAction(mouseover, editbutton, "Edit");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickdeleteTheScreeningQuestions(String screeningquestion) {
		WebElement mouseover = driver.findElement(By.xpath("//div[contains(text(),'" + screeningquestion + "')]"));
		WebElement deletebutton = driver.findElement(
				By.xpath("//div[contains(text(),'" + screeningquestion + "')]//following::*[local-name()='svg'][2]"));
		try {
			clickByAction(mouseover, deletebutton, "Delete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnconfirmDelete() {
		click(eleToConfirmDeleteTheAddedScreeingQuestions, "Confirm delete");
	}

	public String validateScreeningQuestionsAdded(String screeningquestion) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'" + screeningquestion + "')]")).getText();
	}
	
	public void clickOnScreeningUpdateButton() {
		click(eleToClickOnEditQuestionsUpdateButton, "Update button");
	}
	
	public void clickOnCareerPageSwitch() {
		click(eleToclickOnCareerPageSwitch, "CareerPageSwitch");
		waitForElementLoad(2000);
	}
	
	public void clickOnPublishButton() {
		waitForElementLoad(1000);
		click(eleOfclickOnPublishButton,"PublishButton");
	}
	
	public String validateJobTitleInCareerPage(String jobtitle) {
		waitForElementLoad(2000);
	return driver.findElement(By.xpath("//a[contains(text(),'" + jobtitle + "')]")).getText();
	}
	
	public String validateJobErrMessageInCareerPage(String jobErrMessage) {
		waitForElementLoad(2000);
		String strErrMsg = driver.findElement(By.xpath("//span[contains(text(),'" + jobErrMessage + "')]")).getText();
		strErrMsg.trim();
		return strErrMsg;
	}
	
	public String validateJobTitleInCareerPageViaSpecficJob() {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//section/main/div/div/div/div[2]")).getText();
	}
	
	public String validateJobNotAvailableInCareerPageViaSpecficJob() {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//section/main/div/div/div/div/div[2]")).getText();
	}
	
	public void clickOnApplyForThisJob() {
		waitForElementLoad(1000);
		click(eleOfclickOnApplyForThisJob,"ApplyForThisJob");
	}
	
	public void enterFirstNameInCareerPage(String strFirstName) {
		waitForElementLoad(2000);
	clearAndTypeWithTagName(eleToenterFirstNameInCareerPage, strFirstName, "FirstName");
	}
	
	public void clickOnSubmitApplicationButton() {
		click(eleOfclickOnSubmitApplicationButton,"SubmitApplication");
		waitForElementLoad(2000);
	}
	
	public void createJob(String jobtitle, String department, String jobLocation, String noOfOpening,String jobdescription,
			String workExperience,String minsalary,String maxsalary,String screeningQuestion,String stageName,String automationTemplateForSendingEmail) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobTitle(jobtitle);
		postJobPage.selectJobDepartment(department);
		postJobPage.selectJobLocation(jobLocation);
		postJobPage.enterNoOfOpening(noOfOpening);
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnGetStarted();
		postJobPage.enterJobDescription(jobdescription);
		postJobPage.enterJobWorkExperience(workExperience);
		postJobPage.enterJobAnnualMinSalary(minsalary);
		postJobPage.enterJobAnnualMaxSalary(maxsalary);
		postJobPage.clickContinueOnJobDescription();
		postJobPage.clickonContinueInPublishJob();
		postJobPage.clickContinueOnAdvertiseJob();
		postJobPage.addScreening(screeningQuestion);
		postJobPage.clickContinueOnApplication();
		postJobPage.clickOnAddStageButton();
		postJobPage.enterStageTitle(stageName);
		postJobPage.clickOnSendemail();
		postJobPage.selectEmailTemplate(automationTemplateForSendingEmail);
		postJobPage.clickUpdateStage();
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnInterviewProcess();
	}
	
	public String validateDisabledJobTargetText() {
		return getElementText(eleToValidateDisabledjobTargetInIntegratios);
	}
	
	public String validateEnabledJobTargetText() {
		return getElementText(eleToValidateEnabledjobTargetInIntegratios);
	}
	
	public void selectScreeningQuestionType(String strAddQuestionType) {
		driver.findElement(byEleScreeingquestype).click();
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//li[contains(text(),'" + strAddQuestionType + "')]")).click();
		reportStep("The QuestionType :" + strAddQuestionType + " selected Successfully", "pass");
	}
	
	public void enterAddQuestionScreening(String screeningquestion) {
		waitForElementLoad(1000);
		clearAndTypeWithTagName(eleEnterQuestionScreening, screeningquestion, "Add screening question");
	}
	
	public void clickOnAddAnswerInScreeningchoice() {
		waitForElementLoad(1000);
		click(eleToclickOnAddAnswerInScreeningchoice, "Add Answer In Screening choice");
	}
	
	public void enterscreeningOptionalAnswer1() {
		waitForElementLoad(1000);
		clearAndType(eleToenterscreeningOptionalAnswer1, "screeningOptionalAnswer1");
	}
	
	public void enterscreeningOptionalAnswer2() {
		waitForElementLoad(1000);
		clearAndType(eleToenterscreeningOptionalAnswer2, "screeningOptionalAnswer2");
	}
	
	public void clickOnAddcompleteScreeningchoiceSet() {
		waitForElementLoad(1000);
		click(eleToclickOnAddcompleteScreeningchoiceSet, "Add complete Screening Choice Set");
	}
	
	public void clickDisabledresponse() throws InterruptedException {
		waitForElementLoad(1000);
		clickByAction(eleToclickDisabledresponse, eleToclickDisabledresponse, "Delete");
	}
	
	public void clickRequiredresponse() throws InterruptedException {
		waitForElementLoad(1000);
		clickByAction(eleToclickRequriedresponse, eleToclickRequriedresponse, "Delete");
	}
	
	public void clickOnAdvertiseJob() {
		click(eleToclickAdvertiseJob, "Advertise Job");
		waitForElementLoad(9000);
	}
	
	public void switchtoJobTargetIntegrationPage() {
		switchToWindow(1);
		waitForElementLoad(9000);
	}
	
	public void clickOnRefreshAdvertiseJob() {
		click(eleToclickrefreshAdvertiseJob, "Refresh Advertise Job");
		waitForElementLoad(4000);
	}
	
	public String getJobTargetText(String sitename) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+sitename+"')]")).getText();
	}
	
	
}
