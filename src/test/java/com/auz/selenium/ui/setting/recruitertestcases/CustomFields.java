package com.auz.selenium.ui.setting.recruitertestcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.CustomFieldsPage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class CustomFields extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Recruiter-Custom Fields";
		testSuiteDescription = "Testing the CustomFields(add,delete)Functionality";
		nodes = "Custom Fields";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("recruiter_username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_customFields_by_selecting_shortanswer_as_yes_in_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_customFields_by_selecting_shortanswer_as_yes_in_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldsName = (String) jsonsuitetestData.get("customFieldName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnAddNewCustomFields();
			customfieldsPage.enterCustomFieldName(customfieldsName);
			customfieldsPage.clickOnShortAnsweryes();
			customfieldsPage.clickOnAddCustomeFieldAfterEnteringValue();
			Assert.assertEquals(customfieldsPage.validateAddedCustomFields(customfieldsName), customfieldsName);
			reportStep("CustomFields added Successfully", "pass");
			updateTestRailResultAsPass("303514");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303514");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_delete_the_added_customFields_of_the_shortanswer_as_yes_in_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_delete_the_added_customFields_of_the_shortanswer_as_yes_in_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldsName = (String) jsonsuitetestData.get("customFieldName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnDeleteCustomeField(customfieldsName);
			customfieldsPage.clickOnConfirmDeleteCustomeField();
			reportStep("CustomFields deleted Successfully", "pass");
			updateTestRailResultAsPass("303523");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303523");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_add_customFields_by_selecting_shortanswer_as_no_in_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_add_customFields_by_selecting_shortanswer_as_no_in_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldsName = (String) jsonsuitetestData.get("customFieldName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnAddNewCustomFields();
			customfieldsPage.enterCustomFieldName(customfieldsName);
			customfieldsPage.clickOnShortAnswerNo();
			customfieldsPage.clickOnAddCustomeFieldAfterEnteringValue();
			Assert.assertEquals(customfieldsPage.validateAddedCustomFields(customfieldsName), customfieldsName);
			reportStep("CustomFields added Successfully", "pass");
			updateTestRailResultAsPass("303532");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303532");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC004_verify_user_is_able_to_search_the_added_customFields_in_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_search_the_added_customFields_in_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldsName = (String) jsonsuitetestData.get("customFieldName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.enterSearchCustomFields(customfieldsName);
			Assert.assertEquals(customfieldsPage.validateAddedCustomFields(customfieldsName), customfieldsName);
			reportStep("CustomFields searched Successfully", "pass");
			updateTestRailResultAsPass("303541");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303541");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_Application_throwing_proper_error_while_short_answer_is_not_checked_in_customFields_through_recruiter()throws InterruptedException {
		String testName = "TC005_verify_Application_throwing_proper_error_while_short_answer_is_not_checked_in_customFields_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String pleasecheckErrortext = (String) jsonsuitetestData.get("customefielderrortext");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnAddNewCustomFields();
			customfieldsPage.enterCustomFieldName(RandomGenerator.randomAlphabetic(5));
			customfieldsPage.clickOnAddCustomeFieldAfterEnteringValue();
			Assert.assertEquals(customfieldsPage.validateCustomFieldtext(pleasecheckErrortext), pleasecheckErrortext);
			reportStep("CustomCheckBox :"+pleasecheckErrortext+" validated Successfully", "pass");
			updateTestRailResultAsPass("303550");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303550");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_delete_the_added_customFields_of_the_shortanswer_as_no_in_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_delete_the_added_customFields_of_the_shortanswer_as_no_in_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldsName = (String) jsonsuitetestData.get("customFieldName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnDeleteCustomeField(customfieldsName);
			customfieldsPage.clickOnConfirmDeleteCustomeField();
			reportStep("CustomFields deleted Successfully", "pass");
			updateTestRailResultAsPass("303559");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303559");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_Application_throwing_proper_error_message_when_custom_field_name_is_not_entered_in_customFields_through_recruiter()throws InterruptedException {
		String testName = "TC007_verify_Application_throwing_proper_error_message_when_custom_field_name_is_not_entered_in_customFields_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CustomFieldsPage customfieldsPage=new CustomFieldsPage(driver, test);
		String customfieldValidationText = (String) jsonsuitetestData.get("customfieldValidationText");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			customfieldsPage.clickOnCustomFieldMenu();
			customfieldsPage.clickOnAddNewCustomFields();
			customfieldsPage.clickOnAddCustomeFieldAfterEnteringValue();
			Assert.assertEquals(customfieldsPage.validateCustomFieldtext(customfieldValidationText), customfieldValidationText);
			reportStep("CustomFields: " + customfieldValidationText + "validated Successfully", "pass");
			updateTestRailResultAsPass("303568");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303568");
			Assert.fail(e.getMessage());
		}
	}
}
