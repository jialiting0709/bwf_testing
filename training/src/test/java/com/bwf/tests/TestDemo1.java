package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo1 {
	@BeforeSuite
	public void beforSuiteM() {
		System.out.println("---Befor Suite---");
	}
	@AfterSuite
	public void afterSuiteM() {
		System.out.println("---After Suite---");
	}
	@BeforeTest
	public void beforTestM() {
		System.out.println("---Befor Test1---");
	}
	@AfterTest
	public void afterTestM() {
		System.out.println("---After Test1---");
	}
	@BeforeClass
	public void beforClassM() {
		System.out.println("---Befor Class TestDemo1---");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("---After Class TestDemo1---");
	}
	@BeforeMethod
	public void beforMethodM() {
		System.out.println("---Befor Method in TestDemo1---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("---After Method in TestDemo1---");
	}
	@Test(groups= {"firstLeve1"})
	public void myTest11Func() {
		System.out.println("。。。testMethod-myTest11Func");
	}
	
	@Test(groups= {"secondLeve1"},dependsOnGroups="firstLeve1")
	public void myTest12Func() {
		System.out.println("。。。testMethod-myTest12Func");
	}
}
