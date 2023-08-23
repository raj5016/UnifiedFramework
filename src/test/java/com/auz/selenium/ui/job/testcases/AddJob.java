package com.auz.selenium.ui.job.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class AddJob extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Creating Job for Hiring process";
		testSuiteDescription = "Testing the functionality of Job Module";
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

	@Test
	public void TC001_verify_user_is_able_to_publish_the_job_Externally(){
		String testName = "TC001_verify_user_is_able_to_publish_the_job_Externally";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

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
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("258322");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258322");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_create_a_job_by_adding_screening_questions() {
		String testName = "TC002_verify_user_is_able_to_create_a_job_by_adding_screening_questions";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.scrollBottom(driver);
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("258328");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258328");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_create_a_job_by_adding_stagingActions_in_interview_process()
			throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_create_a_job_by_adding_stagingActions_in_interview_process";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.clickContinueOnApplication();
			postJobPage.addStaging(RandomGenerator.randomStageTitle());
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("258334");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258334");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_publish_the_job_Internally() throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_publish_the_job_Internally";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

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
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "posted internally", "pass");
			updateTestRailResultAsPass("284235");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284235");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_create_an_email_stagingActions_in_interview_process_and_post_a_job_in_job_page() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_create_an_email_stagingActions_in_interview_process_and_post_a_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.clickContinueOnApplication();
			postJobPage.addStaging(RandomGenerator.randomStageTitle());
			postJobPage.clickOnEditIcon();
			postJobPage.clickOnSendemail();
			postJobPage.enterEmailSubject((String) jsonsuitetestData.get("emailtemplatesubjectName"));
			postJobPage.enterEmailBody((String) jsonsuitetestData.get("emailtemplatebody"));
			postJobPage.clickUpdateStage();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "created by adding email staging action", "pass");
			updateTestRailResultAsPass("284283");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284283");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_create_an_email_with_questionnaire_stagingActions_in_interview_process_and_post_a_job_in_job_page() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_create_an_email_with_questionnaire_stagingActions_in_interview_process_and_post_a_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.clickContinueOnApplication();
			postJobPage.addStaging(RandomGenerator.randomStageTitle());
			postJobPage.clickOnEditIcon();
			postJobPage.clickOnSendemail();
			postJobPage.clickonInsertQuestionnaire();
			postJobPage.enterEmailSubject((String) jsonsuitetestData.get("emailtemplatesubjectName"));
			postJobPage.clickUpdateStage();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "created by adding questionnaire email staging action", "pass");
			updateTestRailResultAsPass("284291");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284291");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_user_is_able_to_create_an_email_with_template_stagingActions_in_interview_process_and_post_a_job_in_job_page() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_create_an_email_with_template_stagingActions_in_interview_process_and_post_a_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.clickContinueOnApplication();
			postJobPage.addStaging(RandomGenerator.randomStageTitle());
			postJobPage.clickOnEditIcon();
			postJobPage.clickOnSendemail();
			postJobPage.selectEmailTemplate((String) jsonsuitetestData.get("automationTemplateForSendingEmail"));
			postJobPage.clickUpdateStage();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "created by adding email template staging action", "pass");
			updateTestRailResultAsPass("284299");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284299");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC008_verify_user_is_able_to_create_an_email_with_Placeholders_stagingActions_in_interview_process_and_post_a_job_in_job_page() throws InterruptedException {
		String testName = "TC008_verify_user_is_able_to_create_an_email_with_Placeholders_stagingActions_in_interview_process_and_post_a_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
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
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.clickContinueOnApplication();
			postJobPage.addStaging(RandomGenerator.randomStageTitle());
			postJobPage.clickOnEditIcon();
			postJobPage.clickOnSendemail();
			postJobPage.enterEmailSubject((String) jsonsuitetestData.get("emailtemplatesubjectName"));
			postJobPage.clickOnPlaceholders();
			postJobPage.clickUpdateStage();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "created by adding placeholder in staging action", "pass");
			updateTestRailResultAsPass("284307");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284307");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_application_throwing_error_when_jobtitle_is_not_entered_while_publishing_job() throws InterruptedException {
		String testName = "TC009_verify_application_throwing_error_when_jobtitle_is_not_entered_while_publishing_job";
 		// setting Report data
		reportUpdate(testName);
	
		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitleerrortext =(String) jsonsuitetestData.get("jobtitlerequirederrortext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnGetStarted();
			Assert.assertEquals(postJobPage.validateJobTitleRequiredErrorText(jobtitleerrortext), jobtitleerrortext);
			reportStep("JobTitle :" + jobtitleerrortext + "validated Successfully", "pass");
			updateTestRailResultAsPass("284771");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284771");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC010_verify_application_throwing_error_when_questions_is_not_entered_while_adding_screening_questions() throws InterruptedException {
		String testName = "TC010_verify_application_throwing_error_when_questions_is_not_entered_while_adding_screening_questions";
 		// setting Report data
		reportUpdate(testName);
	
		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String questionserrortext =(String) jsonsuitetestData.get("questionsrequirederrortext");
	
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postJobPage.enterJobTitle(RandomGenerator.randomJobTiTle());
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnGetStarted();
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			Assert.assertEquals(postJobPage.validateQuestionsRequiredErrorText(questionserrortext), questionserrortext);
			reportStep("Add Screening Question Error text :" + questionserrortext + "validated Successfully", "pass");
			updateTestRailResultAsPass("284779");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284779");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_edit_added_screening_questions() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_edit_added_screening_questions";
 		// setting Report data
		reportUpdate(testName);
	
		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);
		String editscreeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postJobPage.enterJobTitle(RandomGenerator.randomJobTiTle());
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnGetStarted();
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickOneditTheScreeningQuestions(screeningQuestions);
			postJobPage.enterScreeningQuestions(editscreeningQuestions);
			postJobPage.clickOnScreeningUpdateButton();
			Assert.assertEquals(postJobPage.validateScreeningQuestionsAdded(editscreeningQuestions), editscreeningQuestions);
			reportStep("Edited Screening Question :" + editscreeningQuestions + "validated Successfully", "pass");
			updateTestRailResultAsPass("284787");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284787");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_delete__the_added_screening_questions() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_delete__the_added_screening_questions";
 		// setting Report data
		reportUpdate(testName);
	
		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String screeningQuestions =RandomGenerator.randomAlphabetic(10);
		String editscreeningQuestions =RandomGenerator.randomAlphabetic(10);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			postJobPage.enterJobTitle(RandomGenerator.randomJobTiTle());
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnGetStarted();
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickAddScreeningQuestions();
			postJobPage.enterScreeningQuestions(screeningQuestions);
			postJobPage.clickOnAddButtonOfScreeningQuestion();
			postJobPage.clickdeleteTheScreeningQuestions(screeningQuestions);
			postJobPage.clickOnconfirmDelete();
			reportStep("Added Screening Question :" + editscreeningQuestions + " deleted Successfully", "pass");
			updateTestRailResultAsPass("284795");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284795");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
}
