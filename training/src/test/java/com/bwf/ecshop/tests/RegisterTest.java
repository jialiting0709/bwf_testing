package com.bwf.ecshop.tests;

import org.testng.annotations.Test;

import com.bwf.ecshop.pages.IndexPage;
import com.bwf.ecshop.pages.RegisterPage;
import com.bwf.ecshop.pages.UserPage;
import com.bwf.framework.utils.BaseTest;

/**
 * 
 * @author jlt
 *
 */
public class RegisterTest extends BaseTest{
	@Test(dataProvider="registerTestData_tips",dataProviderClass=com.bwf.ecshop.data.TestDataFactory.class)
	public void testRegister(String content,String expectedText ) {
		String[] contents = content.split(",");
		String[] expectedTexts =  expectedText.split(",");
		driver.get("http://localhost:801/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_register_link();
		RegisterPage registerPage = new RegisterPage(driver);
		for(int i=1;i<=contents.length;i++) {
			registerPage.input_reg_info(i,contents[i-1]);
		}
		for(int i=1;i<=expectedTexts.length;i++) {
			registerPage.assert_input_tip(i,expectedTexts[i-1]);
		}
	}
	/**
	 * 成功注册的测试用例
	 */
	@Test(dataProvider="registerTest_success",dataProviderClass=com.bwf.ecshop.data.TestDataFactory.class)
	public void testRegisterSuccess(String content,String expectedText) {
		String[] contents = content.split(",");
		driver.get("http://localhost:801/ecshop/");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.click_register_link();
		RegisterPage registerPage = new RegisterPage(driver);
		for(int i=1;i<=contents.length;i++) {
			registerPage.input_reg_info(i, contents[i-1]);
		}
		registerPage.click_submit_btn();
		registerPage.assert_result_text(expectedText);
	}
}
