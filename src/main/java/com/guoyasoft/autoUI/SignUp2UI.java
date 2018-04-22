package com.guoyasoft.autoUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SignUp2UI {
	public static void main(String[] args) {
		//此处src前面没有"/"，说明是相对工程根目录的路径
        System.setProperty("webdriver.chrome.driver",
        "src/main/resources/selenium/driver/chromedriver.exe");
        
        //设置浏览器的参数
        ChromeOptions options = new ChromeOptions();
        //最大化浏览器
        options.addArguments("--test-type", "--start-maximized");
        //指定浏览器位置
        //options.setBinary("C:/XXXXXXX/chrome.exe");
        
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("http://127.0.0.1:8083/guoya/jsp/user/signUp2.jsp");
        
        //为了测试看效果
        sleep(3000);
        
        //关闭浏览器，driver.close()是关闭当前窗口
        driver.quit();
        
	}
	
	 public static void sleep(int millis) {
	        try {
	            Thread.sleep(millis);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
