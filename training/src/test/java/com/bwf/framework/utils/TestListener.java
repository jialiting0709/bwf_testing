package com.bwf.framework.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener  extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr) {
		try {
			Field field = tr.getTestClass().getRealClass().getField("driver");
			WrappedRemoteWebDriver driver = (WrappedRemoteWebDriver)field.get(tr.getInstance());
			String className = tr.getTestClass().getName();
			String mothedName = tr.getName();
			SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss_SSS");
			String time = adf.format(new Date());
			//文件名命名规范类名+方法名+时间（到毫秒）.png(必须是png文件)
			driver.takeScreenShot(className+"-"+mothedName+"-"+time+".png");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
