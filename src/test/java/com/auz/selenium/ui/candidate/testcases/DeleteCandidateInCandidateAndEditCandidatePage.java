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
import com.aventstack.extentreports.Status;

public class DeleteCandidateInCandidateAndEditCandidatePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "DeleteCandidate";
		testSuiteDescription = "Testing the functionality of deletiing the Candidate in both candidate and EditCandidate page";
		nodes = "Delete Candidate";
	}
	
	@Test
	public void TC001_Verify_user_is_able_to_delete_candidate_in_candidatePage() throws InterruptedException {
		String testName = "TC001_Verify_user_is_able_to_delete_candidate_in_candidatePage";
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
			addCandidate(candidateName,(String)jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnDelete();
			Assert.assertNotEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate deleted Successfully in candidatePage", "pass");
			updateTestRailResultAsPass("273676");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273676");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_Verify_user_is_able_to_delete_candidate_in_candidate_editPage() throws InterruptedException {
		String testName = "TC002_Verify_user_is_able_to_delete_candidate_in_candidate_editPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateEditPage=new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName,(String)jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateEditPage.mouseOverToSelectArchiveAndDelete();
			candidateEditPage.selectDeleteCandidate();
			Assert.assertNotEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			reportStep("Candidate deleted Successfully in candidateEditPage", "pass");
			updateTestRailResultAsPass("273683");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273683");
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
			CandidatePage candidatepage = new CandidatePage(driver, test);
			candidatepage.clickOnArchive();
			candidatepage.clickArchiveCandidateByReason(archivereason);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
