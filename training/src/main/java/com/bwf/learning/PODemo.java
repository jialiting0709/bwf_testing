package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bwf.DriverUtil.DriverUtil;

public class PODemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			//等待http返回的值
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com");
			//PageFactory工厂类返回传进类的实例
			TestingLTPageIndex pageIndex = PageFactory.initElements(driver,TestingLTPageIndex.class );
			pageIndex.forum_1_link.click();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}

	}
}
