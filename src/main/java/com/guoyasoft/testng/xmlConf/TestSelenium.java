package com.guoyasoft.testng.xmlConf;

import java.util.List;
import java.util.Set;

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

public class TestSelenium {
	private WebDriver driver;

	@BeforeTest
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/selenium/driver/chromedriver.exe");
		driver = new ChromeDriver();
		sleep(1000);
	}
	
	@Test
	public void openUrl(String url){
		driver.get(url);
	}
	

	public  String switchToWindow(String windowTitle, WebDriver dr) {
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
	
	@Test()
	private void testWindow() {
        /*
         * 第1步：打开测试界面
         */
        Actions actions = new Actions(driver);

        /*
         * 第2步：点击京东，再切换回原界面
         */
        WebElement jd = driver.findElement(By.xpath("//a[@id='link_jd']"));
        //按顺序点，按顺序放
        actions.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).click(jd)
                .keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
        sleep(1000);

        //窗口切换到京东，进行操作，此处不做任何操作
        String currentHandle=switchToWindow("京东", driver);
        sleep(1000);

        //切换回原窗口
        switchToWindow("selenium", driver);
        sleep(1000);

        /*
         * 第3步：点击百度，再切换回原界面
         */
        WebElement baidu = driver
                .findElement(By.xpath("//a[@id='link_baidu']"));
        actions.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).click(baidu)
                .keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
        actions.click();
        sleep(1000);

        switchToWindow("百度一下，你就知道", driver);
        sleep(1000);

        switchToWindow("selenium", driver);
        sleep(1000);
        /*
         * 第4步：点击当当，再切换回原界面
         */
        WebElement dangdang = driver.findElement(By
                .xpath("//a[@id='link_dangdang']"));
        actions.keyDown(Keys.SHIFT).keyDown(Keys.CONTROL).click(dangdang)
                .keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
        actions.click();
        sleep(1000);
        switchToWindow("当当", driver);
        sleep(1000);

        switchToWindow("selenium", driver);
        sleep(1000);

    }
	
	@Test
	public void test2() {

		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/selenium/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// 1. 先打开一个界面
		driver.navigate().to(
				"http://127.0.0.1:8083/guoya/selenium/NewFile.html");
		sleep(2000);
		// 2. to()方法再打开另一个界面
		driver.navigate().to("https://www.baidu.com");
		sleep(2000);
		// 3. back()回退
		driver.navigate().back();
		sleep(2000);
		// 4. forward()前进
		driver.navigate().forward();
		sleep(2000);
		// 5. refresh()刷新
		driver.navigate().refresh();
		// 先线程休眠3秒，然后才关闭
		sleep(1000);

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

	@Test
	public void input() {
		System.out.println(driver.getWindowHandle());
		WebElement input = driver.findElement(By
				.xpath("//input[@type='file' and @name='attach']"));
		input.clear();
		input.sendKeys("C:/Program Files (x86)/Kingsoft DataRecovery Master/ksodr.exe");
	}
	@Test
	public void button() {
		WebElement button = driver.findElement(By
				.xpath("//input[@type='button' and @id='alertButtonId']"));
		button.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test(parameters="urlBaidu")
	public void testBaidu(String url){
		driver.get(url);
		 WebElement input=driver.findElement(By.xpath("//input[@id='kw']"));
         input.clear();
         input.sendKeys("果芽软件");
         
         WebElement submit=driver.findElement(By.id("su"));
         submit.click();
         sleep(2000);
         
         //定位超链接元素的专用方法（精确和模糊两种，类似id和name选择器）
         WebElement baike=driver.findElement(By.linkText("上海果芽软件科技有限公司_百度百科"));
         //WebElement baike=driver.findElement(By.partialLinkText("果芽软件"));

         baike.click();
         sleep(2000);
	}
	
	@Test(dataProvider="data")
	public void testBaidu2(String url,String selector1,String keyword,String selector2){
		driver.get(url);
        sleep(2000);
		 WebElement input=driver.findElement(By.xpath(selector1));
         input.clear();
         input.sendKeys(keyword);

         sleep(2000);
         WebElement submit=driver.findElement(By.xpath(selector2));
         submit.click();
         sleep(2000);
	}
	
	@Test(dataProvider="data2")
	public void testData(List list,String result){
		
	}
	
	@DataProvider(name="data")
	public Object[][] getParameters(){
		
		 return GenerateData.getData();
	}
	
	@DataProvider(name="data2")
	public Object[][] getParameters2(){
		
		 return GenerateData.getData2();
	}
	
	@AfterTest
	public void after() {
		sleep(3000);
		// 关闭浏览器，driver.close()是关闭当前窗口
		driver.quit();
	}
	
	
}
