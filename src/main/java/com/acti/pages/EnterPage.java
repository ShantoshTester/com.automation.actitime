package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.driver.DriverManager;

public class EnterPage extends DriverManager {
	
// ****************************************** Page Elements ***********************************************//
	
	@FindBy(id = "logoutLink") WebElement logoutLink;
	@FindBy(xpath = "//a[@class='userProfileLink username ']") WebElement userprofileText;
	
// ****************************************** Page Initialization ******************************************//
	
	public EnterPage() {
		PageFactory.initElements(driver, this);
	}
	
// ****************************************** Page Actions/Functions ***************************************//
	
	public String getUserLoggedIn() {
		return userprofileText.getText();
	}
	
	public String getEnterPageTitle() {
		return driver.getTitle();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}

}
