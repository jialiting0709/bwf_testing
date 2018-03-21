package com.bwf.DriverUtil;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bwf.framework.utils.ReadExcel;

public class test {

	public static void main(String[] args) {
		//List <>datas = new ArrayList<>();
		Object[][] obj = ReadExcel.getDataFromExcel("LoginTestData.xlsx", "register");
		
	}

}
