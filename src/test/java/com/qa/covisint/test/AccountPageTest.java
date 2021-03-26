package com.qa.covisint.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.covisint.base.BaseTest;
import com.qa.covisint.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 200: define account page test features")
@Story("US 201: define the account page class feature with title, header and search functionality")
public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Account page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void accountPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		System.out.println("Account page title : " + title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	}

	@Description("Account page header test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void verifyAccountPageHeaderTest() {
		String headerValue = accountPage.getHeadervalue();
		System.out.println("Account page header is " + headerValue);
		Assert.assertEquals(headerValue, Constants.ACCOUNT_PAGE_HEADER);
	}

	@Description("Account sections test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void verifyMyAccountSectionTest() {
		Assert.assertTrue(accountPage.getAccountSectionsCount() == Constants.ACCOUNT_SECTIONS);
	}
	
	@Description("Account sections list test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void verifyMyAccountSectionsListTest() {
		Assert.assertEquals(accountPage.getAccountSectionsItems(), Constants.getAccountSectionsList());
	}
	
	@Description("Account seacrh test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 5)
	public void searchTest() {
		Assert.assertTrue(accountPage.doSearchItems("iMac"));
	}
}
