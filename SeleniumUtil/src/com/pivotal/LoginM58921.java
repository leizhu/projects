package com.pivotal;

import core.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lei on 3/4/14.
 */
public class LoginM58921 {
    WebDriver driver = null;

    public LoginM58921(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.get("http://58921.com/user/login");


        WebElement userNameElement = driver.findElement(By.id("user_login"));
        userNameElement.sendKeys("paxbeijing@gmail.com");
        WebElement passwordElement = driver.findElement(By.name("pass"));
        passwordElement.sendKeys("cetas123");

        WebElement loginElement = driver.findElement(By.id("user_login_form_type_submit"));
        loginElement.click();
    }
}

