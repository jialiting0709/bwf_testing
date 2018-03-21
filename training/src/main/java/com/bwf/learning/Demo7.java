package com.bwf.learning;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bwf.DriverUtil.DriverUtil;

public class Demo7 {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("https://www.baidu.com");
			String baidu = driver.getWindowHandle();
			driver.findElement(By.id("kw")).sendKeys("51testing");
			//输入回车
			driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
			driver.findElement(By.partialLinkText("中国软件测试领跑者")).click();
			Thread.sleep(2000);
			String testing51 = driver.getWindowHandle();
			//弹窗处理
			 Set<String> hands = driver.getWindowHandles();
			 String hand51="";
			for(String handle:hands) {
				if(!handle.equals(baidu)) {
					hand51=handle;
					break;
				}
			}
			driver.switchTo().window(hand51);
			String text = driver.findElement(By.className("title")).getText();
			System.out.println(text);
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}
	}

}
