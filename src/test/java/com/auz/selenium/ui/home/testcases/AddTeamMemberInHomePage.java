package com.auz.selenium.ui.home.testcases;

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

public class AddTeamMemberInHomePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Adding team Member in homePage";
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
	public void TC001_verify_user_is_able_to_add_NewteamMember_through_home_page()throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_add_NewteamMember_through_home_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String firstname = (String) jsonsuitetestData.get("firstname");
		String email = (String) jsonsuitetestData.get("email");
		String role = (String) jsonsuitetestData.get("Role");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddUser();
			teamMemberPage.enterFirstName(firstname);
			teamMemberPage.enterEmail(email);
			teamMemberPage.selectRole(role);
			teamMemberPage.clickOnAddPerson();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Team Member added Successfully in homepage", "pass");
			updateTestRailResultAsPass("269965");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269965");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_application_updated_emailid_properly_In_teamMember_Page_which_is_added_through_homepage()
			throws InterruptedException {
		String testName = "TC002_verify_application_updated_emailid_properly_In_teamMember_Page_which_is_added_through_homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String email = (String) jsonsuitetestData.get("email");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			Assert.assertEquals(teamMemberPage.validateAddedEmail(email), email);
			reportStep("Email :" + email + " Updated Successfully in teammembers pages which is added through homepage", "pass");
			updateTestRailResultAsPass("269972");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269972");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_application_updated_role_properly_In_teamMember_Page_which_is_added_through_homepage()throws InterruptedException {
		String testName = "TC003_verify_application_updated_role_properly_In_teamMember_Page_which_is_added_through_homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("Role");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			Assert.assertEquals(teamMemberPage.validateAddedRole(role), role);
			reportStep("Role :" + role + " Updated Successfully in teammembers pages which is added through homepag", "pass");
			updateTestRailResultAsPass("269979");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269979");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member_which_is_added_through_homepage()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_resend_the_invite_for_adding_the_team_member_which_is_added_through_homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("Role");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnResentInvite(role);
			reportStep("ReInvite sent Successfully  n teammembers pages which is added through homepage", "pass");
			updateTestRailResultAsPass("269986");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269986");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_delete_invite_which_is_added_which_is_added_through_homepag()throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_delete_invite_which_is_added_which_is_added_through_homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String role = (String) jsonsuitetestData.get("Role");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			teamMemberPage.clickOnTeamMemberMenu();
			teamMemberPage.clickOnDeleteTeamMemberAdded(role);
			teamMemberPage.clickOnConfirmDeleteTeamMemberAdded();
			reportStep("Added team member deleted successfully in teammembers pages which is added through homepage", "pass");
			updateTestRailResultAsPass("269993");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("269993");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC006_verify_application_throwing_error_when_FirstName_is_not_enetered_under_Homepage() {
		String testName = "TC006_verify_application_throwing_error_when_FirstName_is_not_enetered_under_Homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String firstnameerror = (String) jsonsuitetestData.get("firstNameErrorInTeamMember");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddUser();
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
	public void TC007_verify_application_throwing_error_when_Email_is_not_enetered_under_Homepage(){
		String testName = "TC007_verify_application_throwing_error_when_Email_is_not_enetered_under_Homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String emailError = (String) jsonsuitetestData.get("emailError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddUser();
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
	public void TC008_verify_application_throwing_error_when_role_is_not_selected_under_Homepage() {
		String testName = "TC008_verify_application_throwing_error_when_role_is_not_selected_under_Homepage";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		TeamMemberPage teamMemberPage=new TeamMemberPage(driver, test);
		String pleaseselectroleError = (String) jsonsuitetestData.get("pleaseselectroleError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddUser();
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
