package com.bwf.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestRunner {
	public static void main(String[] args) {
		TestNG testNG = new TestNG();
//		testNG.setTestClasses(new Class[] {TestDemo1.class});	
//		testNG.run();
		XmlSuite suite = new XmlSuite();
		List<String> file = new ArrayList<String>();
		file.add("testngDemo.xml");
		suite.setSuiteFiles(file);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		testNG.setXmlSuites(suites);
		testNG.run();
	}
}
