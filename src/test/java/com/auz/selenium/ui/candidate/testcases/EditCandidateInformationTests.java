package com.auz.selenium.ui.candidate.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.CandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class EditCandidateInformationTests extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setValues() {
		testSuiteName = "EditCandidateInformation";
		testSuiteDescription = "Testing the functionality of Candidate edit(source,information,remove job,add tag) in EditCandidate page";
		nodes = "EditCandidate";
	}

	public void enterBasicJobDetails(String jobtitle, String department, String jobLocation, String NoOfOpeing) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobTitle(jobtitle);
		postJobPage.selectJobDepartment(department);
		postJobPage.selectJobLocation(jobLocation);
		postJobPage.enterNoOfOpening(NoOfOpeing);
		postJobPage.scrollBottom(driver);
		postJobPage.clickContinueOnGetStarted();
	}

	@Test
	public void TC001_Verify_user_is_able_to_change_the_sources_in_candidateEditPage() {
		String testName = "TC001_Verify_user_is_able_to_change_the_sources_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String changedScource = (String) jsonsuitetestData.get("changeSourceIneditInformation");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateeditpage.mouseOverToSelectSourceTag();
			candidateeditpage.selectSourcesReason((String) jsonsuitetestData.get("changeSourceIneditInformation"));
			Assert.assertEquals(candidatepage.validateSourcesFilterText(), changedScource);
			reportStep("Source:" + changedScource + " changed Successfully", "pass");
			updateTestRailResultAsPass("273704");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("273704");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_Verify_application_throwing_error_when_invalid_link_is_entered_in_candidateEditPage() {
		String testName = "TC002_Verify_application_throwing_error_when_invalid_link_is_entered_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String errortext = (String) jsonsuitetestData.get("invaliderrortext");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEditInformation();
			candidateeditpage.enterLink(RandomGenerator.randomAlphabetic(3));
			Assert.assertEquals(candidateeditpage.validateErrorMessageOfLink(errortext), errortext);
			reportStep("Invalid linktext is validated successfully", "pass");
			updateTestRailResultAsPass("275162");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("275162");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_Verify_user_is_able_to_edit_information_in_candidateEditPage() {
		String testName = "TC003_Verify_user_is_able_to_edit_information_in_candidateEditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String location = RandomGenerator.randomLocation();
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			String candidatename = candidatepage.getFirstCandidateNameAdded();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEditInformation();
			candidateeditpage.enterEmail(RandomGenerator.randomEmailAddress(3));
			candidateeditpage.enterPhone(RandomGenerator.randomPhonenumber());
			candidateeditpage.enterLocation(location);
			candidateeditpage.enterCurrentRole(RandomGenerator.randomCurrentDesgination());
			candidateeditpage.enterCurrentCompany(RandomGenerator.randomCompanyName());
			candidateeditpage.enterLink((String) jsonsuitetestData.get("candidateEditLink"));
			candidateeditpage.clickOnSave();
			candidateeditpage.clickOnCloseButton();
			Assert.assertEquals(
					candidatepage.validateCandidateLocationAterEditingInformationInCandidateEditPage(candidatename),
					location);
			reportStep("Candidate information edited Successfully", "pass");
			updateTestRailResultAsPass("274118");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("274118");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_Verify_user_is_able_to_enter_details_description_information_in_candidateEditPage() {
		String testName = "TC004_Verify_user_is_able_to_enter_details_description_information_in_candidateEditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnDetailsEditInformation();
			candidateeditpage.enterDetailsInformation(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnSaveDetailsInformation();
			candidateeditpage.clickOnCloseButton();
			reportStep("Candidate Details information entered Successfully", "pass");
			updateTestRailResultAsPass("275169");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("275169");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_user_is_able_to_select_the_tag_in_candidateEditPage() {
		String testName = "TC005_verify_user_is_able_to_select_the_tag_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.selectTags((String) jsonsuitetestData.get("selectTags"));
			candidateeditpage.clickOnCloseButton();
			reportStep("Tags selected Successfully", "pass");
			updateTestRailResultAsPass("275187");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("275187");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_user_is_able_to_remove_the_added_job_in_candidateEditPage() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_remove_the_added_job_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnRemoveJob();
			candidateeditpage.clickOnCloseButton();
			reportStep("candidate is moved to talentpool page after removing job in candidate editpage", "pass");
			updateTestRailResultAsPass("275326");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("275326");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_user_is_able_to_upload_resume_in_candidateEditPage() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_upload_resume_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String filename = "sample-resume-3";
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnResumeTab();
			candidateeditpage.clickOnUploadButton(filename);
			reportStep("Resume uploaded Successfully in Candidate edit page", "pass");
			updateTestRailResultAsPass("281108");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("281108");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_user_is_able_to_add_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC008_verify_user_is_able_to_add_the_comments_in_candidateEditPage";
		reportUpdate(testName);
		String tagName = "@";
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnCommentsSection();
			candidateeditpage.clickOnAddComments();
			candidateeditpage.clickOnDomain(tagName);
			candidateeditpage.enterCommentsInAddCommentsection(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnComment();
			candidateeditpage.clickToVerifyAddedComment();
			candidateeditpage.clickOnCloseButton();
			reportStep("comment is added to comment section in candidate editpage", "pass");
			updateTestRailResultAsPass("282005");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("282005");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_user_is_able_to_delete_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_delete_the_comments_in_candidateEditPage";
		String tagName = "@";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnCommentsSection();
			candidateeditpage.clickOnAddComments();
			candidateeditpage.clickOnDomain(tagName);
			candidateeditpage.enterCommentsInAddCommentsection(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnComment();
			candidateeditpage.clickToVerifyAddedComment();
			candidateeditpage.clickOnDeleteComments();
			candidateeditpage.clickOnDeleteCommentsButton();
			candidateeditpage.clickOnCloseButton();
			reportStep("comment is deleted from comment section in candidate editpage", "pass");
			updateTestRailResultAsPass("282033");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("282033");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_user_is_able_to_edit_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC010_verify_user_is_able_to_edit_the_comments_in_candidateEditPage";
		String tagName = "@";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnCommentsSection();
			candidateeditpage.clickOnAddComments();
			candidateeditpage.clickOnDomain(tagName);
			candidateeditpage.enterCommentsInAddCommentsection(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnComment();
			candidateeditpage.clickToVerifyAddedComment();
			candidateeditpage.clickOnEditComments();
			candidateeditpage.enterCommentsInAddCommentsection(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnComment();
			candidateeditpage.clickOnCloseButton();
			reportStep("comment is edited in the comment section in candidate editpage", "pass");
			updateTestRailResultAsPass("282040");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("282040");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC011_verify_user_is_able_to_submit_screening_response_in_candidateEditPage()
			throws InterruptedException {
		String testName = "TC011_verify_user_is_able_to_submit_screening_response_in_candidateEditPage";

		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobPage jobpage = new JobPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String response = RandomGenerator.randomAlphabetic(6);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobMenu();
			jobpage.clickAddNewJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.enterJobDescription((String) jsonsuitetestData.get("jobdescription"));
			postJobPage.enterJobWorkExperience(RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			postJobPage.selectJobEducation((String) jsonsuitetestData.get("education"));
			postJobPage.enterJobAnnualMinSalary(RandomGenerator.randomMinSalary());
			postJobPage.enterJobAnnualMaxSalary(RandomGenerator.randomMaxSalary());
			postJobPage.clickContinueOnJobDescription();
			postJobPage.clickonContinueInPublishJob();
			postJobPage.clickContinueOnAdvertiseJob();
			postJobPage.scrollBottom(driver);
			postJobPage.addScreening((String) jsonsuitetestData.get("screeningQuestion"));
			postJobPage.scrollBottom(driver);
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateLinkedinUrl((String) jsonsuitetestData.get("linkdenUrl"));
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnScreeningTab();
			candidateeditpage.clickOnScreeningJob();
			candidateeditpage.clickOnEditScreeningJob();
			candidateeditpage.enterScreeningResponse(response);
			candidateeditpage.clickOnSaveScreeningJob();
			Assert.assertEquals(candidateeditpage.validateScreeningResponsetext(response), response);
			reportStep("Screening response entered and validated successfully in candidate editpage", "pass");
			updateTestRailResultAsPass("283268");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("283268");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC012_verify_user_is_able_to_follow_the_candidate_by_clickong_the_follow_button_in_candidateEditPage() {
		String testName = "TC012_verify_user_is_able_to_follow_the_candidate_by_clickong_the_follow_button_in_candidateEditPage";

		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(6));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnFollowAndUnFollowButton("Follow");
			Assert.assertEquals(candidateeditpage.validateFollowingText(), "Following");
			reportStep("Candidate followed successfully", "pass");
			updateTestRailResultAsPass("288251");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("288251");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC013_verify_user_is_able_to_unfollow_the_candidate_in_candidateEditPage() {
		String testName = "TC013_verify_user_is_able_to_unfollow_the_candidate_in_candidateEditPage";

		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnFollowAndUnFollowButton("UnFollow");
			Assert.assertEquals(candidateeditpage.validateFollowingText(), "Follow");
			reportStep("Candidate unfollowed successfully", "pass");
			updateTestRailResultAsPass("288259");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("288259");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC014_verify_application_throwing_error_when_user_tries_add_comments_without_entering_comment_in_candidateEditPage(){
		String testName = "TC014_verify_application_throwing_error_when_user_tries_add_comments_without_entering_comment_in_candidateEditPage";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String commentmandatorytext=(String) jsonsuitetestData.get("commentmandatoryText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnCommentsSection();
			candidateeditpage.clickOnAddComments();
			candidateeditpage.clickOnComment();
			Assert.assertTrue(candidateeditpage.validateCommentMandatoryText(commentmandatorytext).contains(commentmandatorytext));
			reportStep("comment mandatory text :"+ commentmandatorytext +" validated successfully", "pass");
			updateTestRailResultAsPass("291683");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("291683");
			reportStep("Test Case Not executed Successfully", "fail");
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

	public void addCandidate(String candidateName, String source) {
		try {
			AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource(source);
			addcandidatepage.clickAddCandidateButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
