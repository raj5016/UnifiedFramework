package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.IntegrationsPage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class JobBoardIntegrationsTest extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "JobBoard Integrations";
		testSuiteDescription = "JobBoard Integrations-Enable and Disable";
		nodes = "JobBoard";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_disable_the_jobTarget_under_integrations_setting_page() {
		String testName = "TC001_verify_user_is_able_to_disable_the_jobTarget_under_integrations_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		IntegrationsPage integrationpage=new IntegrationsPage(driver, test);
		String jobtargetdisabletext = (String) jsonsuitetestData.get("jobtargetdisabletext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			integrationpage.clickOnIntegrations();
			integrationpage.clickOnJobBoardSubMenu();
			integrationpage.clickOnEnableAndDisableJobBoard("Disable");
			Assert.assertEquals(integrationpage.validateJobtargetEnableAndDisableText(jobtargetdisabletext), jobtargetdisabletext);
			reportStep("JobTarget: "+ jobtargetdisabletext +" Disabled Successfully", "pass");
			updateTestRailResultAsPass("290419");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290419");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC002_verify_application_giving_proper_text_message_when_user_tries_to_publish_job_under_advertiseJob_when_jobtarget_is_disabled() {
		String testName = "TC002_verify_application_giving_proper_text_message_when_user_tries_to_publish_job_under_advertiseJob_when_jobtarget_is_disabled";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage=new JobPage(driver, test);
		PostJobPage postjobpage=new PostJobPage(driver, test);
		String publishJobAdvertiseDisabledtargettext = (String) jsonsuitetestData.get("publishJobAdvertiseDisabledtargettext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.enterJobTitle(RandomGenerator.randomJobTiTle());
			postjobpage.scrollBottom(driver);
			postjobpage.clickContinueOnGetStarted();
			postjobpage.clickContinueOnJobDescription();
			postjobpage.clickonContinueInPublishJob();
			Assert.assertEquals(postjobpage.validateDisabledJobTargetText(), publishJobAdvertiseDisabledtargettext);
			reportStep("Advertise Jobtarget: "+ publishJobAdvertiseDisabledtargettext +" validated Successfully", "pass");
			updateTestRailResultAsPass("290435");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290435");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_enable_the_jobTarget_under_integrations_setting_page(){
		String testName = "TC003_verify_user_is_able_enable_the_jobTarget_under_integrations_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		IntegrationsPage integrationpage=new IntegrationsPage(driver, test);
		String jobtargetenabletext = (String) jsonsuitetestData.get("jobtargetenabletext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			integrationpage.clickOnIntegrations();
			integrationpage.clickOnJobBoardSubMenu();
			integrationpage.clickOnEnableAndDisableJobBoard("Enable");
			Assert.assertEquals(integrationpage.validateJobtargetEnableAndDisableText(jobtargetenabletext), jobtargetenabletext);
			reportStep("JobTarget :"+ jobtargetenabletext +" Enabled Successfully", "pass");
			updateTestRailResultAsPass("290427");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290427");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_application_giving_proper_text_message_when_user_tries_to_publish_job_under_advertiseJob_when_jobtarget_is_enabled() {
		String testName = "TC004_verify_application_giving_proper_text_message_when_user_tries_to_publish_job_under_advertiseJob_when_jobtarget_is_enabled";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage=new JobPage(driver, test);
		PostJobPage postjobpage=new PostJobPage(driver, test);
		String publishJobAdvertiseEnabledtargettext = (String) jsonsuitetestData.get("publishJobAdvertiseEnabledtargettext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.enterJobTitle(RandomGenerator.randomJobTiTle());
			postjobpage.scrollBottom(driver);
			postjobpage.clickContinueOnGetStarted();
			postjobpage.clickContinueOnJobDescription();
			postjobpage.clickonContinueInPublishJob();
			Assert.assertEquals(postjobpage.validateEnabledJobTargetText(), publishJobAdvertiseEnabledtargettext);
			reportStep("Advertise Jobtarget: "+ publishJobAdvertiseEnabledtargettext +" validated Successfully", "pass");
			updateTestRailResultAsPass("290443");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290443");
			Assert.fail(e.getMessage());
		}
	}
}
