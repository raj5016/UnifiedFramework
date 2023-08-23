package com.auz.selenium.ui.home.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;
import com.auz.selenium.pages.JobsManagedByMe;

public class HomePageTests extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Home Page(DashBoard,scheduled Interview count)";
		testSuiteDescription = "Testing the Home Page(DashBoard,scheduled Interview count ) Validation Functionality";
		nodes = "DashBoard";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_validate_the_dashboard_active_candidate_count_is_matching_with_homepage_and_candidatePage()
			throws InterruptedException {
		String testName = "TC001_validate_the_dashboard_active_candidate_count_is_matching_with_homepage_and_candidatePage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			String activecandidatecount = homePage.getActiveCandidateCount();
			candidatepage.clickOnCandidateMenu();
			String allcandidatecount = candidatepage.getAllCandidateCount();
			Assert.assertEquals(activecandidatecount, separateDigitsAndAlphabets(allcandidatecount));
			reportStep("Candidate count matched in both page", "pass");
			updateTestRailResultAsPass("268216");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("268216");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_validate_the_dashboard_job_count_is_matching_with_homepage_and_jobsPage()
			throws InterruptedException {
		String testName = "TC002_validate_the_dashboard_job_count_is_matching_with_homepage_and_jobsPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage JobPage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			String homepagejobcount = homePage.getTotalJobsCount();
			homePage.clickJobMenu();
			String jobscount = JobPage.getJobsCount();
			Assert.assertEquals(homepagejobcount, separateDigitsAndAlphabets(jobscount));
			reportStep("Jobs count matched in both page", "pass");
			updateTestRailResultAsPass("268223");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("268223");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_validate_the_dashboard_Myjob_count_is_matching_with_homepage_and_jobsManagedByMePage()
			throws InterruptedException {
		String testName = "TC003_validate_the_dashboard_Myjob_count_is_matching_with_homepage_and_jobsManagedByMePage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobsmanagedbyme = new JobsManagedByMe(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			String homepagemyjobcount = homePage.getMyJobsCount();
			homePage.clickJobsManagedByMeMenu();
			String jobscount = jobsmanagedbyme.getMyJobsCount();
			Assert.assertEquals(homepagemyjobcount, separateDigitsAndAlphabets(jobscount));
			reportStep("MyJobs count matched in both page", "pass");
			updateTestRailResultAsPass("268230");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("268230");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_validate_the_dashboard_talentPool_count_is_matching_with_homepage_and_talentpoolPage()
			throws InterruptedException {
		String testName = "TC004_validate_the_dashboard_talentPool_count_is_matching_with_homepage_and_talentpoolPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			String homepagetalentpoolcount = homePage.getTalentPoolCount();
			homePage.clickTalentPoolMenu();
			String talentpoolcount = talentpoolpage.getTalentPoolCount();
			Assert.assertEquals(homepagetalentpoolcount, separateDigitsAndAlphabets(talentpoolcount));
			reportStep("Candidate count matched in both page", "pass");
			updateTestRailResultAsPass("268237");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("268237");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_validate_the_jobName_is_displayed_after_searching_the_jobname_in_MyjobSearch_page(){
		String testName = "TC005_validate_the_jobName_is_displayed_after_searching_the_jobname_in_MyjobSearch_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		String jobname=(String) jsonsuitetestData.get("jobTitle1");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.searchJobname(jobname);
			Assert.assertEquals(homePage.validateJobsearchname(jobname),jobname);
			reportStep("Searched job name is displayed successfully", "pass");
			updateTestRailResultAsPass("268237");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("268237");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(enabled=false)
	public void TC006_validate_the_total_candidate_count_is_matching_with_myOpenJobs_and_jobspage(){
		String testName = "TC006_validate_the_total_candidate_count_is_matching_with_myOpenJobs_and_jobspage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage=new JobPage(driver, test);
		String jobname=(String) jsonsuitetestData.get("jobTitle1");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			String myopenjobstotalcandidatecount=homePage.getCandidateCounMappedForThatJob(jobname);
			homePage.clickJobMenu();
			String jobstotalcandidatecount=jobpage.getCandidateCounMappedForThatJob(jobname);
			Assert.assertEquals(myopenjobstotalcandidatecount,jobstotalcandidatecount);
			reportStep("Candidate count matched in both homepage and jobpage", "pass");
			updateTestRailResultAsPass("269321");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269321");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test(enabled=false)
	public void TC007_Verify_that_user_is_able_to_view_the_upcoming_interview_in_homepage_upcoming_interview_tab(){
		String testName = "TC007_Verify_that_user_is_able_to_view_the_upcoming_interview_in_homepage_upcoming_interview_tab";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage canidatepage=new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage=new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			String candidatename=canidatepage.getFirstCandidateNameAdded();
			canidatepage.clickOnCandidate();
			candidateeditpage.clickOnScheduleInterview();
			candidateeditpage.selectInterviewTime();
			candidateeditpage.selectInterviewStage((String)jsonsuitetestData.get("interviewstage"));
			candidateeditpage.clickInterviewType();
			candidateeditpage.clickOnScheduleInterviewOnSelctedDate();
			candidateeditpage.clickOnCloseButton();
			candidateeditpage.clickOnHomePageMenu();
			String candidateAndJobTitleName=homePage.validateCandidateInterviewScheduledText();
			Assert.assertTrue(candidateAndJobTitleName.contains(candidatename));
			reportStep("Interview Scheduled validated successfully", "pass");
			updateTestRailResultAsPass("281115");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281115");
			Assert.fail(e.getMessage());
		}
	}
}
