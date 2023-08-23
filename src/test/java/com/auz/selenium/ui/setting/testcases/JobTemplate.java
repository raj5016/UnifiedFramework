package com.auz.selenium.ui.setting.testcases;

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

public class JobTemplate extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Job Template";
		testSuiteDescription = "Testing the Job Template(add,edit,delete)Functionality";
		nodes = "Job Template";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_NewJobTemplate_under_setting_page()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_NewJobTemplate_under_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("jobtemplateName");
		String jobdescription = (String) jsonsuitetestData.get("jobtemplatedescription");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.clickOnAddNewJobTemplate();
			templatePage.enterJobTemplateName(templateName);
			templatePage.enterJobDescriptionName(jobdescription);
			templatePage.ClickOnJobName();
			templatePage.ClickOnJobSaveButton();
			Assert.assertEquals(templatePage.validateAddedJobTemplate(templateName), templateName);
			reportStep("Job Template Added Successfully", "pass");
			updateTestRailResultAsPass("267786");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("267786");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_search_the_added_JobTemplate_under_setting_page()throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_search_the_added_JobTemplate_under_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("jobtemplateName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.SerachJobTemplateByName(templateName);
			Assert.assertEquals(templatePage.validateAddedJobTemplate(templateName), templateName);
			reportStep("Job Template Added Successfully", "pass");
			updateTestRailResultAsPass("284691");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284691");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_edit_the_JobTemplate_which_is_added_under_setting_page()throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_edit_the_JobTemplate_which_is_added_under_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("jobtemplateName");
		String jobEdittemplatedescription = (String) jsonsuitetestData.get("jobEdittemplatedescription");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.clickOnJobTemplateEdit(templateName);
			templatePage.enterJobDescriptionName(jobEdittemplatedescription);
			templatePage.ClickOnJobSaveButton();
			Assert.assertEquals(templatePage.validateAddedJobTemplate(templateName), templateName);
			reportStep("Job Template edited Successfully", "pass");
			updateTestRailResultAsPass("267793");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("267793");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_delete_the_JobTemplate_which_is_added_under_setting_page()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_delete_the_JobTemplate_which_is_added_under_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("jobtemplateName");
		String JobTemplateDeletedValidationText = (String) jsonsuitetestData.get("emailAndJobTemplateDeletedValidationText");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.clickOnJobTemplateDelete(templateName);
			templatePage.clickOnConfirmDeleteJobTemplate();
			Assert.assertEquals(templatePage.validateEmailTemplateDeleteText(JobTemplateDeletedValidationText), JobTemplateDeletedValidationText);
			reportStep("Job Template deleted Successfully", "pass");
			updateTestRailResultAsPass("267800");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("267800");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_application_throwing_error_when_NewJobTemplate_is_created_without_templatename(){
		String testName = "TC005_verify_application_throwing_error_when_NewJobTemplate_is_created_without_templatename";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String jobTemplatevalidationtext = (String) jsonsuitetestData.get("emailAndJobTemplateNameValidationText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.clickOnAddNewJobTemplate();
			templatePage.ClickOnJobSaveButton();
			Assert.assertEquals(templatePage.validateEmailAndJobTemplateErrorText(jobTemplatevalidationtext), jobTemplatevalidationtext);
			reportStep("Job Template name error text: "+ jobTemplatevalidationtext +" validated Successfully", "pass");
			updateTestRailResultAsPass("287235");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("287235");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_application_throwing_error_when_NewJobTemplate_is_created_without_JobDescription(){
		String testName = "TC006_verify_application_throwing_error_when_NewJobTemplate_is_created_without_JobDescription";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TemplatePage templatePage=new TemplatePage(driver, test);
		String templateName = (String) jsonsuitetestData.get("jobtemplateName");
		String jobdescriptionValidationText = (String) jsonsuitetestData.get("jobdescriptionValidationText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			templatePage.clickOnTemplateMenu();
			templatePage.clickOnJobTemplateMenu();
			templatePage.clickOnAddNewJobTemplate();
			templatePage.enterJobTemplateName(templateName);
			templatePage.ClickOnJobSaveButton();
			Assert.assertEquals(templatePage.validateEmailAndJobTemplateErrorText(jobdescriptionValidationText), jobdescriptionValidationText);
			reportStep("Job Description Error text: "+ jobdescriptionValidationText +" validated Successfully", "pass");
			updateTestRailResultAsPass("287243");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("287243");
			Assert.fail(e.getMessage());
		}
	}
	
}
