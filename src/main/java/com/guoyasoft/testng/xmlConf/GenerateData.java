package com.guoyasoft.testng.xmlConf;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {
	public  static Object[][] getData(){
		return new Object[][]{
                {"http://www.baidu.com","//input[@id='kw']","iphone8","su"},
                {"http://www.jd.com", "//input[@id='key']","iphone7","//*[@id='search']/div/div[2]/button"}
               };
	}
	public  static Object[][] getData2(){
		List list1=new ArrayList();
		list1.add("http://www.baidu.com");
		list1.add("//input[@id='kw']");
		

		List list2=new ArrayList();
		list2.add("http://www.jd.com");
		list2.add("//input[@id='key']");
		list2.add("iphone7");
		
		return new Object[][]{
                {list1,"true"},
                {list2,"false"}
               };
	}
}
