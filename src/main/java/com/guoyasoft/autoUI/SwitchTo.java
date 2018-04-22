package com.guoyasoft.autoUI;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SwitchTo extends BaseUI{

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
}
