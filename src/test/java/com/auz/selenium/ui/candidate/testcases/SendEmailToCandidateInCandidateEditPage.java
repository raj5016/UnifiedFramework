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

public class SendEmailToCandidateInCandidateEditPage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Sending Email To Candidate";
		testSuiteDescription = "Testing the functionality of Email sending process";
		nodes = "Email Sending";
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
			addcandidatepage.enterCandidateEmail(RandomGenerator.randomEmailAddress(3));
			addcandidatepage.clickAddCandidateButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TC001_Verify_user_is_able_sent_email_to_candidate_in_candidateeditPage() {
		String testName = "TC001_Verify_user_is_able_sent_email_to_candidate_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.enterEmailSubject((String) jsonsuitetestData.get("emailtemplateName"));
			candidateeditpage.enterEmailMessage(emailmsg);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
			reportStep("Email send to candidate Successfully", "pass");
			updateTestRailResultAsPass("281690");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281690");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC002_Verify_user_is_able_sent_email_to_candidate_by_selecting_predefined_email_template_in_candidateeditPage() {
		String testName = "TC002_Verify_user_is_able_sent_email_to_candidate_by_selecting_predefined_email_template_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailTemplate = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.selectEmailTemplate(emailTemplate);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
			reportStep("Email send to candidate Successfully with predefined template", "pass");
			updateTestRailResultAsPass("281753");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281753");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_Verify_user_is_able_sent_email_to_candidate_by_adding_cc_in_candidateeditPage() {
		String testName = "TC003_Verify_user_is_able_sent_email_to_candidate_by_adding_cc_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailTemplate = (String) jsonsuitetestData.get("emailtemplateName");
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.clickOnSendEmailWithCC();
			candidateeditpage.enterEmailSubject(emailTemplate);
			candidateeditpage.enterEmailMessage(emailmsg);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
			reportStep("Email send to candidate Successfully with CC", "pass");
			updateTestRailResultAsPass("281977");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281977");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC004_Verify_user_is_able_sent_email_to_candidate_by_adding_Bcc_in_candidateeditPage() {
		String testName = "TC004_Verify_user_is_able_sent_email_to_candidate_by_adding_Bcc_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailTemplate = (String) jsonsuitetestData.get("automationTemplateForSendingEmail");
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.clickOnSendEmailWithBCC();
			candidateeditpage.enterEmailSubject(emailTemplate);
			candidateeditpage.enterEmailMessage(emailmsg);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
			reportStep("Email send to candidate Successfully with BCC", "pass");
			updateTestRailResultAsPass("281984");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281984");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC005_verify_application_throwing_error_when_subject_is_not_entered_in_candidateeditPage() {
		String testName = "TC005_verify_application_throwing_error_when_subject_is_not_entered_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailSubjectErrorText = (String) jsonsuitetestData.get("emailSubjectErrorText");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSubjectRequiredErrortext(emailSubjectErrorText)
					.contains(emailSubjectErrorText));
			reportStep("Email subject error message validated Successfully", "pass");
			updateTestRailResultAsPass("282999");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("282999");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC006_verify_application_throwing_error_when_body_is_not_entered_in_candidateeditPage() {
		String testName = "TC006_verify_application_throwing_error_when_body_is_not_entered_in_candidateeditPage";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailBodyErrorText = (String) jsonsuitetestData.get("emailBodyErrorText");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(
					candidateeditpage.validateBodyRequiredErrortext(emailBodyErrorText).contains(emailBodyErrorText));
			reportStep("Email body error message validated Successfully", "pass");
			updateTestRailResultAsPass("283006");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283006");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC007_verify_application_throwing_proper_tooltip_message_when_sendEmail_button_is_disabled() {
		String testName = "TC007_verify_application_throwing_proper_tooltip_message_when_sendEmail_button_is_disabled";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String disabledEmailToolTipMessage = (String) jsonsuitetestData.get("disabledEmailToolTipMessage");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEmailTab();
			Assert.assertTrue(candidateeditpage.validateDisabledSendEmailToolTipText(disabledEmailToolTipMessage)
					.contains(disabledEmailToolTipMessage));
			reportStep("ToolTip message validated Successfully", "pass");
			updateTestRailResultAsPass("283640");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283640");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC008_verify_user_able_to_reply_to_sent_email() {
		String testName = "TC008_verify_user_able_to_reply_to_sent_email";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String emailId = RandomGenerator.randomEmailAddress(6);
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");
		String emailSubject = (String) jsonsuitetestData.get("emailtemplateName");
		String replyemailmsg = "Reply " + (String) jsonsuitetestData.get("emailtemplatebody");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnEditInformation();
			candidateeditpage.enterEmail(emailId);
			candidateeditpage.clickOnSave();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnEmailTab();
			candidateeditpage.clickOnNewSendEmail();
			candidateeditpage.enterEmailSubject(emailSubject);
			candidateeditpage.enterEmailMessage(emailmsg);
			candidateeditpage.clickOnSendEmail();
			candidateeditpage.clickOnEmailReplyButton();
			candidateeditpage.enterEmailMessage(replyemailmsg);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(replyemailmsg).contains(replyemailmsg));
			reportStep("User Replied to email successfully", "pass");
			updateTestRailResultAsPass("283892");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283892");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC009_verify_user_able_to_sendEmail_through_sendemail_link_provided_under_candidateProfile() {
		String testName = "TC009_verify_user_able_to_sendEmail_through_sendemail_link_provided_under_candidateProfile";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");
		String emailsubject = (String) jsonsuitetestData.get("emailtemplateName");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addCandidate(candidateName, (String) jsonsuitetestData.get("candidateSource"));
			candidatepage.clickOnCandidate();
			candidateeditpage.clickOnSendEmailUnderCandidateProfile();
			candidateeditpage.enterEmailSubject(emailsubject);
			candidateeditpage.enterEmailMessage(emailmsg);
			candidateeditpage.clickOnSendEmail();
			Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
			reportStep("Email sent to candidate Successfully", "pass");
			updateTestRailResultAsPass("283956");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283956");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC010_verify_application_throwing_proper_tooltip_message_when_user_trying_to_sendEmail_when_candidate_is_not_mapped_with_emailid_under_candidateProfile() {
		String testName = "TC010_verify_application_throwing_proper_tooltip_message_when_user_trying_to_sendEmail_when_candidate_is_not_mapped_with_emailid_under_candidateProfile";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CandidatePage candidatepage = new CandidatePage(driver, test);
		CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		String candidateName = RandomGenerator.randomName();
		String disabledEmailToolTipMessage = (String) jsonsuitetestData.get("disabledEmailToolTipMessage");

		try {
			login();
			homePage.clickCandidateMenu();
			candidatepage.clickManuallyAddCandidate();
			addcandidatepage.enterCandidateName(candidateName);
			addcandidatepage.clickAddJobToCandidate();
			addcandidatepage.selectCandidateSource((String) jsonsuitetestData.get("candidateSource"));
			addcandidatepage.clickAddCandidateButton();
			candidatepage.clickOnCandidate();
			addcandidatepage.moveToSendEmailUnderCandidateProfile();
			Assert.assertTrue(candidateeditpage
					.validateDisabledSendEmailToolTipTextUnderCandidateprofile(disabledEmailToolTipMessage)
					.contains(disabledEmailToolTipMessage));
			reportStep("ToolTip message validated Successfully", "pass");
			updateTestRailResultAsPass("283964");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("283964");
			Assert.fail(e.getMessage());
		}
	}
}
