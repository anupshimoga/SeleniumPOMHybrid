package com.qa.covisint.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	public static final int ACCOUNT_SECTIONS = 4;
	
	public static final List<String> getAccountSectionsList() {
		List<String> getAccountList = new ArrayList<String>();
		getAccountList.add("My Account");
		getAccountList.add("My Orders");
		getAccountList.add("My Affiliate Account");
		getAccountList.add("Newsletter");
		return getAccountList;
	}
}
