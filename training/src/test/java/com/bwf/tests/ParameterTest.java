package com.bwf.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterTest {
/*	@DataProvider(name="auth")
	public Object[][] getAuthData(){
		return new Object [][] {
			{"liudao","123456"},
			{"xiaohong","234567"},
			{"xiaoqiang","345678"}
		};
	}*/
	@Test(dataProvider="auth",dataProviderClass=com.bwf.tests.DataProviderFactory.class)
	public void testp(String u,String p) {
		System.out.println("”√ªß√˚£∫"+u+","+"√‹¬Î£∫"+p);
	}
	
}
