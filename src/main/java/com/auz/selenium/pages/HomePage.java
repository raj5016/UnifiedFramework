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

public class HomePage extends ProjectSpecificMethods {

	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='ant-dropdown-menu-item']//button[@class='ant-btn']")
	public WebElement eleLoggedout;

	@FindBy(how = How.XPATH, using = "//body/div[@id='hireApp']/div/section/section/aside/div/ul/a/i[1]//*[local-name()='svg']")
	public WebElement eleMouseOverToLogout;

	@FindBy(how = How.XPATH, using = "//div[@id='hireApp']//div//section//section//main//section//header//div//div//div//div//button")
	public WebElement eleAddNew;

	public By eleClickAddNew = By
			.xpath("//div[@id='hireApp']//div//section//section//main//section//header//div//div//div//div//button");

	public By eleClickAddCandidate = By.xpath("//a[contains(text(),'Candidate')]");

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Job')]")
	public WebElement eleAddJob;

	@FindBy(how = How.XPATH, using = "//body/div/div/div/ul/li[2]/a[1]")
	public WebElement eleAddCandidate;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'User')]")
	public WebElement eleAddUser;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'WORKSPACE')]//following::a[2]")
	public WebElement eleCandidateMenu;

	@FindBy(how = How.XPATH, using = "//li[3]//ul[1]//li[2]//a[1]")
	public WebElement eleCandidateLink;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'WORKSPACE')]//following::a[3]")
	public WebElement eleJobMenu;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'WORKSPACE')]//following::a[4]")
	public WebElement eleJobsManagedBYMeMenu;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'WORKSPACE')]//following::a[6]")
	public WebElement eleTalentpoolMenu;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'WORKSPACE')]//following::a[5]")
	public WebElement eleReportsMenu;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Settings')]")
	public WebElement eleSetting;

	public By eleActiveCandidateCount = By
			.xpath("//body//div[@id='hireApp']//div//div//div//div[1]//a[1]//div[1]//div[1]//div[2]//div[2]/div");

	public By eleTalentPoolCandidateCount = By
			.xpath("//body//div[@id='hireApp']//div//div//div//div[4]//a[1]//div[1]//div[1]//div[2]//div[2]/div");

	public By eleJobsCount = By
			.xpath("//body//div[@id='hireApp']//div//div//div//div[2]//a[1]//div[1]//div[1]//div[2]//div[2]/div");

	public By eleMyJobsCount = By
			.xpath("//body//div[@id='hireApp']//div//div//div//div[3]//a[1]//div[1]//div[1]//div[2]//div[2]/div");

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement eleSearchJobByName;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Add Candidate')]")
	public WebElement eleToverifyAddcandidateText;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Candidate Interview:')]")
	public WebElement eleTovalidateCandidateInterviewScheduled;

	/*
	 * =============================================================================
	 * Home page methods starts here
	 * ============================================================
	 */

	public HomePage verifyHomePageTitle(String data) {
		waitForElementLoad(2000);
		verifyTitle(data);
		waitForElementLoad(2000);
		return this;
	}

	public void clickLogOut() throws InterruptedException {
		clickByAction(eleMouseOverToLogout, eleLoggedout, "LogOut");
	}

	public void clickAddJob() throws InterruptedException {
		clickByAction(eleAddNew, eleAddJob, "AddJob");
	}

	public void clickAddCandidate() throws InterruptedException {
		clickByAction(eleAddNew, eleAddCandidate, "Addcandidate");

	}

	public void clickAddUser() throws InterruptedException {
		clickByAction(eleAddNew, eleAddUser, "Adduser");
	}

	public void clickCandidateMenu() {
		click(eleCandidateMenu, "CandidateMenu");
		waitForElementLoad(2000);
	}

	public void clickJobMenu() {
		click(eleJobMenu, "JobsMenu");
		waitForElementLoad(3000);
	}

	public void clickJobsManagedByMeMenu() {
		click(eleJobsManagedBYMeMenu, "JobsManagedByMeMenu");
	}

	public void clickTalentPoolMenu() {
		click(eleTalentpoolMenu, "TalentPool Menu");
		waitForElementLoad(2000);
	}

	public void clickSettingMenu() throws InterruptedException {
		click(eleSetting, "Setting");
		waitForElementLoad(2000);
	}

	public void clickReportMenu() throws InterruptedException {
		click(eleReportsMenu, "Setting");
	}

	public String getActiveCandidateCount() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleActiveCandidateCount));
		String activecandidateCount = driver.findElement(eleActiveCandidateCount).getText();
		return activecandidateCount;
	}

	public String getTotalJobsCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleJobsCount));
		String jobsCount = driver.findElement(eleJobsCount).getText();
		return jobsCount;
	}

	public String getTalentPoolCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleTalentPoolCandidateCount));
		String talentpoolCount = driver.findElement(eleTalentPoolCandidateCount).getText();
		return talentpoolCount;
	}

	public String getMyJobsCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleMyJobsCount));
		String myjobsCount = driver.findElement(eleMyJobsCount).getText();
		return myjobsCount;
	}

	public void searchJobname(String jobname) {
		clearAndTypeWithTagName(eleSearchJobByName, jobname, "search");
	}

	public String validateJobsearchname(String jobname) {
		String searchjobname = driver.findElement(By.xpath("//a[text()='" + jobname + "']")).getText();
		return searchjobname;
	}

	public String getCandidateCounMappedForThatJob(String jobname) {
		String candidateCount = driver.findElement(By.xpath("//a[text()='" + jobname + "']//following::td[1]/span"))
				.getText();
		return candidateCount;
	}
	
	public String validateCandidateInterviewScheduledText() {
		return getElementText(eleTovalidateCandidateInterviewScheduled);
	}

}
