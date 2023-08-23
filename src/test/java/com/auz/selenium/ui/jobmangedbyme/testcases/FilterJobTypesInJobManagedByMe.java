package com.auz.selenium.ui.jobmangedbyme.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobsManagedByMe;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class FilterJobTypesInJobManagedByMe extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Filter Job Types in Job ManagedByMe page";
		testSuiteDescription = "Testing the functionality of Job filter Types in Job ManagedByMe page";
		nodes = "JobsFilterTypes in Job managed By Me";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_filter_all_job_types_in_jobsManagedBymepage() throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_filter_all_job_types_in_jobsManagedBymepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			Assert.assertTrue(jobmanagedByMepage.getMyJobsCount().contains("All Jobs"));
			reportStep("Application dispalyed all Jobs after selecting the filter type as All Jobs in JobManagedByMe Page", "pass");
			updateTestRailResultAsPass("270906");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270906");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC002_verify_user_is_able_to_filter_draft_job_types_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_filter_draft_job_types_in_jobsManagedByMepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);


		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.selectDraftJob();
			Assert.assertTrue(jobmanagedByMepage.validateDraftTextForFirstcandidate().contains("Draft"));
			reportStep("Application dispalyed Draft Jobs after selecting the filter type as Draft in JobmanagedByme Page", "pass");
			updateTestRailResultAsPass("270913");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270913");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_filter_published_job_types_in_jobsmanagedByMepage() throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_filter_published_job_types_in_jobsmanagedByMepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.selectPublishedJobInJobMangedByMe();
			Assert.assertTrue(jobmanagedByMepage.getPublishedJobCountInJobMangedByMe().contains("Showing"));
			reportStep("Application dispalyed Published Jobs after selecting the filter type as Published in jobsmanagedByMepage", "pass");
			updateTestRailResultAsPass("270920");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270920");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_filter_jobs_by_location_in_jobsmanagedByMepage() throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_filter_jobs_by_location_in_jobsmanagedByMepage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);
		String location=(String)jsonsuitetestData.get("locationname");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.selectLocationInsideMoreFilter(location);
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(location.contains(jobmanagedByMepage.validateLocationname()));
			reportStep("Application displayed Jobs after selecting the filter type as Location in jobsmanagedByMepage", "pass");
			updateTestRailResultAsPass("270927");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270927");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_filter_jobs_by_department_in_jobsmanagedByMepage() throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_filter_jobs_by_department_in_jobsmanagedByMepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.selectGroupAsDepartment();
			reportStep("Application displayed Jobs after selecting the filter type as Department in jobsmanagedByMepage", "pass");
			updateTestRailResultAsPass("270934");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270934");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_filter_jobs_by_JobStatus_in_jobsmanagedbymepage() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_filter_jobs_by_JobStatus_in_jobsmanagedbymepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.selectGroupAsJobStatus();
			Assert.assertTrue(jobmanagedByMepage.validateJobStatus().contains((String)jsonsuitetestData.get("jobstatus")));
			reportStep("Application displayed Jobs after selecting the filter type as Jobstatus in JobManaged by me", "pass");
			updateTestRailResultAsPass("270941");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270941");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_filter_jobs_by_datePosted_by_past24hours_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_filter_jobs_by_datePosted_by_past24hours_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();;
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnPast24HourFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as past24hour in Job ManagedBy me Page", "pass");
			updateTestRailResultAsPass("270948");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270948");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastweek_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC008_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastweek_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnPastWeekFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as pastWeek in job ManagedByMe Page", "pass");
			updateTestRailResultAsPass("270955");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270955");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastMonth_in_jobsManagedbyMepage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_filter_jobs_by_datePosted_by_pastMonth_in_jobsManagedbyMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnPastMonthFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as pastmonth in Job ManagedByMe page", "pass");
			updateTestRailResultAsPass("270962");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270962");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_filter_jobs_by_datePosted_by_anyTime_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC010_verify_user_is_able_to_filter_jobs_by_datePosted_by_anyTime_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnAnyTimeFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as anytimeFilter in job managedbyme page", "pass");
			updateTestRailResultAsPass("270969");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270969");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_FullTime_in_jobsManagedBymepage() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_FullTime_in_jobsManagedBymepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnFullTimeFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with FulType Filter in job ManagedByme Page", "pass");
			updateTestRailResultAsPass("270976");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270976");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_PartTime_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_PartTime_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnPartTimeFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with PartTime Filter in jobmanagedByMe page", "pass");
			updateTestRailResultAsPass("270983");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270983");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_contract_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC013_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_contract_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnContractTimeFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with Contract Filter in jobManagedByMe Page", "pass");
			updateTestRailResultAsPass("270990");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270990");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC014_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_internship_in_jobsmanagedBymepage() throws InterruptedException {
		String testName = "TC014_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_internship_in_jobsmanagedBymepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnInternshipTimeFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with Contract Filter in jobManagedByMe Page", "pass");
			updateTestRailResultAsPass("270997");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("270997");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC015_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_temporary_in_jobsManagedByMepage() throws InterruptedException {
		String testName = "TC015_verify_user_is_able_to_filter_jobs_by_EmploymentType_as_temporary_in_jobsManagedByMepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedByMepage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedByMepage.clickOnMoreFilter();
			jobmanagedByMepage.clickOnTemporaryFilter();
			jobmanagedByMepage.clickOnApplyFilter();
			Assert.assertTrue(jobmanagedByMepage.validateFilteredShowingText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed Jobs after selecting the filter type as EmploymentType with temporary Filter in JobManagedByme page", "pass");
			updateTestRailResultAsPass("271004");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271004");
			Assert.fail(e.getMessage());
		}
	}
}