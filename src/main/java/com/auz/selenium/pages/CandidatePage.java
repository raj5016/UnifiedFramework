package com.auz.selenium.pages;

import java.awt.AWTException;
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


public class CandidatePage extends ProjectSpecificMethods{

	public CandidatePage(RemoteWebDriver driver,ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}		

	@FindBy(xpath="//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//button[1]")
	public WebElement eleofFirstCandidate;
	
	public By byeleofFirstCandidate=By.xpath("//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[1]//div[1]//button[1]");

	@FindBy(xpath="//li[3]//ul[1]//li[2]//a[1]")
	public WebElement eleCandidatemenu;
	
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
	
	@FindBy(xpath="//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[6]//button[1]")
	public WebElement eleOfMouseOverCandidateName;
	
	@FindBy(xpath="//li[contains(text(),'Edit')]")
	public WebElement eleOfEditCandidateName;
	
	@FindBy(xpath="//div[contains(text(),'Archive')]")
	public WebElement eleOfArcheiveCandidateName;
	
	@FindBy(xpath="//li[contains(text(),'Delete')]")
	public WebElement eleOfDeleteCandidateName;
	
	@FindBy(xpath="//li[contains(text(),'Move to Talent Pool')]")
	public WebElement eleOfMoveToTalentPool;
	
	@FindBy(xpath="//div[contains(text(),'Do you really want to delete')]//following::button[1]")
	public WebElement eleOfConfirmDeleteCandidateName;
	
	public By eleAllCandidateCount=By.xpath("//div[contains(text(),'All Candidates (')]");
	
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
	
	@FindBy(how = How.XPATH, using = "//div/div/div/div/div/span/div/div/div[1]/label[1]/span[1]/input[1]")
	public WebElement eleToClickOnAppliedFilter;
	
	public By eleValidateSourcesFilterText=By.xpath("//body//div[@id='hireApp']//div//div//div//div//div//div//div[1]//div[1]//div[4]");
	
	@FindBy(how = How.XPATH, using = "//input[@value='Sourced']")
	public WebElement eleToClickOnSourcedFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='EmployeeReferral']")
	public WebElement eleToClickOnEmployeeReferralFilter;
	
	public By eleValidateEmployeeReferralFilterText=By.xpath("//div[contains(text(),'EmployeeReferral')]");
	
	@FindBy(how = How.XPATH, using = "//input[@value='University']")
	public WebElement eleToClickOnUniversityFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Agency']")
	public WebElement eleToClickOnAgencyFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='LinkedIn']")
	public WebElement eleToClickOnLinkedInFilter;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Other']")
	public WebElement eleToClickOnOtherFilter;
	
	public By eleToSelectOwner=By.xpath("//div[contains(text(),'e.g. Any Employee')]");
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'automation')]")
	public WebElement eleToSelectRespectiveOwner;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'e.g. Product Manager')]")
	public WebElement eleToSelectJobFilter;
	
	@FindBy(how = How.XPATH, using = "//header[2]//div[1]//div[2]//div[1]//div[2]//button[1]")
	public WebElement eleToClickOnApply;
	
	@FindBy(xpath="//li[contains(text(),'Career Page Link')]")
	public WebElement eleToClickOnCareerPageLink;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement eleToSearchcandidate;
	
	@FindBy(xpath="//header//div//div//div//div[3]/button[1]")
	public WebElement eleofImportLink;
	
	@FindBy(xpath="//span[contains(text(),'Import Candidate')]//parent::button")
	public WebElement eleofImportButton;
	
	@FindBy(xpath="//span[contains(text(),'Upload File')]//parent::button")
	public WebElement eleofUploadFileButton;
	
	@FindBy(xpath="//span[contains(text(),'Continue')]//parent::button")
	public WebElement eleofContinueinImportPage;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[1]/div[1]")
	public WebElement eleofFiledinAuzmorHiredrop;
	
	@FindBy(xpath="//body/div/div/div/div/ul/li[1]")
	public WebElement eleofSelectfromAuzmorHiredrop;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div[2]/div[3]/div[1]/div[1]/div[1]")
	public WebElement eleofFiledinJobStagedrop;
	
	@FindBy(xpath="//div[contains(text(),'Incorrect File Uploaded!')]")
	public WebElement eleofimporterrmessagetext;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/span/div/div/span/div/div/span/span/a")
	public WebElement eleofremovefilebutton;
	
	@FindBy(xpath="//span[contains(text(),'Go Back')]//parent::button")
	public WebElement eleofGoBackbutton;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/span/div/div/span/div/div/span/span[1]")
	public WebElement eleofuploadedfilesection;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/a")
	public WebElement eleofSampleFilelink;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div[3]/div[2]/div[1]/div[1]/div[1]")
	public WebElement eleofFiledinAuzmorHireMultiplecandidate;
	
	@FindBy(xpath="//body[1]/div[4]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	public WebElement eleofSelectfromAuzmorHiredropMultipleCandidate;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/div/div/div[2]/div/div/div")
	public WebElement eleofFiledinmapping;
	
	@FindBy(xpath="//li[contains(text(),'Last Name')]")
	public WebElement eleofSelectfrommapping;
	
	@FindBy(id="CandidateFilters_followerIds")
	public WebElement eleoffollowedByYouFilter;
	
	@FindBy(xpath="//body/div/div/section/section/main/div/div[1]/div[2]/div[3]/form[1]/div[8]/div[2]/div[1]/span[1]/span[1]/div[2]/span[1]/div[1]/button[1]")
	public WebElement eleofUploadFileButtonInCareerPage;
	/*
	 * 
	 * =============================================================================Home page methods starts here ============================================================
	 */
	
	public void clickOnCandidateMenu() {
		click(eleCandidatemenu,"CandidateMenu");
	}
	
	public void clickOnCandidate() {
		click(eleofFirstCandidate,"CandidateDetails");
	}
	
	public String validateCandidateCreatedSuccessText(String Strname) {
		String candidatename=driver.findElement(By.xpath("//span[contains(text(),'"+Strname+"')]")).getAttribute("value");
		System.out.println(candidatename);
		return candidatename;
	}
	
	public void clickManuallyAddCandidate() throws InterruptedException {
		clickByAction(eleOfAddCandidateLink,eleOfManuallyAddCandidateLink,"ManualAddcandidateLink");
	}
	
	public void clickOnEditCandidate() throws InterruptedException {
		clickByAction(eleOfMouseOverCandidateName,eleOfEditCandidateName,"EditcandidateLink");
	}
	
	public void clickOnArchive() throws InterruptedException {
		clickByAction(eleOfMouseOverCandidateName,eleOfArcheiveCandidateName,"ArcheiveMenu");
	}
	
	public void clickOnDelete() throws InterruptedException {
		clickByAction(eleOfMouseOverCandidateName,eleOfDeleteCandidateName,"Delete");
		click(eleOfConfirmDeleteCandidateName);
	}
	
	public void clickOnMoveToTalentPool() throws InterruptedException {
		clickByAction(eleOfMouseOverCandidateName,eleOfMoveToTalentPool,"MoveTotalentPool");
	}
	
	public void clickArchiveCandidateByReason(String strArcheiveReason) throws InterruptedException {
		WebElement eleArcheiveReason=driver.findElement(By.xpath("//li[contains(text(),'"+strArcheiveReason+"')]"));
		clickByAction(eleOfArcheiveCandidateName,eleArcheiveReason,strArcheiveReason);
	}
	
	public String getFirstCandidateNameAdded() throws InterruptedException {
		String name= getElementText(eleofFirstCandidate);
		waitForElementLoad(1000);
		return name;
	}

	public String getAllCandidateCount() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleAllCandidateCount));
		String	allcandidateCount=driver.findElement(eleAllCandidateCount).getText();
		return allcandidateCount;
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
		waitForElementLoad(3000);
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
		waitForElementLoad(3000);
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
	
	public String validateCandidateNameAterUnArchivedFromCandidateEditPage(String name){
		WebElement eleArchivedCandidateName = driver
				.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
		String archivedCandidateName = getElementText(eleArchivedCandidateName);
		return archivedCandidateName;
	}
	
	public String validateCandidateLocationAterEditingInformationInCandidateEditPage(String name) throws InterruptedException{
		waitForElementLoad(2000);
		WebElement eleLocationCandidateName = driver
				.findElement(By.xpath("//span[contains(text(),'"+name+"')]//following::div[2]"));
		String getCandidateLocation = getElementText(eleLocationCandidateName);
		return getCandidateLocation;
	}
	
	public void clickAddViaResumeCandidate() throws InterruptedException {
		clickByAction(eleOfAddCandidateLink,eleOfAddViaResumeCandidateLink,"AddViaResumeCandidateLink");
	}
	public void clickBrowseResumeCandidate(String filename) throws InterruptedException {
		click(eleToClickAndBrowseResumeToAdd,"Browse");
		waitForElementLoad(4000);
		uploadFile(filename);
		waitForElementLoad(5000);
	}
	
	public void clickProceedAfterFileUpload() throws InterruptedException {
		click(eleToClickProceedButton,"Proceed");
		waitForElementLoad(5000);
	}
	
	public void searchCandidate(String candidateName) throws InterruptedException {
		clearAndTypeWithTagName(eleToSearchcandidate, candidateName, "Search");
	}
	
	public void clickOnImportLink() {
		click(eleofImportLink,"ImportCandidateDetailsLink");
		waitForElementLoad(2000);
	}
	
	public void clickOnImportButton() {
		click(eleofImportButton,"ImportButtonforcandidatedetails");
		waitForElementLoad(2000);
	}
	
	public void clickOnUploadCSVFile(String filename) {
		click(eleofUploadFileButton,"UploadCSVFile");
		waitForElementLoad(4000);
		uploadCSVFile(filename);
		waitForElementLoad(4000);
	}
	
	public void clickOnContinueButtonInImportCandidate() {
		click(eleofContinueinImportPage,"ContinueButtoninimportCandidatepage");
		waitForElementLoad(4000);
	}
	
	public void clickOnFieldinAuzmour() throws InterruptedException {
		click(eleofFiledinAuzmorHiredrop,"SelectFieldinAuzmorHire");
		waitForElementLoad(3000);
		clickByAction(eleofSelectfromAuzmorHiredrop,eleofSelectfromAuzmorHiredrop,"FieldAuzmorHire");
		waitForElementLoad(3000);
	}
	
	public void selectjobstageinImportpage(String strJobStage) throws InterruptedException {
		click(eleofFiledinJobStagedrop,"SelectFieldinJobStage");
		WebElement eleofSelectfromJobStagedrop=driver.findElement(By.xpath("//li[contains(text(),'"+strJobStage+"')]"));
		clickByAction(eleofSelectfromJobStagedrop,eleofSelectfromJobStagedrop,strJobStage);
	}
	
	public String getErrorMessagewhilecandidateImport() throws InterruptedException {
		String importerrmessage = getElementText(eleofimporterrmessagetext);
		waitForElementLoad(1000);
		return importerrmessage;
	}
	
	public boolean getContinuebuttonStatus() {
		boolean continubtn =driver.findElement(By.xpath("//span[contains(text(),'Continue')]//parent::button")).isEnabled();
		return continubtn;
	}
	
	public void clickonremovefileinImportpage() throws InterruptedException {
		clickByAction(eleofuploadedfilesection,eleofremovefilebutton,"Remove file button");
		waitForElementLoad(1000);
	}
	
	public void clickOnGoBackbutton() {
		waitForElementLoad(1000);
		click(eleofGoBackbutton,"GoBackButton");
	}
	
	public void clickOnSampleFilelink() throws InterruptedException {
		waitForElementLoad(2000);
		clickByAction(eleofSampleFilelink,eleofSampleFilelink,"Sample File Link");
	}
	
	public void clickOnFieldinAuzmourMultipleCandidate() throws InterruptedException {
		click(eleofFiledinAuzmorHireMultiplecandidate,"SelectFieldinAuzmorHireMultiplecandidate");
		waitForElementLoad(3000);
		clickByAction(eleofSelectfromAuzmorHiredropMultipleCandidate,eleofSelectfromAuzmorHiredropMultipleCandidate,"FieldAuzmorHire");
		waitForElementLoad(3000);
	}
	
	public void selectDuplicateFieldsinMapping(String strfieldName) throws InterruptedException, AWTException {
		click(eleofFiledinmapping,"SelectDuplicateFieldinAuzmorHire");
		waitForElementLoad(3000);
		WebElement eleofSelectfrommapping=driver.findElement(By.xpath("//li[contains(text(),'"+strfieldName+"')]"));
		clickByAction(eleofSelectfrommapping,eleofSelectfrommapping,"Duplicatefiledselection");
	}
	
	public void clickOnFollowedByYouFilter() {
		Actions action=new Actions(driver);
		action.moveToElement(eleoffollowedByYouFilter).click().build().perform();
		waitForElementLoad(3000);
	}
	
	public void clickAddCandidateResumeInCareerPage(String fileName) {
		click(eleofUploadFileButtonInCareerPage,"AddResume");
		waitForElementLoad(3000);
		uploadFile(fileName);
		waitForElementLoad(4000);
	}
}










