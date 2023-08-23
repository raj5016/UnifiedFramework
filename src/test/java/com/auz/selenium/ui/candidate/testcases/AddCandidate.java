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
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class AddCandidate extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Add candidate";
		testSuiteDescription = "Testing the functionality of Candidate adding for hiring process";
		nodes = "Add candidate";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job()
			throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job";

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
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
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
			updateTestRailResultAsPass("258346");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("258346");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job() throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addcandidatepage.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addcandidatepage.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addcandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("258352");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258352");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly()
			throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateName(candidateName);
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("258358");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258358");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields()
			throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidatepage.clickAddJobToCandidate();
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("258364");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258364");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_application_throwing_error_when_firstName_is_not_entered() throws InterruptedException {
		String testName = "TC005_verify_application_throwing_error_when_firstName_is_not_enetered";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateFirstNameErrorText(),
					(String) jsonsuitetestData.get("firstNameError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258370");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258370");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_application_throwing_error_when_source_is_not_selected() throws InterruptedException {
		String testName = "TC006_verify_application_throwing_error_when_source_is_not_selected";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateName(RandomGenerator.randomName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258376");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258376");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only()
			throws InterruptedException {
		String testName = "TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258382");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258382");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber()
			throws InterruptedException {
		String testName = "TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258388");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258388");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany()
			throws InterruptedException {
		String testName = "TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258394");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258394");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition()
			throws InterruptedException {
		String testName = "TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("258400");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258400");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_edit_candidate_information_successfully() {
		String testName = "TC011_verify_user_is_able_to_edit_candidate_information_successfully";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnEditCandidate();
			addcandidatepage.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addcandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("258436");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("258436");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC012_verify_user_is_able_to_add_candidate_successfully_by_uploadingResume(){
		String testName = "TC012_verify_user_is_able_to_add_candidate_successfully_by_uploadingResume";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidatepage.clickAddJobToCandidate();
			addCandidatepage.clickAddCandidateResume("sample_resume-1");
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("281000");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281000");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_add_candidate_via_resume_in_candidate_page(){
		String testName = "TC013_verify_user_is_able_to_add_candidate_via_resume_in_candidate_page";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickAddViaResumeCandidate();
			candidatepage.clickBrowseResumeCandidate("sample-resume-3");
			candidatepage.clickProceedAfterFileUpload();
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.clickAddJobToCandidate();
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			Assert.assertTrue(candidatepage.getFirstCandidateNameAdded().contains(candidateName));
			updateTestRailResultAsPass("281021");
			reportStep("Candidate added Successfully in Candidate page", "fail");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281021");
			Assert.fail(e.getMessage());
		}
	}
}
