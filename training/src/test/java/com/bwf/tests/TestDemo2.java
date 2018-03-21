package com.bwf.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo2 {
	@BeforeClass
	public void beforClassM() {
		System.out.println("---Befor Class TestDemo2---");
	}
	@AfterClass
	public void afterClassM() {
		System.out.println("---After Class TestDemo2---");
	}
	@BeforeMethod
	public void beforMethodM() {
		System.out.println("---Befor Method in TestDemo2---");
	}
	@AfterMethod
	public void afterMethodM() {
		System.out.println("---After Method in TestDemo2---");
	}
	@Test(groups= {"firstLeve1"})
	public void myTest21Func() {
		System.out.println("。。。testMethod-myTest21Func");
	}
	@Test(groups= {"secondLeve1"})
	public void myTest22Func() {
		System.out.println("。。。testMethod-myTest22Func");
	}
}
