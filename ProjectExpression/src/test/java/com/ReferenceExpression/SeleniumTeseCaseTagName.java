package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTeseCaseTagName {

    private WebDriver driver;


    @Before
    public void invokeBrowser() {


        System.setProperty("web.chrome.driver", "chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }



    @Test

    public void tagName(){

       driver.navigate().to("https://accounts.google.com/");
       driver.findElement(By.tagName("input")).sendKeys("ham427115@gmail.com");



    }














    @After
    public void tearDown(){


        driver.quit();



    }







}
