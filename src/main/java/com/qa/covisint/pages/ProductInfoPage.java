package com.qa.covisint.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.covisint.base.BasePage;
import com.qa.covisint.utils.ElementUtil;

public class ProductInfoPage extends BasePage{
	private WebDriver driver;
	private ElementUtil elemUtil;
	
	private By productNameHeader = By.cssSelector("#content h1");
	private By productMetaData = By.cssSelector("#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("#content .list-unstyled:nth-of-type(2) li");
	private By quantity = By.id("input-quantity");
	private By addToCart = By.id("button-cart");
	private By productImages = By.cssSelector(".thumbnails li img");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elemUtil = new ElementUtil(this.driver);
	}

	public void getProductPageTitle() {
		elemUtil.waitForTitlePresent("iMac", 10);
	}

	public Map<String, String> getProductInformation() {
		Map<String, String> productInforMap = new HashMap<>();
		productInforMap.put("name", elemUtil.doGetText(productNameHeader).trim());
		List<WebElement> productMetaDataList = elemUtil.getElements(productMetaData);
		for(WebElement e : productMetaDataList ) {
			productInforMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());			
		}
		List<WebElement> productPriceData = elemUtil.getElements(productPrice);
			productInforMap.put("price", productPriceData.get(0).getText().trim());
			productInforMap.put("exTaxPrice", productPriceData.get(1).getText().split(":")[1].trim());
			
		return productInforMap;
	}
	
	public void selectQuantity(String qty) {
		elemUtil.doSendKeys(quantity, qty);
	}
	
	public void addToCart() {
		elemUtil.doClick(addToCart);
	}
	
	public int getProductImages() {
		int imagesCount = elemUtil.getElements(productImages).size();
		System.out.println("total images :"+imagesCount);
		return imagesCount;
	}
	
}
