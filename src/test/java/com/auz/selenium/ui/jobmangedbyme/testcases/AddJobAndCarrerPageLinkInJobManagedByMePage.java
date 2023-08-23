package com.auz.selenium.ui.jobmangedbyme.testcases;

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

public class AddJobAndCarrerPageLinkInJobManagedByMePage extends ProjectSpecificMethods {
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
	public void TC001_verify_user_is_able_to_create_a_job_and_publish_in_career_page_from_job_managed_by_me_page() {
		String testName = "TC001_verify_user_is_able_to_create_a_job_and_publish_in_career_page_from_job_managed_by_me_page";

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
			updateTestRailResultAsPass("290491");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290491");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_from_job_managed_by_me_page() {
		String testName = "TC002_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_from_job_managed_by_me_page";

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
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			managepage.clickOnCareerPage();
			managepage.switchtoCareerPage();
			managepage.EnterOnCareerSearch(jobtitle);
			Assert.assertEquals(postJobPage.validateJobErrMessageInCareerPage((String) jsonsuitetestData.get("JobErrMessageInCareerPage")), (String) jsonsuitetestData.get("JobErrMessageInCareerPage"));
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("290499");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290499");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_publish_the_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_publish_the_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			Assert.assertEquals(postJobPage.validateJobTitleInCareerPageViaSpecficJob(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("290507");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290507");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_via_specific_job_from_job_managed_by_me_page() {
		String testName = "TC004_verify_job_is_not_published_in_career_page_when_pubish_career_page_switch_is_off_via_specific_job_from_job_managed_by_me_page";

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
			postJobPage.clickOnPublishButton();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			jobpage.clickOnCarrerPageLink();
			managepage.switchtoCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("290515");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290515");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("290523");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("290523");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_upload_the_doc_and_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_upload_the_doc_and_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			candidatepage.clickAddCandidateResumeInCareerPage("sample_resume-1");
			postJobPage.clickOnSubmitApplicationButton();
			managepage.switchtoHirePage();
			homePage.clickCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("291611");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291611");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_user_is_able_to_schdeule_an_interview_for_a_candidate_applied__in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_schdeule_an_interview_for_a_candidate_applied__in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			candidatepage.clickOnCandidate();
			scheduleInterview((String) jsonsuitetestData.get("interviewstage"));
			Assert.assertTrue(candidateeditPage.validateInterviewScheduledText()
						.contains((String) jsonsuitetestData.get("InterviewSchduledSuccessfullText")));
			reportStep("Interview scheduled Successfully", "pass");
			updateTestRailResultAsPass("291619");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291619");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_delete_a_candidate_applied_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
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
			candidatepage.clickOnDelete();
			Assert.assertNotEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate deleted Successfully in candidatePage", "pass");
			updateTestRailResultAsPass("291627");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291627");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC009_verify_user_is_able_to_archive_a_candidate_applied_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_archive_a_candidate_applied_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			updateTestRailResultAsPass("291635");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291635");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page_and_verify_the_same_in_list_view() throws InterruptedException {
		String testName = "TC010_verify_user_is_able_to_apply_for_a_job_in_carrer_page_via_specfic_job_from_job_managed_by_me_page_and_verify_the_same_in_list_view";

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
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickOnFirstJob();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate :" + candidateName + "was able to apply for a job in career page", "pass");
			updateTestRailResultAsPass("291643");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291643");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_close_a_job_that_was_posted_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickOnClose();
			managepage.switchtoCareerPage();
			managepage.refreshCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("291651");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291651");
			Assert.fail(e.getMessage());
		}
		
		
	}
	
	@Test
	public void TC012_verify_user_is_able_to_delete_a_job_that_was_posted_in_carrer_page_via_specfic_job_from_job_managed_by_me_page() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_delete_a_job_that_was_posted_in_carrer_page_via_specfic_job_from_job_managed_by_me_page";

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
			homePage.clickJobsManagedByMeMenu();
			jobpage.clickOnDelete();
			managepage.switchtoCareerPage();
			managepage.refreshCareerPage();
			postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob();
			Assert.assertEquals(postJobPage.validateJobNotAvailableInCareerPageViaSpecficJob(), (String) jsonsuitetestData.get("JobErrMessageInCareerPageViaSpecificJob"));
			reportStep("JobTitle :" + jobtitle + " is validated as not availabe in the career page", "pass");
			updateTestRailResultAsPass("291659");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291659");
			Assert.fail(e.getMessage());
		}
	}
	
	
}
