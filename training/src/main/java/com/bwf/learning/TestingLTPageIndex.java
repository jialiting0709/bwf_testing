package com.bwf.learning;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 	注解查找元素
 *
 */
public class TestingLTPageIndex{
	@FindBy(linkText="[软件测试新手上路]")
	public WebElement forum_1_link;
	
	public TestingLTPageIndex(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
