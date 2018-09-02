package com.guoyasoft.autoAPI.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestHttp {
	public static void main(String[] args) throws Exception {
        //请求的webservice的url
        URL url = new URL("http://47.98.226.232:8080/guoya-client/user/login.action");
        //创建http链接
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    
        //设置请求的方法类型
        httpURLConnection.setRequestMethod("POST");
        
        //设置请求的内容类型
        httpURLConnection.setRequestProperty("Origin", "http://47.98.226.232:8080");

        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        //设置发送数据
        httpURLConnection.setDoOutput(true);
        //设置接受数据
        httpURLConnection.setDoInput(true);
        
        //发送数据,使用输出流
        OutputStream outputStream = httpURLConnection.getOutputStream();
        //发送的soap协议的数据
      //  String requestXmlString = requestXml("北京");
    
        String content = "userName=guoya&password=3c43974fcff75d39d5aab8a2521f9c65&submit=%E7%99%BB%E5%BD%95";
        
        //发送数据
        outputStream.write(content.getBytes());

        // flush输出流的缓冲
        outputStream.flush();
    
        //接收数据
        InputStream inputStream = httpURLConnection.getInputStream();
    
        //定义字节数组
        byte[] b = new byte[1024];
        
        //定义一个输出流存储接收到的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        //开始接收数据
        int len = 0;
        while (true) {
            len = inputStream.read(b);
            if (len == -1) {
                //数据读完
                break;
            }
            byteArrayOutputStream.write(b, 0, len);
        }
        
        //从输出流中获取读取到数据(服务端返回的)
        String response = byteArrayOutputStream.toString();
        
        System.out.println(response);
        
    }
}
