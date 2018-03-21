package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bwf.DriverUtil.DriverUtil;

public class PODemo {
	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			//�ȴ�http���ص�ֵ
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com");
			//PageFactory�����෵�ش������ʵ��
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
