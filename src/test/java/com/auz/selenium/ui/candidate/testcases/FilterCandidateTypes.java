package com.auz.selenium.ui.candidate.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class FilterCandidateTypes extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Filter Candidate Types";
		testSuiteDescription = "Testing the functionality of candidate filter Types";
		nodes = "CandidateFilterTypes";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_filter_candidate_status_as_AllCandidate_in_CandidatePage(){
		String testName = "TC001_verify_user_is_able_to_filter_candidate_status_as_AllCandidate_in_CandidatePage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			Assert.assertTrue(candidatepage.getAllCandidateCount().contains("All Candidates"));
			reportStep("Application dispalyed all candidates after selecting the filter type as All Candidates", "pass");
			updateTestRailResultAsPass("271041");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271041");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC002_verify_user_is_able_to_filter_candidate_status_as_sourced_in_candidatepage(){
		String testName = "TC002_verify_user_is_able_to_filter_candidate_status_as_sourced_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.selectSourcedCandidate();
			Assert.assertTrue(candidatepage.validateFilterText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application dispalyed sourced Candidate after selecting the filter type as Sourced", "pass");
			updateTestRailResultAsPass("271048");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271048");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_filter_candidate_status_as_archived_in_candidatepage(){
		String testName = "TC003_verify_user_is_able_to_filter_candidate_status_as_archived_in_candidatepage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.selectArchieveCandidate();
			Assert.assertTrue(candidatepage.validateArchivedFilterText().contains((String)jsonsuitetestData.get("archivedfilteringtext")));
			reportStep("Application dispalyed archived candidate after selecting the filter type as Archived", "pass");
			updateTestRailResultAsPass("271055");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271055");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_filter_candidate_by_dateadded_in_candidatepage(){
		String testName = "TC004_verify_user_is_able_to_filter_candidate_by_dateadded_in_candidatepage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.selectSortByDateAdded();
			reportStep("Application displayed candidate after selecting the sort type as dateadded", "pass");
			updateTestRailResultAsPass("271062");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271062");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_filter_candidate_by_name_in_candidatepage(){
		String testName = "TC005_verify_user_is_able_to_filter_candidate_by_name_in_candidatepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.selectSortByNameAdded();
			reportStep("Application displayed candidate after selecting the sort type as name", "pass");
			updateTestRailResultAsPass("271069");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271069");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_filter_candidate_by_sources_as_applied_in_candidatepage(){
		String testName = "TC006_verify_user_is_able_to_filter_candidate_by_sources_as_applied_in_candidatepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnAppliedFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("appliedfilteringtext")));
			reportStep("Application displayed Applied candidate after selecting the filter sources as Applied", "pass");
			updateTestRailResultAsPass("271076");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271076");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_filter_candidate_by_sources_as_sourced_in_candidatepage(){
		String testName = "TC007_verify_user_is_able_to_filter_candidate_by_sources_as_sourced_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnSourcedFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("sourcedfilteringtext")));
			reportStep("Application displayed Sourced candidate after selecting the filter sources as Sourced", "pass");
			updateTestRailResultAsPass("271083");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271083");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_filter_candidate_by_sources_as_EmployeeReferral_in_candidatepage(){
		String testName = "TC008_verify_user_is_able_to_filter_candidate_by_sources_as_EmployeeReferral_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnEmployeeReferralFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("employeefilteringtext")));
			reportStep("Application displayed EmployeeReferral candidate after selecting the filter sources as EmployeeReferral", "pass");
			updateTestRailResultAsPass("271090");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271090");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_filter_candidate_by_sources_as_University_in_candidatepage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_filter_candidate_by_sources_as_University_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnUniversityFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("universityfilteringtext")));
			reportStep("Application displayed candidates after selecting the filter sources as University", "pass");
			updateTestRailResultAsPass("271097");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271097");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_filter_candidate_by_sources_as_agency_in_candidatepage(){
		String testName = "TC010_verify_user_is_able_to_filter_candidate_by_sources_as_agency_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnAgencyFilter();
			candidatepage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as agency", "pass");
			updateTestRailResultAsPass("271104");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271104");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_filter_candidate_by_sources_as_linkedIn_in_candidatepage() throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_filter_candidate_by_sources_as_linkedIn_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnLinkedInFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("linkedinfilteringtext")));
			reportStep("Application displayed candidates after selecting the filter type as LinkedIn", "pass");
			updateTestRailResultAsPass("271111");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271111");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_filter_candidate_by_sources_as_others_in_candidatepage() throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_filter_candidate_by_sources_as_others_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnOtherInFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateSourcesFilterText().contains((String)jsonsuitetestData.get("otherfilteringtext")));
			reportStep("Application displayed candidates after selecting the filter type as Others", "pass");
			updateTestRailResultAsPass("271118");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271118");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_filter_candidate_by_owners_in_candidatepage() throws InterruptedException {
		String testName = "TC013_verify_user_is_able_to_filter_candidate_by_owners_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.selectByOwnerFilter();
			candidatepage.clickOnApplyFilter();
			Assert.assertTrue(candidatepage.validateFilterText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application displayed candidates after selecting the filter type as owners", "pass");
			updateTestRailResultAsPass("271125");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271125");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC014_verify_user_is_able_to_filter_candidate_by_followed_in_candidatepage(){
		String testName = "TC014_verify_user_is_able_to_filter_candidate_by_followed_in_candidatepage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage=new CandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnMoreFilters();
			candidatepage.clickOnFollowedByYouFilter();
			candidatepage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as followed by you", "pass");
			updateTestRailResultAsPass("288471");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288471");
			Assert.fail(e.getMessage());
		}
	}
}