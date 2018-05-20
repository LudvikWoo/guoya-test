package com.guoyasoft.autoUI.cases.baidu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.guoyasoft.autoUI.common.BaseUI;

public class TestBaiduHome extends BaseUI{

	@Test
	public void search() {
		try {
			// // 2. 实例化主界面
			// driver.get("https://www.jd.com");
			// JdHomePage home=FindBySvc.newPage(driver, JdHomePage.class);
			// // 3. 调用测试功能
			// home.search("iphone7");

			driver.get("http://www.baidu.com");
			BaiduHome baidu = PageFactory.initElements(driver, BaiduHome.class);
			baidu.search("果芽软件");
			//sleep(2000);
			BaiduDetail detail = PageFactory.initElements(driver, BaiduDetail.class);
			detail.clickLink();

		} catch (Exception e) {
			e.printStackTrace();
			after();
		}
		// 4. 关闭浏览器
		after();
	}
}
