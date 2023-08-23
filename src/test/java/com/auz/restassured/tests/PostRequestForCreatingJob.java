package com.auz.restassured.tests;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.auz.SupportedUtils.Constants;
import com.auz.SupportedUtils.JsonComponent;
import com.auz.restassuredbase.coreutils.RestAssuredBase;
import io.restassured.response.Response;

public class PostRequestForCreatingJob extends RestAssuredBase {
	public static HashMap<String, String> headers;
	public static String payLoadBody;
	
	@BeforeTest
	public void setValues() {
		try {
			testSuiteName = "Post Request for Creating Job ";
			testSuiteDescription = "Validating the Create Job Request";
		} catch (Exception e) {
			e.printStackTrace();
			reportRequest("Exception occured in @BeforeTest Method while reading the TestDescription", "FAIL");
		}
	}

	@Test()
	public void TC001_Create_a_order_with_valid_Input() {
		try {
			String testName="TC001_Create_a_order_with_valid_Input";
			reportUpdate(testName);

			String filePath=System.getProperty("user.dir") + Constants.JSONOBJECT_JOB_DIR +"postJob.json";
			payLoadBody = JsonComponent.readTextFile(filePath);
			headers =generateHeader();
			
			Response response = postWithHeaderAndForm(headers, payLoadBody, Constants.CREATE_JOB_POST_URL);
			logResponseInReport(response);
			System.out.println("Status code: " + response.statusCode());
			verifyResponseCode(response,  "201");
			verifyContentType(response, Constants.JSON_CONTENTTYPE);
			verifyResponseTime(response, 1000);
			//Assert.assertEquals(response.statusCode(),"201");
		} catch (Exception e) {
			reportRequest("Exception occured while executing the method" + e.getMessage(), "FAIL");
		}
	}
	@Test()
	public void TC002_Create_a_order_with_valid_Input() {
		try {
			String testName="TC002_Create_a_order_with_valid_Input";
			reportUpdate(testName);

			String filePath=System.getProperty("user.dir") + Constants.JSONOBJECT_JOB_DIR +"postJob.json";
			payLoadBody = JsonComponent.readTextFile(filePath);
			headers =generateHeader();
			
			Response response = postWithHeaderAndForm(headers, payLoadBody, Constants.CREATE_JOB_POST_URL);
			logResponseInReport(response);
			System.out.println("Status code: " + response.statusCode());
			verifyResponseCode(response,  "201");
			verifyContentType(response, Constants.JSON_CONTENTTYPE);
			verifyResponseTime(response, 1000);
		} catch (Exception e) {
			reportRequest("Exception occured while executing the method" + e.getMessage(), "FAIL");
		}
	}
}
