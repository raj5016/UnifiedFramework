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

public class UnArchiveCandidateInCandidateAndEditCandidatePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "UnArchiveCandidate in both TalentPool and EditCandidate page";
		testSuiteDescription = "Testing the functionality of Unarchiving the Candidate";
		nodes = "UnArchive Candidate";
	}

	@Test
	public void TC001_Verify_user_is_able_unarchive_candidate_from_talentPoolPage() throws InterruptedException {
		String testName = "TC001_Verify_user_is_able_unarchive_candidate_from_talentPoolPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		TalentPoolPage talentpoolpage=new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnArchive();
			candidatepage.clickArchiveCandidateByReason((String) jsonsuitetestData.get("archivereason1"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickUnArchiveCandidate();
			candidatepage.clickOnCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Interview scheduled Successfully", "pass");
			updateTestRailResultAsPass("258694");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258694");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_Verify_user_is_able_unarchive_candidate_from_candidateeditPage(){
		String testName = "TC002_Verify_user_is_able_unarchive_candidate_from_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateeditpage.mouseOverToSelectArchiveAndDelete();
			candidateeditpage.selectArchiveReason((String) jsonsuitetestData.get("archivereason1"));
			candidateeditpage.mouseOverToSelectArchiveAndDelete();
			candidateeditpage.selectUnArchiveReason();
			candidateeditpage.clickOnCloseButton();
			Assert.assertEquals(candidatepage.validateCandidateNameAterUnArchivedFromCandidateEditPage(candidateName), candidateName);
			updateTestRailResultAsPass("273088");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258694");
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
}
