package com.bwf.learning;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;


public class Demo1 {

	public static void main(String[] args) {
		//…Ë÷√‰Ø¿¿∆˜«˝∂Ø

		//System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_2.33_win32\\chromedriver.exe");
		//WebDriver driver = new  ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "F:\\geckodriver-v0.19.1-win32\\geckodriver.exe");
		//WebDriver driver = new  FirefoxDriver();
		GeckoDriverService service  =new GeckoDriverService.Builder()
				.usingFirefoxBinary(new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")))
				.usingAnyFreePort()
				.usingDriverExecutable(new File("F:\\geckodriver-v0.19.1-win32\\geckodriver.exe"))
				.build();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setProfile(new FirefoxProfile(new File("E:\\temp")));
		//≈‰÷√Œƒº˛∆Ù”√ª∫¸
		FirefoxDriver driver = new FirefoxDriver(service,firefoxOptions);
		driver.get("https://www.baidu.com");
	}

}
