package com.crm.qa.testcases;

import org.testng.annotations.Test;

public class TestClass {
	
	@Test(priority=1)
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(priority=-2)
	public void test2() {
		System.out.println("test2");
	}
	
	@Test(priority=-2)
	public void test8() {
		System.out.println("test8");
	}
	
	@Test(priority=-1)
	public void test9() {
		System.out.println("test9");
	}
	
	
	@Test(priority=2)
	public void test3() {
		System.out.println("test3");
	}
	
	@Test(priority=0)
	public void test4() {
		System.out.println("test4");
	}
	
	@Test(priority=0)
	public void atest7() {
		System.out.println("test7");
	}
	
	@Test
	public void test5() {
		System.out.println("test5");
	}
	
	

}
