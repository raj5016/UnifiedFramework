package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.RecruitingPreferencesPage;
import com.aventstack.extentreports.Status;

public class RecruitingPreferences extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "RecruitingPreferences";
		testSuiteDescription = "Testing the functionality of SettingFeatures";
		nodes = "CompanySetting";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_staging_under_recruitingPreferences_in_setting_page()
			throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_staging_under_recruitingPreferences_in_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		RecruitingPreferencesPage recruitingpreferencesPage=new RecruitingPreferencesPage(driver, test);
		String stageName = (String) jsonsuitetestData.get("StageName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			recruitingpreferencesPage.clickOnRecruitingPreferenceMenu();
			recruitingpreferencesPage.clickOnAddStage();
			recruitingpreferencesPage.enterStageName(stageName);
			recruitingpreferencesPage.clickUpdateButtonAfterStagesValueEntered();
			recruitingpreferencesPage.clickOnSaveButtoonAfterValueEntered();
			Assert.assertEquals(recruitingpreferencesPage.validateAddedStage(), stageName);
			reportStep("Interview Stage :" + stageName + " added Successfully", "pass");
			updateTestRailResultAsPass("262097");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262097");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_edit_the_added_stage_name_under_recruitingPreferences_in_setting_page()
			throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_edit_the_added_stage_name_under_recruitingPreferences_in_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		RecruitingPreferencesPage recruitingpreferencesPage=new RecruitingPreferencesPage(driver, test);
		String stageName = (String) jsonsuitetestData.get("StageName");
		String editstageName = (String) jsonsuitetestData.get("EditStageName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			recruitingpreferencesPage.clickOnRecruitingPreferenceMenu();
			recruitingpreferencesPage.clickOnEditStageButton(stageName);
			recruitingpreferencesPage.enterStageName(editstageName);
			recruitingpreferencesPage.clickUpdateButtonAfterStagesValueEntered();
			recruitingpreferencesPage.clickOnSaveButtoonAfterValueEntered();
			Assert.assertEquals(recruitingpreferencesPage.validateAddedStage(), editstageName);
			reportStep("Interview Stage :" + editstageName + " edited Successfully", "pass");
			updateTestRailResultAsPass("262104");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262104");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_delete_the_added_stage_name_under_recruitingPreferences_in_setting_page()
			throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_delete_the_added_stage_name_under_recruitingPreferences_in_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		RecruitingPreferencesPage recruitingpreferencesPage=new RecruitingPreferencesPage(driver, test);
		String editstageName = (String) jsonsuitetestData.get("EditStageName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			recruitingpreferencesPage.clickOnRecruitingPreferenceMenu();
			recruitingpreferencesPage.clickOnDeleteStageButton(editstageName);
			recruitingpreferencesPage.clickOnStageConfirmDeleteButton();
			recruitingpreferencesPage.clickOnSaveButtoonAfterValueEntered();
			reportStep("Interview Stage :" + editstageName + " deleted Successfully", "pass");
			updateTestRailResultAsPass("262111");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262111");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_application_throwing_error_when_stage_is_not_entered_under_recruitingPreferences_in_setting_page(){
		String testName = "TC004_verify_application_throwing_error_when_stage_is_not_entered_under_recruitingPreferences_in_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		RecruitingPreferencesPage recruitingpreferencesPage=new RecruitingPreferencesPage(driver, test);
		String stageNameError = (String) jsonsuitetestData.get("stageNameErrorName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			recruitingpreferencesPage.clickOnRecruitingPreferenceMenu();
			recruitingpreferencesPage.clickOnAddStage();
			recruitingpreferencesPage.clickUpdateButtonAfterStagesValueEntered();
			Assert.assertEquals(recruitingpreferencesPage.validateStageRequiredText(stageNameError), stageNameError);
			reportStep("Error Stage validated Successfully", "pass");
			updateTestRailResultAsPass("284595");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284595");
			Assert.fail(e.getMessage());
		}
	}
}
