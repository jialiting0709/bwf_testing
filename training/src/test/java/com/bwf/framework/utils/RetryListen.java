package com.bwf.framework.utils;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * test����ʧ�ܾ�����һ�μ�����
 * @author jlt
 *
 */

public class RetryListen implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		//���û�����ù����ܷ�������ô�����������ܷ�����
		//���ù����������ᱻ����
		IRetryAnalyzer retry = method.getTestMethod().getRetryAnalyzer();
		if(retry==null) {
			method.getTestMethod().setRetryAnalyzer(new RetryAnalysis());
		}
		
	}

	
	
}
