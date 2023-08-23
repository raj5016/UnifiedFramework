package com.auz.selenium.ui.candidate.testcases;

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
import com.aventstack.extentreports.Status;

public class ArchiveCandidate extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Candidate Archive";
		testSuiteDescription = "Testing the functionality of Candidate Archeive";
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
		addcandidatepage.clickAddJobToCandidate();
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
	public void TC001_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Unresponsive() {
		String testName = "TC001_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Unresponsive";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason1"));
			updateTestRailResultAsPass("258634");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258634");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Underqualified() {
		String testName = "TC002_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Underqualified";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason2"));
			updateTestRailResultAsPass("258640");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258640");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC003_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Timing() {
		String testName = "TC003_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Timing";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason3"));
			updateTestRailResultAsPass("258646");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258646");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC004_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Withdrew() {
		String testName = "TC004_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_Withdrew";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason4"));
			updateTestRailResultAsPass("258652");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258652");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_OfferDeclined() {
		String testName = "TC005_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_is_OfferDeclined";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason5"));
			updateTestRailResultAsPass("258658");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258658");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_Position_is_Closed() {
		String testName = "TC006_verify_user_is_able_to_archeive_candidate_information_successfully_after_candidate_Position_is_Closed";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason6"));
			updateTestRailResultAsPass("258664");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258664");
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
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			archiveCandidate((String) jsonsuitetestData.get("archivereason7"));
			updateTestRailResultAsPass("258670");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258670");
			Assert.fail(e.getMessage());
		}
	}
}
