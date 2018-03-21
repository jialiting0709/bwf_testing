package com.bwf.learning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bwf.DriverUtil.DriverUtil;

public class TestingLT {

	public static void main(String[] args) {
		WebDriver driver = DriverUtil.getDriver();
		try {
			List<WebElement> elements ;
			driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
			driver.get("http://bbs.51testing.com/forum.php");
			driver.findElement(By.partialLinkText("[软件测试新手上路]")).click();	
			elements= driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			elements.get(0).findElement(By.xpath("//tr/th/a[3]"));
			Thread.sleep(2000);
			driver.findElement(By.partialLinkText("[软件测试新手上路]")).click();	
			elements = driver.findElements(By.xpath("//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]"));
			elements.get(1).findElement(By.xpath("//tr/th/a[3]"));
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			driver.quit();
		}finally {
			DriverUtil.stopService();
		}
	}

}
