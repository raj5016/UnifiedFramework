package com.auz.selenium.ui.talentpool.testcases;

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

public class ImportCandidateInTalentPool extends ProjectSpecificMethods {
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
		public void TC001_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_in_Talent_pool_page(){
			String testName = "TC001_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.clickOnContinueButtonInImportCandidate();
				homePage.clickCandidateMenu();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("287735");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287735");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC002_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_apply_from_importSection_in_Talent_pool_page(){
			String testName = "TC002_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_apply_from_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Apply");
				candidatepage.clickOnContinueButtonInImportCandidate();
				homePage.clickCandidateMenu();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("287743");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287743");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC003_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_offer_job_from_importSection_in_Talent_pool_page(){
			String testName = "TC003_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_offer_job_from_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			//AddCandidatePage addCandidatepage = new AddCandidatePage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Offer Job");
				candidatepage.clickOnContinueButtonInImportCandidate();
				homePage.clickCandidateMenu();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("287751");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287751");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC004_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_hired_from_importSection_in_Talent_pool_page(){
			String testName = "TC004_verify_user_is_able_to_upload_csvfile_successfully_with_job_stage_as_hired_from_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.selectjobstageinImportpage("Hired");
				candidatepage.clickOnContinueButtonInImportCandidate();
				homePage.clickCandidateMenu();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("287759");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287759");
				Assert.fail(e.getMessage());
			}
	}
		
		@Test
		public void TC005_verify_user_is_note_able_to_continue_without_choosing_field_in_auzmor_hire_options_in_importSection_in_Talent_pool_page(){
			String testName = "TC005_verify_user_is_note_able_to_continue_without_choosing_field_in_auzmor_hire_options_in_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnContinueButtonInImportCandidate();
				Assert.assertEquals(candidatepage.getContinuebuttonStatus(),false);
				updateTestRailResultAsPass("287767");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287767");
				Assert.fail(e.getMessage());
			}
		}
	
	
		@Test
		public void TC006_verify_user_is_not_able_to_continue_while_uploading_empty_csv_in_importSection_in_Talent_pool_page(){
			String testName = "TC006_verify_user_is_not_able_to_continue_while_uploading_empty_csv_in_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("EmptyCSV");
				Assert.assertEquals(candidatepage.getErrorMessagewhilecandidateImport(), (String) jsonsuitetestData.get("ImportCandidateError"));
				updateTestRailResultAsPass("287775");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287775");
				Assert.fail(e.getMessage());
			}
		}
	
		@Test
		public void TC007_verify_user_is_able_to_remove_the_csv_file_after_uploading_in_importSection_in_Talent_pool_page(){
			String testName = "TC007_verify_user_is_able_to_remove_the_csv_file_after_uploading_in_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("CandidateDetails");
				candidatepage.clickOnGoBackbutton();
				candidatepage.clickonremovefileinImportpage();
				updateTestRailResultAsPass("287783");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("287783");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC008_verify_user_is_able_to_download_the_sample_csv_file_in_importSection_in_Talent_pool_page(){
			String testName = "TC008_verify_user_is_able_to_download_the_sample_csv_file_in_importSection_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnSampleFilelink();
				updateTestRailResultAsPass("288163");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("288163");
				Assert.fail(e.getMessage());
			}
		}
		
		@Test
		public void TC009_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_for_multiple_candidate_in_Talent_pool_page(){
			String testName = "TC009_verify_user_is_able_to_upload_csvfile_successfully_from_importSection_for_multiple_candidate_in_Talent_pool_page";
			
			reportUpdate(testName);
			HomePage homePage = new HomePage(driver, test);
			CandidatePage candidatepage = new CandidatePage(driver, test);
			TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
			try {
				login();
				homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
				talentpoolpage.clickTalentPoolMenu();
				candidatepage.clickOnImportLink();
				candidatepage.clickOnImportButton();
				candidatepage.clickOnUploadCSVFile("MutipleCandidates");
				candidatepage.clickOnContinueButtonInImportCandidate();
				candidatepage.clickOnFieldinAuzmour();
				candidatepage.clickOnFieldinAuzmourMultipleCandidate();
				candidatepage.clickOnContinueButtonInImportCandidate();
				homePage.clickCandidateMenu();
				Assert.assertEquals(candidatepage.getFirstCandidateNameAdded(), (String) jsonsuitetestData.get("ImportCandidateName"));
				updateTestRailResultAsPass("288171");
			} catch (Exception e) {
				test.log(Status.ERROR, "StackTrace Result: " + e);
				reportStep("Test Case Not executed Successfully", "fail");
				updateTestRailResultAsFail("288171");
				Assert.fail(e.getMessage());
			}
		}
			
			@Test
			public void TC010_verify_user_is_able_not_able_to_continue_when_duplicate_fields_are_selected_in_mapping_in_Talent_pool_page(){
				String testName = "TC010_verify_user_is_able_not_able_to_continue_when_duplicate_fields_are_selected_in_mapping_in_Talent_pool_page";
				
				reportUpdate(testName);
				HomePage homePage = new HomePage(driver, test);
				CandidatePage candidatepage = new CandidatePage(driver, test);
				TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
				try {
					login();
					homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
					talentpoolpage.clickTalentPoolMenu();
					candidatepage.clickOnImportLink();
					candidatepage.clickOnImportButton();
					candidatepage.clickOnUploadCSVFile("MutipleCandidates");
					candidatepage.selectDuplicateFieldsinMapping("Last Name");
					Assert.assertEquals(candidatepage.getContinuebuttonStatus(),false);
					updateTestRailResultAsPass("288179");
				} catch (Exception e) {
					test.log(Status.ERROR, "StackTrace Result: " + e);
					reportStep("Test Case Not executed Successfully", "fail");
					updateTestRailResultAsFail("288179");
					Assert.fail(e.getMessage());
				}
		}
			
			@Test
			public void TC011_verify_user_is_not_able_to_continue_while_uploading_wrongly_mapped_csv_in_importSection_in_Talent_pool_page(){
				String testName = "TC011_verify_user_is_not_able_to_continue_while_uploading_wrongly_mapped_csv_in_importSection_in_Talent_pool_page";
				
				reportUpdate(testName);
				HomePage homePage = new HomePage(driver, test);
				CandidatePage candidatepage = new CandidatePage(driver, test);
				TalentPoolPage talentpoolpage = new TalentPoolPage(driver, test);
				try {
					login();
					homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
					talentpoolpage.clickTalentPoolMenu();
					candidatepage.clickOnImportLink();
					candidatepage.clickOnImportButton();
					candidatepage.clickOnUploadCSVFile("Wrongmapping");
					Assert.assertEquals(candidatepage.getErrorMessagewhilecandidateImport(), (String) jsonsuitetestData.get("ImportCandidateError"));
					updateTestRailResultAsPass("288187");
				} catch (Exception e) {
					test.log(Status.ERROR, "StackTrace Result: " + e);
					reportStep("Test Case Not executed Successfully", "fail");
					updateTestRailResultAsFail("288187");
					Assert.fail(e.getMessage());
				}
			}
	
}
