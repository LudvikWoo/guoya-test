package com.guoyasoft.cases.baidu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.guoyasoft.autoUI.common.BaseUI;


public class BaiduHome extends BaseUI{
	public BaiduHome(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='kw']")
	public WebElement input;
	
	@FindBy(xpath="//*[@id='su']")
	public WebElement search;

	public void search(String content){
		text(input, content);
		click(search);
	}
	
}
