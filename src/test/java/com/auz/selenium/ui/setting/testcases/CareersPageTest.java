package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.CareersPage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class CareersPageTest extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "CareersPage";
		testSuiteDescription = "Testing the Careers Page(add)Functionality";
		nodes = "CareersPage";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_companyProfile_under_setting_page()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_companyProfile_under_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CareersPage careerspage=new CareersPage(driver, test);
		String companyprofile = (String) jsonsuitetestData.get("companyprofile");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			careerspage.clickOnCareersPageMenu();
			careerspage.enterCompanyProfile(companyprofile);
			careerspage.clickOnUpdateButton();
			reportStep("Company profile updated Successfully", "pass");
			updateTestRailResultAsPass("267849");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("267849");
			Assert.fail(e.getMessage());
		}
	}
	
}
