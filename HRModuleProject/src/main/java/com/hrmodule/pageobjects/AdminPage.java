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
public class AdminPage extends BaseClass {
	@FindBy(xpath="//*[@class='oxd-main-menu']/li/a/*[text() = 'Admin']")
	WebElement menuAdmin;
	
	@FindBy(xpath="//span[contains(text(), 'User Management')]")
	WebElement btnUserManagement;
	
	@FindBy(xpath="//span[contains(text(), 'Job')]")
	WebElement btnJob;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public UserManagement clickOnUserManagement() {
		Action.click(driver, menuAdmin);
		Action.implicitWait(driver, 3);
		Action.click(driver, btnUserManagement);
		
		return new UserManagement();
	}
	
}
