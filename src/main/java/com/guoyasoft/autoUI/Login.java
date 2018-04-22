package com.guoyasoft.autoUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	@BeforeClass
	public void before(){
		//打开浏览器
		// 设置环境变量，指定chromedriver的路径
				System.setProperty("webdriver.chrome.driver",
						"src/main/resources/selenium/driver_v236_63_65/chromedriver.exe");
				// 设置浏览器的参数
				ChromeOptions options = new ChromeOptions();
				// 最大化浏览器
				options.addArguments("--test-type", "--start-maximized");
				// options.setBinary("C:/XXXXXXX/chrome.exe");
				// 打开浏览器
				driver = new ChromeDriver(options);
				sleep(1000);
	}
	
	@Test
	@Parameters({"url","userName","password","checkCode"})
	public void login(String url,String name,String pwd,String ck){
		//打开URL
//		driver.get("http://127.0.0.1:8080/guoya-medium/jsp/user/login.jsp");
		driver.get(url);
		sleep(1000);
		
		WebElement userName=driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"userName\"]"));
		userName.clear();
		userName.sendKeys(name);
		sleep(1000);

		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(pwd);
		sleep(1000);
		
		WebElement checkCode=driver.findElement(By.xpath("//input[@name='checkCode']"));
		checkCode.clear();
		checkCode.sendKeys(ck);
		sleep(1000);
		
		WebElement loginBtn=driver.findElement(By.id("loginBtn"));
		loginBtn.click();
		sleep(1000);

		
	}
	
	@Test
	public void back(){
		driver.navigate().back();
		sleep(1000);
		
	}
	
	@Test
	public void queryUser(){
//		WebElement endTime=driver.findElement(By.xpath("//input[@name='endTime']"));
//		endTime.sendKeys("2018-04-21");
		
		String js="document.getElementsByName('endTime')[0].value='2018-04-21';";
		JavascriptExecutor jsDriver=(JavascriptExecutor)driver;
		jsDriver.executeScript(js);
		
		sleep(10000);
	}
	
	@AfterClass
	public void after(){
		//关闭浏览器
		sleep(1000);
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
