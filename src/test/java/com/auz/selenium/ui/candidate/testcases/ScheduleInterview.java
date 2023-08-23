package com.auz.selenium.ui.candidate.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class ScheduleInterview extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Scheduleing Interview process-InEditCandidatePage";
		testSuiteDescription = "Testing the functionality of Interview Scheduleing process";
		nodes = "Jobs";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	public void scheduleInterview(String strinterviewStage) {
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		candidateeditPage.clickOnScheduleInterview();
		waitForElementLoad(1000);
		candidateeditPage.selectInterviewStage(strinterviewStage);
		candidateeditPage.clickInterviewType();
		candidateeditPage.clickOnScheduleInterviewOnSelctedDate();
	}
	

	@Test
	public void TC001_Verify_user_is_able_schedule_an_interview_to_candidate() throws InterruptedException {
		String testName = "TC0001_Verify_user_is_able_schedule_an_interview_to_candidate";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			scheduleInterview((String) jsonsuitetestData.get("interviewstage"));
			Assert.assertTrue(candidateeditPage.validateInterviewScheduledText()
						.contains((String) jsonsuitetestData.get("InterviewSchduledSuccessfullText")));
			reportStep("Interview scheduled Successfully", "pass");
			updateTestRailResultAsPass("258304");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258304");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_Verify_user_is_able_edit_the_scheduled_interview_for_candidate() throws InterruptedException {
		String testName = "TC002_Verify_user_is_able_edit_the_scheduled_interview_for_candidate";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String location = RandomGenerator.randomLocation();

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.editTheScheduledInterview(location);
			Assert.assertEquals(candidateeditPage.validateInterviewEditedLocationText(location), location);
			reportStep("Scheduled Interview edited Successfully", "pass");
			updateTestRailResultAsPass("258310");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258310");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_Verify_user_is_able_delete_the_scheduled_interview_for_candidate() throws InterruptedException {
		String testName = "TC003_Verify_user_is_able_delete_the_scheduled_interview_for_candidate";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidateEditPage candidatePage = new CandidateEditPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		
		try {
		login();
		homePage.clickCandidateMenu();
		candidatePage.clickOnCandidate();
		candidateeditPage.deleteTheScheduledInterview();
		reportStep("Scheduled Interview Deleted Successfully", "pass");
		updateTestRailResultAsPass("258316");
	} catch (Exception e) {
		test.log(Status.ERROR, "StackTrace Result: " + e);
		reportStep("Test Case Not executed Successfully", "fail");
		updateTestRailResultAsFail("258316");
		Assert.fail(e.getMessage());
	}
}
	
	@Test
	public void TC004_Verify_user_is_able_add_feedback_after_schedulling_an_interview_to_candidate() {
		String testName = "TC004_Verify_user_is_able_add_feedback_after_schedulling_an_interview_to_candidate";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("strongyesFeedback");
		String validatefeedback="Strongly Yes";

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			scheduleInterview(interviewStage);
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnSubmitFeedback(interviewStage);
			candidateeditPage.enterFeedbackDescription(RandomGenerator.randomAlphabetic(10));
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(validatefeedback,interviewStage)
						.contains(validatefeedback));
			reportStep("FeedBack submitted Successfully", "pass");
			updateTestRailResultAsPass("281066");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281066");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_Verify_user_is_able_edit_the_feedback_submitted() {
		String testName = "TC005_Verify_user_is_able_edit_the_feedback_submitted";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("strongyesFeedback");
		String validatefeedback="Strongly Yes";

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnEditTheSubmittedFeedback();
			candidateeditPage.enterFeedbackDescription(RandomGenerator.randomAlphabetic(10));
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(validatefeedback,interviewStage)
						.contains(validatefeedback));
			reportStep("FeedBack edited Successfully", "pass");
			updateTestRailResultAsPass("281073");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281073");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_yes() {
		String testName = "TC006_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_yes";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("yesfeedback");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnEditTheSubmittedFeedback();
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(feedback,interviewStage)
						.contains(feedback));
			reportStep("FeedBack value :"+ feedback + "edited Successfully", "pass");
			updateTestRailResultAsPass("281080");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281080");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_MayBe() {
		String testName = "TC007_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_MayBe";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("maybefeedback");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnEditTheSubmittedFeedback();
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(feedback,interviewStage)
						.contains(feedback));
			reportStep("FeedBack value :"+ feedback + "edited Successfully", "pass");
			updateTestRailResultAsPass("281087");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281087");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_no() {
		String testName = "TC008_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_no";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("nofeedback");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnEditTheSubmittedFeedback();
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(feedback,interviewStage)
						.contains(feedback));
			reportStep("FeedBack value :"+ feedback + "edited Successfully", "pass");
			updateTestRailResultAsPass("281094");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281094");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_StrongNo() {
		String testName = "TC009_Verify_user_is_able_edit_the_feedback_by_selecting_feedback_as_StrongNo";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStage=(String) jsonsuitetestData.get("Sourcinginterviewstage");
		String feedback=(String)jsonsuitetestData.get("strongno");
		String validatefeedback="Strongly No";

		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickonFeedback();
			candidateeditPage.clickOnEditTheSubmittedFeedback();
			candidateeditPage.selectFeedbackValue(feedback);
			candidateeditPage.clickonSubmitScorecard();
			Assert.assertTrue(candidateeditPage.validateSubittedScorecard(validatefeedback,interviewStage)
						.contains(validatefeedback));
			reportStep("FeedBack value :"+ feedback + "edited Successfully", "pass");
			updateTestRailResultAsPass("281101");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281101");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_Verify_application_throwing_error_when_interview_stage_not_selected(){
		String testName = "TC010_Verify_application_throwing_error_when_interview_stage_not_selected";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewStagemandatoryText=(String) jsonsuitetestData.get("interviewStagemandatoryText");
		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickOnScheduleInterview();
			candidateeditPage.clickOnScheduleInterviewOnSelctedDate();			
			Assert.assertTrue(candidateeditPage.validateInterviewMandatoryText(interviewStagemandatoryText).contains(interviewStagemandatoryText));
			reportStep("InterviewStage mandatory :"+interviewStagemandatoryText+" validated Successfully", "pass");
			updateTestRailResultAsPass("291667");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291667");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_Verify_application_throwing_error_when_interview_type_not_selected(){
		String testName = "TC011_Verify_application_throwing_error_when_interview_type_not_selected";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatePage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String interviewTypemandatoryText=(String) jsonsuitetestData.get("interviewTypemandatoryText");
		try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.clickOnScheduleInterview();
			candidateeditPage.clickOnScheduleInterviewOnSelctedDate();			
			Assert.assertTrue(candidateeditPage.validateInterviewMandatoryText(interviewTypemandatoryText).contains(interviewTypemandatoryText));
			reportStep("InterviewStage mandatory :"+interviewTypemandatoryText+" validated Successfully", "pass");
			updateTestRailResultAsPass("291675");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291675");
			Assert.fail(e.getMessage());
		}
	}
}
