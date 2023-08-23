package com.auz.selenium.ui.jobmangedbyme.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.AddCandidatePage;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobsManagedByMe;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class AddCandidateInsideJobManagedByMePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Adding Candidate Inside the jobManagedBy";
		testSuiteDescription = "Adding candidate for that jobManagedBy";
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

	public void addCandidate(String candidateName,String source) {
		try {
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		addcandidatepage.enterCandidateName(candidateName);
		addcandidatepage.clickAddJobToCandidate();
		addcandidatepage.selectCandidateSource(source);
		addcandidatepage.clickAddCandidateButton();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void TC001_verify_user_is_able_to_add_candidate_inside_the_jobmanagedBymePage(){
		String testName = "TC001_verify_user_is_able_to_add_candidate_inside_the_jobmanagedBymePage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanageByMepage = new JobsManagedByMe(driver, test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String candidateName = RandomGenerator.randomName();

		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanageByMepage.clickAddNewJobInJobManagedByme();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String)jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			jobmanageByMepage.clickOnFirstJob();
			jobmanageByMepage.clickOnAddCandidateInsideJob();
			addCandidate(candidateName,(String) jsonsuitetestData.get("candidateSource"));
			Assert.assertEquals(jobmanageByMepage.getFirstCandidateNameInsideJob(), candidateName);
			reportStep("Candidate :" + candidateName + "added Successfully", "pass");
			updateTestRailResultAsPass("284707");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284707");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	@Test
	public void TC002_verify_user_is_able_to_move_the_candidate_to_different_stages_in_pipeline_view_in_jobmanagedbyMePage(){
		String testName = "TC002_verify_user_is_able_to_move_the_candidate_to_different_stages_in_pipeline_view_in_jobmanagedbyMePage";

		// setting Report data
		reportUpdate(testName);
		AddCandidatePage addcandidatepage = new AddCandidatePage(driver, test);
		HomePage homePage = new HomePage(driver, test);
		JobsManagedByMe jobmanageByMepage = new JobsManagedByMe(driver, test);
		String currentstage="Apply";
		
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickJobsManagedByMeMenu();
			jobmanageByMepage.clickOnFirstJob();
			jobmanageByMepage.clickOnPipeLine();
			jobmanageByMepage.movecandidateTodifferentStages(); 
			jobmanageByMepage.clickOnListView();
			jobmanageByMepage.clickOnFirstcandidatInsideTheJob();
			Assert.assertTrue(addcandidatepage.validateCurrentStages(currentstage).contains(currentstage));
			reportStep("Candidate is moved from source to Apply stage Successfully", "pass");
			updateTestRailResultAsPass("284843");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			updateTestRailResultAsFail("284843");
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}

}
