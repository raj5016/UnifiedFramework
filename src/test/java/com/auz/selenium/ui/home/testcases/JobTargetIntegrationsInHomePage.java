package com.auz.selenium.ui.home.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.SupportedUtils.PermittedCharacters;
import com.auz.SupportedUtils.ProjectSpecificMethods;
import com.auz.SupportedUtils.RandomGenerator;
import com.auz.selenium.pages.HomePage;
import com.auz.selenium.pages.JobTargetIntegrationsPage;
import com.auz.selenium.pages.LoginPage;
import com.auz.selenium.pages.PostJobPage;
import com.aventstack.extentreports.Status;

public class JobTargetIntegrationsInHomePage extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "Job Target Integrations in My job Page";
		testSuiteDescription = "Testing the functionality of Job Module";
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
	}

	@Test
	public void TC001_verify_user_is_able_to_publish_the_job_in_homepage_by_adding_sitename_as_careerbuilder_in_jobtargetpage(){
		String testName = "TC001_verify_user_is_able_to_publish_the_job_in_homepage_by_adding_sitename_as_careerbuilder_in_jobtargetpage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobTargetIntegrationsPage jobTargetIntegrationsPage=new JobTargetIntegrationsPage(driver,test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String siteName =(String) jsonsuitetestData.get("careerBuilderSiteName");
		String country=(String) jsonsuitetestData.get("jobTargetcountry");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			postJobPage.clickOnAdvertiseJob();
			postJobPage.switchtoJobTargetIntegrationPage();
			jobTargetIntegrationsPage.switchtoFrameInJobTargetIntegrationPage();
			jobTargetIntegrationsPage.scrollBottom(driver);
			jobTargetIntegrationsPage.clickOnAddCartOnSite(siteName);
			jobTargetIntegrationsPage.clickOnCartContainer();
			jobTargetIntegrationsPage.clickOnNextStepInCartContainer();
			jobTargetIntegrationsPage.selectMultiIndustries();
			jobTargetIntegrationsPage.selectMultiCategories();
			jobTargetIntegrationsPage.selectCountry(country);
			jobTargetIntegrationsPage.selectApplicationMethod((String) jsonsuitetestData.get("ApplyOnlineApplicationMethod"));
			jobTargetIntegrationsPage.clickOnNextStepReviewOrder();
			jobTargetIntegrationsPage.switchtoWindow(2);
			jobTargetIntegrationsPage.selectState((String) jsonsuitetestData.get("JobTargetState"));
			jobTargetIntegrationsPage.clickOnNextStepReviewOrder();
			jobTargetIntegrationsPage.switchtoWindow(3);
			jobTargetIntegrationsPage.enterBillingname(RandomGenerator.randomName());
			jobTargetIntegrationsPage.enterCCNumber((String) jsonsuitetestData.get("creditcardNumber"));
			jobTargetIntegrationsPage.selectExpiryMonth(11);
			jobTargetIntegrationsPage.selectExpiryYear(6);
			jobTargetIntegrationsPage.enterCVV((String) jsonsuitetestData.get("creditcardNumberCVV"));
			jobTargetIntegrationsPage.selectBillingCountry(country);
			jobTargetIntegrationsPage.enterBillingAddress(RandomGenerator.randomAddress());
			jobTargetIntegrationsPage.enterBillingCity(RandomGenerator.randomAlphabetic(6));
			jobTargetIntegrationsPage.enterBillingState((String) jsonsuitetestData.get("JobTargetState"));
			jobTargetIntegrationsPage.enterBillingZipCode(RandomGenerator.random(6, PermittedCharacters.NUMERIC));
			jobTargetIntegrationsPage.clickonconfirmPayment();
			jobTargetIntegrationsPage.switchtoWindowAndCloseBrowser(2);
			jobTargetIntegrationsPage.switchtoWindowAndCloseBrowser(1);
			switchToWindow(0);
			postJobPage.clickOnRefreshAdvertiseJob();
			String jobtargettext=postJobPage.getJobTargetText(siteName);
			System.out.println(jobtargettext);
			postJobPage.clickOnContinueInAdvertiseJobAfterJobTargetadded();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobtargettext, siteName);
			reportStep("Job published by adding "+ siteName +" as jobtarget Successfully", "pass");
			updateTestRailResultAsPass("304597");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("304597");
			Assert.fail(e.getMessage());
		}
	}
	@Test
	public void TC002_verify_user_is_able_to_publish_the_job_in_Homepage_by_adding_sitename_as_LinkedIn_in_jobtargetpage(){
		String testName = "TC002_verify_user_is_able_to_publish_the_job_in_Homepage_by_adding_sitename_as_LinkedIn_in_jobtargetpage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobTargetIntegrationsPage jobTargetIntegrationsPage=new JobTargetIntegrationsPage(driver,test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String siteName =(String) jsonsuitetestData.get("LinkedInSiteName");
		String linkedInAppUrl =(String) jsonsuitetestData.get("LinkedInAppUrl");

		String country=(String) jsonsuitetestData.get("jobTargetcountry");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			postJobPage.clickOnAdvertiseJob();
			postJobPage.switchtoJobTargetIntegrationPage();
			jobTargetIntegrationsPage.switchtoFrameInJobTargetIntegrationPage();
			jobTargetIntegrationsPage.scrollBottom(driver);
			jobTargetIntegrationsPage.clickOnAddCartOnSite(siteName);
			jobTargetIntegrationsPage.clickOnCartContainer();
			jobTargetIntegrationsPage.clickOnNextStepInCartContainer();
			jobTargetIntegrationsPage.selectCountry(country);
			jobTargetIntegrationsPage.clickOnNextStepReviewOrder();
			jobTargetIntegrationsPage.enterAppUrl(linkedInAppUrl);
			jobTargetIntegrationsPage.clickOnNextStepReviewOrder();
			jobTargetIntegrationsPage.enterBillingname(RandomGenerator.randomName());
			jobTargetIntegrationsPage.enterCCNumber((String) jsonsuitetestData.get("creditcardNumber"));
			jobTargetIntegrationsPage.selectExpiryMonth(11);
			jobTargetIntegrationsPage.selectExpiryYear(6);
			jobTargetIntegrationsPage.enterCVV((String) jsonsuitetestData.get("creditcardNumberCVV"));
			jobTargetIntegrationsPage.selectBillingCountry(country);
			jobTargetIntegrationsPage.enterBillingAddress(RandomGenerator.randomAddress());
			jobTargetIntegrationsPage.enterBillingCity(RandomGenerator.randomAlphabetic(6));
			jobTargetIntegrationsPage.enterBillingState((String) jsonsuitetestData.get("JobTargetState"));
			jobTargetIntegrationsPage.enterBillingZipCode(RandomGenerator.random(6, PermittedCharacters.NUMERIC));
			jobTargetIntegrationsPage.clickonconfirmPaymentOnLinkedIn();
			jobTargetIntegrationsPage.switchtoWindowAndCloseBrowser(1);
			switchToWindow(0);
			postJobPage.clickOnRefreshAdvertiseJob();
			String jobtargettext=postJobPage.getJobTargetText(siteName);
			postJobPage.clickOnContinueInAdvertiseJobAfterJobTargetadded();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobtargettext, siteName);
			reportStep("Job published by adding "+ siteName +" as jobtarget Successfully", "pass");
			updateTestRailResultAsPass("304606");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("304606");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_publish_the_job_in_myjobpage_by_adding_sitename_as_monstor_in_jobtargetpage(){
		String testName = "TC003_verify_user_is_able_to_publish_the_job_in_myjobpage_by_adding_sitename_as_monstor_in_jobtargetpage";

		// setting Report data
		reportUpdate(testName);

		HomePage homePage = new HomePage(driver, test);
		PostJobPage postJobPage = new PostJobPage(driver, test);
		JobTargetIntegrationsPage jobTargetIntegrationsPage=new JobTargetIntegrationsPage(driver,test);
		String jobtitle = RandomGenerator.randomJobTiTle();
		String siteName =(String) jsonsuitetestData.get("monstorSiteName");
		String jobTargetJobStatus =(String) jsonsuitetestData.get("jobTargetJobStatus");
		String country=(String) jsonsuitetestData.get("jobTargetcountry");
		try {
			login();
			homePage.verifyHomePageTitle((String) jsonsuitetestData.get("homepagetitle"));
			homePage.clickAddJob();
			enterBasicJobDetails(jobtitle, (String) jsonsuitetestData.get("department2"),
					(String) jsonsuitetestData.get("JobLocation1"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC));
			enterJobApplicationdetails((String) jsonsuitetestData.get("jobdescription"),
					RandomGenerator.random(1, PermittedCharacters.NUMERIC), (String) jsonsuitetestData.get("education"),
					RandomGenerator.randomMinSalary(), RandomGenerator.randomMaxSalary());
			postJobPage.clickOnAdvertiseJob();
			postJobPage.switchtoJobTargetIntegrationPage();
			jobTargetIntegrationsPage.switchtoFrameInJobTargetIntegrationPage();
			jobTargetIntegrationsPage.scrollBottom(driver);
			jobTargetIntegrationsPage.clickOnAddCartOnSite(siteName);
			jobTargetIntegrationsPage.clickOnCartContainer();
			jobTargetIntegrationsPage.clickOnNextStepInCartContainer();
			jobTargetIntegrationsPage.selectMultiOccupations();
			jobTargetIntegrationsPage.selectJobStatus(jobTargetJobStatus);
			jobTargetIntegrationsPage.selectCountry(country);
			jobTargetIntegrationsPage.clickOnNextStepReviewOrder();
			jobTargetIntegrationsPage.switchtoWindow(2);
			jobTargetIntegrationsPage.enterBillingname(RandomGenerator.randomName());
			jobTargetIntegrationsPage.enterCCNumber((String) jsonsuitetestData.get("creditcardNumber"));
			jobTargetIntegrationsPage.selectExpiryMonth(11);
			jobTargetIntegrationsPage.selectExpiryYear(6);
			jobTargetIntegrationsPage.enterCVV((String) jsonsuitetestData.get("creditcardNumberCVV"));
			jobTargetIntegrationsPage.selectBillingCountry(country);
			jobTargetIntegrationsPage.enterBillingAddress(RandomGenerator.randomAddress());
			jobTargetIntegrationsPage.enterBillingCity(RandomGenerator.randomAlphabetic(6));
			jobTargetIntegrationsPage.enterBillingState((String) jsonsuitetestData.get("JobTargetState"));
			jobTargetIntegrationsPage.enterBillingZipCode(RandomGenerator.random(6, PermittedCharacters.NUMERIC));
			jobTargetIntegrationsPage.clickonconfirmPayment();
			jobTargetIntegrationsPage.switchtoWindowAndCloseBrowser(1);
			switchToWindow(0);
			postJobPage.clickOnRefreshAdvertiseJob();
			String jobtargettext=postJobPage.getJobTargetText(siteName);
			postJobPage.clickOnContinueInAdvertiseJobAfterJobTargetadded();
			postJobPage.clickContinueOnApplication();
			postJobPage.clickContinueOnInterviewProcess();
			Assert.assertEquals(jobtargettext, siteName);
			reportStep("Job published by adding "+ siteName +" as jobtarget Successfully", "pass");
			updateTestRailResultAsPass("304615");
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			reportStep("Test Case Not executed Successfully", "fail");
			updateTestRailResultAsFail("304615");
			Assert.fail(e.getMessage());
		}
	}
}
