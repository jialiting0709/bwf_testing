package com.bwf.learning;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RunTime {	
	//定义方法执行次数，没有指定默认执行一次
	public int count() default 1;

}
