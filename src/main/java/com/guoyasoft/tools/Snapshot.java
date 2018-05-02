package com.guoyasoft.tools;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapshot {

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

	public static void main(String[] args) throws InterruptedException {

		String URL = "http://www.baidu.com";
		System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/driver_v236_63_65/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		// max size the browser
		driver.manage().window().maximize();
		/*
		 * Navigation navigation = driver.navigate(); navigation.to(URL);
		 */
		Thread.sleep(2000);
		snapshot((TakesScreenshot) driver, "01_open_baidu.png");
		// WebElement reg=driver.findElement(By.name("tj_reg"));
		// reg.click();
		// WebElement keyWord = driver.findElement(By.id("kw1"));

		// find the element
		WebElement keyWord = driver.findElement(By.xpath("//input[@id='kw']"));
		keyWord.clear();
		// send key words
		keyWord.sendKeys("果芽软件");
		Thread.sleep(2000);
		snapshot((TakesScreenshot) driver, "02_input_keyWord.png");

		WebElement submit = driver.findElement(By.id("su"));

		System.out.println(submit.getLocation());
		submit.click();
		// System.out.println(driver.getWindowHandle());
		Thread.sleep(2000);

		// System.out.println(driver.getPageSource());

//		String pageSource = driver.getPageSource();
		// System.out.println(pageSource);
		// WebElement link =driver.findElement(By.xpath(SELENIUM_LINK));
		WebElement link = driver.findElement(By.partialLinkText("百度百科")); // *[@id="1"]/h3/a
		link.click();
		Thread.sleep(2000);

		snapshot((TakesScreenshot) driver, "03_search_result.png");
		
		driver.switchTo().window(
				driver.getWindowHandles().toArray(new String[0])[1]);

		// get page title
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		// navigation.back();
		snapshot((TakesScreenshot) driver, "04_search_result_detail.png");
		System.out.println(driver.getTitle() + "\n" + driver.getCurrentUrl());

		driver.quit();

	}

}
