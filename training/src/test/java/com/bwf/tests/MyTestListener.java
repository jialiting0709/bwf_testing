package com.bwf.tests;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter{
	@Override
	//����ʧ��
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		System.out.print("F");
	}
	@Override
	//���гɹ�
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		System.out.print(".");
	}
}
