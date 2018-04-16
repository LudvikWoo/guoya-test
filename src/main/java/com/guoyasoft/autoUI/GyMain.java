package com.guoyasoft.autoUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GyMain {
	private static WebDriver driver;

	public static void main(String[] args) {
		before();
		sleep(1000);
		// studentinfo();
		//action();
		switchWindow();

		after();

	}

	public static void before() {
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
	}
	
	public static void action(){
		
		WebDriver driver=new ChromeDriver();
		
		String js="document.getElementsByName('startTime')[0].setAttribute('value','2012-10-25');";
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		jsDriver.executeScript(js);
		
		
		List list=new ArrayList();//先计划，再实现
		
		Set set=new HashSet();
		
		driver.navigate().to("http://www.guoyasoft.com:15021/guoya-client/");
		sleep(1000);
		
		driver.switchTo().frame("left");
		Actions actions=new Actions(driver);
		sleep(1000);
		
		WebElement xuesheng=driver.findElement(By.xpath("//a[@href=\"../studentInfo.html\"]"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(xuesheng).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(1000);
		
		WebElement renwu=driver.findElement(By.xpath("//a[@href=\"../taskInfo.html\"]"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(renwu).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(1000);
		
	}

	public static void switchWindow() {
		driver.get("http://www.guoyasoft.com:15021/guoya-client/");
		sleep(1000);

		driver.switchTo().frame("left");
		WebElement student = driver.findElement(By
				.xpath("//a[@href=\"../studentInfo.html\"]"));

		// 动作对象
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(student)
				.keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(1000);

		WebElement exercise = driver.findElement(By
				.xpath("//a[@href=\"../exerciseInfo.html\"]"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(exercise)
				.keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		exercise.click();
		sleep(1000);
		
		
		String dangqian=driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		for(String s:tabs){
			System.out.println(s);
			driver.switchTo().window(s);
			String title=driver.getTitle();
			String pageSource=driver.getPageSource();
			String url=driver.getCurrentUrl();
			System.out.println("url:"+url);
			System.out.println("pageSource:"+pageSource);
			System.out.println("title:"+title);
			if(title.contains("学生信息系统")){
				break;
			}
			sleep(1000);
		}
		//测试完成后，关闭窗口
		
		
		//切换回原界面
		driver.switchTo().window(dangqian);
	}

	public static void studentinfo() {
		driver.get("http://www.guoyasoft.com:15021/guoya-client/");
		sleep(1000);
		// 切换窗口到左侧导航栏，点击作业信息
		WebElement leftFrame = driver.findElement(By.id("left"));
		driver.switchTo().frame(leftFrame);
		WebElement studentInfo = driver.findElement(By
				.xpath("//a[@href=\"../studentInfo.html\"]"));
		studentInfo.click();
		sleep(1000);

		// 切换回主窗口，定位右侧frame框
		driver.switchTo().defaultContent();

		WebElement rightFrame = driver.findElement(By.id("right"));
		driver.switchTo().frame(rightFrame);
		// driver.switchTo().frame("right");

		// 测试学生信息登记页面
		WebElement userName = driver.findElement(By
				.xpath("//tbody/tr[1]/td[2]/input[@type='text']"));
		userName.clear();
		userName.sendKeys("guoya");
		sleep(1000);

		// 切回主界面
		driver.switchTo().defaultContent();
		driver.switchTo().frame("left");
		WebElement zuoye = driver.findElement(By
				.xpath("//a[@href=\"../exerciseInfo.html\"]"));
		zuoye.click();
	}

	public static void after() {
		sleep(1000);
		//先关驱动
		driver.close();
		//再关浏览器
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
