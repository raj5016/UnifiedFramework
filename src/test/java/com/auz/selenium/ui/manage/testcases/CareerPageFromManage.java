package com.auz.selenium.ui.manage.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.ManagePage;
import com.aventstack.extentreports.Status;

public class CareerPageFromManage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Integration-ManagePage";
		testSuiteDescription = "Testing the enableing Integration Functionality In Manage Menu";
		nodes = "Integration";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_application_navigated_to_career_page_and_search_for_a_job__when_users_click_on_careerpage_submenu_in_ManageMenu(){
		String testName = "TC001_verify_application_navigated_to_career_page_and_search_for_a_job__when_users_click_on_careerpage_submenu_in_ManageMenu";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String careerpageheadValdationsText = (String) jsonsuitetestData.get("careerpageheadValdationsText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnCareerPage();
			managepage.switchtoCareerPage();
			managepage.EnterOnCareerSearch(jobtitle);
			Assert.assertEquals(managepage.validateCareerPageHeadText(), careerpageheadValdationsText);
			reportStep("Application navigated to the external Career Link Page", "pass");
			updateTestRailResultAsPass("290623");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTraceResult: " + e);
			updateTestRailResultAsFail("290623");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
}
