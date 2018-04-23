package com.guoyasoft.topic.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TestString {
	
	@Test
	public void length(){
		String str="上海果芽软件科技有限公司";
		int length=str.length();
		System.out.println("字符串长度="+length);
	}
	
	@Test
	public void contains(){
		String s1="上海果芽软件科技有限公司";
		String s2="果芽";
		String s3="责任";
		
		boolean isContain=s1.contains(s2);
		System.out.println("s1是否包含s2："+isContain);
		
		isContain=s1.contains(s3);
		System.out.println("s1是否包含s3："+isContain);
	}
	
	@Test
	public void indexOf(){
		String s1="上海果芽软件科技有限公司";
		String s2="果芽";
		int index=s1.indexOf(s2);
		System.out.println("s1中“果芽”的位置："+index);
	}
	
	@Test
	public void subString(){
		String s1="上海果芽软件科技有限公司";
		String s2=s1.substring(2);
		System.out.println("截取s1的第2个位置到末尾的字符串："+s2);
		
		String s3=s1.substring(2,6);
		System.out.println("截取s1的第2位到第6位的字符串："+s3);
		
		//解析身份证号
	}
	
	@Test
	public void equals(){
		String s1="果芽软件";
		String s2="果芽软件";
		String s3="果芽";
		boolean isEqual=s1.equals(s2);
		System.out.println("s1是否等于s2："+isEqual);
		
		isEqual=s1.equals(s3);
		System.out.println("s1是否等于s3："+isEqual);
		
	}
	
	@Test
	public void addStr(){
		String s1="上海果芽软件";
		String s2="科技有限公司";
		String s3=s1+s2;
		System.out.println("s1+s2="+s3);
		
		int a=10;
		String s4=s1+a;
		System.out.println("s1+int="+s4);
		
	}
	
	@Test
	public void isBlank(){
		String s2="";
		String s3=null;
		String s4="hello";
		
		if(s2!=null && !"".equals(s2) && !s2.equalsIgnoreCase("null")){
			System.out.println("s2不为空");
		}else{
			System.out.println("s2为空");
		}
		
		if(s3!=null && !"".equals(s3) && !s3.equalsIgnoreCase("null")){
			System.out.println("s3不为空");
		}else{
			System.out.println("s3为空");
		}
		
		if(s4!=null && !"".equals(s4) && !s4.equalsIgnoreCase("null")){
			System.out.println("s4不为空");
		}else{
			System.out.println("s4为空");
		}
		
	}
	
	@Test
	public void strToDate() throws ParseException{
		String str="2018-04-23 21:41:23";
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//字符串转时间
		Date date=sf.parse(str);
		//时间转字符串

		SimpleDateFormat sf2=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		String newStr=sf2.format(date);
		System.out.println(newStr);
		

		SimpleDateFormat sf3=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		String newStr3=sf3.format(date);
		System.out.println(newStr3);
	}
	
	
	@Test
	public void intToStr(){
		int a=20;
		String strA=a+"";
		System.out.println("a="+strA);
	}
	
	@Test
	public void strToNumber(){
		String s="10";
		int a=Integer.parseInt(s);
		System.out.println("a="+a);
		
		String s2="10.23";
		double b=Double.parseDouble(s2);
		System.out.println("b="+b);
		
		//前端界面传的金额、年龄等为字符串，后端要进行数字计算，必须转成对应类型的数字
	}
}
