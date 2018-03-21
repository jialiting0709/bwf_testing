package com.bwf.ecshop.pages;
/**
 * UserPage类用于定义user.php页面的元素和方法
 * @author jlt
 *
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	private WebDriver driver;
	/**
	 * 定位用户名输入框
	 */
	@FindBy(name="username")
	private WebElement username_input;
	
	/**
	 * 定位密码输入框
	 */
	@FindBy(name="password")
	private WebElement password_input;
	/**
	 * 定位立即登录按钮
	 */
	@FindBy(name="submit")
	private WebElement submit_btn;
	/**
	 * 定位登录成功的提示
	 */
	@FindBy(css="div.boxCenterList>div>p")
	private WebElement login_result_text;
	
	/**
	 * PageFactory工厂构建自己
	 * @param driver
	 */
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * 在用户名输入框中输入指定的用户名字符串
	 */
	public void input_username(String userName) {
		username_input.sendKeys(userName);
	}
	/**
	 * 在密码输入框中输入指定的密码字符串
	 */
	public void input_password(String passWord) {
		password_input.sendKeys(passWord);
	}
	/**
	 * 点击立即登录按钮
	 */
	public void click_submit() {
		submit_btn.click();
	}
	/*
	 * 检查点，断言是否显示指定的登录的提示文本
	 * expectedText 期望提示的文本
	 */
	public void asset_login_success_text(String expectedText) {
		String actualText = login_result_text.getText();
		assertEquals(actualText, expectedText);
	}
	/*
	 * 检查点，断言是否和Alert提示文本一样
	 * expected 期望提示的文本
	 */
	public void assert_alert_text(String expetedText) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		//关闭弹框
		alert.accept();
		assertTrue(actualText.contains(expetedText));
	}
}
