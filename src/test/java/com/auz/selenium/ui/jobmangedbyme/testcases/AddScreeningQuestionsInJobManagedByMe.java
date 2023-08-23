package com.auz.selenium.ui.jobmangedbyme.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class AddScreeningQuestionsInJobManagedByMe extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Creating screening questions in Job creation process";
		testSuiteDescription = "Testing the functionality of Screening in My Job module";
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
	public void TC001_verify_user_is_able_to_view_and_edit_single_line_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC001_verify_user_is_able_to_view_and_edit_single_line_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);
		String singleLineScreeingResponse =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.enterSinglelineresponse(singleLineScreeingResponse);
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single linke response added Successfully", "pass");
			updateTestRailResultAsPass("295434");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295434");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_view_and_edit_multiple_line_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC002_verify_user_is_able_to_view_and_edit_multiple_line_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);
		String MultipleLineScreeingResponse =RandomGenerator.randomAlphabetic(50);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("textMultipleLineScreening"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.enterMultiplelineresponse(MultipleLineScreeingResponse);
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single linke response added Successfully", "pass");
			updateTestRailResultAsPass("295442");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295442");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_view_and_edit_single_choice_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC003_verify_user_is_able_to_view_and_edit_single_choice_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("singlechoiceScreening"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddAnswerInScreeningchoice();
			postJobPage.enterscreeningOptionalAnswer1();
			postJobPage.clickOnAddAnswerInScreeningchoice();
			postJobPage.enterscreeningOptionalAnswer2();
			postJobPage.clickOnAddcompleteScreeningchoiceSet();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnSinglechoiceRespOption();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single choice response added Successfully", "pass");
			updateTestRailResultAsPass("295450");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295450");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_view_and_edit_multi_choice_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC004_verify_user_is_able_to_view_and_edit_multi_choice_type_screening_questions_inside_the_candidate_profile";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("multichoiceScreening"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddAnswerInScreeningchoice();
			postJobPage.enterscreeningOptionalAnswer1();
			postJobPage.clickOnAddAnswerInScreeningchoice();
			postJobPage.enterscreeningOptionalAnswer2();
			postJobPage.clickOnAddcompleteScreeningchoiceSet();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnSinglechoiceRespOption();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single choice response added Successfully", "pass");
			updateTestRailResultAsPass("295458");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295458");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_view_and_edit_yes_no__choice_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC005_verify_user_is_able_to_view_and_edit_yes_no__choice_type_screening_questions_inside_the_candidate_profile";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("yesnochoice"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnSinglechoiceRespOption();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single choice response added Successfully", "pass");
			updateTestRailResultAsPass("295466");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295466");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_view_and_edit_file_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC006_verify_user_is_able_to_view_and_edit_file_type_screening_questions_inside_the_candidate_profile";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("filechoice"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnUploadButtonInScreeningsection("sample_resume-1");
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single choice response added Successfully", "pass");
			updateTestRailResultAsPass("295474");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295474");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC007_verify_user_is_able_to_view_and_edit_date_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC007_verify_user_is_able_to_view_and_edit_date_type_screening_questions_inside_the_candidate_profile";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("datechoice"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.selectScreeningDate();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single choice response added Successfully", "pass");
			updateTestRailResultAsPass("295482");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("295482");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_view_and_edit_video_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me() {
		String testName = "TC008_verify_user_is_able_to_view_and_edit_video_type_screening_questions_inside_the_candidate_profile_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("videochoice"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("Screening questions with video choice response added Successfully", "pass");
			updateTestRailResultAsPass("298982");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("298982");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_view_and_edit_video_type_screening_questions_as_disabled_from_job_managed_by_me() {
		String testName = "TC009_verify_user_is_able_to_view_and_edit_video_type_screening_questions_as_disabled__from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.selectScreeningQuestionType((String) jsonsuitetestData.get("videochoice"));
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickDisabledresponse();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("Screening questions with video choice response added Successfully", "pass");
			updateTestRailResultAsPass("299393");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("299393");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_save_single_line_type_optional_screening_questions_inside_the_candidate_profile_without_filling_the_details_from_job_managed_by_me() {
		String testName = "TC010_verify_user_is_able_to_save_single_line_type_optional_screening_questions_inside_the_candidate_profile_without_filling_the_details_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			reportStep("Screening questions with single linke response added Successfully without filling any details", "pass");
			updateTestRailResultAsPass("299409");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("299409");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_save_single_line_type_required_screening_questions_inside_the_candidate_profile_from_the_details_from_job_managed_by_me() {
		String testName = "TC011_verify_user_is_able_to_save_single_line_type_required_screening_questions_inside_the_candidate_profile_from_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickRequiredresponse();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.clickOnSaveButtonInSingleLinkRespButton();
			Assert.assertEquals(candidateeditPage.validateAnswersRequiredScreeningErrorText((String) jsonsuitetestData.get("screeningerrortext")), (String) jsonsuitetestData.get("screeningerrortext"));
			reportStep("Screening questions with single linke response added Successfully without filling any details", "pass");
			updateTestRailResultAsPass("299417");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("299417");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_save_single_line_type_disabled_screening_questions_inside_the_candidate_profile_from_the_details_job_managed_by_me() {
		String testName = "TC012_verify_user_is_able_to_save_single_line_type_disabled_screening_questions_inside_the_candidate_profile_from_the_details_job_managed_by_me";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickDisabledresponse();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnFirstJob();
			jobpage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"),
					RandomGenerator.randomEmailAddress(6));
			jobpage.clickOnFirstcandidatInsideTheJob();
			candidateeditPage.clickOnScreeningLink();
			candidateeditPage.clickOnSingleLineScreeningQuestion();
			candidateeditPage.clickOnEditLink();
			candidateeditPage.getformfieldStatus();
			reportStep("Response field is not displayed for diabled screening question", "pass");
			updateTestRailResultAsPass("299425");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("299425");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
}
