package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PopupWindow {

    private WebDriver driver;

    @Before
    public void invokeBrowser(){

        System.setProperty("web.chrome.driver","chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);






    }
    @Test
    public void popUp(){

        driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
        waitForSometime();
        driver.findElement(By.name("proceed")).click();
        waitForSometime();

        //PREDIFINED METHOD##############
        Alert popUp = driver.switchTo().alert(); //switch the driver focus from the web page to popup/Alert message
        String errorMessage2 = popUp.getText();

        // popUp error message if you want to choose  OK select "accept();"  method, if you want to chooose CANCEL
        // select "dismiss():" method.

        popUp.accept();

        waitForSometime();
        driver.findElement(By.id("login1")).sendKeys("ham427115@gmail.com");
        waitForSometime();
        System.out.println(errorMessage2);
        //Please enter a valid user name



    }

    @After
    public void tearDown(){


        driver.quit();


    }

    public void waitForSometime() {


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
