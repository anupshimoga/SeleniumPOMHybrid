package com.qa.covisint.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.covisint.base.BasePage;
import com.qa.covisint.utils.Constants;
import com.qa.covisint.utils.ElementUtil;

public class AccountPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elemUtil;
	private By header = By.cssSelector("div#logo a");
	private By accountHeaders = By.cssSelector("div#content h2");
	private By searchText = By.xpath("//input[@name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemResult = By.cssSelector(".product-layout .product-thumb h4 a");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elemUtil = new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		return elemUtil.waitForTitlePresent(Constants.ACCOUNT_PAGE_TITLE, 10);
	}

	public String getHeadervalue() {
		if (elemUtil.getElement(header).isDisplayed()) {
			return elemUtil.getElement(header).getText();
		}
		return null;
	}
	
	public int getAccountSectionsCount() {
		return elemUtil.getElements(accountHeaders).size();
	}
	
	public List<String>  getAccountSectionsItems() {
		List<String> allaccntSecItems = new ArrayList<String>();
		List<WebElement> accntSecnItems = elemUtil.getElements(accountHeaders);
		
		for(WebElement temp : accntSecnItems) {
			allaccntSecItems.add(temp.getText());
		}
		return allaccntSecItems;
	}
	
	public boolean doSearchItems(String productName) {
		elemUtil.getElement(searchText).sendKeys(productName);
		elemUtil.getElement(searchButton).click();
		if(elemUtil.getElements(searchItemResult).size()>0) {
			return true;
		}
		return false;
	}
	
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemList = elemUtil.getElements(searchItemResult);
		System.out.println("Total number of items displayed : " + resultItemList.size());
		for(WebElement e : resultItemList) {
			if(e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
	return new ProductInfoPage(driver);	
	}
}
