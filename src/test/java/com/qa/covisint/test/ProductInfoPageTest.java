package com.qa.covisint.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.covisint.base.BaseTest;

public class ProductInfoPageTest extends BaseTest  {
	
	@BeforeClass
	public void productInfoSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyProductInfoTestMacBook(){
		String productsName = "MacBook";
		Assert.assertTrue(accountPage.doSearchItems(productsName));
		productInfoPage = accountPage.selectProductFromResults("MacBook Pro");
		productInfoPage.addToCart();
		int imageSize = productInfoPage.getProductImages();
		System.out.println(imageSize);
		Map<String, String> productInforMap = productInfoPage.getProductInformation();
		System.out.println(productInforMap);
		
		Assert.assertEquals(productInforMap.get("name"), "MacBook Pro");
		Assert.assertEquals(productInforMap.get("Brand"), "Apple");
		Assert.assertEquals(productInforMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInforMap.get("Reward Points"), "800");
		Assert.assertEquals(productInforMap.get("price"), "$2,000.00");
	
		}
}
