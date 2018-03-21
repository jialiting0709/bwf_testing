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
 * DriverUtil�������ṩservice�ĵ������������ṩƥ�䲻ͬ�������driver����
 * browser
 * @author jlt
 *
 */

public class DriverUtil {
	/**
	 * service�������ڱ�������û����õ�ϵͳ������������ͬ�������driverservice
	 */
	private static DriverService service;
	/**
	 * ���ڻ�ȡ�������û�������ϵͳ����bwf.test.browser�е�ֵ
	 */
	private static String browser;
	/**
	 * ������־����
	 */
	private static WebDriver driver;
	/**
	 * ��̬���أ������Ķ���ģʽ��service���󣬲�����
	 */
	private static final Logger logger = LogManager.getLogger();
	static {
		/**
		 * ��ȡϵͳ����bwf.test.browser��ֵ�����δ���ã�Ĭ��Ϊfirefox
		 */
		browser =System.getProperty("bwf.test.browser","firefox");
		//ʹ����־��¼��ȡ�Ĳ���ֵ
		logger.info("��ȡϵͳ����bwf.test.browser��ֵΪ"+browser);
		
		/**
		 * ����browser���ֱ𴴽�DriverService����
		 */
		Config config = new Config("config.properties");
		String driverFile = config.getConfig("driver");
		//ʹ����־��¼��ȡ�Ĳ���ֵ
		logger.info("��ȡ�����ļ���driver����·�����ļ�����ֵΪ"+driverFile);
		if(browser.equalsIgnoreCase("firefox")) {
			service = new GeckoDriverService.Builder()
					.usingFirefoxBinary(new FirefoxBinary(new File(config.getConfig("FirefoxBinary"))))
					.usingDriverExecutable(new File(driverFile))
					.build();//��Builder��������service����
		}else if(browser.equalsIgnoreCase("chrome")) {
			service = new ChromeDriverService.Builder()
					.usingDriverExecutable(new File(driverFile))
					.build();
		}else {
			//ͨ����־��¼�����������Ϣ�Ƿ���ȷ
			logger.error("Ϊ֧�ֵ���������ͣ�����ϵͳ����bwf.test.browser");
			new RuntimeException("û�п�ִ�������");
		}
		
		try {
			service.start();
			//ͨ����־��¼�����Ƿ���ȷ����
			logger.info("driver����������");
		} catch (IOException e) {
			
			logger.error("���ܳɹ�����service,ԭ��Ϊ"+e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * ��ʹ�����ṩ��ȡ�����driver����
	 * @return
	 */
	public static WebDriver getDriver() {
		/**
		 * ����browser���ж�����browser�����͡�
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
	 * �ر�service
	 */
	public static void stopService() {
		service.stop();
	}
	/**
	 * ��������Ԫ�ع�����ҳ�涥����Ҳ���Ժ��������
	 */
	public static void scrollTodiv(WebElement element,WebDriver driver) {
		JavascriptExecutor jee = (JavascriptExecutor)driver;
		Point location = element.getLocation();
		jee.executeScript("window.scrollTo(arguments[0] ,arguments[1])",location.x,location.y);
	}
}
