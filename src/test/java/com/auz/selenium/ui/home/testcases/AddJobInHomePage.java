package com.auz.selenium.ui.home.testcases;

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

public class AddJobInHomePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Creating Job for Hiring process in homePage";
		testSuiteDescription = "Testing the functionality of Job Module in home page";
		nodes = "HomePage Job Adding";
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
	public void TC001_verify_user_is_able_to_publish_the_job_Externally_in_homepage() throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_publish_the_job_Externally_in_homepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			Assert.assertEquals(jobpage.validateFirstJobNameAdded(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("269860");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269860");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_create_a_job_by_adding_screening_questions_in_home_page() throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_create_a_job_by_adding_screening_questions_in_home_page";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			updateTestRailResultAsPass("269867");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269867");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_create_a_job_by_adding_stagingActions_in_interview_process_in_homepage()
			throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_create_a_job_by_adding_stagingActions_in_interview_process_in_homepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			updateTestRailResultAsPass("269874");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269874");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_create_an_email_stagingActions_in_interview_process_and_post_a_job() throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_create_an_email_stagingActions_in_interview_process";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("284251");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284251");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_create_an_email_with_questionnaire_stagingActions_in_interview_process_and_post_a_job() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_create_an_email_with_questionnaire_stagingActions_in_interview_process_and_post_a_job";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("284259");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284259");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_create_an_email_with_template_stagingActions_in_interview_process_and_post_a_job() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_create_an_email_with_template_stagingActions_in_interview_process_and_post_a_job";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("284267");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284267");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC007_verify_user_is_able_to_create_an_email_with_Placeholders_stagingActions_in_interview_process_and_post_a_job() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_create_an_email_with_template_stagingActions_in_interview_process_and_post_a_job";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
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
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("284275");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284275");
			Assert.fail(e.getMessage());
		}
	}
}
