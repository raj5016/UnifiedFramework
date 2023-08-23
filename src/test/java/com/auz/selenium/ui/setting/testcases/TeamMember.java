package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.TeamMemberPage;
import com.aventstack.extentreports.Status;

public class TeamMember extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "TeamMember";
		testSuiteDescription = "Testing the Team Member Adding Functionality";
		nodes = "Team Member";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_add_NewteamMember_under_TeamMember_in_setting_page()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_NewteamMember_under_TeamMember_in_setting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String firstname = (String) jsonsuitetestData.get("settingfirstname");
		String email = (String) jsonsuitetestData.get("settingemail");
		String role = (String) jsonsuitetestData.get("settingRole");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnAddNewMember();
			teamMemberPage.enterFirstName(firstname);
			teamMemberPage.enterEmail(email);
			teamMemberPage.selectRole(role);
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Team Member added Successfully", "pass");
			updateTestRailResultAsPass("262752");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262752");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_application_updated_emailid_properly_In_teamMember_Page()
			throws InterruptedException {
		String testName = "TC002_verify_application_updated_emailid_properly_In_teamMember_Page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String email = (String) jsonsuitetestData.get("settingemail");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Email :" + email + " Updated Successfully", "pass");
			updateTestRailResultAsPass("262759");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262759");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_application_updated_role_properly_In_teamMember_Page()throws InterruptedException {
		String testName = "TC003_verify_application_updated_role_properly_In_teamMember_Page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			Assert.assertEquals(teamMemberPage.validateAddedRole(role), role);
			reportStep("Role :" + role + " Updated Successfully", "pass");
			updateTestRailResultAsPass("262766");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262766");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		String resendInvitetext = (String) jsonsuitetestData.get("resendInvitetext");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnResentInvite(role);
			Assert.assertEquals(teamMemberPage.validateResentInviteAndDeleteSuccessfullText(resendInvitetext),resendInvitetext);
			reportStep("ReInvite sent Successfully", "pass");
			updateTestRailResultAsPass("262983");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262983");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_delete_invite_which_is_added()throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_delete_invite_which_is_added";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		String deleteTeamMembertext = (String) jsonsuitetestData.get("deleteTeamMembertext");

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnDeleteTeamMemberAdded(role);
			teamMemberPage.clickOnConfirmDeleteTeamMemberAdded();
			Assert.assertEquals(teamMemberPage.validateResentInviteAndDeleteSuccessfullText(deleteTeamMembertext),deleteTeamMembertext);
			reportStep("Added team member deleted successfully", "pass");
			updateTestRailResultAsPass("263095");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("263095");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC006_verify_application_throwing_error_when_FirstName_is_not_enetered_under_settingpage() {
		String testName = "TC006_verify_application_throwing_error_when_FirstName_is_not_enetered_under_settingpage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String firstnameerror = (String) jsonsuitetestData.get("firstNameErrorInTeamMember");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnAddNewMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(firstnameerror),firstnameerror);
			reportStep("FirstName error text validated successfully", "pass");
			updateTestRailResultAsPass("284571");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284571");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_application_throwing_error_when_Email_is_not_enetered_under_settingpage(){
		String testName = "TC007_verify_application_throwing_error_when_Email_is_not_enetered_under_settingpage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String emailError = (String) jsonsuitetestData.get("emailError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnAddNewMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(emailError),emailError);
			reportStep("Email error text validated successfully", "pass");
			updateTestRailResultAsPass("284579");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284579");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC008_verify_application_throwing_error_when_role_is_not_selected_under_settingpage() {
		String testName = "TC008_verify_application_throwing_error_when_role_is_not_selected_under_settingpage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String pleaseselectroleError = (String) jsonsuitetestData.get("pleaseselectroleError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnAddNewMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(pleaseselectroleError),pleaseselectroleError);
			reportStep("Email error text validated successfully", "pass");
			updateTestRailResultAsPass("284587");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284587");
			Assert.fail(e.getMessage());
		}
	}
}
