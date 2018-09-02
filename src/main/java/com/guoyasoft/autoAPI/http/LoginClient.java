package com.guoyasoft.autoAPI.http;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class LoginClient {
	public static void main(String[] args) {
		String url="http://47.98.226.232:8080/guoya-client/user/login.action"	;
		Map<String,String> headers=new HashMap<String,String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		
		String content="userName=guoya&password=3c43974fcff75d39d5aab8a2521f9c65&submit=%E7%99%BB%E5%BD%95";
		try {
			String response=TestHttp2.sendPost(url, headers, content);
			boolean expected=response.contains("查询项目");
			Assert.assertEquals(true, expected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
