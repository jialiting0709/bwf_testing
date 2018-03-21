package com.bwf.ecshop.pages;
/**
 * UserPage�����ڶ���user.phpҳ���Ԫ�غͷ���
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
	 * ��λ�û��������
	 */
	@FindBy(name="username")
	private WebElement username_input;
	
	/**
	 * ��λ���������
	 */
	@FindBy(name="password")
	private WebElement password_input;
	/**
	 * ��λ������¼��ť
	 */
	@FindBy(name="submit")
	private WebElement submit_btn;
	/**
	 * ��λ��¼�ɹ�����ʾ
	 */
	@FindBy(css="div.boxCenterList>div>p")
	private WebElement login_result_text;
	
	/**
	 * PageFactory���������Լ�
	 * @param driver
	 */
	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * ���û��������������ָ�����û����ַ���
	 */
	public void input_username(String userName) {
		username_input.sendKeys(userName);
	}
	/**
	 * �����������������ָ���������ַ���
	 */
	public void input_password(String passWord) {
		password_input.sendKeys(passWord);
	}
	/**
	 * ���������¼��ť
	 */
	public void click_submit() {
		submit_btn.click();
	}
	/*
	 * ���㣬�����Ƿ���ʾָ���ĵ�¼����ʾ�ı�
	 * expectedText ������ʾ���ı�
	 */
	public void asset_login_success_text(String expectedText) {
		String actualText = login_result_text.getText();
		assertEquals(actualText, expectedText);
	}
	/*
	 * ���㣬�����Ƿ��Alert��ʾ�ı�һ��
	 * expected ������ʾ���ı�
	 */
	public void assert_alert_text(String expetedText) {
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		//�رյ���
		alert.accept();
		assertTrue(actualText.contains(expetedText));
	}
}
