package com.auz.selenium.ui.manage.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.ManagePage;
import com.auz.selenium.pages.TeamMemberPage;
import com.aventstack.extentreports.Status;

public class InviteTeamMember extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "InviteTeamMember-ManagePage";
		testSuiteDescription = "Testing the Team Member Adding Functionality In Manage Menu";
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
	public void TC001_verify_user_is_able_to_add_NewteamMember_under_TeamMember_in_ManageMenu()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_NewteamMember_under_TeamMember_in_ManageMenu";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String firstname = (String) jsonsuitetestData.get("settingfirstname");
		String email = (String) jsonsuitetestData.get("settingemail");
		String role = (String) jsonsuitetestData.get("settingRole");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnInviteTeamMember();
			teamMemberPage.enterFirstName(firstname);
			teamMemberPage.enterEmail(email);
			teamMemberPage.selectRole(role);
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Team Member added Successfully", "pass");
			updateTestRailResultAsPass("284507");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284507");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_application_updated_emailid_properly_In_teamMember_Page_which_is_added_through_managePage(){
		String testName = "TC002_verify_application_updated_emailid_properly_In_teamMember_Page_which_is_added_through_managePage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String email = (String) jsonsuitetestData.get("settingemail");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnTeamMember();
			teamMemberPage.clickOnTeamMemberMenu();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Email :" + email + " Updated Successfully", "pass");
			updateTestRailResultAsPass("284515");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284515");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_application_updated_role_properly_In_teamMember_Page(){
		String testName = "TC003_verify_application_updated_role_properly_In_teamMember_Page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnTeamMember();
			Assert.assertEquals(teamMemberPage.validateAddedRole(role), role);
			reportStep("Role :" + role + " Updated Successfully", "pass");
			updateTestRailResultAsPass("284523");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284523");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnTeamMember();
			teamMemberPage.clickOnResentInvite(role);
			reportStep("ReInvite sent Successfully", "pass");
			updateTestRailResultAsPass("284531");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284531");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_delete_invite_which_is_added()throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_delete_invite_which_is_added";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String role = (String) jsonsuitetestData.get("settingRole");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnTeamMember();
			teamMemberPage.clickOnDeleteTeamMemberAdded(role);
			teamMemberPage.clickOnConfirmDeleteTeamMemberAdded();
			reportStep("Added team member deleted successfully", "pass");
			updateTestRailResultAsPass("284539");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284539");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC006_verify_application_throwing_error_when_FirstName_is_not_enetered() {
		String testName = "TC006_verify_application_throwing_error_when_FirstName_is_not_enetered";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String firstnameerror = (String) jsonsuitetestData.get("firstNameErrorInTeamMember");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnInviteTeamMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(firstnameerror),firstnameerror);
			reportStep("FirstName error text validated successfully", "pass");
			updateTestRailResultAsPass("284547");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284547");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC007_verify_application_throwing_error_when_Email_is_not_enetered(){
		String testName = "TC007_verify_application_throwing_error_when_Email_is_not_enetered";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String emailError = (String) jsonsuitetestData.get("emailError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnInviteTeamMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(emailError),emailError);
			reportStep("Email error text validated successfully", "pass");
			updateTestRailResultAsPass("284555");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284555");
			Assert.fail(e.getMessage());
		}
	}
	

	@Test
	public void TC008_verify_application_throwing_error_when_role_is_not_selected() {
		String testName = "TC008_verify_application_throwing_error_when_role_is_not_selected";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		ManagePage managepage=new ManagePage(driver, test);
		String pleaseselectroleError = (String) jsonsuitetestData.get("pleaseselectroleError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			managepage.clickOnInviteTeamMember();
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateMandatoryFieldsText(pleaseselectroleError),pleaseselectroleError);
			reportStep("Email error text validated successfully", "pass");
			updateTestRailResultAsPass("284563");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284563");
			Assert.fail(e.getMessage());
		}
	}
}
