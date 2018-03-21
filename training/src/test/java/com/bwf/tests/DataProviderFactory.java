package com.bwf.tests;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
	@DataProvider(name="auth")
	public static Object[][] getDataProvider() {
		return new Object[][] {
			{"liudao","123456"},
			{"xiaohong","234567"},
			{"xiaoqiang","345678"}
		};
	}
}
