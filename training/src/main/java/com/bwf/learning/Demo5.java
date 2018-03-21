package com.bwf.learning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwf.DriverUtil.DriverUtil;

public class Demo5 {

	public static void main(String[] args) {
		//关于alert
		WebDriver driver = DriverUtil.getDriver();
		try {
			//driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);隐式等待不起作用
			driver.get("http://localhost:801/test/kuang.html");
			driver.findElement(By.id("a1")).click();	
			//如果10s内没有找到会在日志里写出错误信息
			WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver, 10).withMessage("找了10秒都没找到，sorry");
			//等待并点击alert的确定
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//点击alert的确定
//			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
//			alert.sendKeys("345");
			alert.accept();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}

	}

}
