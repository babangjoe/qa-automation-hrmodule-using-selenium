/**
 * Author: Tutupolij Johan Ferdian
 */
package com.hrmodule.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrmodule.base.BaseClass;
import com.hrmodule.pageobjects.HomePage;
import com.hrmodule.pageobjects.LoginPage;

/**
 * 
 */
public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void Setup() {
		launchApp();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void LoginTest() {
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Assert.assertTrue(homePage.verifyDashboard());
		
		String actualURL = homePage.getHomePageURL();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualURL, expectedURL);
	}
}
