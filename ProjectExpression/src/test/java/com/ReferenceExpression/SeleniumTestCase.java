package com.ReferenceExpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTestCase {

    private WebDriver driver;

    @Before
    public void invokeBrowser() throws Exception {
        //Setting Chrome browser
        System.setProperty("web.chrome.driver", "chrome.exe");
        driver = new ChromeDriver();
        //Opening the home page
        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        //Setting TimeOut
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //Test Steps:
    //1. launch the browser
    //2. navigate to gcr shop admin interface("http://www.gcrit.com/buid3/admin/")
    //3.enter "username"
    //4.enter "password"
    //5.click "login" button

    //Input data/Testdata
    //username="admin"
    //password="admin@123"

    //Verification point:
    // capture the url after login and compare with expected.

    //Expected url: http://www.gcrit.com/build3/admin/index.php

    //Actual:
    // Test Result: pass/fail


    @Test
    public void adminLogin() {


        driver.navigate().to("http:www.gcrit.com/build3/admin/");
        waitForSometime();
        driver.findElement(By.name("username")).sendKeys("admin");
        waitForSometime();
        driver.findElement(By.name("password")).sendKeys("admin@123");
        waitForSometime();
        driver.findElement(By.id("tdb1")).click();
        waitForSometime();
        String URL = driver.getCurrentUrl();
        if (URL.equals("http://www.gcrit.com/build3/admin/index.php")) {
            System.out.println("Admin Login Successful-Passed");
        } else {
            System.out.println("Admin Login Unsuccessful-Failed");
        }
    }
    @Test
    public void adminLoginAttempt(){

       driver.navigate().to("https://www.amazon.co.uk/");
       waitForSometime();
        driver.findElement(By.cssSelector("#nav-link-yourAccount")).click();
       driver.findElement(By.id("ap_email")).sendKeys("ham427115@gmail.com");
       waitForSometime();
       driver.findElement(By.id("ap_password")).sendKeys("fordfocus2005");
       waitForSometime();
       driver.findElement(By.cssSelector("#signInSubmit")).click();
       waitForSometime();
       String URL = driver.getCurrentUrl();
       if (URL.equals("https://www.amazon.co.uk/?ref_=nav_custrec_signin&")){
           System.out.println("The Login is Successful-Passed");



       }else{
           System.out.println("The Login is not Suceesful-Failed");
       }
    // 2ND SYNTAX********
//        WebElement elementName=driverObject.WebDriverCommand(By.ElementLocator("LocatorValue"));
//        elementName.WebDriverCommand();
//        WebElement username=  driver.findElement(By.id("ap_email"));
//        username.sendKeys("ham427115@gmail.com");
//

    }
    public void waitForSometime(){


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //"http://www.gcrit.com/build3/admin/index.php"
    }
    @After//closing the driver
    public void tearDown ()  {
        //close the driver
        driver.quit();

    }

}