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
public class HomePage extends BaseClass {
	
	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/*[text()='Dashboard']")
	WebElement homePageTextDashboard;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDashboard() {
		return Action.isDisplayed(driver, homePageTextDashboard);
	}
	
	public String getHomePageURL() {
		String homePageURL = driver.getCurrentUrl();
		return homePageURL;
	}
}
