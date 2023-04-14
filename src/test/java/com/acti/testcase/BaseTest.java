package com.acti.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.acti.driver.DriverManager;
import com.acti.pages.LoginPage;
import com.acti.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverManager {
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	static ExtentTest logger;
	LoginPage lp;
	
	@BeforeSuite
	public void setUpReport() {
		extent = new ExtentHtmlReporter("./reports/actiindex.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void preTest() {
		initApplication();
		lp = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		quitBrowser();
	}

}








