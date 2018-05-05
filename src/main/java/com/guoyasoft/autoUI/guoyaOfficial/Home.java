package com.guoyasoft.autoUI.guoyaOfficial;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.guoyasoft.autoUI.common.BaseUI;

public class Home extends BaseUI{
	
	@Test
	public void link(){
		driver.switchTo().frame("left");
		WebElement studentInfo=driver.findElement(By.xpath("//a[@href='../studentInfo.html']"));
		studentInfo.click();
		sleep(2000);
		
		WebElement navigateInfo=driver.findElement(By.linkText("资料汇总"));
		navigateInfo.click();
		sleep(2000);
		
		WebElement summarizeInfo=driver.findElement(By.partialLinkText("总结"));
		summarizeInfo.click();
		sleep(2000);
		
	}
	
	@Test
	public void action(){
		driver.switchTo().frame("left");
		WebElement navigateInfo=driver.findElement(By.linkText("资料汇总"));
		
		navigateInfo.click();
		sleep(2000);
		
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(navigateInfo).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(2000);
		
		actions.keyDown(Keys.SHIFT).click(navigateInfo).keyUp(Keys.SHIFT).perform();
		sleep(2000);
		
	}
	
	@Test
	public void frame(){
		driver.switchTo().frame("left");
		sleep(1000);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("left");
		sleep(1000);
		
		WebElement exerciseinfo=driver.findElement(By.partialLinkText("作业检查"));
		exerciseinfo.click();
		sleep(1000);
		
		//先从左侧frame框出来，回到主界面
		driver.switchTo().defaultContent();
		sleep(1000);
		
		//再进入右侧frame框
		driver.switchTo().frame("right");
		sleep(1000);
		
		WebElement restart= driver.findElement(By.xpath("//input[@type='button' and @value='重新开始']"));
		restart.click();
		sleep(1000);
	}
	
	@Test
	public void windows(){
		driver.switchTo().frame("left");
		sleep(1000);

		Actions actions=new Actions(driver);

		WebElement studentInfo=driver.findElement(By.xpath("//a[@href='../studentInfo.html']"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(studentInfo).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(2000);
		
		WebElement navigateInfo=driver.findElement(By.linkText("资料汇总"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(navigateInfo).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(2000);
		
		WebElement summarizeInfo=driver.findElement(By.partialLinkText("总结"));
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(summarizeInfo).keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		sleep(2000);
		
		String current=driver.getWindowHandle();
		System.out.println("当前界面的句柄："+current);
		
		Set<String> wins=driver.getWindowHandles();
		//foreach的方式进行遍历
		for(String s:wins){
			System.out.println("handle="+s);
			driver.switchTo().window(s);
			String title=driver.getTitle();
			System.out.println("title="+title);
			
			String url=driver.getCurrentUrl();
			System.out.println("url="+url);
			
			String source=driver.getPageSource();
			System.out.println("界面源代码="+source);
			
			sleep(2000);
			
			if(title.contains("学生信息")){
				break;
			}
			if(url.contains("studentInfo.html")){
				break;
			}
			if(source.contains("学生信息系统")){
				break;
			}
		}
		driver.switchTo().window(current);
	}
	
	@Test
	public void alert(){
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame("left");
		sleep(1000);
		
		WebElement exerciseinfo=driver.findElement(By.partialLinkText("作业检查"));
		exerciseinfo.click();
		sleep(1000);
		
		//先从左侧frame框出来，回到主界面
		driver.switchTo().defaultContent();
		sleep(1000);
		
		//再进入右侧frame框
		driver.switchTo().frame("right");
		sleep(1000);
		
		WebElement restart= driver.findElement(By.xpath("//input[@type='button' and @value='重新开始']"));
		restart.click();
		sleep(1000);
		
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		sleep(1000);
		
		restart.click();
		sleep(1000);
		alert=driver.switchTo().alert();
		alert.accept();
		sleep(1000);
	}
	
	@Test
	public void waitTime(){
		
	}
}
