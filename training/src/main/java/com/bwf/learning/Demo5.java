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
		//����alert
		WebDriver driver = DriverUtil.getDriver();
		try {
			//driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);��ʽ�ȴ���������
			driver.get("http://localhost:801/test/kuang.html");
			driver.findElement(By.id("a1")).click();	
			//���10s��û���ҵ�������־��д��������Ϣ
			WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver, 10).withMessage("����10�붼û�ҵ���sorry");
			//�ȴ������alert��ȷ��
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//���alert��ȷ��
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
