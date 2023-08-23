package com.auz.selenium.ui.reports.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.JobsManagedByMe;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.ReportsPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class Reports extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Reports";
		testSuiteDescription = "Testing the Reports Page(Candidate Analysis and Job Analysis) Validation Functionality";
		nodes = "Reports Functionality";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_total_candidateCount_in_reportpage_is_matching_with_candidateAndTalentpoolPageCandidateCount(){
		String testName = "TC001_verify_total_candidateCount_in_reportpage_is_matching_with_candidateAndTalentpoolPageCandidateCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		TalentPoolPage talentPoolepage = new TalentPoolPage(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			String candidatepagecount=separateDigitsAndAlphabets(candidatepage.getAllCandidateCount());
			homePage.clickTalentPoolMenu();
			String talentpoolpagecandidatecount=separateDigitsAndAlphabets(talentPoolepage.getTalentPoolCount());
			int totalcount =Integer.parseInt(candidatepagecount) + Integer.parseInt(talentpoolpagecandidatecount);
			homePage.clickReportMenu();
			Assert.assertEquals(reportpage.getReportsCandidateCount(),Integer.toString(totalcount));
			reportStep("Candidate count "+ talentpoolpagecandidatecount +" matched in both page", "pass");
			updateTestRailResultAsPass("269328");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269328");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC002_verify_archived_candidateCount_in_reportpage_is_matching_with_CandidatePageCount(){
		String testName = "TC002_verify_archived_candidateCount_in_reportpage_is_matching_with_CandidatePageCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String)jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.selectArchieveCandidate();
			String candidatepageArchivedcount=separateDigitsAndAlphabets(candidatepage.getArchiveCandidateCount());
			homePage.clickReportMenu();
			Assert.assertEquals(reportpage.getReportsArchivedCandidateCount(),candidatepageArchivedcount);
			reportStep("Archived Candidate count "+ candidatepageArchivedcount + " matched in both page", "pass");
			updateTestRailResultAsPass("269783");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269783");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_reportpage_published_jobcount_is_matched_with_JobPagePublishedJobCount(){
		String testName = "TC003_verify_reportpage_published_jobcount_is_matched_with_JobPagePublishedJobCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobspage = new JobPage(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String)jsonsuitetestData.get("homepagetitle"));
			homePage.clickReportMenu();
			reportpage.selectJobAnalysis();
			String reportPublishedJobCount=reportpage.getPublishedJobCount();
			String reportPageInternalJobCount=reportpage.getInternalJobCount();
			int reporttotalpublishedjobcount =Integer.parseInt(reportPublishedJobCount) + Integer.parseInt(reportPageInternalJobCount);
			homePage.clickJobMenu();
			jobspage.selectPublishedJob();
			String jobspagepublishedcount=separateDigitsAndAlphabets(jobspage.getPublishedJobCount());
			Assert.assertEquals(Integer.toString(reporttotalpublishedjobcount),jobspagepublishedcount);
			reportStep("Published Job count "+ jobspagepublishedcount +" matched in both report and Job page", "pass");
			updateTestRailResultAsPass("269645");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269645");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_reportpage_published_jobcount_is_matched_with_JobmanagedBymePagePublishedJobCount(){
		String testName = "TC004_verify_reportpage_published_jobcount_is_matched_with_JobmanagedBymePagePublishedJobCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobsmangedbymepage = new JobsManagedByMe(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String)jsonsuitetestData.get("homepagetitle"));
			homePage.clickReportMenu();
			reportpage.selectJobAnalysis();
			String reportPagePublishedJobCount=reportpage.getPublishedJobCount();
			String reportPageInternalJobCount=reportpage.getInternalJobCount();
			int reporttotalpublishedjobcount =Integer.parseInt(reportPagePublishedJobCount) + Integer.parseInt(reportPageInternalJobCount);
			homePage.clickJobsManagedByMeMenu();
			jobsmangedbymepage.selectPublishedJobInJobMangedByMe();
			String jobsmanagedbymepagepublishedcount=separateDigitsAndAlphabets(jobsmangedbymepage.getPublishedJobCountInJobMangedByMe());
			Assert.assertEquals(Integer.toString(reporttotalpublishedjobcount),jobsmanagedbymepagepublishedcount);
			reportStep("Published Job count "+ jobsmanagedbymepagepublishedcount +"matched in both report and JobManagedBy page", "pass");
			updateTestRailResultAsPass("269652");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269652");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_reportpage_openAndClosed_jobcount_is_matched_with_JobPageAllJobCount(){
		String testName = "TC005_verify_reportpage_openAndClosed_jobcount_is_matched_with_JobPageAllJobCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobPage jobspage = new JobPage(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String)jsonsuitetestData.get("homepagetitle"));
			homePage.clickReportMenu();
			reportpage.selectJobAnalysis();
			String reportPageOpenJobCount=reportpage.getOpenJobCount();
			String reportPageClosedJobCount=reportpage.getClosedJobCount();
			int reporttotalJobcount =Integer.parseInt(reportPageOpenJobCount) + Integer.parseInt(reportPageClosedJobCount);
			homePage.clickJobMenu();
			String alljobscount=separateDigitsAndAlphabets(jobspage.getJobsCount());
			Assert.assertEquals(alljobscount,Integer.toString(reporttotalJobcount));
			reportStep("All Job count "+ alljobscount +" matched in both report and Jobpage", "pass");
			updateTestRailResultAsPass("269659");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269659");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_reportpage_openAndClosed_jobcount_is_matched_with_JobMangedByMePageAllJobCount(){
		String testName = "TC006_verify_reportpage_openAndClosed_jobcount_is_matched_with_JobMangedByMePageAllJobCount";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobsmangedbymepage = new JobsManagedByMe(driver, test);
		ReportsPage reportpage=new ReportsPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String)jsonsuitetestData.get("homepagetitle"));
			homePage.clickReportMenu();
			reportpage.selectJobAnalysis();
			String reportPageOpenJobCount=reportpage.getOpenJobCount();
			String reportPageClosedJobCount=reportpage.getClosedJobCount();
			int reporttotalJobcount =Integer.parseInt(reportPageOpenJobCount) + Integer.parseInt(reportPageClosedJobCount);
			homePage.clickJobsManagedByMeMenu();
			String alljobscountInjobsmangedbymepage=separateDigitsAndAlphabets(jobsmangedbymepage.getMyJobsCount());
			Assert.assertEquals(alljobscountInjobsmangedbymepage,Integer.toString(reporttotalJobcount));
			reportStep("All Job count "+ alljobscountInjobsmangedbymepage +" matched in both report and JobMangedBymepage", "pass");
			updateTestRailResultAsPass("269666");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269666");
			Assert.fail(e.getMessage());
		}
	}
}
