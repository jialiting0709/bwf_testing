package com.bwf.learning;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.bwf.DriverUtil.DriverUtil;

public class TaoBaoMouse {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			//等待http返回的值
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("https://www.taobao.com");
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.id("J_SiteNavSeller")))
			.pause(Duration.ofSeconds(2L))
			.moveToElement(driver.findElement(By.id("J_SiteNavService")))
			.pause(Duration.ofSeconds(2L))
			.moveToElement(driver.findElement(By.id("J_SiteNavSitemap")))
			.perform();
			Thread.sleep(2000);
			driver.quit();
		} catch (Exception e) {
			driver.quit();
			e.printStackTrace();
		}finally {
			DriverUtil.stopService();
		}

	}

}
