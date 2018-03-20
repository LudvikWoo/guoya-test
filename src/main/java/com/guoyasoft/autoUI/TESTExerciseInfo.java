package com.guoyasoft.autoUI;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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

import com.guoyasoft.testng.xmlConf.GenerateData;

public class TESTExerciseInfo {
	private WebDriver driver;

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		sleep(1000);
	}

	@Test(parameters = "pro_guoya_client")
	public void openUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		//不加这句话，界面刷新时间太慢，会找不到
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		sleep(1000);
	}

	@Test
	public void exerciseInfo() {
		// 第一步：定位frame框
		WebElement leftFrame = driver.findElement(By
				.xpath("//frame[@src=\"basicClass/frame/left.html\"]"));
		driver.switchTo().frame(leftFrame);

		// 第二步：定位“作业检查”菜单，并点击菜单
		WebElement exercise = driver.findElement(By.partialLinkText("作业检查"));
		exercise.click();

		// 第三步：回到主窗口
		driver.switchTo().defaultContent();

		// 第四步：定位并切换到内容窗口
		WebElement rightFrame = driver.findElement(By
				.xpath("//frame[@name=\"right\"]"));
		driver.switchTo().frame(rightFrame);

		// 第五步：获取学生状态图片，循环点击测试
		List<WebElement> statusImgs = driver.findElements(By
				.className("statusImg"));
		for (WebElement item : statusImgs) {
			String orgSrc = item.getAttribute("src");
			item.click();
			String newSrc = item.getAttribute("src");
			if(orgSrc.equals(newSrc)){
				System.out.println("状态点击失败！");
			}else{
				System.out.println("状态点击成功!");
			}		
			sleep(500);
		}
		
		//第六步：点击重新开始按钮
		WebElement restartBtn = driver.findElement(By
				.xpath("//input[@type=\"button\" and @value=\"重新开始\"]"));
		restartBtn.click();
		//切换到确认框，点击确认
		Alert prompt = driver.switchTo().alert();
		sleep(1000);
		prompt.accept();
		for (WebElement item : statusImgs) {
			String src = item.getAttribute("src");
			if(src.contains("tick.jpg")){
				System.out.println("重置失败！");
			}else{
				System.out.println("重置成功!");
			}		
			sleep(500);
		}
		
		sleep(1000);
	}

	public String switchToWindow(String windowTitle, WebDriver dr) {
		// 将页面上所有的windowshandle放在入set集合当中
		String currentHandle = dr.getWindowHandle();
		Set<String> handles = dr.getWindowHandles();
		for (String s : handles) {
			sleep(2000);
			dr.switchTo().window(s);
			// 判断title是否和handles当前的窗口相同
			if (dr.getTitle().contains(windowTitle)) {
				break;// 如果找到当前窗口就停止查找
			}
		}
		return currentHandle;
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

	@AfterTest
	public void after() {
		sleep(3000);
		// 关闭浏览器，driver.close()是关闭当前窗口
		driver.quit();
	}
}
