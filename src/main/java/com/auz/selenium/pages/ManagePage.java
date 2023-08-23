package com.auz.selenium.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;


public class ManagePage extends ProjectSpecificMethods{

	public ManagePage(RemoteWebDriver driver,ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}		


	@FindBy(how=How.XPATH,using="//span[contains(text(),'Invite')]")
	private WebElement eleOfInviteTeamMember;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'MANAGE')]//following::ul//li//button")
	private WebElement eleOfTeamMember;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Integrations')]")
	private WebElement eleOfIntegrations;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Career Page')]")
	private WebElement eleOfCareerPage;
	
	@FindBy(how=How.XPATH,using="//section/main/div/div/div/div/span/input")
	private WebElement eleOfCareerSearch;
	
	/*
	 * =============================================================================Home page methods starts here ============================================================
	 */
	
	public void clickOnTeamMember() {
		clickBySingleAction(eleOfTeamMember, "TeamMember");
	}
	
	public void clickOnInviteTeamMember() {
		clickBySingleAction(eleOfInviteTeamMember, "InviteTeamMember");
	}
	
	public void clickOnIntegrations() {
		clickBySingleAction(eleOfIntegrations, "Integrations");
		waitForElementLoad(1000);
	}
	
	public void clickOnCareerPage() {
		clickBySingleAction(eleOfCareerPage, "CareerPage");
		waitForElementLoad(1000);
	}
	
	public void switchtoCareerPage() {
		switchToWindow(1);
		waitForElementLoad(1000);
	}
	
	public void switchtoHirePage() {
		switchToWindow(0);
		waitForElementLoad(1000);
	}
	
	public void EnterOnCareerSearch(String JobTitle) {
		clearAndTypeWithTagName(eleOfCareerSearch, JobTitle,"CareerPageSearch");
		waitForElementLoad(1000);
	}
	
	public void clickOnSearchButton() {
		clickBySingleAction(eleOfCareerPage, "CareerPage");
		waitForElementLoad(1000);
	}
	
	public String validateCareerPageHeadText()  {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div/div/div/div[2]/div")).getText();
	}
	
	public void refreshCareerPage() {
		refreshBrowser();
	}
}










