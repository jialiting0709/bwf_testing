package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bwf.DriverUtil.DriverUtil;

public class Demo6 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://localhost:801/test/frame.html");
			//页中页定位要用switchTo()
			driver.switchTo().frame(driver.findElement(By.xpath("//p[@id='mid']/iframe[2]")));
			driver.findElement(By.id("kw")).sendKeys("123");
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.id("keguan")).sendKeys("滴滴滴");
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}
	}

}
