package com.qa.covisint.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.qa.covisint.pages.AccountPage;
import com.qa.covisint.pages.LoginPage;
import com.qa.covisint.pages.ProductInfoPage;

public class BaseTest {
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public ProductInfoPage productInfoPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		String url = prop.getProperty("url");
		driver.get(url);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
