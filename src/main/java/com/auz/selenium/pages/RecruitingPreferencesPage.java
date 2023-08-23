package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class RecruitingPreferencesPage extends ProjectSpecificMethods{
	public RecruitingPreferencesPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Recruiting Preferences page objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Recruiting Preferences')]")
	private WebElement eleRecruitingPreferencemenu;	
	
	@FindBy(how=How.XPATH,using="//div[@id='hireApp']//following::div//div//div//div//div//div//div//div//div//div[1]//div[1]//div[1]//button")
	private WebElement eleAddStage;
	
	@FindBy(how=How.ID,using="interviewStage_title")
	private WebElement eleEnterStageTitle;
	
	@FindBy(how=How.XPATH,using="//input[@id='interviewStage_title']//preceding::div[2]/div[1]/button[1]")
	private WebElement eleUpdateButtonAfterAddingStage;
	
	@FindBy(how=How.XPATH,using="//body/div/div/div/div/div/div/section/main/div/div/div/div/div/div/div/button[1]")
	private WebElement eleSaveAddStage;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'OnRound')]")
	private WebElement eleValidateAddedStage;
	
	@FindBy(how=How.XPATH,using="//body//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//button[1]")
	private WebElement eleClickOnConfirmDeleteStage;
	

	/*	=====================================Recruiting Preferences methods starts===================================================================*/
	public void clickOnRecruitingPreferenceMenu() {
		click(eleRecruitingPreferencemenu,"RecruitingPreference");
	}
	
	public void clickOnAddStage() {
		click(eleAddStage,"AddStage");
	}
	
	public void enterStageName(String stageName) {
		clearAndTypeWithTagName(eleEnterStageTitle, stageName, "StageTitle Button");
	}
	
	public void clickUpdateButtonAfterStagesValueEntered() {
		click(eleUpdateButtonAfterAddingStage,"Update Button");
	}
	
	public void clickOnSaveButtoonAfterValueEntered() {
		click(eleSaveAddStage,"Save Button");
	}
	
	public String validateAddedStage() {
		String addedStage= getElementText(eleValidateAddedStage);
		 return addedStage;
	}
	
	public void clickOnEditStageButton(String stageName) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+stageName+"')]//following::i[1]//*[local-name()='svg']")).click();
		reportStep("The Element " + stageName + " clicked on Edit Button", "pass", false);
	}
	
	public void clickOnDeleteStageButton(String stageName) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+stageName+"')]//following::i[2]//*[local-name()='svg']")).click();
		reportStep("The Element " + stageName + " clicked on Delete Button", "pass", false);
	}
	
	public void clickOnStageConfirmDeleteButton() throws InterruptedException {
		click(eleClickOnConfirmDeleteStage, "confirmDelete button");
		Thread.sleep(3000);
	}
	public String validateStageRequiredText(String stageNameErrorName)  {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+stageNameErrorName+"')]")).getText();
	}
}
