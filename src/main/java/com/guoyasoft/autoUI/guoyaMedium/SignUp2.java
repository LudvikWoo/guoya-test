package com.guoyasoft.autoUI.guoyaMedium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guoyasoft.autoUI.common.BaseUI;

public class SignUp2 extends BaseUI{
	
	

	@Test
	public void navigate(){
		//打开地址
		//前进、后退、刷新
		driver.navigate().to("https://www.baidu.com");
		sleep(1000);
		driver.navigate().back();
		sleep(1000);
		driver.navigate().forward();
		sleep(1000);
		driver.navigate().refresh();
		sleep(1000);
		driver.navigate().back();
	}
	
	@Test
	public void basic(){
		//普通元素抓取、填值和操作
		WebElement userName=driver.findElement(By.id("userName"));
		clean(userName);
		sleep(1000);
		text(userName, "guoyasoft");
		sleep(1000);
		
		
		WebElement realName=driver.findElement(By.xpath("//input[@type='text' and @id='realName']"));
		realName.clear();
		sleep(1000);
		realName.sendKeys("果芽软件");
		sleep(1000);
		
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		sleep(1000);
		password.sendKeys("Aa123!");
		sleep(1000);
		

		WebElement password2=driver.findElement(By.id("password2"));
		password2.clear();
		sleep(1000);
		password2.sendKeys("Aa123!");
		sleep(1000);
	

		WebElement weixin=driver.findElement(By.id("weixin"));
		weixin.clear();
		sleep(1000);
		weixin.sendKeys("weixingongzuohao");
		sleep(1000);
		
		WebElement address=driver.findElement(By.id("address"));
		address.clear();
		sleep(1000);
		address.sendKeys("weixingongzuohao");
		sleep(1000);

		WebElement phone=driver.findElement(By.id("phone"));
		phone.clear();
		sleep(1000);
		phone.sendKeys("12312312312");
		sleep(1000);

		WebElement age=driver.findElement(By.id("age"));
		age.clear();
		sleep(1000);
		age.sendKeys("21");
		sleep(1000);
		
		WebElement checkCode=driver.findElement(By.id("checkCode"));
		checkCode.clear();
		sleep(1000);
		checkCode.sendKeys("1234");
		sleep(1000);

	}
	
	@Test
	public void select(){
		//下拉框 抓取、填值和操作
		WebElement education=driver.findElement(By.id("education"));
		Select eduSelect=new Select(education);
		eduSelect.selectByIndex(2);
		sleep(1000);
		eduSelect.selectByValue("3");
		sleep(1000);
		eduSelect.selectByVisibleText("研究生");
		

		WebElement classType=driver.findElement(By.id("classType"));
		Select eduClassType=new Select(classType);
		eduClassType.selectByIndex(2);
	}

	@Test(groups={"submit"})
	public void submit(){
		WebElement submitBtn=driver.findElement(By.id("submitBtn"));
		submitBtn.click();
		sleep(1000);
	}
	
	@Test
	public void reset(){
		WebElement resetBtn=driver.findElement(By.xpath("//input[@type='reset' and @value='重置']"));
		resetBtn.click();
		sleep(1000);
	}
	
	@Test
	public void date(){
		//时间 抓取、填值和操作
	}
	
	@Test
	public void radio(){
		//单选框  抓取、填值和操作
	}
	
	@Test
	public void checkBox(){
		//多选框  抓取、填值和操作
	}
	
	@Test
	public void link(){
		//超链接  抓取、填值和操作
	}
	
	@Test
	public void alert(){
		//弹出窗口切换
	}
	
	@Test
	public void frame(){
		//frame窗口切换
	}
	
	@Test
	public void window(){
		//标签页窗口切换
	}
	
	@Test
	public void waitTime(){
		//隐式等待和显示等待
	}
	
	@Test
	public void exception(){
		//断言
	}
	
	@Test
	public void parameter(){
		//参数化
	}
	
	@Test
	public void dataProvider(){
		//批量数据
	}
	
	@Test
	public void stress(){
		//多线程、循环次数
	}
	
}
