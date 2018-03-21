package com.bwf.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestAnnoFactory {
	public static ITestAnno build;
	
	public static ITestAnno getBuild() {
		build = (ITestAnno)Proxy.newProxyInstance(ITestAnno.class.getClassLoader(),
				new Class[]{ITestAnno.class}, 
				new TestAnnoInvocationHandler());
		return build;
	}
	
}
