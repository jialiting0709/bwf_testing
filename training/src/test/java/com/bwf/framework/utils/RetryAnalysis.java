package com.bwf.framework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * 重跑计数器，失败重跑一次
 * @author jlt
 *
 */
public class RetryAnalysis implements IRetryAnalyzer{
	private static final int MAX= 1;
	private int count;


	/**
	 * 返回true代表重跑，放回false代表不用重跑
	 */
	@Override
	public boolean retry(ITestResult result) {
		if(count<=MAX) {
			count++;
			return true;
		}
		return false;
	}

}
