package com.auz.selenium.ui.manage.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.IntegrationsPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.ManagePage;
import com.aventstack.extentreports.Status;

public class Integrations extends ProjectSpecificMethods {
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
	public void TC001_verify_application_navigated_to_setting_integrationpage_when_users_click_on_integrations_submenu_in_ManageMenu(){
		String testName = "TC001_verify_application_navigated_to_setting_integrationpage_when_users_click_on_integrations_submenu_in_ManageMenu";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		IntegrationsPage integrationspage=new IntegrationsPage(driver, test);
		String integrationValdationsText = (String) jsonsuitetestData.get("integrationText");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnIntegrations();
			Assert.assertEquals(integrationspage.validateIntegrationsMenuText(integrationValdationsText), integrationValdationsText);
			reportStep("Application navigated to setting Integration enableing page", "pass");
			updateTestRailResultAsPass("284699");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTraceResult: " + e);
			updateTestRailResultAsFail("284699");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
}
