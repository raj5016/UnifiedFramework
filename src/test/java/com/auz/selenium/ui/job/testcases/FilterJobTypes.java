package com.auz.selenium.ui.job.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class FilterJobTypes extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Filter Job Types";
		testSuiteDescription = "Testing the functionality of Job filter Types";
		nodes = "JobsFilterTypes";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_filter_all_job_types_in_jobspage() throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_filter_all_job_types_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			Assert.assertTrue(jobpage.getJobsCount().contains("All Jobs"));
			reportStep("Application dispalyed all Jobs after selecting the filter type as All Jobs", "pass");
			updateTestRailResultAsPass("270641");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270641");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC002_verify_user_is_able_to_filter_draft_job_types_in_jobspage() throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_filter_draft_job_types_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.selectDraftJob();
			Assert.assertTrue(jobpage.validateDraftTextForFirstcandidate().contains("Draft"));
			reportStep("Application dispalyed Draft Jobs after selecting the filter type as Draft", "pass");
			updateTestRailResultAsPass("270648");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270648");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_filter_published_job_types_in_jobspage() throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_filter_published_job_types_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.selectPublishedJob();
			Assert.assertTrue(jobpage.getPublishedJobCount().contains("Showing"));
			reportStep("Application dispalyed Published Jobs after selecting the filter type as Published", "pass");
			updateTestRailResultAsPass("270655");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270655");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_filter_jobs_by_location_in_jobspage() throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_filter_jobs_by_location_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		String location=(String)jsonsuitetestData.get("locationname");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.selectLocationInsideMoreFilter(location);
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(location.contains(jobpage.validateLocationname()));
			reportStep("Application displayed Jobs after selecting the filter type as Location", "pass");
			updateTestRailResultAsPass("270662");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270662");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_filter_jobs_by_department_in_jobspage() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_filter_jobs_by_department_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.selectGroupAsDepartment();
			reportStep("Application displayed Jobs after selecting the filter type as Department", "pass");
			updateTestRailResultAsPass("270669");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270669");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_filter_jobs_by_JobStatus_in_jobspage() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_filter_jobs_by_JobStatus_in_jobspage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.selectGroupAsJobStatus();
			Assert.assertTrue(jobpage.validateJobStatus().contains((String)jsonsuitetestData.get("jobstatus")));
			reportStep("Application displayed Jobs after selecting the filter type as Jobstatus", "pass");
			updateTestRailResultAsPass("270676");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270676");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_filter_jobs_by_datePosted_by_past24hours_in_jobspage() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_filter_jobs_by_datePosted_by_past24hours_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnPast24HourFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as past24hour", "pass");
			updateTestRailResultAsPass("270843");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270843");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastweek_in_jobspage() throws InterruptedException {
		String testName = "TC008_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastweek_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnPastWeekFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as pastWeek", "pass");
			updateTestRailResultAsPass("270850");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270850");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastMonth_in_jobspage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastMonth_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnPastMonthFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as pastmonth", "pass");
			updateTestRailResultAsPass("270857");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270857");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_filter_jobs_by_datePosted_by_anyTime_in_jobspage() throws InterruptedException {
		String testName = "TC010_verify_user_is_able_to_filter_jobs_by_datePosted_by_anyTime_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnAnyTimeFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as anytimeFilter", "pass");
			updateTestRailResultAsPass("270864");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270864");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_FullTime_in_jobspage() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_FullTime_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnFullTimeFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with FulType Filter", "pass");
			updateTestRailResultAsPass("270871");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270871");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_PartTime_in_jobspage() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_PartTime_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnPartTimeFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with PartTime Filter", "pass");
			updateTestRailResultAsPass("270878");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270878");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_contract_in_jobspage() throws InterruptedException {
		String testName = "TC013_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_contract_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnContractTimeFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with Contract Filter", "pass");
			updateTestRailResultAsPass("270885");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270885");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC014_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_internship_in_jobspage() throws InterruptedException {
		String testName = "TC014_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_internship_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnInternshipTimeFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with Contract Filter", "pass");
			updateTestRailResultAsPass("270892");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270892");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC015_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_temporary_in_jobspage() throws InterruptedException {
		String testName = "TC015_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_temporary_in_jobspage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobpage = new JobPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickOnMoreFilter();
			jobpage.clickOnTemporaryFilter();
			jobpage.clickOnApplyFilter();
			Assert.assertTrue(jobpage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with temporary Filter", "pass");
			updateTestRailResultAsPass("270899");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270899");
			Assert.fail(e.getMessage());
		}
	}
}