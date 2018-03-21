package com.bwf.framework.utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * test方法失败就重跑一次监听器
 * @author jlt
 *
 */

public class RetryListen implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		//如果没有设置过重跑分析器那么就是设置重跑分析器
		//设置过，计数器会被清零
		IRetryAnalyzer retry = method.getTestMethod().getRetryAnalyzer();
		if(retry==null) {
			method.getTestMethod().setRetryAnalyzer(new RetryAnalysis());
		}
		
	}

	
	
}
