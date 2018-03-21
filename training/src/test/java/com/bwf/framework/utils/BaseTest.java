package com.bwf.framework.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

/**
 * 每个测试用例都要用的方法
 * @author jlt
 *
 */
public class BaseTest {
	public WebDriver driver;
	/**
	 * 执行完suite(测试套件)关闭service
	 */
	@AfterSuite
	public void clossService() {
		DriverUtil.stopService();
	}
	/**
	 * 每个方法运行之前都要获取一下driver
	 * @return
	 */
	@BeforeMethod
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("bwf.test.browser", config.getConfig("bwf.test.browser"));
		driver = DriverUtil.getDriver();
	}
	/**
	 * 每个方法执行后关闭浏览器
	 */
	@AfterMethod
	public void clossDriver() {
		driver.quit();
	}
	
}
