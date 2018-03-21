package com.bwf.tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
	@Override
	//运行失败
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.print("F");
	}
	@Override
	//运行成功
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		System.out.print(".");
	}
}
