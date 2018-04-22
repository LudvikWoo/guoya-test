package com.guoyasoft.autoUI;

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
	}
}
