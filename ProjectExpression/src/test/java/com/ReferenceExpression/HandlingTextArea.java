package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingTextArea {


    private WebDriver driver;

    @Before
    public void invokeBrowser() {
        System.setProperty("web.chrome.driver", "chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    //HANDLING TEXT AREA###############
    //RETURNING THE TEXT###############

    @Test
    public void textMethod(){

        driver.navigate().to("https://accounts.google.com/");


        String textArea = driver.findElement(By.tagName("h1")).getText();
        System.out.println(textArea);
        driver.findElement(By.id("identifierNext")).click();
        waitForSometime();
        String error_message = driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).getText();
        System.out.println(error_message);
        // CAPTURING THE SIGNIN AND ERROR MESSAGE
        //Sign in
        //Enter an email or phone number

    }

    @Test
    public void errorMessage(){

    driver.navigate().to("https://accounts.google.com/");
    driver.findElement(By.id("identifierNext")).click();
    waitForSometime();
    String error_message = driver.findElement(By.cssSelector(".dEOOab.RxsGPe")).getText();
    System.out.println(error_message);
    //Enter an email or phone number


    }







    public void waitForSometime() {


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }




    @After
    public void tearDown()
    {

        driver.close();
        //driver.quit(); WHEN YOU ARE USING MULTIPLE BROWSERS NEED TO USE THIS COMMANDS

    }




}
