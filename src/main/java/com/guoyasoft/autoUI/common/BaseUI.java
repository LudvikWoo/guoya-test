package com.guoyasoft.autoUI.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseUI {
	public WebDriver driver;
	
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
	@Parameters({"url"})
	public void openUrl(String url){
		//打开URL
		driver.get(url);
		sleep(1000);
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
	
	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:c:/" + filename);
			FileUtils.copyFile(scrFile, new File("c:\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}
}
