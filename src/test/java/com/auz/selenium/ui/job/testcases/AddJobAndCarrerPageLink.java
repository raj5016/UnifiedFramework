package com.auz.selenium.ui.job.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.ManagePage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class AddJobAndCarrerPageLink extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Creating Job for Hiring process and Publishing it in Career Page";
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
	
	public void scheduleInterview(String strinterviewStage) {
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		candidateeditPage.clickOnScheduleInterview();
		waitForElementLoad(1000);
		candidateeditPage.selectInterviewStage(strinterviewStage);
		candidateeditPage.clickInterviewType();
		candidateeditPage.clickOnScheduleInterviewOnSelctedDate();
	}
	
	public void archiveCandidate(String archivereason) {
		try {
			CandidatePage candidatepage = new CandidatePage(driver, test);
			candidatepage.clickOnArchive();
			candidatepage.clickArchiveCandidateByReason(archivereason);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void TC001_verify_user_is_able_to_create_a_job_and_publish_in_career_page() {
		String testName = "TC001_verify_user_is_able_to_create_a_job_and_publish_in_career_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
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
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			managepage.clickOnCareerPage();
			managepage.switchtoCareerPage();
			managepage.EnterOnCareerSearch(jobtitle);
			Assert.assertEquals(postJobPage.validateJobTitleInCareerPage(jobtitle), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("290451");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290451");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off() {
		String testName = "TC002_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
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
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			managepage.clickOnCareerPage();
			managepage.switchtoCareerPage();
			managepage.EnterOnCareerSearch(jobtitle);
			Assert.assertEquals(postJobPage.validateJobErrMessageInCareerPage((String) jsonsuitetestData.get("JobErrMessageInCareerPage")), (String) jsonsuitetestData.get("JobErrMessageInCareerPage"));
			reportStep("JobTitle :" + jobtitle + "is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("290459");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290459");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_publish_the_job_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_publish_the_job_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			Assert.assertEquals(postJobPage.validateJobTitleInCareerPageViaSpecficJob(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("290467");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290467");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_via_specific_job_in_job_page() {
		String testName = "TC004_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_via_specific_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
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
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("290475");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290475");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("290483");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290483");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_upload_the_doc_and_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_upload_the_doc_and_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			candidatepage.clickAddCandidateResumeInCareerPage("sample_resume-1");
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("291555");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291555");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_user_is_able_to_schdeule_aan_interview_for_a_candidate_applied__in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_schdeule_aan_interview_for_a_candidate_applied__in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			scheduleInterview((String) jsonsuitetestData.get("interviewstage"));
			Assert.assertTrue(candidateeditPage.validateInterviewScheduledText()
						.contains((String) jsonsuitetestData.get("InterviewSchduledSuccessfullText")));
			reportStep("Interview scheduled Successfully", "pass");
			updateTestRailResultAsPass("291563");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291563");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_delete_a_candidate_applied_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC008_verify_user_is_delete_a_candidate_applied_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			candidatepage.clickOnDelete();
			Assert.assertNotEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate deleted Successfully in candidatePage", "pass");
			updateTestRailResultAsPass("291571");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291571");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_archive_a_candidate_applied_in_carrer_page_via_specfic_job__in_job_page() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_archive_a_candidate_applied_in_carrer_page_via_specfic_job__in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			archiveCandidate((String) jsonsuitetestData.get("archivereason1"));
			updateTestRailResultAsPass("291579");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291579");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page_and_verify_the_same_in_list_view() throws InterruptedException {
		String testName = "TC010_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_in_job_page_and_verify_the_same_in_list_view";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickJobMenu();
			jobpage.clickOnFirstJob();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("291587");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291587");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickJobMenu();
			jobpage.clickOnClose();
			managepage.switchtoCareerPage();
			managepage.refreshCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("291595");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291595");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC012_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_in_job_page() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_in_job_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		ManagePage managepage = new ManagePage(driver, test);
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
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickOnCareerPageSwitch();
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.clickOnApplyForThisJob();
			postJobPage.enterFirstNameInCareerPage(candidateName);
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickJobMenu();
			jobpage.clickOnDelete();
			managepage.switchtoCareerPage();
			managepage.refreshCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("291603");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291603");
			Assert.fail(e.getMessage());
		}
	}
	
	
}
