/**
 * Author: Tutupolij Johan Ferdian
 */
package com.hrmodule.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmodule.actiondriver.Action;
import com.hrmodule.base.BaseClass;

/**
 * 
 */
public class UserManagement extends BaseClass {
	@FindBy(xpath="//*[text()='System Users']")
	WebElement userManagementPageTitle;
	
	@FindBy(xpath="//*[@class='oxd-label' and text()='Username']/parent::div[1]/following-sibling::div[1]/input")
	WebElement searchInputUserName;
	
	@FindBy(xpath="//button[@type='submit' and text()=' Search ']")
	WebElement btnSearch;
	
	@FindBy(xpath="//button[@type='button' and text()=' Add ']")
	WebElement btnAdd;
	
	public UserManagement() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePageTitleUserManagement() {
		return Action.isDisplayed(driver, userManagementPageTitle);
	}
	
	public SearchUser searchUser() {
		Action.type(searchInputUserName, "Test Joe");
		Action.click(driver, btnSearch);
		return new SearchUser();
	}
	
	public AddUserPage clickOnAddUser() {
		Action.click(driver, btnAdd);
		
		return new AddUserPage();
	}

}
