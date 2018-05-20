package com.guoyasoft.tools.http;

import java.util.HashMap;

public class ApacheHttpBean {
	private int timeout=6000;
	private String url;
	private HashMap<String,String> headers=new HashMap<String,String>();
	private HashMap<String,String> params=new HashMap<String,String>();
	private String encode="UTF-8";
	
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}
	public HashMap<String, String> getParams() {
		return params;
	}
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	
	
	
}
