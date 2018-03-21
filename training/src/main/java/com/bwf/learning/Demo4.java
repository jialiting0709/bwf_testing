package com.bwf.learning;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.bwf.DriverUtil.DriverUtil;

public class Demo4 {

	public static void main(String[] args) {
		//javascript & jquery
		WebDriver driver = DriverUtil.getDriver();
		try {
			driver.get("http://127.0.0.1:801/test/table.html");
			JavascriptExecutor jee = (JavascriptExecutor)driver;
			Thread.sleep(4000);
			Object object = jee.executeScript("return document.getElementsByTagName('tr');");
			System.out.println(object);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}

	}

}
