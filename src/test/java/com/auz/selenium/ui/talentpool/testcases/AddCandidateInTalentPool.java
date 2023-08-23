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

public class AddCandidateInTalentPool extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "AddCandidateInTalentPool";
		testSuiteDescription = "Testing the functionality of adding candidate";
		nodes = "AddJobs";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job_in_talent_pool_page() {
		String testName = "TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job_in_talent_pool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addcandidatepage.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addcandidatepage.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addcandidatepage.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("271752");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271752");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job_in_talentpool_page() {
		String testName = "TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addcandidatepage.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addcandidatepage.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addcandidatepage.clickAddCandidateButton();
			homePage.clickCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("271759");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271759");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly_in_talentpool_page() {
		String testName = "TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly_in_talentpool_page";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateName(candidateName);
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("271766");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271766");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields_in_talentpool_page() {
		String testName = "TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidatepage.clickAddJobToCandidate();
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			homePage.clickCandidateMenu();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("271773");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271773");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_application_throwing_error_when_firstName_is_not_entered_in_talentpool_page() {
		String testName = "TC005_verify_application_throwing_error_when_firstName_is_not_entered_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateFirstNameErrorText(),
					(String) jsonsuitetestData.get("firstNameError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271780");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271780");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_application_throwing_error_when_source_is_not_selected_in_talentpool_page() {
		String testName = "TC006_verify_application_throwing_error_when_source_is_not_selected_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateName(RandomGenerator.randomName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271787");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271787");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only_in_talentpool_page() {
		String testName = "TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271794");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271794");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber_in_talentpool_page() {
		String testName = "TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271801");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271801");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany_in_talentpool_page() {
		String testName = "TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271808");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271808");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition_in_talentpool_page() {
		String testName = "TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("271815");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271815");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC011_verify_user_is_able_to_edit_candidate_information_successfully_in_talentpool_page() {
		String testName = "TC011_verify_user_is_able_to_edit_candidate_information_successfully_in_talentpool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.clickAddCandidateButton();
			homePage.clickCandidateMenu();
			candidatepage.clickOnEditCandidate();
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("271822");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("271822");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC012_verify_user_is_able_to_add_candidate_successfully_by_mapping_resume_in_talent_pool_page() {
		String testName = "TC012_verify_user_is_able_to_add_candidate_successfully_by_mapping_resume_in_talent_pool_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			talentpoolpage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addcandidatepage.clickAddCandidateResume("sample_resume-1");
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("281014");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281014");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC013_verify_user_is_able_to_add_candidate_via_resume_in_talentpool_page(){
		String testName = "TC013_verify_user_is_able_to_add_candidate_via_resume_in_talentpool_page";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			candidatepage.clickAddViaResumeCandidate();
			candidatepage.clickBrowseResumeCandidate("sample-resume-3");
			candidatepage.clickProceedAfterFileUpload();
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			Assert.assertTrue(talentpoolpage.getFirstCandidateNameAdded().contains(candidateName));
			updateTestRailResultAsPass("281028");
			reportStep("Candidate added Successfully in talentpool page", "Pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281028");
			Assert.fail(e.getMessage());
		}
	}
}
