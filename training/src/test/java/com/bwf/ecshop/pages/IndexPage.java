package com.bwf.ecshop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * IndexPage类用于定义index.php页面的元素和方法
 * @author jlt
 *
 */
public class IndexPage {
	/**
	 * 登录链接
	 */
	@FindBy(partialLinkText="请登录")
	private WebElement login_link;
	/**
	 * 免费注册链接
	 */
	@FindBy(partialLinkText="免费注册")
	private WebElement register_link;
	/**
	 * PageFactory工厂构建自己
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * 点击登录链接
	 */
	public void click_login_link() {
		login_link.click();
	}
	/**
	 * 点击免费注册链接
	 */
	public void click_register_link() {
		register_link.click();
	}
}
