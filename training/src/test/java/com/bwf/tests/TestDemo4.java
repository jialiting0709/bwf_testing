package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo4 {
	@BeforeClass
	public void beforClassM() {
		System.out.println("---Befor Class TestDemo4---");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("---After Class TestDemo4---");
	}
	@BeforeMethod
	public void beforMethodM() {
		System.out.println("---Befor Method in TestDemo4---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("---After Method in TestDemo4---");
	}
	@Test
	public void myTest41Func() {
		System.out.println("。。。testMethod-myTest41Func");
	}
	@Test
	public void myTest42Func() {
		System.out.println("。。。testMethod-myTest42Func");
	}
}
