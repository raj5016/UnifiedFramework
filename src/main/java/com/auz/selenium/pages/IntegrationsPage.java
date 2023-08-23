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

public class IntegrationsPage extends ProjectSpecificMethods{
	public IntegrationsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	/*	=====================================Integration page objects starts===================================================================*/

	@FindBy(how=How.XPATH,using="//div[contains(text(),'Job Boards')]")
	private WebElement eleJobBoardSubMenu;	
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Post Jobs')]//following::button[1]")
	private WebElement eleClickOnEnableAndDisableJobTarget;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Navigation')]//following::li[4]/span")
	private WebElement eleOfIntegrations;

	/*	=====================================Integration methods starts===================================================================*/
	public void clickOnIntegrations() {
		clickBySingleAction(eleOfIntegrations, "Integrations");
		waitForElementLoad(1000);
	}
	
	public void clickOnJobBoardSubMenu() {
		clickBySingleAction(eleJobBoardSubMenu, "JobBoard");
	}
	
	public void clickOnEnableAndDisableJobBoard(String enabledisable) {
		clickBySingleAction(eleClickOnEnableAndDisableJobTarget, enabledisable);
	}
	
	public String validateIntegrationsMenuText(String integrationsSubmenuText)  {
		waitForElementLoad(2000);
		return driver.findElement(By.xpath("//div[contains(text(),'"+integrationsSubmenuText+"')]")).getText();
	}
	
	public String validateJobtargetEnableAndDisableText(String jobtargetEnableAndDisableText)  {
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'"+jobtargetEnableAndDisableText+"')]"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		return getElementText(ele);
	}
}
