package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.DriverUtil.DriverUtil;

public class Demo2 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		/**
		 driver.get("http://127.0.0.1:801/test/link.html");
		WebElement link = driver.findElement(By.partialLinkText("吃了吗"));
		System.out.println(link.getText()); */
		try {
			//异步延迟
			//driver.manage().timeouts().implicitlyWait(4L,TimeUnit.SECONDS);
			//JavascriptExecutor jee = (JavascriptExecutor)driver;
			driver.get("http://127.0.0.1:801/test/table.html");
			//执行js
			//jee.executeScript("window.scrollTo(arguments[0] ,arguments[1])",0,1000);
			int pricel1,pricel2;
			pricel1 = select(driver,1);
			pricel2 = select(driver,3);
			System.out.println("总和为："+(pricel1+pricel2));
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			DriverUtil.stopService();
		}
	}
	public static int select(WebDriver driver,int index) {
		int pricel;
		WebElement element = driver.findElement(By.xpath("//table/tbody/tr["+(1+index)+"]/td[4]/input"));
		element.click();
		pricel = Integer.parseInt(element.findElement(By.xpath("../../td[3]")).getText());
		return pricel;
	}

}
