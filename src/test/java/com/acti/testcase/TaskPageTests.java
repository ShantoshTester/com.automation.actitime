package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest {
	
	@Test(priority = 1, dataProvider = "actidata")
	public void testCreateNewCustomer(String username, String password) {
		
		logger = report.createTest("Test Create New Customer");
		lp.enterUsername(username);
		logger.pass("entered username "+username);
		lp.enterPassword(password);
		logger.pass("entered password "+password);
		lp.clickLogin();
		logger.pass("clicked login button");
		ep.clickTaskMenu();
		logger.pass("clicked Task menu");
		tp.clickAddNew();
		logger.pass("clicked Add new button");
		tp.clickAddNewCustomer();
		logger.pass("clicked Add new customer");
		tp.enterCustomerName("Test Customer");
		logger.pass("entered customer name");
		tp.enterCustomerDescription("Dummy Customer Description");
		logger.pass("entered customer description");
		tp.clickCreateCustomer();
		logger.pass("clicked on create customer");
		String actual = tp.getSuccessmessage();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("has been created"));
		ep.clickLogout();
		logger.pass("clicked logout");

	}

}
