package com.bwf.learning;

import java.lang.reflect.Method;

public class RunAnno {

	public static void main(String[] args) throws Exception{
		TestAnno ta = new TestAnno();
		//在TestAnno类里找不带参数的方法，这种才能返回Method
		//import java.lang.reflect.Method反射包里的类，把方法当作Method的对象返回
		Method method = TestAnno.class.getDeclaredMethod("sayHi");
		//获取当前方法的注解类
		RunTime rt = method.getAnnotation(RunTime.class);
		int count = rt.count();
		for(int i = 0;i<count;i++) {
			//运行
			method.invoke(ta);
		}
		
	}

}
