package com.guoyasoft.autoUI.guoyaMedium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guoyasoft.autoUI.common.BaseUI;
import com.guoyasoft.topic.csv.CSVReader;

public class Login extends BaseUI{
	
	
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
	
	@Test(dataProvider="loginData1")
	public void loginBatch1(String name,String pwd,String chk){
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
		checkCode.sendKeys(chk);
		sleep(1000);
		
		WebElement loginBtn=driver.findElement(By.id("loginBtn"));
		loginBtn.click();
		sleep(1000);
		
		
	}
	
	@Test(dataProvider="loginData2")
	public void loginBatch2(String name,String pwd,String chk,String expection){
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
		checkCode.sendKeys(chk);
		sleep(1000);
		
		WebElement loginBtn=driver.findElement(By.id("loginBtn"));
		loginBtn.click();
		sleep(1000);
		
		boolean result=driver.getPageSource().contains(expection);
		Assert.assertEquals(result, true);
		
	}
	
	@DataProvider(name="loginData1")
	public Object[][] loginData(){
		Object[][] obj=new Object[2][3];
		obj[0][0]="wuling";
		obj[0][1]="0000";
		obj[0][2]="12345";
		

		obj[1][0]="guoya";
		obj[1][1]="1111";
		obj[1][2]="12345";
		
		return obj;
	}
	
	@DataProvider(name="loginData2")
	public Object[][] loginData2(){
		Object[][] obj=CSVReader.readCSV("src/main/resources/csvData/loginData.csv");
		return obj;
	}
}
