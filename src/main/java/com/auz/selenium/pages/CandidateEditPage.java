package com.auz.selenium.pages;

import static org.junit.Assert.assertTrue;
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

public class CandidateEditPage extends ProjectSpecificMethods {

	public CandidateEditPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//button[1]")
	public WebElement eleofFirstCandidate;

	@FindBy(xpath = "//html//body//div//div//div//div//div//div//section//main//section//main//div//div//div//div//div//button")
	public WebElement eleScheduleInterview;

	@FindBy(xpath = "//label[contains(text(),'Interview Date')]//following::i[2]//*[local-name()='svg']")
	public WebElement eleSelectScheduleInterviewDate;

	public By eleclickInterviewTimeIcon = By
			.xpath("//label[contains(text(),'Start Time')]//following::i[1]//*[local-name()='svg']");

	@FindBy(xpath = "//span[contains(text(),'Voice Call')]")
	public WebElement eleScheduleInterviewType;

	@FindBy(xpath = "//body//div//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//span[1]//button[1]")
	public WebElement eleScheduleInterviewOnSelectedDate;

	@FindBy(xpath = "//html//body//div//div//div//div//div//div//section//main//section//main//div//div//div//div//div//div//div//div//div//div//div//a//i//*[local-name()='svg']")
	public WebElement eleToSelectEditAndDeleteScheduleInterview;

	@FindBy(xpath = "//body/div/div/div/ul/li[1]/button[1]")
	public WebElement eleToEditTheScheduleInterview;

	@FindBy(xpath = "//li[2]//button[1]")
	public WebElement eleToDeleteTheScheduleInterview;

	@FindBy(xpath = "//body//div//div//div//section//section//div//div//div//div//div//div//button[1]")
	public WebElement eleToConfirmDeleteInScheduleInterview;

	public By byInterviewStage = By.id("InterviewCreateForm_interviews[0][interviewStage]");

	@FindBy(id = "InterviewCreateForm_interviews[0][location]")
	public WebElement eleInterviewLocation;

	@FindBy(xpath = "//body//h4[1]")
	public WebElement elescheduledInterviewText;

	@FindBy(xpath = "//body/div/div/div/div/div/div/section/aside/div/div/div/i[1]//*[local-name()='svg']")
	public WebElement eleOfMouseOverToArchiveAndDelete;

	@FindBy(xpath = "//div[contains(text(),'Archive Candidate')]")
	public WebElement eleToSelectArchiveOption;

	@FindBy(xpath = "//li[contains(text(),'Delete Candidate')]")
	public WebElement eleToSelectDeleteOption;

	@FindBy(xpath = "//span[contains(text(),'Move to Stage:')]//ancestor::div/div/div/div/div[2]/button/span/i//*[local-name()='svg']")
	public WebElement eleToCloseEditInformation;

	@FindBy(xpath = "//li[contains(text(),'Unarchive Candidate')]")
	public WebElement eleToSelectUnArchiveOption;

	@FindBy(xpath = "//span[contains(text(),'Source')]//following::div[1]//div[1]//span[1]//i[1]//*[local-name()='svg']")
	public WebElement eleToSelectSourceOption;

	@FindBy(xpath = "//span[contains(text(),'Information')]//following::button[1]")
	public WebElement eleToClickEditInformation;

	@FindBy(id = "candidateDetailsForm_email")
	public WebElement eleToenterEmail;

	@FindBy(id = "candidateDetailsForm_mobileNo")
	public WebElement eleToenterPhone;

	@FindBy(id = "candidateDetailsForm_currentLocation")
	public WebElement eleToenterLocation;

	@FindBy(id = "candidateDetailsForm_currentDesignation")
	public WebElement eleToenterDesgination;

	@FindBy(id = "candidateDetailsForm_currentCompany")
	public WebElement eleToenterCurentCompany;

	@FindBy(id = "candidateDetailsForm_url")
	public WebElement eleToenterLink;

	@FindBy(xpath = "//span[contains(text(),'Information')]//following::div[1]/button[1]")
	public WebElement eleToSaveEditInformation;

	@FindBy(xpath = "//span[contains(text(),'Details')]//following::button[1]")
	public WebElement eleToClickDetailsEditInformation;

	@FindBy(id = "candidateDetailsForm_otherDetails")
	public WebElement eleToenterAddDescription;

	@FindBy(xpath = "//span[contains(text(),'Details')]//following::div[1]/button[1]")
	public WebElement eleToClickSaveDetails;

	@FindBy(xpath = "//div[contains(text(),'Add Tags')]")
	public WebElement eleToAddTags;
	
	@FindBy(xpath = "//span[contains(text(),'Jobs')]//following::div/div/div/div/div/div/section/aside/div/main/div/div/div/div/div/div/div/div/i[1]//*[local-name()='svg']")
	public WebElement eleTomouseOverToremoveJob;

	@FindBy(xpath = "//li[contains(text(),'Remove Job')]")
	public WebElement eleToClickOnRemoveJob;
	
	@FindBy(xpath = "//span[contains(text(),'Resume')]")
	public WebElement eleToClickOnResumeTab;
	
	@FindBy(xpath = "//div[contains(text(),'Upload')]")
	public WebElement eleToClickOnUpload;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/section/aside/div/main/div/div/div/div[2]/div[1]/div[1]")
	public WebElement eleToMouseOverOnUploadedResume;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/section/aside/div/main/div/div/div/div/div[1]/i[2]//*[local-name()='svg']")
	public WebElement eleTOdeleteUploadedFile;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	public WebElement eleHomepageMenu;
	
	@FindBy(xpath = "//div[contains(text(),'Feedback')]")
	public WebElement eleToClickOnFeedbackTab;
	
	@FindBy(id = "FeedbackCreateForm_description")
	public WebElement eleToEnterFeedbackDescription;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]//following::button[1]")
	public WebElement eleToClickOnSubmitscorecard;
	
	@FindBy(xpath = "//body/div/div/div/div/div/div/section/main/section/main/div/div/div/div/div/div/div/div/div/div/div/div/span/i[1]//*[local-name()='svg']")
	public WebElement eleToSelectEditFeedback;
	
	@FindBy(xpath = "//body/div/div/div/ul/li/button[1]")
	public WebElement eleToClickOnEditFeedback;
	
	@FindBy(xpath = "//div[contains(text(),'Emails')]")
	public WebElement eleToClickOnEmailTab;
	
	@FindBy(xpath = "//span[contains(text(),'Sync Mail')]//following::span//button[1]")
	public WebElement eleToClickOnSentEmail;
	
	@FindBy(id = "EmailCreateForm_subject")
	public WebElement eleToEnterEmailSubject;
	
	@FindBy(xpath = "//label[contains(text(),'Message')]//following::div/div/span/div/div[2]/div[1]")
	public WebElement eleToEnterEmailMessage;
	
	@FindBy(xpath = "//span[@class='ant-form-item-children']//button[@class='ant-btn ant-btn-primary']")
	public WebElement eleToClickOnSendEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Select template')]//following::span/i//*[local-name()='svg']")
	public WebElement eleToSendEmailTemplate;
	
	@FindBy(xpath = "//span[text()='CC']")
	public WebElement eleToClickOnCC;
	
	@FindBy(xpath = "//body//div[@id='CC']//div//div//div[2]")
	public WebElement eleToEnterCC;
	
	@FindBy(xpath = "//span[text()='BCC']")
	public WebElement eleToClickOnBCC;
	
	@FindBy(xpath = "//body//div[@id='BCC']//div//div//div[2]")
	public WebElement eleToEnterBCC;
	
	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	public WebElement eleToCommentSection;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/ul[1]/li[1]/span[1]")
	public WebElement eleToDomainName;
	
	@FindBy(xpath = "//textarea[@id='CommentCreateForm_comments']")
	public WebElement eleToEnterComment;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/span[1]/button[2]")
	public WebElement eleToclickOnComment;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]")
	public WebElement eleToAddedComment;
	
	@FindBy(xpath = "//span[contains(text(),'Add Comments')]")
	public WebElement eleToAddComments;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]")
	public WebElement eleToDeleteComments;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[3]/div[1]/button[1]")
	public WebElement eleToDeleteCommentsButton;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/section[1]/main[1]/section[1]/main[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]")
	public WebElement eleToEditComments;
	
	@FindBy(xpath = "//span[contains(text(),'Screening')]")
	public WebElement eleToClickOnScreeningTab;
	
	@FindBy(xpath = "//div[contains(text(),'responses')]")
	public WebElement eleToClickOnScreeningJob;
	
	@FindBy(xpath = "//span[contains(text(),'Screening')]//following::div//div//div//div//div//div//span//button")
	public WebElement eleToClickOnEditScreeningJob;
	
	
	@FindBy(xpath = "//span[contains(text(),'Screening')]//following::div//div//div//div//div//div//form//div//div//div//span//input")
	public WebElement eleToEnterScreeningResponse;
	
	@FindBy(xpath = "//body//section//button[2]")
	public WebElement eleToClickOnSaveResponse;
	
	@FindBy(xpath = "//span[contains(text(),'Sync Mail')]//following::span/span")
	public WebElement eleSendEmailButtonDisabled;
	
	@FindBy(xpath = "//h4[contains(text(),'automation')]//following::button[1]")
	public WebElement eleToClickOnReplyEmail;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Added')]//following::button[1]")
	public WebElement eleToClickOnSendEmailUnderCandidateProfile;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Send a Mail')]//following::button[1]")
	public WebElement eleFollowButton;
	
	@FindBy(xpath = "//span[contains(text(),'Screening')]")
	public WebElement eleToClickOnScreeningLink;
	
	@FindBy(xpath = "//main/div/div/div/div/div/div/div/div/span/button[1]")
	public WebElement eleToClickOnEditLink;
	
	@FindBy(xpath = "//input[contains(@id,'dynamic_form')]")
	public WebElement eleToenterSinglelineresponse;
	
	@FindBy(xpath = "//main/div/div/div/div/div/div/div/div/form/div/div/div/span/div/button[2]")
	public WebElement eleToClickOnSaveButtonInSingleLinkRespButton;
	
	@FindBy(xpath = "//section/aside/div/main/div/div/div/div[2]/div[1]/div[1]/div[1]")
	public WebElement eleToClickOnSingleLineScreeningQuestion;
	
	@FindBy(xpath = "//textarea[contains(@id,'dynamic_form')]")
	public WebElement eleToEnterMultipleLineresponse;
	
	@FindBy(xpath = "//form/div/div/div/span/div/div[2]/label[1]/span[2]")
	public WebElement eleToClickOnSinglechoiceRespOption;
	
	@FindBy(xpath = "//input[contains(@id,'dynamic_form')]/parent::span")
	public WebElement eleToClickOnUploadInScreeningsection;
	
	/*
	 * * =====================end of page object
	 * repository===================================================================
	 */

	public void clickOnCandidate() {
		click(eleofFirstCandidate, "CandidateDetails");
		waitForElementLoad(2000);
	}

	public void clickOnScheduleInterview() {
		click(eleScheduleInterview, "ScheduleInterview");
		waitForElementLoad(2000);
	}

	public void clickOnScheduleInterviewOnSelctedDate() {
		click(eleScheduleInterviewOnSelectedDate, "ScheduleInterview");
		waitForElementLoad(2000);
	}

	public void selectInterviewStage(String strinterviewStage) {
		driver.findElement(byInterviewStage).click();
		driver.findElement(By.xpath("//li[contains(text(),'" + strinterviewStage + "')]")).click();
		reportStep("The InterviewStage :" + strinterviewStage + " selected Successfully", "pass");
	}

	public void clickInterviewType() {
		click(eleScheduleInterviewType, "Voice Call");
	}

	public void enterInterviewLocation(String location) {
		clearAndTypeWithTagName(eleInterviewLocation, location, "InterviewLocation");
	}

	public void deleteTheScheduledInterview() throws InterruptedException {
			waitForElementLoad(2000);
			clickByAction(eleToSelectEditAndDeleteScheduleInterview, eleToDeleteTheScheduleInterview, "Delete");
			waitForElementLoad(1000);
			click(eleToConfirmDeleteInScheduleInterview, "confirmDelete");
			waitForElementLoad(2000);
	}

	public void editTheScheduledInterview(String location) throws InterruptedException {
		waitForElementLoad(2000);
		clickByAction(eleToSelectEditAndDeleteScheduleInterview, eleToEditTheScheduleInterview, "Edit");
		enterInterviewLocation(location);
		scrollBottom(driver);
		clickOnScheduleInterviewOnSelctedDate();
	}

	public String validateInterviewScheduledText() {
		String scheduledInterviewText = getElementText(elescheduledInterviewText);
		return scheduledInterviewText;
	}

	public String validateInterviewEditedLocationText(String location) {
		WebElement editedInterviewLocation = driver
				.findElement(By.xpath("//span[contains(text(),'" + location + "')]"));
		String scheduledInterviewText = getElementText(editedInterviewLocation);
		return scheduledInterviewText;
	}

	public void mouseOverToSelectArchiveAndDelete() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(eleOfMouseOverToArchiveAndDelete).click().build().perform();
		reportStep("The select option for archive/delete selected Successfully", "pass");
	}

	public void selectArchiveReason(String strArcheiveReason) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(eleToSelectArchiveOption).click().build().perform();
		WebElement eleArcheiveReason = driver
				.findElement(By.xpath("//li[contains(text(),'" + strArcheiveReason + "')]"));
		action.moveToElement(eleArcheiveReason).click().build().perform();
		reportStep("The archived reason selected Successfully", "pass");
	}

	public void selectUnArchiveReason() {
		Actions action = new Actions(driver);
		action.moveToElement(eleToSelectUnArchiveOption).click().build().perform();
		reportStep("The Unarchived Clicked Successfully", "pass");
	}

	public void selectDeleteCandidate() throws InterruptedException {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(eleToSelectDeleteOption));
		Actions action = new Actions(driver);
		action.moveToElement(eleToSelectDeleteOption).click().build().perform();
		waitForElementLoad(1000);
		reportStep("The Deleted option Clicked Successfully", "pass");
	}

	public void mouseOverToSelectSourceTag() throws InterruptedException {
		waitForElementLoad(2000);
		Actions action = new Actions(driver);
		action.moveToElement(eleToSelectSourceOption).click().build().perform();
		reportStep("The select option for changing the source is selected Successfully", "pass");
		waitForElementLoad(2000);
	}

	public void selectSourcesReason(String strSourceReason) throws InterruptedException {
		waitForElementLoad(2000);
		WebElement eleSourceReason = driver.findElement(By.xpath("//li[contains(text(),'" + strSourceReason + "')]"));
		Actions action = new Actions(driver);
		action.moveToElement(eleSourceReason).click().build().perform();
		waitForElementLoad(1000);
		reportStep("The Source :"+ strSourceReason + " is selected Successfully", "pass");
	}

	public void clickOnCloseButton() {
		click(eleToCloseEditInformation, "Close button");
	}

	public void clickOnEditInformation() {
		click(eleToClickEditInformation, "Edit");
	}

	public void enterEmail(String email) {
		clearAndTypeWithTagName(eleToenterEmail, email, "Email");
	}

	public void enterPhone(String phone) {
		clearAndTypeWithTagName(eleToenterPhone, phone, "Phone");
	}

	public void enterLocation(String location) {
		clearAndTypeWithTagName(eleToenterLocation, location, "Location");
	}

	public void enterCurrentRole(String currentRole) {
		clearAndTypeWithTagName(eleToenterDesgination, currentRole, "currentRole");
	}

	public void enterCurrentCompany(String currentCompany) {
		clearAndTypeWithTagName(eleToenterCurentCompany, currentCompany, "currentCompany");
	}

	public void enterLink(String link) {
		clearAndTypeWithTagName(eleToenterLink, link, "Link");
	}

	public String validateErrorMessageOfLink(String errorlinktext) {
		WebElement eleerrortextOfLink = driver.findElement(By.xpath("//div[contains(text(),'" + errorlinktext + "')]"));
		String errortextOfLink = eleerrortextOfLink.getText();
		return errortextOfLink;
	}

	public void clickOnSave() {
		click(eleToSaveEditInformation, "Save");
	}

	public void clickOnDetailsEditInformation() {
		click(eleToClickDetailsEditInformation, "DetailsEdit");
	}

	public void enterDetailsInformation(String description) {
		clearAndTypeWithTagName(eleToenterAddDescription, description, "DetailsInformation");
	}

	public void clickOnSaveDetailsInformation() {
		click(eleToClickSaveDetails, "Save");
	}

	public void selectTags(String tagname) {
		click(eleToAddTags, "tag");
		driver.findElement(By.xpath("//li[contains(text(),'" + tagname + "')]")).click();
	}
	
	public void clickOnRemoveJob() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(eleTomouseOverToremoveJob).click().build().perform();
		action.moveToElement(eleToClickOnRemoveJob).click().build().perform();
		waitForElementLoad(2000);
		reportStep("Job removed for that candidate in CandidateEditPage", "pass");
	}
	
	public void clickOnResumeTab() {
		click(eleToClickOnResumeTab,"ResumeTab");
	}
	
	public void clickOnUploadButton(String filename) {
		click(eleToClickOnUpload,"Upload");
		waitForElementLoad(2000);
		uploadFile(filename);
		waitForElementLoad(2000);
	}
	public void mouseoverOnUploadedresume() {
		clickBySingleAction(eleToMouseOverOnUploadedResume, "Mouse over on Resume");
	}
	public void clickOnDeleteUploadedResume() {
		clickBySingleAction(eleTOdeleteUploadedFile, "Delete");
	}
	
	public void clickOnHomePageMenu() {
		click(eleHomepageMenu,"HomePage");
	}
	
	public void selectInterviewTime() {
		driver.findElement(By.xpath("//input[@id='InterviewCreateForm_interviews[0][slotTime]']")).click();
		waitForElementLoad(4000); 
		driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[24]")).click();
		waitForElementLoad(4000);
		}
	public void clickonFeedback() {
		click(eleToClickOnFeedbackTab, "FeedbackTab");
		waitForElementLoad(1000);
	}
	
	public void clickOnSubmitFeedback(String interviewStage) {
		driver.findElement(By.xpath("//h4[contains(text(),'"+interviewStage+"')]//following::button[1]")).click();
		reportStep("Clicked on Feedback Tab", "pass");
	}
	public void enterFeedbackDescription(String decription) {
		clearAndTypeWithTagName(eleToEnterFeedbackDescription, decription, "Description");
	}
	
	public void selectFeedbackValue(String feedbackvalue) {
		waitForElementLoad(1000);
		WebElement ele=driver.findElement(By.xpath("//span[text()='"+feedbackvalue+"']"));
		clickBySingleAction(ele, feedbackvalue);
	}
	
	public void clickonSubmitScorecard() {
		click(eleToClickOnSubmitscorecard, "SubmitScorecard");
	}
	
	public String validateSubittedScorecard(String feedback,String interviewStage) {
		return driver.findElement(By.xpath("//h4[contains(text(),'"+interviewStage+"')]//following::div//div//div//div//div//span[contains(text(),'"+feedback+"')]")).getText();
	}
	
	public void clickOnEditTheSubmittedFeedback() throws InterruptedException {
		waitForElementLoad(2000);
		clickByAction(eleToSelectEditFeedback, eleToClickOnEditFeedback, "EditFeedback");
	}
	
	public void clickOnEmailTab(){
		waitForElementLoad(1000);
		click(eleToClickOnEmailTab,"Email");
	}
	
	public void clickOnNewSendEmail(){
		waitForElementLoad(1000);
		click(eleToClickOnSentEmail,"Email");
	}
	
	public void enterEmailSubject(String Subject){
		clearAndTypeWithTagName(eleToEnterEmailSubject, Subject, "Subject");
	}
	
	public void enterEmailMessage(String message){
		clearAndTypeWithTagName(eleToEnterEmailMessage, message, "Message");
	}
	
	public void clickOnSendEmail(){
		click(eleToClickOnSendEmail,"Send");
	}
	
	public String validateSentEmailBody(String emailBody) {
		return driver.findElement(By.xpath("//p[contains(text(),'"+emailBody+"')]")).getText();
	}
	public void selectEmailTemplate(String templateName) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(eleToSendEmailTemplate).click().build().perform();
		WebElement eleArcheiveReason = driver
				.findElement(By.xpath("//li[contains(text(),'" + templateName + "')]"));
		action.moveToElement(eleArcheiveReason).click().build().perform();
		reportStep("The email template selected Successfully", "pass");
	}
	
	public void clickOnSendEmailWithCC(){
		waitForElementLoad(2000);
		clickBySingleAction(eleToClickOnCC, "CC");
	}
	
	public void enterEmailCC(String ccmailId){
		waitForElementLoad(2000);
		clearAndTypeWithTagName(eleToEnterCC, ccmailId, "CC");
	}
	
	public void clickOnSendEmailWithBCC(){
		waitForElementLoad(2000);
		clickBySingleAction(eleToClickOnBCC,"BCC");
	}
	
	public void enterEmailBCC(String bccmailId){
		waitForElementLoad(2000);
		clearAndTypeWithTagName(eleToEnterBCC, bccmailId, "BCC");
	}
	public void clickOnCommentsSection() {
		click(eleToCommentSection, "Comments");
	}
	
	public void clickOnDomain(String tagName) {
		waitForElementLoad(2000);
		clearAndTypeWithTagName(eleToEnterComment, tagName, "Add Comment");
		waitForElementLoad(2000);
		Actions action = new Actions(driver);
		action.moveToElement(eleToDomainName).click().build().perform();
		waitForElementLoad(1000);
		reportStep("The Domain name is selected Successfully", "pass");
	}

	public void enterCommentsInAddCommentsection(String comments) {
		clearAndTypeWithTagName(eleToEnterComment, comments, "Add Comment");
	}
	
	public void clickOnComment() {
		click(eleToclickOnComment, "Comment");
	}
	
	public void clickToVerifyAddedComment() {
		waitForElementLoad(2000);
		click(eleToAddedComment, "CommentsAdded");
	}
	
	public void clickOnAddComments() {
		clickBySingleAction(eleToAddComments, "Add Comments");
	}
	
	public void clickOnDeleteComments() {
		waitForElementLoad(2000);
		click(eleToDeleteComments, "Delete Comments Link");
	}
	
	public void clickOnDeleteCommentsButton() {
		click(eleToDeleteCommentsButton, "Delete Comments Button");
		waitForElementLoad(2000);
	}
	
	public void clickOnEditComments() {
		waitForElementLoad(2000);
		click(eleToEditComments, "Delete Comments Link");
	}
	public String validateSubjectRequiredErrortext(String subjecterrortext) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+subjecterrortext+"')]")).getText();
	}
	
	public String validateBodyRequiredErrortext(String bodyerrortext) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+bodyerrortext+"')]")).getText();
	}
	
	public void clickOnScreeningTab() {
		click(eleToClickOnScreeningTab, "Screening");
	}
	
	public void clickOnScreeningJob() {
		click(eleToClickOnScreeningJob, "ScreeningJob");
	}
	
	public void clickOnEditScreeningJob() {
		click(eleToClickOnEditScreeningJob, "Edit");
	}
	
	public void enterScreeningResponse(String screeningresponse) {
		clearAndTypeWithTagName(eleToEnterScreeningResponse, screeningresponse,"screeningresponse");
	}
	
	public void clickOnSaveScreeningJob() {
		click(eleToClickOnSaveResponse, "Save");
	}
	
	public String validateScreeningResponsetext(String screeningresponse) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+screeningresponse+"')]")).getText();
	}
	
	public String validateDisabledSendEmailToolTipText(String disabledEmailToolTipMessage) {
		clickBySingleAction(eleSendEmailButtonDisabled, "SendEMail");
		waitForElementLoad(1000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+disabledEmailToolTipMessage+"')]")).getText();	
	}
	public void clickOnEmailReplyButton() {
		click(eleToClickOnReplyEmail, "Reply");
	}
	public void clickOnSendEmailUnderCandidateProfile() {
		click(eleToClickOnSendEmailUnderCandidateProfile, "SendEMail");
	}
	
	public String validateDisabledSendEmailToolTipTextUnderCandidateprofile(String disabledEmailToolTipMessage) {
		waitForElementLoad(1000);
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnSendEmailUnderCandidateProfile).build().perform();
		waitForElementLoad(1000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+disabledEmailToolTipMessage+"')]")).getText();	
	}
	public void clickOnFollowAndUnFollowButton(String followtype) {
		click(eleFollowButton, followtype);
		waitForElementLoad(2000);
	}
	
	public String validateFollowingText() {
		return getElementText(eleFollowButton);
	}
	public String validateInterviewMandatoryText(String interviewmandatorytext) {
		WebElement ele=driver.findElement(By.xpath("//div[contains(text(),'"+interviewmandatorytext+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
	
	public String validateCommentMandatoryText(String commentmandatorytext) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+commentmandatorytext+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
	
	public void clickOnScreeningLink() {
		click(eleToClickOnScreeningLink, "Screening");
	}
	
	public void clickOnSingleLineScreeningQuestion() {
		click(eleToClickOnSingleLineScreeningQuestion, "SingleLineScreeningQuestion");
	}
	
	public void clickOnEditLink() {
		waitForElementLoad(1000);
		click(eleToClickOnEditLink, "EditLink");
	}
	
	public void enterSinglelineresponse(String singleLineResp){
		waitForElementLoad(1000);
		clearAndTypeWithTagName(eleToenterSinglelineresponse, singleLineResp, "SingleLineResponse");
	}
	
	public void clickOnSaveButtonInSingleLinkRespButton() {
		waitForElementLoad(1000);
		click(eleToClickOnSaveButtonInSingleLinkRespButton, "SaveButton");
		waitForElementLoad(3000);
	}
	
	public void enterMultiplelineresponse(String multipleLineresp){
		waitForElementLoad(1000);
		clearAndTypeWithTagName(eleToEnterMultipleLineresponse, multipleLineresp, "MultipleLineResponse");
	}
	
	public void clickOnSinglechoiceRespOption() {
		waitForElementLoad(1000);
		click(eleToClickOnSinglechoiceRespOption, "SinglechoiceResponse");
	}
	
	public void clickOnUploadButtonInScreeningsection(String filename) {
		click(eleToClickOnUploadInScreeningsection,"Upload");
		waitForElementLoad(2000);
		uploadFile(filename);
		waitForElementLoad(2000);
	}
	
	public void selectScreeningDate() {
		driver.findElement(By.xpath("//form/div/div/div/span/span/div/input[1]")).click();
		waitForElementLoad(2000); 
		driver.findElement(By.xpath("//a[contains(text(),'Today')]")).click();
		waitForElementLoad(2000);
	}
	
	public String validateAnswersRequiredScreeningErrorText(String screeningerrortext) {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'" + screeningerrortext + "')]")).getText();
	}
	
	public void getformfieldStatus() {
		assertTrue(driver.findElements(By.xpath("//input[contains(@id,'dynamic_form')]")).isEmpty());
	}
	
}
