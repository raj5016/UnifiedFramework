package com.auz.SupportedUtils;

import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PreAndTest extends Reporter {

	@BeforeSuite
	public void beforeSuite() throws Exception {
		startReport();
		getcookies();
	}

	@BeforeClass
	public void beforeClass() {
		startTestCase(testSuiteName, testSuiteDescription);
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		endResult();
	}

	@Override
	public long takeSnap() {
		return 0;
	}

	public void reportUpdate(String testname) {
		lib.testName.set(testname);
		svcTest = startTestModule(lib.testName.get());
		svcTest.assignAuthor("Govind");
		svcTest.assignCategory("Smoke");
	}

	public void  getcookies() {
		try {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constants.STAGING_APPURL);
		driver.findElement(By.id("username")).sendKeys(Constants.STAGING_USERNAME);
		driver.findElement(By.id("password")).sendKeys(Constants.STAGING_PWD);
		driver.findElement(By.id("signin-button")).click();
		driver.navigate().to(Constants.STAGING_REDIRECT_APPURL);
		Cookie cookie = driver.manage().getCookieNamed("connect.sid");
		String cookievalue = cookie.getValue();
        FileWriter fw=new FileWriter(Constants.RESOURCE_DIR+"cookie.txt");    
        fw.write(cookievalue);
        fw.close();
		driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
