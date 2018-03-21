package com.bwf.learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bwf.DriverUtil.DriverUtil;

public class TestingLTDemo2 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			List<WebElement> elements ;
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/");	
			//论坛首页
			//TestingLTPageIndex testingLTPageIndex = PageFactory.initElements(driver, TestingLTPageIndex.class);
			TestingLTPageIndex testingLTPageIndex = new TestingLTPageIndex(driver);
			testingLTPageIndex.forum_1_link.click();
			//TestingLTPageForum1 testingLTPageForum1 = PageFactory.initElements(driver, TestingLTPageForum1.class);
			TestingLTPageForum1 testingLTPageForum1 = new TestingLTPageForum1(driver);
			//testingLTPageForum1.threads.get(0).findElement(By.xpath("tr/th/a[3]")).click();
			TestingLTPageForum1.clickTopic(1);
			Thread.sleep(2000);
			driver.findElement(By.linkText("[软件测试新手上路]")).click();
			TestingLTPageForum1.clickTopic(2);
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}finally {
			DriverUtil.stopService();
		}

	}

}
