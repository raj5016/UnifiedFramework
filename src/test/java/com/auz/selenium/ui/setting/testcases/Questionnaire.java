package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.QuestionnariePage;
import com.aventstack.extentreports.Status;

public class Questionnaire extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
	String questionarename = (String)jsonsuitetestData.get("questionnnareName");
	String addquestionname = (String)jsonsuitetestData.get("Addquestion");
	String editaddquestionname = "Edit"+(String)jsonsuitetestData.get("Addquestion");
	String editquestionarename="Edit"+(String)jsonsuitetestData.get("questionnnareName");

	@BeforeTest
	public void setValues() {
		testSuiteName = "Questionnaire";
		testSuiteDescription = "Testing the Questionnaire(add,edit,delete)Functionality";
		nodes = "Questionnaire";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_text_multiline_setting_questionare_page(){
		String testName = "TC001_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_text_multiline_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("multiLineQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			Assert.assertEquals(questionnariePage.validateAddedQuestionareeName(questionarename), questionarename);
			reportStep("Questionnare name added Successfully", "pass");
			updateTestRailResultAsPass("280475");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("280475");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_edit_the_addedQuestionnaire_name_in_setting_questionare_page(){
		String testName = "TC002_verify_user_is_able_to_edit_the_addedQuestionnaire_name_in_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnEditQuestionnaire(questionarename);
			questionnariePage.enterQuestionnaireName(editquestionarename);
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			Assert.assertEquals(questionnariePage.validateAddedQuestionareeName(editquestionarename), editquestionarename);
			reportStep("Questionnare name edited Successfully", "pass");
			updateTestRailResultAsPass("280538");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("280538");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_edit_added_questionType_setting_questionare_page(){
		String testName = "TC003_verify_user_is_able_to_edit_added_questionType_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnEditQuestionnaire(editquestionarename);
			questionnariePage.clickOnEditAddQuestionType(addquestionname);
			questionnariePage.enterAddQuestion(editaddquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			Assert.assertEquals(questionnariePage.validateAddedQuestionareeName(editquestionarename), editquestionarename);
			reportStep("Question Type edited Successfully", "pass");
			updateTestRailResultAsPass("281059");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281059");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC004_verify_user_is_able_to_delete_and_add_questionType_again_in_setting_questionare_page(){
		String testName = "TC004_verify_user_is_able_to_delete_and_add_questionType_again_in_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnEditQuestionnaire(editquestionarename);
			questionnariePage.clickOnDeleteAddQuestionType(editaddquestionname);
			questionnariePage.clickOnConfirmDeleteQuestionType();
			questionnariePage.clickOnAddAfterConfirmDeleteOfQuestionType();
			questionnariePage.enterAddQuestion(editaddquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			Assert.assertEquals(questionnariePage.validateAddedQuestionareeName(editquestionarename), editquestionarename);
			reportStep("Question Type deleted and added again Successfully", "pass");
			updateTestRailResultAsPass("281640");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281640");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC005_verify_user_is_able_to_delete_the_addedQuestionnaire_name_in_setting_questionare_page(){
		String testName = "TC005_verify_user_is_able_to_delete_the_addedQuestionnaire_name_in_setting_questionare_page";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		String questionnaredeletetext=(String) jsonsuitetestData.get("questionnaredeleteText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnDeleteQuestionnaire(editquestionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			Assert.assertEquals(questionnariePage.validateQuestionnareDeleteText(questionnaredeletetext), questionnaredeletetext);;
			reportStep("Questionnare name deleted Successfully", "pass");
			updateTestRailResultAsPass("280545");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("280545");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_application_throwing_error_when_question_is_not_entered__in_addedQuestionnaire_page(){
		String testName = "TC006_verify_application_throwing_error_when_question_is_not_entered__in_addedQuestionnaire_page";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.clickOnAddQuestion();
			Assert.assertEquals(questionnariePage.validateErrorTextOfQuestionField(), (String) jsonsuitetestData.get("questionErrorText"));
			reportStep("Error text validated Successfully", "pass");
			updateTestRailResultAsPass("281647");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("281647");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_application_throwing_error_when_questionnare_is_not_entered_in_Questionnaire_page(){
		String testName = "TC007_verify_application_throwing_error_when_questionnare_is_not_entered_in_Questionnaire_page";
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		String questionnarerequiredtext=(String) jsonsuitetestData.get("questionnarerequiredText");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			Assert.assertEquals(questionnariePage.validateQuestionnareRequiredText(questionnarerequiredtext),questionnarerequiredtext);
			reportStep("Error text validated Successfully", "pass");
			updateTestRailResultAsPass("289655");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("289655");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC008_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_text_singleline_setting_questionare_page(){
		String testName = "TC008_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_text_singleline_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("SingleLineQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with singleline as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291691");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291691");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC009_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_singlechoice_setting_questionare_page(){
		String testName = "TC009_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_singlechoice_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("SinglechoiceQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddAnswer();
			questionnariePage.enterOptionalAnswer1();
			questionnariePage.clickOnAddAnswer();
			questionnariePage.enterOptionalAnswer2();
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with singlechoice as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291699");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291699");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC010_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_multiplechoice_setting_questionare_page(){
		String testName = "TC010_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_multiplechoice_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("multiplechoiceQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddAnswer();
			questionnariePage.enterOptionalAnswer1();
			questionnariePage.clickOnAddAnswer();
			questionnariePage.enterOptionalAnswer2();
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with multiplechoice as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291707");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291707");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC011_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_yesorno_setting_questionare_page(){
		String testName = "TC011_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_yesorno_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("yesornoQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with YesOrNo as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291739");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291739");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC012_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_videoanswer_setting_questionare_page(){
		String testName = "TC012_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_videoanswer_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("videoAnswerQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with videoanswer as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291715");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291715");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC013_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_filetype_setting_questionare_page(){
		String testName = "TC013_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_filetype_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("fileQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with filetype as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291723");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291723");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC014_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_date_setting_questionare_page(){
		String testName = "TC014_verify_user_is_able_to_add_Questionnaire_by_selecting_AddQuestion_as_date_setting_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("dateQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			questionnariePage.clickOnAddAndUpdateButtonQuestionnaire();
			questionnariePage.clickOnDeleteQuestionnaire(questionarename);
			questionnariePage.clickOnConfirmDeleteQuestionnaire();
			reportStep("Questionnare name added with date as questiontype and deleted successfully", "pass");
			updateTestRailResultAsPass("291731");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291731");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC015_verify_application_throwing_error_when_optionalfield_is_not_entered_while_adding_by_selecting_the_choice_as_AddQuestion_in_questionare_page(){
		String testName = "TC015_verify_application_throwing_error_when_optionalfield_is_not_entered_while_adding_by_selecting_the_choice_as_AddQuestion_in_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		String questionnareoptionalFieldErrorText=(String) jsonsuitetestData.get("questionnareoptionalFieldErrorText");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("multiplechoiceQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddAnswer();
			questionnariePage.clickOnAddQuestion();
			Assert.assertTrue(questionnariePage.validateOptionalFieldErrorText(questionnareoptionalFieldErrorText).contains(questionnareoptionalFieldErrorText));
			reportStep("Questionnare optionalfield :"+ questionnareoptionalFieldErrorText+" error text validated successfully", "pass");
			updateTestRailResultAsPass("291759");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291759");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC016_verify_application_throwing_error_when_optionalfield_is_notselected_while_adding_by_selecting_the_choice_as_AddQuestion_in_questionare_page(){
		String testName = "TC015_verify_application_throwing_error_when_optionalfield_is_not_entered_while_adding_by_selecting_the_choice_as_AddQuestion_in_questionare_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		QuestionnariePage questionnariePage=new QuestionnariePage(driver, test);
		String questionnareoptionalmandatoryerrortext=(String) jsonsuitetestData.get("questionnareoptionalmandatoryerrortext");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			questionnariePage.clickOnQuestionnaireMenu();
			questionnariePage.clickOnAddNewQuestionnaire();
			questionnariePage.enterQuestionnaireName(questionarename);
			questionnariePage.selectAddQuestionType((String) jsonsuitetestData.get("multiplechoiceQuestionTypeTag"));
			questionnariePage.enterAddQuestion(addquestionname);
			questionnariePage.clickOnAddQuestion();
			Assert.assertTrue(questionnariePage.validatetwoOptionalMandatoryErrorText(questionnareoptionalmandatoryerrortext).contains(questionnareoptionalmandatoryerrortext));
			reportStep("Questionnare optionalfield :"+ questionnareoptionalmandatoryerrortext+" error text validated successfully", "pass");
			updateTestRailResultAsPass("291767");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("291767");
			Assert.fail(e.getMessage());
		}
	}
}
