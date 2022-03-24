package com.feeclouds.login;

import com.feeclouds.pojo.UserLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Set;

public class TestLogin {
    @DataProvider(name = "login")
    public Object[][] loginInfo(){
        UserLogin userLogin = new UserLogin("http://8.141.174.255:8084/login", "12345wlmq@qq.com", "1234Qwer");
        return new Object[][]{{userLogin}};
    }

    @Test(dataProvider = "login")
    public void login(UserLogin userLogin) throws InterruptedException {
       WebDriver webDriver = new ChromeDriver();
        String url = userLogin.getUrl();
        String username = userLogin.getUsername();
        String password = userLogin.getPassword();
//       登录系统
       webDriver.get(url);
       webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
       webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
       webDriver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
       Thread.sleep(1);
//       获取Cookie
        Set<Cookie> cookieSet = webDriver.manage().getCookies();
        System.out.println(cookieSet);
//        for (Cookie cookie: cookieSet) {
//
//        }
//       return cookieSet;
    }
}
