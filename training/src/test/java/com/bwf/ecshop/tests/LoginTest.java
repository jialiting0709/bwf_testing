package com.bwf.ecshop.tests;

import org.testng.annotations.Test;

import com.bwf.ecshop.pages.IndexPage;
import com.bwf.ecshop.pages.UserPage;
import com.bwf.framework.utils.BaseTest;



public class LoginTest extends BaseTest{
	/**
	 * 登陆成功的测试用例
	 * @throws InterruptedException 
	 */
	@Test(dataProvider="login_test_data",dataProviderClass=com.bwf.ecshop.data.TestDataFactory.class)
	public void login_success(String username,String password,String  expected) {
//		1、打开首页	
		driver.get("http://localhost:801/ecshop");
//		2、点击登录连接
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
//		3、填写用户名，密码
		UserPage userPage = new UserPage(driver);
		userPage.input_username(username);
		userPage.input_password(password);
//		4、点击立刻登录按钮
		userPage.click_submit();
//		5、判断是否登录成功
		//打印页面元素
		//System.out.println(driver.getPageSource());
		if(username.equals("") || password.equals("")) {
			userPage.assert_alert_text(expected);
		}else {
			userPage.asset_login_success_text(expected);
		}
		
	}
	
}
