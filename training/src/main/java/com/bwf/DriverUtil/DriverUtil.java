package com.bwf.DriverUtil;

import java.io.File;
import java.io.IOException;

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
	private static WebDriver driver;
	/**
	 * 静态加载（单例的饿汉模式）service对象，并启动
	 */
	static {
		/**
		 * 获取系统属性bwf.test.browser的值，如果未设置，默认为firefox
		 */
		browser =System.getProperty("bwf.test.browser","firefox");
		
		/**
		 * 根据browser，分别创建DriverService对象
		 */
		if(browser.equalsIgnoreCase("firefox")) {
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))
					.usingDriverExecutable(new File("F:\\geckodriver-v0.19.1-win32\\geckodriver.exe"))
					.build();//将Builder对象打造成service对象
		}else if(browser.equalsIgnoreCase("chrome")) {
			service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File("F:\\chromedriver_2.33_win32\\chromedriver.exe"))
					.build();
		}else {
			new RuntimeException("没有可执行浏览器");
		}
		
		try {
			service.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			driver =  new RemoteWebDriver(service.getUrl(),DesiredCapabilities.firefox());
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
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
