package com.auz.selenium.ui.candidate.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class ArchiveCandidateInEditCandidatePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Candidate Archive in EditCandidatePage";
		testSuiteDescription = "Testing the functionality of Candidate Archeive in Edit Candidate Page";
		nodes = "Candidate Archive";
	}

	@Test
	public void TC001_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Unresponsive() {
		String testName = "TC001_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Unresponsive";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason1"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273088");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273088");
			Assert.fail(e.getMessage());
		}
	}
	
	
	@Test
	public void TC002_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Underqualified() {
		String testName = "TC002_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Underqualified";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason2"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273095");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273095");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC003_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Timing() {
		String testName = "TC003_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_Timing";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason3"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273109");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273109");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_withdrewapplication() {
		String testName = "TC004_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_is_withdrewapplication";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason4"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273116");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273116");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_offerDeclined() {
		String testName = "TC005_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_offerDeclined";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason5"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273123");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273123");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_Position_is_Closed() {
		String testName = "TC006_verify_user_is_able_to_archeive_candidate_in_editcandidate_page_when_candidate_Position_is_Closed";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason6"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273130");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273130");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC007_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Hired() {
		String testName = "TC007_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Hired";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			archiveCandidate((String) jsonsuitetestData.get("archivereason7"));
			candidateeditpage.clickOnCloseButton();
			homePage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.validateCandidateNameAterArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273137");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273137");
			Assert.fail(e.getMessage());
		}
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
		addcandidatepage.clickAddJobToCandidate();
		addcandidatepage.selectCandidateSource(source);
		addcandidatepage.clickAddCandidateButton();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void archiveCandidate(String archivereason) {
		try {
			CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
			candidateeditpage.mouseOverToSelectArchiveAndDelete();
			candidateeditpage.selectArchiveReason(archivereason);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
