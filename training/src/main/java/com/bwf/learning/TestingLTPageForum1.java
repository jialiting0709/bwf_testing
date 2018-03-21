package com.bwf.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingLTPageForum1 {
	@FindBy(xpath="//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]")
	public static List<WebElement> threads;	
	/**
	 * 点击某篇帖子	
	 * @param index帖子的序号，从1开始
	 */
	public static void clickTopic(int index) {
		TestingLTPageForum1.threads.get(index-1).findElement(By.xpath("tr/th/a[3]")).click();
	}
	public TestingLTPageForum1(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
}
