package com.qa.covisint.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.covisint.base.BaseTest;
import com.qa.covisint.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: define login page test features")
@Story("US 101: define the login page class feature with title, forgot pwd link and login functionality")
public class LoginPageTest extends BaseTest {

	@Description("Verfying the login page title")
	@Severity(SeverityLevel.NORMAL) 
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getPageTitle();
		System.out.println("Login page title is " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verfying the forgot pwd test")
	@Severity(SeverityLevel.CRITICAL) 
	@Test(priority = 2)
	public void verifyForgtnPwdLinkTest() {
		Assert.assertTrue(loginPage.forgtnPwdLinkIsDisplayed());
	}

	@Description("Verfying the login test")
	@Severity(SeverityLevel.BLOCKER) 
	@Test(priority = 3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
