/**
 * Author: Tutupolij Johan Ferdian
 */
package com.hrmodule.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrmodule.base.BaseClass;
import com.hrmodule.actiondriver.*;

/**
 * 
 */
public class LoginPage extends BaseClass {
	
	@FindBy(name = "username")
	WebElement loginInputUserName;
	
	@FindBy(name = "password")
	WebElement loginInputPassword;
	
	@FindBy(xpath = "//button[contains(@class,'orangehrm-login-button')]")
	WebElement loginBtnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String userName, String password) {
		Action.type(loginInputUserName, userName);
		Action.type(loginInputPassword, password);
		Action.click(driver, loginBtnLogin);
		return new HomePage();
	}
	
}
