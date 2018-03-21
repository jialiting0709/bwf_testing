package com.bwf.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
/**
 * DriverUtil类用于提供service的单例启动，并提供匹配不同浏览器的driver对象
 * browser
 * @author jlt
 *
 */

public class DriverUtil {
	/**
	 * service对象，用于保存根据用户设置的系统属性来创建不同浏览器的driverservice
	 */
	private static DriverService service;
	/**
	 * 用于获取并保存用户设置在系统属性bwf.test.browser中的值
	 */
	private static String browser;
	/**
	 * 定义日志对象
	 */
	private static WebDriver driver;
	/**
	 * 静态加载（单例的饿汉模式）service对象，并启动
	 */
	private static final Logger logger = LogManager.getLogger();
	static {
		/**
		 * 获取系统属性bwf.test.browser的值，如果未设置，默认为firefox
		 */
		browser =System.getProperty("bwf.test.browser","firefox");
		//使用日志记录获取的参数值
		logger.info("获取系统属性bwf.test.browser，值为"+browser);
		
		/**
		 * 根据browser，分别创建DriverService对象
		 */
		Config config = new Config("config.properties");
		String driverFile = config.getConfig("driver");
		//使用日志记录获取的参数值
		logger.info("获取配置文件中driver所在路径和文件名，值为"+driverFile);
		if(browser.equalsIgnoreCase("firefox")) {
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File(config.getConfig("FirefoxBinary"))))
					.usingDriverExecutable(new File(driverFile))
					.build();//将Builder对象打造成service对象
		}else if(browser.equalsIgnoreCase("chrome")) {
			service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(driverFile))
					.build();
		}else {
			//通过日志记录浏览器配置信息是否正确
			logger.error("为支持的浏览器类型，请检查系统属性bwf.test.browser");
			new RuntimeException("没有可执行浏览器");
		}
		
		try {
			service.start();
			//通过日志记录服务是否正确启动
			logger.info("driver服务已启动");
		} catch (IOException e) {
			
			logger.error("不能成功启动service,原因为"+e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * 向使用者提供获取浏览器driver对象
	 * @return
	 */
	public static WebDriver getDriver() {
		/**
		 * 根据browser，判断启动browser的类型。
		 */
		if(browser.equalsIgnoreCase("firefox")) {
			driver =  new WrappedRemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new WrappedRemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
		}else {
			
		}
		return driver;
	}
	/**
	 * 关闭service
	 */
	public static void stopService() {
		service.stop();
	}
	/**
	 * 锁定其他元素滚动到页面顶部（也可以横向滚动）
	 */
	public static void scrollTodiv(WebElement element,WebDriver driver) {
		JavascriptExecutor jee = (JavascriptExecutor)driver;
		Point location = element.getLocation();
		jee.executeScript("window.scrollTo(arguments[0] ,arguments[1])",location.x,location.y);
	}
}
