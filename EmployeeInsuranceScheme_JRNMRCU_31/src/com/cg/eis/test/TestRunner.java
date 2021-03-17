package com.cg.eis.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

//class to run test classes
public class TestRunner{
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(com.cg.eis.test.EmployeeServiceImplTest.class);
		
		result.getRunCount();
		
		System.out.println(result.wasSuccessful());
	}
}