package com.auz.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class CareersPage extends ProjectSpecificMethods{
	public CareersPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Email Template Page Objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Custom Fields')]//following::li/span[text()='Career Page']")
	private WebElement eleCareerPageMenu;	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Company Profile')]//following::div//div//div//div//div[1]")
	private WebElement eleEnterCompanyProfile;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Company Profile')]//following::div/button[1]")
	private WebElement eleUpdateButton;
	
	/*	=====================================Email templates methods starts===================================================================*/
	public void clickOnCareersPageMenu() throws InterruptedException {
		click(eleCareerPageMenu,"CareersPage");
	}
	public void enterCompanyProfile(String companyprofile) {
		clearAndTypeWithTagName(eleEnterCompanyProfile, companyprofile, "CompanyProfile");
	}
	
	public void clickOnUpdateButton() {
		click(eleUpdateButton,"UpdateButton");
	}
	
}
