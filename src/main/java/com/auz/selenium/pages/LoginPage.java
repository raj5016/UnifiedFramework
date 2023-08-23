package com.auz.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.aventstack.extentreports.ExtentTest;

public class LoginPage extends ProjectSpecificMethods{
	public  String strtestdatafilename="UiTestData";
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	 
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;	
	
	@FindBy(how=How.ID,using="domain")
	private WebElement eleDomain;	
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;	
	
	@FindBy(how=How.ID,using="signin-button")
	private WebElement eleLogin;
	
	public final By byuserName=By.id("username");
	
	public void enterUserName(String username) {	
		clearAndTypeWithTagName(eleUserName, username,"UserName");
	}	
	
	public void enterDomain(String domain) {	
		clearAndTypeWithTagName(eleDomain, domain,"Domain");
	}

	public void enterPassword(String password) {
		clearAndTypeWithTagName(elePassword, password,"PassWord");
	}	
	
	public void clickLogin() {
		click(eleLogin);
	}
	
	
}
