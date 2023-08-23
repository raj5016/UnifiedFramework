package com.auz.selenium.ui.talentpool.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class FilterCandidateTypesInTalentPool extends ProjectSpecificMethods {
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
	public void TC001_verify_user_is_able_to_filter_candidate_status_as_AllCandidate_in_TalentPoolPage(){
		String testName = "TC001_verify_user_is_able_to_filter_candidate_status_as_AllCandidate_in_TalentPoolPage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			Assert.assertTrue(talentpoolpage.getTalentPoolCount().contains("All Candidates"));
			reportStep("Application dispalyed all candidates after selecting the filter type as All Candidates", "pass");
			updateTestRailResultAsPass("272760");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272760");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC002_verify_user_is_able_to_filter_candidate_status_as_sourced_in_talentPoolpage(){
		String testName = "TC002_verify_user_is_able_to_filter_candidate_status_as_sourced_in_talentPoolpage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.selectSourcedCandidate();
			Assert.assertTrue(talentpoolpage.validateFilterText().contains((String)jsonsuitetestData.get("filteringtext")));
			reportStep("Application dispalyed sourced Candidate after selecting the filter type as Sourced", "pass");
			updateTestRailResultAsPass("272767");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272767");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_filter_candidate_status_as_archived_in_talentPoolpage(){
		String testName = "TC003_verify_user_is_able_to_filter_candidate_status_as_archived_in_talentPoolpage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.selectArchieveCandidate();
			Assert.assertTrue(talentpoolpage.validateArchivedFilterText().contains((String)jsonsuitetestData.get("archivedfilteringtext")));
			reportStep("Application dispalyed archived candidate after selecting the filter type as Archived", "pass");
			updateTestRailResultAsPass("272774");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272774");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_filter_candidate_by_dateadded_in_talentpoolpage(){
		String testName = "TC004_verify_user_is_able_to_filter_candidate_by_dateadded_in_talentpoolpage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.selectSortByDateAdded();
			reportStep("Application displayed candidate after selecting the sort type as dateadded", "pass");
			updateTestRailResultAsPass("272781");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272781");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_filter_candidate_by_name_in_talentpoolpage(){
		String testName = "TC005_verify_user_is_able_to_filter_candidate_by_name_in_talentpoolpage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.selectSortByNameAdded();
			reportStep("Application displayed candidate after selecting the sort type as name", "pass");
			updateTestRailResultAsPass("272788");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272788");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_user_is_able_to_filter_candidate_by_sources_as_applied_in_talentpoolpage(){
		String testName = "TC006_verify_user_is_able_to_filter_candidate_by_sources_as_applied_in_talentpoolpage";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnAppliedFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed Applied candidate after selecting the filter sources as Applied", "pass");
			updateTestRailResultAsPass("272795");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272795");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_filter_candidate_by_sources_as_sourced_in_talentpoolpage(){
		String testName = "TC007_verify_user_is_able_to_filter_candidate_by_sources_as_sourced_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnSourcedFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed Sourced candidate after selecting the filter sources as Sourced", "pass");
			updateTestRailResultAsPass("272802");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272802");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_filter_candidate_by_sources_as_EmployeeReferral_in_talentpoolpage(){
		String testName = "TC008_verify_user_is_able_to_filter_candidate_by_sources_as_EmployeeReferral_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnEmployeeReferralFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed EmployeeReferral candidate after selecting the filter sources as EmployeeReferral", "pass");
			updateTestRailResultAsPass("272809");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272809");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC009_verify_user_is_able_to_filter_candidate_by_sources_as_University_in_talentpoolpage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_filter_candidate_by_sources_as_University_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnUniversityFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter sources as University", "pass");
			updateTestRailResultAsPass("272816");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272816");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_filter_candidate_by_sources_as_agency_in_talentpoolpage(){
		String testName = "TC010_verify_user_is_able_to_filter_candidate_by_sources_as_agency_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnAgencyFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as agency", "pass");
			updateTestRailResultAsPass("272823");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272823");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_filter_candidate_by_sources_as_linkedIn_in_talentpoolpage(){
		String testName = "TC011_verify_user_is_able_to_filter_candidate_by_sources_as_linkedIn_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnLinkedInFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as LinkedIn", "pass");
			updateTestRailResultAsPass("272830");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272830");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_filter_candidate_by_sources_as_others_in_talentpoolpage() {
		String testName = "TC012_verify_user_is_able_to_filter_candidate_by_sources_as_others_in_talentpoolpage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnOtherInFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as Others", "pass");
			updateTestRailResultAsPass("272837");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272837");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_filter_candidate_by_owners_in_Talentpage() {
		String testName = "TC013_verify_user_is_able_to_filter_candidate_by_owners_in_Talentpage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.selectByOwnerFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as owners", "pass");
			updateTestRailResultAsPass("272844");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272844");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC014_verify_user_is_able_to_filter_candidate_by_followed_in_talentPoolpage(){
		String testName = "TC014_verify_user_is_able_to_filter_candidate_by_followed_in_talentPoolpage";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickOnMoreFilters();
			talentpoolpage.clickOnFollowedByYouFilter();
			talentpoolpage.clickOnApplyFilter();
			reportStep("Application displayed candidates after selecting the filter type as followed by you", "pass");
			updateTestRailResultAsPass("288463");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("288463");
			Assert.fail(e.getMessage());
		}
	}
}