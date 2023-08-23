package com.auz.selenium.ui.candidate.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class MoveToStageInCandidateEditPage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "MovingToStage-InCandidatePage";
		testSuiteDescription = "moving candidate to various stages";
		nodes = "Stages";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	public void addCandidate(String candidateName, String source, String strEmail) {
		try {
			AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource(source);
			addcandidatepage.enterCandidateEmail(strEmail);
			addcandidatepage.clickAddCandidateButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createJob(String jobtitle, String department, String jobLocation, String noOfOpening,
			String stageName) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobTitle(jobtitle);
		postJobPage.selectJobDepartment(department);
		postJobPage.selectJobLocation(jobLocation);
		postJobPage.enterNoOfOpening(noOfOpening);
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnGetStarted();
		postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
		postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
		postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
		postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
		postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
		postJobPage.clickContinueOnJobDescription();
		postJobPage.clickonContinueInPublishJob();
		postJobPage.clickContinueOnAdvertiseJob();
		postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
		postJobPage.clickContinueOnApplication();
		postJobPage.clickOnAddStageButton();
		postJobPage.enterStageTitle(stageName);
		postJobPage.clickOnSendemail();
		postJobPage.selectEmailTemplate((String) jsonsuitetestData.get("automationTemplateForSendingEmail"));
		postJobPage.clickUpdateStage();
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnInterviewProcess();
	}

	@Test
	public void TC001_verify_user_is_able_to_move_candidate_to_ApplyStages() {
		String testName = "TC001_verify_user_is_able_to_move_candidate_to_ApplyStages";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String stage = (String) jsonsuitetestData.get("ApplyStage");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(stage);
			Assert.assertTrue(addcandidatepage.validateCurrentStages(stage).contains(stage));
			updateTestRailResultAsPass("283153");
			reportStep("Candidate moved to apply stages", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283153");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_move_candidate_to_offerJobStage() {
		String testName = "TC002_verify_user_is_able_to_move_candidate_to_offerJobStage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String stage = (String) jsonsuitetestData.get("offerJobStage");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(stage);
			Assert.assertTrue(addcandidatepage.validateCurrentStages(stage).contains(stage));
			updateTestRailResultAsPass("283167");
			reportStep("Candidate moved to offer job stages", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283167");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_move_candidate_to_HiredStage() {
		String testName = "TC003_verify_user_is_able_to_move_candidate_to_HiredStage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String stage = (String) jsonsuitetestData.get("HiredStage");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(stage);
			Assert.assertTrue(addcandidatepage.validateCurrentStages(stage).contains(stage));
			updateTestRailResultAsPass("283174");
			reportStep("Candidate moved to Hired stages", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283174");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_verify_user_is_able_to_move_candidate_to_SourcedStage() {
		String testName = "TC004_verify_user_is_able_to_move_candidate_to_SourcedStage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String stage = (String) jsonsuitetestData.get("SourcingStage");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(stage);
			Assert.assertTrue(addcandidatepage.validateCurrentStages(stage).contains(stage));
			updateTestRailResultAsPass("283181");
			reportStep("Candidate moved to Hired stages", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283181");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_application_throwing_prompt_when_user_tries_to_move_stage_to_user_createdStage_withEmailTemplateMapped() {
		String testName = "TC005_verify_application_throwing_prompt_when_user_tries_to_move_stage_to_user_createdStage_withEmailTemplateMapped";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage=new PostJobPage(driver, test);
		
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String jobtitle = RandomGenerator.randomJobTiTle();
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);
		String stagePromptActionText = (String) jsonsuitetestData.get("stagePromptActionText");
		String jobdescription=(String)jsonsuitetestData.get("jobdescription");
		String workexperience=RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String noOfOpening=RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String screeningQuestion=(String)jsonsuitetestData.get("screeningQuestion");
		String automationTemplateForSendingEmail=(String) jsonsuitetestData.get("automationTemplateForSendingEmail");
		String minsalary=RandomGenerator.randomMinSalary();
		String maxsalary=RandomGenerator.randomMaxSalary();
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation,noOfOpening,jobdescription,workexperience,
					minsalary,maxsalary,screeningQuestion,usercreationStage,automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName, candidatesource, emailId);
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(usercreationStage);
			Assert.assertTrue(addcandidatepage.validatePromptSatgeActionText(stagePromptActionText)
					.contains(stagePromptActionText));
			updateTestRailResultAsPass("287727");
			reportStep("Prompt prompted after moving to user created stage", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("287727");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_move_stage_action_without_performing_action() {
		String testName = "TC006_verify_user_is_able_to_move_stage_action_without_performing_action";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(usercreationStage);
			waitForElementLoad(2000);
			addcandidatepage.clickonMoveWithoutAction();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288195");
			reportStep("Candidate moved to user created stage action", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288195");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_user_is_able_to_move_stage_action_to_user_created_stageaction_by_clicking_on_proceedbutton_in_prompt() {
		String testName = "TC007_verify_user_is_able_to_move_stage_action_to_user_created_stageaction_by_clicking_on_proceedbutton_in_prompt";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String offerJobStage = (String) jsonsuitetestData.get("offerJobStage");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			addcandidatepage.selectStages(offerJobStage);
			waitForElementLoad(2000);
			addcandidatepage.selectStages(usercreationStage);
			addcandidatepage.clickonProceedStageAction();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288203");
			reportStep("Candidate moved to user created stage action", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288203");
			Assert.fail(e.getMessage());
		}
	}
}
