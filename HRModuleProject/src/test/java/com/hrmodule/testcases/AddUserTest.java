/**
 * Author: Tutupolij Johan Ferdian
 */
package com.hrmodule.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrmodule.base.BaseClass;
import com.hrmodule.pageobjects.AddUserPage;
import com.hrmodule.pageobjects.AdminPage;
import com.hrmodule.pageobjects.HomePage;
import com.hrmodule.pageobjects.LoginPage;
import com.hrmodule.pageobjects.UserManagement;

/**
 * 
 */
public class AddUserTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	UserManagement userManagement;
	AddUserPage addUserPage;
	
	@BeforeMethod
	public void Setup() {
		launchApp();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void AddUser() throws InterruptedException {
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyDashboard());
		
		adminPage = new AdminPage();
		userManagement = adminPage.clickOnUserManagement();
		Assert.assertTrue(userManagement.validatePageTitleUserManagement());
		
		userManagement = new UserManagement();
		addUserPage = userManagement.clickOnAddUser();
		Assert.assertTrue(addUserPage.validateAddUserPage());
		
		userManagement = addUserPage.addUser();
		Assert.assertTrue(userManagement.validatePageTitleUserManagement());
		
		
		//assertTrue(userManagement.validatePageTitleUserManagement());
	}
}
