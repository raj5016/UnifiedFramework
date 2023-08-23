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

public class JobPage extends ProjectSpecificMethods {

	public JobPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//button[1]")
	public WebElement eleFirstJobTitle;

	@FindBy(how = How.XPATH, using = "//body/div[@id='hireApp']/div/section/section/main/section/header/div/div/div/div/button[1]")
	public WebElement eleAddNewJob;

	public By eleJobsCount=By.xpath("//div[contains(text(),'All Jobs (')]");
	
	public By eleSelectJob=By.xpath("//body//div[@id='hireApp']//div//div//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//i[1]//*[local-name()='svg']");

	public By eleSelectPublishedJob=By.xpath("//li[contains(text(),'Published')]");
	
	public By elePublishedJobCount=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div/div[1]");

	public By eleSelectDraftJob=By.xpath("//li[contains(text(),'Draft')]");
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='hireApp']/div/section/section/main/section/main/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[1]")
	public WebElement eleToValidateDraftText;
	
	public By eleSelectGroup=By.xpath("//body//div[@id='hireApp']//div//div//div[2]//div[1]//div[2]//div[1]//div[1]//span[1]//i[1]//*[local-name()='svg']");

	public By eleSelectLocationAsGroup=By.xpath("//li[contains(text(),'Location')]");

	public By eleSelectDepartmentAsGroup=By.xpath("//li[contains(text(),'Department')]");

	public By eleSelectJobstatusAsGroup=By.xpath("//li[contains(text(),'Job Status')]");

	@FindBy(how = How.XPATH, using = "//div[text()='Denver']")
	public WebElement eleToValidateLocationName;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Finance (')]")
	public WebElement eleToValidateDepartment;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Draft (')]")
	public WebElement eleToValidateJobStatus;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='hireApp']/div/section/section/main/section/div/div/div/div/span/button[1]")
	public WebElement eleToClickOnMoreFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Past 24 Hours']")
	public WebElement eleToClickOnPast24HoursFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Past Week']")
	public WebElement eleToClickOnPastWeekFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Past Month']")
	public WebElement eleToClickOnPastMonth;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Any Time']")
	public WebElement eleToClickOnAnyTime;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Full Time']")
	public WebElement eleToClickOnFullTime;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Part Time']")
	public WebElement eleToClickOnPartTime;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Contract']")
	public WebElement eleToClickOnContract;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Internship']")
	public WebElement eleToClickOnInternship;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Temporary']")
	public WebElement eleToClickOnTemporary;
	
	@FindBy(how = How.XPATH, using = "//header[2]//div[1]//div[2]//div[1]//div[2]//button[1]")
	public WebElement eleToClickOnApply;
	
	public By eleValidateFilteredShowingText=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div/div[1]");

	@FindBy(xpath = "//span[contains(text(),'Job Successfully Closed')]")
	public WebElement eleCloseJobTitle;
	
	@FindBy(xpath = "//span[contains(text(),'Job Successfully Cloned')]")
	public WebElement eleCloneJobTitle;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement eleToSearchJob;
	
	@FindBy(xpath = "//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[6]//button[1]")
	public WebElement eleOfMouseOverJobName;

	@FindBy(xpath = "//li[contains(text(),'Edit')]")
	public WebElement eleOfEditJobName;

	@FindBy(xpath = "//div[contains(text(),'Do you really want to close')]//following::button[1]")
	public WebElement eleOfConfirmCloseJob;
	
	@FindBy(xpath = "//div[contains(text(),'Do you really want to delete')]//following::button[1]")
	public WebElement eleOfConfirmDeleteJob;

	@FindBy(xpath = "//li[contains(text(),'Close')]")
	public WebElement eleOfCloseJobName;
	
	@FindBy(xpath = "//li[contains(text(),'Delete')]")
	public WebElement eleOfDeleteJobName;

	@FindBy(xpath = "//li[contains(text(),'Clone')]")
	public WebElement eleOfCloneJobName;
	
	@FindBy(xpath = "//div[contains(text(),'e.g')]")
	public WebElement eleOfLocationInsideTheMoreFilter;
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Add Candidate')]")
	public WebElement eleToClickOnAddCandidateInsideJob;

	@FindBy(how = How.XPATH, using = "//div[@id='hireApp']//div//section//section//main//section//div//main//div//div//div//div//div//div//div//div//div//button")
	public WebElement eleToValidateFirstCandidateInsideJob;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Pipeline View')]")
	public WebElement eleToClickonPipeLine;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'List View')]")
	public WebElement eleToClickonListView;

	@FindBy(xpath = "//li[contains(text(),'Career Page Link')]")
	public WebElement eleOfCareerPagelinkInJobName;

	public By elePipeLineOfSourcingStage = By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/div/main/div/div/div/div/div[1]");
	
	public By elePipeLineOfApplyStage = By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/div/main/div/div[2]/div[1]");
	
	public By elePipeLineOfZoomInterviewStage =By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/div/main/div/div[3]/div[1]");
	
	public String validateFirstJobNameAdded() {
		waitForElementLoad(2000);
		String firstjobname = getElementText(eleFirstJobTitle);
		return firstjobname;
	}
	
	public String validateJobIsClosed() {
		String closejobtext = getElementText(eleCloseJobTitle);
		return closejobtext;
	}
	
	public String validateJobIsCloned() {
		String clonejobtext = getElementText(eleCloneJobTitle);
		return clonejobtext;
	}

	public void clickAddNewJob() {
			waitForElementLoad(2000);
			click(eleAddNewJob, "AddNewJob");
	}
	
	public String getCandidateCounMappedForThatJob(String jobname) {
		scrollBottom(driver);
		String candidateCount=driver.findElement(By.xpath("//span[contains(text(),'"+jobname+"')]//following::div[3]")).getText();
		return candidateCount;
	}
	
	public String getJobsCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleJobsCount));		
		String jobsCount=driver.findElement(eleJobsCount).getText();
		return jobsCount;
	}
	
	public void selectPublishedJob() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectJob));
		driver.findElement(eleSelectJob).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectPublishedJob));
		driver.findElement(eleSelectPublishedJob).click();
		waitForElementLoad(2000);
		reportStep("The Published Job selected Successfully", "pass");	
		}
	
	public void selectDraftJob() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectJob));
		driver.findElement(eleSelectJob).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectDraftJob));
		driver.findElement(eleSelectDraftJob).click();
		waitForElementLoad(2000);
		reportStep("The Draft Job selected Successfully", "pass");	
		}
	
	public String validateDraftTextForFirstcandidate() {
		String drafttext=getElementText(eleToValidateDraftText);
		return drafttext;
	}
	
	public String getPublishedJobCount() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elePublishedJobCount));
		String	archivecandidateCount=driver.findElement(elePublishedJobCount).getText();
		return archivecandidateCount;
	}
	
	public void selectGroupAsLocation() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectGroup));
		driver.findElement(eleSelectGroup).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectLocationAsGroup));
		driver.findElement(eleSelectLocationAsGroup).click();
		reportStep("The Group Location selected Successfully", "pass");	
		}
	
	public void selectGroupAsDepartment() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectGroup));
		driver.findElement(eleSelectGroup).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectDepartmentAsGroup));
		driver.findElement(eleSelectDepartmentAsGroup).click();
		reportStep("The Group Department selected Successfully", "pass");	
		}
	public void selectGroupAsJobStatus() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectGroup));
		driver.findElement(eleSelectGroup).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectJobstatusAsGroup));
		driver.findElement(eleSelectJobstatusAsGroup).click();
		reportStep("The Group JobStatus selected Successfully", "pass");	
		}
	
	public String validateLocationname() {
		String locationname=getElementText(eleToValidateLocationName);
		return locationname;
	}
	
	public String validateDepartmentName() {
		String departmentname=getElementText(eleToValidateDepartment);
		return departmentname;
	}
	
	public String validateJobStatus() {
		String jobstatus=getElementText(eleToValidateJobStatus);
		return jobstatus;
	}
	
	public void clickOnMoreFilter() {
		click(eleToClickOnMoreFilter, "More filter");
	}
	
	public void clickOnPast24HourFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnPast24HoursFilter).click().build().perform();
	}
	
	public void clickOnPastWeekFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnPastWeekFilter).click().build().perform();
	}
	
	public void clickOnPastMonthFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnPastMonth).click().build().perform();
	}
	
	public void clickOnAnyTimeFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnAnyTime).click().build().perform();
	}
	
	public void clickOnFullTimeFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnFullTime).click().build().perform();
	}
	public void clickOnPartTimeFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnPartTime).click().build().perform();
	}
	public void clickOnContractTimeFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnContract).click().build().perform();
	}
	public void clickOnInternshipTimeFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnInternship).click().build().perform();
	}
	public void clickOnTemporaryFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnTemporary).click().build().perform();
	}
	public void clickOnApplyFilter() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnApply).click().build().perform();
		waitForElementLoad(5000);
	}	
	
	public String validateFilteredShowingText() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleValidateFilteredShowingText));
		String	filteredText=driver.findElement(eleValidateFilteredShowingText).getText();
		return filteredText;
	}
	public void searchJob(String JobName) throws InterruptedException {
		clearAndTypeWithTagName(eleToSearchJob, JobName, "Search");
	}
	
	public void clickOnEditJob() throws InterruptedException {
		waitForElementLoad(2000);
		clickByAction(eleOfMouseOverJobName, eleOfEditJobName, "EditJobLink");
		waitForElementLoad(2000);
	}

	public void clickOnClose() throws InterruptedException {
		clickByAction(eleOfMouseOverJobName, eleOfCloseJobName, "Close");
		click(eleOfConfirmCloseJob);
		waitForElementLoad(3000);
	}
	
	public void clickOnDelete() throws InterruptedException {
		clickByAction(eleOfMouseOverJobName, eleOfDeleteJobName, "Delete");
		click(eleOfConfirmDeleteJob);
		waitForElementLoad(3000);
	}

	public void clickOnClone() throws InterruptedException {
		clickByAction(eleOfMouseOverJobName, eleOfCloneJobName, "Clone");
	}
	
	public void selectLocationInsideMoreFilter(String location) {
		Actions action=new Actions(driver);
		action.moveToElement(eleOfLocationInsideTheMoreFilter).click().build().perform();
		driver.findElement(By.xpath("//li[contains(text(),'"+location+"')]")).click();
	}
	
	public void clickOnAddCandidateInsideJob() {
		click(eleToClickOnAddCandidateInsideJob, "Add candidate");
	}
	
	public String getFirstCandidateNameInsideJob() {
		return getElementText(eleToValidateFirstCandidateInsideJob);
	}
	
	public void clickOnFirstJob() {
		waitForElementLoad(2000);
		click(eleFirstJobTitle, "FirstJob");
	}
	
	public void clickOnFirstcandidatInsideTheJob() {
		click(eleToValidateFirstCandidateInsideJob, "FirstJob");
		waitForElementLoad(2000);
	}
	
	public void clickOnPipeLine() {
		click(eleToClickonPipeLine, "PipeLine");
		waitForElementLoad(2000);
	}
	
	public void moveCandidateSourceToApplyStages() {
		WebElement sourceOfSourcingStageelement=driver.findElement(elePipeLineOfSourcingStage);
		WebElement targetOfApplyStageelement=driver.findElement(elePipeLineOfApplyStage);
		dragAndDropElement(sourceOfSourcingStageelement, targetOfApplyStageelement);
		waitForElementLoad(3000);
	}
	
	public void movecandidateSourceToUserCreatedStageAction() {
		WebElement sourceOfSourcingStageelement=driver.findElement(elePipeLineOfSourcingStage);
		WebElement targetOfUserCreatedStageelement=driver.findElement(elePipeLineOfZoomInterviewStage);
		dragAndDropElement(sourceOfSourcingStageelement, targetOfUserCreatedStageelement);
		waitForElementLoad(3000);
	}
	
	public void clickOnListView() {
		click(eleToClickonListView, "ListView");
	}
	
	public void clickOnCarrerPageLink() throws InterruptedException {
		waitForElementLoad(2000);
		clickByAction(eleOfMouseOverJobName, eleOfCareerPagelinkInJobName, "CareerPageLink");
		waitForElementLoad(2000);
	}
	
}
