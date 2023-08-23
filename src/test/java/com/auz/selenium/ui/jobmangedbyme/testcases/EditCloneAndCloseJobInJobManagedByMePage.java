package com.auz.selenium.ui.jobmangedbyme.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobsManagedByMe;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class EditCloneAndCloseJobInJobManagedByMePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Edit,Close,Clone-JobManagedByMePage";
		testSuiteDescription = "Edit,Close,Clone-JobManagedByMePage";
		nodes = "Jobs";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
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

	public void enterJobApplicationdetails(String jobDecribe, String workExpe, String education, String minSalary,
			String maxSalary) {
		PostJobPage postJobPage = new PostJobPage(driver, test);
		postJobPage.enterJobDescription(jobDecribe);
		postJobPage.enterJobWorkExperience(workExpe);
		postJobPage.selectJobEducation(education);
		postJobPage.enterJobAnnualMinSalary(minSalary);
		postJobPage.enterJobAnnualMaxSalary(maxSalary);
		postJobPage.clickContinueOnJobDescription();
		postJobPage.clickonContinueInPublishJob();
		postJobPage.clickContinueOnAdvertiseJob();
		postJobPage.clickContinueOnApplication();
		postJobPage.clickContinueOnInterviewProcess();
	}

	@Test
	public void TC001_verify_user_is_able_to_publish_the_job_and_edit_and_save_the_changes_in_job_managedbyme_page(){
		String testName = "TC001_verify_user_is_able_to_publish_the_job_and_edit_and_save_the_changes_in_job_managedbyme_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobsManagedByMe jobmanagedpage = new JobsManagedByMe(driver, test);

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedpage.clickAddNewJobInJobManagedByme();
			enterBasicJobDetails(RandomGenerator.randomJobTiTle(), (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			jobmanagedpage.clickOnEditJob();
			String jobtitle = RandomGenerator.randomJobTiTle();
			postJobPage.enterJobTitle(jobtitle);
			postJobPage.clickOnSaveandExit();
			Assert.assertEquals(jobmanagedpage.validateFirstJobNameAddedInJobManagedByMePage(), jobtitle);
			reportStep("JobTitle :" + jobtitle + "validated Successfully", "pass");
			updateTestRailResultAsPass("284483");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284483");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC002_verify_user_is_able_to_clone_the_job_in_job_managedbyme_page() {
		String testName = "TC002_verify_user_is_able_to_clone_the_job_in_job_managedbyme_page";
		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobsManagedByMe jobmanagedpage = new JobsManagedByMe(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedpage.clickOnClone();
			postJobPage.enterJobTitle(jobtitle);
			postJobPage.clickOnSaveandExit();
			Assert.assertTrue(jobmanagedpage.validateFirstJobNameAddedInJobManagedByMePage().contains(jobtitle));
			reportStep("JobTitle :" + jobtitle + "is cloned Successfully", "pass");
			updateTestRailResultAsPass("284491");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284491");
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void TC003_verify_user_is_able_to_close_the_job_in_job_managedbyme_page(){
		String testName = "TC003_verify_user_is_able_to_close_the_job_in_job_managedbyme_page";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanagedpage = new JobsManagedByMe(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanagedpage.clickOnClose();
			reportStep("JobTitle :" + jobtitle + "is closed Successfully", "pass");
			updateTestRailResultAsPass("284499");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("284499");
			Assert.fail(e.getMessage());
		}
	}
}
