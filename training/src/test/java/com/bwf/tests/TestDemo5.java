package com.bwf.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * 
 * @author jlt
 *监听器能做什么事情
 */
public class TestDemo5 {
	@Test
	public void testFunc1() {
		int a =2;
		assertEquals(a, 2);//实际值在前，期望值在后，相等就成功，不相等就失败
	}	
	/**
	 * 失败了需要做一些记录
	 */
	@Test
	public void testFunc2() {
		int a =3;
		assertEquals(a, 2);//实际值在前，期望值在后，相等就成功，不相等就失败
	}	
}
