package com.guoyasoft.tools.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApacheHttp {
	/*
	 * 请求步骤 使用帮助类HttpClients创建CloseableHttpClient对象.
	 * 基于要发送的HTTP请求类型创建HttpGet或者HttpPost实例. 使用addHeader方法添加请求头部,诸如User-Agent,
	 * Accept-Encoding等参数. 可调用HttpGet、HttpPost共同的setParams(HetpParams
	 * params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity
	 * entity)方法来设置请求参数。 通过执行此HttpGet或者HttpPost请求获取CloseableHttpResponse实例
	 * 从此CloseableHttpResponse实例中获取状态码,错误信息,以及响应页面等等. 释放连接。无论执行方法是否成功，都必须释放连接
	 * 
	 * 作者：AnakinSky 链接：https://www.jianshu.com/p/99c627c6aa9b 來源：简书
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	public static String httpPost2(ApacheHttpBean params) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		try {
			//String url = "http://47.98.226.232:8080/guoya-medium/user/login.action";
			HttpPost httpPost = new HttpPost(params.getUrl());

//			RequestConfig requestConfig = RequestConfig.custom()
//					.setSocketTimeout(6000).setConnectTimeout(6000).build();// 设置请求和传输超时时间
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(params.getTimeout()).setConnectTimeout(params.getTimeout()).build();// 设置请求和传输超时时间
			httpPost.setConfig(requestConfig);
			
			Iterator iterator=params.getHeaders().entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry = (Map.Entry) iterator.next();
				httpPost.addHeader(entry.getKey().toString(), entry.getValue().toString());
			}

			

			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			iterator=params.getParams().entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry entry = (Map.Entry) iterator.next();
				paramList.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
			
			
//			paramList.add(new BasicNameValuePair("userName", "guoya"));
//			paramList.add(new BasicNameValuePair("password",
//					"46da9da65fae31c690e7c391f37b085a"));
//			paramList.add(new BasicNameValuePair("checkCode", "12345"));

			try {
				//httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
				httpPost.setEntity(new UrlEncodedFormEntity(paramList, params.getEncode()));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			httpResponse = httpClient.execute(httpPost);

//			reader = new BufferedReader(new InputStreamReader(httpResponse
//					.getEntity().getContent(), "UTF-8"));
			reader = new BufferedReader(new InputStreamReader(httpResponse
					.getEntity().getContent(), params.getEncode()));

			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

		} catch (Exception var) {
			var.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (httpResponse != null) {
				httpResponse.close();
			}
			httpClient.close();
		}
		System.out.println(response.toString());
//		boolean isSuccess = response.toString().contains("班级类型");
//		Assert.assertEquals(true, isSuccess);
		 return response.toString();

	}
	public static void httpPost() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		try {
			String url = "http://47.98.226.232:8080/guoya-medium/user/login.action";
			HttpPost httpPost = new HttpPost(url);

			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(6000).setConnectTimeout(6000).build();// 设置请求和传输超时时间
			httpPost.setConfig(requestConfig);

			httpPost.addHeader("Host", "47.98.226.232:8080");
			httpPost.addHeader("Connection", "keep-alive");

			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			paramList.add(new BasicNameValuePair("userName", "guoya"));
			paramList.add(new BasicNameValuePair("password",
					"46da9da65fae31c690e7c391f37b085a"));
			paramList.add(new BasicNameValuePair("checkCode", "12345"));

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			httpResponse = httpClient.execute(httpPost);

			reader = new BufferedReader(new InputStreamReader(httpResponse
					.getEntity().getContent(), "UTF-8"));

			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

		} catch (Exception var) {
			var.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (httpResponse != null) {
				httpResponse.close();
			}
			httpClient.close();
		}
		System.out.println(response.toString());
		boolean isSuccess = response.toString().contains("班级类型");
		Assert.assertEquals(true, isSuccess);
		// return response.toString();

	}

	@Test
	public static void httpsPost() throws Exception {
		

		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		BufferedReader reader = null;
		StringBuffer response = new StringBuffer();
		try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            	@Override
            	public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
            httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			String url = "http://47.98.226.232:8080/guoya-medium/user/login.action";
			HttpPost httpPost = new HttpPost(url);

			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(6000).setConnectTimeout(6000).build();// 设置请求和传输超时时间
			httpPost.setConfig(requestConfig);

			httpPost.addHeader("Host", "47.98.226.232:8080");
			httpPost.addHeader("Connection", "keep-alive");

			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			paramList.add(new BasicNameValuePair("userName", "guoya"));
			paramList.add(new BasicNameValuePair("password",
					"46da9da65fae31c690e7c391f37b085a"));
			paramList.add(new BasicNameValuePair("checkCode", "12345"));

			try {
				httpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			httpResponse = httpClient.execute(httpPost);

			reader = new BufferedReader(new InputStreamReader(httpResponse
					.getEntity().getContent(), "UTF-8"));

			String inputLine;

			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}

		} catch (Exception var) {
			var.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (httpResponse != null) {
				httpResponse.close();
			}
			httpClient.close();
		}
		System.out.println(response.toString());
		boolean isSuccess = response.toString().contains("班级类型");
		Assert.assertEquals(true, isSuccess);
		// return response.toString();
		
	}

	public void httpGet() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet("http://www.baidu.com/");
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: "
							+ entity.getContentLength());
					// 打印响应内容
					System.out.println("Response content: "
							+ EntityUtils.toString(entity));
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
