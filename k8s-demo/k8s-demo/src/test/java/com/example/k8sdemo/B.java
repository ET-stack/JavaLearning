package com.example.k8sdemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @className: B
 * @description: TODO 类描述
 * @date: 2024/4/24
 **/
public class B {
    private void testB(){
        System.out.println("B");
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\Development\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.bin", "E:\\Development\\chromedriver_win32\\chrome-win64\\chrome.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("E:\\Development\\chromedriver_win32\\chrome-win64\\chrome.exe");

        // 1.创建webdriver驱动
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        // 2.打开百度首页
        driver.get("https://getwebdriver.com/");

    }
}

