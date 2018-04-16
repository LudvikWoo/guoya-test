package com.guoyasoft.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG0 {
	
	
	@BeforeTest
	public void m1(){
		System.out.println("m1");
	}
	@AfterTest
	public void m9(){
		System.out.println("m9");
	}
	
}
