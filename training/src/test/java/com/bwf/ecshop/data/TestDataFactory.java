package com.bwf.ecshop.data;
/**
 * 数据工厂，参数化数据
 * @author jlt
 *
 */

import org.testng.annotations.DataProvider;

import com.bwf.framework.utils.ReadExcel;

public class TestDataFactory {
	/*
	 * 给登陆提供用户名和密码，期望值也传进来；注意命名规则
	 */
	@DataProvider(name="login_test_data")
	public static Object[][] getTestData(){
		/*return new Object[][] {
			{"liudao001","123456","登录成功"},
			{"liudao001","111111","用户名或密码错误"},
			{"liudao","123456","用户名或密码错误"},
			{"","123456","用户名不能为空"},
			{"liudao001","","登录密码不能为空"}
			
		};*/
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "login");
	}
	/**
	 * 给注册提供用户名,email,密码,确定密码,手机.期望值也传进来.
	 * @return
	 */
	@DataProvider(name="registerTestData_tips")
	public static Object[][] getRegisterTestData_tips(){ 
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "register"); 
	}
	@DataProvider(name="registerTest_success")
	public static Object[][] getRegisterTestData(){
		return ReadExcel.getDataFromExcel("LoginTestData.xlsx", "Sheet3");
	}     
	
}
