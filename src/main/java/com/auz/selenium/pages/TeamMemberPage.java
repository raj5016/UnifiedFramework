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

public class TeamMemberPage extends ProjectSpecificMethods{
	public TeamMemberPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Team member page objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Recruiting Preferences')]//following::li/span[text()='Team Members']")
	private WebElement eleTeamMemberMenu;	
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Team Members')]//following::main//div[2]//div[3]/button[1]")
	private WebElement eleAddNewMember;
	
	@FindBy(how=How.ID,using="PeopleSettings_firstname")
	private WebElement eleEnterFirstName;
	
	@FindBy(how=How.ID,using="PeopleSettings_email")
	private WebElement eleEnterEmail;
	
	public By eleSelectRole=By.xpath("//div[contains(text(),'Select Role')]");
	
	@FindBy(how=How.XPATH,using="//input[@id='PeopleSettings_email']//following::button[2]")
	private WebElement eleAddPerson;
	
	@FindBy(how=How.XPATH,using="//body//div//div//div//div//div//div//div//div//div//div//div//div//div//div//div//button[1]")
	private WebElement eleConfirmDeleted;

	/*	=====================================Team Members methods starts===================================================================*/
	public void clickOnTeamMemberMenu() {
		click(eleTeamMemberMenu,"TeamMember Menu");
	}
	
	public void clickOnAddNewMember() {
		click(eleAddNewMember,"AddNew Member");
	}
	
	public void enterFirstName(String firstname) {
		clearAndTypeWithTagName(eleEnterFirstName, firstname, "FirstName field");
	}
	
	public void enterEmail(String email) {
		clearAndTypeWithTagName(eleEnterEmail, email, "Email field");
	}
	
	public void selectRole(String strRole) {
		driver.findElement(eleSelectRole).click();
		driver.findElement(By.xpath("//li[contains(text(),'Admin')]")).click();
		reportStep("The Role selected Successfully", "pass");	
		}
	
	public void clickOnAddPerson() {
		click(eleAddPerson,"AddPersonr");
		waitForElementLoad(2000);
	}
	
	public String validateAddedPerson(String person) {
		String addedPerson=driver.findElement(By.xpath("//div[contains(text(),'"+person+"')]")).getText();
		 return addedPerson;
	}
	
	public String validateAddedEmail(String email) {
		String addedEmail=driver.findElement(By.xpath("//div[contains(text(),'"+email+"')]")).getText();
		 return addedEmail;
	}
	public String validateAddedRole(String role) {
		String addedrole=driver.findElement(By.xpath("//div[contains(text(),'"+role+"')]")).getText();
		 return addedrole;
	}
	
	public void clickOnResentInvite(String role) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+role+"')]//following::li[1]//button[1]")).click();
		reportStep("The Resent Invite sent Successfully", "pass", false);
	}
	
	public void clickOnDeleteTeamMemberAdded(String role) throws InterruptedException {
		waitForElementLoad(2000);
		driver.findElement(By.xpath("//div[contains(text(),'"+role+"')]//following::li[2]//button[1]")).click();
		reportStep("Added Team member deleted successfully", "pass", false);
	}
	
	public void clickOnConfirmDeleteTeamMemberAdded() throws InterruptedException {
		waitForElementLoad(2000);
		click(eleConfirmDeleted, "ConfirmDelete");
		waitForElementLoad(4000);
	}
	public String validateMandatoryFieldsText(String manadatoryText) {
		return driver.findElement(By.xpath("//div[contains(text(),'"+manadatoryText+"')]")).getText();
		 
	}
	public String validateResentInviteAndDeleteSuccessfullText(String resendemailText) {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+resendemailText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
}
