package com.bwf.ecshop.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * ע��ҳ��
 * @author jlt
 *
 */
public class RegisterPage {
	private WebDriver driver;
	private List<WebElement> reg_list;
	/*
	 * �û��������
	 */
	@FindBy(id="username")
	private WebElement reg_username_input;
	/*
	 * ����������
	 */
	@FindBy(id="email")
	private WebElement reg_email_input;
	/*
	 * ���������
	 */
	@FindBy(id="password1")
	private WebElement reg_password_input;
	/*
	 * ȷ�����������
	 */
	@FindBy(id="conform_password")
	private WebElement reg_confirm_password_input;
	/*
	 * �ֻ������
	 */
	@FindBy(name="extend_field5")
	private WebElement reg_cellphone_input;
	
	/*
	 * ��λע��ɹ�
	 */
	//@FindBy(css="div.boxCenterList>div>p")
	@FindBy(css="div.boxCenterList>div>p") 
	private WebElement login_result_text;
	
	/*
	 * ����ע�ᰴť
	 */
	@FindBy(name="Submit")
	private WebElement submit_btn;
	/**
	 * �������ע�ᰴť
	 */
	public void click_submit_btn() {
		submit_btn.click();
	}
	/*
	 * PageFactory�����Լ�
	 */
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		List<WebElement> input_list =new ArrayList<>();
		input_list.add(reg_username_input);
		input_list.add(reg_email_input);
		input_list.add(reg_password_input);
		input_list.add(reg_confirm_password_input);
		input_list.add(reg_cellphone_input);
		this.reg_list=input_list;
	}
	/**
	 * ���㣬���������Ƿ����Ҫ�󡣰�����ʾ��Ϣ�ı����˳��ŵ������
	 * @param index	�ڼ����������1��ʼ
	 * @param expectedText	��ʾ��ϣ���ı�
	 */
	public void assert_input_tip(int index,String expectedText) {
		WebElement findElement = reg_list.get(index-1).findElement(By.xpath("../span"));
		String actual = findElement.getText();
		assertTrue(actual.contains(expectedText));
	}
	/*
	 * ���㣬����ע��ɹ��Ƿ����ʾ�ı�һ��
	 * expected ������ʾ���ı�
	 */
	public void assert_result_text(String expetedText) {
		String actualText = login_result_text.getText();
		System.out.println("============="+actualText);
		assertEquals(actualText, expetedText);
	}
	/**
	 * ��ע����Ϣ����ָ������
	 * @param index �ڼ����������1��ʼ
	 * @param content ���������
	 */
	public void input_reg_info(int index,String content) {
		reg_list.get(index-1).sendKeys(content);
	}
	
}
