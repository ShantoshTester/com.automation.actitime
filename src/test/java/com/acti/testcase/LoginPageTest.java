package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.acti.pages.EnterPage;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1,enabled = false)
	public void testLoginPageTitle() 
	{
		logger = report.createTest("Test Login Page Title");
		String actual = "actiTIME - Login";
		String expected = lp.getLoginPageTitle();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		logger.pass("actual title matched the exepected");
	}
	
	@Test(priority = 2,enabled = false)
	public void testActiLogoDisplayed() 
	{
		logger = report.createTest("Test actiLogo is displayed");
		boolean flag = lp.actiImgisDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);	
		logger.pass("actilogo is displayed");
	}
	
	@Test(priority = 3,enabled = false)
	public void testActiLinkDisplayed() 
	{
		logger = report.createTest("Test actiTime link is displayed");
		boolean flag = lp.actiTimeLinkisDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
		logger.pass("actitime link is displayed");
	}
	
	@Test(priority = 4,enabled = false)
	public void testLoginFunction() 
	{
		logger = report.createTest("Test Login Function");
		lp.enterUsername("admin");
		logger.pass("entered the username");
		lp.enterPassword("manager");
		logger.pass("entered the password");
		lp.clickLogin();
		logger.pass("clicked login button");
		String user = ep.getUserLoggedIn();
		System.out.println(user);
		Assert.assertTrue(user.contains("John"));
		logger.pass("user logged in contains the name john");
		ep.clickLogout();
		logger.pass("logged out from the applicaiton");
	}
	
	@Test(priority = 5,enabled = true, dataProvider = "actidata")
	
	public void testLoginInvalid(String username, String password) 
	{
		logger = report.createTest("Test Login Function");
		lp.enterUsername(username);
		logger.pass("entered the username");
		lp.enterPassword(password);
		logger.pass("entered the password");
		lp.clickLogin();
		logger.pass("clicked login button");
		String user = ep.getUserLoggedIn();
		System.out.println(user);
		Assert.assertTrue(user.contains("John"));
		logger.pass("user logged in contains the name john");
		ep.clickLogout();
		logger.pass("logged out from the applicaiton");
	}

}










