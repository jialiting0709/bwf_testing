package com.bwf.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * 
 * @author jlt
 *����������ʲô����
 */
public class TestDemo5 {
	@Test
	public void testFunc1() {
		int a =2;
		assertEquals(a, 2);//ʵ��ֵ��ǰ������ֵ�ں���Ⱦͳɹ�������Ⱦ�ʧ��
	}	
	/**
	 * ʧ������Ҫ��һЩ��¼
	 */
	@Test
	public void testFunc2() {
		int a =3;
		assertEquals(a, 2);//ʵ��ֵ��ǰ������ֵ�ں���Ⱦͳɹ�������Ⱦ�ʧ��
	}	
}
