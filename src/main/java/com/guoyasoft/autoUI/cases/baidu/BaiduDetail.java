package com.guoyasoft.autoUI.cases.baidu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.guoyasoft.autoUI.common.BaseUI;


public class BaiduDetail extends BaseUI {
	
	public BaiduDetail(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(partialLinkText="果芽软件")
	public WebElement link;
	
	public void clickLink(){
		click(link);
	}
}
