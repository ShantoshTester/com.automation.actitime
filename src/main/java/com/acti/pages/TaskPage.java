package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.driver.DriverManager;

public class TaskPage extends DriverManager {
	
// ****************************************** Page Elements ***********************************************//
	
	@FindBy(xpath="//div[@class='title ellipsis']") WebElement addNewButton;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement addNewCustomerButton;
	@FindBy(xpath ="(//input[@placeholder='Enter Customer Name'])[2]") WebElement customerNameTb;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement customerDescriptionTextArea;
	@FindBy(xpath="//div[contains(text(),'Create Customer')]") WebElement createCustomerButton;
	@FindBy(xpath = "//span[@class='innerHtml']") WebElement successMsgText;
	
// ****************************************** Page Initialization ******************************************//
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
// ****************************************** Page Actions/Functions ***************************************//
	
	public String getSuccessmessage() {
		return successMsgText.getText();
	}
	
	public void clickAddNew() {
		addNewButton.click();
	}
	
	public void clickAddNewCustomer() {
		addNewCustomerButton.click();
	}
	
	public void enterCustomerName(String custName) {
		customerNameTb.sendKeys(custName);
	}
	
	public void enterCustomerDescription(String custDesc) {
		customerDescriptionTextArea.sendKeys(custDesc);
	}
	
	public void clickCreateCustomer() {
		createCustomerButton.click();
	}
	

}
