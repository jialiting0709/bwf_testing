package com.bwf.ecshop.tests;

import org.testng.annotations.Test;

import com.bwf.ecshop.pages.IndexPage;
import com.bwf.ecshop.pages.UserPage;
import com.bwf.framework.utils.BaseTest;



public class LoginTest extends BaseTest{
	/**
	 * ��½�ɹ��Ĳ�������
	 * @throws InterruptedException 
	 */
	@Test(dataProvider="login_test_data",dataProviderClass=com.bwf.ecshop.data.TestDataFactory.class)
	public void login_success(String username,String password,String  expected) {
//		1������ҳ	
		driver.get("http://localhost:801/ecshop");
//		2�������¼����
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_login_link();
//		3����д�û���������
		UserPage userPage = new UserPage(driver);
		userPage.input_username(username);
		userPage.input_password(password);
//		4��������̵�¼��ť
		userPage.click_submit();
//		5���ж��Ƿ��¼�ɹ�
		//��ӡҳ��Ԫ��
		//System.out.println(driver.getPageSource());
		if(username.equals("") || password.equals("")) {
			userPage.assert_alert_text(expected);
		}else {
			userPage.asset_login_success_text(expected);
		}
		
	}
	
}
