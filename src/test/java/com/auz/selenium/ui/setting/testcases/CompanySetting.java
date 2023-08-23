package com.auz.selenium.ui.setting.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.CompanySettingPage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.LoginPage;
import com.aventstack.extentreports.Status;

public class CompanySetting extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "CompanySetting-BASICS";
		testSuiteDescription = "Testing the functionality of SettingFeatures";
		nodes = "CompanySetting";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}

	@Test
	public void TC001_verify_user_is_able_to_update_companyWebsite_successfully_in_companysetting_page()
			throws InterruptedException {
		String testName = "TC001_verify_user_is_able_to_update_companyWebsite_successfully_in_companysetting_page";
		reportUpdate(testName);
		
		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String companywebsite = (String) jsonsuitetestData.get("companywebsite");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.enterCompanyWeSite(companywebsite);
			companysettingpage.clickOnBasicUpdateButton();
			reportStep("CompanyWebsite :" + companywebsite + " updated Successfully", "pass");
			updateTestRailResultAsPass("261439");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261439");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC002_verify_user_is_able_to_add_departmentName_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC002_verify_user_is_able_to_add_departmentName_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String departmentname = (String) jsonsuitetestData.get("settingAddDepartmentName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnDepartment();
			companysettingpage.clickOnAddDepartment();
			companysettingpage.enterDepartmentName(departmentname);
			companysettingpage.clickOnAddButton();
			Assert.assertEquals(companysettingpage.validateDepartmentAdded(departmentname),departmentname);
			reportStep("DepartmentName :" + departmentname + " Added Successfully", "pass");
			updateTestRailResultAsPass("261456");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261456");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(enabled=false)
	public void TC003_verify_user_is_able_to_edit_departmentName_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC003_verify_user_is_able_to_edit_departmentName_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String addDepartmentname = (String) jsonsuitetestData.get("settingAddDepartmentName");
		String editDepartmentname = (String) jsonsuitetestData.get("settingEditDepartmentName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnDepartment();
			companysettingpage.clickOnEditButton(addDepartmentname);
			companysettingpage.clickUpdateDepartmentButton();
			Assert.assertEquals(companysettingpage.validateDepartmentAdded(editDepartmentname),editDepartmentname);
			reportStep("DepartmentName :" + editDepartmentname + " edited Successfully", "pass");
			updateTestRailResultAsPass("261463");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261463");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(enabled=true)
	public void TC004_verify_user_is_able_to_delete_the_departmentName_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC004_verify_user_is_able_to_delete_the_departmentName_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String adddepartmentname = (String) jsonsuitetestData.get("settingAddDepartmentName");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnDepartment();
			companysettingpage.clickOnDeleteButton(adddepartmentname);
			companysettingpage.clickOnConfirmDeleteButton(adddepartmentname);
			reportStep("DepartmentName :" + adddepartmentname + " deleted Successfully", "pass");
			updateTestRailResultAsPass("261470");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261470");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC005_verify_user_is_able_to_add_Location_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC005_verify_user_is_able_to_add_Location_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String location=(String) jsonsuitetestData.get("addedLocation");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnAddLocation();
			companysettingpage.selectCountry((String)jsonsuitetestData.get("SettingCountryName"));
			companysettingpage.selectState((String)jsonsuitetestData.get("SettingStateName"));
			companysettingpage.selectCity((String)jsonsuitetestData.get("SettingCityName"));
			companysettingpage.enterZipcode(RandomGenerator.random(6, PermittedCharacters.NUMERIC));
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertTrue(companysettingpage.validateAddedLocation().contains(location));
			reportStep("Location :" + location + " Added Successfully", "pass");
			updateTestRailResultAsPass("261692");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261692");
			Assert.fail(e.getMessage());
		}
	}

	@Test()
	public void TC006_verify_user_is_able_to_edit_the_addedLocation_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC006_verify_user_is_able_to_edit_the_addedLocation_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationname=(String) jsonsuitetestData.get("addedLocation");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnEditLocationButton(locationname);
			companysettingpage.enterZipcode(RandomGenerator.random(6, PermittedCharacters.NUMERIC));
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertTrue(companysettingpage.validateAddedLocation().contains(locationname));
			reportStep("Location :" + locationname + " edited Successfully", "pass");
			updateTestRailResultAsPass("261888");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261888");
			Assert.fail(e.getMessage());
		}
	}
	@Test()
	public void TC007_verify_user_is_able_to_delete_the_addedLocation_successfully_in_companysetting_page()throws InterruptedException {
		String testName = "TC007_verify_user_is_able_to_delete_the_addedLocation_successfully_in_companysetting_page";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationname=(String) jsonsuitetestData.get("addedLocation");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnDeleteLocationButton(locationname);
			companysettingpage.clickOnLocationConfirmDeleteButton(locationname);
			reportStep("Location :" + locationname + " deleted Successfully", "pass");
			updateTestRailResultAsPass("261902");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261902");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC008_verify_application_throwing_error_when_country_is_not_selected_while_trying_to_add_location()throws InterruptedException {
		String testName = "TC008_verify_application_throwing_error_when_country_is_not_selected_while_trying_to_add_location";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationCountryErrorText=(String) jsonsuitetestData.get("locationCountryError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnAddLocation();
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertEquals(companysettingpage.validateCountryErrorText(),locationCountryErrorText);
			reportStep("Country Error Text :" + locationCountryErrorText + " Validated Successfully", "pass");
			updateTestRailResultAsPass("261930");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261930");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC009_verify_application_throwing_error_when_state_is_not_selected_while_trying_to_add_location()throws InterruptedException {
		String testName = "TC009_verify_application_throwing_error_when_state_is_not_selected_while_trying_to_add_location";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationStateErrorText=(String) jsonsuitetestData.get("locationStateError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnAddLocation();
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertEquals(companysettingpage.validateStateErrorText(),locationStateErrorText);
			reportStep("State Error Text :" + locationStateErrorText + " Validated Successfully", "pass");
			updateTestRailResultAsPass("261937");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261937");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC010_verify_application_throwing_error_when_city_is_not_selected_while_trying_to_add_location()throws InterruptedException {
		String testName = "TC010_verify_application_throwing_error_when_city_is_not_selected_while_trying_to_add_location";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationCityErrorText=(String) jsonsuitetestData.get("locationCityError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnAddLocation();
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertEquals(companysettingpage.validateCityErrorText(),locationCityErrorText);
			reportStep("City Error Text :" + locationCityErrorText + " Validated Successfully", "pass");
			updateTestRailResultAsPass("261944");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261944");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC011_verify_application_throwing_error_when_zipcode_is_not_entered_while_trying_to_add_location()throws InterruptedException {
		String testName = "TC011_verify_application_throwing_error_when_zipcode_is_not_entered_while_trying_to_add_location";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String locationZipCodeErrorText=(String) jsonsuitetestData.get("locationZipCodeError");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnLocationMenu();
			companysettingpage.clickOnAddLocation();
			companysettingpage.clickOnAddLocationAfterFeedingCountry();
			Assert.assertEquals(companysettingpage.validateZipcodeErrorText(),locationZipCodeErrorText);
			reportStep("ZipCode Error Text :" + locationZipCodeErrorText + " Validated Successfully", "pass");
			updateTestRailResultAsPass("261951");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("261951");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC012_verify_user_is_able_to_add_tagName_under_company_settingPage()throws InterruptedException {
		String testName = "TC012_verify_user_is_able_to_add_tagName_under_compnay_settingPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String tagName=(String) jsonsuitetestData.get("tagsName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnTagsMenu();
			companysettingpage.clickOnAddTags();
			companysettingpage.enterTagsName(tagName);
			companysettingpage.clickAddAfterTagsValueEntered();
			Assert.assertEquals(companysettingpage.validateAddedTag(),tagName);
			reportStep("Tag Name :" + tagName + " Validated Successfully", "pass");
			updateTestRailResultAsPass("262056");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262056");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test()
	public void TC013_verify_user_is_able_to_delete_the_added_tagName_under_company_settingPage()throws InterruptedException {
		String testName = "TC013_verify_user_is_able_to_delete_the_added_tagName_under_company_settingPage";
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		CompanySettingPage companysettingpage = new CompanySettingPage(driver, test);
		String tagName=(String) jsonsuitetestData.get("tagsName");
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickSettingMenu();
			companysettingpage.clickOnTagsMenu();
			companysettingpage.clickOnDeleteTagsButton(tagName);
			companysettingpage.clickOnTagConfirmDeleteButton(tagName);
			reportStep("Tag Name :" + tagName + " deleted Successfully", "pass");
			updateTestRailResultAsPass("262070");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("262070");
			Assert.fail(e.getMessage());
		}
	}
}
