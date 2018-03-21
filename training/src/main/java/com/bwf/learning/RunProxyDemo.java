package com.bwf.learning;

import java.lang.reflect.Proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

public class RunProxyDemo {

	public static void main(String[] args) {
		ITestAnno ta = TestAnnoFactory.getBuild();
		ta.sayHi();
	}

}
