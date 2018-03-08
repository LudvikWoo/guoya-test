package com.guoyasoft.testng.xmlConf;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgParameters {
	private WebDriver driver;

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		sleep(1000);
	}
	
	@Test
	public void openUrl(){
		driver.get("http://www.baidu.com");
	}
	
	@Test
	public void testBaidu(){
		 WebElement input=driver.findElement(By.xpath("//input[@id='kw']"));
         input.clear();
         input.sendKeys("果芽软件");
         
         WebElement submit=driver.findElement(By.id("su"));
         submit.click();
         sleep(2000);
	}
	
	@Test(parameters="url")
	public void openUrlByParam(String url){
		driver.get(url);
	}

	@DataProvider(name="basicData")
	public  static Object[][] getData(){
		return new Object[][]{
                {"http://www.baidu.com","//input[@id='kw']","果芽软件","//input[@id='su']","上海果芽软件科技有限公司_百度百科"},
                {"http://www.baidu.com","//input[@id='kw']","果芽软件","//input[@id='su']","张学友"},
                {"http://www.jd.com", "//input[@id='key']","iphone7","//*[@id='search']/div/div[2]/button","Apple iPhone7"}
               };
	}
	
	
	
	//数据
	@Test(dataProvider="basicData2")
	public void testSearch(String url,String inputSelector,String keyword,String buttonSelector,String except){
		//操作
		driver.get(url);
        sleep(2000);
		 WebElement input=driver.findElement(By.xpath(inputSelector));
         input.clear();
         input.sendKeys(keyword);

         sleep(2000);
         WebElement submit=driver.findElement(By.xpath(buttonSelector));
         submit.click();
         sleep(2000);
         //结果判断
         boolean result=driver.getPageSource().contains(except);
         Assert.assertEquals(true, result);
	}
	
	
	@DataProvider(name="basicData2")
	public  static Object[][] getCsvData(){
		Object[][] data=CSVReader.readCSV("C:\\softwareData\\workspace\\guoya-test\\src\\main\\resources\\testNG\\searchData.csv");
		return data;
	}
	
	
	
	
	@AfterTest
	public void after() {
		sleep(3000);
		// 关闭浏览器，driver.close()是关闭当前窗口
		driver.quit();
	}
	public void sleep(int time) {
		// 先线程休眠3秒，然后才关闭
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
