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
 * 注册页面
 * @author jlt
 *
 */
public class RegisterPage {
	private WebDriver driver;
	private List<WebElement> reg_list;
	/*
	 * 用户名输入框
	 */
	@FindBy(id="username")
	private WebElement reg_username_input;
	/*
	 * 邮箱的输入框
	 */
	@FindBy(id="email")
	private WebElement reg_email_input;
	/*
	 * 密码输入框
	 */
	@FindBy(id="password1")
	private WebElement reg_password_input;
	/*
	 * 确认密码输入框
	 */
	@FindBy(id="conform_password")
	private WebElement reg_confirm_password_input;
	/*
	 * 手机输入框
	 */
	@FindBy(name="extend_field5")
	private WebElement reg_cellphone_input;
	
	/*
	 * 定位注册成功
	 */
	//@FindBy(css="div.boxCenterList>div>p")
	@FindBy(css="div.boxCenterList>div>p") 
	private WebElement login_result_text;
	
	/*
	 * 立即注册按钮
	 */
	@FindBy(name="Submit")
	private WebElement submit_btn;
	/**
	 * 点击立即注册按钮
	 */
	public void click_submit_btn() {
		submit_btn.click();
	}
	/*
	 * PageFactory创建自己
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
	 * 检查点，检查必填项是否符合要求。把有提示信息的必输项按顺序放到集合里，
	 * @param index	第几个必填项，从1开始
	 * @param expectedText	提示的希望文本
	 */
	public void assert_input_tip(int index,String expectedText) {
		WebElement findElement = reg_list.get(index-1).findElement(By.xpath("../span"));
		String actual = findElement.getText();
		assertTrue(actual.contains(expectedText));
	}
	/*
	 * 检查点，断言注册成功是否和提示文本一样
	 * expected 期望提示的文本
	 */
	public void assert_result_text(String expetedText) {
		String actualText = login_result_text.getText();
		System.out.println("============="+actualText);
		assertEquals(actualText, expetedText);
	}
	/**
	 * 对注册信息输入指定内容
	 * @param index 第几个必填项，从1开始
	 * @param content 输入的内容
	 */
	public void input_reg_info(int index,String content) {
		reg_list.get(index-1).sendKeys(content);
	}
	
}
