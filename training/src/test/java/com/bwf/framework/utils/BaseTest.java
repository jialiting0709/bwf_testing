package com.bwf.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

/**
 * ÿ������������Ҫ�õķ���
 * @author jlt
 *
 */
public class BaseTest {
	public WebDriver driver;
	/**
	 * ִ����suite(�����׼�)�ر�service
	 */
	@AfterSuite
	public void clossService() {
		DriverUtil.stopService();
	}
	/**
	 * ÿ����������֮ǰ��Ҫ��ȡһ��driver
	 * @return
	 */
	@BeforeMethod
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("bwf.test.browser", config.getConfig("bwf.test.browser"));
		driver = DriverUtil.getDriver();
	}
	/**
	 * ÿ������ִ�к�ر������
	 */
	@AfterMethod
	public void clossDriver() {
		driver.quit();
	}
	
}
