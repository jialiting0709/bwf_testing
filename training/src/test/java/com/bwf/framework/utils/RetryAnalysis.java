package com.bwf.framework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * ���ܼ�������ʧ������һ��
 * @author jlt
 *
 */
public class RetryAnalysis implements IRetryAnalyzer{
	private static final int MAX= 1;
	private int count;


	/**
	 * ����true�������ܣ��Ż�false����������
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
