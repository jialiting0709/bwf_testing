package com.bwf.ecshop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * IndexPage�����ڶ���index.phpҳ���Ԫ�غͷ���
 * @author jlt
 *
 */
public class IndexPage {
	/**
	 * ��¼����
	 */
	@FindBy(partialLinkText="���¼")
	private WebElement login_link;
	/**
	 * ���ע������
	 */
	@FindBy(partialLinkText="���ע��")
	private WebElement register_link;
	/**
	 * PageFactory���������Լ�
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * �����¼����
	 */
	public void click_login_link() {
		login_link.click();
	}
	/**
	 * ������ע������
	 */
	public void click_register_link() {
		register_link.click();
	}
}
