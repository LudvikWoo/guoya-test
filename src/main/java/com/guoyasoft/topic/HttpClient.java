package com.guoyasoft.topic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpClient {
	public static String post(int timeOut, String urlLink, String xml,
			String encode) throws Exception {
		HttpURLConnection httpurlconnection = null;
		try {
			URL url = null;
			url = new URL(urlLink);
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestProperty("Content-type", "text/xml");
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setConnectTimeout(timeOut);
			httpurlconnection.setReadTimeout(timeOut);
			httpurlconnection.connect();
		} catch (Exception e) {
			throw e;
		}
		try {
			String SendData = xml;
			httpurlconnection.getOutputStream()
					.write(SendData.getBytes(encode));
			httpurlconnection.getOutputStream().flush();
			httpurlconnection.getOutputStream().close();
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		}
		try {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream(), encode));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
			return result;
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
		}
	}

	public static String get(int timeOut, String urlLink, String encode)
			throws Exception {
		HttpURLConnection httpurlconnection = null;
		try {
			URL url = null;
			url = new URL(urlLink);
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setRequestProperty("Content-type", "text/xml");
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setConnectTimeout(timeOut);
			httpurlconnection.setReadTimeout(timeOut);
			httpurlconnection.connect();
		} catch (Exception e) {
			throw e;
		}
		try {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpurlconnection.getInputStream(), encode));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			in.close();
			return result;
		} catch (Exception e) {
			e.getStackTrace();
			throw e;
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
		}
	}

	public static void main(String[] args) {
		try {
			// get请求
			String url = "http://www.kuaidi100.com/query?type=shentong&postid=3350862539854";
			String content = "";
			System.out.println("GET请求报文："+url);
			String response = HttpClient.get(3000, url, "UTF-8");
			System.out.println("GET响应报文：" + response);
			
			url="http://www.kuaidi100.com/query?type=shentong&postid=3350862539854";
			content="";
			response=HttpClient.post(3000, url, content, "UTF-8");
			System.out.println("POST响应报文："+response);

			JsonParser jsonParser = new JsonParser();
			JsonObject obj = (JsonObject) jsonParser.parse(response);
			String status = obj.get("status").getAsString();

			System.out.println("status=" + status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
