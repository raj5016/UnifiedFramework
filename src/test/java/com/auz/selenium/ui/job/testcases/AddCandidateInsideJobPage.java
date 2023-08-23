package com.auz.selenium.ui.job.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class AddCandidateInsideJobPage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Adding Candidate Inside the job Page";
		testSuiteDescription = "Adding candidate for that job Page";
		nodes = "Jobs";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	public void enterBasicJobDetails(String jobtitle, String department, String jobLocation, String NoOfOpeing) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobTitle(jobtitle);
		postJobPage.selectJobDepartment(department);
		postJobPage.selectJobLocation(jobLocation);
		postJobPage.enterNoOfOpening(NoOfOpeing);
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnGetStarted();
	}

	public void enterJobApplicationdetails(String jobDecribe, String workExpe, String education, String minSalary,
			String maxSalary) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobDescription(jobDecribe);
		postJobPage.enterJobWorkExperience(workExpe);
		postJobPage.selectJobEducation(education);
		postJobPage.enterJobAnnualMinSalary(minSalary);
		postJobPage.enterJobAnnualMaxSalary(maxSalary);
		postJobPage.clickContinueOnJobDescription();
		postJobPage.clickonContinueInPublishJob();
		postJobPage.clickContinueOnAdvertiseJob();
		postJobPage.clickContinueOnApplication();
		postJobPage.clickContinueOnInterviewProcess();
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

	@Test
	public void TC001_verify_user_is_able_to_add_candidate_inside_the_jobPage() {
		String testName = "TC001_verify_user_is_able_to_add_candidate_inside_the_jobPage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			Assert.assertEquals(jobpage.getFirstCandidateNameInsideJob(), candidateName);
			reportStep("Candidate :" + candidateName + "added Successfully", "pass");
			updateTestRailResultAsPass("284715");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284715");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_move_the_candidate_to_different_stages_in_pipeline_view() {
		String testName = "TC002_verify_user_is_able_to_move_the_candidate_to_different_stages_in_pipeline_view";

		// setting Report data
		reportUpdate(testName);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String currentstage = "Apply";

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnFirstJob();
			jobpage.clickOnPipeLine();
			jobpage.moveCandidateSourceToApplyStages();
			jobpage.clickOnListView();
			jobpage.clickOnFirstcandidatInsideTheJob();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(currentstage).contains(currentstage));
			reportStep("Candidate is moved from source to Apply stage Successfully", "pass");
			updateTestRailResultAsPass("284835");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284835");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}

	@Test
	public void TC003_verify_application_throwing_prompt_when_user_tries_to_move_stage_to_user_createdStage_withEmailTemplateMapped_in_pipelineview() {
		String testName = "TC003_verify_application_throwing_prompt_when_user_tries_to_move_stage_to_user_createdStage_withEmailTemplateMapped_in_pipelineview";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage = new PostJobPage(driver, test);

		String jobtitle = RandomGenerator.randomJobTiTle();
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String noOfOpening = RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String jobdescription = (String) jsonsuitetestData.get("jobdescription");
		String workexperience = RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String minsalary = RandomGenerator.randomMinSalary();
		String maxsalary = RandomGenerator.randomMaxSalary();
		String screeningQuestion = (String) jsonsuitetestData.get("screeningQuestion");
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String automationTemplateForSendingEmail = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");

		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);
		String stagePromptActionText = (String) jsonsuitetestData.get("stagePromptActionText");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation, noOfOpening, jobdescription, workexperience,
					minsalary, maxsalary, screeningQuestion, usercreationStage, automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, candidatesource, emailId);
			refreshBrowser();
			jobpage.clickOnFirstJob();
			jobpage.clickOnPipeLine();
			jobpage.movecandidateSourceToUserCreatedStageAction();
			Assert.assertTrue(addcandidatepage.validatePromptSatgeActionText(stagePromptActionText)
					.contains(stagePromptActionText));
			updateTestRailResultAsPass("288211");
			reportStep("Prompt prompted with : "+ stagePromptActionText +" when user moved to user created stage", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288211");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_user_is_able_to_move_stage_action_without_performing_action_inside_the_pipelineview() {
		String testName = "TC004_verify_user_is_able_to_move_stage_action_without_performing_action_inside_the_pipelineview";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage = new PostJobPage(driver, test);

		String jobtitle = RandomGenerator.randomJobTiTle();
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String noOfOpening = RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String jobdescription = (String) jsonsuitetestData.get("jobdescription");
		String workexperience = RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String minsalary = RandomGenerator.randomMinSalary();
		String maxsalary = RandomGenerator.randomMaxSalary();
		String screeningQuestion = (String) jsonsuitetestData.get("screeningQuestion");
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String automationTemplateForSendingEmail = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");

		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation, noOfOpening, jobdescription, workexperience,
					minsalary, maxsalary, screeningQuestion, usercreationStage, automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, candidatesource, emailId);
			refreshBrowser();
			jobpage.clickOnFirstJob();
			jobpage.clickOnPipeLine();
			jobpage.movecandidateSourceToUserCreatedStageAction();
			addcandidatepage.clickonMoveWithoutAction();
			jobpage.clickOnListView();
			jobpage.clickOnFirstcandidatInsideTheJob();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288219");
			reportStep("Candidate moved to user created stage action without taking action: "+ usercreationStage +"", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288219");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_user_is_able_to_move_stage_action_by_performing_action_inside_the_pipelineview() {
		String testName = "TC005_verify_user_is_able_to_move_stage_action_by_performing_action_inside_the_pipelineview";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage = new PostJobPage(driver, test);

		String jobtitle = RandomGenerator.randomJobTiTle();
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String noOfOpening = RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String jobdescription = (String) jsonsuitetestData.get("jobdescription");
		String workexperience = RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String minsalary = RandomGenerator.randomMinSalary();
		String maxsalary = RandomGenerator.randomMaxSalary();
		String screeningQuestion = (String) jsonsuitetestData.get("screeningQuestion");
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String automationTemplateForSendingEmail = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");

		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation, noOfOpening, jobdescription, workexperience,
					minsalary, maxsalary, screeningQuestion, usercreationStage, automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, candidatesource, emailId);
			refreshBrowser();
			jobpage.clickOnFirstJob();
			jobpage.clickOnPipeLine();
			jobpage.movecandidateSourceToUserCreatedStageAction();
			addcandidatepage.clickonProceedStageAction();
			jobpage.clickOnListView();
			jobpage.clickOnFirstcandidatInsideTheJob();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288227");
			reportStep("Candidate moved to user created stage action by taking action: "+ usercreationStage +"", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288227");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_user_is_able_to_move_stage_action_without_performing_action_inside_the_listview() {
		String testName = "TC006_verify_user_is_able_to_move_stage_action_without_performing_action_inside_the_listview";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage = new PostJobPage(driver, test);

		String jobtitle = RandomGenerator.randomJobTiTle();
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String noOfOpening = RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String jobdescription = (String) jsonsuitetestData.get("jobdescription");
		String workexperience = RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String minsalary = RandomGenerator.randomMinSalary();
		String maxsalary = RandomGenerator.randomMaxSalary();
		String screeningQuestion = (String) jsonsuitetestData.get("screeningQuestion");
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String automationTemplateForSendingEmail = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");

		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation, noOfOpening, jobdescription, workexperience,
					minsalary, maxsalary, screeningQuestion, usercreationStage, automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, candidatesource, emailId);
			refreshBrowser();
			jobpage.clickOnFirstJob();
			jobpage.clickOnFirstcandidatInsideTheJob();
			addcandidatepage.selectStages(usercreationStage);
			addcandidatepage.clickonMoveWithoutAction();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288235");
			reportStep("Candidate moved to user created stage action without taking action: "+ usercreationStage +"", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288235");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_move_stage_action_by_performing_action_inside_the_listview() {
		String testName = "TC007_verify_user_is_able_to_move_stage_action_by_performing_action_inside_the_listview";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postjobpage = new PostJobPage(driver, test);

		String jobtitle = RandomGenerator.randomJobTiTle();
		String department = (String) jsonsuitetestData.get("department2");
		String joblocation = (String) jsonsuitetestData.get("JobLocation1");
		String noOfOpening = RandomGenerator.random(2, PermittedCharacters.NUMERIC);
		String jobdescription = (String) jsonsuitetestData.get("jobdescription");
		String workexperience = RandomGenerator.random(1, PermittedCharacters.NUMERIC);
		String minsalary = RandomGenerator.randomMinSalary();
		String maxsalary = RandomGenerator.randomMaxSalary();
		String screeningQuestion = (String) jsonsuitetestData.get("screeningQuestion");
		String usercreationStage = (String) jsonsuitetestData.get("usercreationStage");
		String automationTemplateForSendingEmail = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");

		String candidateName = RandomGenerator.randomName();
		String candidatesource = (String) jsonsuitetestData.get("candidateSource");
		String emailId = RandomGenerator.randomEmailAddress(6);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postjobpage.createJob(jobtitle, department, joblocation, noOfOpening, jobdescription, workexperience,
					minsalary, maxsalary, screeningQuestion, usercreationStage, automationTemplateForSendingEmail);
			waitForElementLoad(2000);
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, candidatesource, emailId);
			refreshBrowser();
			jobpage.clickOnFirstJob();
			jobpage.clickOnFirstcandidatInsideTheJob();
			addcandidatepage.selectStages(usercreationStage);
			addcandidatepage.clickonProceedStageAction();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(usercreationStage).contains(usercreationStage));
			updateTestRailResultAsPass("288243");
			reportStep("Candidate moved to user created stage action by taking action: "+ usercreationStage +"", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288243");
			Assert.fail(e.getMessage());
		}
	}
}
