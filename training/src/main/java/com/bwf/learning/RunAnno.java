package com.bwf.learning;

import java.lang.reflect.Method;

public class RunAnno {

	public static void main(String[] args) throws Exception{
		TestAnno ta = new TestAnno();
		//��TestAnno�����Ҳ��������ķ��������ֲ��ܷ���Method
		//import java.lang.reflect.Method���������࣬�ѷ�������Method�Ķ��󷵻�
		Method method = TestAnno.class.getDeclaredMethod("sayHi");
		//��ȡ��ǰ������ע����
		RunTime rt = method.getAnnotation(RunTime.class);
		int count = rt.count();
		for(int i = 0;i<count;i++) {
			//����
			method.invoke(ta);
		}
		
	}

}
