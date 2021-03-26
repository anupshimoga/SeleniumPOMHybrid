package com.qa.covisint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.covisint.base.BasePage;
import com.qa.covisint.utils.Constants;
import com.qa.covisint.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	// 1. By locators : OR
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@value='Login' and @type='submit']");

	private By registrationLink = By.linkText("Forgotten Password");

	// 2. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. Login Page Actions (Behaviour or the feature of the page)
	@Step("Getting the login page")
	public String getPageTitle() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}
	
	@Step("Checking the forgot password link")
	public Boolean forgtnPwdLinkIsDisplayed() {
		return elementUtil.getElement(registrationLink).isDisplayed();
	}
	
	@Step("Logging in with : {0} and {1}")
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("Logging in with Username: " + un + " Password: " + pwd);
		elementUtil.doActionsSendKeys(emailId, un);
		elementUtil.doActionsSendKeys(password, pwd);
		elementUtil.doActionsClick(login);

		return new AccountPage(driver);
	}
}
