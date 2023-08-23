package com.auz.selenium.ui.talentpool.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.CandidateEditPage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TalentPoolPage;
import com.aventstack.extentreports.Status;

public class EditCandidateInformationInTalentPool extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setValues() {
		testSuiteName = "Candidate edit-TalentPool";
		testSuiteDescription = "Testing the functionality of Candidate edit(source,information,remove job,add tag) in EditCandidate page";
		nodes = "EditCandidate";
	}

	@Test
	public void TC001_Verify_user_is_able_to_change_the_sources_of_talentpoolcandidate_in_candidateEditPage() {
		String testName = "TC001_Verify_user_is_able_to_change_the_sources_of_talentpollcandidate_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String changedScource = (String) jsonsuitetestData.get("changeSourceIneditInformation");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.mouseOverToSelectSourceTag();
			candidateeditpage.selectSourcesReason((String) jsonsuitetestData.get("changeSourceIneditInformation"));
			Assert.assertEquals(talentpoolpage.validateSourcesFilterText(), changedScource);
			reportStep("Source:" + changedScource + " changed Successfully", "pass");
			updateTestRailResultAsPass("284379");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284379");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_Verify_application_throwing_error_when_invalid_link_is_entered_of_talentpoolcandidate_in_candidateEditPage() {
		String testName = "TC002_Verify_application_throwing_error_when_invalid_link_is_entered_of_talentpoolcandidate_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String errortext = (String) jsonsuitetestData.get("invaliderrortext");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnEditInformation();
			candidateeditpage.enterLink(RandomGenerator.randomAlphabetic(3));
			Assert.assertEquals(candidateeditpage.validateErrorMessageOfLink(errortext), errortext);
			reportStep("Invalid linktext is validated successfully", "pass");
			updateTestRailResultAsPass("284387");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284387");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_Verify_user_is_able_to_edit_talentPoolcandidate_information_in_candidateEditPage() {
		String testName = "TC003_Verify_user_is_able_to_edit_talentPoolcandidate_information_in_candidateEditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String location = RandomGenerator.randomLocation();
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			String candidatename = talentpoolpage.getFirstCandidateNameAdded();
			talentpoolpage.clickonCandidateFirstName();
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
					talentpoolpage.validateCandidateLocationAterEditingInformationInCandidateEditPage(candidatename),
					location);
			reportStep("Candidate information edited Successfully", "pass");
			updateTestRailResultAsPass("284395");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284395");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_Verify_user_is_able_to_enter_details_description_information_in_candidateEditPage() {
		String testName = "TC004_Verify_user_is_able_to_enter_details_description_information_in_candidateEditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnDetailsEditInformation();
			candidateeditpage.enterDetailsInformation(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnSaveDetailsInformation();
			candidateeditpage.clickOnCloseButton();
			reportStep("Candidate Details information entered Successfully", "pass");
			updateTestRailResultAsPass("284403");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284403");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_user_is_able_to_select_the_tag_in_candidateEditPage() {
		String testName = "TC005_verify_user_is_able_to_select_the_tag_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.selectTags((String) jsonsuitetestData.get("selectTags"));
			candidateeditpage.clickOnCloseButton();
			reportStep("Tags selected Successfully", "pass");
			updateTestRailResultAsPass("284411");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284411");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_user_is_able_to_upload_resume_in_candidateEditPage() throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_upload_resume_in_candidateEditPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String filename = "sample-resume-3";
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnResumeTab();
			candidateeditpage.clickOnUploadButton(filename);
			reportStep("Resume uploaded Successfully in Candidate edit page", "pass");
			updateTestRailResultAsPass("284419");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284419");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_user_is_able_to_add_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_add_the_comments_in_candidateEditPage";
		reportUpdate(testName);
		String tagName = "@";
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnCommentsSection();
			candidateeditpage.clickOnAddComments();
			candidateeditpage.clickOnDomain(tagName);
			candidateeditpage.enterCommentsInAddCommentsection(RandomGenerator.randomAlphabetic(15));
			candidateeditpage.clickOnComment();
			candidateeditpage.clickToVerifyAddedComment();
			candidateeditpage.clickOnCloseButton();
			reportStep("comment is added to comment section in candidate editpage", "pass");
			updateTestRailResultAsPass("284427");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284427");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_user_is_able_to_delete_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC008_verify_user_is_able_to_delete_the_comments_in_candidateEditPage";
		String tagName = "@";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
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
			updateTestRailResultAsPass("284443");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284443");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_user_is_able_to_edit_the_comments_in_candidateEditPage() throws InterruptedException {
		String testName = "TC009_verify_user_is_able_to_edit_the_comments_in_candidateEditPage";
		String tagName = "@";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
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
			updateTestRailResultAsPass("284451");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284451");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_user_is_able_to_follow_the_candidate_through_talentpoolPage_by_clicking_the_follow_button_in_candidateEditPage() {
		String testName = "TC010_verify_user_is_able_to_follow_the_candidate_through_talentpoolPage_by_clicking_the_follow_button_in_candidateEditPage";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnFollowAndUnFollowButton("Follow");
			Assert.assertEquals(candidateeditpage.validateFollowingText(), "Following");
			reportStep("Candidate followed successfully in talentpool page", "pass");
			updateTestRailResultAsPass("288267");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("288267");
			reportStep("Test Case Not executed Successfully", "fail");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC011_verify_user_is_able_to_unfollow_the_candidate_through_talentpoolpage_by_clicking_the_follow_button_in_candidateEditPage() {
		String testName = "TC011_verify_user_is_able_to_unfollow_the_candidate_through_talentpoolpage_by_clicking_the_follow_button_in_candidateEditPage";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickTalentPoolMenu();
			talentpoolpage.clickonCandidateFirstName();
			candidateeditpage.clickOnFollowAndUnFollowButton("UnFollow");
			Assert.assertEquals(candidateeditpage.validateFollowingText(), "Follow");
			reportStep("Candidate unfollowed successfully", "pass");
			updateTestRailResultAsPass("288275");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("288275");
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
			addcandidatepage.selectCandidateSource(source);
			addcandidatepage.clickAddCandidateButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
