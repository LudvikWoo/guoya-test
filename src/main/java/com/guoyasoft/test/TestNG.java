package com.guoyasoft.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {
	
	@Test
	public void m2(){
		System.out.println("m2");
	}
	@Parameters({"",""})
	@Test
	public void m3(){
		System.out.println("m3");
	}
	@Test
	public void m4(){
		System.out.println("m4");
	}

	@BeforeClass
	public void m1(){
		System.out.println("m1");
	}
	
	@AfterClass
	public void m5(){
		System.out.println("m5");
	}
	
}
