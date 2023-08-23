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

public class CandidateSearchInTalentPool extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "CandidateSearch in talentPool Page";
		testSuiteDescription = "Testing the functionality of CandidateSearch in talentPoolpage";
		nodes = "CandidateSearch";
	}

	@Test
	public void TC001_Verify_user_is_able_search_the_added_candidate_in_talentPool_page() throws InterruptedException {
		String testName = "TC001_Verify_user_is_able_search_the_added_candidate_in_talentPool_page";
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
			homePage.clickTalentPoolMenu();
			String candidatename=candidatepage.getFirstCandidateNameAdded();
			talentpoolpage.searchCandidate(candidatename);
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			reportStep("candidate dispalyed after searching with candidate name in talent pool page", "pass");
			updateTestRailResultAsPass("284355");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284355");
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
		addcandidatepage.selectCandidateSource(source);
		addcandidatepage.clickAddCandidateButton();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
