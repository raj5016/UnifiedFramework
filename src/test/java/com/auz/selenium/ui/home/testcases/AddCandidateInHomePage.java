package com.auz.selenium.ui.home.testcases;

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

public class AddCandidateInHomePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Adding Candidate for Hiring process";
		testSuiteDescription = "Testing the functionality of CandidateAdd";
		nodes = "Add CandidateIn HomePage";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job_in_home_page()throws InterruptedException 
	{
		String testName = "TC001_verify_user_is_able_to_add_candidate_successfully_without_mapping_job_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
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
			updateTestRailResultAsPass("269881");
			reportStep("Candidate added successfully", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269881");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job_in_home_page() throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_add_candidate_successfully_by_mapping_job_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
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
			updateTestRailResultAsPass("269888");
			reportStep("Candidate added successfully", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269888");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly_in_home_page()
			throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_add_candidate_successfully_by_entering_only_with_MandatoryFieldsOnly_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateName(candidateName);
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("269895");
			reportStep("Candidate added successfully", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269895");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields_in_home_page()
			throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_add_candidate_successfully_by_addingJob_and_by_entering_MandatoryFields_in_home_page";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidatepage.clickAddJobToCandidate();
			addCandidatepage.enterCandidateName(candidateName);
			addCandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidatepage.clickAddCandidateButton();
			Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("269902");
			reportStep("Candidate added successfully", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269902");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_application_throwing_error_when_firstName_is_not_entered_while_adding_the_candidate_in_home_page() throws InterruptedException {
		String testName = "TC005_verify_application_throwing_error_when_firstName_is_not_entered_while_adding_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateFirstNameErrorText(),
					(String) jsonsuitetestData.get("firstNameError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269909");
			reportStep("Application throwing error while mandatory fields are not entered", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269909");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_application_throwing_error_when_source_is_not_selected_while_adding_the_candidate_in_home_page() throws InterruptedException {
		String testName = "TC006_verify_application_throwing_error_when_source_is_not_selected_while_adding_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateName(RandomGenerator.randomName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269916");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269916");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only_while_adding_the_candidate_in_home_page()
			throws InterruptedException {
		String testName = "TC007_verify_application_throwing_error_while_submitting_candidate_by_entering_candidate_emaildId_only_while_adding_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateEmail(RandomGenerator.randomEmailAddress(8));
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269923");
			reportStep("Application throwing error while mandatory fields are not entered", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269923");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber_while_adding_the_candidate_in_home_page()
	{
		String testName = "TC008_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_mobileNumber_while_adding_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateMobileNumber(RandomGenerator.randomPhonenumber());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269930");
			reportStep("Application throwing error while mandatory fields are not entered", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269930");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany_while_adding_the_candidate_in_home_page()
{
		String testName = "TC009_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentCompany_while_adding_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateCurrentCompany(RandomGenerator.randomCompanyName());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269937");
			reportStep("Application throwing error while mandatory fields are not entered", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269937");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition_when_added_the_candidate_in_home_page()
			throws InterruptedException {
		String testName = "TC010_verify_application_throwing_error_while_submitting_candidate_by_entering_only_candidate_currentPosition_when_added_the_candidate_in_home_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addCandidate = new AddCandidatePage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addCandidate.enterCandidateCurrentDesgination(RandomGenerator.randomCurrentDesgination());
			addCandidate.clickAddCandidateButton();
			Assert.assertEquals(addCandidate.validateSourceErrorText(), (String) jsonsuitetestData.get("sourceError"));
			reportStep("Error text" + (String) jsonsuitetestData.get("firstNameError") + "validated Successfully",
					"pass");
			updateTestRailResultAsPass("269944");
			reportStep("Application throwing error while mandatory fields are not entered", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269944");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC011_verify_user_is_able_to_edit_candidate_information_successfully_which_is_added_through_home_page() {
		String testName = "TC011_verify_user_is_able_to_edit_candidate_information_successfully_which_is_added_through_home_page";

		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
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
			updateTestRailResultAsPass("269951");
			reportStep("Candidate edited Successfully", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269951");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC012_verify_user_is_able_to_archeive_candidate_information_successfully_when_candidate_is_Unresponsive_which_is_added_through_homepage() {
		String testName = "TC012_verify_user_is_able_to_archeive_candidate_information_successfully_when_candidate_is_Unresponsive_which_is_added_through_homepage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnArchive();
			candidatepage.clickArchiveCandidateByReason("Unresponsive");
			updateTestRailResultAsPass("269958");
			reportStep("Candidate archived Successfully by selecting reason as Unresponsive ", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269958");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC013_verify_user_is_able_to_add_candidate_successfully_by_mapping_resume_in_home_page()throws InterruptedException 
	{
		String testName = "TC013_verify_user_is_able_to_add_candidate_successfully_by_mapping_resume_in_home_page";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddCandidate();
			addcandidatepage.clickAddCandidateResume("sample_resume-1");
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			talentpoolpage.clickTalentPoolMenu();
			Assert.assertEquals(talentpoolpage.getFirstCandidateNameAdded(), candidateName);
			updateTestRailResultAsPass("281007");
			reportStep("Candidated added Successfully with Uploading Resume ", "pass");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281007");
			Assert.fail(e.getMessage());
		}
	}
}
