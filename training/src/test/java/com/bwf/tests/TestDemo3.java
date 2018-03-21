package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo3 {
	@BeforeTest
	public void beforTestM() {
		System.out.println("---Befor Test3---");
	}
	@AfterTest
	public void afterTestM() {
		System.out.println("---After Test3---");
	}
	@BeforeClass
	public void beforClassM() {
		System.out.println("---Befor Class TestDemo3---");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("---After Class TestDemo3---");
	}
	@BeforeMethod
	public void beforMethodM() {
		System.out.println("---Befor Method in TestDemo3---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("---After Method in TestDemo3---");
	}
	@Test(invocationCount=3)
	public void myTest31Func() {
		System.out.println("。。。testMethod-myTest31Func");
	}
	@Test(dependsOnMethods= {"myTest31Func"})
	public void myTest32Func() {
		System.out.println("。。。testMethod-myTest32Func");
	}
}
