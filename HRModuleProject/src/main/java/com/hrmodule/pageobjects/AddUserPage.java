/**
 * Author: Tutupolij Johan Ferdian
 */
package com.hrmodule.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmodule.base.BaseClass;
import com.hrmodule.actiondriver.Action;

/**
 * 
 */
public class AddUserPage extends BaseClass {
	@FindBy(xpath="//div[@class='orangehrm-card-container']//*[text() = 'Add User']")
	WebElement addUserPageTitle;
	
	@FindBy(xpath="//label[text()='User Role']/parent::div/following-sibling::div//*[@class='oxd-select-text-input']")
	WebElement dropDownListUserRole;
	
	@FindBy(xpath="//div[@class='oxd-select-option']//span[normalize-space(text()) = 'ESS']")
	WebElement dropDownListUserRoleValue;
	
	@FindBy(xpath="//label[text()='Status']/parent::div/following-sibling::div//*[@class='oxd-select-text-input']")
	WebElement dropDownListStatus;
	
	@FindBy(xpath="//div[@class='oxd-select-option']//span[normalize-space(text()) = 'Enabled']")
	WebElement dropDownListStatusValue;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div//input")
	WebElement inputEmployeeName;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']//span[normalize-space(text()) = 'Joe Root']")
	WebElement selectEmployee;
	
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div//*[contains(@class,'oxd-input')]")
	WebElement inputUsername;
	
	@FindBy(xpath="//label[text()='Password']/parent::div/following-sibling::div//*[contains(@class,'oxd-input')]")
	WebElement inputPassword;
	
	@FindBy(xpath="//label[text()='Confirm Password']/parent::div/following-sibling::div//*[contains(@class,'oxd-input')]")
	WebElement inputConfirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnSave;
	
	public AddUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public UserManagement addUser() throws InterruptedException {
		Action.click(driver, dropDownListUserRole);
		Thread.sleep(3000);
		Action.click(driver, dropDownListUserRoleValue);
		
		Action.click(driver, dropDownListStatus);
		Thread.sleep(3000);
		Action.click(driver, dropDownListStatusValue);
		
		Action.type(inputEmployeeName, "Joe Root");
		Thread.sleep(3000);
		Action.click(driver, selectEmployee);
		
		Action.type(inputUsername, "Test Joe3");
		Action.type(inputPassword, "TestJoe223344");
		Action.type(inputConfirmPassword, "TestJoe223344");
		Action.click(driver, btnSave);
		
		Thread.sleep(5000);
		
		return new UserManagement();
	}
	
	public boolean validateAddUserPage() {
		return Action.isDisplayed(driver, addUserPageTitle);
	}
}
