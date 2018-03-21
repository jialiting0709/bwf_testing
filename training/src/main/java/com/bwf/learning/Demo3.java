package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.DriverUtil.DriverUtil;

public class Demo3 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			//等待http返回的值
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("https://www.taobao.com");
			WebElement div = driver.findElement(By.cssSelector(".layer.clearfix>div"));
			DriverUtil.scrollTodiv(div, driver);
			WebElement element = driver.findElement(By.id("dg-item-tl-0"));
			String text = element.getText();
			System.out.println(text);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}

	}

}
