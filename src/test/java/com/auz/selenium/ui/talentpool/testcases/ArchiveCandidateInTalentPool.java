package com.auz.selenium.ui.talentpool.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class ArchiveCandidateInTalentPool extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Candidate Archive in TalentPool Page";
		testSuiteDescription = "Testing the functionality of Candidate Archive in talentpool page";
		nodes = "Candidate Archive";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}
	
	public void addCandidate(String candidateName,String source) {
		try {
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		addcandidatepage.enterCandidateName(candidateName);
		addcandidatepage.selectCandidateSource(source);
		addcandidatepage.clickAddCandidateButton();
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public void TC001_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Unresponsive_in_talentpoolpage() {
		String testName = "TC001_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Unresponsive_in_talentpoolpage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason1"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("271989");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271989");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Underqualified_in_talentPool_Page() {
		String testName = "TC002_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Underqualified_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason2"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("271996");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271996");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC003_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Timing_in_talentPool_Page() {
		String testName = "TC003_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Timing_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String)jsonsuitetestData.get("archivereason3"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("272003");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272003");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Withdrew_in_talentPool_Page() {
		String testName = "TC004_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Withdrew_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason4"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("272010");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272010");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_OfferDeclined_in_talentPool_Page() {
		String testName = "TC005_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_OfferDeclined_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason5"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("272017");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272017");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_Position_is_Closed_in_talentPool_Page() {
		String testName = "TC006_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_Position_is_Closed_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason6"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("272024");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272024");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Hired_in_talentPool_Page() {
		String testName = "TC007_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Hired_in_talentPool_Page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason7"));
			Assert.assertEquals(talentpoolpage.validateArchivedText(), (String) jsonsuitetestData.get("archivedfilteringtext"));
			updateTestRailResultAsPass("272031");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("272031");
			Assert.fail(e.getMessage());
		}
	}
}
