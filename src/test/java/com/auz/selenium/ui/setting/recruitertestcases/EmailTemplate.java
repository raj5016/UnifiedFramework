package com.auz.selenium.ui.setting.recruitertestcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TemplatePage;
import com.aventstack.extentreports.Status;

public class EmailTemplate extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Recruiter-Email Template";
		testSuiteDescription = "Testing the Email Template(add,edit,delete)Functionality";
		nodes = "Email Template";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("recruiter_username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_NewEmailTemplate_under_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_NewEmailTemplate_under_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");
		String emailSubjectName = (String) jsonsuitetestData.get("emailtemplatesubjectName");
		String emailBody = (String) jsonsuitetestData.get("emailtemplatebody");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnAddNewTemplate();
			templatePage.enterTemplateName(templateName);
			templatePage.enterEmailSubject(emailSubjectName);
			templatePage.enterEmailBody(emailBody);
			templatePage.clickOnCandidateNamePlaceHolder();
			templatePage.clickOnJobNamePlaceHolder();
			templatePage.clickOnEmailTemplateSave();
			Assert.assertEquals(templatePage.validateAddedEmailTemplate(templateName), templateName);
			reportStep("Email Template Added Successfully", "pass");
			updateTestRailResultAsPass("303577");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303577");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_search_the_EmailTemplate_added_under_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_search_the_EmailTemplate_added_under_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.SerachTemplateByName(templateName);
			Assert.assertEquals(templatePage.validateAddedEmailTemplate(templateName), templateName);
			reportStep("User able to search the Email Template which is Added", "pass");
			updateTestRailResultAsPass("303586");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303586");
			Assert.fail(e.getMessage());
		}
	}	
	
	@Test
	public void TC003_verify_user_is_able_to_edit_the_EmailTemplate_added_under_setting_page_through_recruiter()throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_edit_the_EmailTemplate_added_under_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");
		String editEmailSubjectName = (String) jsonsuitetestData.get("editemailtemplatesubjectName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnEmailTemplateEdit(templateName);
			templatePage.enterEmailSubject(editEmailSubjectName);
			templatePage.clickOnEmailTemplateSave();
			Assert.assertEquals(templatePage.validateAddedEmailTemplate(templateName), templateName);
			reportStep("Email Template edited Successfully", "pass");
			updateTestRailResultAsPass("303595");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303595");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_delete_the_EmailTemplate_which_is_added_under_setting_page_through_recruiter(){
		String testName = "TC004_verify_user_is_able_to_delete_the_EmailTemplate_which_is_added_under_setting_page_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");
		String emailTemplateDeletedValidationText = (String) jsonsuitetestData.get("emailAndJobTemplateDeletedValidationText");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnDeleteEmailTemplate(templateName);
			templatePage.clickOnConfirmDeleteEmailTemplate();
			Assert.assertEquals(templatePage.validateEmailTemplateDeleteText(emailTemplateDeletedValidationText), emailTemplateDeletedValidationText);
			reportStep("Email Template deleted Successfully", "pass");
			updateTestRailResultAsPass("303604");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303604");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_templateName_through_recruiter(){
		String testName = "TC005_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_templateName_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String emailTemplateNameValidationText = (String) jsonsuitetestData.get("emailAndJobTemplateNameValidationText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnAddNewTemplate();
			templatePage.clickOnEmailTemplateSave();
			Assert.assertEquals(templatePage.validateEmailAndJobTemplateErrorText(emailTemplateNameValidationText), emailTemplateNameValidationText);
			reportStep("Email Template name error text: "+ emailTemplateNameValidationText +" validated Successfully", "pass");
			updateTestRailResultAsPass("303613");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303613");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_emailSubject_through_recruiter(){
		String testName = "TC006_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_emailSubject_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String emailSubjectValidationText = (String) jsonsuitetestData.get("emailSubjectValidationText");
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnAddNewTemplate();
			templatePage.enterTemplateName(templateName);
			templatePage.clickOnEmailTemplateSave();
			Assert.assertEquals(templatePage.validateEmailAndJobTemplateErrorText(emailSubjectValidationText), emailSubjectValidationText);
			reportStep("Email subject error text :"+ emailSubjectValidationText +" validated Successfully", "pass");
			updateTestRailResultAsPass("303622");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303622");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_emailBody_through_recruiter(){
		String testName = "TC007_verify_application_throwing_error_message_when_user_trying_to_create_EmailTemplateName_without_giving_emailBody_through_recruiter";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String emailBodyValidationText = (String) jsonsuitetestData.get("emailBodyValidationText");
		String templateName = (String) jsonsuitetestData.get("emailtemplateName");
		String emailSubjectName = (String) jsonsuitetestData.get("emailtemplatesubjectName");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnAddNewTemplate();
			templatePage.enterTemplateName(templateName);
			templatePage.enterEmailSubject(emailSubjectName);
			templatePage.clickOnEmailTemplateSave();
			Assert.assertEquals(templatePage.validateEmailAndJobTemplateErrorText(emailBodyValidationText), emailBodyValidationText);
			reportStep("Email Body error text:"+ emailBodyValidationText +" validated Successfully", "pass");
			updateTestRailResultAsPass("303631");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("303631");
			Assert.fail(e.getMessage());
		}
	}
}
