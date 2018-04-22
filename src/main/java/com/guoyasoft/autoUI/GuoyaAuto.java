package com.guoyasoft.autoUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.guoyasoft.tools.CSVReader;

public class GuoyaAuto {

	private static WebDriver driver;

	@BeforeClass
	@Parameters({ "loginUrl" })
	public static void before(String url) {
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
		// WebDriver driver = new ChromeDriver();
		sleep(1000);
		// driver.get("http://127.0.0.1:8083/guoya/jsp/user/signUp2.jsp");
		driver.get(url);
		sleep(1000);
	}

	public static void navigate() {
		driver.navigate().to("http://www.baidu.com");
		sleep(1000);

		driver.navigate().back();
		sleep(1000);

		driver.navigate().forward();
		sleep(1000);

		driver.navigate().refresh();
		sleep(1000);

		driver.navigate().back();
		sleep(1000);
	}

	public static void signUp2() {
		WebElement userName = driver.findElement(By.id("userName"));
		sleep(1000);
		userName.clear();
		sleep(1000);
		userName.sendKeys("wuling");
		sleep(1000);

		WebElement realName = driver.findElement(By.id("realName"));
		realName.sendKeys("吴令");
		sleep(1000);

		// 提交
		WebElement submitBtn = driver.findElement(By.id("submitBtn"));
		submitBtn.click();
		sleep(1000);

		// WebElement
		// reset=driver.findElement(By.xpath("//input[@type=\"reset\"]"));
		// reset.click();
		// sleep(1000);

	}

	@Test(dataProvider="loginData")
	public static void login(String name, String pwd) {
		WebElement userName = driver.findElement(By
				.xpath("//input[@name=\"userName\"]"));
		userName.clear();
		userName.sendKeys(name);
		sleep(1000);

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(pwd);
		sleep(1000);

		WebElement loginBtn = driver.findElement(By.id("loginBtn"));
		loginBtn.click();
		sleep(1000);

		driver.navigate().back();
		sleep(1000);
	}

	public static void queryUser() {

		WebElement education = driver.findElement(By.name("education"));
		Select eduSelect = new Select(education);
		eduSelect.selectByValue("2");
		sleep(1000);

		WebElement classType = driver.findElement(By.name("classType"));
		Select clsSelect = new Select(classType);
		clsSelect.selectByIndex(2);
		sleep(1000);

		// startTime.clear();
		String js = "document.getElementsByName('startTime')[0].setAttribute('value','2012-10-25');";
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript(js);
		sleep(3000);

		WebElement searchBtn = driver.findElement(By
				.xpath("//input[@type=\"submit\" and @value=\"查询\"]"));
		searchBtn.click();
		sleep(1000);

	}

	public static void main(String[] args) {
		// before();
		// navigate();
		// signUp2();
		// login();
		// queryUser();
		// after();
	}

	@AfterClass
	public static void after() {
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
	
	@DataProvider(name="loginData2")
	public Object[][] getLoginData2(){
		Object[][] result=new Object[3][2];
		result[0][0]="wuling";
		result[0][1]="0000";
		
		result[1][0]="wuhao";
		result[1][1]="123456";
		
		result[2][0]="guoya";
		result[2][1]="123456";
		
		return result;
		
	}
	
	@DataProvider(name="loginData")
	public Object[][] getLoginData(){
		Object[][] result=CSVReader.readCSV("c:/loginData.csv");
		
		return result;
		
	}
}
