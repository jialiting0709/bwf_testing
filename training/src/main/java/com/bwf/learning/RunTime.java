package com.bwf.learning;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RunTime {	
	//���巽��ִ�д�����û��ָ��Ĭ��ִ��һ��
	public int count() default 1;

}
