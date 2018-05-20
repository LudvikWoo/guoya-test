package com.guoyasoft.tools.http;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestHttp {
	@Test
	public void testHttp() throws Exception{
		ApacheHttpBean bean=new ApacheHttpBean();
		bean.setUrl("http://47.98.226.232:8080/guoya-medium/user/login.action");
		
		bean.getHeaders().put("Host", "47.98.226.232:8080");
		bean.getHeaders().put("Connection", "keep-alive");
		
		bean.getParams().put("userName", "guoya");
		bean.getParams().put("password", "46da9da65fae31c690e7c391f37b085a");
		bean.getParams().put("checkCode", "12345");
		
		String response=ApacheHttp.httpPost2(bean);
		System.out.println(response);
		boolean isSuccess=response.contains("真实姓名");
		Assert.assertEquals(true, isSuccess);
	}
	
	@Test(dataProvider="loginUser",dataProviderClass=com.guoyasoft.tools.http.ApacheHttpDataProvider.class)
	public void testHttpCsv(ITestContext context, String userName,String password,String checkCode,String exception) throws Exception{
		ApacheHttpBean bean=new ApacheHttpBean();
		String url=context.getCurrentXmlTest().getParameter("url");
		bean.setUrl(url);
//		bean.setUrl("http://47.98.226.232:8080/guoya-medium/user/login.action");
		
//		bean.getHeaders().put("Host", "47.98.226.232:8080");
//		bean.getHeaders().put("Connection", "keep-alive");
		
		bean.getParams().put("userName", userName);
		bean.getParams().put("password", password);
		bean.getParams().put("checkCode", checkCode);
		
		String response=ApacheHttp.httpPost2(bean);
		System.out.println(response);
		boolean isSuccess=response.contains(exception);
		Assert.assertEquals(true, isSuccess);
	}
	
	
	
}
