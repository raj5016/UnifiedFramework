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

public class TalentPoolPage extends ProjectSpecificMethods{
	public TalentPoolPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}

	@FindBy(how=How.XPATH,using="//a[@href='/talentpool']")
	private WebElement eleTalentPoolMenu;
	
	@FindBy(how=How.XPATH,using="//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//button[1]")
	private WebElement eleTalentPoolFirstCandidate;
	
	@FindBy(how=How.XPATH,using="//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[6]//button[1]")
	private WebElement eleMouseOverToEditAndArchiveCanidate;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Edit')]")
	private WebElement eleTalentPoolEditCandidate;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Unarchive')]")
	private WebElement eleTalentPoolUnArchiveCandidate;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Delete')]")
	private WebElement eleTalentPoolDeleteCandidate;
	
	@FindBy(xpath="//header//div//div//div[2]//button[1]")
	public WebElement eleOfAddCandidateLink;
	
	@FindBy(xpath="//li[contains(text(),'Add Manually')]")
	public WebElement eleOfManuallyAddCandidateLink;
	
	@FindBy(xpath="//li[contains(text(),'Add via Resume')]")
	public WebElement eleOfAddViaResumeCandidateLink;
	
	@FindBy(xpath="//*[contains(text(),'Drag Files to Upload')]//following::div//button[1]")
	public WebElement eleToClickAndBrowseResumeToAdd;
	
	@FindBy(xpath="//div//div[3]//button[2]")
	public WebElement eleToClickProceedButton;
	
	public By eleAllCandidateCount=By.xpath("//div[contains(text(),'All Candidates (')]");

	public By eleValidateArchivedcandidateTex=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[1]");

	public By eleArchiveCandidateCount=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div[1]");

	public By eleSelectTagCount=By.xpath("//body//div[@id='hireApp']//div//div//div//div[2]//div[1]//div[1]//span[1]//i[1]//*[local-name()='svg']");

	public By eleSelectArchiveTagCount=By.xpath("//li[contains(text(),'Archived')]");
	
	public By eleSelectSourceTagCount=By.xpath("//li[contains(text(),'Sourced')]");
	
	public By eleValidateArchivedFilterText=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/span[1]");

	public By eleValidateFilterText=By.xpath("//body/div[@id='hireApp']/div/section/section/main/section/main/div[1]");
	
	public By eleSortBySelectTagCount=By.xpath("//body//div[@id='hireApp']//div//div//div//div[4]//div[1]//div[1]//span[1]//i[1]//*[local-name()='svg']");

	public By eleSortByDateAdded=By.xpath("//li[contains(text(),'Date Added')]");

	public By eleSortByNameAdded=By.xpath("//li[contains(text(),'Name')]");
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='hireApp']/div/section/section/main/section/div/div/div/div/span/button[1]")
	public WebElement eleToClickOnMoreFilter;
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div//div//div//div[1]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnAppliedFilter;
	
	public By eleValidateSourcesFilterText=By.xpath("//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[4]");
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[2]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnSourcedFilter;
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[3]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnEmployeeReferralFilter;
	
	public By eleValidateEmployeeReferralFilterText=By.xpath("//div[contains(text(),'EmployeeReferral')]");
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[4]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnUniversityFilter;
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[5]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnAgencyFilter;
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[6]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnLinkedInFilter;
	
	@FindBy(how = How.XPATH, using = "//body//div[@id='hireApp']//div//div//div[7]//label[1]//span[1]//input[1]")
	public WebElement eleToClickOnOtherFilter;
	
	public By eleToSelectOwner=By.xpath("//div[contains(text(),'e.g. Any Employee')]");
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'automation')]")
	public WebElement eleToSelectRespectiveOwner;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'e.g. Product Manager')]")
	public WebElement eleToSelectJobFilter;
	
	@FindBy(how = How.XPATH, using = "//header[2]//div[1]//div[2]//div[1]//div[2]//button[1]")
	public WebElement eleToClickOnApply;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement eleToSearchcandidate;
	
	@FindBy(id="CandidateFilters_followerIds")
	public WebElement eleoffollowedByYouFilter;
	
	public void clickTalentPoolMenu() {
		clickBySingleAction(eleTalentPoolMenu,"TalentPoolMenu");
		waitForElementLoad(2000);
	}
	
	public String getFirstCandidateNameAdded() {
		String name= getElementText(eleTalentPoolFirstCandidate);
		 return name;
	}
	
	public void clickUnArchiveCandidate() {
		try {
			clickByAction(eleMouseOverToEditAndArchiveCanidate, eleTalentPoolUnArchiveCandidate, "Unarchive");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickEditCandidate() {
		try {
			clickByAction(eleMouseOverToEditAndArchiveCanidate, eleTalentPoolEditCandidate, "Edit");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickDeleteCandidate() {
		try {
			clickByAction(eleMouseOverToEditAndArchiveCanidate, eleTalentPoolDeleteCandidate, "Delete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTalentPoolCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleAllCandidateCount));		
		String	candidatecount=driver.findElement(eleAllCandidateCount).getText();
		return candidatecount;
	}
	
	public void clickManuallyAddCandidate() throws InterruptedException {
		clickByAction(eleOfAddCandidateLink,eleOfManuallyAddCandidateLink,"ManualAddcandidateLink");
	}
	
	public String validateArchivedText() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleValidateArchivedcandidateTex));		
		String	archivedText=driver.findElement(eleValidateArchivedcandidateTex).getText();
		return archivedText;
	}
	public void selectArchieveCandidate() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectTagCount));
		driver.findElement(eleSelectTagCount).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectArchiveTagCount));
		driver.findElement(eleSelectArchiveTagCount).click();
		waitForElementLoad(2000);
		reportStep("The archived Candidated selected Successfully", "pass");
	}
	
	public String getArchiveCandidateCount() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleArchiveCandidateCount));
		String	archivecandidateCount=driver.findElement(eleArchiveCandidateCount).getText();
		return archivecandidateCount;
	}
	
	public void selectSourcedCandidate() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectTagCount));
		driver.findElement(eleSelectTagCount).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSelectSourceTagCount));
		driver.findElement(eleSelectSourceTagCount).click();
		waitForElementLoad(2000);
		reportStep("The Sourced Candidated selected Successfully", "pass");
	}
	
	public String validateFilterText() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleValidateFilterText));
		String	filterText=driver.findElement(eleValidateFilterText).getText();
		return filterText;
	}
	
	public void selectSortByDateAdded() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSortBySelectTagCount));
		driver.findElement(eleSortBySelectTagCount).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSortByDateAdded));
		driver.findElement(eleSortByDateAdded).click();
		waitForElementLoad(2000);
		reportStep("Sort By date Added tag selected Successfully", "pass");
	}
	
	public void selectSortByNameAdded() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSortBySelectTagCount));
		driver.findElement(eleSortBySelectTagCount).click();
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleSortByNameAdded));
		driver.findElement(eleSortByNameAdded).click();
		waitForElementLoad(2000);
		reportStep("Sort By Name tag selected Successfully", "pass");
	}
	
	public void clickOnMoreFilters() {
		click(eleToClickOnMoreFilter, "More Filter");
	}
	
	public void clickOnAppliedFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnAppliedFilter).click().build().perform();
	}
	
	public void clickOnSourcedFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnSourcedFilter).click().build().perform();
	}
	
	public void clickOnEmployeeReferralFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnEmployeeReferralFilter).click().build().perform();
	}
	
	public void clickOnUniversityFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnUniversityFilter).click().build().perform();
	}
	
	public void clickOnAgencyFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnAgencyFilter).click().build().perform();
	}
	
	public void clickOnLinkedInFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnLinkedInFilter).click().build().perform();
	}
	
	public void clickOnOtherInFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnOtherFilter).click().build().perform();
	}
	
	public void selectByOwnerFilter() throws InterruptedException {
		driver.findElement(eleToSelectOwner).click();
		Actions action=new Actions(driver);
		action.moveToElement(eleToSelectRespectiveOwner).click().build().perform();
	}
	
	public void clickOnApplyFilter() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(eleToClickOnApply).click().build().perform();
		waitForElementLoad(1000);
	}
	
	public String validateArchivedFilterText() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleValidateArchivedFilterText));
		String	archivedfilterText=driver.findElement(eleValidateArchivedFilterText).getText();
		return archivedfilterText;
	}
	
	public String validateSourcesFilterText() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleValidateSourcesFilterText));
		String	filterText=driver.findElement(eleValidateSourcesFilterText).getText();
		return filterText;
	}
	
	public String validateCandidateNameAterArchivedFromCandidateEditPage(String name) throws InterruptedException {
		WebElement eleArchivedCandidateName = driver
				.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
		String archivedCandidateName = getElementText(eleArchivedCandidateName);
		return archivedCandidateName;
	}
	
	public void clickAddViaResumeCandidate() throws InterruptedException {
		clickByAction(eleOfAddCandidateLink,eleOfAddViaResumeCandidateLink,"AddViaResumeCandidateLink");
	}
	public void clickBrowseResumeCandidate(String filename) throws InterruptedException {
		click(eleToClickAndBrowseResumeToAdd,"Browse");
		waitForElementLoad(2000);
		uploadFile(filename);
		waitForElementLoad(4000);
	}
	
	public void clickProceedAfterFileUpload() throws InterruptedException {
		click(eleToClickProceedButton,"Proceed");
		waitForElementLoad(5000);
	}
	
	public void searchCandidate(String candidateName) throws InterruptedException {
		clearAndTypeWithTagName(eleToSearchcandidate, candidateName, "Search");
	}
	
	public void clickonCandidateFirstName() throws InterruptedException {
		click(eleTalentPoolFirstCandidate,"Candidate");
	}
	public String validateCandidateLocationAterEditingInformationInCandidateEditPage(String name) throws InterruptedException{
		waitForElementLoad(2000);
		WebElement eleLocationCandidateName = driver
				.findElement(By.xpath("//span[contains(text(),'"+name+"')]//following::div[2]"));
		String getCandidateLocation = getElementText(eleLocationCandidateName);
		return getCandidateLocation;
	}
	public void clickOnFollowedByYouFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleoffollowedByYouFilter).click().build().perform();
		waitForElementLoad(1000);
	}
}
