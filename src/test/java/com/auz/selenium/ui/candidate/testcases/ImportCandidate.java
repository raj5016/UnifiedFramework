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

public class ImportCandidate extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Import candidate profile for hiring process";
		testSuiteDescription = "Testing the functionality of Importing CSV in candidate module";
		nodes = "Jobs";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}
	
	public void scheduleInterview(String strinterviewStage) {
		CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
		candidateeditPage.clickOnScheduleInterview();
		waitForElementLoad(1000);
		candidateeditPage.selectInterviewStage(strinterviewStage);
		candidateeditPage.clickInterviewType();
		candidateeditPage.clickOnScheduleInterviewOnSelctedDate();
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
		public void TC001_verify_user_is_able_to_upload_csvfile_successfully_from_importSection(){
			String testName = "TC001_verify_user_is_able_to_upload_csvfile_successfully_from_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("284603");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284603");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC002_Verify_user_is_able_schedule_an_interview_to_an_imported_candidate() throws InterruptedException {
			String testName = "TC002_Verify_user_is_able_schedule_an_interview_to_an_imported_candidate";
			// setting Report data
			reportUpdate(testName);
	
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatePage = new CandidatePage(driver, test);
			CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
	
			try {
				login();
				homePage.clickCandidateMenu();
				candidatePage.clickOnCandidate();
				scheduleInterview((String) jsonsuitetestData.get("interviewstage"));
				Assert.assertTrue(candidateeditPage.validateInterviewScheduledText()
							.contains((String) jsonsuitetestData.get("InterviewSchduledSuccessfullText")));
				reportStep("Interview scheduled Successfully", "pass");
				updateTestRailResultAsPass("284611");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284611");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC003_Verify_user_is_able_edit_the_scheduled_interview_for_an_imported_candidate() throws InterruptedException {
			String testName = "TC003_Verify_user_is_able_edit_the_scheduled_interview_for_an_imported_candidate";
	
			// setting Report data
			reportUpdate(testName);
	
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatePage = new CandidatePage(driver, test);
			CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
			String location = RandomGenerator.randomLocation();
	
			try {
				login();
				homePage.clickCandidateMenu();
				candidatePage.clickOnCandidate();
				candidateeditPage.editTheScheduledInterview(location);
				Assert.assertEquals(candidateeditPage.validateInterviewEditedLocationText(location), location);
				reportStep("Scheduled Interview edited Successfully", "pass");
				updateTestRailResultAsPass("284619");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284619");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC004_Verify_user_is_able_delete_the_scheduled_interview_for_an_imported_candidate() throws InterruptedException {
			String testName = "TC004_Verify_user_is_able_delete_the_scheduled_interview_for_an_imported_candidate";
	
			// setting Report data
			reportUpdate(testName);
	
			HomePage homePage = new HomePage(driver, test);
			CandidateEditPage candidatePage = new CandidateEditPage(driver, test);
			CandidateEditPage candidateeditPage = new CandidateEditPage(driver, test);
			
			try {
			login();
			homePage.clickCandidateMenu();
			candidatePage.clickOnCandidate();
			candidateeditPage.deleteTheScheduledInterview();
			reportStep("Scheduled Interview Deleted Successfully", "pass");
			updateTestRailResultAsPass("284627");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284627");
			Assert.fail(e.getMessage());
		}
			
	  }
		
		@Test
		public void TC005_Verify_user_is_able_send_email_to_imported_candidate_in_candidateeditPage() {
			String testName = "TC005_Verify_user_is_able_send_email_to_imported_candidate_in_candidateeditPage";
			// setting Report data
			reportUpdate(testName);
			
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
			String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");

			try {
				login();
				homePage.clickCandidateMenu();
				candidatepage.clickOnCandidate();
				candidateeditpage.clickOnEmailTab();
				candidateeditpage.clickOnNewSendEmail();
				candidateeditpage.enterEmailSubject((String) jsonsuitetestData.get("emailtemplateName"));
				candidateeditpage.enterEmailMessage(emailmsg);
				candidateeditpage.clickOnSendEmail();
				Assert.assertTrue(candidateeditpage.validateSentEmailBody(emailmsg).contains(emailmsg));
				reportStep("Email send to candidate Successfully", "pass");
				updateTestRailResultAsPass("284723");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284723");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC006_Verify_user_is_able_sent_email_to_imported_candidate_by_selecting_predefined_email_template_in_candidateeditPage() {
			String testName = "TC006_Verify_user_is_able_sent_email_to_imported_candidate_by_selecting_predefined_email_template_in_candidateeditPage";
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
				updateTestRailResultAsPass("284731");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284731");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC007_verify_user_able_to_sendEmail_through_sendemail_link_provided_under_candidateProfile_for_an_imported_candidate() {
			String testName = "TC007_verify_user_able_to_sendEmail_through_sendemail_link_provided_under_candidateProfile_for_an_imported_candidate";
			// setting Report data
			reportUpdate(testName);

			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			CandidateEditPage candidateeditpage = new CandidateEditPage(driver, test);
			String emailmsg = (String) jsonsuitetestData.get("emailtemplatebody");
			String emailsubject = (String) jsonsuitetestData.get("emailtemplateName");

			try {
				login();
				homePage.clickCandidateMenu();
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
		public void TC008_verify_user_is_able_to_archeive_imported_candidate_information_successfully() {
			String testName = "TC008_verify_user_is_able_to_archeive_imported_candidate_information_successfully";

			// setting Report data
			reportUpdate(testName);

			HomePage homePage = new HomePage(driver, test);

			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				archiveCandidate((String) jsonsuitetestData.get("archivereason1"));
				updateTestRailResultAsPass("284747");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284747");
				Assert.fail(e.getMessage());
			}
		}
		
		
		@Test
		public void TC009_Verify_user_is_able_to_delete_an_imported_candidate_in_candidatePage() throws InterruptedException {
			String testName = "TC009_Verify_user_is_able_to_delete_an_imported_candidate_in_candidatePage";
			// setting Report data
			reportUpdate(testName);

			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			String candidateName = RandomGenerator.randomName();

			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnDelete();
				Assert.assertNotEquals(candidatepage.getFirstCandidateNameAdded(), candidateName);
				reportStep("Candidate deleted Successfully in candidatePage", "pass");
				updateTestRailResultAsPass("284755");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284755");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC010_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_apply_from_importSection(){
			String testName = "TC010_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_apply_from_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Apply");
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("284635");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284635");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC011_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_offer_job_from_importSection(){
			String testName = "TC011_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_offer_job_from_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Offer Job");
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("284643");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284643");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC012_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_hired_from_importSection(){
			String testName = "TC012_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_hired_from_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Hired");
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("284651");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284651");
				Assert.fail(e.getMessage());
			}
	}
		
		@Test
		public void TC013_verify_user_is_note_able_to_continue_without_choosing_field_in_auzmor_hire_options_in_importSection(){
			String testName = "TC013_verify_user_is_note_able_to_continue_without_choosing_field_in_auzmor_hire_options_in_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getContinuebuttonStatus(),false);
				updateTestRailResultAsPass("284659");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284659");
				Assert.fail(e.getMessage());
			}
		}
	
	
		@Test
		public void TC014_verify_user_is_not_able_to_continue_while_uploading_empty_csv_in_importSection(){
			String testName = "TC014_verify_user_is_not_able_to_continue_while_uploading_empty_csv_in_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("EmptyCSV");
				Assert.assertEquals(candidatepage.getErrorMessagewhilecandidateImport(), (String) jsonsuitetestData.get("ImportCandidateError"));
				updateTestRailResultAsPass("284667");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284667");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC015_verify_user_is_able_to_remove_the_csv_file_after_uploading_in_importSection(){
			String testName = "TC015_verify_user_is_able_to_remove_the_csv_file_after_uploading_in_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnGoBackbutton();
				candidatepage.clickonremovefileinImportpage();
				updateTestRailResultAsPass("284675");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284675");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC016_verify_user_is_able_to_download_the_sample_csv_file_in_importSection(){
			String testName = "TC016_verify_user_is_able_to_download_the_sample_csv_file_in_importSection";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnSampleFilelink();
				updateTestRailResultAsPass("284763");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284763");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC017_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_for_multiple_candidate(){
			String testName = "TC017_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_for_multiple_candidate";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				homePage.clickCandidateMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("MutipleCandidates");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.clickOnFieldinAuzmourMultipleCandidate();
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("284811");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("284811");
				Assert.fail(e.getMessage());
			}
		}
			
			@Test
			public void TC018_verify_user_is_able_not_able_to_continue_when_duplicate_fields_are_selected_in_mapping(){
				String testName = "TC018_verify_user_is_able_not_able_to_continue_when_duplicate_fields_are_selected_in_mapping";
				
				reportUpdate(testName);
				HomePage homePage = new HomePage(driver, test);
				CandidatePage candidatepage = new CandidatePage(driver, test);
				//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
				try {
					login();
					homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
					homePage.clickCandidateMenu();
					candidatepage.clickOnImportLink();
					candidatepage.clickOnImportButton();
					candidatepage.clickOnUploadCSVFile("MutipleCandidates");
					candidatepage.selectDuplicateFieldsinMapping("Last Name");
					Assert.assertEquals(candidatepage.getContinuebuttonStatus(),false);
					updateTestRailResultAsPass("284819");
				} catch (Exception e) {
					test.log(Status.ERROR, "StackTrace Result: " + e);
					reportStep("Test Case Not executed Successfully", "fail");
					updateTestRailResultAsFail("284819");
					Assert.fail(e.getMessage());
				}
		}
			
			@Test
			public void TC019_verify_user_is_not_able_to_continue_while_uploading_wrongly_mapped_csv_in_importSection(){
				String testName = "TC019_verify_user_is_not_able_to_continue_while_uploading_wrongly_mapped_csv_in_importSection";
				
				reportUpdate(testName);
				HomePage homePage = new HomePage(driver, test);
				CandidatePage candidatepage = new CandidatePage(driver, test);
				//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
				try {
					login();
					homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
					homePage.clickCandidateMenu();
					candidatepage.clickOnImportLink();
					candidatepage.clickOnImportButton();
					candidatepage.clickOnUploadCSVFile("Wrongmapping");
					Assert.assertEquals(candidatepage.getErrorMessagewhilecandidateImport(), (String) jsonsuitetestData.get("ImportCandidateError"));
					updateTestRailResultAsPass("284827");
				} catch (Exception e) {
					test.log(Status.ERROR, "StackTrace Result: " + e);
					reportStep("Test Case Not executed Successfully", "fail");
					updateTestRailResultAsFail("284827");
					Assert.fail(e.getMessage());
				}
			}
	
}
