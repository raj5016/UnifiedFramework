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


public class ReportsPage extends ProjectSpecificMethods{

	public ReportsPage(RemoteWebDriver driver,ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}		

	public By eleTotalcandidateCount=By.xpath("//div[contains(text(),'Total Candidates')]//following::div[1]/div");

	public By eleArchivedCandidateCount=By.xpath("//div[contains(text(),'Archived')]//following::div[1]/div");

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Candidate Analytics')]")
	private WebElement eleCandidateAnalysis;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Job Analytics')]")
	private WebElement eleJobAnalysis;
	
	public By elePublishedJobCount=By.xpath("//div[contains(text(),'Published')]//following::div[1]/div");

	public By eleOpenJobCount=By.xpath("//div[contains(text(),'Open Jobs')]//following::div[1]/div");

	public By eleClosedJobCount=By.xpath("//div[contains(text(),'Closed')]//following::div[1]/div");

	public By eleInternalJobCount=By.xpath("//div[contains(text(),'Internal')]//following::div[1]/div");

	
	/*
	 * =============================================================================Home page methods starts here ============================================================
	 */
	
	
	public String getReportsCandidateCount() throws InterruptedException {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleTotalcandidateCount));		
		String	candidateCount=driver.findElement(eleTotalcandidateCount).getText();
		return candidateCount;
		
	}
	
	public String getReportsArchivedCandidateCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleArchivedCandidateCount));		
		String	archivedCount=driver.findElement(eleArchivedCandidateCount).getText();
		return archivedCount;
	}
	
	public String getPublishedJobCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elePublishedJobCount));		
		String	publishedJobCount=driver.findElement(elePublishedJobCount).getText();
		return publishedJobCount;
	}
	
	public void selectJobAnalysis() throws InterruptedException {
		clickByAction(eleCandidateAnalysis, eleJobAnalysis, "Job Analysis");
	}
	
	public String getOpenJobCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleOpenJobCount));		
		String	openJobCount=driver.findElement(eleOpenJobCount).getText();
		return openJobCount;
	}
	
	public String getClosedJobCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleClosedJobCount));		
		String	closedJobCount=driver.findElement(eleClosedJobCount).getText();
		return closedJobCount;
	}
	
	public String getInternalJobCount() {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(eleInternalJobCount));		
		String	internalJobCount=driver.findElement(eleInternalJobCount).getText();
		return internalJobCount;
	}
	
	
}










