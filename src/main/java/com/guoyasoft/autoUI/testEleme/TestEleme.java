package com.guoyasoft.autoUI.testEleme;

import com.guoyasoft.autoUI.common.BaseUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestEleme extends BaseUI {

    @Test
    public void onclick() {
        driver.get("http://element-cn.eleme.io");
        sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'组件')]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'单选框')]")).click();
        sleep(1000);
        driver.findElement(By.xpath("(//h3[contains(text(),'基础用法')]/following-sibling::div[1]//label[@role='radio'])[2]")).click();
        sleep(1000);
    }
}
